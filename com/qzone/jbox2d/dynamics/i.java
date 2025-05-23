package com.qzone.jbox2d.dynamics;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final a f48251a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final a f48252b = new a();

    /* renamed from: c, reason: collision with root package name */
    public final a f48253c = new a();

    /* renamed from: d, reason: collision with root package name */
    public final a f48254d = new a();

    /* renamed from: e, reason: collision with root package name */
    public final a f48255e = new a();

    /* renamed from: f, reason: collision with root package name */
    public final a f48256f = new a();

    /* renamed from: g, reason: collision with root package name */
    public final a f48257g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final a f48258h = new a();

    /* renamed from: i, reason: collision with root package name */
    public final a f48259i = new a();

    /* renamed from: j, reason: collision with root package name */
    public final a f48260j = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        float f48261a;

        /* renamed from: b, reason: collision with root package name */
        float f48262b;

        /* renamed from: c, reason: collision with root package name */
        float f48263c = Float.MAX_VALUE;

        /* renamed from: d, reason: collision with root package name */
        float f48264d = -3.4028235E38f;

        /* renamed from: e, reason: collision with root package name */
        float f48265e;

        public void a(float f16) {
            this.f48265e += f16;
        }

        public void b() {
            c(this.f48265e);
        }

        public void c(float f16) {
            this.f48261a = (this.f48261a * 0.95f) + (0.05f * f16);
            this.f48262b = (this.f48262b * 0.8f) + (0.2f * f16);
            this.f48263c = com.qzone.jbox2d.common.b.l(f16, this.f48263c);
            this.f48264d = com.qzone.jbox2d.common.b.j(f16, this.f48264d);
        }

        public void d() {
            this.f48265e = 0.0f;
        }

        public String toString() {
            return String.format("%.2f (%.2f) [%.2f,%.2f]", Float.valueOf(this.f48262b), Float.valueOf(this.f48261a), Float.valueOf(this.f48263c), Float.valueOf(this.f48264d));
        }
    }
}
