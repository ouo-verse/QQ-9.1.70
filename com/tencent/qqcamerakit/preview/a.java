package com.tencent.qqcamerakit.preview;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private EGLDisplay f344937a;

    /* renamed from: b, reason: collision with root package name */
    private EGLContext f344938b;

    /* renamed from: c, reason: collision with root package name */
    private EGLConfig f344939c;

    public a(EGLContext eGLContext, int i3) {
        EGLConfig d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eGLContext, i3);
            return;
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f344937a = eGLDisplay;
        this.f344938b = EGL14.EGL_NO_CONTEXT;
        this.f344939c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
                com.tencent.qqcamerakit.common.e.d("EglCore", 2, "sharedContext == null");
            }
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f344937a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i3 & 2) != 0 && (d16 = d(i3, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f344937a, d16, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f344939c = d16;
                            this.f344938b = eglCreateContext;
                        }
                    }
                    if (this.f344938b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig d17 = d(i3, 2);
                        if (d17 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f344937a, d17, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            b("eglCreateContext");
                            this.f344939c = d17;
                            this.f344938b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f344937a, this.f344938b, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    if (com.tencent.qqcamerakit.common.e.f()) {
                        com.tencent.qqcamerakit.common.e.a("EglCore", 2, "EGLContext created, client version " + iArr2[0]);
                        return;
                    }
                    return;
                }
                this.f344937a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            RuntimeException runtimeException = new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            com.tencent.qqcamerakit.common.e.b("EglCore", 1, "checkEglError, ", runtimeException);
            if (com.tencent.qqcamerakit.common.e.f()) {
                throw runtimeException;
            }
        }
    }

    private EGLConfig d(int i3, int i16) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f344937a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.h("EglCore", 2, "unable to find RGB8888 / " + i16 + " EGLConfig");
                return null;
            }
            return null;
        }
        return eGLConfigArr[0];
    }

    void b(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            com.tencent.qqcamerakit.common.e.b("EglCore", 1, "checkEglErrorAndRelease, info:" + ("EGL14.eglGetCurrentContext() = " + EGL14.eglGetCurrentContext() + ", mEGLContext = " + this.f344938b), new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError)));
            f();
        }
    }

    public EGLSurface c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EGLSurface) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f344937a, this.f344939c, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void e(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eGLSurface);
            return;
        }
        if (this.f344937a == EGL14.EGL_NO_DISPLAY && com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("EglCore", 2, "NOTE: makeCurrent w/o display");
        }
        if (EGL14.eglMakeCurrent(this.f344937a, eGLSurface, eGLSurface, this.f344938b)) {
        } else {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EGLDisplay eGLDisplay = this.f344937a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f344937a, this.f344938b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f344937a);
        }
        this.f344937a = EGL14.EGL_NO_DISPLAY;
        this.f344938b = EGL14.EGL_NO_CONTEXT;
        this.f344939c = null;
    }

    public void g(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eGLSurface);
        } else {
            EGL14.eglDestroySurface(this.f344937a, eGLSurface);
        }
    }
}
