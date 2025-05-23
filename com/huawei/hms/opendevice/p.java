package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static String f37380a;

    public static String a() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        } catch (IOException unused) {
            HMSLog.e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e16) {
            HMSLog.e("CommFun", "get current app processes exception!" + e16.getMessage());
            return "";
        }
    }

    public static boolean b() {
        int i3 = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.d("CommFun", "Emui Api Level:" + i3);
        return i3 > 0;
    }

    public static String c(Context context) {
        String parent;
        Context createDeviceProtectedStorageContext;
        File dataDir;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            dataDir = createDeviceProtectedStorageContext.getDataDir();
            sb5.append(dataDir);
            sb5.append("");
            parent = sb5.toString();
        } else {
            parent = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(parent)) {
            HMSLog.e("CommFun", "get storage root path of the current user failed.");
        }
        return parent;
    }

    public static long d(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    public static boolean e(Context context) {
        if (b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && d(context) < 110001400) {
            return true;
        }
        return false;
    }

    public static String b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                    HMSLog.i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        HMSLog.w("CommFun", "get running app processes null!");
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f37380a)) {
            return f37380a;
        }
        String b16 = b(context);
        f37380a = b16;
        if (!TextUtils.isEmpty(b16)) {
            return f37380a;
        }
        String a16 = a();
        f37380a = a16;
        return a16;
    }
}
