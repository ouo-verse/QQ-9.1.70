package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.a;
import com.huawei.hms.base.log.b;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HMSLog {

    /* renamed from: a, reason: collision with root package name */
    private static final b f37630a = new b();

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    public static void d(String str, String str2) {
        f37630a.a(3, str, str2);
    }

    public static void e(String str, String str2) {
        f37630a.a(6, str, str2);
    }

    public static void i(String str, String str2) {
        f37630a.a(4, str, str2);
    }

    public static void init(Context context, int i3, String str) {
        b bVar = f37630a;
        bVar.a(context, i3, str);
        bVar.a(str, "============================================================================\n====== " + a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return f37630a.a(6);
    }

    public static boolean isInfoEnable() {
        return f37630a.a(4);
    }

    public static boolean isWarnEnable() {
        return f37630a.a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z16) throws IllegalArgumentException {
        if (hMSExtLogger != null) {
            a aVar = new a(hMSExtLogger);
            if (z16) {
                f37630a.a(aVar);
                return;
            } else {
                f37630a.a().a(aVar);
                return;
            }
        }
        throw new IllegalArgumentException("extLogger is not able to be null");
    }

    public static void w(String str, String str2) {
        f37630a.a(5, str, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        f37630a.b(6, str, str2, th5);
    }

    public static void e(String str, long j3, String str2) {
        f37630a.a(6, str, "[" + j3 + "] " + str2);
    }

    public static void e(String str, long j3, String str2, Throwable th5) {
        f37630a.b(6, str, "[" + j3 + "] " + str2, th5);
    }
}
