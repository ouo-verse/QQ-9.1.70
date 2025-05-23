package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {
    public static boolean a(String str, int i3) {
        PackageInfo b16 = b(str);
        return b16 != null && b16.versionCode >= i3;
    }

    public static PackageInfo b(String str) {
        if (TextUtils.isEmpty(str)) {
            r.c("PackageUtils", ">> getInstalledPackageInfo packageName is " + str);
            return null;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            r.c("PackageUtils", ">> getInstalledPackageInfo context is null");
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            r.c("PackageUtils", ">> getInstalledPackageInfo packageManager is null");
            return null;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static List<PackageInfo> c(String str) {
        return null;
    }

    public static boolean d(String str) {
        return a(str, 0);
    }

    public static PackageInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            r.c("PackageUtils", ">> getPackageInfo filePath is " + str);
            return null;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            r.c("PackageUtils", ">> getPackageInfo context is null");
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            r.c("PackageUtils", ">> getPackageInfo packageManager is null");
            return null;
        }
        return packageManager.getPackageArchiveInfo(str, 0);
    }

    public static String a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            r.c("PackageUtils", ">> getAppNameByPackageInfo getAppNameByPackageInfo is null");
            return null;
        }
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            r.c("PackageUtils", ">> getAppNameByPackageInfo context is null");
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            r.c("PackageUtils", ">> getAppNameByPackageInfo packageManager is null");
            return null;
        }
        return packageInfo.applicationInfo.loadLabel(packageManager).toString();
    }
}
