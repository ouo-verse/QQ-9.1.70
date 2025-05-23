package com.tencent.gdtad.splash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.tg.splash.TADEmptyOrderReportHelper;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static long f109446a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f109447b = "splash_ad_exposure";

    /* renamed from: c, reason: collision with root package name */
    public static String f109448c = "splash_ad_click";

    /* renamed from: d, reason: collision with root package name */
    public static String f109449d = "splash_ad_jump_click";

    /* renamed from: e, reason: collision with root package name */
    public static String f109450e = "aid";

    /* renamed from: f, reason: collision with root package name */
    public static String f109451f = "isHotSplash";

    /* renamed from: g, reason: collision with root package name */
    public static String f109452g = "isRealTime";

    /* renamed from: h, reason: collision with root package name */
    public static String f109453h = "1";

    /* renamed from: i, reason: collision with root package name */
    public static String f109454i = "0";

    /* renamed from: j, reason: collision with root package name */
    public static String f109455j = "rl_download";

    /* renamed from: k, reason: collision with root package name */
    public static String f109456k = "normal_splash_limit";

    /* renamed from: l, reason: collision with root package name */
    public static String f109457l = "rl_splash_limit";

    /* renamed from: m, reason: collision with root package name */
    public static String f109458m = "1";

    /* renamed from: n, reason: collision with root package name */
    public static String f109459n = "0";

    public static p a() {
        if (SafeModeHelper.f(BaseApplication.getContext())) {
            QLog.e("GdtSplashUtils", 1, "[canRun] error, start fail");
            i();
            return new p(2000003);
        }
        p a16 = q.a();
        int a17 = a16.a();
        if (a17 != 0) {
            i();
            QLog.e("GdtSplashUtils", 1, "[canRun] error, errorCode:" + a17);
            return a16;
        }
        DeviceType a18 = PadUtil.a(BaseApplication.getContext());
        if (a18 != DeviceType.PHONE) {
            i();
            QLog.e("GdtSplashUtils", 1, "[canRun] error, deviceType:" + a18);
            return new p(2000006, a18.ordinal());
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 23) {
            i();
            QLog.e("GdtSplashUtils", 1, "[canRun] error, Build.VERSION.SDK_INT:" + i3);
            return new p(2000007, i3);
        }
        return new p(0);
    }

    public static boolean b() {
        if (System.currentTimeMillis() - f109446a < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsHotShowDuration()) {
            return true;
        }
        return false;
    }

    public static HashMap<String, String> c(boolean z16) {
        String str;
        String str2;
        String str3;
        HashMap<String, String> hashMap = new HashMap<>();
        String str4 = f109455j;
        if (((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDownloadRes()) {
            str = f109458m;
        } else {
            str = f109459n;
        }
        hashMap.put(str4, str);
        String str5 = f109456k;
        if (((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).isAmsSplashExceedLimit(z16)) {
            str2 = f109458m;
        } else {
            str2 = f109459n;
        }
        hashMap.put(str5, str2);
        String str6 = f109457l;
        if (!n.f109392a.m()) {
            str3 = f109458m;
        } else {
            str3 = f109459n;
        }
        hashMap.put(str6, str3);
        return hashMap;
    }

    public static boolean d(Context context) {
        int i3;
        if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
            i3 = context.getResources().getConfiguration().orientation;
        } else {
            i3 = Integer.MIN_VALUE;
        }
        QLog.i("GdtSplashUtils", 1, "[isOrientationValid] orientation:" + i3);
        if (i3 != 2) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (System.currentTimeMillis() - f109446a < ((IGdtAPI) QRoute.api(IGdtAPI.class)).getAmsShowAndPreloadDuration()) {
            return true;
        }
        return false;
    }

    public static void f(boolean z16, boolean z17, int i3) {
        int a16 = a().a();
        if (a16 != 0) {
            QLog.e("GdtSplashUtils", 1, "reportForAnalysis error, canRun errorCode:" + a16);
            return;
        }
        String splashEmptyReportExp = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashEmptyReportExp();
        if (TextUtils.isEmpty(splashEmptyReportExp)) {
            return;
        }
        QLog.e("GdtSplashUtils", 1, "reportEmptyOrderEvent :" + z16 + " exposureChance " + z17 + " errorCode " + i3);
        TADEmptyOrderReportHelper.ReportParams reportParams = new TADEmptyOrderReportHelper.ReportParams();
        reportParams.delayMillis = 5000L;
        reportParams.expParams = splashEmptyReportExp;
        reportParams.posId = "9065538021425253";
        reportParams.isHotStart = z16;
        reportParams.hasExposureChance = z17;
        reportParams.errorCode = i3;
        reportParams.appId = "1109803375";
        reportParams.context = BaseApplication.getContext();
        new TADEmptyOrderReportHelper().dealEmptyOrderReportAfterAWhile(reportParams);
    }

    public static void g(String str, String str2, String str3) {
        Map<String, String> reportParams = ((IAdApi) QRoute.api(IAdApi.class)).getReportParams();
        reportParams.put(f109450e, str2);
        reportParams.put(f109451f, f109454i);
        reportParams.put(f109452g, str3);
        ((IAdApi) QRoute.api(IAdApi.class)).report(str, reportParams);
    }

    public static void h(long j3) {
        f109446a = j3;
    }

    private static void i() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateSplashEmptyOrderParams(false, true, 1000);
    }
}
