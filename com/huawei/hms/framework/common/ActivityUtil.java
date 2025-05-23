package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ActivityUtil {
    private static final String TAG = "ActivityUtil";

    public static PendingIntent getActivities(Context context, int i3, Intent[] intentArr, int i16) {
        if (context == null) {
            Logger.w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i3, intentArr, i16);
        } catch (RuntimeException e16) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e16);
            return null;
        }
    }

    public static boolean isForeground(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> list;
        if (context != null && (activityManager = (ActivityManager) ContextCompat.getSystemService(context, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null) {
            try {
                list = SystemMethodProxy.getRunningAppProcesses(activityManager);
            } catch (RuntimeException e16) {
                Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", e16);
                list = null;
            }
            if (list != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                    String str = runningAppProcessInfo.processName;
                    if (str != null && str.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                        Logger.v(TAG, "isForeground true");
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
