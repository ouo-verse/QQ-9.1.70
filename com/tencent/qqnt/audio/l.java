package com.tencent.qqnt.audio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes23.dex */
public class l {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("audio_9025_121030639", true);
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("audio_9025_121039659", true);
    }
}
