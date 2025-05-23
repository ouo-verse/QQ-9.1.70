package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private float f291174n;

    /* renamed from: o, reason: collision with root package name */
    private float f291175o;

    /* renamed from: p, reason: collision with root package name */
    private float f291176p;

    /* renamed from: q, reason: collision with root package name */
    private float f291177q;

    public d(int i3, float f16, float f17, float f18, float f19) {
        super(i3, 1, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.f291174n = f16;
        this.f291175o = f17;
        this.f291176p = f18;
        this.f291177q = f19;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        float f17 = this.f291174n;
        float f18 = this.f291176p;
        float f19 = ((f18 - f17) * f16) + f17;
        this.f291156a = f19;
        float f26 = this.f291175o;
        float f27 = this.f291177q;
        float f28 = ((f27 - f26) * f16) + f26;
        this.f291157b = f28;
        if (f18 - f17 > 0.0f) {
            if (f19 >= f18) {
                this.f291156a = f18;
            }
        } else if (f19 <= f18) {
            this.f291156a = f18;
        }
        if (f27 - f26 > 0.0f) {
            if (f28 >= f27) {
                this.f291157b = f27;
            }
        } else if (f28 <= f27) {
            this.f291157b = f27;
        }
        if (i3 >= this.f291161f) {
            this.f291156a = f18;
            this.f291157b = f27;
        }
        super.a(i3, f16);
    }
}
