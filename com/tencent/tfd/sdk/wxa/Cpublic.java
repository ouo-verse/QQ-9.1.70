package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.public, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cpublic extends CanisMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f375769a;

    /* renamed from: b, reason: collision with root package name */
    public String f375770b;

    public Cpublic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375769a = "";
            this.f375770b = "";
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canesatici);
        } else {
            canesatici.a(this.f375769a, 0);
            canesatici.a(this.f375770b, 1);
        }
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) caelum);
        } else {
            this.f375769a = caelum.b(0, true);
            this.f375770b = caelum.b(1, true);
        }
    }
}
