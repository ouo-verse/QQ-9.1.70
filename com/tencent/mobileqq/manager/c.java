package com.tencent.mobileqq.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f243592a;

    /* renamed from: b, reason: collision with root package name */
    private int f243593b;

    /* renamed from: c, reason: collision with root package name */
    private String f243594c;

    /* renamed from: d, reason: collision with root package name */
    private String f243595d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f243592a;
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f243594c = str;
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f243595d = str;
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f243593b = i3;
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f243592a = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QSafeManagerBean{mZipThreshold=" + this.f243592a + ", mVersion=" + this.f243593b + ", mAntiTheftUrl='" + this.f243594c + "', mSafeProtectUrl='" + this.f243595d + "'}";
    }
}
