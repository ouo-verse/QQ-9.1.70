package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.Hydra;

/* compiled from: P */
/* loaded from: classes27.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final String f383331c;

    /* renamed from: d, reason: collision with root package name */
    public static final Hydra.Cdo f383332d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f383333e;

    /* renamed from: a, reason: collision with root package name */
    public Strawberry f383334a;

    /* renamed from: b, reason: collision with root package name */
    public Cascara f383335b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383331c = Ccontinue.a(Ccontinue.E0);
        f383332d = new Hydra.Cdo(-10, null);
        f383333e = new f();
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f383335b = null;
        }
    }
}
