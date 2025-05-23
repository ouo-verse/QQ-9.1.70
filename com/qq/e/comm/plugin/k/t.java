package com.qq.e.comm.plugin.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t {
    public static boolean a(Context context) {
        try {
            int myPid = Process.myPid();
            if (new File("/dev/cpuctl/tasks").exists()) {
                try {
                    return b(myPid);
                } catch (IOException unused) {
                    GDTLogger.d("checkForegroundUseCGroup Exception");
                }
            } else {
                try {
                    return a(myPid);
                } catch (IOException unused2) {
                    GDTLogger.d("checkForegroundUseStat Exception");
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        GDTLogger.e(th5.getMessage());
        return b(context);
    }

    private static boolean b(Context context) {
        if (context != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    String packageName = context.getPackageName();
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.importance == 100 && packageName.equals(runningAppProcessInfo.processName)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return false;
    }

    private static boolean a(int i3) throws IOException {
        String a16 = a(String.format("/proc/%d/stat", Integer.valueOf(i3)));
        GDTLogger.d(String.format("checkForegroundUseStat : stat = %s ", a16));
        if (!TextUtils.isEmpty(a16)) {
            String[] split = a16.split("\\s+");
            if (split == null || split.length <= 40) {
                throw new IOException("Invalid format,no match status");
            }
            return Integer.parseInt(split[40]) == 0;
        }
        throw new IOException("No content");
    }

    private static boolean b(int i3) throws IOException {
        String a16 = a(String.format("/proc/%d/cgroup", Integer.valueOf(i3)));
        GDTLogger.d(String.format("checkForegroundUseCGroup : cgroup = %s ", a16));
        if (TextUtils.isEmpty(a16)) {
            throw new IOException("No content");
        }
        return (a16.contains("bg_non_interactive") || a16.contains("background")) ? false : true;
    }

    private static String a(String str) throws IOException {
        StringBuilder sb5;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            sb5 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), ag.f39619a));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            String str2 = "";
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb5.append(str2);
                sb5.append(readLine);
                str2 = "\n";
            }
            String sb6 = sb5.toString();
            bufferedReader.close();
            return sb6;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }
}
