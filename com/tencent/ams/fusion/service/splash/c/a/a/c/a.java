package com.tencent.ams.fusion.service.splash.c.a.a.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import ot.d;
import pt.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f70433a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // pt.c
    public d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70433a;
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f70433a = dVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        }
    }

    @Override // kt.e
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        d dVar = this.f70433a;
        if (dVar == null) {
            return 0L;
        }
        return dVar.c();
    }

    @Override // kt.e
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        d dVar = this.f70433a;
        return dVar == null || dVar.b();
    }
}
