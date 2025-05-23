package com.tencent.edge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.u.a;
import com.tencent.qimei.uin.U;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Camera {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            U.e(a.f343383b);
        }
    }

    public Camera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native void k(String str, int i3);
}
