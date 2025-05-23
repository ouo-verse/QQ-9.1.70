package com.tencent.mobileqq.vas.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUtil {
    public static boolean isMainProcess = BaseApplication.getContext().getPackageName().equals(MobileQQ.processName);

    public static AppRuntime getApp() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static AppInterface getAppInterface() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static String getCurrentUin() {
        return getCurrentUin(true);
    }

    public static IVasService getService(AppRuntime appRuntime) {
        return (IVasService) appRuntime.getRuntimeService(IVasService.class, "all");
    }

    public static IVasSingedApi getSignedService(AppRuntime appRuntime) {
        return (IVasSingedApi) appRuntime.getRuntimeService(IVasSingedApi.class, "all");
    }

    public static IVasDepTemp getTempApi() {
        return (IVasDepTemp) QRoute.api(IVasDepTemp.class);
    }

    public static String getCurrentUin(boolean z16) {
        String currentUin;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return "";
        }
        AppRuntime waitAppRuntime = z16 ? mobileQQ.waitAppRuntime(null) : mobileQQ.peekAppRuntime();
        return (waitAppRuntime == null || (currentUin = waitAppRuntime.getCurrentUin()) == null) ? "" : currentUin;
    }

    public static IVasService getService() {
        return (IVasService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "all");
    }
}
