package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

@MiniKeep
/* loaded from: classes23.dex */
public class ProcessUtil {
    private static final String TAG = "ProcessUtil";
    public static String processName = "";

    public static void exitProcess(IMiniAppContext iMiniAppContext) {
        AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null, null);
        if (iMiniAppContext != null) {
            finishAndRemoveAllTasks(iMiniAppContext.getAttachActivity());
        }
        killProcess(Process.myPid());
    }

    private static boolean finishAndRemoveAllTasks(Activity activity) {
        List<ActivityManager.AppTask> appTasks;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        if (ViewUtils.isActivityInvalid(activity)) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null || (appTasks = activityManager.getAppTasks()) == null) {
                return false;
            }
            for (ActivityManager.AppTask appTask : appTasks) {
                if (appTask != null && appTask.getTaskInfo() != null) {
                    intent = appTask.getTaskInfo().baseIntent;
                    if (intent != null) {
                        intent2 = appTask.getTaskInfo().baseIntent;
                        if (intent2.getComponent() != null) {
                            QMLog.e("miniapp", "will finish and remove task: id=" + appTask.getTaskInfo().id);
                            intent3 = appTask.getTaskInfo().baseIntent;
                            if (!intent3.getComponent().getClassName().equals(activity.getClass().getName())) {
                                intent4 = appTask.getTaskInfo().baseIntent;
                                if (intent4.getComponent().getClassName().equals(activity.getClass().getName())) {
                                }
                            }
                            appTask.finishAndRemoveTask();
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
            return false;
        }
    }

    public static String getCurrentProcessName(Context context) {
        if (TextUtils.isEmpty(processName)) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    processName = runningAppProcessInfo.processName;
                }
            }
        }
        return processName;
    }

    public static boolean isMainProcess(Context context) {
        return context.getPackageName().equals(getCurrentProcessName(context));
    }

    public static void killProcess(int i3) {
        if (isMainProcess(AppLoaderFactory.g().getContext()) && Process.myPid() == i3) {
            QMLog.w(TAG, "killProcess pid is main process, break!");
        } else {
            SystemMethodProxy.killProcess(i3);
        }
    }

    public static void exitProcess(Activity activity) {
        AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null, null);
        finishAndRemoveAllTasks(activity);
        killProcess(Process.myPid());
    }
}
