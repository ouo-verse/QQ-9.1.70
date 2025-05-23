package com.tencent.bugly.matrix.backtrace;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/* loaded from: classes5.dex */
public class ProcessUtil {
    private static String sProcessName;

    public static synchronized String getProcessNameByPid(Context context) {
        String str;
        synchronized (ProcessUtil.class) {
            if (sProcessName == null) {
                sProcessName = getProcessNameByPidImpl(context, Process.myPid());
            }
            str = sProcessName;
        }
        return str;
    }

    private static String getProcessNameByPidImpl(Context context, int i3) {
        BufferedInputStream bufferedInputStream;
        int read;
        String str;
        if (context != null && i3 > 0) {
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                    if (runningAppProcessInfo.pid == i3 && (str = runningAppProcessInfo.processName) != null && !str.equals("")) {
                        return runningAppProcessInfo.processName;
                    }
                }
            } catch (Exception unused) {
            }
            byte[] bArr = new byte[128];
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream("/proc/" + i3 + "/cmdline"));
                } catch (Exception unused2) {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    read = bufferedInputStream.read(bArr);
                } catch (Exception unused3) {
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return "";
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
                if (read > 0) {
                    for (int i16 = 0; i16 < read; i16++) {
                        byte b16 = bArr[i16];
                        if (b16 <= 128 && b16 > 0) {
                        }
                        read = i16;
                        break;
                    }
                    String str2 = new String(bArr, 0, read);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused5) {
                    }
                    return str2;
                }
                bufferedInputStream.close();
            } catch (Exception unused6) {
            }
        }
        return "";
    }

    public static boolean isMainProcess(Context context) {
        return context.getPackageName().equalsIgnoreCase(getProcessNameByPid(context));
    }
}
