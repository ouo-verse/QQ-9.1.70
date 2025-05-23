package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f36203a = 26;

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e16) {
                c.e("parseInt--NumberFormatException" + e16.getMessage());
            }
        }
        return -1;
    }

    public static int b(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).packageName;
        } catch (Exception e16) {
            c.a(e16);
            return "0";
        }
    }

    public static String d(Context context) {
        try {
            return context.getResources().getString(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e16) {
            c.a(e16);
            return "app";
        }
    }

    public static String a(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "0";
        }
    }

    public static int b(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode;
        } catch (Exception e16) {
            c.b("getVersionCode--Exception:" + e16.getMessage());
            return 0;
        }
    }

    public static String c(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionName;
        } catch (Exception e16) {
            c.b("getVersionName--Exception:" + e16.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String a(int[] iArr) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 : iArr) {
            sb5.append((char) i3);
        }
        return sb5.toString();
    }

    public static boolean a(Context context, String str) {
        try {
            InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            c.e("isExistPackage NameNotFoundException:" + e16.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e16) {
            c.e("isSupportPush NameNotFoundException:" + e16.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }
}
