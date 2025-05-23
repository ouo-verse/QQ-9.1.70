package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    public static int a(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(Context context, String str) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            componentName = runningTasks.get(0).topActivity;
            return componentName.getPackageName().equalsIgnoreCase(str);
        }
        return false;
    }
}
