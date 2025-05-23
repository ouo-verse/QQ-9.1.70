package com.tencent.rfix.loader.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rfix.loader.log.RFixLog;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes25.dex */
public class ProcessUtils {
    private static final String PATCH_PROCESS_NAME = ":patch";
    private static final String TAG = "RFix.ProcessUtils";
    private static String mainProcessName;
    private static String processName;

    private static String getDefaultMainProcessName(Context context) {
        String str;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return context.getPackageName();
        }
        return str;
    }

    public static String getProcessName(Context context) {
        String str = processName;
        if (str != null) {
            return str;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    private static String getProcessNameFromAMS(Context context, int i3) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            runningAppProcessInfo = it.next();
                            if (runningAppProcessInfo.pid == i3) {
                                break;
                            }
                        } else {
                            runningAppProcessInfo = null;
                            break;
                        }
                    }
                    if (runningAppProcessInfo != null) {
                        return runningAppProcessInfo.processName;
                    }
                    return "";
                }
                return "";
            } catch (Exception e16) {
                RFixLog.e(TAG, "getProcessNameInternal fail.", e16);
                return "";
            }
        }
        return "";
    }

    @SuppressLint({"PrivateApi"})
    private static String getProcessNameFromActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th5) {
            RFixLog.e(TAG, "getProcessNameFromAT fail.", th5);
            return null;
        }
    }

    private static String getProcessNameFromApplication() {
        String processName2;
        if (Build.VERSION.SDK_INT >= 28) {
            processName2 = Application.getProcessName();
            return processName2;
        }
        return null;
    }

    private static String getProcessNameFromCmdline(int i3) {
        FileInputStream fileInputStream;
        int read;
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream("/proc/" + i3 + "/cmdline");
                    try {
                        read = fileInputStream.read(bArr);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream2 = fileInputStream;
                        RFixLog.e(TAG, "getProcessNameInternal fail.", e);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                            return "";
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
            if (read > 0) {
                for (int i16 = 0; i16 < read; i16++) {
                    byte b16 = bArr[i16];
                    if ((b16 & 255) <= 128 && b16 > 0) {
                    }
                    read = i16;
                    break;
                }
                String str = new String(bArr, 0, read);
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
                return str;
            }
            fileInputStream.close();
            return "";
        } catch (Exception unused3) {
            return "";
        }
    }

    private static String getProcessNameInternal(Context context) {
        String processNameFromApplication = getProcessNameFromApplication();
        if (!TextUtils.isEmpty(processNameFromApplication)) {
            return processNameFromApplication;
        }
        String processNameFromActivityThread = getProcessNameFromActivityThread();
        if (!TextUtils.isEmpty(processNameFromActivityThread)) {
            return processNameFromActivityThread;
        }
        int myPid = Process.myPid();
        if (myPid <= 0) {
            return "";
        }
        String processNameFromCmdline = getProcessNameFromCmdline(myPid);
        if (!TextUtils.isEmpty(processNameFromCmdline)) {
            return processNameFromCmdline;
        }
        if (context == null) {
            return "";
        }
        return getProcessNameFromAMS(context, myPid);
    }

    public static boolean isInMainProcess(Context context) {
        if (TextUtils.isEmpty(mainProcessName)) {
            mainProcessName = getDefaultMainProcessName(context);
        }
        String processName2 = getProcessName(context);
        if (TextUtils.isEmpty(processName2)) {
            processName2 = "";
        }
        if (!TextUtils.isEmpty(mainProcessName) && mainProcessName.equals(processName2)) {
            return true;
        }
        return false;
    }

    public static boolean isInPatchProcess(Context context) {
        return getProcessName(context).endsWith(PATCH_PROCESS_NAME);
    }

    public static boolean isMainProcess(Context context, String str) {
        if (TextUtils.isEmpty(mainProcessName)) {
            mainProcessName = getDefaultMainProcessName(context);
        }
        return TextUtils.equals(mainProcessName, str);
    }

    public static void killProcessExceptMain(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.uid == Process.myUid() && !isMainProcess(context, runningAppProcessInfo.processName)) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
    }

    public static void setMainProcessName(String str) {
        RFixLog.i(TAG, "setMainProcessName oldProcessName=" + mainProcessName + ", newProcessName=" + str);
        mainProcessName = str;
    }
}
