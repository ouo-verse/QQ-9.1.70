package com.tencent.ams.fusion.service.splash.c.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import ot.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements pt.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private c f70393a;

    /* renamed from: b, reason: collision with root package name */
    private rt.a f70394b;

    /* renamed from: c, reason: collision with root package name */
    private long f70395c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // pt.b
    public c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70393a;
    }

    @Override // pt.b
    public rt.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70394b : (rt.a) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void c(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f70393a = cVar;
        }
    }

    public void d(rt.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.f70394b = aVar;
        }
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f70395c = j3;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
    }
}
