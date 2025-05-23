package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class in {

    /* renamed from: a, reason: collision with root package name */
    protected long f148799a = 1500;

    /* renamed from: b, reason: collision with root package name */
    public boolean f148800b = false;

    /* renamed from: c, reason: collision with root package name */
    protected long f148801c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f148802d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f148803e = false;

    /* renamed from: f, reason: collision with root package name */
    public Interpolator f148804f = new LinearInterpolator();

    /* renamed from: g, reason: collision with root package name */
    protected a f148805g = null;

    /* renamed from: h, reason: collision with root package name */
    protected b f148806h = null;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(float f16);

        void a(float f16, float f17);

        void a(float f16, float f17, float f18, float f19);

        void a(int i3, int i16);

        void b(float f16);
    }

    private Interpolator c() {
        return this.f148804f;
    }

    private static long d() {
        return SystemClock.uptimeMillis();
    }

    private void e() {
        this.f148800b = false;
    }

    private boolean f() {
        return this.f148800b;
    }

    private boolean g() {
        return this.f148802d;
    }

    private boolean h() {
        return this.f148803e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(float f16, Interpolator interpolator);

    public final void a(a aVar) {
        this.f148805g = aVar;
    }

    public final void b() {
        a aVar;
        if (!this.f148800b) {
            if (this.f148802d && !this.f148803e && (aVar = this.f148805g) != null) {
                aVar.b();
                return;
            }
            return;
        }
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f148801c)) / ((float) this.f148799a);
        if (uptimeMillis > 1.0f) {
            this.f148800b = false;
            a(1.0f, this.f148804f);
            a aVar2 = this.f148805g;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.f148803e = true;
            return;
        }
        a(uptimeMillis, this.f148804f);
    }

    public void a(b bVar) {
        this.f148806h = bVar;
    }

    private void a(Interpolator interpolator) {
        this.f148804f = interpolator;
    }

    public void a(long j3) {
        this.f148799a = j3;
    }

    public final long a() {
        return this.f148799a;
    }

    public boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.f148799a <= 0) {
            return false;
        }
        this.f148802d = true;
        this.f148801c = SystemClock.uptimeMillis();
        this.f148800b = true;
        a aVar = this.f148805g;
        if (aVar != null) {
            aVar.a();
        }
        return true;
    }
}
