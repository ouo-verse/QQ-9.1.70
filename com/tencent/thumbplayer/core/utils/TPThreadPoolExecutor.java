package com.tencent.thumbplayer.core.utils;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPThreadPoolExecutor {
    private static final int QUEUE_CAPACITY = 20;
    private static final String TAG = "TPCore[TPThreadPoolExecutor]";
    private static final long THREAD_KEEP_ALIVE_TIME = 60;
    private static final String THREAD_POOL_NAME = "TP-Thread";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
        CustomRejectedExecutionHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
                TPNativeLog.printLog(2, TPThreadPoolExecutor.TAG, "rejectedExecution put task to queue");
            } catch (InterruptedException e16) {
                TPNativeLog.printLog(0, TPThreadPoolExecutor.TAG, "rejectedExecution has exception:" + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger threadAtomicCount;

        CustomThreadFactory() {
            this.threadAtomicCount = new AtomicInteger(0);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable);
            baseThread.setName(TPThreadPoolExecutor.THREAD_POOL_NAME + this.threadAtomicCount.incrementAndGet());
            return baseThread;
        }
    }

    public static ExecutorService newCustomThreadExecutor(int i3, int i16) {
        return new BaseThreadPoolExecutor(i3, i16, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }
}
