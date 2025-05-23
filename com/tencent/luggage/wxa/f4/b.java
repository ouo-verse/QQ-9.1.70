package com.tencent.luggage.wxa.f4;

import com.tencent.luggage.wxa.tn.f0;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: q, reason: collision with root package name */
    public static final a f125265q = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public f0 f125266a;

    /* renamed from: b, reason: collision with root package name */
    public long f125267b;

    /* renamed from: f, reason: collision with root package name */
    public boolean f125271f;

    /* renamed from: g, reason: collision with root package name */
    public int f125272g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f125273h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f125274i;

    /* renamed from: k, reason: collision with root package name */
    public long f125276k;

    /* renamed from: l, reason: collision with root package name */
    public long f125277l;

    /* renamed from: m, reason: collision with root package name */
    public long f125278m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f125279n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f125280o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f125281p;

    /* renamed from: c, reason: collision with root package name */
    public long f125268c = 5000;

    /* renamed from: d, reason: collision with root package name */
    public long f125269d = 1000;

    /* renamed from: e, reason: collision with root package name */
    public float f125270e = 2.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f125275j = 0.8f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b() {
        j();
        i();
    }

    public final void a(boolean z16) {
        this.f125281p = z16;
    }

    public final void b() {
        this.f125276k = System.currentTimeMillis();
    }

    public final void c() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f125277l = currentTimeMillis;
        long j3 = currentTimeMillis - this.f125276k;
        this.f125278m = j3;
        w.d("Luggage.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", Long.valueOf(j3), Boolean.valueOf(this.f125271f), Boolean.valueOf(this.f125279n), Boolean.valueOf(this.f125281p));
        if (this.f125271f) {
            a(this.f125267b);
        } else {
            a();
        }
    }

    public final String d() {
        return "luggage_scan_code_retry";
    }

    public final int e() {
        return this.f125272g;
    }

    public final long f() {
        f0 f0Var = this.f125266a;
        if (f0Var == null) {
            return 5000L;
        }
        return f0Var.getLong("scan_code_retry_timeout", 5000L);
    }

    public final float g() {
        return this.f125275j;
    }

    public final long h() {
        return this.f125267b;
    }

    public final void i() {
        long f16 = f();
        this.f125267b = f16;
        this.f125272g = 0;
        this.f125268c = 5000L;
        this.f125269d = 1000L;
        this.f125270e = 200 / 100.0f;
        long max = Math.max(1000L, f16);
        this.f125267b = max;
        this.f125267b = Math.min(this.f125268c, max);
        float f17 = 80 / 100.0f;
        this.f125275j = f17;
        this.f125275j = Math.min(1.0f, f17);
        int i3 = this.f125272g;
        if (i3 == 1) {
            this.f125273h = true;
            this.f125274i = false;
        } else if (i3 == 2) {
            this.f125273h = false;
            this.f125274i = true;
        }
        w.d("Luggage.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", Integer.valueOf(i3), Long.valueOf(this.f125268c), Long.valueOf(this.f125269d), Long.valueOf(this.f125267b), 200, Float.valueOf(this.f125270e), 80, Float.valueOf(this.f125275j), Boolean.valueOf(this.f125273h), Boolean.valueOf(this.f125274i));
    }

    public final void j() {
        this.f125266a = f0.f(d());
    }

    public final void k() {
        this.f125279n = true;
    }

    public final void l() {
        this.f125280o = true;
    }

    public final void a() {
        if (this.f125271f) {
            return;
        }
        long j3 = this.f125268c;
        this.f125267b = j3;
        a(j3);
        w.d("Luggage.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", Long.valueOf(this.f125267b));
    }

    public final void b(long j3) {
        if (this.f125271f) {
            return;
        }
        this.f125271f = true;
        this.f125267b = Math.max(this.f125269d, Math.min(this.f125268c, ((float) j3) * this.f125270e));
    }

    public final void a(long j3) {
        w.d("Luggage.ScanRetryManager", "alvinluo saveTimeout %d", Long.valueOf(j3));
        f0 f0Var = this.f125266a;
        if (f0Var != null) {
            f0Var.putLong("scan_code_retry_timeout", j3);
        }
        f0 f0Var2 = this.f125266a;
        if (f0Var2 != null) {
            f0Var2.apply();
        }
    }

    public final void b(int i3) {
        w.d("Luggage.ScanRetryManager", "alvinluo cancelRetryType: %d", Integer.valueOf(i3));
        if (i3 == 1) {
            this.f125273h = false;
        } else {
            if (i3 != 2) {
                return;
            }
            this.f125274i = false;
        }
    }

    public final boolean a(int i3) {
        if (i3 == 1) {
            return this.f125273h;
        }
        if (i3 != 2) {
            return false;
        }
        return this.f125274i;
    }
}
