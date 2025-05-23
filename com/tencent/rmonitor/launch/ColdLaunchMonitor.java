package com.tencent.rmonitor.launch;

import android.os.SystemClock;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.launch.ActivityLaunchWatcher;
import com.tencent.rmonitor.launch.AppLaunchMonitor;
import com.tencent.rmonitor.launch.LandingPageTracer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class ColdLaunchMonitor {

    /* renamed from: a, reason: collision with root package name */
    protected long f365615a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected long f365616b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected long f365617c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected long f365618d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected long f365619e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f365620f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f365621g = false;

    /* renamed from: h, reason: collision with root package name */
    private long f365622h = 0;

    /* renamed from: i, reason: collision with root package name */
    private AppLaunchMode f365623i = AppLaunchMode.UNKNOWN;

    /* renamed from: j, reason: collision with root package name */
    private final AppLaunchMonitor f365624j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColdLaunchMonitor(AppLaunchMonitor appLaunchMonitor) {
        this.f365624j = appLaunchMonitor;
    }

    private long d(long j3) {
        long j16 = this.f365622h;
        long j17 = this.f365615a;
        if (j3 != j17) {
            return (j16 + j3) - j17;
        }
        return j16;
    }

    private boolean f() {
        if (this.f365623i == AppLaunchMode.APP_LAUNCH_BY_ACTIVITY) {
            return true;
        }
        return false;
    }

    private void k() {
        if (this.f365616b != 0) {
            return;
        }
        Logger.f365497g.w("RMonitor_launch_cold", "onApplicationCreateEndInner");
        this.f365616b = SystemClock.uptimeMillis();
        this.f365624j.spanEnd("applicationCreate");
    }

    private void m(long j3) {
        Logger.f365497g.w("RMonitor_launch_cold", "postCheckPreLaunchTask, delay: ", String.valueOf(j3));
        ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.launch.ColdLaunchMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                ColdLaunchMonitor.this.q(AppLaunchMode.APP_LAUNCH_BY_OTHER);
            }
        }, j3);
    }

    private void o() {
        String str;
        if (f()) {
            if (e()) {
                p(5);
            }
            this.f365624j.addTag("tag_normal_launch");
        } else {
            this.f365624j.addTag("tag_pre_launch");
            this.f365624j.addTag(this.f365623i.toString().toLowerCase());
        }
        long j3 = this.f365620f;
        if (j3 < 180000 && j3 > 0) {
            long c16 = c();
            this.f365624j.m(StartupReportKey.COLD_LAUNCH, c16, this.f365620f, d(c16));
        } else {
            if (j3 >= 180000) {
                str = "300201";
            } else if (j3 < 0) {
                str = "300200";
            } else {
                str = null;
            }
            if (str != null) {
                this.f365624j.n(str, String.valueOf(j3));
            }
            Logger.f365497g.e("RMonitor_launch_cold", "reportColdCost has invalid data of launchType[", StartupReportKey.COLD_LAUNCH, "], coldCostInMs[", String.valueOf(this.f365620f), "]");
        }
        this.f365621g = true;
    }

    private void p(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        this.f365620f = Long.MAX_VALUE;
                    } else {
                        this.f365620f = this.f365618d - c();
                    }
                } else {
                    this.f365620f = this.f365619e - c();
                }
            } else {
                this.f365620f = SystemClock.uptimeMillis() - c();
            }
        } else {
            this.f365620f = this.f365616b - c();
        }
        if (this.f365620f <= 0) {
            this.f365620f = Long.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (!g()) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppLaunchMode b() {
        return this.f365623i;
    }

    public long c() {
        long earliestSpanStartTimeInMs = this.f365624j.getEarliestSpanStartTimeInMs();
        long j3 = this.f365615a;
        if (earliestSpanStartTimeInMs > j3) {
            earliestSpanStartTimeInMs = j3;
        }
        Logger.f365497g.d("RMonitor_launch_cold", "getColdLaunchStartTime, launchStartTime:", String.valueOf(earliestSpanStartTimeInMs), ", applicationOnCreateTime:", String.valueOf(this.f365615a));
        return earliestSpanStartTimeInMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        if (this.f365620f == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        return this.f365621g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        q(AppLaunchMode.APP_LAUNCH_BY_ACTIVITY);
        if (this.f365617c == 0) {
            this.f365617c = SystemClock.uptimeMillis();
            this.f365624j.spanStart("firstScreenRender", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ActivityLaunchWatcher.a aVar) {
        if (this.f365618d == 0) {
            this.f365618d = SystemClock.uptimeMillis();
            this.f365624j.spanEnd("firstScreenRender");
        }
        if (e()) {
            LandingPageTracer.CheckResult g16 = this.f365624j.g(aVar);
            if (g16 == LandingPageTracer.CheckResult.HIT_LANDING_PAGE) {
                p(2);
            } else if (g16 == LandingPageTracer.CheckResult.INVALID) {
                p(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        Logger.f365497g.w("RMonitor_launch_cold", "onApplicationCreateEnd");
        k();
        m(2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        Logger.f365497g.w("RMonitor_launch_cold", "onApplicationCreateStart");
        this.f365622h = System.currentTimeMillis();
        this.f365615a = SystemClock.uptimeMillis();
        this.f365624j.spanStart("applicationCreate", null);
        m(20000L);
        this.f365624j.l(AppLaunchMonitor.CheckAppLaunchStageFrom.FROM_ON_APPLICATION_CREATE_TIME_OUT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.f365619e == 0) {
            this.f365619e = SystemClock.uptimeMillis();
            p(4);
            this.f365624j.l(AppLaunchMonitor.CheckAppLaunchStageFrom.FROM_APP_FULL_LAUNCH);
        }
        Logger.f365497g.w("RMonitor_launch_cold", "reportAppFullLaunch, uptime: ", String.valueOf(this.f365619e));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(AppLaunchMode appLaunchMode) {
        AppLaunchMode appLaunchMode2;
        AppLaunchMode appLaunchMode3;
        boolean z16;
        AppLaunchMode appLaunchMode4 = AppLaunchMode.UNKNOWN;
        if (appLaunchMode == appLaunchMode4 || (appLaunchMode2 = this.f365623i) == (appLaunchMode3 = AppLaunchMode.APP_LAUNCH_BY_ACTIVITY) || (appLaunchMode2 != appLaunchMode4 && (appLaunchMode != appLaunchMode3 || Math.abs(SystemClock.uptimeMillis() - this.f365616b) >= 2000))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            k();
            Logger.f365497g.w("RMonitor_launch_cold", "updateLaunchMode, appLaunchMode: ", String.valueOf(appLaunchMode));
            this.f365623i = appLaunchMode;
            if (!f()) {
                p(1);
            }
        }
    }
}
