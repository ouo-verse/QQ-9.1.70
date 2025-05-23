package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public final class TUmP8 extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382063a;

    /* renamed from: b, reason: collision with root package name */
    public float f382064b;

    /* renamed from: c, reason: collision with root package name */
    public float f382065c;

    /* renamed from: d, reason: collision with root package name */
    public float f382066d;

    /* renamed from: e, reason: collision with root package name */
    public float f382067e;

    public TUmP8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382063a = 0;
        this.f382064b = 0.0f;
        this.f382065c = 0.0f;
        this.f382066d = 0.0f;
        this.f382067e = 0.0f;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382063a, 0);
        xjpd8.a(this.f382064b, 1);
        xjpd8.a(this.f382065c, 2);
        float f16 = this.f382066d;
        if (f16 != 0.0f) {
            xjpd8.a(f16, 3);
        }
        float f17 = this.f382067e;
        if (f17 != 0.0f) {
            xjpd8.a(f17, 4);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382063a = yunKQ.a(this.f382063a, 0, true);
        this.f382064b = yunKQ.a(this.f382064b, 1, true);
        this.f382065c = yunKQ.a(this.f382065c, 2, true);
        this.f382066d = yunKQ.a(this.f382066d, 3, false);
        this.f382067e = yunKQ.a(this.f382067e, 4, false);
    }
}
