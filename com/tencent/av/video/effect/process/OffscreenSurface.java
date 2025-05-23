package com.tencent.av.video.effect.process;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import com.tencent.ark.EGLContextHolder;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OffscreenSurface {
    private static final String TAG = "OffscreenSurface";
    private EGL10 mEGL10 = null;
    private EGLDisplay mEGL10Display = null;
    private EGLSurface mEGL10Surface = null;
    private EGLContext mEGL10Context = null;
    private android.opengl.EGLDisplay mEGL14Display = null;
    private android.opengl.EGLSurface mEGL14Surface = null;
    private android.opengl.EGLContext mEGL14Context = null;

    public OffscreenSurface() {
        createEGL14Context();
    }

    private void createEGL10Context() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEGL10 = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEGL10Display = eglGetDisplay;
        this.mEGL10.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        this.mEGL10.eglChooseConfig(this.mEGL10Display, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, iArr);
        if (iArr[0] == 0) {
            Log.e(TAG, "TROUBLE! No config found.");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        this.mEGL10Surface = this.mEGL10.eglCreatePbufferSurface(this.mEGL10Display, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 64, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 64, 12344});
        EGLContext eglCreateContext = this.mEGL10.eglCreateContext(this.mEGL10Display, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        this.mEGL10Context = eglCreateContext;
        EGL10 egl102 = this.mEGL10;
        EGLDisplay eGLDisplay = this.mEGL10Display;
        EGLSurface eGLSurface = this.mEGL10Surface;
        egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext);
    }

    @SuppressLint({"NewApi"})
    private void createEGL14Context() {
        android.opengl.EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEGL14Display = eglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        android.opengl.EGLConfig[] eGLConfigArr = new android.opengl.EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(this.mEGL14Display, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0) {
            Log.e(TAG, "TROUBLE! No config found.");
        }
        android.opengl.EGLConfig eGLConfig = eGLConfigArr[0];
        this.mEGL14Surface = EGL14.eglCreatePbufferSurface(this.mEGL14Display, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 64, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 64, 12344}, 0);
        android.opengl.EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGL14Display, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
        this.mEGL14Context = eglCreateContext;
        android.opengl.EGLDisplay eGLDisplay = this.mEGL14Display;
        android.opengl.EGLSurface eGLSurface = this.mEGL14Surface;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext);
    }

    private void destroyEGL10Context() {
        EGLDisplay eGLDisplay;
        EGL10 egl10 = this.mEGL10;
        if (egl10 != null && (eGLDisplay = this.mEGL10Display) != null && this.mEGL10Surface != null && this.mEGL10Context != null) {
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.mEGL10.eglDestroySurface(this.mEGL10Display, this.mEGL10Surface);
            this.mEGL10.eglDestroyContext(this.mEGL10Display, this.mEGL10Context);
            this.mEGL10.eglTerminate(this.mEGL10Display);
        }
    }

    @SuppressLint({"NewApi"})
    private void destroyEGL14Context() {
        android.opengl.EGLDisplay eGLDisplay = this.mEGL14Display;
        if (eGLDisplay != null && this.mEGL14Surface != null && this.mEGL14Context != null) {
            android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.mEGL14Display, this.mEGL14Surface);
            EGL14.eglDestroyContext(this.mEGL14Display, this.mEGL14Context);
            EGL14.eglTerminate(this.mEGL14Display);
        }
    }

    public void release() {
        destroyEGL14Context();
    }
}
