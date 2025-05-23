package com.tencent.turingface.sdk.mfa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.LwgsO;
import com.tencent.turingcam.WOMZP;
import com.tencent.turingcam.fBfpd;

/* compiled from: P */
/* loaded from: classes27.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final String f382542c;

    /* renamed from: d, reason: collision with root package name */
    public static final n f382543d;

    /* renamed from: a, reason: collision with root package name */
    public fBfpd f382544a;

    /* renamed from: b, reason: collision with root package name */
    public WOMZP f382545b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13719);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382542c = LwgsO.a(LwgsO.E0);
            f382543d = new n();
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382545b = null;
        }
    }
}
