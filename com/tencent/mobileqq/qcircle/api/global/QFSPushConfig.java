package com.tencent.mobileqq.qcircle.api.global;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import uq3.k;

/* loaded from: classes16.dex */
public class QFSPushConfig {
    private static final String ROCKET_CHARGE_TIP_SHOW_COUNT_KEY = "RocketChargeTipsShowCountKey";
    private static final String TAG = "QFSPushConfig";
    private static String sCurrentUin = null;
    private static boolean sIsNeedShowPushPanelWhenLogin = false;
    private static long sRocketChargeTipsLastTime;
    private static int sRocketChargeTipsShowCountLimit;
    private static String sRocketChargeTipsText;

    public static boolean getIsNeedShowPushPanelWhenLogin() {
        return sIsNeedShowPushPanelWhenLogin;
    }

    public static long getRocketChargeTipsLastShowTime(String str) {
        long j3 = sRocketChargeTipsLastTime;
        if (j3 > 0) {
            return j3;
        }
        return k.a().f(str, 0L);
    }

    public static String getRocketChargeTipsText() {
        return sRocketChargeTipsText;
    }

    public static boolean isNeedShowRocketChargeTipsWhenLogin() {
        if (TextUtils.isEmpty(sRocketChargeTipsText) || sRocketChargeTipsShowCountLimit <= 0 || !((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount().equals(sCurrentUin) || k.a().e("QFSPushConfigRocketChargeTipsShowCountKey", 0) > sRocketChargeTipsShowCountLimit) {
            return false;
        }
        return true;
    }

    public static void saveRocketChargeTipsLastShowTime(String str, long j3) {
        sRocketChargeTipsLastTime = j3;
        k.a().n(str, j3);
        k.a().m("QFSPushConfigRocketChargeTipsShowCountKey", k.a().e("QFSPushConfigRocketChargeTipsShowCountKey", 0) + 1);
    }

    public static void saveRocketChargeTipsShowCountLimit(int i3) {
        sRocketChargeTipsShowCountLimit = i3;
    }

    public static void saveRocketChargeTipsText(String str) {
        sRocketChargeTipsText = str;
    }

    public static void setCurrentUin(String str) {
        sCurrentUin = str;
    }

    public static void setIsNeedShowPushPanelWhenLogin(boolean z16) {
        sIsNeedShowPushPanelWhenLogin = z16;
    }
}
