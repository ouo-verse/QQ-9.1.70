package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public final class WOMZP extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382086a;

    /* renamed from: b, reason: collision with root package name */
    public String f382087b;

    public WOMZP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382086a = "";
            this.f382087b = "";
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
        } else {
            xjpd8.a(this.f382086a, 0);
            xjpd8.a(this.f382087b, 1);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
        } else {
            this.f382086a = yunKQ.b(0, true);
            this.f382087b = yunKQ.b(1, true);
        }
    }
}
