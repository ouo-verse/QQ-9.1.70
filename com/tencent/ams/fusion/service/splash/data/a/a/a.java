package com.tencent.ams.fusion.service.splash.data.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements qt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f70508a;

    /* renamed from: b, reason: collision with root package name */
    private String f70509b;

    /* renamed from: c, reason: collision with root package name */
    private String f70510c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f70511d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70512e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // qt.a
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70508a;
    }

    @Override // qt.a
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70509b : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // qt.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f70510c : (String) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // qt.a
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f70512e : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f70511d = z16;
        }
    }

    public void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f70510c = str;
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f70508a = str;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f70512e = z16;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    public void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f70509b = str;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }
}
