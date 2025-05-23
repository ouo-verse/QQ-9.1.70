package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class PackageUtil {
    private static final String BIG_BROTHER_SOURCE_KEY = "big_brother_source_key";
    public static final int CALLBACK_DEFAULT = 0;
    private static final String CURRENT_UIN = "current_uin";
    public static final String KEY_CALLBACK_ID = "key_callback_id";
    private static final String TAG = "PackageUtil";

    public static String checkAppInstalled(Context context, String str) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str.trim(), 0);
            if (packageInfo == null) {
                return "0";
            }
            return packageInfo.versionName;
        } catch (Exception unused) {
            return "0";
        }
    }

    public static String checkAppInstalledBatch(Context context, String str) {
        if (str == null) {
            return "0";
        }
        PackageManager packageManager = context.getPackageManager();
        String[] split = str.split("\\|");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 != 0) {
                stringBuffer.append("|");
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, split[i3].trim(), 0);
                if (packageInfo == null) {
                    stringBuffer.append(0);
                } else {
                    stringBuffer.append(packageInfo.versionName);
                }
            } catch (Exception unused) {
                stringBuffer.append(0);
            }
        }
        return stringBuffer.toString();
    }

    public static String getAppsVerionCodeBatch(Context context, String str) {
        if (str == null) {
            return "0";
        }
        PackageManager packageManager = context.getPackageManager();
        String[] split = str.split("\\|");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 != 0) {
                stringBuffer.append("|");
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, split[i3].trim(), 0);
                if (packageInfo == null) {
                    stringBuffer.append(0);
                } else {
                    stringBuffer.append(packageInfo.versionCode);
                }
            } catch (Exception unused) {
                stringBuffer.append(0);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str.trim(), 0) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String isAppInstalledBatch(Context context, String str) {
        if (str == null) {
            return "0";
        }
        PackageManager packageManager = context.getPackageManager();
        String[] split = str.split("\\|");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < split.length; i3++) {
            if (i3 != 0) {
                stringBuffer.append("|");
            }
            try {
                if (InstalledAppListMonitor.getPackageInfo(packageManager, split[i3].trim(), 0) == null) {
                    stringBuffer.append(0);
                } else {
                    stringBuffer.append(1);
                }
            } catch (Exception unused) {
                stringBuffer.append(0);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean startAppWithPkgName(Context context, String str, String str2) {
        return startAppWithPkgName(context, str, str2, null, 0);
    }

    public static boolean verifyInstalledApp(Context context, String str, String str2) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
            for (Signature signature : signatureArr) {
                if (str2.equals(MD5.toMD5(signature.toByteArray()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startAppWithPkgName(Context context, String str, String str2, String str3, int i3) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<--startAppWithPkgName pkgName=" + str + ",openid=" + str2);
            }
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str.trim());
            launchIntentForPackage.setFlags(268435456);
            if (str2 != null && str2.length() > 4) {
                launchIntentForPackage.putExtra(CURRENT_UIN, str2);
            }
            launchIntentForPackage.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qq_m");
            launchIntentForPackage.putExtra(BIG_BROTHER_SOURCE_KEY, str3);
            launchIntentForPackage.putExtra("key_callback_id", i3);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
