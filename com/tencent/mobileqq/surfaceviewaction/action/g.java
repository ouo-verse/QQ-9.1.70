package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private float f291182n;

    /* renamed from: o, reason: collision with root package name */
    private float f291183o;

    public g(int i3, float f16, float f17) {
        super(i3, 2, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f291182n = f16;
            this.f291183o = f17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        float f17 = this.f291182n;
        float f18 = this.f291183o;
        float f19 = ((f18 - f17) * f16) + f17;
        this.f291158c = f19;
        if (f18 - f17 > 0.0f) {
            if (f19 >= f18) {
                this.f291158c = f18;
            }
        } else if (f19 <= f18) {
            this.f291158c = f18;
        }
        if (i3 >= this.f291161f) {
            this.f291158c = f18;
        }
        super.a(i3, f16);
    }
}
