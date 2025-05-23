package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class jf implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    float f148865a;

    /* renamed from: b, reason: collision with root package name */
    Class<?> f148866b;

    /* renamed from: c, reason: collision with root package name */
    Interpolator f148867c = null;

    /* renamed from: d, reason: collision with root package name */
    boolean f148868d = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class c extends jf {

        /* renamed from: e, reason: collision with root package name */
        Object f148871e;

        c(float f16, Object obj) {
            boolean z16;
            Class<?> cls;
            this.f148865a = f16;
            this.f148871e = obj;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f148868d = z16;
            if (z16) {
                cls = obj.getClass();
            } else {
                cls = Object.class;
            }
            this.f148866b = cls;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.mapsdk.internal.jf
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public c e() {
            c cVar = new c(this.f148865a, this.f148871e);
            cVar.f148867c = this.f148867c;
            return cVar;
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final void a(Object obj) {
            boolean z16;
            this.f148871e = obj;
            if (obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f148868d = z16;
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final Object d() {
            return this.f148871e;
        }
    }

    public static jf a(float f16, int i3) {
        return new b(f16, i3);
    }

    public static jf b() {
        return new a();
    }

    public static jf c() {
        return new c(0.0f, null);
    }

    private boolean f() {
        return this.f148868d;
    }

    private float g() {
        return this.f148865a;
    }

    private Interpolator h() {
        return this.f148867c;
    }

    private Class i() {
        return this.f148866b;
    }

    public abstract void a(Object obj);

    public abstract Object d();

    @Override // 
    public abstract jf e();

    public static jf a() {
        return new b();
    }

    public static jf a(float f16, double d16) {
        return new a(f16, d16);
    }

    public static jf a(float f16, Object obj) {
        return new c(f16, obj);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a extends jf {

        /* renamed from: e, reason: collision with root package name */
        double f148869e;

        a(float f16, double d16) {
            this.f148865a = f16;
            this.f148869e = d16;
            this.f148866b = Double.TYPE;
            this.f148868d = true;
        }

        private double f() {
            return this.f148869e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.mapsdk.internal.jf
        /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a e() {
            a aVar = new a(this.f148865a, this.f148869e);
            aVar.f148867c = this.f148867c;
            return aVar;
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final void a(Object obj) {
            if (obj != null && obj.getClass() == Double.class) {
                this.f148869e = ((Double) obj).doubleValue();
                this.f148868d = true;
            }
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final Object d() {
            return Double.valueOf(this.f148869e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
            this.f148865a = 0.0f;
            this.f148866b = Double.TYPE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class b extends jf {

        /* renamed from: e, reason: collision with root package name */
        int f148870e;

        b(float f16, int i3) {
            this.f148865a = f16;
            this.f148870e = i3;
            this.f148866b = Integer.TYPE;
            this.f148868d = true;
        }

        private int f() {
            return this.f148870e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tencent.mapsdk.internal.jf
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b e() {
            b bVar = new b(this.f148865a, this.f148870e);
            bVar.f148867c = this.f148867c;
            return bVar;
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final void a(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f148870e = ((Integer) obj).intValue();
                this.f148868d = true;
            }
        }

        @Override // com.tencent.mapsdk.internal.jf
        public final Object d() {
            return Integer.valueOf(this.f148870e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            this.f148865a = 0.0f;
            this.f148866b = Integer.TYPE;
        }
    }

    private void a(float f16) {
        this.f148865a = f16;
    }

    private void a(Interpolator interpolator) {
        this.f148867c = interpolator;
    }
}
