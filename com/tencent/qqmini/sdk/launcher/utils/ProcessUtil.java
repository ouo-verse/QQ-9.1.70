package com.tencent.qqmini.sdk.launcher.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes23.dex */
public class ProcessUtil {
    private static final String TAG = "ProcessNameUtil";

    public static String getProcessName(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processNameFromRunningProcess = processNameFromRunningProcess(context);
        if (!TextUtils.isEmpty(processNameFromRunningProcess)) {
            return processNameFromRunningProcess;
        }
        String processNameFromLinuxFile = processNameFromLinuxFile(Process.myPid());
        if (!TextUtils.isEmpty(processNameFromLinuxFile)) {
            return processNameFromLinuxFile;
        }
        String processNameFromReflection = processNameFromReflection();
        if (!TextUtils.isEmpty(processNameFromReflection)) {
            return processNameFromReflection;
        }
        QMLog.e(TAG, "WTF, process name is null");
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x003f -> B:20:0x0055). Please report as a decompilation issue!!! */
    public static String getSimpleProcessName() {
        FileInputStream fileInputStream;
        Throwable th5;
        String str;
        String str2 = ":main";
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i3 = 0;
                    while (true) {
                        int read = fileInputStream.read();
                        if (read <= 0 || i3 >= 256) {
                            break;
                        }
                        bArr[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 <= 0) {
                        str = ":main";
                    } else {
                        str = new String(bArr, 0, i3, "UTF-8");
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                }
            } catch (Throwable th7) {
                fileInputStream = null;
                th5 = th7;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            int indexOf = str.indexOf(":");
            if (indexOf > 0) {
                str2 = str.substring(indexOf);
            }
            fileInputStream.close();
        } catch (Throwable th8) {
            String str3 = str;
            th5 = th8;
            str2 = str3;
            try {
                th5.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str2;
            } catch (Throwable th9) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th9;
            }
        }
        return str2;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x009e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:159), block:B:31:0x009e */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String processNameFromLinuxFile(int i3) {
        BufferedReader bufferedReader;
        Exception e16;
        BufferedReader bufferedReader2;
        String str;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i3 + "/cmdline"), "iso-8859-1"));
            } catch (Exception e17) {
                bufferedReader = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedReader3 != null) {
                }
                throw th;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb5.append((char) read);
                }
                sb5.trimToSize();
                str = sb5.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e18) {
                    QMLog.e(TAG, "Failed to close reader", e18);
                }
            } catch (Exception e19) {
                e16 = e19;
                QMLog.e(TAG, "Failed to read /proc/" + i3 + "/cmdline", e16);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e26) {
                        QMLog.e(TAG, "Failed to close reader", e26);
                    }
                }
                str = "";
                QMLog.d(TAG, "read /proc/self/cmdline: " + str + " for pid: " + i3);
                return str;
            }
            QMLog.d(TAG, "read /proc/self/cmdline: " + str + " for pid: " + i3);
            return str;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader3 = bufferedReader2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e27) {
                    QMLog.e(TAG, "Failed to close reader", e27);
                }
            }
            throw th;
        }
    }

    private static String processNameFromReflection() {
        try {
            String str = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
            QMLog.d(TAG, "Get process name: " + str + " by reflection");
            return str;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getProcessName exception!", th5);
            return null;
        }
    }

    private static String processNameFromRunningProcess(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    QMLog.d(TAG, "Loop running process matched process name: " + runningAppProcessInfo.processName + " for pid: " + myPid);
                    return runningAppProcessInfo.processName;
                }
            }
            QMLog.e(TAG, "Failed to get process name, running app processes: " + runningAppProcesses);
            return null;
        } catch (Throwable th5) {
            QMLog.e(TAG, "getProcessName exception!", th5);
            return null;
        }
    }
}
