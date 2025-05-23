package com.tencent.beacon.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.beacon.a.d.a;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Date;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f77630a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f77631b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static String f77632c = "";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f77633d = false;

    /* renamed from: e, reason: collision with root package name */
    private static String f77634e = null;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f77635f = false;

    /* renamed from: g, reason: collision with root package name */
    private static String f77636g = "";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f77637h = false;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f77638i = false;

    /* renamed from: j, reason: collision with root package name */
    private static int f77639j = -2;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f77640k = true;

    public static String a() {
        if (f77630a == null) {
            f77630a = e();
        }
        return f77630a;
    }

    public static String b() {
        Context b16 = c.c().b();
        if (b16 == null) {
            return null;
        }
        String packageName = b16.getPackageName();
        return TextUtils.isEmpty(packageName) ? "" : packageName;
    }

    public static String c(Context context) {
        return com.tencent.beacon.base.util.a.a();
    }

    public static String d() {
        if (!"".equals(f77632c)) {
            return f77632c;
        }
        if (f77631b == 0) {
            f77631b = Process.myPid();
        }
        f77632c += f77631b + "_";
        String str = f77632c + new Date().getTime();
        f77632c = str;
        return str;
    }

    public static synchronized boolean e(Context context) {
        synchronized (b.class) {
            boolean z16 = false;
            if (context == null) {
                com.tencent.beacon.base.util.c.b("[appInfo] context is null", new Object[0]);
                return false;
            }
            com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
            String string = a16.getString("APPVER_DENGTA", "");
            String a17 = a();
            if (string.isEmpty() || !string.equals(a17)) {
                a.SharedPreferencesEditorC0784a edit = a16.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("APPVER_DENGTA", a17);
                }
                z16 = true;
            }
            return z16;
        }
    }

    public static boolean f(Context context) {
        return a(context, context.getPackageName());
    }

    public static synchronized boolean g() {
        boolean z16;
        synchronized (b.class) {
            com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
            String string = a16.getString("APPKEY_DENGTA", "");
            String e16 = c.c().e();
            z16 = TextUtils.isEmpty(string) || !e16.equals(string);
            a.SharedPreferencesEditorC0784a edit = a16.edit();
            if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("APPKEY_DENGTA", e16);
            }
        }
        return z16;
    }

    private static void h() {
        try {
            com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
            String string = a16.getString("APPVER_DENGTA", "");
            String a17 = a();
            if (!TextUtils.isEmpty(string) && a17.equals(string)) {
                f77635f = false;
            } else {
                f77635f = true;
                a.SharedPreferencesEditorC0784a edit = a16.edit();
                if (com.tencent.beacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                    edit.putString("APPVER_DENGTA", a17);
                }
            }
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.b("[core] app version check fail!", new Object[0]);
            com.tencent.beacon.base.util.c.a(e16);
        }
    }

    public static String c() {
        return f77636g;
    }

    public static void f() {
        h();
    }

    public static boolean a(Context context, String str) {
        if (f77638i) {
            return f77640k;
        }
        if (context != null && str != null && str.trim().length() > 0) {
            if (!com.tencent.beacon.d.b.a().l()) {
                com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", Boolean.FALSE);
                return true;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        for (String str2 : runningAppProcessInfo.pkgList) {
                            if (str.equals(str2)) {
                                f77640k = true;
                                f77638i = true;
                                return true;
                            }
                        }
                    }
                }
                f77640k = false;
                f77638i = true;
                return false;
            }
            com.tencent.beacon.base.util.c.e("[appInfo] no running proc", new Object[0]);
        }
        return false;
    }

    public static int b(Context context) {
        if (f77637h) {
            return f77639j;
        }
        if (f77631b == 0) {
            f77631b = Process.myPid();
        }
        if (!com.tencent.beacon.d.b.a().l()) {
            com.tencent.beacon.base.util.c.a("[DeviceInfo] current collect Process Info be refused! isCollect Process Info: %s", Boolean.FALSE);
            return -2;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager != null && SystemMethodProxy.getRunningAppProcesses(activityManager) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses(activityManager)) {
                if (runningAppProcessInfo.pid == f77631b) {
                    int i3 = runningAppProcessInfo.importance;
                    f77639j = i3;
                    f77637h = true;
                    return i3;
                }
            }
        }
        f77639j = 0;
        f77637h = true;
        return 0;
    }

    public static boolean d(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.a(e16);
            return false;
        }
    }

    public static boolean g(Context context) {
        if (context == null) {
            return true;
        }
        String c16 = c(context);
        return TextUtils.isEmpty(c16) || c16.equals(context.getPackageName());
    }

    public static synchronized String e() {
        synchronized (b.class) {
            String b16 = b();
            if (TextUtils.isEmpty(b16)) {
                return null;
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(c.c().b().getPackageManager(), b16, 0);
                String str = packageInfo.versionName;
                int i3 = packageInfo.versionCode;
                if (str != null && str.trim().length() > 0) {
                    String replace = str.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C");
                    int i16 = 0;
                    for (char c16 : replace.toCharArray()) {
                        if (c16 == '.') {
                            i16++;
                        }
                    }
                    if (i16 < 3) {
                        com.tencent.beacon.base.util.c.a("[appInfo] add versionCode: %s", Integer.valueOf(i3));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(replace);
                        sb5.append(".");
                        sb5.append(i3);
                        replace = sb5.toString();
                    }
                    com.tencent.beacon.base.util.c.a("[appInfo] final Version: %s", replace);
                    return replace;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("");
                sb6.append(i3);
                return sb6.toString();
            } catch (Throwable th5) {
                com.tencent.beacon.base.util.c.a(th5);
                com.tencent.beacon.base.util.c.b(th5.toString(), new Object[0]);
                return "";
            }
        }
    }

    public static synchronized String a(Context context) {
        String str;
        synchronized (b.class) {
            if (TextUtils.isEmpty(f77634e)) {
                String str2 = "on_app_first_install_time_" + c(context);
                com.tencent.beacon.a.d.a a16 = com.tencent.beacon.a.d.a.a();
                long j3 = a16.getLong(str2, 0L);
                if (j3 == 0) {
                    j3 = new Date().getTime();
                    com.tencent.beacon.a.b.a.a().a(new a(a16, str2, j3));
                }
                String valueOf = String.valueOf(j3);
                f77634e = valueOf;
                com.tencent.beacon.base.util.c.a("[appInfo] process: %s, getAppFirstInstallTime: %s", str2, valueOf);
            }
            com.tencent.beacon.base.util.c.a("[appInfo] getAppFirstInstallTime: %s", f77634e);
            str = f77634e;
        }
        return str;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Long.parseLong(str) > 10000) {
                    f77636g = str;
                    return;
                }
                return;
            } catch (Exception unused) {
                com.tencent.beacon.base.util.c.e("[appInfo] set qq is not available !", new Object[0]);
                return;
            }
        }
        com.tencent.beacon.base.util.c.e("[appInfo] set qq is null !", new Object[0]);
    }
}
