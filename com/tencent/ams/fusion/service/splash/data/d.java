package com.tencent.ams.fusion.service.splash.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70527a;

    /* renamed from: b, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70528b;

    /* renamed from: c, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70529c;

    /* renamed from: d, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70530d;

    /* renamed from: e, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70531e;

    /* renamed from: f, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70532f;

    /* renamed from: g, reason: collision with root package name */
    List<com.tencent.ams.fusion.service.splash.b.a.a> f70533g;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70527a;
    }

    public void b(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.f70527a = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70528b;
    }

    public void d(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f70528b = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f70529c;
    }

    public void f(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.f70529c = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f70530d;
    }

    public void h(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        } else {
            this.f70530d = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f70531e;
    }

    public void j(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        } else {
            this.f70532f = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f70532f;
    }

    public void l(List<com.tencent.ams.fusion.service.splash.b.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        } else {
            this.f70533g = list;
        }
    }

    public List<com.tencent.ams.fusion.service.splash.b.a.a> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f70533g;
    }
}
