package com.tencent.ams.fusion.service.splash.c.a.a.d;

import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a, pt.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // pt.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // pt.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 128;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a
    protected ot.d r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ot.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        pt.b s16 = s();
        if (s16 == null) {
            return a(1);
        }
        if (s16.a() == null) {
            return a(1);
        }
        rt.a b16 = s16.b();
        if (b16 == null) {
            return a(2);
        }
        SplashOrder c16 = b16.c();
        if (c16 == null) {
            return a(4);
        }
        if (!c16.aA()) {
            m(c16, e(), 200, Integer.MIN_VALUE);
            return a(8);
        }
        return d(c16);
    }
}
