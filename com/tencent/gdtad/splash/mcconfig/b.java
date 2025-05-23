package com.tencent.gdtad.splash.mcconfig;

import com.tencent.gdtad.splash.GdtSplashConstants$MMKV;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdPreloadConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    public static void a() {
        ym0.a.j("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_REQUEST_NUM_ONE_DAY);
        ym0.a.j("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_TIME_STAMP);
    }

    public static boolean b(int i3) {
        GdtSplashAdPreloadConfigParser.a a16 = a.a();
        if (a16 == null) {
            QLog.i("GdtSplashPreloadConfig", 1, "[isPreloadInLimitation] config is null, use default config");
            a16 = new GdtSplashAdPreloadConfigParser.a();
        }
        int i16 = a16.f109382d;
        if (i16 > 0 && i3 >= i16) {
            QLog.e("GdtSplashPreloadConfig", 1, "[isPreloadInLimitation] return false, access limit count:" + i3 + " config:" + a16);
            return false;
        }
        int i17 = a16.f109383e;
        int i18 = a16.f109384f;
        if (i17 <= 0 && i18 <= 0) {
            QLog.i("GdtSplashPreloadConfig", 1, "[isPreloadInLimitation] has no frequency control");
            return true;
        }
        int b16 = ym0.a.b("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_REQUEST_NUM_ONE_DAY, 0);
        long c16 = ym0.a.c("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_TIME_STAMP, 0L);
        String c17 = c(c16);
        long currentTimeMillis = System.currentTimeMillis();
        String c18 = c(currentTimeMillis);
        QLog.i("GdtSplashPreloadConfig", 1, "[isPreloadInLimitation] maxRequestOneDay:" + i17 + " twoRequestIntervalTimeSeconds\uff1a" + i18 + " requestNumOneDay:" + b16 + " lastRequestTimeStamp:" + c16 + " lastRequestTimeDate:" + c17 + " thisRequestTimeStamp:" + currentTimeMillis + " thisReuqestDate" + c18);
        if (!c18.equalsIgnoreCase(c17)) {
            a();
            return true;
        }
        if (b16 >= i17 && i17 > 0) {
            return false;
        }
        if ((currentTimeMillis - c16) / 1000 > i18 || i18 <= 0) {
            return true;
        }
        return false;
    }

    public static String c(long j3) {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(j3));
    }

    public static void d() {
        int b16 = ym0.a.b("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_REQUEST_NUM_ONE_DAY, 0) + 1;
        long currentTimeMillis = System.currentTimeMillis();
        String c16 = c(currentTimeMillis);
        ym0.a.f("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_REQUEST_NUM_ONE_DAY, b16);
        ym0.a.g("Splash_", GdtSplashConstants$MMKV.KEY_SPLASH_LAST_REQUEST_TIME_STAMP, currentTimeMillis);
        QLog.i("GdtSplashPreloadConfig", 1, "splash frequency control-cache requestNumOneDay\uff1a" + b16 + " thisRequestTimeStamp\uff1a" + currentTimeMillis + " thisReuqestDate\uff1a" + c16);
        QLog.i("GdtSplashPreloadConfig", 1, "splash frequency control-This is a valid request, preload request in progress");
    }
}
