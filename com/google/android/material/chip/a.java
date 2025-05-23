package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.l;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import g1.c;
import g1.d;
import h1.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import x0.h;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends MaterialShapeDrawable implements Drawable.Callback, l.b {

    /* renamed from: g1, reason: collision with root package name */
    private static final int[] f33454g1 = {R.attr.state_enabled};

    /* renamed from: h1, reason: collision with root package name */
    private static final ShapeDrawable f33455h1 = new ShapeDrawable(new OvalShape());
    private float A0;
    private float B0;
    private float C0;

    @NonNull
    private final Context D0;
    private final Paint E0;

    @Nullable
    private final Paint F0;
    private final Paint.FontMetrics G0;
    private final RectF H0;
    private final PointF I0;
    private final Path J0;

    @NonNull
    private final l K0;

    @ColorInt
    private int L0;

    @ColorInt
    private int M0;

    @ColorInt
    private int N0;

    @ColorInt
    private int O0;

    @ColorInt
    private int P0;

    @ColorInt
    private int Q0;
    private boolean R0;

    @ColorInt
    private int S0;
    private int T0;

    @Nullable
    private ColorFilter U0;

    @Nullable
    private PorterDuffColorFilter V0;

    @Nullable
    private ColorStateList W;

    @Nullable
    private ColorStateList W0;

    @Nullable
    private ColorStateList X;

    @Nullable
    private PorterDuff.Mode X0;
    private float Y;
    private int[] Y0;
    private float Z;
    private boolean Z0;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private ColorStateList f33456a0;

    /* renamed from: a1, reason: collision with root package name */
    @Nullable
    private ColorStateList f33457a1;

    /* renamed from: b0, reason: collision with root package name */
    private float f33458b0;

    /* renamed from: b1, reason: collision with root package name */
    @NonNull
    private WeakReference<InterfaceC0230a> f33459b1;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private ColorStateList f33460c0;

    /* renamed from: c1, reason: collision with root package name */
    private TextUtils.TruncateAt f33461c1;

    /* renamed from: d0, reason: collision with root package name */
    @Nullable
    private CharSequence f33462d0;

    /* renamed from: d1, reason: collision with root package name */
    private boolean f33463d1;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f33464e0;

    /* renamed from: e1, reason: collision with root package name */
    private int f33465e1;

    /* renamed from: f0, reason: collision with root package name */
    @Nullable
    private Drawable f33466f0;

    /* renamed from: f1, reason: collision with root package name */
    private boolean f33467f1;

    /* renamed from: g0, reason: collision with root package name */
    @Nullable
    private ColorStateList f33468g0;

    /* renamed from: h0, reason: collision with root package name */
    private float f33469h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f33470i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f33471j0;

    /* renamed from: k0, reason: collision with root package name */
    @Nullable
    private Drawable f33472k0;

    /* renamed from: l0, reason: collision with root package name */
    @Nullable
    private Drawable f33473l0;

    /* renamed from: m0, reason: collision with root package name */
    @Nullable
    private ColorStateList f33474m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f33475n0;

    /* renamed from: o0, reason: collision with root package name */
    @Nullable
    private CharSequence f33476o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f33477p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f33478q0;

    /* renamed from: r0, reason: collision with root package name */
    @Nullable
    private Drawable f33479r0;

    /* renamed from: s0, reason: collision with root package name */
    @Nullable
    private ColorStateList f33480s0;

    /* renamed from: t0, reason: collision with root package name */
    @Nullable
    private h f33481t0;

    /* renamed from: u0, reason: collision with root package name */
    @Nullable
    private h f33482u0;

    /* renamed from: v0, reason: collision with root package name */
    private float f33483v0;

    /* renamed from: w0, reason: collision with root package name */
    private float f33484w0;

    /* renamed from: x0, reason: collision with root package name */
    private float f33485x0;

    /* renamed from: y0, reason: collision with root package name */
    private float f33486y0;

    /* renamed from: z0, reason: collision with root package name */
    private float f33487z0;

    /* compiled from: P */
    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0230a {
        void a();
    }

    a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        this.Z = -1.0f;
        this.E0 = new Paint(1);
        this.G0 = new Paint.FontMetrics();
        this.H0 = new RectF();
        this.I0 = new PointF();
        this.J0 = new Path();
        this.T0 = 255;
        this.X0 = PorterDuff.Mode.SRC_IN;
        this.f33459b1 = new WeakReference<>(null);
        N(context);
        this.D0 = context;
        l lVar = new l(this);
        this.K0 = lVar;
        this.f33462d0 = "";
        lVar.e().density = context.getResources().getDisplayMetrics().density;
        this.F0 = null;
        int[] iArr = f33454g1;
        setState(iArr);
        Z1(iArr);
        this.f33463d1 = true;
        if (b.f404037a) {
            f33455h1.setTint(-1);
        }
    }

    private void A0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.f33467f1) {
            this.E0.setColor(this.M0);
            this.E0.setStyle(Paint.Style.FILL);
            this.E0.setColorFilter(Z0());
            this.H0.set(rect);
            canvas.drawRoundRect(this.H0, I0(), I0(), this.E0);
        }
    }

    private boolean A2() {
        if (this.f33478q0 && this.f33479r0 != null && this.R0) {
            return true;
        }
        return false;
    }

    private void B0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (B2()) {
            o0(rect, this.H0);
            RectF rectF = this.H0;
            float f16 = rectF.left;
            float f17 = rectF.top;
            canvas.translate(f16, f17);
            this.f33466f0.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            this.f33466f0.draw(canvas);
            canvas.translate(-f16, -f17);
        }
    }

    private boolean B2() {
        if (this.f33464e0 && this.f33466f0 != null) {
            return true;
        }
        return false;
    }

    private void C0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f33458b0 > 0.0f && !this.f33467f1) {
            this.E0.setColor(this.O0);
            this.E0.setStyle(Paint.Style.STROKE);
            if (!this.f33467f1) {
                this.E0.setColorFilter(Z0());
            }
            RectF rectF = this.H0;
            float f16 = rect.left;
            float f17 = this.f33458b0;
            rectF.set(f16 + (f17 / 2.0f), rect.top + (f17 / 2.0f), rect.right - (f17 / 2.0f), rect.bottom - (f17 / 2.0f));
            float f18 = this.Z - (this.f33458b0 / 2.0f);
            canvas.drawRoundRect(this.H0, f18, f18, this.E0);
        }
    }

    private boolean C2() {
        if (this.f33471j0 && this.f33472k0 != null) {
            return true;
        }
        return false;
    }

    private void D0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.f33467f1) {
            this.E0.setColor(this.L0);
            this.E0.setStyle(Paint.Style.FILL);
            this.H0.set(rect);
            canvas.drawRoundRect(this.H0, I0(), I0(), this.E0);
        }
    }

    private void D2(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void E0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (C2()) {
            r0(rect, this.H0);
            RectF rectF = this.H0;
            float f16 = rectF.left;
            float f17 = rectF.top;
            canvas.translate(f16, f17);
            this.f33472k0.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            if (b.f404037a) {
                this.f33473l0.setBounds(this.f33472k0.getBounds());
                this.f33473l0.jumpToCurrentState();
                this.f33473l0.draw(canvas);
            } else {
                this.f33472k0.draw(canvas);
            }
            canvas.translate(-f16, -f17);
        }
    }

    private void E2() {
        ColorStateList colorStateList;
        if (this.Z0) {
            colorStateList = b.d(this.f33460c0);
        } else {
            colorStateList = null;
        }
        this.f33457a1 = colorStateList;
    }

    private void F0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.E0.setColor(this.P0);
        this.E0.setStyle(Paint.Style.FILL);
        this.H0.set(rect);
        if (!this.f33467f1) {
            canvas.drawRoundRect(this.H0, I0(), I0(), this.E0);
        } else {
            h(new RectF(rect), this.J0);
            super.p(canvas, this.E0, this.J0, u());
        }
    }

    @TargetApi(21)
    private void F2() {
        this.f33473l0 = new RippleDrawable(b.d(U0()), this.f33472k0, f33455h1);
    }

    private void G0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.F0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.F0);
            if (B2() || A2()) {
                o0(rect, this.H0);
                canvas.drawRect(this.H0, this.F0);
            }
            if (this.f33462d0 != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.F0);
            }
            if (C2()) {
                r0(rect, this.H0);
                canvas.drawRect(this.H0, this.F0);
            }
            this.F0.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            q0(rect, this.H0);
            canvas.drawRect(this.H0, this.F0);
            this.F0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            s0(rect, this.H0);
            canvas.drawRect(this.H0, this.F0);
        }
    }

    private void H0(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z16;
        if (this.f33462d0 != null) {
            Paint.Align w06 = w0(rect, this.I0);
            u0(rect, this.H0);
            if (this.K0.d() != null) {
                this.K0.e().drawableState = getState();
                this.K0.j(this.D0);
            }
            this.K0.e().setTextAlign(w06);
            int i3 = 0;
            if (Math.round(this.K0.f(V0().toString())) > Math.round(this.H0.width())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = canvas.save();
                canvas.clipRect(this.H0);
            }
            CharSequence charSequence = this.f33462d0;
            if (z16 && this.f33461c1 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.K0.e(), this.H0.width(), this.f33461c1);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.I0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.K0.e());
            if (z16) {
                canvas.restoreToCount(i3);
            }
        }
    }

    private void P1(@Nullable ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            onStateChange(getState());
        }
    }

    private float R0() {
        Drawable drawable;
        if (this.R0) {
            drawable = this.f33479r0;
        } else {
            drawable = this.f33466f0;
        }
        float f16 = this.f33469h0;
        if (f16 <= 0.0f && drawable != null) {
            f16 = (float) Math.ceil(ViewUtils.c(this.D0, 24));
            if (drawable.getIntrinsicHeight() <= f16) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f16;
    }

    private float S0() {
        Drawable drawable;
        if (this.R0) {
            drawable = this.f33479r0;
        } else {
            drawable = this.f33466f0;
        }
        float f16 = this.f33469h0;
        if (f16 <= 0.0f && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f16;
    }

    @Nullable
    private ColorFilter Z0() {
        ColorFilter colorFilter = this.U0;
        if (colorFilter == null) {
            return this.V0;
        }
        return colorFilter;
    }

    private static boolean b1(@Nullable int[] iArr, @AttrRes int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }

    private static boolean f1(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    private static boolean g1(@Nullable Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    private static boolean h1(@Nullable d dVar) {
        if (dVar != null && dVar.i() != null && dVar.i().isStateful()) {
            return true;
        }
        return false;
    }

    private void i1(@Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        TypedArray h16 = o.h(this.D0, attributeSet, w0.a.O0, i3, i16, new int[0]);
        this.f33467f1 = h16.hasValue(w0.a.f444102z1);
        P1(c.a(this.D0, h16, w0.a.f443950m1));
        t1(c.a(this.D0, h16, w0.a.Z0));
        H1(h16.getDimension(w0.a.f443894h1, 0.0f));
        int i17 = w0.a.f443810a1;
        if (h16.hasValue(i17)) {
            v1(h16.getDimension(i17, 0.0f));
        }
        L1(c.a(this.D0, h16, w0.a.f443928k1));
        N1(h16.getDimension(w0.a.f443939l1, 0.0f));
        m2(c.a(this.D0, h16, w0.a.f444090y1));
        r2(h16.getText(w0.a.T0));
        d g16 = c.g(this.D0, h16, w0.a.P0);
        g16.l(h16.getDimension(w0.a.Q0, g16.j()));
        s2(g16);
        int i18 = h16.getInt(w0.a.R0, 0);
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 == 3) {
                    e2(TextUtils.TruncateAt.END);
                }
            } else {
                e2(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            e2(TextUtils.TruncateAt.START);
        }
        G1(h16.getBoolean(w0.a.f443882g1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            G1(h16.getBoolean(w0.a.f443846d1, false));
        }
        z1(c.e(this.D0, h16, w0.a.f443834c1));
        int i19 = w0.a.f443870f1;
        if (h16.hasValue(i19)) {
            D1(c.a(this.D0, h16, i19));
        }
        B1(h16.getDimension(w0.a.f443858e1, -1.0f));
        c2(h16.getBoolean(w0.a.f444032t1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            c2(h16.getBoolean(w0.a.f443972o1, false));
        }
        Q1(c.e(this.D0, h16, w0.a.f443961n1));
        a2(c.a(this.D0, h16, w0.a.f444020s1));
        V1(h16.getDimension(w0.a.f443996q1, 0.0f));
        l1(h16.getBoolean(w0.a.U0, false));
        s1(h16.getBoolean(w0.a.Y0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            s1(h16.getBoolean(w0.a.W0, false));
        }
        n1(c.e(this.D0, h16, w0.a.V0));
        int i26 = w0.a.X0;
        if (h16.hasValue(i26)) {
            p1(c.a(this.D0, h16, i26));
        }
        p2(h.c(this.D0, h16, w0.a.A1));
        f2(h.c(this.D0, h16, w0.a.f444056v1));
        J1(h16.getDimension(w0.a.f443917j1, 0.0f));
        j2(h16.getDimension(w0.a.f444078x1, 0.0f));
        h2(h16.getDimension(w0.a.f444067w1, 0.0f));
        w2(h16.getDimension(w0.a.C1, 0.0f));
        u2(h16.getDimension(w0.a.B1, 0.0f));
        X1(h16.getDimension(w0.a.f444008r1, 0.0f));
        S1(h16.getDimension(w0.a.f443984p1, 0.0f));
        x1(h16.getDimension(w0.a.f443822b1, 0.0f));
        l2(h16.getDimensionPixelSize(w0.a.S0, Integer.MAX_VALUE));
        h16.recycle();
    }

    private boolean k1(@NonNull int[] iArr, @NonNull int[] iArr2) {
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        int i17;
        int i18;
        int i19;
        boolean z18;
        boolean z19;
        int i26;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.W;
        if (colorStateList != null) {
            i3 = colorStateList.getColorForState(iArr, this.L0);
        } else {
            i3 = 0;
        }
        int l3 = l(i3);
        boolean z26 = true;
        if (this.L0 != l3) {
            this.L0 = l3;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.X;
        if (colorStateList2 != null) {
            i16 = colorStateList2.getColorForState(iArr, this.M0);
        } else {
            i16 = 0;
        }
        int l16 = l(i16);
        if (this.M0 != l16) {
            this.M0 = l16;
            onStateChange = true;
        }
        int g16 = z0.a.g(l3, l16);
        if (this.N0 != g16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (x() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 | z17) {
            this.N0 = g16;
            Y(ColorStateList.valueOf(g16));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.f33456a0;
        if (colorStateList3 != null) {
            i17 = colorStateList3.getColorForState(iArr, this.O0);
        } else {
            i17 = 0;
        }
        if (this.O0 != i17) {
            this.O0 = i17;
            onStateChange = true;
        }
        if (this.f33457a1 != null && b.e(iArr)) {
            i18 = this.f33457a1.getColorForState(iArr, this.P0);
        } else {
            i18 = 0;
        }
        if (this.P0 != i18) {
            this.P0 = i18;
            if (this.Z0) {
                onStateChange = true;
            }
        }
        if (this.K0.d() != null && this.K0.d().i() != null) {
            i19 = this.K0.d().i().getColorForState(iArr, this.Q0);
        } else {
            i19 = 0;
        }
        if (this.Q0 != i19) {
            this.Q0 = i19;
            onStateChange = true;
        }
        if (b1(getState(), R.attr.state_checked) && this.f33477p0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.R0 != z18 && this.f33479r0 != null) {
            float p06 = p0();
            this.R0 = z18;
            if (p06 != p0()) {
                onStateChange = true;
                z19 = true;
            } else {
                z19 = false;
                onStateChange = true;
            }
        } else {
            z19 = false;
        }
        ColorStateList colorStateList4 = this.W0;
        if (colorStateList4 != null) {
            i26 = colorStateList4.getColorForState(iArr, this.S0);
        } else {
            i26 = 0;
        }
        if (this.S0 != i26) {
            this.S0 = i26;
            this.V0 = b1.a.c(this, this.W0, this.X0);
        } else {
            z26 = onStateChange;
        }
        if (g1(this.f33466f0)) {
            z26 |= this.f33466f0.setState(iArr);
        }
        if (g1(this.f33479r0)) {
            z26 |= this.f33479r0.setState(iArr);
        }
        if (g1(this.f33472k0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z26 |= this.f33472k0.setState(iArr3);
        }
        if (b.f404037a && g1(this.f33473l0)) {
            z26 |= this.f33473l0.setState(iArr2);
        }
        if (z26) {
            invalidateSelf();
        }
        if (z19) {
            j1();
        }
        return z26;
    }

    private void n0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f33472k0) {
            if (drawable.isStateful()) {
                drawable.setState(P0());
            }
            DrawableCompat.setTintList(drawable, this.f33474m0);
            return;
        }
        Drawable drawable2 = this.f33466f0;
        if (drawable == drawable2 && this.f33470i0) {
            DrawableCompat.setTintList(drawable2, this.f33468g0);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void o0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (B2() || A2()) {
            float f16 = this.f33483v0 + this.f33484w0;
            float S0 = S0();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f17 = rect.left + f16;
                rectF.left = f17;
                rectF.right = f17 + S0;
            } else {
                float f18 = rect.right - f16;
                rectF.right = f18;
                rectF.left = f18 - S0;
            }
            float R0 = R0();
            float exactCenterY = rect.exactCenterY() - (R0 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + R0;
        }
    }

    private void q0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (C2()) {
            float f16 = this.C0 + this.B0 + this.f33475n0 + this.A0 + this.f33487z0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f16;
            } else {
                rectF.left = rect.left + f16;
            }
        }
    }

    private void r0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (C2()) {
            float f16 = this.C0 + this.B0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f17 = rect.right - f16;
                rectF.right = f17;
                rectF.left = f17 - this.f33475n0;
            } else {
                float f18 = rect.left + f16;
                rectF.left = f18;
                rectF.right = f18 + this.f33475n0;
            }
            float exactCenterY = rect.exactCenterY();
            float f19 = this.f33475n0;
            float f26 = exactCenterY - (f19 / 2.0f);
            rectF.top = f26;
            rectF.bottom = f26 + f19;
        }
    }

    private void s0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (C2()) {
            float f16 = this.C0 + this.B0 + this.f33475n0 + this.A0 + this.f33487z0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f17 = rect.right;
                rectF.right = f17;
                rectF.left = f17 - f16;
            } else {
                int i3 = rect.left;
                rectF.left = i3;
                rectF.right = i3 + f16;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void u0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.f33462d0 != null) {
            float p06 = this.f33483v0 + p0() + this.f33486y0;
            float t06 = this.C0 + t0() + this.f33487z0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + p06;
                rectF.right = rect.right - t06;
            } else {
                rectF.left = rect.left + t06;
                rectF.right = rect.right - p06;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float v0() {
        this.K0.e().getFontMetrics(this.G0);
        Paint.FontMetrics fontMetrics = this.G0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean x0() {
        if (this.f33478q0 && this.f33479r0 != null && this.f33477p0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static a y0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        a aVar = new a(context, attributeSet, i3, i16);
        aVar.i1(attributeSet, i3, i16);
        return aVar;
    }

    private void z0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (A2()) {
            o0(rect, this.H0);
            RectF rectF = this.H0;
            float f16 = rectF.left;
            float f17 = rectF.top;
            canvas.translate(f16, f17);
            this.f33479r0.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            this.f33479r0.draw(canvas);
            canvas.translate(-f16, -f17);
        }
    }

    public void A1(@DrawableRes int i3) {
        z1(AppCompatResources.getDrawable(this.D0, i3));
    }

    public void B1(float f16) {
        if (this.f33469h0 != f16) {
            float p06 = p0();
            this.f33469h0 = f16;
            float p07 = p0();
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    public void C1(@DimenRes int i3) {
        B1(this.D0.getResources().getDimension(i3));
    }

    public void D1(@Nullable ColorStateList colorStateList) {
        this.f33470i0 = true;
        if (this.f33468g0 != colorStateList) {
            this.f33468g0 = colorStateList;
            if (B2()) {
                DrawableCompat.setTintList(this.f33466f0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void E1(@ColorRes int i3) {
        D1(AppCompatResources.getColorStateList(this.D0, i3));
    }

    public void F1(@BoolRes int i3) {
        G1(this.D0.getResources().getBoolean(i3));
    }

    public void G1(boolean z16) {
        boolean z17;
        if (this.f33464e0 != z16) {
            boolean B2 = B2();
            this.f33464e0 = z16;
            boolean B22 = B2();
            if (B2 != B22) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (B22) {
                    n0(this.f33466f0);
                } else {
                    D2(this.f33466f0);
                }
                invalidateSelf();
                j1();
            }
        }
    }

    public void H1(float f16) {
        if (this.Y != f16) {
            this.Y = f16;
            invalidateSelf();
            j1();
        }
    }

    public float I0() {
        if (this.f33467f1) {
            return G();
        }
        return this.Z;
    }

    public void I1(@DimenRes int i3) {
        H1(this.D0.getResources().getDimension(i3));
    }

    public float J0() {
        return this.C0;
    }

    public void J1(float f16) {
        if (this.f33483v0 != f16) {
            this.f33483v0 = f16;
            invalidateSelf();
            j1();
        }
    }

    @Nullable
    public Drawable K0() {
        Drawable drawable = this.f33466f0;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void K1(@DimenRes int i3) {
        J1(this.D0.getResources().getDimension(i3));
    }

    public float L0() {
        return this.Y;
    }

    public void L1(@Nullable ColorStateList colorStateList) {
        if (this.f33456a0 != colorStateList) {
            this.f33456a0 = colorStateList;
            if (this.f33467f1) {
                i0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float M0() {
        return this.f33483v0;
    }

    public void M1(@ColorRes int i3) {
        L1(AppCompatResources.getColorStateList(this.D0, i3));
    }

    @Nullable
    public Drawable N0() {
        Drawable drawable = this.f33472k0;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void N1(float f16) {
        if (this.f33458b0 != f16) {
            this.f33458b0 = f16;
            this.E0.setStrokeWidth(f16);
            if (this.f33467f1) {
                super.j0(f16);
            }
            invalidateSelf();
        }
    }

    @Nullable
    public CharSequence O0() {
        return this.f33476o0;
    }

    public void O1(@DimenRes int i3) {
        N1(this.D0.getResources().getDimension(i3));
    }

    @NonNull
    public int[] P0() {
        return this.Y0;
    }

    public void Q0(@NonNull RectF rectF) {
        s0(getBounds(), rectF);
    }

    public void Q1(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable N0 = N0();
        if (N0 != drawable) {
            float t06 = t0();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f33472k0 = drawable2;
            if (b.f404037a) {
                F2();
            }
            float t07 = t0();
            D2(N0);
            if (C2()) {
                n0(this.f33472k0);
            }
            invalidateSelf();
            if (t06 != t07) {
                j1();
            }
        }
    }

    public void R1(@Nullable CharSequence charSequence) {
        if (this.f33476o0 != charSequence) {
            this.f33476o0 = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public void S1(float f16) {
        if (this.B0 != f16) {
            this.B0 = f16;
            invalidateSelf();
            if (C2()) {
                j1();
            }
        }
    }

    public TextUtils.TruncateAt T0() {
        return this.f33461c1;
    }

    public void T1(@DimenRes int i3) {
        S1(this.D0.getResources().getDimension(i3));
    }

    @Nullable
    public ColorStateList U0() {
        return this.f33460c0;
    }

    public void U1(@DrawableRes int i3) {
        Q1(AppCompatResources.getDrawable(this.D0, i3));
    }

    @Nullable
    public CharSequence V0() {
        return this.f33462d0;
    }

    public void V1(float f16) {
        if (this.f33475n0 != f16) {
            this.f33475n0 = f16;
            invalidateSelf();
            if (C2()) {
                j1();
            }
        }
    }

    @Nullable
    public d W0() {
        return this.K0.d();
    }

    public void W1(@DimenRes int i3) {
        V1(this.D0.getResources().getDimension(i3));
    }

    public float X0() {
        return this.f33487z0;
    }

    public void X1(float f16) {
        if (this.A0 != f16) {
            this.A0 = f16;
            invalidateSelf();
            if (C2()) {
                j1();
            }
        }
    }

    public float Y0() {
        return this.f33486y0;
    }

    public void Y1(@DimenRes int i3) {
        X1(this.D0.getResources().getDimension(i3));
    }

    public boolean Z1(@NonNull int[] iArr) {
        if (!Arrays.equals(this.Y0, iArr)) {
            this.Y0 = iArr;
            if (C2()) {
                return k1(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.material.internal.l.b
    public void a() {
        j1();
        invalidateSelf();
    }

    public boolean a1() {
        return this.Z0;
    }

    public void a2(@Nullable ColorStateList colorStateList) {
        if (this.f33474m0 != colorStateList) {
            this.f33474m0 = colorStateList;
            if (C2()) {
                DrawableCompat.setTintList(this.f33472k0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b2(@ColorRes int i3) {
        a2(AppCompatResources.getColorStateList(this.D0, i3));
    }

    public boolean c1() {
        return this.f33477p0;
    }

    public void c2(boolean z16) {
        boolean z17;
        if (this.f33471j0 != z16) {
            boolean C2 = C2();
            this.f33471j0 = z16;
            boolean C22 = C2();
            if (C2 != C22) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (C22) {
                    n0(this.f33472k0);
                } else {
                    D2(this.f33472k0);
                }
                invalidateSelf();
                j1();
            }
        }
    }

    public boolean d1() {
        return g1(this.f33472k0);
    }

    public void d2(@Nullable InterfaceC0230a interfaceC0230a) {
        this.f33459b1 = new WeakReference<>(interfaceC0230a);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i3;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i16 = this.T0;
            if (i16 < 255) {
                i3 = y0.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i16);
            } else {
                i3 = 0;
            }
            D0(canvas, bounds);
            A0(canvas, bounds);
            if (this.f33467f1) {
                super.draw(canvas);
            }
            C0(canvas, bounds);
            F0(canvas, bounds);
            B0(canvas, bounds);
            z0(canvas, bounds);
            if (this.f33463d1) {
                H0(canvas, bounds);
            }
            E0(canvas, bounds);
            G0(canvas, bounds);
            if (this.T0 < 255) {
                canvas.restoreToCount(i3);
            }
        }
    }

    public boolean e1() {
        return this.f33471j0;
    }

    public void e2(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f33461c1 = truncateAt;
    }

    public void f2(@Nullable h hVar) {
        this.f33482u0 = hVar;
    }

    public void g2(@AnimatorRes int i3) {
        f2(h.d(this.D0, i3));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.T0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.U0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.Y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f33483v0 + p0() + this.f33486y0 + this.K0.f(V0().toString()) + this.f33487z0 + t0() + this.C0), this.f33465e1);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f33467f1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.Z);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.Z);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h2(float f16) {
        if (this.f33485x0 != f16) {
            float p06 = p0();
            this.f33485x0 = f16;
            float p07 = p0();
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    public void i2(@DimenRes int i3) {
        h2(this.D0.getResources().getDimension(i3));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!f1(this.W) && !f1(this.X) && !f1(this.f33456a0) && ((!this.Z0 || !f1(this.f33457a1)) && !h1(this.K0.d()) && !x0() && !g1(this.f33466f0) && !g1(this.f33479r0) && !f1(this.W0))) {
            return false;
        }
        return true;
    }

    protected void j1() {
        InterfaceC0230a interfaceC0230a = this.f33459b1.get();
        if (interfaceC0230a != null) {
            interfaceC0230a.a();
        }
    }

    public void j2(float f16) {
        if (this.f33484w0 != f16) {
            float p06 = p0();
            this.f33484w0 = f16;
            float p07 = p0();
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    public void k2(@DimenRes int i3) {
        j2(this.D0.getResources().getDimension(i3));
    }

    public void l1(boolean z16) {
        if (this.f33477p0 != z16) {
            this.f33477p0 = z16;
            float p06 = p0();
            if (!z16 && this.R0) {
                this.R0 = false;
            }
            float p07 = p0();
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    public void l2(@Px int i3) {
        this.f33465e1 = i3;
    }

    public void m1(@BoolRes int i3) {
        l1(this.D0.getResources().getBoolean(i3));
    }

    public void m2(@Nullable ColorStateList colorStateList) {
        if (this.f33460c0 != colorStateList) {
            this.f33460c0 = colorStateList;
            E2();
            onStateChange(getState());
        }
    }

    public void n1(@Nullable Drawable drawable) {
        if (this.f33479r0 != drawable) {
            float p06 = p0();
            this.f33479r0 = drawable;
            float p07 = p0();
            D2(this.f33479r0);
            n0(this.f33479r0);
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    public void n2(@ColorRes int i3) {
        m2(AppCompatResources.getColorStateList(this.D0, i3));
    }

    public void o1(@DrawableRes int i3) {
        n1(AppCompatResources.getDrawable(this.D0, i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o2(boolean z16) {
        this.f33463d1 = z16;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (B2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f33466f0, i3);
        }
        if (A2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f33479r0, i3);
        }
        if (C2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f33472k0, i3);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        boolean onLevelChange = super.onLevelChange(i3);
        if (B2()) {
            onLevelChange |= this.f33466f0.setLevel(i3);
        }
        if (A2()) {
            onLevelChange |= this.f33479r0.setLevel(i3);
        }
        if (C2()) {
            onLevelChange |= this.f33472k0.setLevel(i3);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.l.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.f33467f1) {
            super.onStateChange(iArr);
        }
        return k1(iArr, P0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p0() {
        if (!B2() && !A2()) {
            return 0.0f;
        }
        return this.f33484w0 + S0() + this.f33485x0;
    }

    public void p1(@Nullable ColorStateList colorStateList) {
        if (this.f33480s0 != colorStateList) {
            this.f33480s0 = colorStateList;
            if (x0()) {
                DrawableCompat.setTintList(this.f33479r0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void p2(@Nullable h hVar) {
        this.f33481t0 = hVar;
    }

    public void q1(@ColorRes int i3) {
        p1(AppCompatResources.getColorStateList(this.D0, i3));
    }

    public void q2(@AnimatorRes int i3) {
        p2(h.d(this.D0, i3));
    }

    public void r1(@BoolRes int i3) {
        s1(this.D0.getResources().getBoolean(i3));
    }

    public void r2(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.f33462d0, charSequence)) {
            this.f33462d0 = charSequence;
            this.K0.i(true);
            invalidateSelf();
            j1();
        }
    }

    public void s1(boolean z16) {
        boolean z17;
        if (this.f33478q0 != z16) {
            boolean A2 = A2();
            this.f33478q0 = z16;
            boolean A22 = A2();
            if (A2 != A22) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (A22) {
                    n0(this.f33479r0);
                } else {
                    D2(this.f33479r0);
                }
                invalidateSelf();
                j1();
            }
        }
    }

    public void s2(@Nullable d dVar) {
        this.K0.h(dVar, this.D0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j3);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.T0 != i3) {
            this.T0 = i3;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.U0 != colorFilter) {
            this.U0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.W0 != colorStateList) {
            this.W0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.X0 != mode) {
            this.X0 = mode;
            this.V0 = b1.a.c(this, this.W0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (B2()) {
            visible |= this.f33466f0.setVisible(z16, z17);
        }
        if (A2()) {
            visible |= this.f33479r0.setVisible(z16, z17);
        }
        if (C2()) {
            visible |= this.f33472k0.setVisible(z16, z17);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t0() {
        if (C2()) {
            return this.A0 + this.f33475n0 + this.B0;
        }
        return 0.0f;
    }

    public void t1(@Nullable ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            onStateChange(getState());
        }
    }

    public void t2(@StyleRes int i3) {
        s2(new d(this.D0, i3));
    }

    public void u1(@ColorRes int i3) {
        t1(AppCompatResources.getColorStateList(this.D0, i3));
    }

    public void u2(float f16) {
        if (this.f33487z0 != f16) {
            this.f33487z0 = f16;
            invalidateSelf();
            j1();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @Deprecated
    public void v1(float f16) {
        if (this.Z != f16) {
            this.Z = f16;
            setShapeAppearanceModel(E().w(f16));
        }
    }

    public void v2(@DimenRes int i3) {
        u2(this.D0.getResources().getDimension(i3));
    }

    @NonNull
    Paint.Align w0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f33462d0 != null) {
            float p06 = this.f33483v0 + p0() + this.f33486y0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + p06;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - p06;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - v0();
        }
        return align;
    }

    @Deprecated
    public void w1(@DimenRes int i3) {
        v1(this.D0.getResources().getDimension(i3));
    }

    public void w2(float f16) {
        if (this.f33486y0 != f16) {
            this.f33486y0 = f16;
            invalidateSelf();
            j1();
        }
    }

    public void x1(float f16) {
        if (this.C0 != f16) {
            this.C0 = f16;
            invalidateSelf();
            j1();
        }
    }

    public void x2(@DimenRes int i3) {
        w2(this.D0.getResources().getDimension(i3));
    }

    public void y1(@DimenRes int i3) {
        x1(this.D0.getResources().getDimension(i3));
    }

    public void y2(boolean z16) {
        if (this.Z0 != z16) {
            this.Z0 = z16;
            E2();
            onStateChange(getState());
        }
    }

    public void z1(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable K0 = K0();
        if (K0 != drawable) {
            float p06 = p0();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f33466f0 = drawable2;
            float p07 = p0();
            D2(K0);
            if (B2()) {
                n0(this.f33466f0);
            }
            invalidateSelf();
            if (p06 != p07) {
                j1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z2() {
        return this.f33463d1;
    }
}
