package com.tencent.av.opengl.effects;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import com.tencent.ark.EGLContextHolder;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes3.dex */
public class v {

    /* renamed from: d, reason: collision with root package name */
    private EGL10 f74048d = null;

    /* renamed from: e, reason: collision with root package name */
    private EGLDisplay f74049e = null;

    /* renamed from: f, reason: collision with root package name */
    private EGLSurface f74050f = null;

    /* renamed from: h, reason: collision with root package name */
    private EGLContext f74051h = null;

    /* renamed from: i, reason: collision with root package name */
    private android.opengl.EGLDisplay f74052i = null;

    /* renamed from: m, reason: collision with root package name */
    private android.opengl.EGLSurface f74053m = null;
    private android.opengl.EGLContext C = null;

    @SuppressLint({"NewApi"})
    private void e() {
        android.opengl.EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f74052i = eglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(this.f74052i, g(), 0, eGLConfigArr, 0, 1, iArr2, 0);
        if (iArr2[0] == 0 && AVCoreLog.isColorLevel()) {
            AVCoreLog.i("OffscreenSurface", "TROUBLE! No config found.");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        this.f74053m = EGL14.eglCreatePbufferSurface(this.f74052i, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 64, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 64, 12344}, 0);
        android.opengl.EGLContext eglCreateContext = EGL14.eglCreateContext(this.f74052i, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
        this.C = eglCreateContext;
        android.opengl.EGLDisplay eGLDisplay = this.f74052i;
        android.opengl.EGLSurface eGLSurface = this.f74053m;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext);
    }

    @SuppressLint({"NewApi"})
    private void f() {
        android.opengl.EGLDisplay eGLDisplay = this.f74052i;
        if (eGLDisplay != null && this.f74053m != null && this.C != null) {
            android.opengl.EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f74052i, this.f74053m);
            EGL14.eglDestroyContext(this.f74052i, this.C);
            EGL14.eglTerminate(this.f74052i);
        }
    }

    @NotNull
    public int[] g() {
        return new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        e();
    }

    public void i() {
        f();
    }
}
