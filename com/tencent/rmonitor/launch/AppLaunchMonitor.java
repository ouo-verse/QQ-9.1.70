package com.tencent.rmonitor.launch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.launch.ActivityLaunchWatcher;
import com.tencent.rmonitor.launch.ActivityThreadHacker;
import com.tencent.rmonitor.launch.LandingPageTracer;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes25.dex */
public final class AppLaunchMonitor extends f implements ActivityThreadHacker.IApplicationCreateListener, ActivityLaunchWatcher.OnLaunchCompleteListener {
    private static AppLaunchMonitor G;

    /* renamed from: d, reason: collision with root package name */
    private int f365604d = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f365605e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f365606f = true;

    /* renamed from: h, reason: collision with root package name */
    private ActivityThreadHacker f365607h = null;

    /* renamed from: i, reason: collision with root package name */
    private ActivityLaunchWatcher f365608i = null;
    private d E = null;
    private ColdLaunchMonitor F = null;

    /* renamed from: m, reason: collision with root package name */
    private final b f365609m = new b(TraceGenerator.getProcessLaunchId());
    private final c C = new c();
    private final LandingPageTracer D = new LandingPageTracer();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public enum CheckAppLaunchStageFrom {
        FROM_ON_APPLICATION_CREATE_TIME_OUT,
        FROM_WARM_LAUNCH,
        FROM_APP_FULL_LAUNCH
    }

    protected AppLaunchMonitor() {
    }

    private void e() {
        if (this.f365608i == null && AndroidVersion.isOverJellyBeanMr2()) {
            this.f365608i = new ActivityLaunchWatcher(this);
        }
    }

    public static AppLaunchMonitor getInstance() {
        if (G == null) {
            synchronized (AppLaunchMonitor.class) {
                if (G == null) {
                    G = new AppLaunchMonitor();
                }
            }
        }
        return G;
    }

    private void h() {
        ActivityLaunchWatcher activityLaunchWatcher = this.f365608i;
        if (activityLaunchWatcher == null) {
            return;
        }
        activityLaunchWatcher.destroy();
        this.f365608i = null;
    }

