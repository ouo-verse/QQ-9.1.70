package com.gcore.abase.utils;

import com.gcore.abase.log.XLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ThreadPoolUtils {
    private static final String TAG = "THREAD_POOL_UTILS";
    private ExecutorService service;

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        private static final ThreadPoolUtils THREAD_POOL_UTILS = new ThreadPoolUtils();

        SingletonHolder() {
        }
    }

    public static ThreadPoolUtils getThreadPoolSingleton() {
        return SingletonHolder.THREAD_POOL_UTILS;
    }

    public void execute(Runnable runnable) {
        this.service.execute(runnable);
    }

    ThreadPoolUtils() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 0) {
            this.service = ProxyExecutors.newFixedThreadPool(availableProcessors * 2);
        } else {
            XLog.w(TAG, "Get CPU number failed.");
        }
    }
}
