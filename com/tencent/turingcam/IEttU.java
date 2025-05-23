package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class IEttU extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static FP21m f381837k;

    /* renamed from: a, reason: collision with root package name */
    public int f381838a;

    /* renamed from: b, reason: collision with root package name */
    public int f381839b;

    /* renamed from: c, reason: collision with root package name */
    public int f381840c;

    /* renamed from: d, reason: collision with root package name */
    public int f381841d;

    /* renamed from: e, reason: collision with root package name */
    public int f381842e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f381843f;

    /* renamed from: g, reason: collision with root package name */
    public FP21m f381844g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f381845h;

    /* renamed from: i, reason: collision with root package name */
    public int f381846i;

    /* renamed from: j, reason: collision with root package name */
    public String f381847j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20274);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f381837k = new FP21m();
        }
    }

    public IEttU() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381838a = 0;
        this.f381839b = 0;
        this.f381840c = 0;
        this.f381841d = 0;
        this.f381842e = 0;
        this.f381843f = null;
        this.f381844g = null;
        this.f381845h = null;
        this.f381846i = 0;
        this.f381847j = "";
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new IEttU() : (UMDtK) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f381838a, 0);
        int i3 = this.f381839b;
        if (i3 != 0) {
            xjpd8.a(i3, 1);
        }
        int i16 = this.f381840c;
        if (i16 != 0) {
            xjpd8.a(i16, 2);
        }
        xjpd8.a(this.f381841d, 3);
        int i17 = this.f381842e;
        if (i17 != 0) {
            xjpd8.a(i17, 4);
        }
        byte[] bArr = this.f381843f;
        if (bArr != null) {
            xjpd8.a(bArr, 5);
        }
        FP21m fP21m = this.f381844g;
        if (fP21m != null) {
            xjpd8.a((UMDtK) fP21m, 6);
        }
        byte[] bArr2 = this.f381845h;
        if (bArr2 != null) {
            xjpd8.a(bArr2, 7);
        }
        int i18 = this.f381846i;
        if (i18 != 0) {
            xjpd8.a(i18, 8);
        }
        String str = this.f381847j;
        if (str != null) {
            xjpd8.a(str, 9);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) yunKQ);
            return;
        }
        this.f381838a = yunKQ.a(this.f381838a, 0, true);
        this.f381839b = yunKQ.a(this.f381839b, 1, false);
        this.f381840c = yunKQ.a(this.f381840c, 2, false);
        this.f381841d = yunKQ.a(this.f381841d, 3, false);
        this.f381842e = yunKQ.a(this.f381842e, 4, false);
        this.f381843f = yunKQ.a(5, false);
        this.f381844g = (FP21m) yunKQ.a((UMDtK) f381837k, 6, false);
        this.f381845h = yunKQ.a(7, false);
        this.f381846i = yunKQ.a(this.f381846i, 8, false);
        this.f381847j = yunKQ.b(9, false);
    }
}
