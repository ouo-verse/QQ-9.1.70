package com.tencent.upgrade.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.upgrade.core.j;
import java.io.File;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a() {
        try {
            Context i3 = j.l().i();
            String str = InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).applicationInfo.publicSourceDir;
            d.a("AppInfoUtil", "calculateCurrentApkMd5 current apk path = " + str);
            if (h.c(str)) {
                return "";
            }
            return e.a(new File(str));
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String c() {
        Bundle bundle;
        Context i3 = j.l().i();
        try {
            ApplicationInfo applicationInfo = i3.getPackageManager().getApplicationInfo(i3.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return "null";
            }
            return bundle.getString("channelName");
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "null";
        }
    }

    public static String d(Context context, int i3, int i16, String str) {
        String str2 = "gray_sdk_md5_" + i3 + "_" + str + "_" + i16;
        com.tencent.upgrade.storage.b bVar = new com.tencent.upgrade.storage.b(str2, "", j.l().n());
        String str3 = (String) bVar.a();
        if (!TextUtils.isEmpty(str3)) {
            d.a("AppInfoUtil", "getCurrentApkMd5 from cache");
        } else {
            str3 = a();
            bVar.b(str3);
            d.a("AppInfoUtil", "getCurrentApkMd5 by calcu");
        }
        d.a("AppInfoUtil", "getCurrentApkMd5 versionCode = " + i3 + ",buildNo = " + i16 + ",md5Key = " + str2 + ",md5Value = " + str3);
        return str3;
    }

    public static long e() {
        long longVersionCode;
        Context i3 = j.l().i();
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                longVersionCode = InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).getLongVersionCode();
                return longVersionCode;
            } catch (Exception | NoSuchMethodError e16) {
                e16.printStackTrace();
                return -1L;
            }
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).versionCode;
        } catch (Exception e17) {
            e17.printStackTrace();
            return -1L;
        }
    }

    public static String f() {
        try {
            Context i3 = j.l().i();
            return InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String g() {
        Context i3 = j.l().i();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).packageName;
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(i3.getPackageManager(), i3.getPackageName(), 0).packageName;
        } catch (Exception | NoSuchMethodError e17) {
            e17.printStackTrace();
            return "";
        }
    }
}
