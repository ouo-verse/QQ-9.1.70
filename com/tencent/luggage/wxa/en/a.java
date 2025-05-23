package com.tencent.luggage.wxa.en;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static int a(Context context, String str) {
        if (context != null && str != null && str.length() != 0) {
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                    if (str.equals(runningAppProcessInfo.processName)) {
                        return runningAppProcessInfo.pid;
                    }
                }
            } catch (Exception e16) {
                w.a("MicroMsg.ProcessOperator", e16, "", new Object[0]);
            }
        }
        return 0;
    }

    public static boolean b(Context context, String str) {
        int a16 = a(context, str);
        if (a16 != 0) {
            try {
                SystemMethodProxy.killProcess(a16);
                return true;
            } catch (Throwable th5) {
                w.b("MicroMsg.ProcessOperator", "killProcess, process[%s] pid[%d], e=%s", str, Integer.valueOf(a16), th5);
            }
        }
        return false;
    }
}
