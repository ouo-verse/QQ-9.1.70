package com.tencent.ams.fusion.widget.downloadcard;

import com.tencent.ams.fusion.widget.utils.IFusionWebViewBuilder;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadCardViewConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DownloadCardViewConfig";
    private static IFusionWebViewBuilder sFusionWebViewBuilder;

    public DownloadCardViewConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IFusionWebViewBuilder getFusionWebViewBuilder() {
        return sFusionWebViewBuilder;
    }

    public static void setDarkMode(boolean z16) {
        ViewUtils.setDarkMode(z16);
        Logger.i(TAG, "setDarkMode: " + z16);
    }

    public static void setFusionWebViewBuilder(IFusionWebViewBuilder iFusionWebViewBuilder) {
        sFusionWebViewBuilder = iFusionWebViewBuilder;
    }
}
