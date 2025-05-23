package com.qzone.component;

import android.graphics.RectF;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public RectF f46632a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public b f46633b = new b(0.0d, 0.0d);

    /* renamed from: c, reason: collision with root package name */
    public a f46634c = new a(0.0d, 0.0d);

    /* renamed from: d, reason: collision with root package name */
    public int f46635d = 0;

    public String toString() {
        return "ItemStatus{rect=" + this.f46632a + ", velocity=" + this.f46633b + ", acceleration=" + this.f46634c + '}';
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public double f46636a;

        /* renamed from: b, reason: collision with root package name */
        public double f46637b;

        public a(double d16, double d17) {
            this.f46636a = d16;
            this.f46637b = d17;
        }

        public void a(a aVar) {
            this.f46636a = aVar.f46636a;
            this.f46637b = aVar.f46637b;
        }

        public String toString() {
            return "Acceleration{ax=" + this.f46636a + ", ay=" + this.f46637b + '}';
        }

        public a(a aVar) {
            a(aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f46638a;

        /* renamed from: b, reason: collision with root package name */
        public double f46639b;

        public b(double d16, double d17) {
            this.f46638a = d16;
            this.f46639b = d17;
        }

        public void a(b bVar) {
            this.f46638a = bVar.f46638a;
            this.f46639b = bVar.f46639b;
        }

        public String toString() {
            return "Velocity{vx=" + this.f46638a + ", vy=" + this.f46639b + '}';
        }

        public b(b bVar) {
            a(bVar);
        }
    }
}
