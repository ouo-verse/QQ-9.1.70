package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes19.dex */
public class JSThread extends BaseThread {
    private static final String TAG = "JSThread";
    private final IListener mListener;
    private final TTEngine mTritonEngine;
    private volatile boolean mQuitThread = false;
    private long jsThreadId = -1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface IListener {
        void onExit();

        boolean onPrepare();
    }

    public JSThread(TTEngine tTEngine, IListener iListener) {
        this.mTritonEngine = tTEngine;
        this.mListener = iListener;
        setPriority(10);
        setName("JSThread_" + getId());
    }

    public boolean isJSThread() {
        if (this.jsThreadId == Thread.currentThread().getId()) {
            return true;
        }
        return false;
    }

    public void onPause() {
        if (this.mTritonEngine.getRenderContext() != null) {
            JNICaller.RenderContext.nOnPause(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
        }
    }

    public void onResume() {
        if (this.mTritonEngine.getRenderContext() != null) {
            JNICaller.RenderContext.nOnResume(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle());
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        this.jsThreadId = getId();
        Logger.e(TAG, "JSThread (tid:" + this.jsThreadId + ") run start");
        IListener iListener = this.mListener;
        if (iListener == null) {
            return;
        }
        iListener.onPrepare();
        while (!this.mQuitThread) {
            try {
                if (JNICaller.RenderContext.nUpdateRenderContext(this.mTritonEngine.getRenderContext(), this.mTritonEngine.getNativeTTAppHandle())) {
                    TTEngine tTEngine = this.mTritonEngine;
                    JNICaller.TTEngine.runLoop(tTEngine, tTEngine.getNativeTTAppHandle(), true);
                    TTEngine tTEngine2 = this.mTritonEngine;
                    JNICaller.TTEngine.runLoop(tTEngine2, tTEngine2.getNativeTTAppHandle(), false);
                    Logger.i(TAG, "JSThread (tid: " + this.jsThreadId + ") runLoop is interrupted loopQuit=" + this.mQuitThread);
                }
            } catch (Exception e16) {
                Logger.e(TAG, "JSThread (tid:" + this.jsThreadId + ") run error " + e16.getMessage());
            }
        }
        Logger.e(TAG, "JSThread (tid:" + this.jsThreadId + ") run exit");
        this.mListener.onExit();
    }

    public void shutdown() {
        this.mQuitThread = true;
        Logger.e(TAG, "JSThread (tid:" + this.jsThreadId + ") shutdown");
        TTEngine tTEngine = this.mTritonEngine;
        JNICaller.TTEngine.interruptLoop(tTEngine, tTEngine.getNativeTTAppHandle());
    }
}
