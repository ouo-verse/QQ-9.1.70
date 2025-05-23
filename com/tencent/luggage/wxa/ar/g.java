package com.tencent.luggage.wxa.ar;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import android.util.StringBuilderPrinter;
import com.tencent.luggage.wxa.ar.g;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f121636a;

    /* renamed from: b, reason: collision with root package name */
    public static int f121637b;

    /* renamed from: c, reason: collision with root package name */
    public static int f121638c;

    /* renamed from: d, reason: collision with root package name */
    public static final d f121639d = new d(new Callable() { // from class: b21.a
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return g.c();
        }
    });

    public static int a() {
        if (f121636a <= 0) {
            int d16 = d();
            if (d16 > 0) {
                f121636a = d16;
                return d16;
            }
            int e16 = e();
            if (e16 > 0) {
                f121636a = e16;
                return e16;
            }
        }
        return f121636a;
    }

    public static String b() {
        return (String) f121639d.a();
    }

    public static String c() {
        try {
            Object invoke = Class.forName("android.webkit.WebViewFactory").getMethod("getUpdateService", new Class[0]).invoke(null, new Object[0]);
            Object invoke2 = invoke.getClass().getMethod("waitForAndGetProvider", new Class[0]).invoke(invoke, new Object[0]);
            Field field = Class.forName("android.webkit.WebViewProviderResponse").getField("packageInfo");
            field.setAccessible(true);
            PackageInfo packageInfo = (PackageInfo) field.get(invoke2);
            StringBuilder sb5 = new StringBuilder();
            packageInfo.applicationInfo.dump(new StringBuilderPrinter(sb5), "");
            return sb5.toString();
        } catch (Exception e16) {
            x0.a("ChromiumVersionUtil", "Get SysWebView details failed.", e16);
            return "Get SysWebView details failed." + Log.getStackTraceString(e16);
        }
    }

    public static int d() {
        int a16;
        int i3 = f121638c;
        if (i3 > 0) {
            return i3;
        }
        if (XWalkEnvironment.getApplicationContext() != null) {
            PackageManager packageManager = XWalkEnvironment.getApplicationContext().getPackageManager();
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, "com.android.webview", 0);
                if (packageInfo != null) {
                    int a17 = a(packageInfo.versionName);
                    if (a17 > 0) {
                        f121638c = a17;
                        x0.d("ChromiumVersionUtil", "getVersionByPackageInfo, version:" + a17 + ", packageName:com.android.webview");
                        return f121638c;
                    }
                } else {
                    PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, "com.google.android.webview", 0);
                    if (packageInfo2 != null && (a16 = a(packageInfo2.versionName)) > 0) {
                        f121638c = a16;
                        x0.d("ChromiumVersionUtil", "getVersionByPackageInfo, version:" + a16 + ", packageName:com.google.android.webview");
                        return f121638c;
                    }
                }
            } catch (Throwable th5) {
                x0.f("ChromiumVersionUtil", "getVersionByPackageInfo failed, error:" + th5);
            }
        } else {
            x0.d("ChromiumVersionUtil", "getVersionByPackageInfo, invalid context");
        }
        return 0;
    }

    public static int e() {
        int a16;
        int i3 = f121637b;
        if (i3 > 0) {
            return i3;
        }
        try {
        } catch (Throwable th5) {
            x0.a("ChromiumVersionUtil", "getVersionByUserAgent failed, error:", th5);
        }
        if (!f()) {
            x0.c("ChromiumVersionUtil", "getVersionByUserAgent NOT IN UI THREAD");
            return 0;
        }
        String userAgentString = new QmWebview(XWalkEnvironment.getApplicationContext()).getSettings().getUserAgentString();
        if (userAgentString != null) {
            String[] split = userAgentString.split("Chrome/");
            if (split.length != 0 && ((split.length != 1 || split[0].length() != userAgentString.length()) && (a16 = a(split[1])) > 0)) {
                x0.d("ChromiumVersionUtil", "getVersionByUserAgent, version:" + a16);
                f121637b = a16;
                return a16;
            }
        }
        return 0;
    }

    public static boolean f() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static int g() {
        int d16;
        if (f121636a <= 0 && (d16 = d()) > 0) {
            f121636a = d16;
            return d16;
        }
        return f121636a;
    }

    public static int a(String str) {
        if (str != null && !str.isEmpty()) {
            x0.d("ChromiumVersionUtil", "getVersionFromVersionName, versionName:" + str);
            try {
                return Integer.parseInt(str.split("\\.")[0]);
            } catch (Throwable th5) {
                x0.a("ChromiumVersionUtil", "getVersionFromVersionName failed, versionName:" + str + ", error:", th5);
            }
        }
        return 0;
    }
}
