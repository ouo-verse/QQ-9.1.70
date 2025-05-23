package com.tencent.qqperf.crashdefend.report;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ReportSaveInfoHelper {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f363092a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f363096a = "unknown_device_model";

        /* renamed from: b, reason: collision with root package name */
        String f363097b = "unknown_device_rom";

        /* renamed from: c, reason: collision with root package name */
        String f363098c = "unknown";

        /* renamed from: d, reason: collision with root package name */
        String f363099d = "unknown_device_id";

        public String a() {
            return this.f363096a;
        }

        public String b() {
            return this.f363097b;
        }

        public String c() {
            return this.f363099d;
        }

        public String d() {
            return this.f363098c;
        }

        public String toString() {
            return "BaseReportSaveInfo{, deviceModel='" + this.f363096a + "', deviceRom='" + this.f363097b + "', uin='" + this.f363098c + "', Qimei='" + this.f363099d + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static volatile a f363100a = new a();
    }

    private static String d(String str, String str2) {
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    public static a e() {
        return b.f363100a;
    }

    public static void f(final Context context) {
        if (f363092a) {
            return;
        }
        try {
            a e16 = e();
            String str = Build.DISPLAY;
            if (!TextUtils.isEmpty(str)) {
                e16.f363097b = str;
            }
            new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ReportSaveInfoHelper.h(context);
                    ReportSaveInfoHelper.f363092a = true;
                }
            }, "CrashDefendLoad").start();
        } catch (Throwable th5) {
            wy3.c.d("CrashDefendManager_ReportSaveInfoHelper", "initInfo failed", th5);
        }
    }

    public static void g(Context context) {
        if (f363092a) {
            return;
        }
        try {
            a e16 = e();
            String str = Build.DISPLAY;
            if (!TextUtils.isEmpty(str)) {
                e16.f363097b = str;
            }
            h(context);
            f363092a = true;
        } catch (Throwable th5) {
            wy3.c.d("CrashDefendManager_ReportSaveInfoHelper", "initInfo failed", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Context context) {
        a e16 = e();
        List<String> i3 = i(context);
        if (i3 == null) {
            wy3.c.c("CrashDefendManager_ReportSaveInfoHelper", "readInfoFromFile failed!");
            return;
        }
        for (String str : i3) {
            String d16 = d(str, "U_");
            String d17 = d(str, "Q_I__I_");
            String d18 = d(str, "M_");
            if (!com.tencent.mobileqq.qqperftool.common.f.a(d16)) {
                e16.f363098c = d16;
            } else if (!com.tencent.mobileqq.qqperftool.common.f.a(d17)) {
                e16.f363099d = d17;
            } else if (!com.tencent.mobileqq.qqperftool.common.f.a(d18)) {
                e16.f363096a = d18;
            }
        }
        wy3.c.g("CrashDefendManager_ReportSaveInfoHelper", "initInfo end. info is " + e16.toString());
    }

    private static synchronized List<String> i(Context context) {
        synchronized (ReportSaveInfoHelper.class) {
            if (context == null) {
                wy3.c.c("CrashDefendManager_ReportSaveInfoHelper", "readInfoFromFile failed");
                return null;
            }
            File b16 = wy3.d.c().b(context, "CD/RP_I/");
            if (b16 != null && b16.exists()) {
                ArrayList arrayList = new ArrayList();
                try {
                    File[] listFiles = b16.listFiles();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            arrayList.add(file.getName());
                        }
                    }
                    return arrayList;
                } catch (Throwable th5) {
                    try {
                        wy3.c.d("CrashDefendManager_ReportSaveInfoHelper", "readInfoFromFile failed!", th5);
                        return arrayList;
                    } catch (Throwable unused) {
                        return arrayList;
                    }
                }
            }
            wy3.c.g("CrashDefendManager_ReportSaveInfoHelper", "readInfoFromFile dir is invalied");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context) {
        String str;
        String str2;
        synchronized (ReportSaveInfoHelper.class) {
            if (context == null) {
                wy3.b.a("CrashDefendManager_ReportSaveInfoHelper", "saveSwitchToFile failed");
                return;
            }
            File b16 = wy3.d.c().b(context, "CD/RP_I/");
            if (b16 != null && b16.exists()) {
                a e16 = e();
                boolean z16 = true;
                try {
                    File[] listFiles = b16.listFiles();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            file.delete();
                        }
                    }
                    if (!e16.f363098c.equalsIgnoreCase("unknown")) {
                        z16 = true & new File(b16.getAbsolutePath(), "U_" + e16.f363098c).createNewFile();
                    }
                    if (!e16.f363099d.equalsIgnoreCase("unknown_device_id")) {
                        z16 &= new File(b16.getAbsolutePath(), "Q_I__I_" + e16.f363099d).createNewFile();
                    }
                    if (!e16.f363096a.equalsIgnoreCase("unknown_device_model")) {
                        z16 &= new File(b16.getAbsolutePath(), "M_" + e16.f363096a).createNewFile();
                    }
                    str = "CrashDefendManager_ReportSaveInfoHelper";
                    str2 = "saveSwitchToFile end result is " + z16;
                } catch (Throwable th5) {
                    try {
                        wy3.c.d("CrashDefendManager_ReportSaveInfoHelper", "saveSwitchToFile failed!", th5);
                        str = "CrashDefendManager_ReportSaveInfoHelper";
                        str2 = "saveSwitchToFile end result is false";
                    } catch (Throwable th6) {
                        wy3.c.g("CrashDefendManager_ReportSaveInfoHelper", "saveSwitchToFile end result is " + z16);
                        throw th6;
                    }
                }
                wy3.c.g(str, str2);
                return;
            }
            wy3.c.g("CrashDefendManager_ReportSaveInfoHelper", "saveInfoToFile dir is invalied");
        }
    }

    public static void k(final Context context, String str, String str2, String str3) {
        a e16 = e();
        e16.f363096a = str;
        e16.f363099d = str2;
        e16.f363098c = str3;
        new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper.2
            @Override // java.lang.Runnable
            public void run() {
                ReportSaveInfoHelper.j(context);
            }
        }, "CrashDefendSave").start();
    }

    public static void l(final Context context, String str) {
        e().f363098c = str;
        new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.report.ReportSaveInfoHelper.3
            @Override // java.lang.Runnable
            public void run() {
                ReportSaveInfoHelper.j(context);
            }
        }, "CrashDefendSave").start();
    }
}
