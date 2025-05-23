package com.tencent.mobileqq.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime) {
        if (MobileQQ.sProcessId == 1) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100037", false);
            QLog.d("LzmaDecodeFeatureSwitch", 1, "FeatureSwitch: " + isSwitchOn);
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("lzma_decode_feature_switch", isSwitchOn);
        }
    }
}
