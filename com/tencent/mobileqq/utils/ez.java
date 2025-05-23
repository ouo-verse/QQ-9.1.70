package com.tencent.mobileqq.utils;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ez<T> extends Animation {
    static final g F = new a();
    static final g G = new b();
    static final g H = new c();
    static final g I = new d();
    static final g J = new e();
    protected boolean C;
    protected boolean D;
    private long E;

    /* renamed from: d, reason: collision with root package name */
    protected T f307762d;

    /* renamed from: e, reason: collision with root package name */
    protected T f307763e;

    /* renamed from: f, reason: collision with root package name */
    protected g<T> f307764f;

    /* renamed from: h, reason: collision with root package name */
    protected f<T> f307765h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f307766i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f307767m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements g<Integer> {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.ez.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer evaluate(float f16, Integer num, Integer num2) {
            return Integer.valueOf((int) (num.intValue() + (f16 * (num2.intValue() - r3))));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements g<Number> {
        b() {
        }

        @Override // com.tencent.mobileqq.utils.ez.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f16, Number number, Number number2) {
            float floatValue = number.floatValue();
            return Float.valueOf(floatValue + (f16 * (number2.floatValue() - floatValue)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements g<Rect> {
        c() {
        }

        @Override // com.tencent.mobileqq.utils.ez.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect evaluate(float f16, Rect rect, Rect rect2) {
            return new Rect(rect.left + ((int) ((rect2.left - r1) * f16)), rect.top + ((int) ((rect2.top - r2) * f16)), rect.right + ((int) ((rect2.right - r3) * f16)), rect.bottom + ((int) ((rect2.bottom - r7) * f16)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements g<Point> {
        d() {
        }

        @Override // com.tencent.mobileqq.utils.ez.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Point evaluate(float f16, Point point, Point point2) {
            float f17 = point.x;
            float f18 = point.y;
            return new Point((int) (f17 + ((point2.x - f17) * f16)), (int) (f18 + (f16 * (point2.y - f18))));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e implements g<PointF> {
        e() {
        }

        @Override // com.tencent.mobileqq.utils.ez.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF evaluate(float f16, PointF pointF, PointF pointF2) {
            float f17 = pointF.x;
            float f18 = pointF.y;
            return new PointF(f17 + ((pointF2.x - f17) * f16), f18 + (f16 * (pointF2.y - f18)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f<T> {
        void a(ez<T> ezVar, float f16, T t16, Transformation transformation);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    interface g<T> {
        T evaluate(float f16, T t16, T t17);
    }

    public ez(T t16, T t17, f<T> fVar) {
        this(t16, t17, fVar, false, false, null);
    }

    public void a(f<T> fVar) {
        this.f307765h = fVar;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f16, Transformation transformation) {
        f<T> fVar = this.f307765h;
        if (fVar != null) {
            fVar.a(this, f16, this.f307764f.evaluate(f16, this.f307762d, this.f307763e), transformation);
        }
    }

    public void b(long j3) {
        this.E = j3;
    }

    @Override // android.view.animation.Animation
    public void cancel() {
        this.C = true;
        super.cancel();
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j3, Transformation transformation) {
        if (this.D) {
            if (this.E == 0) {
                b(j3 - getStartTime());
            }
            setStartTime(j3 - this.E);
        }
        return super.getTransformation(j3, transformation);
    }

    @Override // android.view.animation.Animation
    public void reset() {
        this.C = false;
        super.reset();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return this.f307766i;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return this.f307767m;
    }

    public ez(T t16, T t17, f<T> fVar, boolean z16, boolean z17, g<T> gVar) {
        this.E = 0L;
        Class<?> cls = t16.getClass();
        if (gVar != null) {
            this.f307764f = gVar;
        } else if (cls == Integer.class) {
            this.f307764f = F;
        } else if (Float.class == cls) {
            this.f307764f = G;
        } else if (Rect.class == cls) {
            this.f307764f = H;
        } else if (Point.class == cls) {
            this.f307764f = I;
        } else if (PointF.class == cls) {
            this.f307764f = J;
        } else {
            throw new IllegalArgumentException("Can't support type " + t16.getClass().getSimpleName());
        }
        this.f307762d = t16;
        this.f307763e = t17;
        a(fVar);
        this.f307766i = z16;
        this.f307767m = z17;
    }
}
