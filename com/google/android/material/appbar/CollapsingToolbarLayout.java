package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: d0, reason: collision with root package name */
    private static final int f33220d0 = 2131953244;
    private int C;
    private int D;
    private int E;
    private final Rect F;

    @NonNull
    final com.google.android.material.internal.b G;

    @NonNull
    final c1.a H;
    private boolean I;
    private boolean J;

    @Nullable
    private Drawable K;

    @Nullable
    Drawable L;
    private int M;
    private boolean N;
    private ValueAnimator P;
    private long Q;
    private int R;
    private AppBarLayout.g S;
    int T;
    private int U;

    @Nullable
    WindowInsetsCompat V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f33221a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f33222b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f33223c0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33224d;

    /* renamed from: e, reason: collision with root package name */
    private int f33225e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private ViewGroup f33226f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private View f33227h;

    /* renamed from: i, reason: collision with root package name */
    private View f33228i;

    /* renamed from: m, reason: collision with root package name */
    private int f33229m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TitleCollapseMode {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.p(windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.q(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class c implements AppBarLayout.g {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
            int i16;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.T = i3;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.V;
            if (windowInsetsCompat != null) {
                i16 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i16 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i17);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                e l3 = CollapsingToolbarLayout.l(childAt);
                int i18 = layoutParams.f33230a;
                if (i18 != 1) {
                    if (i18 == 2) {
                        l3.j(Math.round((-i3) * layoutParams.f33231b));
                    }
                } else {
                    l3.j(MathUtils.clamp(-i3, 0, CollapsingToolbarLayout.this.h(childAt)));
                }
            }
            CollapsingToolbarLayout.this.w();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.L != null && i16 > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - i16;
            float f16 = height;
            CollapsingToolbarLayout.this.G.n0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.i()) / f16));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.G.a0(collapsingToolbarLayout3.T + height);
            CollapsingToolbarLayout.this.G.l0(Math.abs(i3) / f16);
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i3) {
        TimeInterpolator timeInterpolator;
        c();
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.P = valueAnimator2;
            if (i3 > this.M) {
                timeInterpolator = x0.a.f446812c;
            } else {
                timeInterpolator = x0.a.f446813d;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.P.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.P.cancel();
        }
        this.P.setDuration(this.Q);
        this.P.setIntValues(this.M, i3);
        this.P.start();
    }

    private void b(AppBarLayout appBarLayout) {
        if (m()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void c() {
        if (!this.f33224d) {
            return;
        }
        ViewGroup viewGroup = null;
        this.f33226f = null;
        this.f33227h = null;
        int i3 = this.f33225e;
        if (i3 != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i3);
            this.f33226f = viewGroup2;
            if (viewGroup2 != null) {
                this.f33227h = d(viewGroup2);
            }
        }
        if (this.f33226f == null) {
            int childCount = getChildCount();
            int i16 = 0;
            while (true) {
                if (i16 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i16);
                if (n(childAt)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
                i16++;
            }
            this.f33226f = viewGroup;
        }
        v();
        this.f33224d = false;
    }

    @NonNull
    private View d(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private static int g(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence k(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static e l(@NonNull View view) {
        e eVar = (e) view.getTag(R.id.f11880755);
        if (eVar == null) {
            e eVar2 = new e(view);
            view.setTag(R.id.f11880755, eVar2);
            return eVar2;
        }
        return eVar;
    }

    private boolean m() {
        if (this.U == 1) {
            return true;
        }
        return false;
    }

    private static boolean n(View view) {
        if (!(view instanceof Toolbar) && !(view instanceof android.widget.Toolbar)) {
            return false;
        }
        return true;
    }

    private boolean o(View view) {
        View view2 = this.f33227h;
        if (view2 != null && view2 != this) {
            if (view == view2) {
                return true;
            }
        } else if (view == this.f33226f) {
            return true;
        }
        return false;
    }

    private void r(boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        View view = this.f33227h;
        if (view == null) {
            view = this.f33226f;
        }
        int h16 = h(view);
        com.google.android.material.internal.d.a(this, this.f33228i, this.F);
        ViewGroup viewGroup = this.f33226f;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i3 = toolbar.getTitleMarginStart();
            i17 = toolbar.getTitleMarginEnd();
            i18 = toolbar.getTitleMarginTop();
            i16 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT >= 24 && (viewGroup instanceof android.widget.Toolbar)) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i3 = toolbar2.getTitleMarginStart();
            i17 = toolbar2.getTitleMarginEnd();
            i18 = toolbar2.getTitleMarginTop();
            i16 = toolbar2.getTitleMarginBottom();
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        com.google.android.material.internal.b bVar = this.G;
        Rect rect = this.F;
        int i26 = rect.left;
        if (z16) {
            i19 = i17;
        } else {
            i19 = i3;
        }
        int i27 = i26 + i19;
        int i28 = rect.top + h16 + i18;
        int i29 = rect.right;
        if (!z16) {
            i3 = i17;
        }
        bVar.S(i27, i28, i29 - i3, (rect.bottom + h16) - i16);
    }

    private void s() {
        setContentDescription(j());
    }

    private void t(@NonNull Drawable drawable, int i3, int i16) {
        u(drawable, this.f33226f, i3, i16);
    }

    private void u(@NonNull Drawable drawable, @Nullable View view, int i3, int i16) {
        if (m() && view != null && this.I) {
            i16 = view.getBottom();
        }
        drawable.setBounds(0, 0, i3, i16);
    }

    private void v() {
        View view;
        if (!this.I && (view = this.f33228i) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f33228i);
            }
        }
        if (this.I && this.f33226f != null) {
            if (this.f33228i == null) {
                this.f33228i = new View(getContext());
            }
            if (this.f33228i.getParent() == null) {
                this.f33226f.addView(this.f33228i, -1, -1);
            }
        }
    }

    private void x(int i3, int i16, int i17, int i18, boolean z16) {
        View view;
        boolean z17;
        int i19;
        int i26;
        if (this.I && (view = this.f33228i) != null) {
            boolean z18 = false;
            if (ViewCompat.isAttachedToWindow(view) && this.f33228i.getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.J = z17;
            if (z17 || z16) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z18 = true;
                }
                r(z18);
                com.google.android.material.internal.b bVar = this.G;
                if (z18) {
                    i19 = this.D;
                } else {
                    i19 = this.f33229m;
                }
                int i27 = this.F.top + this.C;
                int i28 = i17 - i3;
                if (z18) {
                    i26 = this.f33229m;
                } else {
                    i26 = this.D;
                }
                bVar.b0(i19, i27, i28 - i26, (i18 - i16) - this.E);
                this.G.Q(z16);
            }
        }
    }

    private void y() {
        if (this.f33226f != null && this.I && TextUtils.isEmpty(this.G.D())) {
            setTitle(k(this.f33226f));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i3;
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.f33226f == null && (drawable = this.K) != null && this.M > 0) {
            drawable.mutate().setAlpha(this.M);
            this.K.draw(canvas);
        }
        if (this.I && this.J) {
            if (this.f33226f != null && this.K != null && this.M > 0 && m() && this.G.z() < this.G.A()) {
                int save = canvas.save();
                canvas.clipRect(this.K.getBounds(), Region.Op.DIFFERENCE);
                this.G.l(canvas);
                canvas.restoreToCount(save);
            } else {
                this.G.l(canvas);
            }
        }
        if (this.L != null && this.M > 0) {
            WindowInsetsCompat windowInsetsCompat = this.V;
            if (windowInsetsCompat != null) {
                i3 = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                this.L.setBounds(0, -this.T, getWidth(), i3 - this.T);
                this.L.mutate().setAlpha(this.M);
                this.L.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        boolean z16;
        if (this.K != null && this.M > 0 && o(view)) {
            u(this.K, view, getWidth(), getHeight());
            this.K.mutate().setAlpha(this.M);
            this.K.draw(canvas);
            z16 = true;
        } else {
            z16 = false;
        }
        if (super.drawChild(canvas, view, j3) || z16) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.L;
        boolean z16 = false;
        if (drawable != null && drawable.isStateful()) {
            z16 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.K;
        if (drawable2 != null && drawable2.isStateful()) {
            z16 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.G;
        if (bVar != null) {
            z16 |= bVar.v0(drawableState);
        }
        if (z16) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final int h(@NonNull View view) {
        return ((getHeight() - l(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int i() {
        int i3;
        int i16 = this.R;
        if (i16 >= 0) {
            return i16 + this.W + this.f33222b0;
        }
        WindowInsetsCompat windowInsetsCompat = this.V;
        if (windowInsetsCompat != null) {
            i3 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i3 = 0;
        }
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + i3, getHeight());
        }
        return getHeight() / 3;
    }

    @Nullable
    public CharSequence j() {
        if (this.I) {
            return this.G.D();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            b(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.S == null) {
                this.S = new c();
            }
            appBarLayout.e(this.S);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.G.M(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.g gVar = this.S;
        if (gVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).z(gVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        WindowInsetsCompat windowInsetsCompat = this.V;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt = getChildAt(i19);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i26 = 0; i26 < childCount2; i26++) {
            l(getChildAt(i26)).g();
        }
        x(i3, i16, i17, i18, false);
        y();
        w();
        int childCount3 = getChildCount();
        for (int i27 = 0; i27 < childCount3; i27++) {
            l(getChildAt(i27)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        c();
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        WindowInsetsCompat windowInsetsCompat = this.V;
        if (windowInsetsCompat != null) {
            i17 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i17 = 0;
        }
        if ((mode == 0 || this.f33221a0) && i17 > 0) {
            this.W = i17;
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i17, 1073741824));
        }
        if (this.f33223c0 && this.G.B() > 1) {
            y();
            x(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int w3 = this.G.w();
            if (w3 > 1) {
                this.f33222b0 = Math.round(this.G.x()) * (w3 - 1);
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.f33222b0, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f33226f;
        if (viewGroup != null) {
            View view = this.f33227h;
            if (view != null && view != this) {
                setMinimumHeight(g(view));
            } else {
                setMinimumHeight(g(viewGroup));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        Drawable drawable = this.K;
        if (drawable != null) {
            t(drawable, i3, i16);
        }
    }

    WindowInsetsCompat p(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.V, windowInsetsCompat2)) {
            this.V = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    void q(int i3) {
        ViewGroup viewGroup;
        if (i3 != this.M) {
            if (this.K != null && (viewGroup = this.f33226f) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.M = i3;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setCollapsedTitleGravity(int i3) {
        this.G.X(i3);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i3) {
        this.G.U(i3);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i3) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.G.Y(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.K;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.K = drawable3;
            if (drawable3 != null) {
                t(drawable3, getWidth(), getHeight());
                this.K.setCallback(this);
                this.K.setAlpha(this.M);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i3) {
        setContentScrim(new ColorDrawable(i3));
    }

    public void setContentScrimResource(@DrawableRes int i3) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setExpandedTitleColor(@ColorInt int i3) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setExpandedTitleGravity(int i3) {
        this.G.h0(i3);
    }

    public void setExpandedTitleMargin(int i3, int i16, int i17, int i18) {
        this.f33229m = i3;
        this.C = i16;
        this.D = i17;
        this.E = i18;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i3) {
        this.E = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i3) {
        this.D = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i3) {
        this.f33229m = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i3) {
        this.C = i3;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i3) {
        this.G.e0(i3);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.G.g0(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.G.j0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z16) {
        this.f33223c0 = z16;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z16) {
        this.f33221a0 = z16;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i3) {
        this.G.o0(i3);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f16) {
        this.G.q0(f16);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f16) {
        this.G.r0(f16);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i3) {
        this.G.s0(i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z16) {
        this.G.u0(z16);
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j3) {
        this.Q = j3;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i3) {
        if (this.R != i3) {
            this.R = i3;
            w();
        }
    }

    public void setScrimsShown(boolean z16) {
        setScrimsShown(z16, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        boolean z16;
        Drawable drawable2 = this.L;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.L = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.L.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.L, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.L;
                if (getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                drawable4.setVisible(z16, false);
                this.L.setCallback(this);
                this.L.setAlpha(this.M);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i3) {
        setStatusBarScrim(new ColorDrawable(i3));
    }

    public void setStatusBarScrimResource(@DrawableRes int i3) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i3));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.G.w0(charSequence);
        s();
    }

    public void setTitleCollapseMode(int i3) {
        this.U = i3;
        boolean m3 = m();
        this.G.m0(m3);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            b((AppBarLayout) parent);
        }
        if (m3 && this.K == null) {
            setContentScrimColor(this.H.d(getResources().getDimension(R.dimen.f158657c84)));
        }
    }

    public void setTitleEnabled(boolean z16) {
        if (z16 != this.I) {
            this.I = z16;
            s();
            v();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.G.t0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        boolean z16;
        super.setVisibility(i3);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Drawable drawable = this.L;
        if (drawable != null && drawable.isVisible() != z16) {
            this.L.setVisible(z16, false);
        }
        Drawable drawable2 = this.K;
        if (drawable2 != null && drawable2.isVisible() != z16) {
            this.K.setVisible(z16, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.K && drawable != this.L) {
            return false;
        }
        return true;
    }

    final void w() {
        boolean z16;
        if (this.K != null || this.L != null) {
            if (getHeight() + this.T < i()) {
                z16 = true;
            } else {
                z16 = false;
            }
            setScrimsShown(z16);
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a7j);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.G.W(colorStateList);
    }

    public void setScrimsShown(boolean z16, boolean z17) {
        if (this.N != z16) {
            if (z17) {
                a(z16 ? 255 : 0);
            } else {
                q(z16 ? 255 : 0);
            }
            this.N = z16;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f33220d0;
        this.f33224d = true;
        this.F = new Rect();
        this.R = -1;
        this.W = 0;
        this.f33222b0 = 0;
        Context context2 = getContext();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.G = bVar;
        bVar.x0(x0.a.f446814e);
        bVar.u0(false);
        this.H = new c1.a(context2);
        TypedArray h16 = o.h(context2, attributeSet, w0.a.W1, i3, i16, new int[0]);
        bVar.h0(h16.getInt(w0.a.f443823b2, 8388691));
        bVar.X(h16.getInt(w0.a.X1, 8388627));
        int dimensionPixelSize = h16.getDimensionPixelSize(w0.a.f443835c2, 0);
        this.E = dimensionPixelSize;
        this.D = dimensionPixelSize;
        this.C = dimensionPixelSize;
        this.f33229m = dimensionPixelSize;
        int i17 = w0.a.f443871f2;
        if (h16.hasValue(i17)) {
            this.f33229m = h16.getDimensionPixelSize(i17, 0);
        }
        int i18 = w0.a.f443859e2;
        if (h16.hasValue(i18)) {
            this.D = h16.getDimensionPixelSize(i18, 0);
        }
        int i19 = w0.a.f443883g2;
        if (h16.hasValue(i19)) {
            this.C = h16.getDimensionPixelSize(i19, 0);
        }
        int i26 = w0.a.f443847d2;
        if (h16.hasValue(i26)) {
            this.E = h16.getDimensionPixelSize(i26, 0);
        }
        this.I = h16.getBoolean(w0.a.f444009r2, true);
        setTitle(h16.getText(w0.a.f443985p2));
        bVar.e0(R.style.aas);
        bVar.U(R.style.f173669aa3);
        int i27 = w0.a.f443895h2;
        if (h16.hasValue(i27)) {
            bVar.e0(h16.getResourceId(i27, 0));
        }
        int i28 = w0.a.Y1;
        if (h16.hasValue(i28)) {
            bVar.U(h16.getResourceId(i28, 0));
        }
        int i29 = w0.a.f443907i2;
        if (h16.hasValue(i29)) {
            bVar.g0(g1.c.a(context2, h16, i29));
        }
        int i36 = w0.a.Z1;
        if (h16.hasValue(i36)) {
            bVar.W(g1.c.a(context2, h16, i36));
        }
        this.R = h16.getDimensionPixelSize(w0.a.f443962n2, -1);
        int i37 = w0.a.f443940l2;
        if (h16.hasValue(i37)) {
            bVar.s0(h16.getInt(i37, 1));
        }
        int i38 = w0.a.f444021s2;
        if (h16.hasValue(i38)) {
            bVar.t0(AnimationUtils.loadInterpolator(context2, h16.getResourceId(i38, 0)));
        }
        this.Q = h16.getInt(w0.a.f443951m2, 600);
        setContentScrim(h16.getDrawable(w0.a.f443811a2));
        setStatusBarScrim(h16.getDrawable(w0.a.f443973o2));
        setTitleCollapseMode(h16.getInt(w0.a.f443997q2, 0));
        this.f33225e = h16.getResourceId(w0.a.f444033t2, -1);
        this.f33221a0 = h16.getBoolean(w0.a.f443929k2, false);
        this.f33223c0 = h16.getBoolean(w0.a.f443918j2, false);
        h16.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f33230a;

        /* renamed from: b, reason: collision with root package name */
        float f33231b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33230a = 0;
            this.f33231b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f444045u2);
            this.f33230a = obtainStyledAttributes.getInt(w0.a.f444057v2, 0);
            a(obtainStyledAttributes.getFloat(w0.a.f444068w2, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f16) {
            this.f33231b = f16;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f33230a = 0;
            this.f33231b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33230a = 0;
            this.f33231b = 0.5f;
        }
    }
}
