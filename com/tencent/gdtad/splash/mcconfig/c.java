package com.tencent.gdtad.splash.mcconfig;

import com.tencent.gdtad.splash.GdtSplashConstants$MMKV;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static boolean a() {
        GdtSplashAdSwitchConfigParser.a b16 = a.b();
        if (b16 == null) {
            QLog.i("GdtSplashSwitchConfig", 1, "[canReportForEmptyOrder] config is null, has no frequency control");
            return true;
        }
        int i3 = b16.f109390f;
        if (i3 <= 0) {
            QLog.i("GdtSplashSwitchConfig", 1, "[canReportForEmptyOrder] has no frequency control");
            return true;
        }
        int b17 = ym0.a.b("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_NULL_ORDER_REPORT_NUM_TODAY, 0);
        long c16 = ym0.a.c("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_NULL_ORODER_REPORT_TIME_STAMP, 0L);
        String c17 = b.c(c16);
        long currentTimeMillis = System.currentTimeMillis();
        String c18 = b.c(currentTimeMillis);
        QLog.i("GdtSplashSwitchConfig", 1, "[canReportForEmptyOrder] maxReportNumOneDay:" + i3 + " reportNumOneDay:" + b17 + " lastReportTimeStamp:" + c16 + " lastReportTimeDate:" + c17 + " thisReportTimeStamp:" + currentTimeMillis + " thisReuqestDate" + c18);
        if (!c18.equalsIgnoreCase(c17)) {
            b();
            return true;
        }
        if (b17 < i3 || i3 <= 0) {
            return true;
        }
        return false;
    }

    public static void b() {
        ym0.a.j("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_NULL_ORDER_REPORT_NUM_TODAY);
        ym0.a.j("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_NULL_ORODER_REPORT_TIME_STAMP);
    }

    public static void c() {
        int b16 = ym0.a.b("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_NULL_ORDER_REPORT_NUM_TODAY, 0) + 1;
        long currentTimeMillis = System.currentTimeMillis();
        String c16 = b.c(currentTimeMillis);
        ym0.a.f("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_NULL_ORDER_REPORT_NUM_TODAY, b16);
        ym0.a.g("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_NULL_ORODER_REPORT_TIME_STAMP, currentTimeMillis);
        QLog.i("GdtSplashSwitchConfig", 1, "splash frequency control-cache reportNumOneDay\uff1a" + b16 + " thisReportTimeStamp\uff1a" + currentTimeMillis + " thisReportDate\uff1a" + c16);
    }
}
