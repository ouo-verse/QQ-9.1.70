package com.tencent.ams.dsdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DeviceUtils";

    public DeviceUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getAppName(Context context) {
        PackageManager packageManager;
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            return packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (Throwable th5) {
            DLog.e(TAG, "get app name error.", th5);
            return null;
        }
    }

    public static String getAppVersion(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "get app version error.", th5);
        }
        return null;
    }
}
