package com.tencent.halley.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Process;
import com.tencent.halley.common.a.c;
import com.tencent.halley.common.a.i;
import com.tencent.halley.common.utils.f;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.measure.config.RAFTComConfig;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113172a;

    /* renamed from: b, reason: collision with root package name */
    public static String f113173b;

    /* renamed from: c, reason: collision with root package name */
    public static int f113174c;

    /* renamed from: d, reason: collision with root package name */
    public static String f113175d;

    /* renamed from: e, reason: collision with root package name */
    public static String f113176e;

    /* renamed from: f, reason: collision with root package name */
    public static int f113177f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f113178g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f113179h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f113180i;

    /* renamed from: j, reason: collision with root package name */
    public static final RAFTComConfig f113181j;

    /* renamed from: k, reason: collision with root package name */
    private static Context f113182k;

    /* renamed from: l, reason: collision with root package name */
    private static int f113183l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f113184m;

    /* renamed from: n, reason: collision with root package name */
    private static String f113185n;

    /* renamed from: o, reason: collision with root package name */
    private static String f113186o;

    /* renamed from: p, reason: collision with root package name */
    private static Handler f113187p;

    /* renamed from: q, reason: collision with root package name */
    private static String f113188q;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f113189r;

    /* renamed from: s, reason: collision with root package name */
    private static String f113190s;

    /* renamed from: t, reason: collision with root package name */
    private static int f113191t;

    /* renamed from: u, reason: collision with root package name */
    private static Handler f113192u;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f113193v;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113172a = "null";
        f113173b = "";
        f113174c = 0;
        f113175d = "";
        f113176e = "";
        f113177f = -1;
        f113178g = false;
        f113179h = true;
        f113180i = false;
        f113182k = null;
        f113183l = 0;
        f113184m = false;
        f113185n = "";
        f113186o = "0.1.1";
        f113188q = "";
        f113189r = false;
        f113190s = "";
        f113191t = 0;
        f113193v = false;
        f113181j = new RAFTComConfig("QDDownloader", "0.1.1");
    }

    public static Context a() {
        return f113182k;
    }

    public static boolean b() {
        return f113193v;
    }

    public static int c() {
        return f113183l;
    }

    public static String d() {
        return f113185n;
    }

    public static String e() {
        return f113186o;
    }

    public static Handler f() {
        return f113187p;
    }

    public static String g() {
        if (!j.a(f113190s)) {
            return f113190s;
        }
        if (j.a(f113188q) || !f113188q.contains(":")) {
            return "";
        }
        return f113188q.substring(f113188q.indexOf(":") + 1);
    }

    public static Handler h() {
        return f113192u;
    }

    public static void a(boolean z16, d dVar, String str) {
        com.tencent.halley.common.utils.d.a("halley-cloud-SDKBaseInfo", "initSDKBaseInfo,isTestMode:" + z16 + ",isSDKMode:" + f113184m + ",uuid:" + f113175d, true);
        f113180i = dVar.f113563a;
        f113193v = z16;
        f113177f = Process.myPid();
        Context d16 = dVar.d();
        f113182k = d16.getApplicationContext();
        f113185n = d16.getPackageName();
        f113183l = dVar.a();
        f113184m = dVar.j();
        String h16 = dVar.h();
        if (j.a(h16)) {
            h16 = "";
        }
        f113175d = h16;
        String c16 = dVar.c();
        f113176e = j.a(c16) ? "" : c16;
        f113186o = "0.1.1";
        f113191t = 0;
        f113187p = new Handler(f113182k.getMainLooper());
        f113188q = str;
        f113189r = f113185n.equals(str);
        Handler a16 = i.a("TempTask");
        f113192u = a16;
        a16.post(new Runnable() { // from class: com.tencent.halley.common.a.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(a.f113182k.getPackageManager(), a.f113182k.getPackageName(), 0);
                    a.f113172a = packageInfo.versionName;
                    a.f113174c = packageInfo.versionCode;
                    a.f113173b = packageInfo.applicationInfo.loadLabel(a.f113182k.getPackageManager()).toString();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                c.a();
                a.a();
                f.a();
            }
        });
    }
}
