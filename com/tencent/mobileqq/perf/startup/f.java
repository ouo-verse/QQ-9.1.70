package com.tencent.mobileqq.perf.startup;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.widget.TraceUtils;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f258037a;

    /* renamed from: b, reason: collision with root package name */
    public static long f258038b;

    /* renamed from: c, reason: collision with root package name */
    public static long f258039c;

    /* renamed from: d, reason: collision with root package name */
    public static long f258040d;

    /* renamed from: e, reason: collision with root package name */
    public static long f258041e;

    /* renamed from: f, reason: collision with root package name */
    public static long f258042f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f258043g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258037a = 0L;
        f258038b = 0L;
        f258039c = 0L;
        f258040d = 0L;
        f258041e = 0L;
        f258042f = 0L;
        f258043g = false;
    }

    public static void a(Map<String, String> map) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt("actSCount", 0);
        int i3 = decodeInt + 1;
        map.put("actSCount", String.valueOf(i3));
        from.encodeInt("actSCount", i3);
        com.tencent.mobileqq.perf.log.a.a("AS", "[actSCount] addActSCounts, lastCount = " + decodeInt + " , thisCount = " + i3);
    }

    public static void b() {
        long j3 = f258040d;
        if (j3 > 0) {
            long j16 = f258041e;
            if (j16 > 0) {
                long j17 = j16 - j3;
                com.tencent.mobileqq.perf.log.a.c("AS", "AutoMonitor, hotStartTime = " + j17);
                PerfReportUtil.e(j17);
                f258040d = 0L;
                f258041e = 0L;
            }
        }
    }

    public static void c(Context context) {
        long j3;
        long startUptimeMillis;
        if (f258043g) {
            Log.d("AS", "AutoMonitor, onAppAttachBaseContext, hasAttached, return.");
            return;
        }
        f258037a = SystemClock.uptimeMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            long j16 = f258037a;
            startUptimeMillis = Process.getStartUptimeMillis();
            j3 = j16 - startUptimeMillis;
        } else {
            j3 = -1;
        }
        Log.d("AS", "AutoMonitor, onAppAttachBaseContext, appSysLaunchCost = " + j3);
        f258043g = true;
        TraceUtils.asyncTraceBegin(4096L, "ColdStartup", Process.myTid());
        TraceUtils.traceBegin("PreAppStart");
    }

    public static void d() {
        com.tencent.mobileqq.perf.log.a.a("AS", "[actSCount] onCurrentVersionFirstLaunch");
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").removeKey("actSCount");
        SpeedUpUtil.t();
    }

    public static void e() {
        f258040d = SystemClock.uptimeMillis();
        com.tencent.mobileqq.perf.log.a.a("AS", "AutoMonitor,MainActivityRestart, sMainOnRestartTime = " + f258040d);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null && guardManager.isApplicationForeground()) {
            com.tencent.mobileqq.perf.log.a.a("AS", "AutoMonitor,MainActivityRestart, isApplicationForeground.");
            f258040d = 0L;
        }
    }

    public static void f() {
        f258041e = SystemClock.uptimeMillis();
        com.tencent.mobileqq.perf.log.a.a("AS", "AutoMonitor,onMainActivityWindowFocusChanged, sMainOnWindowFocusChangedTime = " + f258041e);
        b();
    }

    public static void g(String str) {
        TraceUtils.traceBegin(str);
        com.tencent.mobileqq.perf.log.a.b("AS", str + " Begin.");
    }

    public static void h(String str) {
        TraceUtils.traceEnd();
        com.tencent.mobileqq.perf.log.a.b("AS", str + " End.");
    }
}
