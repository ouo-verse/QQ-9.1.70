package com.tencent.rmonitor.launch;

import android.os.SystemClock;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.launch.ActivityLaunchWatcher;
import com.tencent.rmonitor.launch.AppLaunchMonitor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AppLaunchMonitor f365637a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f365638b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f365639c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f365640d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f365641e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f365642f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f365643g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f365644h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AppLaunchMonitor appLaunchMonitor) {
        this.f365637a = appLaunchMonitor;
    }

    private void a() {
        this.f365638b = true;
        this.f365644h = System.currentTimeMillis();
        this.f365640d = SystemClock.uptimeMillis();
        this.f365639c = 0L;
        this.f365641e = false;
    }

    private void c() {
        this.f365639c = SystemClock.uptimeMillis() - this.f365640d;
        this.f365643g++;
        this.f365641e = true;
        this.f365638b = false;
        this.f365637a.l(AppLaunchMonitor.CheckAppLaunchStageFrom.FROM_WARM_LAUNCH);
    }

    private boolean d(AppLaunchMode appLaunchMode) {
        if (this.f365643g == 1 && appLaunchMode == AppLaunchMode.APP_LAUNCH_BY_ACTIVITY) {
            return true;
        }
        return false;
    }

    private boolean f() {
        if (this.f365642f == 0) {
            return true;
        }
        return false;
    }

    private void k() {
        this.f365644h = 0L;
        this.f365638b = false;
        this.f365640d = 0L;
        this.f365641e = false;
        this.f365639c = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f365641e && !d(this.f365637a.getAppLaunchMode())) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f365638b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (f()) {
            a();
        }
        this.f365642f++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f365642f--;
        if (f()) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ActivityLaunchWatcher.a aVar) {
        if (e()) {
            c();
        }
    }

    void j() {
        String str;
        long j3 = this.f365639c;
        if (j3 < 60000 && j3 > 0) {
            this.f365637a.m("warm_launch", this.f365640d, j3, this.f365644h);
        } else {
            if (j3 >= 60000) {
                str = "300401";
            } else if (j3 < 0) {
                str = "300400";
            } else {
                str = null;
            }
            if (str != null) {
                this.f365637a.n(str, String.valueOf(j3));
            }
            Logger.f365497g.e("RMonitor_launch_warm", "reportWarmCost has invalid data of launchType[", "warm_launch", "], warmCostInMs[", String.valueOf(this.f365639c), "]");
        }
        this.f365641e = false;
    }
}
