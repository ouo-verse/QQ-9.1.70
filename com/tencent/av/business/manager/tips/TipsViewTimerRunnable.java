package com.tencent.av.business.manager.tips;

import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import dw.b;
import ju.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TipsViewTimerRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    VideoAppInterface f73453d;

    /* renamed from: e, reason: collision with root package name */
    volatile long f73454e = 0;

    /* renamed from: f, reason: collision with root package name */
    volatile b f73455f = null;

    /* renamed from: h, reason: collision with root package name */
    volatile long f73456h = 0;

    /* renamed from: i, reason: collision with root package name */
    volatile b f73457i = null;

    /* renamed from: m, reason: collision with root package name */
    volatile boolean f73458m = false;

    public TipsViewTimerRunnable(VideoAppInterface videoAppInterface) {
        this.f73453d = videoAppInterface;
    }

    private boolean a(b bVar, long j3) {
        boolean z16 = false;
        if (bVar == null) {
            return false;
        }
        if (bVar.b()) {
            return true;
        }
        if (SystemClock.elapsedRealtime() - j3 >= bVar.e() * 1000) {
            z16 = true;
        }
        return !z16;
    }

    private void k() {
        VideoAppInterface videoAppInterface = this.f73453d;
        if (videoAppInterface == null) {
            return;
        }
        videoAppInterface.M().removeCallbacks(this);
        if (!this.f73458m) {
            return;
        }
        this.f73453d.M().postDelayed(this, 1000L);
    }

    public void e() {
        b bVar = this.f73455f;
        this.f73455f = null;
        this.f73454e = 0L;
        a aVar = (a) this.f73453d.B(11);
        if (aVar != null) {
            aVar.n(bVar);
        }
    }

    public void f() {
        b bVar = this.f73457i;
        this.f73457i = null;
        this.f73456h = 0L;
        a aVar = (a) this.f73453d.B(11);
        if (aVar != null) {
            aVar.o(bVar);
        }
    }

    public b g() {
        return this.f73455f;
    }

    public b h() {
        return this.f73457i;
    }

    public boolean i(b bVar) {
        if (bVar == null) {
            return false;
        }
        this.f73455f = bVar;
        if (!bVar.b()) {
            this.f73454e = SystemClock.elapsedRealtime();
            this.f73458m = true;
            k();
        } else {
            this.f73454e = 0L;
        }
        return true;
    }

    public boolean j(b bVar) {
        if (bVar == null) {
            return false;
        }
        this.f73457i = bVar;
        if (!bVar.b()) {
            this.f73456h = SystemClock.elapsedRealtime();
            this.f73458m = true;
            k();
        } else {
            this.f73456h = 0L;
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        boolean z17 = true;
        if (a(this.f73455f, this.f73454e)) {
            z16 = true;
        } else {
            e();
            z16 = false;
        }
        if (!a(this.f73457i, this.f73456h)) {
            f();
            z17 = z16;
        }
        this.f73458m = z17;
        k();
    }
}
