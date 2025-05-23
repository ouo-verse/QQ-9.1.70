package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* loaded from: classes2.dex */
public class PackageUtils {
    private static final String TAG = "PackageUtils";

    public static String getVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e16) {
            Logger.w(TAG, "", e16);
            return "";
        }
    }
}
