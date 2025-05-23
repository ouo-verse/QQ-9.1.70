package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.tencent.mobileqq.R;
import g1.c;
import h1.b;
import j1.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {

    /* renamed from: t, reason: collision with root package name */
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean f33384t = true;

    /* renamed from: u, reason: collision with root package name */
    private static final boolean f33385u = false;

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f33386a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private g f33387b;

    /* renamed from: c, reason: collision with root package name */
    private int f33388c;

    /* renamed from: d, reason: collision with root package name */
    private int f33389d;

    /* renamed from: e, reason: collision with root package name */
    private int f33390e;

    /* renamed from: f, reason: collision with root package name */
    private int f33391f;

    /* renamed from: g, reason: collision with root package name */
    private int f33392g;

    /* renamed from: h, reason: collision with root package name */
    private int f33393h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f33394i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private ColorStateList f33395j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private ColorStateList f33396k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private ColorStateList f33397l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Drawable f33398m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f33399n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f33400o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f33401p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f33402q;

    /* renamed from: r, reason: collision with root package name */
    private LayerDrawable f33403r;

    /* renamed from: s, reason: collision with root package name */
    private int f33404s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, @NonNull g gVar) {
        this.f33386a = materialButton;
        this.f33387b = gVar;
    }

    private void A() {
        this.f33386a.r(a());
        MaterialShapeDrawable c16 = c();
        if (c16 != null) {
            c16.X(this.f33404s);
        }
    }

    private void B(@NonNull g gVar) {
        if (f33385u && !this.f33400o) {
            int paddingStart = ViewCompat.getPaddingStart(this.f33386a);
            int paddingTop = this.f33386a.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.f33386a);
            int paddingBottom = this.f33386a.getPaddingBottom();
            A();
            ViewCompat.setPaddingRelative(this.f33386a, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (c() != null) {
            c().setShapeAppearanceModel(gVar);
        }
        if (i() != null) {
            i().setShapeAppearanceModel(gVar);
        }
        if (b() != null) {
            b().setShapeAppearanceModel(gVar);
        }
    }

    private void C() {
        int i3;
        MaterialShapeDrawable c16 = c();
        MaterialShapeDrawable i16 = i();
        if (c16 != null) {
            c16.h0(this.f33393h, this.f33396k);
            if (i16 != null) {
                float f16 = this.f33393h;
                if (this.f33399n) {
                    i3 = z0.a.d(this.f33386a, R.attr.a8g);
                } else {
                    i3 = 0;
                }
                i16.g0(f16, i3);
            }
        }
    }

    @NonNull
    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f33388c, this.f33390e, this.f33389d, this.f33391f);
    }

    private Drawable a() {
        int i3;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f33387b);
        materialShapeDrawable.N(this.f33386a.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.f33395j);
        PorterDuff.Mode mode = this.f33394i;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.h0(this.f33393h, this.f33396k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f33387b);
        materialShapeDrawable2.setTint(0);
        float f16 = this.f33393h;
        if (this.f33399n) {
            i3 = z0.a.d(this.f33386a, R.attr.a8g);
        } else {
            i3 = 0;
        }
        materialShapeDrawable2.g0(f16, i3);
        if (f33384t) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f33387b);
            this.f33398m = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.f33397l), D(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f33398m);
            this.f33403r = rippleDrawable;
            return rippleDrawable;
        }
        h1.a aVar = new h1.a(this.f33387b);
        this.f33398m = aVar;
        DrawableCompat.setTintList(aVar, b.d(this.f33397l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f33398m});
        this.f33403r = layerDrawable;
        return D(layerDrawable);
    }

    @Nullable
    private MaterialShapeDrawable d(boolean z16) {
        LayerDrawable layerDrawable = this.f33403r;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f33384t) {
                return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.f33403r.getDrawable(0)).getDrawable()).getDrawable(!z16 ? 1 : 0);
            }
            return (MaterialShapeDrawable) this.f33403r.getDrawable(!z16 ? 1 : 0);
        }
        return null;
    }

    @Nullable
    private MaterialShapeDrawable i() {
        return d(true);
    }

    private void z(@Dimension int i3, @Dimension int i16) {
        int paddingStart = ViewCompat.getPaddingStart(this.f33386a);
        int paddingTop = this.f33386a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f33386a);
        int paddingBottom = this.f33386a.getPaddingBottom();
        int i17 = this.f33390e;
        int i18 = this.f33391f;
        this.f33391f = i16;
        this.f33390e = i3;
        if (!this.f33400o) {
            A();
        }
        ViewCompat.setPaddingRelative(this.f33386a, paddingStart, (paddingTop + i3) - i17, paddingEnd, (paddingBottom + i16) - i18);
    }

    @Nullable
    public f b() {
        LayerDrawable layerDrawable = this.f33403r;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f33403r.getNumberOfLayers() > 2) {
                return (f) this.f33403r.getDrawable(2);
            }
            return (f) this.f33403r.getDrawable(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public MaterialShapeDrawable c() {
        return d(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g e() {
        return this.f33387b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f33393h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList g() {
        return this.f33395j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode h() {
        return this.f33394i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f33400o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f33402q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull TypedArray typedArray) {
        this.f33388c = typedArray.getDimensionPixelOffset(w0.a.V3, 0);
        this.f33389d = typedArray.getDimensionPixelOffset(w0.a.W3, 0);
        this.f33390e = typedArray.getDimensionPixelOffset(w0.a.X3, 0);
        this.f33391f = typedArray.getDimensionPixelOffset(w0.a.Y3, 0);
        int i3 = w0.a.f443837c4;
        if (typedArray.hasValue(i3)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i3, -1);
            this.f33392g = dimensionPixelSize;
            t(this.f33387b.w(dimensionPixelSize));
            this.f33401p = true;
        }
        this.f33393h = typedArray.getDimensionPixelSize(w0.a.f443952m4, 0);
        this.f33394i = ViewUtils.j(typedArray.getInt(w0.a.f443825b4, -1), PorterDuff.Mode.SRC_IN);
        this.f33395j = c.a(this.f33386a.getContext(), typedArray, w0.a.f443813a4);
        this.f33396k = c.a(this.f33386a.getContext(), typedArray, w0.a.f443941l4);
        this.f33397l = c.a(this.f33386a.getContext(), typedArray, w0.a.f443930k4);
        this.f33402q = typedArray.getBoolean(w0.a.Z3, false);
        this.f33404s = typedArray.getDimensionPixelSize(w0.a.f443849d4, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.f33386a);
        int paddingTop = this.f33386a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f33386a);
        int paddingBottom = this.f33386a.getPaddingBottom();
        if (typedArray.hasValue(w0.a.U3)) {
            n();
        } else {
            A();
        }
        ViewCompat.setPaddingRelative(this.f33386a, paddingStart + this.f33388c, paddingTop + this.f33390e, paddingEnd + this.f33389d, paddingBottom + this.f33391f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i3) {
        if (c() != null) {
            c().setTint(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.f33400o = true;
        this.f33386a.setSupportBackgroundTintList(this.f33395j);
        this.f33386a.setSupportBackgroundTintMode(this.f33394i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z16) {
        this.f33402q = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i3) {
        if (!this.f33401p || this.f33392g != i3) {
            this.f33392g = i3;
            this.f33401p = true;
            t(this.f33387b.w(i3));
        }
    }

    public void q(@Dimension int i3) {
        z(this.f33390e, i3);
    }

    public void r(@Dimension int i3) {
        z(i3, this.f33391f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@Nullable ColorStateList colorStateList) {
        if (this.f33397l != colorStateList) {
            this.f33397l = colorStateList;
            boolean z16 = f33384t;
            if (z16 && (this.f33386a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f33386a.getBackground()).setColor(b.d(colorStateList));
            } else if (!z16 && (this.f33386a.getBackground() instanceof h1.a)) {
                ((h1.a) this.f33386a.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(@NonNull g gVar) {
        this.f33387b = gVar;
        B(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z16) {
        this.f33399n = z16;
        C();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@Nullable ColorStateList colorStateList) {
        if (this.f33396k != colorStateList) {
            this.f33396k = colorStateList;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i3) {
        if (this.f33393h != i3) {
            this.f33393h = i3;
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(@Nullable ColorStateList colorStateList) {
        if (this.f33395j != colorStateList) {
            this.f33395j = colorStateList;
            if (c() != null) {
                DrawableCompat.setTintList(c(), this.f33395j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(@Nullable PorterDuff.Mode mode) {
        if (this.f33394i != mode) {
            this.f33394i = mode;
            if (c() != null && this.f33394i != null) {
                DrawableCompat.setTintMode(c(), this.f33394i);
            }
        }
    }
}
