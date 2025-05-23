package com.tencent.tavsticker.utils;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class ThreadPoolManager {
    private static final int MAX_RUNNING_THREAD = 5;
    private static volatile ThreadPoolManager _instance;
    private ScheduledExecutorService executor;

    /* loaded from: classes26.dex */
    private static class CommonThreadFactory implements ThreadFactory {
        public final String threadNamePrefix;
        public final AtomicInteger threadNumber = new AtomicInteger(1);
        public final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public CommonThreadFactory(String str) {
            this.threadNamePrefix = str + "-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(this.group, runnable, this.threadNamePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 1) {
                baseThread.setPriority(1);
            }
            return baseThread;
        }
    }

    ThreadPoolManager() {
        this.executor = null;
        try {
            this.executor = ProxyExecutors.newScheduledThreadPool(5, new CommonThreadFactory("ThreadPool"));
        } catch (Throwable unused) {
            this.executor = ProxyExecutors.newScheduledThreadPool(5, new CommonThreadFactory("ThreadPool"));
        }
    }

    public static ThreadPoolManager get() {
        if (_instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (_instance == null) {
                    _instance = new ThreadPoolManager();
                }
            }
        }
        return _instance;
    }

    public void start(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            try {
                scheduledExecutorService.submit(runnable).get();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            } catch (ExecutionException e17) {
                e17.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void startDelayed(Runnable runnable, long j3) {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(runnable, j3, TimeUnit.MILLISECONDS);
        }
    }
}
