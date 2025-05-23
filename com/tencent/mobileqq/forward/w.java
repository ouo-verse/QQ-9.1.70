package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class w {
    static IPatchRedirector $redirector_;

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
            QLog.e("ForwardSdkUtil", 1, " requestShareMessage net error");
        }
    }

    public static boolean b(Activity activity) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        int i3;
        ComponentName componentName;
        ComponentName componentName2;
        if (activity == null) {
            return false;
        }
        try {
            runningTasks = ((ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        } catch (Exception e16) {
            QLog.e("ForwardSdkUtil", 1, "isRootActivity error ", e16);
        }
        if (runningTasks.size() == 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        i3 = runningTaskInfo.numActivities;
        if (i3 == 1) {
            componentName = runningTaskInfo.topActivity;
            if (componentName != null) {
                componentName2 = runningTaskInfo.topActivity;
                if (TextUtils.equals(componentName2.getClassName(), activity.getClass().getName())) {
                    QLog.i("ForwardSdkUtil", 1, "isRootActivity true");
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void c(Context context, String str) {
    }
}
