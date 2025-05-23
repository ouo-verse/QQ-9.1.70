package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ic {

    /* renamed from: b, reason: collision with root package name */
    public boolean f148766b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f148768d;

    /* renamed from: g, reason: collision with root package name */
    private boolean f148771g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f148772h;

    /* renamed from: a, reason: collision with root package name */
    protected long f148765a = 1500;

    /* renamed from: c, reason: collision with root package name */
    protected long f148767c = 0;

    /* renamed from: i, reason: collision with root package name */
    private Interpolator f148773i = new LinearInterpolator();

    /* renamed from: e, reason: collision with root package name */
    protected a f148769e = null;

    /* renamed from: f, reason: collision with root package name */
    protected b f148770f = null;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class a {
        private static void a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(float f16) {
        }

        private static void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    private Interpolator c() {
        return this.f148773i;
    }

    private static long d() {
        return SystemClock.uptimeMillis();
    }

    private void e() {
        this.f148766b = false;
    }

    private boolean f() {
        return this.f148766b;
    }

    private boolean g() {
        return this.f148771g;
    }

    private boolean h() {
        return this.f148772h;
    }

    private boolean i() {
        return this.f148768d;
    }

    public final void a(a aVar) {
        this.f148769e = aVar;
    }

    public final void b() {
        if (!this.f148766b && this.f148772h && this.f148767c == 0) {
            this.f148767c = SystemClock.uptimeMillis();
            this.f148766b = true;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        float f16 = ((float) (uptimeMillis - this.f148767c)) / ((float) this.f148765a);
        if (f16 > 1.0f) {
            if (this.f148771g) {
                this.f148767c = uptimeMillis;
            } else {
                this.f148766b = false;
            }
            f16 = 1.0f;
        }
        Interpolator interpolator = this.f148773i;
        if (interpolator != null) {
            f16 = interpolator.getInterpolation(f16);
        }
        a(f16);
        if (this.f148766b) {
            return;
        }
        this.f148768d = true;
    }

    private void a(b bVar) {
        this.f148770f = bVar;
    }

    private void a(Interpolator interpolator) {
        this.f148773i = interpolator;
    }

    public final void a(long j3) {
        this.f148765a = j3;
    }

    public final boolean a() {
        return a(false);
    }

    public final boolean a(boolean z16) {
        if (this.f148765a <= 0 || this.f148772h) {
            return false;
        }
        this.f148772h = true;
        this.f148771g = z16;
        return true;
    }

    protected void a(float f16) {
        a aVar = this.f148769e;
        if (aVar != null) {
            aVar.a(f16);
        }
    }

    private float b(float f16) {
        Interpolator interpolator = this.f148773i;
        return interpolator != null ? interpolator.getInterpolation(f16) : f16;
    }
}
