package com.tencent.qmethod.pandoraex.core.collector.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.core.o;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f344031a = "";

    /* renamed from: b, reason: collision with root package name */
    private static Method f344032b;

    /* renamed from: c, reason: collision with root package name */
    private static String f344033c;

    public static String a() {
        String processName;
        String processName2;
        if (!TextUtils.isEmpty(f344031a)) {
            return f344031a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            f344031a = processName;
            processName2 = Application.getProcessName();
            f344031a = processName2;
            return processName2;
        }
        if (!h()) {
            return f344031a;
        }
        try {
            Object invoke = f344032b.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                f344031a = (String) invoke;
            }
        } catch (Exception e16) {
            o.d("CollectAppInfo.AppUtil", "getCurrentProcessNameByActivityThread error", e16);
        }
        return f344031a;
    }

    private static String b(int i3) {
        FileInputStream fileInputStream;
        int read;
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream("/proc/self/cmdline");
                    try {
                        read = fileInputStream.read(bArr);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream2 = fileInputStream;
                        o.d("CollectAppInfo.AppUtil", "getProcessNameInternal fail.", e);
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

    @SuppressLint({"PrivateApi"})
    private static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (!(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Throwable th5) {
            o.d("CollectAppInfo.AppUtil", "getProcessNameFromAT fail.", th5);
            return null;
        }
    }

    public static String d(Context context) {
        String str = f344033c;
        if (str != null) {
            return str;
        }
        String g16 = g(context);
        f344033c = g16;
        return g16;
    }

    private static String e(Context context, int i3) {
        ActivityManager activityManager;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == i3) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                }
            } catch (Exception e16) {
                o.d("CollectAppInfo.AppUtil", "getProcessNameInternal fail.", e16);
            }
        }
        return "";
    }

    private static String f() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        return null;
    }

    private static String g(Context context) {
        String f16 = f();
        if (!TextUtils.isEmpty(f16)) {
            return f16;
        }
        String c16 = c();
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        int myPid = Process.myPid();
        if (myPid <= 0) {
            return "";
        }
        String b16 = b(myPid);
        if (!TextUtils.isEmpty(b16)) {
            return b16;
        }
        if (context == null) {
            return "";
        }
        return e(context, myPid);
    }

    @SuppressLint({"PrivateApi"})
    private static boolean h() {
        if (f344032b != null) {
            return true;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            f344032b = declaredMethod;
            declaredMethod.setAccessible(true);
            return true;
        } catch (Exception e16) {
            o.d("CollectAppInfo.AppUtil", "initCurrentProcessNameMethod error", e16);
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            o.d("CollectAppInfo.AppUtil", "isApkInDebug error", e16);
            return true;
        }
    }

    public static boolean j(Context context) {
        String str;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
        }
        String d16 = d(context);
        if (d16 == null || d16.length() == 0) {
            d16 = "";
        }
        if (str != null && !str.isEmpty() && str.equals(d16)) {
            return true;
        }
        return false;
    }
}
