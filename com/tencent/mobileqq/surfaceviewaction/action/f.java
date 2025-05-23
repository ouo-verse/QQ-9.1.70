package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private int f291180n;

    /* renamed from: o, reason: collision with root package name */
    private int f291181o;

    public f(int i3, int i16, int i17) {
        super(i3, 8, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f291180n = i16;
            this.f291181o = i17;
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
        System.out.println("time = " + i3 + ", percent = " + f16);
        int i16 = this.f291180n;
        int i17 = this.f291181o;
        int i18 = (int) (((float) i16) + (((float) (i17 - i16)) * f16));
        this.f291160e = i18;
        if (i17 - i16 > 0) {
            if (i18 >= i17) {
                this.f291160e = i17;
            }
        } else if (i18 <= i17) {
            this.f291160e = i17;
        }
        super.a(i3, f16);
    }
}
