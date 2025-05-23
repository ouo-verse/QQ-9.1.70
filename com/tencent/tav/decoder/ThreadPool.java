package com.tencent.tav.decoder;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* loaded from: classes26.dex */
public class ThreadPool {
    private static ExecutorService threadPool = ProxyExecutors.newFixedThreadPool(3);
    private static ExecutorService singleThreadPool = null;
    private static Object singleLock = new Object();

    public static void execute(Runnable runnable) {
        threadPool.execute(runnable);
    }

    public static void executeOnSingleThread(Runnable runnable) {
        synchronized (singleLock) {
            if (singleThreadPool == null) {
                singleThreadPool = ProxyExecutors.newSingleThreadExecutor();
            }
        }
        singleThreadPool.execute(runnable);
    }
}
