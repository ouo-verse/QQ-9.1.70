package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class kGAMq extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Xy56r f382291h;

    /* renamed from: a, reason: collision with root package name */
    public int f382292a;

    /* renamed from: b, reason: collision with root package name */
    public int f382293b;

    /* renamed from: c, reason: collision with root package name */
    public int f382294c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f382295d;

    /* renamed from: e, reason: collision with root package name */
    public Xy56r f382296e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f382297f;

    /* renamed from: g, reason: collision with root package name */
    public int f382298g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382291h = new Xy56r();
        }
    }

    public kGAMq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382292a = 0;
        this.f382293b = 0;
        this.f382294c = 0;
        this.f382295d = null;
        this.f382296e = null;
        this.f382297f = null;
        this.f382298g = 0;
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new kGAMq() : (UMDtK) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382292a, 0);
        int i3 = this.f382293b;
        if (i3 != 0) {
            xjpd8.a(i3, 1);
        }
        int i16 = this.f382294c;
        if (i16 != 0) {
            xjpd8.a(i16, 2);
        }
        byte[] bArr = this.f382295d;
        if (bArr != null) {
            xjpd8.a(bArr, 3);
        }
        Xy56r xy56r = this.f382296e;
        if (xy56r != null) {
            xjpd8.a((UMDtK) xy56r, 4);
        }
        byte[] bArr2 = this.f382297f;
        if (bArr2 != null) {
            xjpd8.a(bArr2, 5);
        }
        int i17 = this.f382298g;
        if (i17 != 0) {
            xjpd8.a(i17, 6);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382292a = yunKQ.a(this.f382292a, 0, true);
        this.f382293b = yunKQ.a(this.f382293b, 1, false);
        this.f382294c = yunKQ.a(this.f382294c, 2, false);
        this.f382295d = yunKQ.a(3, false);
        this.f382296e = (Xy56r) yunKQ.a((UMDtK) f382291h, 4, false);
        this.f382297f = yunKQ.a(5, false);
        this.f382298g = yunKQ.a(this.f382298g, 6, false);
    }
}
