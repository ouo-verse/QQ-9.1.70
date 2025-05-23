package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class d {
    static final TimeInterpolator D = x0.a.f446812c;
    static final int[] E = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] F = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] G = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] H = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] I = {R.attr.state_enabled};
    static final int[] J = new int[0];

    @Nullable
    private ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    com.google.android.material.shape.g f33695a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    MaterialShapeDrawable f33696b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    Drawable f33697c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    com.google.android.material.floatingactionbutton.c f33698d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    Drawable f33699e;

    /* renamed from: f, reason: collision with root package name */
    boolean f33700f;

    /* renamed from: h, reason: collision with root package name */
    float f33702h;

    /* renamed from: i, reason: collision with root package name */
    float f33703i;

    /* renamed from: j, reason: collision with root package name */
    float f33704j;

    /* renamed from: k, reason: collision with root package name */
    int f33705k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.internal.k f33706l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Animator f33707m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private x0.h f33708n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private x0.h f33709o;

    /* renamed from: p, reason: collision with root package name */
    private float f33710p;

    /* renamed from: r, reason: collision with root package name */
    private int f33712r;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f33714t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f33715u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<j> f33716v;

    /* renamed from: w, reason: collision with root package name */
    final FloatingActionButton f33717w;

    /* renamed from: x, reason: collision with root package name */
    final i1.b f33718x;

    /* renamed from: g, reason: collision with root package name */
    boolean f33701g = true;

    /* renamed from: q, reason: collision with root package name */
    private float f33711q = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    private int f33713s = 0;

    /* renamed from: y, reason: collision with root package name */
    private final Rect f33719y = new Rect();

    /* renamed from: z, reason: collision with root package name */
    private final RectF f33720z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private boolean f33721d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f33722e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f33723f;

        a(boolean z16, k kVar) {
            this.f33722e = z16;
            this.f33723f = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f33721d = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            d.this.f33713s = 0;
            d.this.f33707m = null;
            if (!this.f33721d) {
                FloatingActionButton floatingActionButton = d.this.f33717w;
                boolean z16 = this.f33722e;
                if (z16) {
                    i3 = 8;
                } else {
                    i3 = 4;
                }
                floatingActionButton.b(i3, z16);
                k kVar = this.f33723f;
                if (kVar != null) {
                    kVar.onHidden();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f33717w.b(0, this.f33722e);
            d.this.f33713s = 1;
            d.this.f33707m = animator;
            this.f33721d = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f33725d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f33726e;

        b(boolean z16, k kVar) {
            this.f33725d = z16;
            this.f33726e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.f33713s = 0;
            d.this.f33707m = null;
            k kVar = this.f33726e;
            if (kVar != null) {
                kVar.onShown();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.f33717w.b(0, this.f33725d);
            d.this.f33713s = 2;
            d.this.f33707m = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends x0.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f16, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            d.this.f33711q = f16;
            return super.evaluate(f16, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0233d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float C;
        final /* synthetic */ Matrix D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f33729d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f33730e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f33731f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f33732h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f33733i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f33734m;

        C0233d(float f16, float f17, float f18, float f19, float f26, float f27, float f28, Matrix matrix) {
            this.f33729d = f16;
            this.f33730e = f17;
            this.f33731f = f18;
            this.f33732h = f19;
            this.f33733i = f26;
            this.f33734m = f27;
            this.C = f28;
            this.D = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.f33717w.setAlpha(x0.a.b(this.f33729d, this.f33730e, 0.0f, 0.2f, floatValue));
            d.this.f33717w.setScaleX(x0.a.a(this.f33731f, this.f33732h, floatValue));
            d.this.f33717w.setScaleY(x0.a.a(this.f33733i, this.f33732h, floatValue));
            d.this.f33711q = x0.a.a(this.f33734m, this.C, floatValue);
            d.this.h(x0.a.a(this.f33734m, this.C, floatValue), this.D);
            d.this.f33717w.setImageMatrix(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements TypeEvaluator<Float> {

        /* renamed from: a, reason: collision with root package name */
        FloatEvaluator f33735a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f16, Float f17, Float f18) {
            float floatValue = this.f33735a.evaluate(f16, (Number) f17, (Number) f18).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.D();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class g extends m {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return 0.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class h extends m {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.f33702h + dVar.f33703i;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class i extends m {
        i() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.f33702h + dVar.f33704j;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    interface j {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    interface k {
        void onHidden();

        void onShown();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class l extends m {
        l() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return d.this.f33702h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f33742d;

        /* renamed from: e, reason: collision with root package name */
        private float f33743e;

        /* renamed from: f, reason: collision with root package name */
        private float f33744f;

        m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.c0((int) this.f33744f);
            this.f33742d = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float w3;
            if (!this.f33742d) {
                MaterialShapeDrawable materialShapeDrawable = d.this.f33696b;
                if (materialShapeDrawable == null) {
                    w3 = 0.0f;
                } else {
                    w3 = materialShapeDrawable.w();
                }
                this.f33743e = w3;
                this.f33744f = a();
                this.f33742d = true;
            }
            d dVar = d.this;
            float f16 = this.f33743e;
            dVar.c0((int) (f16 + ((this.f33744f - f16) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(d dVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FloatingActionButton floatingActionButton, i1.b bVar) {
        this.f33717w = floatingActionButton;
        this.f33718x = bVar;
        com.google.android.material.internal.k kVar = new com.google.android.material.internal.k();
        this.f33706l = kVar;
        kVar.a(E, k(new i()));
        kVar.a(F, k(new h()));
        kVar.a(G, k(new h()));
        kVar.a(H, k(new h()));
        kVar.a(I, k(new l()));
        kVar.a(J, k(new g()));
        this.f33710p = floatingActionButton.getRotation();
    }

    private boolean W() {
        if (ViewCompat.isLaidOut(this.f33717w) && !this.f33717w.isInEditMode()) {
            return true;
        }
        return false;
    }

    private void d0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f16, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.f33717w.getDrawable() != null && this.f33712r != 0) {
            RectF rectF = this.f33720z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            int i3 = this.f33712r;
            rectF2.set(0.0f, 0.0f, i3, i3);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i16 = this.f33712r;
            matrix.postScale(f16, f16, i16 / 2.0f, i16 / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet i(@NonNull x0.h hVar, float f16, float f17, float f18) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f33717w, (Property<FloatingActionButton, Float>) View.ALPHA, f16);
        hVar.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f33717w, (Property<FloatingActionButton, Float>) View.SCALE_X, f17);
        hVar.h("scale").a(ofFloat2);
        d0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f33717w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f17);
        hVar.h("scale").a(ofFloat3);
        d0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f18, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f33717w, new x0.f(), new c(), new Matrix(this.B));
        hVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        x0.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f16, float f17, float f18) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C0233d(this.f33717w.getAlpha(), f16, this.f33717w.getScaleX(), f17, this.f33717w.getScaleY(), this.f33711q, f18, new Matrix(this.B)));
        arrayList.add(ofFloat);
        x0.b.a(animatorSet, arrayList);
        animatorSet.setDuration(f1.a.d(this.f33717w.getContext(), com.tencent.mobileqq.R.attr.axa, this.f33717w.getContext().getResources().getInteger(com.tencent.mobileqq.R.integer.f167190bi)));
        animatorSet.setInterpolator(f1.a.e(this.f33717w.getContext(), com.tencent.mobileqq.R.attr.axk, x0.a.f446811b));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener o() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int[] iArr) {
        throw null;
    }

    void B(float f16, float f17, float f18) {
        throw null;
    }

    void C(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f33699e, "Didn't initialize content background");
        if (V()) {
            this.f33718x.setBackgroundDrawable(new InsetDrawable(this.f33699e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.f33718x.setBackgroundDrawable(this.f33699e);
        }
    }

    void D() {
        float rotation = this.f33717w.getRotation();
        if (this.f33710p != rotation) {
            this.f33710p = rotation;
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        ArrayList<j> arrayList = this.f33716v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        ArrayList<j> arrayList = this.f33716v;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    boolean G() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f33696b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f33698d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f33696b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void J(float f16) {
        if (this.f33702h != f16) {
            this.f33702h = f16;
            B(f16, this.f33703i, this.f33704j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z16) {
        this.f33700f = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(@Nullable x0.h hVar) {
        this.f33709o = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(float f16) {
        if (this.f33703i != f16) {
            this.f33703i = f16;
            B(this.f33702h, f16, this.f33704j);
        }
    }

    final void N(float f16) {
        this.f33711q = f16;
        Matrix matrix = this.B;
        h(f16, matrix);
        this.f33717w.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(int i3) {
        if (this.f33712r != i3) {
            this.f33712r = i3;
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(int i3) {
        this.f33705k = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f16) {
        if (this.f33704j != f16) {
            this.f33704j = f16;
            B(this.f33702h, this.f33703i, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f33697c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, h1.b.d(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(boolean z16) {
        this.f33701g = z16;
        b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(@NonNull com.google.android.material.shape.g gVar) {
        this.f33695a = gVar;
        MaterialShapeDrawable materialShapeDrawable = this.f33696b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(gVar);
        }
        Object obj = this.f33697c;
        if (obj instanceof j1.f) {
            ((j1.f) obj).setShapeAppearanceModel(gVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f33698d;
        if (cVar != null) {
            cVar.f(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(@Nullable x0.h hVar) {
        this.f33708n = hVar;
    }

    boolean V() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean X() {
        if (this.f33700f && this.f33717w.p() < this.f33705k) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(@Nullable k kVar, boolean z16) {
        boolean z17;
        AnimatorSet j3;
        float f16;
        float f17;
        if (v()) {
            return;
        }
        Animator animator = this.f33707m;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f33708n == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (W()) {
            if (this.f33717w.getVisibility() != 0) {
                float f18 = 0.0f;
                this.f33717w.setAlpha(0.0f);
                FloatingActionButton floatingActionButton = this.f33717w;
                if (z17) {
                    f16 = 0.4f;
                } else {
                    f16 = 0.0f;
                }
                floatingActionButton.setScaleY(f16);
                FloatingActionButton floatingActionButton2 = this.f33717w;
                if (z17) {
                    f17 = 0.4f;
                } else {
                    f17 = 0.0f;
                }
                floatingActionButton2.setScaleX(f17);
                if (z17) {
                    f18 = 0.4f;
                }
                N(f18);
            }
            x0.h hVar = this.f33708n;
            if (hVar != null) {
                j3 = i(hVar, 1.0f, 1.0f, 1.0f);
            } else {
                j3 = j(1.0f, 1.0f, 1.0f);
            }
            j3.addListener(new b(z16, kVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f33714t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j3.addListener(it.next());
                }
            }
            j3.start();
            return;
        }
        this.f33717w.b(0, z16);
        this.f33717w.setAlpha(1.0f);
        this.f33717w.setScaleY(1.0f);
        this.f33717w.setScaleX(1.0f);
        N(1.0f);
        if (kVar != null) {
            kVar.onShown();
        }
    }

    void Z() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0() {
        N(this.f33711q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0() {
        Rect rect = this.f33719y;
        p(rect);
        C(rect);
        this.f33718x.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c0(float f16) {
        MaterialShapeDrawable materialShapeDrawable = this.f33696b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.X(f16);
        }
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f33715u == null) {
            this.f33715u = new ArrayList<>();
        }
        this.f33715u.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f33714t == null) {
            this.f33714t = new ArrayList<>();
        }
        this.f33714t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull j jVar) {
        if (this.f33716v == null) {
            this.f33716v = new ArrayList<>();
        }
        this.f33716v.add(jVar);
    }

    float l() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f33700f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final x0.h n() {
        return this.f33709o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull Rect rect) {
        int i3;
        float f16;
        if (this.f33700f) {
            i3 = (this.f33705k - this.f33717w.p()) / 2;
        } else {
            i3 = 0;
        }
        if (this.f33701g) {
            f16 = l() + this.f33704j;
        } else {
            f16 = 0.0f;
        }
        int max = Math.max(i3, (int) Math.ceil(f16));
        int max2 = Math.max(i3, (int) Math.ceil(f16 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final com.google.android.material.shape.g q() {
        return this.f33695a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final x0.h r() {
        return this.f33708n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@Nullable k kVar, boolean z16) {
        int i3;
        AnimatorSet j3;
        if (u()) {
            return;
        }
        Animator animator = this.f33707m;
        if (animator != null) {
            animator.cancel();
        }
        if (W()) {
            x0.h hVar = this.f33709o;
            if (hVar != null) {
                j3 = i(hVar, 0.0f, 0.0f, 0.0f);
            } else {
                j3 = j(0.0f, 0.4f, 0.4f);
            }
            j3.addListener(new a(z16, kVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.f33715u;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j3.addListener(it.next());
                }
            }
            j3.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f33717w;
        if (z16) {
            i3 = 8;
        } else {
            i3 = 4;
        }
        floatingActionButton.b(i3, z16);
        if (kVar != null) {
            kVar.onHidden();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i3) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        if (this.f33717w.getVisibility() == 0) {
            if (this.f33713s != 1) {
                return false;
            }
            return true;
        }
        if (this.f33713s == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        if (this.f33717w.getVisibility() != 0) {
            if (this.f33713s != 2) {
                return false;
            }
            return true;
        }
        if (this.f33713s == 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        MaterialShapeDrawable materialShapeDrawable = this.f33696b;
        if (materialShapeDrawable != null) {
            com.google.android.material.shape.d.f(this.f33717w, materialShapeDrawable);
        }
        if (G()) {
            this.f33717w.getViewTreeObserver().addOnPreDrawListener(o());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        ViewTreeObserver viewTreeObserver = this.f33717w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }
}
