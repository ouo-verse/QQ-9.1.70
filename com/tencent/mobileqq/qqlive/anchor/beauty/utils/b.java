package com.tencent.mobileqq.qqlive.anchor.beauty.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f270550a;

    /* renamed from: b, reason: collision with root package name */
    private int f270551b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f270550a = 0;
            this.f270551b = 0;
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.f270551b;
        if (i3 == 0) {
            return 0;
        }
        return (int) ((this.f270550a * 100.0f) / i3);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f270550a = 0;
            this.f270551b = 0;
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f270550a++;
        }
        this.f270551b++;
    }
}
