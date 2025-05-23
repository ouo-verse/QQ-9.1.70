package com.tencent.hlyyb.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.hlyyb.common.b.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static Context f114320a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f114321b = null;

    /* renamed from: c, reason: collision with root package name */
    public static long f114322c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f114323d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static String f114324e = "3.4.0.16";

    /* renamed from: f, reason: collision with root package name */
    public static Handler f114325f;

    /* renamed from: g, reason: collision with root package name */
    public static Handler f114326g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15096);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static Context a() {
        return f114320a;
    }

    public static int b() {
        return f114323d;
    }

    public static String c() {
        return f114321b;
    }

    public static int d() {
        return (int) (SystemClock.elapsedRealtime() - f114322c);
    }

    public static String e() {
        return f114324e;
    }

    public static Handler f() {
        return f114325f;
    }

    public static Handler g() {
        return f114326g;
    }

    public static void a(int i3, Context context, String str, String str2, String str3) {
        f114322c = SystemClock.elapsedRealtime();
        f114320a = context.getApplicationContext();
        context.getPackageName();
        f114323d = i3;
        b.a(str);
        b.a(str2);
        f114324e = "3.4.0.16";
        f114325f = new Handler(f114320a.getMainLooper());
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            String str4 = packageInfo.versionName;
            packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
        }
        f114321b = b.g();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HalleyTempTaskThread");
        baseHandlerThread.start();
        f114326g = new Handler(baseHandlerThread.getLooper());
        com.tencent.hlyyb.common.a.a.a();
    }
}
