package com.tencent.ams.fusion.service.splash.b.b.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import nt.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f70337a;

    /* renamed from: b, reason: collision with root package name */
    private String f70338b;

    /* renamed from: c, reason: collision with root package name */
    private String f70339c;

    /* renamed from: d, reason: collision with root package name */
    private long f70340d;

    /* renamed from: e, reason: collision with root package name */
    private Object f70341e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f70342f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // nt.f
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f70337a : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
    }

    @Override // nt.f
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70338b : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // nt.f
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f70339c : (String) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // kt.d
    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f70340d : ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f70339c = str;
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f70342f = z16;
        }
    }

    public Object g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f70341e;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f70342f;
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.f70340d = j3;
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        }
    }

    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f70341e = obj;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, obj);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.f70338b = str;
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f70337a = z16;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }
}
