package com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes17.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f276203a = Log.getStackTraceString(new Throwable());

    /* renamed from: b, reason: collision with root package name */
    private EGLDisplay f276204b;

    /* renamed from: c, reason: collision with root package name */
    private EGLContext f276205c;

    /* renamed from: d, reason: collision with root package name */
    private EGLConfig f276206d;

    /* renamed from: e, reason: collision with root package name */
    private int f276207e;

    public b(EGLContext eGLContext, int i3) {
        EGLConfig c16;
        this.f276204b = EGL14.EGL_NO_DISPLAY;
        this.f276205c = EGL14.EGL_NO_CONTEXT;
        this.f276206d = null;
        this.f276207e = -1;
        if (this.f276204b == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f276204b = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i3 & 2) != 0 && (c16 = c(i3, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f276204b, c16, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f276206d = c16;
                            this.f276205c = eglCreateContext;
                            this.f276207e = 3;
                        }
                    }
                    if (this.f276205c == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig c17 = c(i3, 2);
                        if (c17 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f276204b, c17, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            a("eglCreateContext");
                            this.f276206d = c17;
                            this.f276205c = eglCreateContext2;
                            this.f276207e = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    EGL14.eglQueryContext(this.f276204b, this.f276205c, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, new int[1], 0);
                    return;
                }
                this.f276204b = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    private void a(String str) {
        EGL14.eglGetError();
    }

    private EGLConfig c(int i3, int i16) {
        int i17;
        if (i16 >= 3) {
            i17 = 68;
        } else {
            i17 = 4;
        }
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i17, 12344, 0, 12344};
        if ((i3 & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f276204b, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return null;
        }
        return eGLConfigArr[0];
    }

    public EGLSurface b(int i3, int i16) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f276204b, this.f276206d, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void d(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = this.f276204b;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f276205c);
    }

    public void e() {
        EGLDisplay eGLDisplay = this.f276204b;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f276204b, this.f276205c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f276204b);
        }
        this.f276204b = EGL14.EGL_NO_DISPLAY;
        this.f276205c = EGL14.EGL_NO_CONTEXT;
        this.f276206d = null;
    }

    public void f(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f276204b, eGLSurface);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f276204b != EGL14.EGL_NO_DISPLAY) {
                e();
            }
        } finally {
            super.finalize();
        }
    }
}
