package com.tencent.mtt.hippy;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.common.ThreadExecutorManager;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippySingleThreadEngineManager extends HippyEngineManagerImpl {
    private boolean mIsDestroyed;
    private final Object mLock;
    private ThreadExecutor mThreadExecutor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HippySingleThreadEngineManager(HippyEngine.EngineInitParams engineInitParams, HippyBundleLoader hippyBundleLoader) {
        super(engineInitParams, hippyBundleLoader);
        this.mLock = new Object();
        this.mThreadExecutor = null;
        this.mIsDestroyed = false;
        ThreadExecutorManager.getInstance().add(this);
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    public int getBridgeType() {
        return 2;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    public ThreadExecutor getThreadExecutor() {
        ThreadExecutor threadExecutor;
        ThreadExecutor threadExecutor2 = ThreadExecutorManager.getInstance().getThreadExecutor(this.mGroupId);
        if (threadExecutor2 == null) {
            synchronized (this.mLock) {
                LogUtils.e(HippyQQConstants.HIPPY_TAG, "SingleThreadEngineManager group threadExecutor == null, isDestroyed=" + this.mIsDestroyed);
                if (this.mThreadExecutor == null) {
                    ThreadExecutor threadExecutor3 = new ThreadExecutor(-1);
                    this.mThreadExecutor = threadExecutor3;
                    threadExecutor3.setUncaughtExceptionHandler(this);
                }
                threadExecutor = this.mThreadExecutor;
            }
            return threadExecutor;
        }
        return threadExecutor2;
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl, com.tencent.mtt.hippy.common.ThreadExecutor.UncaughtExceptionHandler
    public void handleThreadUncaughtException(Thread thread, Throwable th5, Integer num) {
        super.handleThreadUncaughtException(thread, th5, num);
        if (this.mDebugMode && this.mDevSupportManager != null) {
            synchronized (this.mLock) {
                ThreadExecutor threadExecutor = this.mThreadExecutor;
                if (threadExecutor != null) {
                    threadExecutor.destroy();
                    this.mThreadExecutor = null;
                }
            }
        }
    }

    @Override // com.tencent.mtt.hippy.HippyEngineManagerImpl
    public void onDestroy() {
        super.onDestroy();
        ThreadExecutorManager.getInstance().remove(this);
        synchronized (this.mLock) {
            this.mIsDestroyed = true;
            ThreadExecutor threadExecutor = this.mThreadExecutor;
            if (threadExecutor != null) {
                threadExecutor.destroy();
                this.mThreadExecutor = null;
            }
        }
    }
}
