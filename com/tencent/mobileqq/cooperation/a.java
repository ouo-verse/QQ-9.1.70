package com.tencent.mobileqq.cooperation;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public static int a(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String c(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean d(String str, Context context) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(Context context, String str) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            componentName = runningTasks.get(0).topActivity;
            return componentName.getPackageName().equalsIgnoreCase(str);
        }
        return false;
    }
}
