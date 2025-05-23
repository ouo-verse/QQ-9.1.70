package com.tencent.upgrade.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses == null) {
            return true;
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            d.a("ProcessUtil", "processName: " + runningAppProcessInfo.processName + " processId:" + runningAppProcessInfo.pid);
            if (myPid == runningAppProcessInfo.pid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return context.getPackageName().equals(str);
    }
}
