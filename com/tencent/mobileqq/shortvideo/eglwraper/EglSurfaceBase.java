package com.tencent.mobileqq.shortvideo.eglwraper;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.sveffects.SLog;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes18.dex */
public class EglSurfaceBase {
    protected static final String TAG = "EglSurfaceBase";
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    protected EglCore mEglCore;

    public EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    public void createOffscreenSurface(int i3, int i16) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createOffscreenSurface(i3, i16);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    }

    public void setPresentationTime(long j3) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, j3);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.mEglCore.swapBuffers(this.mEGLSurface);
        if (!swapBuffers && SLog.isEnable()) {
            SLog.d(TAG, "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }
}
