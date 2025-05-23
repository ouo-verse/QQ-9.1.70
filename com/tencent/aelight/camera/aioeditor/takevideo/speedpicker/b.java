package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends Drawable implements Animatable {
    private Drawable N;
    private Drawable R;
    private ValueAnimator U;
    private WeakReference<k> V;

    /* renamed from: d, reason: collision with root package name */
    private float f68879d = 16.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f68881e = 5.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f68882f = 50.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f68883h = 50.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f68884i = 30.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f68885m = 22.0f;
    private com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.e C = new com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.e();
    private RectF D = new RectF();
    private RectF E = new RectF();
    private int F = 0;
    private int G = 255;
    private int H = 0;
    private int I = 179;
    private int J = 0;
    private int K = 179;
    private com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f L = new com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f();
    private RectF M = new RectF();
    private int P = -1;
    private boolean Q = false;
    private boolean S = false;
    private int T = 0;
    Property<b, Float> W = new C0618b(Float.class, "backHeight");
    Property<b, Integer> X = new c(Integer.class, "backAlpha");
    Property<b, Integer> Y = new d(Integer.class, "speedAlpha");
    Property<b, Integer> Z = new e(Integer.class, "reverseAlpha");

    /* renamed from: a0, reason: collision with root package name */
    Property<b, Float> f68876a0 = new f(Float.class, "foreSpeed");

    /* renamed from: b0, reason: collision with root package name */
    Property<b, Float> f68877b0 = new g(Float.class, "foreHeight");

    /* renamed from: c0, reason: collision with root package name */
    Property<b, Float> f68878c0 = new h(Float.class, "speedPos");

    /* renamed from: d0, reason: collision with root package name */
    Property<b, Integer> f68880d0 = new i(Integer.class, "markAlpha");

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f extends Property<b, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(b bVar) {
            return Float.valueOf(bVar.Q());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Float f16) {
            bVar.e0(f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class g extends Property<b, Float> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(b bVar) {
            return Float.valueOf(bVar.P());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Float f16) {
            bVar.d0(f16.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface k {
        void a(int i3);

        void c(int i3);

        void e(int i3, int i16, RectF rectF);

        void f(int i3);

        void g(int i3, RectF rectF);
    }

    private void G(Canvas canvas, boolean z16) {
        RectF b16 = this.L.b(this.H - 1);
        if (b16 == null || this.R == null) {
            return;
        }
        float centerX = b16.centerX();
        float centerY = b16.centerY();
        float f16 = this.f68884i;
        float f17 = centerX - (f16 / 2.0f);
        float f18 = this.f68885m;
        float f19 = centerY - (f18 / 2.0f);
        this.R.setBounds((int) f17, (int) f19, (int) (f16 + f17), (int) (f18 + f19));
        if (!z16) {
            this.R.setAlpha(this.J);
        } else {
            this.R.setAlpha(255);
        }
        this.R.draw(canvas);
    }

    private void H(Canvas canvas) {
        RectF b16 = this.L.b(this.P);
        if (b16 != null) {
            float centerX = b16.centerX();
            float centerY = b16.centerY();
            float width = centerX - (this.E.width() / 2.0f);
            float height = centerY - (this.E.height() / 2.0f);
            float width2 = this.E.width() + width;
            float height2 = this.E.height() + height;
            canvas.save();
            Drawable drawable = this.N;
            if (drawable != null) {
                drawable.setBounds((int) width, (int) height, (int) width2, (int) height2);
                this.N.setAlpha(this.G);
                this.N.draw(canvas);
            }
            canvas.restore();
        }
    }

    private void I(Canvas canvas) {
        Drawable drawable = this.N;
        if (drawable != null) {
            RectF rectF = this.E;
            drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.N.setAlpha(this.G);
            this.N.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i3) {
        k kVar;
        WeakReference<k> weakReference = this.V;
        if (weakReference == null || (kVar = weakReference.get()) == null) {
            return;
        }
        kVar.f(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i3) {
        k kVar;
        WeakReference<k> weakReference = this.V;
        if (weakReference == null || (kVar = weakReference.get()) == null) {
            return;
        }
        kVar.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i3) {
        k kVar;
        WeakReference<k> weakReference = this.V;
        if (weakReference == null || (kVar = weakReference.get()) == null) {
            return;
        }
        kVar.c(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float O() {
        return this.D.height();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float P() {
        return this.M.height();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float Q() {
        return this.E.height();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int V() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float X() {
        return this.E.centerY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(int i3) {
        int i16 = this.T;
        if (i16 != 3 && i16 != 1) {
            this.F = 115;
        } else {
            this.F = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(float f16) {
        int i3 = this.T;
        if (i3 == 1 || i3 == 3) {
            f0(this.D, f16);
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.e eVar = this.C;
            if (eVar != null) {
                eVar.d(this.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(float f16) {
        k kVar;
        int i3 = this.T;
        if (i3 == 1 || i3 == 3) {
            f0(this.M, f16);
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
            if (fVar != null) {
                fVar.f(this.M);
                WeakReference<k> weakReference = this.V;
                if (weakReference == null || (kVar = weakReference.get()) == null) {
                    return;
                }
                kVar.g(this.T, S());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Float f16) {
        if (this.T == 3) {
            RectF rectF = this.E;
            rectF.left = rectF.centerX() - (f16.floatValue() / 2.0f);
            RectF rectF2 = this.E;
            rectF2.right = rectF2.centerX() + (f16.floatValue() / 2.0f);
            RectF rectF3 = this.E;
            rectF3.top = rectF3.centerY() - (f16.floatValue() / 2.0f);
            RectF rectF4 = this.E;
            rectF4.bottom = rectF4.centerY() + (f16.floatValue() / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(int i3) {
        int i16 = this.T;
        if (i16 == 3 || i16 == 1) {
            this.K = i3;
        } else if (i16 == 0) {
            this.K = 179;
        } else {
            this.K = 127;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(int i3) {
        int i16 = this.T;
        if (i16 == 1) {
            this.J = i3;
            this.I = 255 - i3;
        } else if (i16 == 3) {
            this.J = i3;
            this.I = (int) ((((255 - i3) * 179) * 1.0f) / 255.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(int i3) {
        int i16 = this.T;
        if (i16 != 1 && i16 != 3) {
            this.F = 255;
        } else {
            this.G = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(float f16) {
        k kVar;
        if (this.T == 4) {
            this.E.offset(0.0f, f16 - this.E.centerY());
            WeakReference<k> weakReference = this.V;
            if (weakReference == null || (kVar = weakReference.get()) == null) {
                return;
            }
            kVar.g(this.T, this.E);
        }
    }

    private void l0(Context context) {
        this.f68882f = PickerContainer.r(context, this.f68882f);
        this.f68883h = PickerContainer.r(context, this.f68883h);
        this.f68884i = PickerContainer.r(context, this.f68884i);
        this.f68885m = PickerContainer.r(context, this.f68885m);
        this.f68881e = PickerContainer.r(context, this.f68881e);
        this.f68879d /= context.getResources().getDisplayMetrics().density;
    }

    public int M() {
        return this.T;
    }

    public RectF S() {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
        if (fVar != null) {
            return fVar.b(this.P);
        }
        return null;
    }

    public RectF T(float f16) {
        int m06 = m0(f16);
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
        if (fVar != null) {
            return fVar.b(m06);
        }
        return null;
    }

    public RectF U(int i3) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
        if (fVar != null) {
            return fVar.b(i3);
        }
        return null;
    }

    public boolean Y(Context context, int i3, float f16, float f17, k kVar) {
        this.V = new WeakReference<>(kVar);
        if (i3 > 0) {
            this.f68879d /= i3;
        }
        l0(context);
        this.H = i3;
        this.L.c(-1, i3, this.f68881e, f16, f17);
        this.C.b(0, f16, f17);
        this.N = context.getResources().getDrawable(R.drawable.d5a);
        this.R = context.getResources().getDrawable(R.drawable.d5_);
        return true;
    }

    public RectF Z(int i3, boolean z16, boolean z17) {
        RectF b16;
        WeakReference<k> weakReference;
        k kVar;
        int i16 = this.P;
        this.P = i3;
        if (z16) {
            this.Q = z16;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
        if (fVar != null && (b16 = fVar.b(i3)) != null) {
            if (!z17) {
                this.E.set(b16.centerX() - (this.f68882f / 2.0f), b16.centerY() - (this.f68883h / 2.0f), b16.centerX() + (this.f68883h / 2.0f), b16.centerY() + (this.f68883h / 2.0f));
                if (z16 && (weakReference = this.V) != null && (kVar = weakReference.get()) != null) {
                    kVar.e(this.T, this.P, b16);
                    this.Q = false;
                }
                invalidateSelf();
            } else {
                RectF b17 = this.L.b(i16);
                if (b17 != null) {
                    this.E.set(b17.centerX() - (this.f68882f / 2.0f), b17.centerY() - (this.f68883h / 2.0f), b17.centerX() + (this.f68883h / 2.0f), b17.centerY() + (this.f68883h / 2.0f));
                    float abs = Math.abs(b17.centerY() - b16.centerY()) * this.f68879d;
                    if (isRunning()) {
                        stop();
                    }
                    this.T = 4;
                    this.S = true;
                    k0(4, (int) abs, b17.centerY(), b16.centerY());
                }
            }
        }
        return this.E;
    }

    public void a0(int i3) {
        this.T = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i3 = this.T;
        if (i3 == 0) {
            this.L.a(canvas, this.I, this.P, (int) (((this.J * 1.0f) * 179.0f) / 255.0f), this.K);
            int i16 = this.P;
            if (i16 < 0 || i16 >= this.H) {
                return;
            }
            H(canvas);
            return;
        }
        if (i3 == 1 || i3 == 3 || i3 == 2) {
            this.C.a(canvas, this.F);
            this.L.a(canvas, this.I, this.P, (int) (((this.J * 1.0f) * 127.0f) / 255.0f), this.K);
            G(canvas, false);
            int i17 = this.T;
            if (i17 == 3 || i17 == 1) {
                if (this.P == this.H - 1) {
                    G(canvas, true);
                    return;
                } else {
                    H(canvas);
                    return;
                }
            }
            return;
        }
        if (i3 == 4) {
            RectF S = S();
            if (S != null) {
                if (Math.abs(S.centerY() - this.E.centerY()) < this.E.height() / 2.0f) {
                    this.L.a(canvas, this.I, this.P, (int) (((this.J * 1.0f) * 179.0f) / 255.0f), this.K);
                } else {
                    this.L.a(canvas, this.I, -1, (int) (((this.J * 1.0f) * 179.0f) / 255.0f), this.K);
                }
            }
            int i18 = this.P;
            if (i18 < 0 || i18 >= this.H) {
                return;
            }
            I(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.S;
    }

    public int m0(float f16) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
        if (fVar != null) {
            return fVar.d(f16);
        }
        return 0;
    }

    public void o0() {
        this.L.e();
        this.C.c();
        this.N = null;
        this.R = null;
        this.S = false;
        ValueAnimator valueAnimator = this.U;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.U.removeAllUpdateListeners();
            this.U = null;
        }
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f68876a0 = null;
        this.f68877b0 = null;
        this.f68878c0 = null;
        this.f68880d0 = null;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        WeakReference<k> weakReference;
        k kVar;
        super.onBoundsChange(rect);
        n0(rect);
        int i3 = this.P;
        if (i3 >= 0) {
            Z(i3, false, false);
            if (this.Q && (weakReference = this.V) != null && (kVar = weakReference.get()) != null) {
                RectF rectF = new RectF();
                rectF.set(this.E);
                kVar.e(this.T, this.P, rectF);
                this.Q = false;
            }
            this.Q = false;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            stop();
        }
        this.S = true;
        if (QLog.isColorLevel()) {
            QLog.d("GroundDrawable", 2, "start :" + this.T);
        }
        int i3 = this.T;
        if (i3 == 1 || i3 == 0) {
            this.T = 1;
            k0(1, 300, -1.0f, -1.0f);
        } else if (i3 == 3 || i3 == 2) {
            this.T = 3;
            k0(3, 200, -1.0f, -1.0f);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.S) {
            this.S = false;
            ValueAnimator valueAnimator = this.U;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.U.removeAllUpdateListeners();
                this.U = null;
            }
            int i3 = this.T;
            if (i3 == 1) {
                this.T = 2;
                n0(getBounds());
                this.F = 115;
            } else if (i3 == 3) {
                this.T = 0;
                n0(getBounds());
                this.F = 115;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0618b extends Property<b, Float> {
        C0618b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(b bVar) {
            if (bVar != null) {
                return Float.valueOf(bVar.O());
            }
            return Float.valueOf(0.0f);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Float f16) {
            if (bVar != null) {
                bVar.c0(f16.floatValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends Property<b, Integer> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(b bVar) {
            if (bVar != null) {
                return Integer.valueOf(bVar.N());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Integer num) {
            if (bVar != null) {
                bVar.b0(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends Property<b, Integer> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(b bVar) {
            if (bVar != null) {
                return Integer.valueOf(bVar.W());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Integer num) {
            if (bVar != null) {
                bVar.i0(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends Property<b, Integer> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(b bVar) {
            if (bVar != null) {
                return Integer.valueOf(bVar.V());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Integer num) {
            if (bVar != null) {
                bVar.h0(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class h extends Property<b, Float> {
        h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(b bVar) {
            if (bVar != null) {
                return Float.valueOf(bVar.X());
            }
            return Float.valueOf(0.0f);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Float f16) {
            if (bVar != null) {
                bVar.j0(f16.floatValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class i extends Property<b, Integer> {
        i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(b bVar) {
            if (bVar != null) {
                return Integer.valueOf(bVar.R());
            }
            return 0;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(b bVar, Integer num) {
            if (bVar != null) {
                bVar.g0(num.intValue());
            }
        }
    }

    private void f0(RectF rectF, float f16) {
        if (rectF == null) {
            return;
        }
        Rect bounds = getBounds();
        if (bounds.height() < f16) {
            f16 = bounds.height();
        }
        float width = ((bounds.width() * 1.0f) / bounds.height()) * f16;
        if (bounds.width() < width) {
            width = bounds.width();
        }
        float width2 = (bounds.width() - width) / 2.0f;
        float height = (bounds.height() - f16) / 2.0f;
        rectF.set(width2, height, width + width2, f16 + height);
    }

    private void n0(Rect rect) {
        if (rect == null) {
            return;
        }
        if (this.S) {
            if (QLog.isColorLevel()) {
                QLog.d("GroundDrawable", 2, "isrunning, cannot resetdata:" + this.T);
                return;
            }
            return;
        }
        int i3 = this.T;
        if (i3 == 0 || i3 == 1) {
            f0(this.D, rect.height() * 0.4f);
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.e eVar = this.C;
            if (eVar != null) {
                eVar.d(this.D);
            }
            f0(this.M, rect.height() * 0.9f);
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar = this.L;
            if (fVar != null) {
                fVar.f(this.M);
                return;
            }
            return;
        }
        if (i3 == 3 || i3 == 2) {
            f0(this.D, rect.height());
            f0(this.M, rect.height());
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.e eVar2 = this.C;
            if (eVar2 != null) {
                eVar2.d(this.D);
            }
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.f fVar2 = this.L;
            if (fVar2 != null) {
                fVar2.f(this.M);
            }
        }
    }

    private void k0(int i3, int i16, float f16, float f17) {
        ValueAnimator valueAnimator = this.U;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.U.removeAllUpdateListeners();
            this.U = null;
        }
        int height = getBounds().height();
        if (i3 == 1) {
            float f18 = height;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(this.W, this.D.height(), f18), PropertyValuesHolder.ofFloat(this.f68877b0, this.M.height(), f18), PropertyValuesHolder.ofInt(this.Y, this.G, 0), PropertyValuesHolder.ofInt(this.Z, this.J, 255), PropertyValuesHolder.ofInt(this.X, this.F, 115), PropertyValuesHolder.ofInt(this.f68880d0, this.K, 127));
            this.U = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(i16);
        } else if (i3 == 3) {
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofInt(this.X, this.F, 0), PropertyValuesHolder.ofFloat(this.f68877b0, this.M.height(), (int) (height * 0.9f)), PropertyValuesHolder.ofFloat(this.f68876a0, this.E.height(), (int) this.f68882f), PropertyValuesHolder.ofInt(this.Z, this.J, 0), PropertyValuesHolder.ofFloat(this.W, this.D.height(), 0.0f), PropertyValuesHolder.ofInt(this.Y, this.G, 255), PropertyValuesHolder.ofInt(this.f68880d0, this.K, 179));
            this.U = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setDuration(i16);
        } else if (i3 == 4) {
            ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(this.f68878c0, f16, f17));
            this.U = ofPropertyValuesHolder3;
            ofPropertyValuesHolder3.setDuration(i16);
        }
        ValueAnimator valueAnimator2 = this.U;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatMode(1);
            this.U.setRepeatCount(0);
            this.U.setStartDelay(0L);
            this.U.addUpdateListener(new j());
            this.U.addListener(new a());
            this.U.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            k kVar;
            if (b.this.S) {
                b.this.S = false;
                b bVar = b.this;
                bVar.J(bVar.T);
                if (b.this.T != 1) {
                    if (b.this.T != 3) {
                        if (b.this.T == 4) {
                            if (b.this.Q && b.this.V != null && (kVar = (k) b.this.V.get()) != null) {
                                RectF b16 = b.this.L.b(b.this.P);
                                if (b16 != null) {
                                    kVar.e(b.this.T, b.this.P, b16);
                                } else {
                                    QLog.d("GroundDrawable", 2, "onGroundMarkSelected error 2 !! rc is null:" + b.this.P);
                                }
                                b.this.Q = false;
                            }
                            b.this.a0(0);
                            return;
                        }
                        return;
                    }
                    b.this.a0(0);
                    return;
                }
                b.this.a0(2);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k kVar;
            if (b.this.isRunning()) {
                b.this.S = false;
                b bVar = b.this;
                bVar.K(bVar.T);
                if (b.this.T != 1) {
                    if (b.this.T != 3) {
                        if (b.this.T == 4) {
                            if (b.this.Q && b.this.V != null && (kVar = (k) b.this.V.get()) != null) {
                                RectF b16 = b.this.L.b(b.this.P);
                                if (b16 != null) {
                                    kVar.e(b.this.T, b.this.P, b16);
                                } else {
                                    QLog.d("GroundDrawable", 2, "onGroundMarkSelected error!! rc is null:" + b.this.P);
                                }
                                b.this.Q = false;
                            }
                            b.this.a0(0);
                            return;
                        }
                        return;
                    }
                    b.this.a0(0);
                    return;
                }
                b.this.a0(2);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (b.this.isRunning()) {
                b bVar = b.this;
                bVar.L(bVar.T);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
