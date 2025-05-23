package com.tencent.aekit.plugin.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AISegAttr {
    static IPatchRedirector $redirector_;
    private static boolean isRotate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12155);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isRotate = false;
        }
    }

    public AISegAttr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isRotate() {
        return isRotate;
    }

    public static void setRotate(boolean z16) {
        isRotate = z16;
    }
}
