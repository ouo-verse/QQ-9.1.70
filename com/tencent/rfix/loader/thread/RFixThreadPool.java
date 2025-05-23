package com.tencent.rfix.loader.thread;

import com.tencent.rfix.loader.thread.IRFixThreadPool;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class RFixThreadPool implements IRFixThreadPool {
    private static final int CORE_POOL_SIZE = 0;
    private static final long KEEP_ALIVE_TIME = 60;
    private static final int MAX_POOL_SIZE = 5;
    private static IRFixThreadPool sInstance;
    private final ExecutorService executor = new BaseThreadPoolExecutor(0, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    RFixThreadPool() {
    }

    public static IRFixThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (RFixThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new RFixThreadPool();
                }
            }
        }
        return sInstance;
    }

    public static void setThreadPoolImpl(IRFixThreadPool iRFixThreadPool) {
        synchronized (RFixThreadPool.class) {
            sInstance = iRFixThreadPool;
        }
    }

    @Override // com.tencent.rfix.loader.thread.IRFixThreadPool
    public void execute(Runnable runnable) {
        execute(runnable, IRFixThreadPool.ThreadType.THREAD_DEFAULT);
    }

    @Override // com.tencent.rfix.loader.thread.IRFixThreadPool
    public void execute(Runnable runnable, IRFixThreadPool.ThreadType threadType) {
        this.executor.execute(runnable);
    }
}
