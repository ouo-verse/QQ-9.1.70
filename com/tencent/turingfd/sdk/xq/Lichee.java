package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Lichee extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382871a;

    /* renamed from: b, reason: collision with root package name */
    public int f382872b;

    /* renamed from: c, reason: collision with root package name */
    public String f382873c;

    /* renamed from: d, reason: collision with root package name */
    public String f382874d;

    /* renamed from: e, reason: collision with root package name */
    public int f382875e;

    /* renamed from: f, reason: collision with root package name */
    public String f382876f;

    public Lichee() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382871a = 0;
        this.f382872b = 0;
        this.f382873c = "";
        this.f382874d = "";
        this.f382875e = 0;
        this.f382876f = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382871a, 0);
        solar.a(this.f382872b, 1);
        String str = this.f382873c;
        if (str != null) {
            solar.a(str, 2);
        }
        String str2 = this.f382874d;
        if (str2 != null) {
            solar.a(str2, 3);
        }
        solar.a(this.f382875e, 4);
        String str3 = this.f382876f;
        if (str3 != null) {
            solar.a(str3, 5);
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
        if (obj == null || !(obj instanceof Lichee)) {
            return false;
        }
        Lichee lichee = (Lichee) obj;
        if (Triangulum.a(this.f382871a, lichee.f382871a) && Triangulum.a(this.f382872b, lichee.f382872b) && this.f382873c.equals(lichee.f382873c) && this.f382874d.equals(lichee.f382874d) && Triangulum.a(this.f382875e, lichee.f382875e) && this.f382876f.equals(lichee.f382876f)) {
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
        this.f382871a = serpens.a(this.f382871a, 0, true);
        this.f382872b = serpens.a(this.f382872b, 1, false);
        this.f382873c = serpens.b(2, false);
        this.f382874d = serpens.b(3, false);
        this.f382875e = serpens.a(this.f382875e, 4, false);
        this.f382876f = serpens.b(5, false);
    }
}
