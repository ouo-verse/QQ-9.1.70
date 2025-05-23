package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileCardReportUtil {
    static IPatchRedirector $redirector_ = null;
    private static final int FROM_CONTACT_LIST = 2;
    private static final int FROM_MOBILE_RECOMMEND = 3;
    private static final int FROM_MOBILE_SEARCH = 1;

    public ProfileCardReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getProfileSourceType(AllInOne allInOne) {
        int i3 = allInOne.f260789pa;
        if (i3 != 33 && i3 != 32 && i3 != 31 && i3 != 34) {
            if (i3 == 36) {
                return 3;
            }
            return 1;
        }
        return 2;
    }
}
