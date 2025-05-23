package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.PublicKey;

/* compiled from: P */
/* loaded from: classes27.dex */
public class fDI6Z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public PublicKey f382240a;

    public fDI6Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f382240a = null;
        }
    }
}
