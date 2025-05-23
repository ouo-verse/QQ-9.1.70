package com.tencent.matrix.backtrace;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f151450a;

    public static synchronized String a(Context context) {
        String str;
        synchronized (a.class) {
            if (f151450a == null) {
                f151450a = b(context, Process.myPid());
            }
            str = f151450a;
        }
        return str;
    }

    private static String b(Context context, int i3) {
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

    public static boolean c(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }
}
