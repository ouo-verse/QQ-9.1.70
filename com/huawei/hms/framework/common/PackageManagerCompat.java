package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "6.0.2.300";
    private static String sAppVersion = "";

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w(TAG, "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return sAppVersion;
        }
        try {
            sAppVersion = String.valueOf(InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w(TAG, "Failed to get Package managers Package Info");
        }
        return sAppVersion;
    }

    private static Bundle getBundleFromApp(Context context) {
        Bundle bundle = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context == null) {
            return bundle;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return bundle;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle2 = applicationInfo.metaData;
                if (bundle2 != null) {
                    return bundle2;
                }
                return bundle;
            }
            return bundle;
        } catch (PackageManager.NameNotFoundException | RuntimeException e16) {
            Logger.w(TAG, "NameNotFoundException:", e16);
            return bundle;
        }
    }

    private static Bundle getBundleFromKit(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.v(TAG, "the kitContext is null");
            return Bundle.EMPTY;
        }
        if (context.getApplicationInfo() == null) {
            Logger.v(TAG, "the kit applicationInfo is null");
            return Bundle.EMPTY;
        }
        Bundle bundle = context.getApplicationInfo().metaData;
        if (bundle == null) {
            return Bundle.EMPTY;
        }
        return bundle;
    }

    private static Bundle getBundleFromKitOrAPP(Context context) {
        Bundle bundleFromKit = getBundleFromKit(context);
        if (bundleFromKit == null || bundleFromKit.isEmpty()) {
            return getBundleFromApp(context);
        }
        return bundleFromKit;
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle bundleFromApp = getBundleFromApp(context);
        if (bundleFromApp != null) {
            return bundleFromApp.getString(str, str2);
        }
        return str2;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle bundleFromKit = getBundleFromKit(context);
            if (bundleFromKit == null) {
                return str2;
            }
            return bundleFromKit.getString(str, str2);
        } catch (RuntimeException unused) {
            Logger.v(TAG, "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        return getBundleFromKitOrAPP(context).getString(str, str2);
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
        for (String str2 : getBundleFromKitOrAPP(context).keySet()) {
            if (str2.startsWith(str)) {
                String string = bundleFromKitOrAPP.getString(str2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }
}
