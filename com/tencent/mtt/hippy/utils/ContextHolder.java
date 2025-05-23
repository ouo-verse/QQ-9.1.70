package com.tencent.mtt.hippy.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ContextHolder {
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void initAppContext(Context context) {
        if (context != null && sAppContext == null) {
            sAppContext = context.getApplicationContext();
        }
    }

    public static boolean isAppOnBackground() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context = sAppContext;
        if (context == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
            return true;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                if (next.importance == 100) {
                    return false;
                }
            }
        }
        return true;
    }
}
