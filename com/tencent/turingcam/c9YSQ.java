package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c9YSQ extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static jb1kT f382167d;

    /* renamed from: a, reason: collision with root package name */
    public jb1kT f382168a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f382169b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f382170c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382167d = new jb1kT();
        }
    }

    public c9YSQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382168a = null;
        this.f382169b = null;
        this.f382170c = null;
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new c9YSQ() : (UMDtK) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xjpd8);
            return;
        }
        jb1kT jb1kt = this.f382168a;
        if (jb1kt != null) {
            xjpd8.a((UMDtK) jb1kt, 0);
        }
        byte[] bArr = this.f382169b;
        if (bArr != null) {
            xjpd8.a(bArr, 1);
        }
        byte[] bArr2 = this.f382170c;
        if (bArr2 != null) {
            xjpd8.a(bArr2, 2);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382168a = (jb1kT) yunKQ.a((UMDtK) f382167d, 0, false);
        this.f382169b = yunKQ.a(1, false);
        this.f382170c = yunKQ.a(2, false);
    }
}
