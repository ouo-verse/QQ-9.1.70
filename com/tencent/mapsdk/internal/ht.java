package com.tencent.mapsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.map.tools.Util;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ht {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148737a = 400;

    /* renamed from: b, reason: collision with root package name */
    public static final String f148738b = "TencentMapSDK";

    /* renamed from: c, reason: collision with root package name */
    private static final int f148739c = 65537;

    /* renamed from: d, reason: collision with root package name */
    private static String f148740d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f148741e = null;

    /* renamed from: f, reason: collision with root package name */
    private static String f148742f = null;

    /* renamed from: g, reason: collision with root package name */
    private static String f148743g = "";

    /* renamed from: h, reason: collision with root package name */
    private static final String f148744h = "device_id";

    public static float a(Context context) {
        if (context == null) {
            return 1.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int[] d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new int[]{point.x, point.y};
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            return packageInfo.versionName + packageInfo.versionCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String f(Context context) {
        return Util.getMD5String(Util.getSuid(context));
    }

    public static String g(Context context) {
        if (!TextUtils.isEmpty(f148743g)) {
            return f148743g;
        }
        return Util.getMD5String(Util.getDuid(context));
    }

    public static String h(Context context) {
        ApplicationInfo applicationInfo;
        CharSequence charSequence;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            charSequence = applicationInfo.loadLabel(packageManager);
        } else {
            charSequence = "can't find app name";
        }
        try {
            return URLEncoder.encode(charSequence.toString(), "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static int j(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            return deviceConfigurationInfo.reqGlEsVersion;
        }
        return 65537;
    }

    public static String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(str);
    }

    public static String b() {
        if (f148740d == null) {
            f148740d = "undefined";
        }
        return f148740d;
    }

    public static String c() {
        if (f148741e == null) {
            f148741e = DeviceInfoMonitor.getModel();
        }
        return f148741e;
    }

    public static String a() {
        if (f148742f == null) {
            f148742f = Util.getMD5String(Util.getUUID());
        }
        return f148742f;
    }

    public static void a(String str, String str2) {
        if ("device_id".equals(str)) {
            f148743g = str2;
        }
    }

    private static boolean a(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        return f17 >= ((float) i16) && f17 <= ((float) (view.getMeasuredHeight() + i16)) && f16 >= ((float) i3) && f16 <= ((float) (view.getMeasuredWidth() + i3));
    }

    public static Rect a(View view) {
        if (view == null) {
            return new Rect();
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        return new Rect(i3, i16, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i16);
    }
}
