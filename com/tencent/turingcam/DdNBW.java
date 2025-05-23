package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DdNBW extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f381784a;

    /* renamed from: b, reason: collision with root package name */
    public String f381785b;

    /* renamed from: c, reason: collision with root package name */
    public String f381786c;

    /* renamed from: d, reason: collision with root package name */
    public int f381787d;

    /* renamed from: e, reason: collision with root package name */
    public String f381788e;

    /* renamed from: f, reason: collision with root package name */
    public String f381789f;

    /* renamed from: g, reason: collision with root package name */
    public String f381790g;

    /* renamed from: h, reason: collision with root package name */
    public String f381791h;

    public DdNBW() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381784a = "";
        this.f381785b = "";
        this.f381786c = "";
        this.f381787d = 0;
        this.f381788e = "";
        this.f381789f = "";
        this.f381790g = "";
        this.f381791h = "";
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f381784a, 0);
        String str = this.f381785b;
        if (str != null) {
            xjpd8.a(str, 1);
        }
        xjpd8.a(this.f381786c, 2);
        xjpd8.a(this.f381787d, 3);
        xjpd8.a(this.f381788e, 4);
        xjpd8.a(this.f381789f, 5);
        String str2 = this.f381790g;
        if (str2 != null) {
            xjpd8.a(str2, 6);
        }
        String str3 = this.f381791h;
        if (str3 != null) {
            xjpd8.a(str3, 7);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
            return;
        }
        this.f381784a = yunKQ.b(0, true);
        this.f381785b = yunKQ.b(1, false);
        this.f381786c = yunKQ.b(2, true);
        this.f381787d = yunKQ.a(this.f381787d, 3, true);
        this.f381788e = yunKQ.b(4, true);
        this.f381789f = yunKQ.b(5, true);
        this.f381790g = yunKQ.b(6, false);
        this.f381791h = yunKQ.b(7, false);
    }
}