    private boolean i() {
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null && coldLaunchMonitor.g()) {
            return true;
        }
        return false;
    }

    private boolean j() {
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null && coldLaunchMonitor.e()) {
            return true;
        }
        return false;
    }

    private boolean k() {
        d dVar = this.E;
        if (dVar != null && dVar.e()) {
            return true;
        }
        return false;
    }

    public void addActivityNameBeforeLanding(String str) {
        this.D.a(str);
    }

    public void addLandingActivityName(String str) {
        this.D.b(str);
    }

    public void addSpan(String str, String str2, long j3, long j16) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j16 >= j3 && j16 <= uptimeMillis && j3 <= uptimeMillis && uptimeMillis - j3 <= 180000) {
            this.f365609m.a(str, str2, j3, j16);
        } else {
            Logger.f365497g.d("RMonitor_launch_Monitor", String.format("addSpan fail for [name: %s, start: %s, end: %s]", str, Long.valueOf(j3), Long.valueOf(j16)));
        }
    }

    public void addTag(String str) {
        this.C.a(str);
    }

    public void enableCheckActivityBeforeLanding(boolean z16) {
        this.D.d(z16);
    }

    public void endSpanFromLaunch(String str) {
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            addSpan(str, null, coldLaunchMonitor.c(), SystemClock.uptimeMillis());
        }
    }

    protected void f() {
        ActivityThreadHacker activityThreadHacker;
        Logger.f365497g.d("RMonitor_launch_Monitor", "checkAppLaunchStage");
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            coldLaunchMonitor.a();
        }
        if (this.E != null && i()) {
            this.E.b();
        }
        if (!j() && (activityThreadHacker = this.f365607h) != null) {
            activityThreadHacker.j();
        }
        if (!j() && !k()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LandingPageTracer.CheckResult g(ActivityLaunchWatcher.a aVar) {
        return this.D.c(aVar.f365582a);
    }

    public AppLaunchMode getAppLaunchMode() {
        AppLaunchMode appLaunchMode = AppLaunchMode.UNKNOWN;
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            return coldLaunchMonitor.b();
        }
        return appLaunchMode;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getEarliestSpanStartTimeInMs() {
        return this.f365609m.d();
    }

    public boolean isStarted() {
        return this.f365605e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(CheckAppLaunchStageFrom checkAppLaunchStageFrom) {
        long j3;
        Logger.f365497g.i("RMonitor_launch_Monitor", "postCheckAppLaunchStageTask, from: ", String.valueOf(checkAppLaunchStageFrom));
        if (checkAppLaunchStageFrom == CheckAppLaunchStageFrom.FROM_WARM_LAUNCH && !i()) {
            return;
        }
        if (checkAppLaunchStageFrom == CheckAppLaunchStageFrom.FROM_ON_APPLICATION_CREATE_TIME_OUT) {
            j3 = 180000;
        } else {
            j3 = 500;
        }
        ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.launch.AppLaunchMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                AppLaunchMonitor.this.f();
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(String str, long j3, long j16, long j17) {
        a aVar = new a(str, j3, j16, j17);
        aVar.d(this.f365609m.f());
        aVar.e(this.C.c());
        AppLaunchReporter.getInstance().report(aVar);
        this.f365609m.c();
        this.C.b();
        int i3 = this.f365604d + 1;
        this.f365604d = i3;
        if (i3 >= 10) {
            stop();
        }
        Logger.f365497g.i("RMonitor_launch_Monitor", "report, result: ", aVar.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(String str, String str2) {
        AppLaunchReporter.getInstance().reportError(str, str2);
    }

    @Override // com.tencent.rmonitor.launch.ActivityLaunchWatcher.OnLaunchCompleteListener
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onActivityLaunchComplete(ActivityLaunchWatcher.a aVar) {
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            coldLaunchMonitor.i(aVar);
        }
        d dVar = this.E;
        if (dVar != null) {
            dVar.i(aVar);
        }
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_launch_Monitor", "onLaunchComplete", aVar.toString());
        }
    }

    public void onApplicationCreateEnd() {
        ColdLaunchMonitor coldLaunchMonitor;
        if (isStarted() && (coldLaunchMonitor = this.F) != null) {
            coldLaunchMonitor.j();
        }
    }

    @Override // com.tencent.rmonitor.launch.ActivityThreadHacker.IApplicationCreateListener
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onApplicationLaunchEnd(AppLaunchMode appLaunchMode) {
        Logger.f365497g.w("RMonitor_launch_Monitor", "onApplicationLaunchEnd, appLaunchMode: " + appLaunchMode);
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            coldLaunchMonitor.q(appLaunchMode);
        }
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onCreate(@NotNull Activity activity) {
        ColdLaunchMonitor coldLaunchMonitor = this.F;
        if (coldLaunchMonitor != null) {
            coldLaunchMonitor.h();
        }
        d dVar = this.E;
        if (dVar != null) {
            dVar.g();
        }
        if (k() || j()) {
            e();
        }
        ActivityLaunchWatcher activityLaunchWatcher = this.f365608i;
        if (activityLaunchWatcher != null) {
            activityLaunchWatcher.onActivityCreate(activity);
        }
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onDestroy(@NotNull Activity activity) {
        ActivityLaunchWatcher activityLaunchWatcher = this.f365608i;
        if (activityLaunchWatcher != null) {
            activityLaunchWatcher.onActivityDestroy(activity);
        }
        d dVar = this.E;
        if (dVar != null) {
            dVar.h();
        }
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onResume(@NotNull Activity activity) {
        ActivityLaunchWatcher activityLaunchWatcher = this.f365608i;
        if (activityLaunchWatcher != null) {
            activityLaunchWatcher.onActivityResume(activity);
        }
    }

    public void reportAppFullLaunch() {
        ColdLaunchMonitor coldLaunchMonitor;
        if (isStarted() && (coldLaunchMonitor = this.F) != null) {
            coldLaunchMonitor.n();
        }
    }

    public void setUseActivityThreadHacker(boolean z16) {
        this.f365606f = z16;
        Logger.f365497g.w("RMonitor_launch_Monitor", "setUseActivityThreadHacker, useHacker: ", String.valueOf(z16));
    }

    public void spanEnd(String str) {
        this.f365609m.g(str);
    }

    public void spanStart(String str, String str2) {
        this.f365609m.h(str, str2);
    }

    public void startOnApplicationOnCreate(Application application) {
        if (isStarted()) {
            Logger.f365497g.e("RMonitor_launch_Monitor", "call startOnApplicationOnCreate fail forAppLaunchMonitor has started before.");
            return;
        }
        Logger.f365497g.d("RMonitor_launch_Monitor", "startOnApplicationOnCreate");
        this.f365605e = true;
        ColdLaunchMonitor coldLaunchMonitor = new ColdLaunchMonitor(this);
        this.F = coldLaunchMonitor;
        coldLaunchMonitor.l();
        this.E = new d(this);
        LifecycleCallback.r(this);
        LifecycleCallback.k(application);
        if (this.f365606f) {
            this.f365607h = new ActivityThreadHacker(this);
        }
        ActivityThreadHacker activityThreadHacker = this.f365607h;
        if (activityThreadHacker != null) {
            activityThreadHacker.i();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stop() {
        if (!isStarted()) {
            Logger.f365497g.w("RMonitor_launch_Monitor", "AppLaunchMonitor has not started yet.");
            return;
        }
        LifecycleCallback.s(this);
        h();
        this.f365605e = false;
        Logger.f365497g.i("RMonitor_launch_Monitor", "stop");
    }
}
