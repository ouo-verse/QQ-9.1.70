package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UIUtil {
    private static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        if (isBackground(context)) {
            HMSLog.i("UIUtil", "isBackground" + isBackground(context));
            return null;
        }
        if (activity == null) {
            HMSLog.i("UIUtil", "activity is null");
            return ActivityMgr.INST.getCurrentActivity();
        }
        if (activity.isFinishing()) {
            HMSLog.i("UIUtil", "activity isFinishing is " + activity.isFinishing());
            return ActivityMgr.INST.getCurrentActivity();
        }
        return activity;
    }

    public static int getDialogThemeId(Activity activity) {
        if (a(activity) != 0) {
            return 0;
        }
        if (activity == null || (activity.getResources().getConfiguration().uiMode & 48) != 32) {
            return 3;
        }
        return 2;
    }

    public static String getProcessName(Context context, int i3) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i3) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static boolean isActivityFullscreen(Activity activity) {
        if ((activity.getWindow().getAttributes().flags & 1024) == 1024) {
            return true;
        }
        return false;
    }

    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z16;
        if (context == null) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (activityManager == null || keyguardManager == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null) {
            return true;
        }
        String processName = getProcessName(context, Process.myPid());
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (TextUtils.equals(runningAppProcessInfo.processName, processName)) {
                HMSLog.i("UIUtil", "appProcess.importance is " + runningAppProcessInfo.importance);
                if (runningAppProcessInfo.importance == 100) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean isKeyguardLocked = keyguardManager.isKeyguardLocked();
                HMSLog.i("UIUtil", "isForground is " + z16 + "***  isLockedState is " + isKeyguardLocked);
                if (!z16 || isKeyguardLocked) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static Intent modifyIntentBehaviorsSafe(Intent intent) {
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action) || "android.media.action.IMAGE_CAPTURE".equals(action) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(action) || "android.media.action.VIDEO_CAPTURE".equals(action)) {
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        }
        intent.setFlags(intent.getFlags() & (-129) & (-65) & (-2) & (-3));
        return intent;
    }
}
