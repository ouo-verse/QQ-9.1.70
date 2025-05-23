package com.tencent.msdk.dns.core.stat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.e;
import com.tencent.msdk.dns.core.i;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class a implements i.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String[] f336376a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f336377b;

    /* renamed from: c, reason: collision with root package name */
    public int f336378c;

    /* renamed from: d, reason: collision with root package name */
    public long f336379d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f336376a = e.f336253a;
        this.f336377b = false;
        this.f336378c = 0;
        this.f336379d = 0L;
    }

    @Override // com.tencent.msdk.dns.core.i.c
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (e.f336253a != this.f336376a) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.msdk.dns.core.i.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f336377b;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f336378c = (int) (System.currentTimeMillis() - this.f336379d);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f336379d = System.currentTimeMillis();
        }
    }
}
