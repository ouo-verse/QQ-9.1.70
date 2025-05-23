package com.tencent.mobileqq.profilecard.version;

import com.tencent.mobileqq.profilecard.multyple.ProfileCardElegantConfig;
import com.tencent.mobileqq.profilecard.multyple.ProfileCardVersion;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.relation.common.abtest.a;
import com.tencent.relation.common.config.toggle.c;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class ProfileCardVersionController {
    static IPatchRedirector $redirector_ = null;
    public static final ProfileCardVersion ELEGANT;
    public static final ProfileCardVersion OLD;
    public static final String TAG = "ProfileCardVersionController";
    private static boolean isForceElegant;
    public static HashMap<Integer, ProfileCardVersion> versionMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ProfileCardVersion profileCardVersion = ProfileCardVersion.V_OLD;
        OLD = profileCardVersion;
        ProfileCardVersion profileCardVersion2 = ProfileCardVersion.V_ELEGANT;
        ELEGANT = profileCardVersion2;
        HashMap<Integer, ProfileCardVersion> hashMap = new HashMap<>();
        versionMap = hashMap;
        hashMap.put(0, profileCardVersion);
        versionMap.put(1, profileCardVersion2);
    }

    public ProfileCardVersionController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void forceElegant() {
        isForceElegant = true;
    }

    public static ProfileCardVersion getVersion() {
        if (getVersionCode() == 1) {
            setElegantGiftBtnState(true);
            return versionMap.get(1);
        }
        return versionMap.get(0);
    }

    public static int getVersionCode() {
        if (!isForceElegant && !c.A.g(false) && !a.c("exp_qqprofile_homepage_ui") && !a.d("exp_qqprofile_homepage_ui", "exp_qqprofile_homepage_ui_C")) {
            return 0;
        }
        return 1;
    }

    public static void initConfig() {
        isForceElegant = false;
    }

    private static void setElegantGiftBtnState(boolean z16) {
        ((ProfileCardElegantConfig) ELEGANT.getVersionConfig()).setShowGiftBtn(z16);
    }
}
