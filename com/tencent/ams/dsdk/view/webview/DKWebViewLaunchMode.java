package com.tencent.ams.dsdk.view.webview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DKWebViewLaunchMode {
    static IPatchRedirector $redirector_;
    public static int LAUNCH_NOT_ALLOWED;
    public static int LAUNCH_WITHOUT_CONFIRMATION;
    public static int LAUNCH_WITH_CONFIRMATION;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LAUNCH_WITH_CONFIRMATION = 1;
        LAUNCH_WITHOUT_CONFIRMATION = 2;
        LAUNCH_NOT_ALLOWED = 3;
    }

    public DKWebViewLaunchMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
