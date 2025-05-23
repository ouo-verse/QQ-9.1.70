package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public final class Pomelo extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f383030a;

    /* renamed from: b, reason: collision with root package name */
    public String f383031b;

    /* renamed from: c, reason: collision with root package name */
    public String f383032c;

    /* renamed from: d, reason: collision with root package name */
    public int f383033d;

    /* renamed from: e, reason: collision with root package name */
    public String f383034e;

    /* renamed from: f, reason: collision with root package name */
    public String f383035f;

    /* renamed from: g, reason: collision with root package name */
    public String f383036g;

    /* renamed from: h, reason: collision with root package name */
    public String f383037h;

    public Pomelo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383030a = "";
        this.f383031b = "";
        this.f383032c = "";
        this.f383033d = 0;
        this.f383034e = "";
        this.f383035f = "";
        this.f383036g = "";
        this.f383037h = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383030a, 0);
        String str = this.f383031b;
        if (str != null) {
            solar.a(str, 1);
        }
        solar.a(this.f383032c, 2);
        solar.a(this.f383033d, 3);
        solar.a(this.f383034e, 4);
        solar.a(this.f383035f, 5);
        String str2 = this.f383036g;
        if (str2 != null) {
            solar.a(str2, 6);
        }
        String str3 = this.f383037h;
        if (str3 != null) {
            solar.a(str3, 7);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f383030a = serpens.b(0, true);
        this.f383031b = serpens.b(1, false);
        this.f383032c = serpens.b(2, true);
        this.f383033d = serpens.a(this.f383033d, 3, true);
        this.f383034e = serpens.b(4, true);
        this.f383035f = serpens.b(5, true);
        this.f383036g = serpens.b(6, false);
        this.f383037h = serpens.b(7, false);
    }
}
