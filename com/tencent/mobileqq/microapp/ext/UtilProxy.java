package com.tencent.mobileqq.microapp.ext;

import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes15.dex */
public class UtilProxy {
    static IPatchRedirector $redirector_;

    public UtilProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void setStatusTextColor(boolean z16, Window window) {
        ImmersiveUtils.setStatusTextColor(z16, window);
    }
}
