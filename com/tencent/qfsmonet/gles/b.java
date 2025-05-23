package com.tencent.qfsmonet.gles;

import android.annotation.TargetApi;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private EGLDisplay f342489a;

    /* renamed from: b, reason: collision with root package name */
    private EGLContext f342490b;

    /* renamed from: c, reason: collision with root package name */
    private EGLConfig f342491c;

    /* renamed from: d, reason: collision with root package name */
    private EGLSurface f342492d;

    public b(@NonNull EGLDisplay eGLDisplay, @NonNull EGLContext eGLContext, @NonNull EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eGLDisplay, eGLContext, eGLConfig);
            return;
        }
        this.f342492d = null;
        this.f342491c = eGLConfig;
        this.f342490b = eGLContext;
        this.f342489a = eGLDisplay;
    }

    public EGLConfig a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EGLConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f342491c;
    }

    public EGLContext b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EGLContext) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f342490b;
    }

    public EGLDisplay c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EGLDisplay) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f342489a;
    }

    public EGLSurface d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EGLSurface) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f342492d;
    }

    public void e(EGLSurface eGLSurface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eGLSurface);
        } else {
            this.f342492d = eGLSurface;
        }
    }
}
