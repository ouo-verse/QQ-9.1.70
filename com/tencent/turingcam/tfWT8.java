package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class tfWT8 extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382391a;

    /* renamed from: b, reason: collision with root package name */
    public String f382392b;

    /* renamed from: c, reason: collision with root package name */
    public String f382393c;

    /* renamed from: d, reason: collision with root package name */
    public String f382394d;

    /* renamed from: e, reason: collision with root package name */
    public int f382395e;

    public tfWT8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382391a = 0;
        this.f382392b = "";
        this.f382393c = "";
        this.f382394d = "";
        this.f382395e = 0;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382391a, 0);
        xjpd8.a(this.f382392b, 1);
        xjpd8.a(this.f382393c, 2);
        xjpd8.a(this.f382394d, 3);
        xjpd8.a(this.f382395e, 4);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382391a = yunKQ.a(this.f382391a, 0, true);
        this.f382392b = yunKQ.b(1, true);
        this.f382393c = yunKQ.b(2, true);
        this.f382394d = yunKQ.b(3, true);
        this.f382395e = yunKQ.a(this.f382395e, 4, true);
    }
}
