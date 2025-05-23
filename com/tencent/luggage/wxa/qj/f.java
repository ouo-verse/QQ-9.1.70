package com.tencent.luggage.wxa.qj;

import android.os.Looper;
import android.view.Choreographer;
import com.tencent.luggage.wxa.qj.f;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public Choreographer f138921a;

    /* renamed from: d, reason: collision with root package name */
    public long f138924d;

    /* renamed from: f, reason: collision with root package name */
    public a f138926f;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ln.a f138928h;

    /* renamed from: b, reason: collision with root package name */
    public long f138922b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f138923c = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f138925e = false;

    /* renamed from: g, reason: collision with root package name */
    public volatile double f138927g = 0.0d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(double d16);
    }

    public f() {
        com.tencent.luggage.wxa.ln.a aVar = new com.tencent.luggage.wxa.ln.a(2, new Runnable() { // from class: z31.a
            @Override // java.lang.Runnable
            public final void run() {
                f.this.b();
            }
        });
        this.f138928h = aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.f138921a = Choreographer.getInstance();
            aVar.b();
        } else {
            c0.a(new Runnable() { // from class: z31.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.c();
                }
            });
        }
        this.f138924d = 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f138921a = Choreographer.getInstance();
        this.f138928h.b();
    }

    public void d() {
        if (this.f138925e) {
            return;
        }
        this.f138925e = true;
        w.d("FPSMetronome", "[start] stack:%s", w0.b());
        this.f138928h.b();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        if (this.f138925e) {
            long j16 = j3 / 1000000;
            long j17 = this.f138922b;
            if (j17 > 0) {
                long j18 = j16 - j17;
                this.f138923c = this.f138923c + 1;
                if (j18 > this.f138924d) {
                    double d16 = (r2 * 1000) / j18;
                    if (d16 >= 60.0d) {
                        d16 = 60.0d;
                    }
                    this.f138922b = j16;
                    this.f138923c = 0;
                    this.f138927g = d16;
                    a aVar = this.f138926f;
                    if (aVar != null) {
                        aVar.a(d16);
                    }
                }
            } else {
                this.f138922b = j16;
            }
        }
        if (this.f138925e) {
            this.f138921a.postFrameCallback(this);
        }
    }

    public void e() {
        if (!this.f138925e) {
            return;
        }
        this.f138928h.a();
        this.f138925e = false;
        this.f138922b = 0L;
        this.f138923c = 0;
        w.d("FPSMetronome", "[stop] stack:%s", w0.b());
        Choreographer choreographer = this.f138921a;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        Choreographer choreographer = this.f138921a;
        Objects.requireNonNull(choreographer);
        choreographer.postFrameCallback(this);
    }

    public void a(long j3) {
        this.f138924d = j3;
    }

    public void a(a aVar) {
        this.f138926f = aVar;
    }

    public int a() {
        return (int) (this.f138927g + 0.5d);
    }
}
