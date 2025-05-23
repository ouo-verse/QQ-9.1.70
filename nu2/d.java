package nu2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.TimingLogicHandler;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class d extends c implements TimingLogicHandler.a {

    /* renamed from: g, reason: collision with root package name */
    protected String f421305g;

    /* renamed from: h, reason: collision with root package name */
    protected TimingLogicHandler f421306h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f421307i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f421308j;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f421310l;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f421309k = true;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f421311m = true;

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.utils.timer.TimingLogicHandler.a
    public void a() {
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i3) {
        switch (i3) {
            case 1:
            case 3:
                this.f421307i = true;
                if (this.f421309k && !this.f421310l) {
                    l();
                    return;
                }
                return;
            case 2:
            case 4:
            case 5:
            case 6:
                this.f421307i = false;
                if (this.f421309k) {
                    m();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public long i() {
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            return timingLogicHandler.b();
        }
        return 0L;
    }

    protected abstract TimingLogicHandler j();

    /* JADX INFO: Access modifiers changed from: protected */
    public long k() {
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            return timingLogicHandler.c();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void l() {
        n.e(this.f421305g, "handleStartCountEvent, mEnableCountDown = " + this.f421311m);
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null && this.f421311m) {
            timingLogicHandler.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m() {
        n.e(this.f421305g, "handleOnPlayerStop, mEnableCountDown = " + this.f421311m);
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            timingLogicHandler.f();
        }
    }

    protected synchronized void n() {
        if (this.f421306h == null) {
            TimingLogicHandler j3 = j();
            this.f421306h = j3;
            j3.j(this);
            av2.a.a().b(this.f421306h);
        }
    }

    public void o(int i3, int i16, int i17, String str, Object obj) {
        h(i3);
    }

    public synchronized void p() {
        if (this.f421306h != null) {
            n.e(this.f421305g, "release play timing manager");
            av2.a.a().d(this.f421306h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        n.e(this.f421305g, "resetTimedCount");
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            timingLogicHandler.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void r(boolean z16) {
        this.f421311m = z16;
    }

    public void s(long j3) {
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            timingLogicHandler.h(j3);
        }
    }

    public synchronized void t(long j3) {
        if (j3 <= 0) {
            return;
        }
        TimingLogicHandler timingLogicHandler = this.f421306h;
        if (timingLogicHandler != null) {
            timingLogicHandler.i(j3);
        }
    }

    public synchronized void u(boolean z16, long j3) {
        n.e(this.f421305g, "startDynamicAdCountIfNeed requestInterval: " + j3);
        if (z16 && j3 > 0) {
            this.f421308j = z16;
            n();
            t(j3);
            av2.a.a().c();
            if (this.f421307i) {
                l();
            }
            return;
        }
        p();
    }

    protected abstract void v();
}
