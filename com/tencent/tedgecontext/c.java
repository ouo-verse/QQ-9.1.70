package com.tencent.tedgecontext;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedger.outapi.delegate.e;
import ve4.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private a f375128a;

    public c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375128a = aVar;
        }
    }

    private e a() {
        return this.f375128a.l();
    }

    private String b() {
        return "TEDGESDK_" + this.f375128a.c() + "_";
    }

    public void c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f375128a == null) {
            return;
        }
        a().i(b() + str, a().a(), str2);
    }

    @Override // ve4.l
    public void d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f375128a == null) {
            return;
        }
        a().d(b() + str, a().a(), str2);
    }

    @Override // ve4.l
    public void e(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (this.f375128a == null) {
            return;
        }
        a().e(b() + str, a().a(), str2 + "(" + i3 + ")");
    }

    public void f(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
        } else {
            if (this.f375128a == null) {
                return;
            }
            e(str, i3, str2);
        }
    }

    public void g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f375128a = aVar;
        }
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f375128a == null) {
            return;
        }
        a().w(b() + str, a().a(), str2);
    }
}
