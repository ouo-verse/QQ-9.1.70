package com.tencent.luggage.wxa.ar;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.xweb.XWebSdk;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e0 {
    public static String a() {
        Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        String str = invoke instanceof String ? (String) invoke : null;
        x0.d("ProcessUtil", "getCurrentProcessNameByActivityThread, processName:" + invoke);
        return str;
    }

    public static void b(Context context) {
        String str;
        x0.d("ProcessUtil", "killAllProcess, start");
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid && ((str = runningAppProcessInfo.processName) == null || !str.contains("com.tencent.mm") || str.contains("tools") || str.contains("appbrand") || str.contains(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT))) {
                x0.d("ProcessUtil", "killAllProcess, processName:" + str + ", pid:" + runningAppProcessInfo.pid);
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
            }
        }
        x0.d("ProcessUtil", "killAllProcess, kill this process, pid:" + myPid);
        SystemMethodProxy.killProcess(myPid);
    }

    public static void c(Context context) {
        String str;
        x0.d("ProcessUtil", "killGpuProcess, start");
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        boolean z16 = false;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid && (str = runningAppProcessInfo.processName) != null && str.contains("xweb_privileged_process")) {
                x0.d("ProcessUtil", "killGpuProcess, processName:" + str + ", pid:" + runningAppProcessInfo.pid);
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                z16 = true;
            }
        }
        if (!z16) {
            x0.d("ProcessUtil", "killGpuProcess, try force kill gpu process");
            XWebSdk.forceKillGpuProcess();
        }
    }

    public static void d(Context context) {
        String str;
        x0.d("ProcessUtil", "killRenderProcess, start");
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        boolean z16 = false;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid && (str = runningAppProcessInfo.processName) != null && str.contains("xweb_sandboxed_process")) {
                x0.d("ProcessUtil", "killRenderProcess, processName:" + str + ", pid:" + runningAppProcessInfo.pid);
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                z16 = true;
            }
        }
        if (!z16) {
            x0.d("ProcessUtil", "killRenderProcess, try force kill render process");
            XWebSdk.forceKillRenderProcess();
        }
    }

    public static void e(Context context) {
        String str;
        x0.d("ProcessUtil", "killToolsProcess, start");
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid && (str = runningAppProcessInfo.processName) != null && str.contains("com.tencent.mm") && str.contains("tools")) {
                x0.d("ProcessUtil", "killToolsProcess, processName:" + str + ", pid:" + runningAppProcessInfo.pid);
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static String f(Context context) {
        Object a16;
        if (Build.VERSION.SDK_INT >= 28 && (a16 = h0.a("android.app.Application", "getProcessName")) != null) {
            x0.d("ProcessUtil", "safeGetProcessName, processName:" + a16);
            return a16.toString();
        }
        try {
            return a();
        } catch (Throwable unused) {
            return a(context);
        }
    }

    public static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    x0.d("ProcessUtil", "getProcessNameByPid, processName:" + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }
}
