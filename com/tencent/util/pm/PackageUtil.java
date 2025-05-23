package com.tencent.util.pm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public final class PackageUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String PREFIX__KEY_NAME__GET_INSTALLED_APP_LISt = "bid_";
    private static final String SP_NAME__GET_INSTALLED_APP_LIST = "get_installed_app_list";
    private static final String TAG = "PackageUtil";

    /* loaded from: classes27.dex */
    public interface OnRequestPermissionResultListener {
        void onResult(boolean z16);
    }

    public PackageUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkGetInstalledAppListPermission(Context context, String str) {
        return context.getSharedPreferences(SP_NAME__GET_INSTALLED_APP_LIST, 4).getBoolean(PREFIX__KEY_NAME__GET_INSTALLED_APP_LISt + str, false);
    }

    public static ApplicationInfo getApplicationInfo(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(str, 0);
    }

    @Nullable
    public static String getApplicationName(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getApplicationName: failed. ", e16);
            return null;
        }
    }

    public static PackageInfo getPackageInfo(Context context, String str) throws PackageManager.NameNotFoundException {
        return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
    }

    public static int getVersionCode(Context context, String str) throws PackageManager.NameNotFoundException {
        return getPackageInfo(context, str).versionCode;
    }

    public static boolean isPackageInstalled(Context context, String str) {
        try {
            getPackageInfo(context, str);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
