package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Cascara extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382642a;

    /* renamed from: b, reason: collision with root package name */
    public String f382643b;

    public Cascara() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382642a = "";
            this.f382643b = "";
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
        } else {
            solar.a(this.f382642a, 0);
            solar.a(this.f382643b, 1);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
        } else {
            this.f382642a = serpens.b(0, true);
            this.f382643b = serpens.b(1, true);
        }
    }
}
