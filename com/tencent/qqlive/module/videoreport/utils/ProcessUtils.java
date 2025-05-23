package com.tencent.qqlive.module.videoreport.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.Log;
import java.io.FileReader;
import java.util.List;

/* loaded from: classes22.dex */
public class ProcessUtils {
    private static final String TAG = "ProcessUtils";
    private static boolean sEnableCollectProcessName = true;

    private static String getMainProcessName(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName;
    }

    public static String getProcessName(Context context) {
        if (!sEnableCollectProcessName || context == null) {
            return "unknown";
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (list != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e16) {
            Log.d(TAG, "getProcessName error " + list + e16);
        }
        return getProcessName(Process.myPid());
    }

    public static boolean isMainProcess() {
        try {
            Context context = ReportUtils.getContext();
            if (context == null) {
                return true;
            }
            String mainProcessName = getMainProcessName(context);
            String processName = getProcessName(Process.myPid());
            if (mainProcessName == null) {
                return true;
            }
            return mainProcessName.equals(processName);
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    private static boolean isPidOfProcessName(Context context, int i3, String str) {
        if (str == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
            if (runningAppProcessInfo.pid == i3) {
                if (!runningAppProcessInfo.processName.equals(str)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void setCollectProcessName(boolean z16) {
        sEnableCollectProcessName = z16;
    }

    private static String getProcessName(int i3) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/" + i3 + "/cmdline");
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i16 = 0;
            while (i16 < 512 && cArr[i16] != 0) {
                i16++;
            }
            String str = new String(cArr, 0, i16);
            try {
                fileReader.close();
            } catch (Throwable th6) {
                Log.e(TAG, "getProcessName close reader error " + th6);
            }
            return str;
        } catch (Throwable th7) {
            th = th7;
            fileReader2 = fileReader;
            try {
                Log.e(TAG, "getProcessName wrapper throw e" + th);
                return "unknown";
            } finally {
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable th8) {
                        Log.e(TAG, "getProcessName close reader error " + th8);
                    }
                }
            }
        }
    }
}
