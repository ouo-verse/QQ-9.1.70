package com.tencent.mobileqq.qmethodmonitor;

import android.content.Context;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    public static boolean a(Context context) {
        if (Foreground.getActivityCount() > 0) {
            return true;
        }
        return QMMKV.from(context, "common_mmkv_configurations").decodeBool("app_state_foreground_key", true);
    }

    public static void b(String str, Map<String, String> map) {
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        } else {
            str2 = "0";
        }
        QLog.d("PrivacyUtil", 1, "reportBeacon param:" + map);
        QQBeaconReport.report(str2, str, map);
    }

    public static void c(Context context) {
        QLog.d("PrivacyUtil", 1, "set application on background");
        QMMKV.from(context, "common_mmkv_configurations").encodeBool("app_state_foreground_key", false);
    }

    public static void d(Context context) {
        QLog.d("PrivacyUtil", 1, "set application on foreground");
        QMMKV.from(context, "common_mmkv_configurations").encodeBool("app_state_foreground_key", true);
    }
}
