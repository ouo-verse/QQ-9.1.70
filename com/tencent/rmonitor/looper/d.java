package com.tencent.rmonitor.looper;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.bugly.common.looper.FrameManager;
import com.tencent.bugly.common.looper.IFrame;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
class d extends LagObserver implements IFrame, com.tencent.rmonitor.metrics.looper.a {

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.rmonitor.metrics.looper.b f365666i;

    /* renamed from: m, reason: collision with root package name */
    private long f365667m;

    public d(com.tencent.rmonitor.looper.provider.b bVar) {
        super(bVar);
        this.f365667m = 0L;
        this.f365666i = new com.tencent.rmonitor.metrics.looper.b(this);
    }

    private void m(long j3) {
        long j16 = this.f365667m;
        if (j16 != 0) {
            d(j3, j3 - j16);
        }
        this.f365667m = 0L;
    }

    @Override // com.tencent.bugly.common.looper.IFrame
    public void doFrame(long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        m(uptimeMillis);
        this.f365667m = uptimeMillis;
        c(uptimeMillis);
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public Thread e() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return null;
        }
        return mainLooper.getThread();
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void h() {
        super.h();
        FrameManager.INSTANCE.unRegister(this);
        m(SystemClock.uptimeMillis());
        Logger.f365497g.d("RMonitor_lag_vsync", "pause");
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void i() {
        super.i();
        FrameManager.INSTANCE.register(this);
        Logger.f365497g.d("RMonitor_lag_vsync", "resume");
    }

    @Override // com.tencent.bugly.common.looper.IFrame
    public boolean isOpen() {
        return true;
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void k() {
        super.k();
        this.f365666i.b();
        FrameManager.INSTANCE.register(this);
        Logger.f365497g.d("RMonitor_lag_vsync", "start");
    }

    @Override // com.tencent.rmonitor.looper.LagObserver
    public void l() {
        FrameManager.INSTANCE.unRegister(this);
        this.f365666i.c();
        super.l();
        Logger.f365497g.d("RMonitor_lag_vsync", "stop");
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onBackground() {
        h();
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onForeground() {
        i();
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void b(String str) {
    }
}
