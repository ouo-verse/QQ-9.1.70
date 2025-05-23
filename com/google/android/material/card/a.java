package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.f;
import com.google.android.material.shape.g;
import com.tencent.mobileqq.R;
import g1.c;
import h1.b;
import j1.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {

    /* renamed from: u, reason: collision with root package name */
    private static final double f33411u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: v, reason: collision with root package name */
    private static final Drawable f33412v;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final MaterialCardView f33413a;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f33415c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f33416d;

    /* renamed from: e, reason: collision with root package name */
    @Dimension
    private int f33417e;

    /* renamed from: f, reason: collision with root package name */
    @Dimension
    private int f33418f;

    /* renamed from: g, reason: collision with root package name */
    private int f33419g;

    /* renamed from: h, reason: collision with root package name */
    @Dimension
    private int f33420h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f33421i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private Drawable f33422j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f33423k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f33424l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private g f33425m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private ColorStateList f33426n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private Drawable f33427o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private LayerDrawable f33428p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f33429q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f33430r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f33432t;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final Rect f33414b = new Rect();

    /* renamed from: s, reason: collision with root package name */
    private boolean f33431s = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0229a extends InsetDrawable {
        C0229a(Drawable drawable, int i3, int i16, int i17, int i18) {
            super(drawable, i3, i16, i17, i18);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        f33412v = colorDrawable;
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i3, @StyleRes int i16) {
        this.f33413a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i3, i16);
        this.f33415c = materialShapeDrawable;
        materialShapeDrawable.N(materialCardView.getContext());
        materialShapeDrawable.e0(-12303292);
        g.b v3 = materialShapeDrawable.E().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, w0.a.M0, i3, R.style.f173388c1);
        int i17 = w0.a.N0;
        if (obtainStyledAttributes.hasValue(i17)) {
            v3.o(obtainStyledAttributes.getDimension(i17, 0.0f));
        }
        this.f33416d = new MaterialShapeDrawable();
        K(v3.m());
        obtainStyledAttributes.recycle();
    }

    private boolean O() {
        if (this.f33413a.getPreventCornerOverlap() && !e()) {
            return true;
        }
        return false;
    }

    private boolean P() {
        if (this.f33413a.getPreventCornerOverlap() && e() && this.f33413a.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    private void T(Drawable drawable) {
        if (this.f33413a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f33413a.getForeground()).setDrawable(drawable);
        } else {
            this.f33413a.setForeground(q(drawable));
        }
    }

    private void V() {
        Drawable drawable;
        if (b.f404037a && (drawable = this.f33427o) != null) {
            ((RippleDrawable) drawable).setColor(this.f33423k);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f33429q;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Y(this.f33423k);
        }
    }

    private float a() {
        return Math.max(Math.max(b(this.f33425m.q(), this.f33415c.G()), b(this.f33425m.s(), this.f33415c.H())), Math.max(b(this.f33425m.k(), this.f33415c.t()), b(this.f33425m.i(), this.f33415c.s())));
    }

    private float b(d dVar, float f16) {
        if (dVar instanceof f) {
            return (float) ((1.0d - f33411u) * f16);
        }
        if (dVar instanceof com.google.android.material.shape.a) {
            return f16 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        float f16;
        float maxCardElevation = this.f33413a.getMaxCardElevation();
        if (P()) {
            f16 = a();
        } else {
            f16 = 0.0f;
        }
        return maxCardElevation + f16;
    }

    private float d() {
        float f16;
        float maxCardElevation = this.f33413a.getMaxCardElevation() * 1.5f;
        if (P()) {
            f16 = a();
        } else {
            f16 = 0.0f;
        }
        return maxCardElevation + f16;
    }

    private boolean e() {
        if (this.f33415c.Q()) {
            return true;
        }
        return false;
    }

    @NonNull
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable h16 = h();
        this.f33429q = h16;
        h16.Y(this.f33423k);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.f33429q);
        return stateListDrawable;
    }

    @NonNull
    private Drawable g() {
        if (b.f404037a) {
            this.f33430r = h();
            return new RippleDrawable(this.f33423k, null, this.f33430r);
        }
        return f();
    }

    @NonNull
    private MaterialShapeDrawable h() {
        return new MaterialShapeDrawable(this.f33425m);
    }

    @NonNull
    private Drawable m() {
        if (this.f33427o == null) {
            this.f33427o = g();
        }
        if (this.f33428p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f33427o, this.f33416d, this.f33422j});
            this.f33428p = layerDrawable;
            layerDrawable.setId(2, R.id.zh8);
        }
        return this.f33428p;
    }

    private float o() {
        if (this.f33413a.getPreventCornerOverlap() && this.f33413a.getUseCompatPadding()) {
            return (float) ((1.0d - f33411u) * this.f33413a.j());
        }
        return 0.0f;
    }

    @NonNull
    private Drawable q(Drawable drawable) {
        int i3;
        int i16;
        if (this.f33413a.getUseCompatPadding()) {
            i16 = (int) Math.ceil(d());
            i3 = (int) Math.ceil(c());
        } else {
            i3 = 0;
            i16 = 0;
        }
        return new C0229a(drawable, i3, i16, i3, i16);
    }

    private boolean t() {
        if ((this.f33419g & 80) == 80) {
            return true;
        }
        return false;
    }

    private boolean u() {
        if ((this.f33419g & 8388613) == 8388613) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(boolean z16) {
        this.f33432t = z16;
    }

    public void B(boolean z16) {
        int i3;
        Drawable drawable = this.f33422j;
        if (drawable != null) {
            if (z16) {
                i3 = 255;
            } else {
                i3 = 0;
            }
            drawable.setAlpha(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(@Nullable Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f33422j = mutate;
            DrawableCompat.setTintList(mutate, this.f33424l);
            B(this.f33413a.isChecked());
        } else {
            this.f33422j = f33412v;
        }
        LayerDrawable layerDrawable = this.f33428p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.zh8, this.f33422j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(int i3) {
        this.f33419g = i3;
        w(this.f33413a.getMeasuredWidth(), this.f33413a.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@Dimension int i3) {
        this.f33417e = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@Dimension int i3) {
        this.f33418f = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@Nullable ColorStateList colorStateList) {
        this.f33424l = colorStateList;
        Drawable drawable = this.f33422j;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(float f16) {
        K(this.f33425m.w(f16));
        this.f33421i.invalidateSelf();
        if (P() || O()) {
            R();
        }
        if (P()) {
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f33415c.Z(f16);
        MaterialShapeDrawable materialShapeDrawable = this.f33416d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.Z(f16);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f33430r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.Z(f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(@Nullable ColorStateList colorStateList) {
        this.f33423k = colorStateList;
        V();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(@NonNull g gVar) {
        this.f33425m = gVar;
        this.f33415c.setShapeAppearanceModel(gVar);
        this.f33415c.d0(!r0.Q());
        MaterialShapeDrawable materialShapeDrawable = this.f33416d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(gVar);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f33430r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(gVar);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.f33429q;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        if (this.f33426n == colorStateList) {
            return;
        }
        this.f33426n = colorStateList;
        W();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(@Dimension int i3) {
        if (i3 == this.f33420h) {
            return;
        }
        this.f33420h = i3;
        W();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(int i3, int i16, int i17, int i18) {
        this.f33414b.set(i3, i16, i17, i18);
        R();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        Drawable drawable;
        Drawable drawable2 = this.f33421i;
        if (this.f33413a.isClickable()) {
            drawable = m();
        } else {
            drawable = this.f33416d;
        }
        this.f33421i = drawable;
        if (drawable2 != drawable) {
            T(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        boolean z16;
        float f16;
        if (!O() && !P()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            f16 = a();
        } else {
            f16 = 0.0f;
        }
        int o16 = (int) (f16 - o());
        MaterialCardView materialCardView = this.f33413a;
        Rect rect = this.f33414b;
        materialCardView.m(rect.left + o16, rect.top + o16, rect.right + o16, rect.bottom + o16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.f33415c.X(this.f33413a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        if (!r()) {
            this.f33413a.n(q(this.f33415c));
        }
        this.f33413a.setForeground(q(this.f33421i));
    }

    void W() {
        this.f33416d.h0(this.f33420h, this.f33426n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void i() {
        Drawable drawable = this.f33427o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i3 = bounds.bottom;
            this.f33427o.setBounds(bounds.left, bounds.top, bounds.right, i3 - 1);
            this.f33427o.setBounds(bounds.left, bounds.top, bounds.right, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable j() {
        return this.f33415c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList k() {
        return this.f33415c.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f33419g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.f33415c.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect p() {
        return this.f33414b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f33431s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f33432t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@NonNull TypedArray typedArray) {
        Drawable drawable;
        ColorStateList a16 = c.a(this.f33413a.getContext(), typedArray, w0.a.U4);
        this.f33426n = a16;
        if (a16 == null) {
            this.f33426n = ColorStateList.valueOf(-1);
        }
        this.f33420h = typedArray.getDimensionPixelSize(w0.a.V4, 0);
        boolean z16 = typedArray.getBoolean(w0.a.M4, false);
        this.f33432t = z16;
        this.f33413a.setLongClickable(z16);
        this.f33424l = c.a(this.f33413a.getContext(), typedArray, w0.a.S4);
        C(c.e(this.f33413a.getContext(), typedArray, w0.a.O4));
        F(typedArray.getDimensionPixelSize(w0.a.R4, 0));
        E(typedArray.getDimensionPixelSize(w0.a.Q4, 0));
        this.f33419g = typedArray.getInteger(w0.a.P4, 8388661);
        ColorStateList a17 = c.a(this.f33413a.getContext(), typedArray, w0.a.T4);
        this.f33423k = a17;
        if (a17 == null) {
            this.f33423k = ColorStateList.valueOf(z0.a.d(this.f33413a, R.attr.a7p));
        }
        z(c.a(this.f33413a.getContext(), typedArray, w0.a.N4));
        V();
        S();
        W();
        this.f33413a.n(q(this.f33415c));
        if (this.f33413a.isClickable()) {
            drawable = m();
        } else {
            drawable = this.f33416d;
        }
        this.f33421i = drawable;
        this.f33413a.setForeground(q(drawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        if (this.f33428p != null) {
            if (this.f33413a.getUseCompatPadding()) {
                i17 = (int) Math.ceil(d() * 2.0f);
                i18 = (int) Math.ceil(c() * 2.0f);
            } else {
                i17 = 0;
                i18 = 0;
            }
            if (u()) {
                i19 = ((i3 - this.f33417e) - this.f33418f) - i18;
            } else {
                i19 = this.f33417e;
            }
            if (t()) {
                i26 = this.f33417e;
            } else {
                i26 = ((i16 - this.f33417e) - this.f33418f) - i17;
            }
            int i37 = i26;
            if (u()) {
                i27 = this.f33417e;
            } else {
                i27 = ((i3 - this.f33417e) - this.f33418f) - i18;
            }
            if (t()) {
                i28 = ((i16 - this.f33417e) - this.f33418f) - i17;
            } else {
                i28 = this.f33417e;
            }
            int i38 = i28;
            if (ViewCompat.getLayoutDirection(this.f33413a) == 1) {
                i36 = i27;
                i29 = i19;
            } else {
                i29 = i27;
                i36 = i19;
            }
            this.f33428p.setLayerInset(2, i36, i38, i29, i37);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(boolean z16) {
        this.f33431s = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList) {
        this.f33415c.Y(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f33416d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.Y(colorStateList);
    }
}
