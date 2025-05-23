package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.ComaBerenices;
import com.tencent.turingfd.sdk.xq.Hydra;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Wild {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final Wild f383217b;

    /* renamed from: a, reason: collision with root package name */
    public Strawberry f383218a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383217b = new Wild();
        }
    }

    public Wild() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public c a(int i3, byte[] bArr, int i16, int i17, Lacerta lacerta) {
        c a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17), lacerta);
        }
        Hydra hydra = this.f383218a.f383079a;
        if (hydra == null) {
            return c.a(-20000);
        }
        try {
            System.currentTimeMillis();
            Hydra.Cdo a17 = ((ComaBerenices.Cdo) hydra).a(bArr);
            int i18 = a17.f382843a;
            if (i18 != 0) {
                a16 = c.a(i18 - 20000);
            } else {
                a16 = c.a(a17.f382844b);
            }
            return a16;
        } catch (Throwable unused) {
            return c.a(-20000);
        }
    }
}
