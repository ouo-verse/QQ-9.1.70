package com.tencent.ams.fusion.service.splash.c.a.a.c.b;

import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import ot.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<SplashOrder> f70436a;

    /* renamed from: b, reason: collision with root package name */
    private int f70437b;

    /* renamed from: c, reason: collision with root package name */
    private int f70438c;

    /* renamed from: d, reason: collision with root package name */
    private int f70439d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70440e;

    /* renamed from: f, reason: collision with root package name */
    private long f70441f;

    /* renamed from: g, reason: collision with root package name */
    private List<com.tencent.ams.fusion.service.splash.c.a.a.c.a.a> f70442g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f70443h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70437b = -1;
        this.f70438c = 0;
        this.f70439d = 0;
        this.f70440e = true;
        this.f70443h = false;
    }

    @Override // ot.d
    public List<SplashOrder> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f70436a;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f70437b = i3;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // kt.e
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.f70441f : ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
    }

    public void d(List<SplashOrder> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            if (j.b(list)) {
                return;
            }
            if (j.b(this.f70436a)) {
                this.f70436a = list;
            } else {
                this.f70436a.addAll(list);
            }
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f70440e = z16;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f70439d = i3;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void g(List<SplashOrder> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            d(list);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.f70443h = z16;
        }
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f70438c = i3;
        }
    }

    public void j(List<com.tencent.ams.fusion.service.splash.c.a.a.c.a.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        } else {
            this.f70442g = list;
        }
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return j.b(this.f70436a);
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f70439d;
    }

    @Override // ot.d, kt.e
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.f70440e : ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.f70441f = j3;
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        }
    }

    @Override // ot.d
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f70438c : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
    }

    @Override // ot.d
    public List<com.tencent.ams.fusion.service.splash.c.a.a.c.a.a> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? this.f70442g : (List) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @Override // ot.d
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.f70443h : ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
    }

    @Override // ot.d
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.f70437b : ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
    }
}
