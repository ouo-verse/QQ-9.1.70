package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static String f369765a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f369766b = "GA";

    /* renamed from: c, reason: collision with root package name */
    private static String f369767c = "GE";

    /* renamed from: d, reason: collision with root package name */
    private static String f369768d = "9422";

    /* renamed from: e, reason: collision with root package name */
    private static String f369769e = "0";

    /* renamed from: f, reason: collision with root package name */
    private static String f369770f = "";

    /* renamed from: g, reason: collision with root package name */
    private static boolean f369771g = false;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f369772h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f369773i = false;

    public static String a(Context context) {
        return a(context, "0");
    }

    private static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getWidth();
        }
        return -1;
    }

    private static int c(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            return defaultDisplay.getHeight();
        }
        return -1;
    }

    private static boolean d(Context context) {
        boolean z16;
        if (f369772h) {
            return f369773i;
        }
        try {
            if ((Math.min(b(context), c(context)) * 160) / e(context) >= 700) {
                z16 = true;
            } else {
                z16 = false;
            }
            f369773i = z16;
            f369772h = true;
            return z16;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.densityDpi;
        }
        return 160;
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(f369765a)) {
            return f369765a;
        }
        String a16 = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), str, f369766b, f369767c, f369768d, f369769e, f369770f, f369771g);
        f369765a = a16;
        return a16;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16) {
        String str8;
        String str9;
        StringBuilder sb5 = new StringBuilder();
        String str10 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), applicationInfo.packageName, 0);
            str8 = applicationInfo.packageName;
            try {
                if (TextUtils.isEmpty(str7)) {
                    str7 = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e16) {
                e = e16;
                e.printStackTrace();
                str7 = "";
                String a16 = a(str8);
                String str11 = "PAD";
                str11 = "QB".equals(a16) ? IYunGameConstant.MIDAS_FLATFORM_TYPE : IYunGameConstant.MIDAS_FLATFORM_TYPE;
                sb5.append("QV");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append("3");
                a(sb5, "PL", "ADR");
                a(sb5, "PR", a16);
                a(sb5, "PP", str8);
                a(sb5, "PPVN", str7);
                if (!TextUtils.isEmpty(str)) {
                }
                a(sb5, "CO", "SYS");
                if (!TextUtils.isEmpty(str2)) {
                    a(sb5, "CO", "BK");
                }
                if (!TextUtils.isEmpty(str2)) {
                }
                a(sb5, "PB", str4);
                a(sb5, "VE", str3);
                a(sb5, "DE", str11);
                if (TextUtils.isEmpty(str6)) {
                }
                a(sb5, "CHID", str6);
                a(sb5, "LCID", str5);
                a(sb5, "MO", "unknown");
                a(sb5, "RL", str10);
                str9 = Build.VERSION.RELEASE;
                str9 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
                if (!TextUtils.isEmpty(str9)) {
                }
                a(sb5, "API", Build.VERSION.SDK_INT + "");
                return sb5.toString();
            }
        } catch (PackageManager.NameNotFoundException e17) {
            e = e17;
            str8 = "";
        }
        String a162 = a(str8);
        String str112 = "PAD";
        if ("QB".equals(a162) ? !d(context) : !z16) {
        }
        sb5.append("QV");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append("3");
        a(sb5, "PL", "ADR");
        a(sb5, "PR", a162);
        a(sb5, "PP", str8);
        a(sb5, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            a(sb5, "TBSVC", str);
        }
        a(sb5, "CO", "SYS");
        if (!TextUtils.isEmpty(str2) && !str2.equals("0")) {
            a(sb5, "CO", "BK");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(sb5, "COVC", str2);
        }
        a(sb5, "PB", str4);
        a(sb5, "VE", str3);
        a(sb5, "DE", str112);
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        a(sb5, "CHID", str6);
        a(sb5, "LCID", str5);
        a(sb5, "MO", "unknown");
        a(sb5, "RL", str10);
        str9 = Build.VERSION.RELEASE;
        try {
            str9 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str9)) {
            a(sb5, Global.TRACKING_OS, str9);
        }
        a(sb5, "API", Build.VERSION.SDK_INT + "");
        return sb5.toString();
    }

    private static void a(StringBuilder sb5, String str, String str2) {
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(str2);
    }

    private static String a(String str) {
        return "com.tencent.mm".equals(str) ? "WX" : "com.tencent.mobileqq".equals(str) ? "QQ" : "com.qzone".equals(str) ? "QZ" : TbsConfig.APP_QB.equals(str) ? "QB" : ky.f149107m;
    }
}
