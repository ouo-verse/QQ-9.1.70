package com.tencent.qqperf.crashdefend;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqperftool.crashdefend.f;
import com.tencent.qqperf.crashdefend.CrashDefendConfigProcessor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class CrashDefendManager {

    /* renamed from: a, reason: collision with root package name */
    private c f363067a = new c();

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f363068b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private g f363069c = null;

    /* renamed from: d, reason: collision with root package name */
    private b f363070d = null;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f363071e = null;

    /* renamed from: f, reason: collision with root package name */
    private volatile CrashDefendConfigProcessor.a f363072f = CrashDefendConfigProcessor.a.a();

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Context> f363073g = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static CrashDefendManager f363076a = new CrashDefendManager();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class b implements com.tencent.mobileqq.qqperftool.crash.d {
        b() {
        }

        @Override // com.tencent.mobileqq.qqperftool.crash.d
        public void b(com.tencent.mobileqq.qqperftool.crash.b bVar) {
            if (CrashDefendManager.this.f363069c != null) {
                CrashDefendManager.this.f363069c.b(bVar.b(), bVar.a());
            }
        }

        @Override // com.tencent.mobileqq.qqperftool.common.c
        public String getComponentName() {
            return "safe_mode_crash_callback";
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class c implements f.a {
        c() {
        }

        @Override // com.tencent.mobileqq.qqperftool.crashdefend.f.a
        public void a(com.tencent.mobileqq.qqperftool.crash.b bVar) {
            if (CrashDefendManager.this.f363069c != null) {
                CrashDefendManager.this.f363069c.a();
            } else {
                wy3.b.a("CrashDefendManager", "doOnStartStepCrash is jump mCrashDefenderAction is null");
            }
        }
    }

    public static CrashDefendManager i() {
        return a.f363076a;
    }

    public boolean b() {
        return this.f363072f.c();
    }

    public boolean c() {
        return this.f363072f.d();
    }

    public boolean d() {
        String str;
        if (!c()) {
            wy3.b.a("CrashDefendManager", "checkStartCrashOnCheckPoint checkIsNeedStartStepCrashDefender is false");
            return false;
        }
        List<com.tencent.mobileqq.qqperftool.crash.b> g16 = wy3.a.f().g();
        if (g16 != null && g16.size() != 0) {
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkStartCrashOnCheckPoint crashInfoList is ");
        if (g16 == null) {
            str = "null";
        } else {
            str = "Empty";
        }
        sb5.append(str);
        wy3.b.a("CrashDefendManager", sb5.toString());
        return false;
    }

    public boolean e() {
        return this.f363068b.get();
    }

    public synchronized void f() {
        wy3.a.f().l(com.tencent.qqperf.monitor.crash.safemode.d.c());
        if (this.f363068b.compareAndSet(true, false)) {
            wy3.a.f().e();
            wy3.b.a("CrashDefendManager", "disEnableStartStepCrashDefender success");
            g gVar = this.f363069c;
            if (gVar != null) {
                gVar.d();
            }
        }
    }

    public boolean g(@NonNull String str, @NonNull String str2) {
        if (wy3.a.f().d("safe_mode_crash_defender")) {
            return false;
        }
        if (wy3.a.f().d("safe_mode_crash_defender") && !wy3.a.f().k("safe_mode_crash_defender")) {
            return false;
        }
        boolean a16 = wy3.a.f().a("safe_mode_crash_defender", str, str2);
        if (a16) {
            if (this.f363070d == null) {
                this.f363070d = new b();
            }
            wy3.a.f().b(this.f363070d);
        }
        return a16;
    }

    public CrashDefendConfigProcessor.a h() {
        return this.f363072f;
    }

    public synchronized void j(g gVar, Context context) {
        this.f363073g = new WeakReference<>(context);
        if (!c()) {
            return;
        }
        this.f363069c = gVar;
        wy3.a.f().h(h().e(), h().b());
        wy3.a.f().j(false);
        com.tencent.qqperf.monitor.crash.safemode.d.d(context);
        wy3.a.f().b(com.tencent.qqperf.monitor.crash.safemode.d.c());
        wy3.b.a("CrashDefendManager", "init");
    }

    public void k() {
        if (this.f363068b.get()) {
            wy3.b.a("CrashDefendManager", "initCrashDefenderLogger result is " + wy3.c.f());
        }
    }

    public void l() {
        g gVar = this.f363069c;
        if (gVar != null) {
            gVar.c();
        } else {
            wy3.b.a("CrashDefendManager", "initSafeModeRunnerFactory is jump mCrashDefenderAction is null");
        }
    }

    public synchronized void m() {
        if (!c()) {
            return;
        }
        if (this.f363068b.compareAndSet(false, true)) {
            wy3.a.f().c(this.f363067a);
            wy3.b.a("CrashDefendManager", "initStartStepCrashDefender success");
        }
    }

    public synchronized void n(Context context) {
        this.f363072f = com.tencent.qqperf.crashdefend.b.b(context);
    }

    public void o(@NonNull Thread thread, @NonNull Throwable th5) {
        if (!c() || !e()) {
            return;
        }
        wy3.a.f().i(thread, th5);
    }

    public void p(@NonNull final Throwable th5) {
        if (MobileQQ.sProcessId == 1) {
            final Thread currentThread = Thread.currentThread();
            new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.CrashDefendManager.1
                @Override // java.lang.Runnable
                public void run() {
                    CrashDefendManager.this.o(currentThread, th5);
                }
            }).start();
        }
    }

    @NonNull
    public Context q() {
        WeakReference<Context> weakReference = this.f363073g;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
