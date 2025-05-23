package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class KKOXW extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f381875a;

    public KKOXW() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381875a = "";
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new KKOXW() : (UMDtK) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            xjpd8.a(this.f381875a, 0);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f381875a = yunKQ.b(0, true);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
        }
    }
}
