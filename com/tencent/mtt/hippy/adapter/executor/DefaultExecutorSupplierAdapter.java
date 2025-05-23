package com.tencent.mtt.hippy.adapter.executor;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultExecutorSupplierAdapter implements HippyExecutorSupplierAdapter {
    private volatile ExecutorService mBackgroundTaskExecutor;
    private volatile ExecutorService mDBExecutor;

    @Override // com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter
    public void destroyIfNeed() {
        synchronized (DefaultExecutorSupplierAdapter.class) {
            if (this.mDBExecutor != null && !this.mDBExecutor.isShutdown()) {
                this.mDBExecutor.shutdown();
                this.mDBExecutor = null;
            }
            if (this.mBackgroundTaskExecutor != null && !this.mBackgroundTaskExecutor.isShutdown()) {
                this.mBackgroundTaskExecutor.shutdown();
                this.mBackgroundTaskExecutor = null;
            }
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter
    public Executor getBackgroundTaskExecutor() {
        if (this.mBackgroundTaskExecutor == null) {
            synchronized (DefaultExecutorSupplierAdapter.class) {
                if (this.mBackgroundTaskExecutor == null) {
                    this.mBackgroundTaskExecutor = ProxyExecutors.newSingleThreadExecutor();
                }
            }
        }
        return this.mBackgroundTaskExecutor;
    }

    @Override // com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter
    public Executor getDBExecutor() {
        if (this.mDBExecutor == null) {
            synchronized (DefaultExecutorSupplierAdapter.class) {
                if (this.mDBExecutor == null) {
                    this.mDBExecutor = ProxyExecutors.newSingleThreadExecutor();
                }
            }
        }
        return this.mDBExecutor;
    }
}
