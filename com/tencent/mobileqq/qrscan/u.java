package com.tencent.mobileqq.qrscan;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes17.dex */
public class u {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("scan_qbar_so_download_switch_new", false);
    }

    public static String b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("scan_qbar_so_download_switch_new", "");
    }
}
