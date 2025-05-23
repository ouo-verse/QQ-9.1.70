package com.tencent.rmonitor.looper;

import android.os.Debug;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class LagObserver implements c14.a {

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.rmonitor.looper.provider.b f365645d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.rmonitor.looper.provider.c f365646e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f365647f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f365648h = false;

    public LagObserver(com.tencent.rmonitor.looper.provider.b bVar) {
        this.f365645d = bVar;
    }

    @Override // c14.a
    public void a(final MonitorInfo monitorInfo) {
        if (Debug.isDebuggerConnected()) {
            Logger.f365497g.d("RMonitor_lag", "onAfterStack, in debugger mode.");
        } else if (monitorInfo != null && monitorInfo.getDuration() > this.f365645d.f365684b) {
            ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.looper.LagObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    LooperReport.f365654b.e(monitorInfo);
                }
            });
        }
    }

    public void c(long j3) {
        boolean z16;
        com.tencent.rmonitor.looper.provider.c cVar = this.f365646e;
        if (this.f365647f && Math.random() < this.f365645d.f365683a) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && cVar != null) {
            this.f365648h = z16;
            cVar.c(j3);
        }
    }

    public void d(long j3, long j16) {
        com.tencent.rmonitor.looper.provider.c cVar = this.f365646e;
        if (this.f365648h && cVar != null) {
            cVar.b(j3, j16);
        }
        this.f365648h = false;
    }

    public abstract Thread e();

    public String f() {
        Thread e16 = e();
        if (e16 != null) {
            return e16.getName();
        }
        return "";
    }

    public boolean g() {
        return this.f365647f;
    }

    public void h() {
        this.f365647f = false;
    }

    public void i() {
        this.f365647f = true;
    }

    public void j(com.tencent.rmonitor.looper.provider.c cVar) {
        this.f365646e = cVar;
    }

    public void k() {
        Thread e16 = e();
        com.tencent.rmonitor.looper.provider.c cVar = this.f365646e;
        if (cVar != null && e16 != null) {
            cVar.a(e16, this.f365645d, this);
        }
    }

    public void l() {
        com.tencent.rmonitor.looper.provider.c cVar = this.f365646e;
        if (cVar != null) {
            cVar.stop();
        }
    }
}
