package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import com.tencent.sveffects.SLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes18.dex */
public class EglHandlerThread extends BaseHandlerThread {
    private static final String TAG = "EglHandlerThread";
    private EglCore eglCore;
    private EglSurfaceBase eglSurfaceBase;
    private Handler handler;
    private boolean initSuccess;
    private EGLContext sharedContext;

    public EglHandlerThread(String str, EGLContext eGLContext) {
        super(str);
        this.initSuccess = false;
        this.sharedContext = eGLContext;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public boolean isInitSuccess() {
        return this.initSuccess;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.handler = new Handler(getLooper());
        EglCore eglCore = new EglCore(this.sharedContext, 1);
        this.eglCore = eglCore;
        EglSurfaceBase eglSurfaceBase = new EglSurfaceBase(eglCore);
        this.eglSurfaceBase = eglSurfaceBase;
        try {
            eglSurfaceBase.createOffscreenSurface(64, 64);
            this.eglSurfaceBase.makeCurrent();
            this.initSuccess = true;
        } catch (Exception e16) {
            this.initSuccess = false;
            SLog.e(TAG, e16);
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        boolean quit = super.quit();
        release();
        return quit;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        boolean quitSafely = super.quitSafely();
        release();
        return quitSafely;
    }

    public void release() {
        if (!this.initSuccess) {
            return;
        }
        EglSurfaceBase eglSurfaceBase = this.eglSurfaceBase;
        if (eglSurfaceBase != null) {
            eglSurfaceBase.releaseEglSurface();
            this.eglSurfaceBase = null;
        }
        EglCore eglCore = this.eglCore;
        if (eglCore != null) {
            eglCore.release();
            this.eglCore = null;
        }
    }
}
