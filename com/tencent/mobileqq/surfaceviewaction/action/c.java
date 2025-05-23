package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private int f291169n;

    /* renamed from: o, reason: collision with root package name */
    private int f291170o;

    /* renamed from: p, reason: collision with root package name */
    private int f291171p;

    /* renamed from: q, reason: collision with root package name */
    private int f291172q;

    /* renamed from: r, reason: collision with root package name */
    private float f291173r;

    public c(int i3, int i16, int i17, int i18, int i19, float f16) {
        super(i3, 11, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Float.valueOf(f16));
            return;
        }
        this.f291169n = i16;
        this.f291170o = i17;
        this.f291171p = i18;
        this.f291172q = i19;
        this.f291173r = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        float f17 = i3;
        int i16 = this.f291161f;
        float f18 = (f17 * 0.8f) / i16;
        this.f291158c = f18;
        if (f18 > 0.8f) {
            this.f291158c = 0.8f;
        }
        this.f291160e = (int) (((360.0f * f17) * f17) / (i16 * i16));
        int i17 = this.f291169n;
        this.f291156a = i17 + (((this.f291171p - i17) * i3) / i16);
        this.f291157b = (int) (this.f291170o + (this.f291172q * Math.sin(this.f291173r * r0)));
        super.a(i3, f16);
    }
}
