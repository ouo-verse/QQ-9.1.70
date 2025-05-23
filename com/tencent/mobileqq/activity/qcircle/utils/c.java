package com.tencent.mobileqq.activity.qcircle.utils;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.qcircle.application.QCircleApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    public static SplitViewState a() {
        return com.tencent.mobileqq.pad.e.a();
    }

    private static boolean b() {
        if (uq3.c.X0("qqcircle", "secondary_key_enable_pad_split_view_mode", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static AppInterface c() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) waitAppRuntime;
    }

    public static IQCircleEeveeManangerService d() {
        return (IQCircleEeveeManangerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleEeveeManangerService.class, "");
    }

    public static IQCirclePreLoaderService e() {
        return (IQCirclePreLoaderService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCirclePreLoaderService.class, "");
    }

    public static IQCircleRedPointService f() {
        return (IQCircleRedPointService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleRedPointService.class, "");
    }

    public static IQCircleService g() {
        return (IQCircleService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleService.class, "");
    }

    public static boolean h() {
        Context applicationContext = QCircleApplication.getAPP().getApplicationContext();
        if (applicationContext.getResources().getConfiguration().orientation == 2 && AppSetting.o(applicationContext)) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        SplitViewState a16 = a();
        if (j() && a16 == SplitViewState.STATE_FLAT) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        if (AppSetting.t(QCircleApplication.getAPP().getApplicationContext()) && b()) {
            return true;
        }
        return false;
    }
}
