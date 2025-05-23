package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private int f291178n;

    /* renamed from: o, reason: collision with root package name */
    private int f291179o;

    public e(int i3, int i16, int i17) {
        super(i3, 4, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f291178n = i16;
            this.f291179o = i17;
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
        int i16 = this.f291178n;
        int i17 = this.f291179o;
        int i18 = (int) (i16 + ((i17 - i16) * f16));
        this.f291159d = i18;
        if (i17 - i16 > 0) {
            if (i18 >= i17) {
                this.f291159d = i17;
            }
        } else if (i18 <= i17) {
            this.f291159d = i17;
        }
        super.a(i3, f16);
    }

    public e(int i3, int i16, int i17, int i18) {
        super(i3, 4, i18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f291178n = i16;
            this.f291179o = i17;
        }
    }
}
