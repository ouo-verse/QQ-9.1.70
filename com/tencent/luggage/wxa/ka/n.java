package com.tencent.luggage.wxa.ka;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.FileInputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Context f131857a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f131858b;

    public static com.tencent.luggage.wxa.la.c a() {
        return null;
    }

    public static Context b() {
        com.tencent.luggage.wxa.er.a.a("IPCInvoker not initialize.", (Object) f131857a);
        return f131857a;
    }

    public static String c() {
        if (f131858b == null || f131858b.length() == 0) {
            f131858b = a(f131857a, Process.myPid());
        }
        return f131858b;
    }

    public static d d() {
        return null;
    }

    public static void a(com.tencent.luggage.wxa.la.c cVar) {
    }

    public static void a(Context context) {
        f131857a = context;
    }

    public static boolean a(String str) {
        return str != null && str.equals(c());
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, int i3) {
        FileInputStream fileInputStream;
        int read;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String processName;
        FileInputStream fileInputStream2 = null;
        if (context == null) {
            return null;
        }
        if (Process.myPid() == i3 && Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i3) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        byte[] bArr = new byte[128];
        try {
            try {
                fileInputStream = new FileInputStream("/proc/" + i3 + "/cmdline");
                try {
                    read = fileInputStream.read(bArr);
                } catch (Exception e16) {
                    e = e16;
                    try {
                        com.tencent.luggage.wxa.ta.c.b("IPC.IPCInvokeLogic", "get running process error : %s", Log.getStackTraceString(e));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
        }
        if (read <= 0) {
            fileInputStream.close();
            return null;
        }
        for (int i16 = 0; i16 < read; i16++) {
            byte b16 = bArr[i16];
            if (b16 <= 128 && b16 > 0) {
            }
            read = i16;
            break;
        }
        String str = new String(bArr, 0, read);
        try {
            fileInputStream.close();
        } catch (Exception unused3) {
        }
        return str;
    }
}
