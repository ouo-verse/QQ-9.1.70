package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    public static boolean a() {
        return b("rich_media_browser_config_pic");
    }

    public static boolean b(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, false);
    }

    public static boolean c() {
        return b("rich_media_browser_config_video");
    }
}
