package com.tencent.tuxmeterqui.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxDialogBundleKey {
    static IPatchRedirector $redirector_ = null;
    public static final String NATIVE_SURVEY_SETTING = "native_survey_setting";
    public static final String SURVEY = "survey";
    public static final String WEB_URL = "web_url";

    public TuxDialogBundleKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
