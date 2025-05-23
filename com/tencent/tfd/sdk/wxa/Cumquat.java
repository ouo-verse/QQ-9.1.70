package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cumquat {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final Cumquat f375573b;

    /* renamed from: a, reason: collision with root package name */
    public Bryony f375574a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375573b = new Cumquat();
        }
    }

    public Cumquat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final Durian a(byte[] bArr) {
        Durian a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Durian) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
        Cabstract cabstract = this.f375574a.f375458a;
        if (cabstract == null) {
            return Durian.a(-20000);
        }
        try {
            System.currentTimeMillis();
            Cinstanceof a17 = cabstract.a(bArr);
            int i3 = a17.errCode;
            if (i3 != 0) {
                a16 = Durian.a(i3 - 20000);
            } else {
                a16 = Durian.a(a17.data);
            }
            return a16;
        } catch (Throwable unused) {
            return Durian.a(-20000);
        }
    }
}
