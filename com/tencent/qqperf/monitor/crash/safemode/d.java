package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.crashdefend.report.StartStepCrashReportHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements com.tencent.mobileqq.qqperftool.crash.d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f363218c;

    /* renamed from: a, reason: collision with root package name */
    private Context f363219a = null;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f363220b = new AtomicBoolean(false);

    public static d c() {
        return f363218c;
    }

    public static synchronized void d(Context context) {
        synchronized (d.class) {
            f363218c = new d();
            f363218c.f(context);
        }
    }

    @Override // com.tencent.mobileqq.qqperftool.crash.d
    public void b(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        if (this.f363220b.compareAndSet(false, true)) {
            wy3.c.c("SafeModeCrashRecord", "recordCrashInfo: " + bVar.a());
            com.tencent.mobileqq.hodor.a.b(this.f363219a, bVar.b(), bVar.c(), bVar.d(), "com.tencent.mobileqq");
            StartStepCrashReportHelper.f(bVar);
            c.c(this.f363219a, bVar);
            CrashDefendManager.i().l();
            SafeModeHelper.g(this.f363219a);
            return;
        }
        wy3.c.c("SafeModeCrashRecord", "jump recordCrashInfo: " + bVar.a());
    }

    public boolean e() {
        return this.f363220b.get();
    }

    public void f(Context context) {
        this.f363219a = context;
    }

    @Override // com.tencent.mobileqq.qqperftool.common.c
    public String getComponentName() {
        return "SafeModeCrashRecord";
    }
}
