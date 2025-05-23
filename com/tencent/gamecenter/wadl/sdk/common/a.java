package com.tencent.gamecenter.wadl.sdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Process;
import com.tencent.gamecenter.wadl.sdk.InitParam;
import com.tencent.gamecenter.wadl.sdk.common.b.c;
import com.tencent.gamecenter.wadl.sdk.common.b.h;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.IFlowCallback;
import com.tencent.gamecenter.wadl.sdk.downloader.IThreadPool;
import com.tencent.gamecenter.wadl.sdk.downloader.manager.b;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.standard.log.IRLog;
import com.tencent.raft.standard.report.IRReport;
import com.tencent.raft.standard.task.IRTask;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f106978a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f106979b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static String f106980c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f106981d = "null";

    /* renamed from: e, reason: collision with root package name */
    public static String f106982e = "";

    /* renamed from: f, reason: collision with root package name */
    public static int f106983f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static String f106984g = "DefaultSDKVer";

    /* renamed from: h, reason: collision with root package name */
    private static String f106985h = "";

    /* renamed from: i, reason: collision with root package name */
    private static String f106986i = "";

    /* renamed from: j, reason: collision with root package name */
    private static Handler f106987j = null;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f106988k = false;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f106989l = false;

    /* renamed from: m, reason: collision with root package name */
    public static IRReport f106990m = null;

    /* renamed from: n, reason: collision with root package name */
    public static IRLog f106991n = null;

    /* renamed from: o, reason: collision with root package name */
    public static IRTask f106992o = null;

    /* renamed from: p, reason: collision with root package name */
    public static IThreadPool f106993p = null;

    /* renamed from: q, reason: collision with root package name */
    public static IFlowCallback f106994q = null;

    /* renamed from: r, reason: collision with root package name */
    private static int f106995r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static PCDNInitParam f106996s;

    /* compiled from: P */
    /* renamed from: com.tencent.gamecenter.wadl.sdk.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC1121a implements Runnable {
        RunnableC1121a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(a.f106978a.getPackageManager(), a.f106978a.getPackageName(), 0);
                a.f106981d = packageInfo.versionName;
                a.f106983f = packageInfo.versionCode;
                a.f106982e = packageInfo.applicationInfo.loadLabel(a.f106978a.getPackageManager()).toString();
            } catch (Throwable unused) {
            }
            c.g();
        }
    }

    public static Context b() {
        return f106978a;
    }

    public static int c() {
        return f106979b;
    }

    public static String d() {
        return f106980c;
    }

    public static int e() {
        if (b.c().d()) {
            return f106995r + 1;
        }
        return f106995r;
    }

    public static String f() {
        if (!g.e(f106986i)) {
            return f106986i;
        }
        if (!g.e(f106985h) && f106985h.contains(":")) {
            return f106985h.substring(f106985h.indexOf(":") + 1);
        }
        return "";
    }

    public static Handler g() {
        return f106987j;
    }

    public static String h() {
        return f106984g;
    }

    public static boolean i() {
        return f106988k;
    }

    public static void a(InitParam initParam, String str) {
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-SDKBaseInfo", "initSDKBaseInfo,isTestMode:" + f106988k + ",appid:" + initParam.appid);
        f106989l = initParam.maskDeviceInfo;
        f106988k = initParam.isTestMode;
        Process.myPid();
        Context context = initParam.getContext();
        f106978a = context.getApplicationContext();
        f106980c = context.getPackageName();
        f106979b = initParam.appid;
        f106984g = "DefaultSDKVer";
        f106996s = initParam.getPcdnInitParam();
        int i3 = initParam.ScheduleCorePoolNum;
        if (i3 > 2 && i3 <= 10) {
            f106995r = i3;
        }
        new Handler(f106978a.getMainLooper());
        f106985h = str;
        Handler a16 = h.a("TempTask", 10);
        f106987j = a16;
        a16.post(new RunnableC1121a());
        IThreadPool iThreadPool = initParam.iThreadPool;
        if (iThreadPool == null) {
            throw new RuntimeException("iThreadPool can't null");
        }
        f106990m = initParam.iWadlReportDelegate;
        f106991n = initParam.iWadlLogDelegate;
        f106992o = initParam.iRtaskDeleGaye;
        f106993p = iThreadPool;
        f106994q = initParam.iFlowCallback;
    }
}
