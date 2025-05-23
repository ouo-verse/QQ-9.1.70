package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class jb1kT extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382263a;

    /* renamed from: b, reason: collision with root package name */
    public int f382264b;

    /* renamed from: c, reason: collision with root package name */
    public int f382265c;

    /* renamed from: d, reason: collision with root package name */
    public int f382266d;

    public jb1kT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382263a = 0;
        this.f382264b = 0;
        this.f382265c = 0;
        this.f382266d = 0;
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new jb1kT() : (UMDtK) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
            return;
        }
        int i3 = this.f382263a;
        if (i3 != 0) {
            xjpd8.a(i3, 0);
        }
        xjpd8.a(this.f382264b, 1);
        int i16 = this.f382265c;
        if (i16 != 0) {
            xjpd8.a(i16, 2);
        }
        int i17 = this.f382266d;
        if (i17 != 0) {
            xjpd8.a(i17, 3);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382263a = yunKQ.a(this.f382263a, 0, false);
        this.f382264b = yunKQ.a(this.f382264b, 1, false);
        this.f382265c = yunKQ.a(this.f382265c, 2, false);
        this.f382266d = yunKQ.a(this.f382266d, 3, false);
    }
}
