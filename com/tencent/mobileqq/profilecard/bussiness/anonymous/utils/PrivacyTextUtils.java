package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class PrivacyTextUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String DESCRIPTION_PICK = "\uff0c\u5df2\u9009\u4e2d";
    public static final String DESCRIPTION_VISIBLE_STATE_ALL = "\u6240\u6709\u4eba\u53ef\u89c1";
    public static final String DESCRIPTION_VISIBLE_STATE_ALL_NOT = "\u6240\u6709\u4eba\u4e0d\u53ef\u89c1";
    public static final String DESCRIPTION_VISIBLE_STATE_ONLY_FRIEND = "\u4ec5\u597d\u53cb\u53ef\u89c1";

    public PrivacyTextUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getPrivacyText(int i3) {
        if (i3 == 0) {
            return DESCRIPTION_VISIBLE_STATE_ALL;
        }
        if (i3 == 1) {
            return DESCRIPTION_VISIBLE_STATE_ONLY_FRIEND;
        }
        if (i3 != 2) {
            return DESCRIPTION_VISIBLE_STATE_ALL;
        }
        return DESCRIPTION_VISIBLE_STATE_ALL_NOT;
    }
}
