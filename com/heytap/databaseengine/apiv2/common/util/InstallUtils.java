package com.heytap.databaseengine.apiv2.common.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.heytap.databaseengine.constant.AppType;
import com.heytap.databaseengine.utils.HLog;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class InstallUtils {
    private static final String HEALTH_APP_H5_URL = "https://sport.health.heytapmobi.com/h5/watch-scancode-connect/index.html";
    private static final String HEYTAP_MARKET_PACKAGENAME = "com.heytap.market";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String OPPO_MARKET_PACKAGENAME = "com.oppo.market";
    private static final String ROM_EMUI = "EMUI";
    private static final String ROM_FLYME = "FLYME";
    private static final String ROM_MIUI = "MIUI";
    private static final String ROM_OPPO = "OPPO";
    private static final String ROM_SMARTISAN = "SMARTISAN";
    private static final String ROM_VIVO = "VIVO";
    private static final String TAG = "InstallUtils";
    private static String sName;

    public static void DownloadApp(Activity activity) {
        if (activity == null) {
            return;
        }
        if (isOPPO() && isAppStoreInstalled(activity.getApplicationContext())) {
            openAppStore(activity.getApplicationContext(), AppType.HEALTH_PACKAGE_NAME);
        } else {
            openAppDownloadPageInBrower(activity.getApplicationContext(), AppType.HEALTH_PACKAGE_NAME);
        }
    }

    private static boolean check(String str) {
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        if (!TextUtils.isEmpty(getProp(KEY_VERSION_MIUI))) {
            sName = ROM_MIUI;
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_EMUI))) {
            sName = ROM_EMUI;
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_OPPO))) {
            sName = "OPPO";
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_VIVO))) {
            sName = "VIVO";
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_SMARTISAN))) {
            sName = ROM_SMARTISAN;
        } else if (Build.DISPLAY.toUpperCase().contains(ROM_FLYME)) {
            sName = ROM_FLYME;
        } else {
            sName = Build.MANUFACTURER.toUpperCase();
        }
        return sName.equals(str);
    }

    @SuppressLint({"PrivateApi"})
    private static String getProp(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class).invoke(null, str);
        } catch (Exception e16) {
            HLog.e(TAG, "Unable to read prop " + str + "," + e16);
            return null;
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                context.getApplicationContext().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException e16) {
                HLog.e(TAG, "Do not install Health app. e: " + e16.getMessage());
            }
        }
        return false;
    }

    private static boolean isAppStoreInstalled(Context context) {
        if (!isAppInstalled(context, HEYTAP_MARKET_PACKAGENAME) && !isAppInstalled(context, OPPO_MARKET_PACKAGENAME)) {
            return false;
        }
        return true;
    }

    private static synchronized boolean isOPPO() {
        boolean check;
        synchronized (InstallUtils.class) {
            check = check("OPPO");
        }
        return check;
    }

    private static void openAppDownloadPageInBrower(Context context, String str) {
        HLog.d(TAG, "openAppDownloadPageInBrower: " + str);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(HEALTH_APP_H5_URL));
        intent.addFlags(268435456);
        context.getApplicationContext().startActivity(intent);
    }

    private static void openAppStore(Context context, String str) {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        HLog.d(TAG, "openAppStore: " + str);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("market://details?id=" + str + "&caller=" + context.getPackageName() + "&atd=true&style=1"));
        intent.addFlags(268435456);
        PackageManager packageManager = context.getPackageManager();
        try {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, OPPO_MARKET_PACKAGENAME, 0);
                if (packageInfo != null && (applicationInfo2 = packageInfo.applicationInfo) != null && applicationInfo2.enabled) {
                    intent.setPackage(OPPO_MARKET_PACKAGENAME);
                }
            } catch (Throwable th5) {
                HLog.e(TAG, "openAppStore e = " + th5.getMessage());
            }
        } catch (Throwable unused) {
            PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, HEYTAP_MARKET_PACKAGENAME, 0);
            if (packageInfo2 != null && (applicationInfo = packageInfo2.applicationInfo) != null && applicationInfo.enabled) {
                intent.setPackage(HEYTAP_MARKET_PACKAGENAME);
            }
        }
        context.startActivity(intent);
    }
}
