package com.tencent.qqcamerakit.preview;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected a f344940a;

    /* renamed from: b, reason: collision with root package name */
    private EGLSurface f344941b;

    public b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f344941b = EGL14.EGL_NO_SURFACE;
            this.f344940a = aVar;
        }
    }

    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (this.f344941b == EGL14.EGL_NO_SURFACE) {
                this.f344941b = this.f344940a.c(i3, i16);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f344940a.e(this.f344941b);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f344940a.g(this.f344941b);
            this.f344941b = EGL14.EGL_NO_SURFACE;
        }
    }
}
