package com.tencent.richmedia.videocompress.mediacodec;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes25.dex */
public class InputSurface {
    static final int EGL_OPENGL_ES2_BIT = 4;
    static final int EGL_RECORDABLE_ANDROID = 12610;
    static final String TAG = "InputSurface";
    static final boolean VERBOSE = false;
    EGLContext mEGLContext;
    EGLDisplay mEGLDisplay;
    EGLSurface mEGLSurface;
    Surface mSurface;

    public InputSurface(Surface surface) {
        surface.getClass();
        this.mSurface = surface;
        eglSetup();
    }

    void checkEglError(String str) {
        boolean z16 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z16 = true;
        }
        if (!z16) {
        } else {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    void eglSetup() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                    checkEglError("eglCreateContext");
                    if (this.mEGLContext != null) {
                        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
                        checkEglError("eglCreateWindowSurface");
                        if (this.mEGLSurface != null) {
                            return;
                        } else {
                            throw new RuntimeException("surface was null");
                        }
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.mEGLDisplay = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void makeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext)) {
        } else {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void release() {
        if (EGL14.eglGetCurrentContext().equals(this.mEGLContext)) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        this.mSurface.release();
        this.mEGLDisplay = null;
        this.mEGLContext = null;
        this.mEGLSurface = null;
        this.mSurface = null;
    }

    public void setPresentationTime(long j3) {
        try {
            Class.forName("android.opengl.EGLExt").getDeclaredMethod("eglPresentationTimeANDROID", EGLDisplay.class, EGLSurface.class, Long.TYPE).invoke(null, this.mEGLDisplay, this.mEGLSurface, Long.valueOf(j3));
        } catch (Exception unused) {
        }
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    }
}
