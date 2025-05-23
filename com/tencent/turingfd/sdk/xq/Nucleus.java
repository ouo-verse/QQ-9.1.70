package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Nucleus extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382942a;

    /* renamed from: b, reason: collision with root package name */
    public String f382943b;

    /* renamed from: c, reason: collision with root package name */
    public String f382944c;

    /* renamed from: d, reason: collision with root package name */
    public String f382945d;

    /* renamed from: e, reason: collision with root package name */
    public int f382946e;

    public Nucleus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382942a = 0;
        this.f382943b = "";
        this.f382944c = "";
        this.f382945d = "";
        this.f382946e = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382942a, 0);
        solar.a(this.f382943b, 1);
        solar.a(this.f382944c, 2);
        solar.a(this.f382945d, 3);
        solar.a(this.f382946e, 4);
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f382942a = serpens.a(this.f382942a, 0, true);
        this.f382943b = serpens.b(1, true);
        this.f382944c = serpens.b(2, true);
        this.f382945d = serpens.b(3, true);
        this.f382946e = serpens.a(this.f382946e, 4, true);
    }
}
