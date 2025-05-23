package com.tencent.qimei.u;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.util.List;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f343382a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile String f343383b;

    /* renamed from: c, reason: collision with root package name */
    public static String f343384c;

    /* renamed from: d, reason: collision with root package name */
    public static String f343385d;

    /* renamed from: e, reason: collision with root package name */
    public static String f343386e;

    /* renamed from: f, reason: collision with root package name */
    public static String f343387f;

    public static synchronized String a() {
        synchronized (a.class) {
            String str = f343387f;
            if (str != null) {
                return str;
            }
            Context e16 = com.tencent.qimei.ap.d.c().e();
            if (e16 == null) {
                return "";
            }
            try {
                String b16 = com.tencent.qimei.f.a.b(e16.getPackageManager().getApplicationInfo(e16.getPackageName(), 0).sourceDir);
                f343387f = b16;
                return b16;
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static synchronized void b(String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(f343382a) && !"0IOS0HZ21B510CEZ".equals(str)) {
                f343382a = str;
            }
        }
    }

    public static String c() {
        String str = f343385d;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
            f343385d = str2;
            return str2;
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
            return "";
        }
    }

    public static String d() {
        String str;
        Context e16 = com.tencent.qimei.ap.d.c().e();
        if (e16 != null) {
            str = e16.getPackageName();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static synchronized String e() {
        synchronized (a.class) {
            String d16 = d();
            if (TextUtils.isEmpty(d16)) {
                return "";
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(com.tencent.qimei.ap.d.c().e().getPackageManager(), d16, 0);
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
                        replace = replace + "." + i3;
                    }
                    return replace;
                }
                return "" + i3;
            } catch (Exception e16) {
                com.tencent.qimei.ad.c.a(e16);
                e16.toString();
                return "";
            }
        }
    }

    public static boolean f() {
        Context e16 = com.tencent.qimei.ap.d.c().e();
        if (e16 != null) {
            String c16 = c();
            if (TextUtils.isEmpty(c16) || c16.equals(e16.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static String a(String str) {
        return new File(b(), str).getAbsolutePath();
    }

    public static synchronized String b() {
        String str;
        String absolutePath;
        synchronized (a.class) {
            if (TextUtils.isEmpty(f343386e)) {
                Context e16 = com.tencent.qimei.ap.d.c().e();
                if (e16 != null) {
                    File file = new File(e16.getFilesDir(), "qm");
                    if (!file.exists() ? file.mkdirs() : true) {
                        absolutePath = file.getAbsolutePath();
                        f343386e = absolutePath;
                    }
                }
                absolutePath = "";
                f343386e = absolutePath;
            }
            str = f343386e;
        }
        return str;
    }

    public static synchronized void c(String str) {
        synchronized (a.class) {
            if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(f343383b)) {
                f343383b = str;
            }
        }
    }

    public static void a(String str, com.tencent.qimei.v.a aVar) {
        if (f()) {
            aVar.a();
        }
    }

    public static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String packageName = context.getPackageName();
        if (packageName == null || packageName.trim().length() <= 0 || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (packageName.equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
