package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ZIDl7 extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382117a;

    /* renamed from: b, reason: collision with root package name */
    public int f382118b;

    public ZIDl7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382117a = "";
            this.f382118b = 0;
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ZIDl7() : (UMDtK) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
            return;
        }
        String str = this.f382117a;
        if (str != null) {
            xjpd8.a(str, 0);
        }
        int i3 = this.f382118b;
        if (i3 != 0) {
            xjpd8.a(i3, 1);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
        } else {
            this.f382117a = yunKQ.b(0, false);
            this.f382118b = yunKQ.a(this.f382118b, 1, false);
        }
    }
}
