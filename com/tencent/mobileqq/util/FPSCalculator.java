package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/* loaded from: classes20.dex */
public class FPSCalculator {

    /* renamed from: k, reason: collision with root package name */
    private static volatile FPSCalculator f306371k;

    /* renamed from: c, reason: collision with root package name */
    private Choreographer f306374c;

    /* renamed from: d, reason: collision with root package name */
    private Choreographer.FrameCallback f306375d;

    /* renamed from: f, reason: collision with root package name */
    private Handler f306377f;

    /* renamed from: a, reason: collision with root package name */
    private long f306372a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f306373b = 0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f306376e = false;

    /* renamed from: g, reason: collision with root package name */
    private final Vector<a> f306378g = new Vector<>();

    /* renamed from: h, reason: collision with root package name */
    private final Object f306379h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f306380i = new Runnable() { // from class: com.tencent.mobileqq.util.FPSCalculator.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (FPSCalculator.this.f306374c != null) {
                    FPSCalculator.this.f306374c.removeFrameCallback(FPSCalculator.this.f306375d);
                } else {
                    FPSCalculator.this.f306374c = Choreographer.getInstance();
                }
                FPSCalculator.this.f306374c.postFrameCallback(FPSCalculator.this.f306375d);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FPSCalculator", 2, "Choreographer.getInstance", e16);
                }
            }
            FPSCalculator.this.f306377f.removeCallbacks(FPSCalculator.this.f306380i);
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f306381j = new Runnable() { // from class: com.tencent.mobileqq.util.FPSCalculator.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (FPSCalculator.this.f306379h) {
                for (int i3 = 0; i3 < FPSCalculator.this.f306378g.size(); i3++) {
                    a aVar = (a) FPSCalculator.this.f306378g.get(i3);
                    FPSCalculator.this.f306372a = System.currentTimeMillis();
                    aVar.onInfo(FPSCalculator.this.f306372a, 60.0d);
                }
            }
            FPSCalculator.this.f306377f.postDelayed(FPSCalculator.this.f306381j, 500L);
        }
    };

    /* loaded from: classes20.dex */
    public interface a {
        void onInfo(long j3, double d16);
    }

    FPSCalculator() {
    }

    private void m() {
        if (this.f306376e) {
            Choreographer choreographer = this.f306374c;
            if (choreographer != null) {
                choreographer.removeFrameCallback(this.f306375d);
                if (QLog.isColorLevel()) {
                    QLog.d("FPSCalculator", 2, "removeFrameCallback ");
                }
            }
            this.f306377f.removeCallbacksAndMessages(Boolean.TRUE);
            this.f306372a = 0L;
            this.f306373b = 0;
            this.f306376e = false;
            QLog.d("FPSCalculator", 2, "FPSCalculator set enable = false");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j3) {
        long q16 = q(j3);
        long j16 = this.f306372a;
        if (j16 <= 0) {
            this.f306372a = q16;
        } else {
            long j17 = q16 - j16;
            this.f306373b = this.f306373b + 1;
            if (j17 > 500) {
                double d16 = (r2 * 1000) / j17;
                this.f306372a = q16;
                this.f306373b = 0;
                synchronized (this.f306379h) {
                    for (int i3 = 0; i3 < this.f306378g.size(); i3++) {
                        this.f306378g.get(i3).onInfo(this.f306372a, d16);
                    }
                }
            }
        }
        this.f306374c.postFrameCallback(this.f306375d);
    }

    private void o() {
        if (this.f306376e) {
            QLog.d("FPSCalculator", 2, "FPSCalculator is enable");
            return;
        }
        this.f306376e = true;
        QLog.d("FPSCalculator", 2, "FPSCalculator set enable = true");
        if (this.f306377f == null) {
            this.f306377f = new Handler(Looper.getMainLooper());
        }
        if (this.f306375d == null) {
            this.f306375d = new Choreographer.FrameCallback() { // from class: com.tencent.mobileqq.util.aa
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j3) {
                    FPSCalculator.this.n(j3);
                }
            };
        }
        this.f306377f.post(this.f306380i);
    }

    public static FPSCalculator p() {
        if (f306371k == null) {
            synchronized (FPSCalculator.class) {
                if (f306371k == null) {
                    f306371k = new FPSCalculator();
                }
            }
        }
        return f306371k;
    }

    private static long q(long j3) {
        return TimeUnit.NANOSECONDS.toMillis(j3);
    }

    public void l(a aVar) {
        synchronized (this.f306379h) {
            if (!this.f306378g.contains(aVar)) {
                this.f306378g.add(aVar);
            }
            o();
        }
    }

    public void r(a aVar) {
        synchronized (this.f306379h) {
            this.f306378g.remove(aVar);
            if (this.f306378g.isEmpty()) {
                m();
            }
        }
    }
}
