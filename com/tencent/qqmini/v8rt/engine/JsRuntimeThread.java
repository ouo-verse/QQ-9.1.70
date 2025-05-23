package com.tencent.qqmini.v8rt.engine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsRuntimeThread implements Handler.Callback {
    private static final String HANDLER_THREAD_NAME = "JsRuntimeThread";
    public static final int MSG_EXEC = 2;
    public static final int MSG_RELEASE = 3;
    private boolean isRelease = false;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final String sTAG;

    public JsRuntimeThread(int i3) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(HANDLER_THREAD_NAME);
        this.mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.sTAG = "JsRT-" + i3;
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
    }

    private void releaseInternal() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandlerThread.quit();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 3) {
            releaseInternal();
            return false;
        }
        return false;
    }

    public boolean isReleased() {
        return this.isRelease;
    }

    public void release() {
        Logger.i(this.sTAG, "release");
        this.isRelease = true;
        this.mHandler.sendEmptyMessage(3);
    }

    public void run(V8JsContext v8JsContext, Runnable runnable) {
        if (!this.isRelease) {
            this.mHandler.post(runnable);
        }
    }
}
