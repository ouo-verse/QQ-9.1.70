package com.tencent.mobileqq.processkiller;

import android.os.Process;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3) {
        int myPid = Process.myPid();
        BaseApplication context = BaseApplication.getContext();
        String a16 = b.a(context, i3);
        String a17 = b.a(context, myPid);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        int length = stackTrace.length;
        boolean z16 = true;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i16];
            if (stackTraceElement.toString().startsWith(SystemMethodProxy.class.getName() + ".killProcess")) {
                z16 = false;
            } else if (z16) {
                continue;
            } else {
                i17++;
                sb5.append("\n");
                sb5.append(stackTraceElement.toString());
                if (i17 >= 15) {
                    sb5.append("\n");
                    sb5.append("max line count 15 , other stack jump...");
                    break;
                }
            }
            i16++;
        }
        String sb6 = sb5.toString();
        b(a16, a17, sb6);
        QLog.i("ProcessKillManager", 1, "killProcess: " + sb6);
        return true;
    }

    private static void b(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reportUin", MobileQQ.sMobileQQ.getLastLoginUin());
        hashMap.put("killProcessName", str);
        hashMap.put("currentProcessName", str2);
        hashMap.put("invokeStack", str3);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "process_kill_monitor", true, 0L, 0L, hashMap, "", false);
        QLog.e("ProcessKillManager", 1, "reportOnProcessKillInvoke: killProcessName:" + str + " |currentProcessName:" + str2 + " |invokeStack:" + str3);
    }
}
