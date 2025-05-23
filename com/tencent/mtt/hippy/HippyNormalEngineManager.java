package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.ThreadExecutor;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class HippyNormalEngineManager extends HippyEngineManagerImpl {
    private final Object mLock;
    private volatile ThreadExecutor mThreadExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HippyNormalEngineManager(HippyEngine.EngineInitParams engineInitParams, HippyBundleLoader hippyBundleLoader) {
        super(engineInitParams, hippyBundleLoader);
        this.mLock = new Object();
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    public int getBridgeType() {
        return 1;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    public ThreadExecutor getThreadExecutor() {
        if (this.mThreadExecutor == null) {
            synchronized (this.mLock) {
                if (this.mThreadExecutor == null) {
                    this.mThreadExecutor = new ThreadExecutor(-1);
                    this.mThreadExecutor.setUncaughtExceptionHandler(this);
                }
            }
        }
        return this.mThreadExecutor;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl, com.tencent.mtt.hippy.common.ThreadExecutor.UncaughtExceptionHandler
    public void handleThreadUncaughtException(Thread thread, Throwable th5, Integer num) {
        super.handleThreadUncaughtException(thread, th5, num);
        if (this.mDebugMode && this.mDevSupportManager != null) {
            synchronized (this.mLock) {
                if (this.mThreadExecutor != null) {
                    this.mThreadExecutor.destroy();
                    this.mThreadExecutor = null;
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    protected void onDestroy() {
        super.onDestroy();
        synchronized (this.mLock) {
            if (this.mThreadExecutor != null) {
                this.mThreadExecutor.destroy();
                this.mThreadExecutor = null;
            }
        }
    }
}
