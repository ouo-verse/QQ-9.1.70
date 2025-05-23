package com.tencent.ads.utility;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ads.AdManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SystemUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f61701a;

    public static String getApkName() {
        return String.valueOf(getPackageName()) + "_" + getAppVersionName();
    }

    public static String getAppName() {
        return String.valueOf(getAppNameLabel()) + " " + getAppVersionName();
    }

    public static String getAppNameLabel() {
        try {
            Context applicationContext = AdManager.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            PackageManager packageManager = applicationContext.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString();
        } catch (Throwable unused) {
            return "QQ";
        }
    }

    public static String getAppVersionName() {
        try {
            Context applicationContext = AdManager.getApplicationContext();
            return InstalledAppListMonitor.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getPackageName() {
        if (f61701a == null) {
            try {
                Context applicationContext = AdManager.getApplicationContext();
                if (applicationContext != null) {
                    f61701a = applicationContext.getPackageName();
                }
            } catch (Throwable unused) {
            }
        }
        if (f61701a == null) {
            f61701a = "";
        }
        return f61701a;
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo[] allNetworkInfo;
        Context applicationContext = AdManager.getApplicationContext();
        if (applicationContext != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
