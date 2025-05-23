package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qphone.base.util.QLog;
import java.util.Objects;

/* compiled from: P */
@TargetApi(18)
/* loaded from: classes20.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private EGLDisplay f312551a;

    /* renamed from: b, reason: collision with root package name */
    private EGLContext f312552b;

    /* renamed from: c, reason: collision with root package name */
    private EGLConfig f312553c;

    public a(EGLContext eGLContext, int i3) {
        EGLConfig e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eGLContext, i3);
            return;
        }
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f312551a = eGLDisplay;
        this.f312552b = EGL14.EGL_NO_CONTEXT;
        this.f312553c = null;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            if (eGLContext == null) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
                QLog.e("EglCore", 2, "sharedContext == null");
            }
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f312551a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i3 & 2) != 0 && (e16 = e(i3, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f312551a, e16, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f312553c = e16;
                            this.f312552b = eglCreateContext;
                        }
                    }
                    if (this.f312552b == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig e17 = e(i3, 2);
                        if (e17 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f312551a, e17, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            b("eglCreateContext");
                            this.f312553c = e17;
                            this.f312552b = eglCreateContext2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    int[] iArr2 = new int[1];
                    EGL14.eglQueryContext(this.f312551a, this.f312552b, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr2, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d("EglCore", 2, "EGLContext created, client version " + iArr2[0]);
                        return;
                    }
                    return;
                }
                this.f312551a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }
        throw new RuntimeException("EGL already set up");
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            QLog.e("EglCore", 2, new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError)), new Object[0]);
        }
    }

    private EGLConfig e(int i3, int i16) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.f312551a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            if (QLog.isColorLevel()) {
                QLog.w("EglCore", 2, "unable to find RGB8888 / " + i16 + " EGLConfig");
                return null;
            }
            return null;
        }
        return eGLConfigArr[0];
    }

    void b(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            Objects.toString(EGL14.eglGetCurrentContext());
            Objects.toString(this.f312552b);
            g();
        }
    }

    public EGLSurface c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EGLSurface) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f312551a, this.f312553c, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public EGLSurface d(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EGLSurface) iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f312551a, this.f312553c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void f(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eGLSurface);
            return;
        }
        if (this.f312551a == EGL14.EGL_NO_DISPLAY && QLog.isColorLevel()) {
            QLog.d("EglCore", 2, "NOTE: makeCurrent w/o display");
        }
        if (EGL14.eglMakeCurrent(this.f312551a, eGLSurface, eGLSurface, this.f312552b)) {
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed = " + EGL14.eglGetError());
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EGLDisplay eGLDisplay = this.f312551a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f312551a, this.f312552b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f312551a);
        }
        this.f312551a = EGL14.EGL_NO_DISPLAY;
        this.f312552b = EGL14.EGL_NO_CONTEXT;
        this.f312553c = null;
    }

    public void h(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eGLSurface);
        } else {
            EGL14.eglDestroySurface(this.f312551a, eGLSurface);
        }
    }

    public void i(EGLSurface eGLSurface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, eGLSurface, Long.valueOf(j3));
        } else {
            EGLExt.eglPresentationTimeANDROID(this.f312551a, eGLSurface, j3);
        }
    }

    public boolean j(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eGLSurface)).booleanValue();
        }
        return EGL14.eglSwapBuffers(this.f312551a, eGLSurface);
    }
}
