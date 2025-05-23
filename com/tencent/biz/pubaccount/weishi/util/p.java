package com.tencent.biz.pubaccount.weishi.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p {
    public static int a() {
        StringBuilder sb5 = new StringBuilder();
        String o16 = o(BaseApplication.getContext());
        if (o16 == null || TextUtils.isEmpty(o16)) {
            return 0;
        }
        for (String str : o16.split("\\.")) {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 10) {
                sb5.append("0");
                sb5.append(parseInt);
            } else {
                sb5.append(parseInt);
            }
        }
        return Integer.parseInt(sb5.toString());
    }

    public static String b() {
        return ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getDeviceInfor();
    }

    public static String c() {
        return PadUtil.a(BaseApplication.getContext()).toString();
    }

    public static String d() {
        return ab.f81687a.b(BaseApplication.getContext());
    }

    public static String e() {
        return DeviceInstance.getInstance().getDeviceName();
    }

    public static String f() {
        return (((((("" + DeviceInfoMonitor.getModel()) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.RELEASE) + ContainerUtils.FIELD_DELIMITER) + Build.VERSION.SDK_INT) + ContainerUtils.FIELD_DELIMITER) + h();
    }

    public static String g() {
        if (AppNetConnInfo.isWifiConn()) {
            return "Wi-Fi";
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo == 1) {
                return "2G";
            }
            if (mobileInfo == 2) {
                return "3G";
            }
            if (mobileInfo == 3) {
                return "4G";
            }
            if (mobileInfo == 4) {
                return "5G";
            }
        }
        return "unknown";
    }

    public static int h() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String i() {
        return Build.VERSION.RELEASE;
    }

    public static String j() {
        String b16 = com.tencent.mobileqq.statistics.o.b();
        return TextUtils.isEmpty(b16) ? "" : b16;
    }

    public static String k() {
        String c16 = com.tencent.mobileqq.statistics.o.c();
        return TextUtils.isEmpty(c16) ? "" : c16;
    }

    public static double l() {
        ((WindowManager) BaseApplication.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return Math.sqrt(Math.pow(r1.widthPixels / r1.xdpi, 2.0d) + Math.pow(r1.heightPixels / r1.ydpi, 2.0d));
    }

    public static int m(Activity activity) {
        return ImmersiveUtils.getStatusBarHeight(activity);
    }

    public static int n(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static String o(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String p() {
        return "";
    }

    public static String q() {
        return s(ab.f81687a.c(BaseApplication.getContext()));
    }

    public static String r() {
        return "";
    }

    public static String s(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }
}
