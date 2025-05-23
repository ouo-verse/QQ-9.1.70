package com.heytap.databaseengine.utils;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HExecutorService {
    private static ExecutorService sExecutorService;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class HThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private static final AtomicInteger sPoolNumber = new AtomicInteger(1);
        private static final HThreadFactory sInstance = new HThreadFactory();

        HThreadFactory() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
            this.namePrefix = "p2-" + sPoolNumber.getAndIncrement() + "-t-";
        }

        public static HThreadFactory getInstance() {
            return sInstance;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            baseThread.setPriority(5);
            return baseThread;
        }
    }

    public static ExecutorService create() {
        if (sExecutorService == null) {
            sExecutorService = new BaseThreadPoolExecutor(0, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), HThreadFactory.getInstance());
        }
        return sExecutorService;
    }
}
