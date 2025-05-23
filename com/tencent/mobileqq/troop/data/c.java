package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f294891a;

    /* renamed from: b, reason: collision with root package name */
    public int f294892b;

    /* renamed from: c, reason: collision with root package name */
    public d f294893c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f294891a = null;
        this.f294892b = -1;
        this.f294893c = new d();
        b();
    }

    public static final boolean a(int i3, int i16) {
        if (i3 == 12) {
            i3 = 31;
        }
        if (i16 == 12) {
            i16 = 31;
        }
        if (i3 != 2 && i3 != 17) {
            if (i3 != 7 && i3 < i16) {
                return false;
            }
            return true;
        }
        if (i3 + 1 < i16) {
            return false;
        }
        return true;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f294893c.a();
        }
    }

    public int c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, z16)).intValue();
        }
        if (z16) {
            return f();
        }
        return d();
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (this.f294893c.c() && d.d(this.f294893c.f294895a)) {
            return this.f294893c.f294895a;
        }
        return 0;
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        if (this.f294893c.c() && d.d(this.f294893c.f294895a)) {
            return this.f294893c.f294896b;
        }
        return -1L;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (this.f294893c.c()) {
            return this.f294893c.f294895a;
        }
        return 0;
    }

    public long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        if (this.f294893c.c()) {
            return this.f294893c.f294896b;
        }
        return -1L;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f294893c.c();
    }

    public c i(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
        if (cVar != null) {
            this.f294893c.i(cVar.f294893c);
        }
        return this;
    }

    public c(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        this.f294891a = null;
        this.f294892b = -1;
        d dVar = new d();
        this.f294893c = dVar;
        if (cVar != null) {
            dVar.b(cVar.f294893c);
        } else {
            b();
        }
    }
}
