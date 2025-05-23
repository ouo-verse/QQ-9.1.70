package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostAppSettingUtil {
    public static String buildNum() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).buildNum();
    }

    public static boolean enableTalkBack() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).enableTalkBack();
    }

    public static String getReportVersionName() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
    }

    public static String getSubVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
    }

    public static String getVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getVersion();
    }

    public static String getVersionForPic() {
        return QUA.getVersionForPic();
    }

    public static boolean isAllowLandscape() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape();
    }

    public static boolean isDebugVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion();
    }

    public static boolean isGrayVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isGrayVersion();
    }

    public static boolean isPublicVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion();
    }

    public static boolean isUITest() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isUITest();
    }
}
