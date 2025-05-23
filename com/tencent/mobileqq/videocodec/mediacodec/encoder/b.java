package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected a f312554a;

    /* renamed from: b, reason: collision with root package name */
    private EGLSurface f312555b;

    public b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f312555b = EGL14.EGL_NO_SURFACE;
            this.f312554a = aVar;
        }
    }

    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (this.f312555b == EGL14.EGL_NO_SURFACE) {
                this.f312555b = this.f312554a.c(i3, i16);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
        } else {
            if (this.f312555b == EGL14.EGL_NO_SURFACE) {
                this.f312555b = this.f312554a.d(obj);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f312554a.f(this.f312555b);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f312554a.h(this.f312555b);
            this.f312555b = EGL14.EGL_NO_SURFACE;
        }
    }

    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.f312554a.i(this.f312555b, j3);
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean j3 = this.f312554a.j(this.f312555b);
        if (!j3 && QLog.isColorLevel()) {
            QLog.d("EglSurfaceBase", 2, "WARNING: swapBuffers() failed");
        }
        return j3;
    }
}
