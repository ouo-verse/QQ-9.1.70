package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Lemon extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382863a;

    /* renamed from: b, reason: collision with root package name */
    public int f382864b;

    /* renamed from: c, reason: collision with root package name */
    public int f382865c;

    /* renamed from: d, reason: collision with root package name */
    public int f382866d;

    /* renamed from: e, reason: collision with root package name */
    public String f382867e;

    /* renamed from: f, reason: collision with root package name */
    public String f382868f;

    /* renamed from: g, reason: collision with root package name */
    public int f382869g;

    /* renamed from: h, reason: collision with root package name */
    public String f382870h;

    public Lemon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382863a = 0;
        this.f382864b = 0;
        this.f382865c = 0;
        this.f382866d = 0;
        this.f382867e = "";
        this.f382868f = "";
        this.f382869g = 0;
        this.f382870h = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382863a, 0);
        solar.a(this.f382864b, 1);
        solar.a(this.f382865c, 2);
        solar.a(this.f382866d, 3);
        String str = this.f382867e;
        if (str != null) {
            solar.a(str, 4);
        }
        String str2 = this.f382868f;
        if (str2 != null) {
            solar.a(str2, 5);
        }
        solar.a(this.f382869g, 6);
        String str3 = this.f382870h;
        if (str3 != null) {
            solar.a(str3, 7);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Lemon)) {
            return false;
        }
        Lemon lemon = (Lemon) obj;
        if (Triangulum.a(this.f382863a, lemon.f382863a) && Triangulum.a(this.f382864b, lemon.f382864b) && Triangulum.a(this.f382865c, lemon.f382865c) && Triangulum.a(this.f382866d, lemon.f382866d) && this.f382867e.equals(lemon.f382867e) && this.f382868f.equals(lemon.f382868f) && Triangulum.a(this.f382869g, lemon.f382869g) && this.f382870h.equals(lemon.f382870h)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f382863a = serpens.a(this.f382863a, 0, true);
        this.f382864b = serpens.a(this.f382864b, 1, false);
        this.f382865c = serpens.a(this.f382865c, 2, false);
        this.f382866d = serpens.a(this.f382866d, 3, false);
        this.f382867e = serpens.b(4, false);
        this.f382868f = serpens.b(5, false);
        this.f382869g = serpens.a(this.f382869g, 6, false);
        this.f382870h = serpens.b(7, false);
    }
}
