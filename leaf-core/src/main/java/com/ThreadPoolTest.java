package com;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        // 重点关注 corePoolSize 和 keepAliveTime，其他参数不重要
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 5,
                30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(15));
        for (int i = 0; i < 20; i++) {
            //executor.execute(() -> {
			//   // 简单地打印当前线程名称
            //    System.out.println(Thread.currentThread().getName());
            //});
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
        }
        System.out.println("main finished");
    }
}
