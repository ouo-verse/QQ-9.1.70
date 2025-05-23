package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.o;
import com.google.android.material.shape.g;
import com.google.android.material.stateful.ExtendableSavedState;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import x0.h;
import x0.k;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, d1.a, j1.f, CoordinatorLayout.AttachedBehavior {
    private static final int N = 2131953245;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    boolean H;
    final Rect I;
    private final Rect J;

    @NonNull
    private final AppCompatImageHelper K;

    @NonNull
    private final d1.b L;
    private com.google.android.material.floatingactionbutton.d M;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private ColorStateList f33657e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f33658f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private ColorStateList f33659h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f33660i;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private ColorStateList f33661m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: e */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: f */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i3) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i3);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface Size {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements d.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33665a;

        a(b bVar) {
            this.f33665a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void onHidden() {
            this.f33665a.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.k
        public void onShown() {
            this.f33665a.b(FloatingActionButton.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements i1.b {
        c() {
        }

        @Override // i1.b
        public boolean a() {
            return FloatingActionButton.this.H;
        }

        @Override // i1.b
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // i1.b
        public void setShadowPadding(int i3, int i16, int i17, int i18) {
            FloatingActionButton.this.I.set(i3, i16, i17, i18);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i3 + floatingActionButton.F, i16 + FloatingActionButton.this.F, i17 + FloatingActionButton.this.F, i18 + FloatingActionButton.this.F);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class d<T extends FloatingActionButton> implements d.j {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final k<T> f33668a;

        d(@NonNull k<T> kVar) {
            this.f33668a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.f33668a.a(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void b() {
            this.f33668a.b(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            if ((obj instanceof d) && ((d) obj).f33668a.equals(this.f33668a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f33668a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private d.k A(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @NonNull
    private com.google.android.material.floatingactionbutton.d h() {
        return new e(this, new c());
    }

    private com.google.android.material.floatingactionbutton.d l() {
        if (this.M == null) {
            this.M = h();
        }
        return this.M;
    }

    private int q(int i3) {
        int i16 = this.E;
        if (i16 != 0) {
            return i16;
        }
        Resources resources = getResources();
        if (i3 != -1) {
            if (i3 != 1) {
                return resources.getDimensionPixelSize(R.dimen.c8n);
            }
            return resources.getDimensionPixelSize(R.dimen.c8m);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return q(1);
        }
        return q(0);
    }

    private void v(@NonNull Rect rect) {
        int i3 = rect.left;
        Rect rect2 = this.I;
        rect.left = i3 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void w() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f33659h;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f33660i;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private static int x(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return size;
                }
                throw new IllegalArgumentException();
            }
            return i3;
        }
        return Math.min(i3, size);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        l().A(getDrawableState());
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        l().e(animatorListener);
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        l().f(animatorListener);
    }

    public void g(@NonNull k<? extends FloatingActionButton> kVar) {
        l().g(new d(kVar));
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f33657e;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f33658f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f33659h;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f33660i;
    }

    @Deprecated
    public boolean i(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        v(rect);
        return true;
    }

    @Override // d1.a
    public boolean isExpanded() {
        return this.L.c();
    }

    public int j() {
        return this.L.b();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        l().w();
    }

    @Nullable
    public h k() {
        return l().n();
    }

    public void m(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        v(rect);
    }

    @NonNull
    public g n() {
        return (g) Preconditions.checkNotNull(l().q());
    }

    @Nullable
    public h o() {
        return l().r();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l().x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        int p16 = p();
        this.F = (p16 - this.G) / 2;
        l().b0();
        int min = Math.min(x(p16, i3), x(p16, i16));
        Rect rect = this.I;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.L.d((Bundle) Preconditions.checkNotNull(extendableSavedState.f34223d.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f34223d.put("expandableWidgetHelper", this.L.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.J) && !this.J.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return q(this.D);
    }

    public void r(@Nullable b bVar) {
        s(bVar, true);
    }

    void s(@Nullable b bVar, boolean z16) {
        l().s(A(bVar), z16);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f33657e != colorStateList) {
            this.f33657e = colorStateList;
            l().H(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f33658f != mode) {
            this.f33658f = mode;
            l().I(mode);
        }
    }

    public void setCompatElevation(float f16) {
        l().J(f16);
    }

    public void setCompatElevationResource(@DimenRes int i3) {
        setCompatElevation(getResources().getDimension(i3));
    }

    public void setCompatHoveredFocusedTranslationZ(float f16) {
        l().M(f16);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i3) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i3));
    }

    public void setCompatPressedTranslationZ(float f16) {
        l().Q(f16);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i3) {
        setCompatPressedTranslationZ(getResources().getDimension(i3));
    }

    public void setCustomSize(@Px int i3) {
        if (i3 >= 0) {
            if (i3 != this.E) {
                this.E = i3;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        l().c0(f16);
    }

    public void setEnsureMinTouchTargetSize(boolean z16) {
        if (z16 != l().m()) {
            l().K(z16);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i3) {
        this.L.f(i3);
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        l().L(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i3) {
        setHideMotionSpec(h.d(getContext(), i3));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            l().a0();
            if (this.f33659h != null) {
                w();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i3) {
        this.K.setImageResource(i3);
        w();
    }

    public void setMaxImageSize(int i3) {
        this.G = i3;
        l().O(i3);
    }

    public void setRippleColor(@ColorInt int i3) {
        setRippleColor(ColorStateList.valueOf(i3));
    }

    @Override // android.view.View
    public void setScaleX(float f16) {
        super.setScaleX(f16);
        l().E();
    }

    @Override // android.view.View
    public void setScaleY(float f16) {
        super.setScaleY(f16);
        l().E();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z16) {
        l().S(z16);
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        l().T(gVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        l().U(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i3) {
        setShowMotionSpec(h.d(getContext(), i3));
    }

    public void setSize(int i3) {
        this.E = 0;
        if (i3 != this.D) {
            this.D = i3;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f33659h != colorStateList) {
            this.f33659h = colorStateList;
            w();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f33660i != mode) {
            this.f33660i = mode;
            w();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f16) {
        super.setTranslationX(f16);
        l().F();
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        l().F();
    }

    @Override // android.view.View
    public void setTranslationZ(float f16) {
        super.setTranslationZ(f16);
        l().F();
    }

    public void setUseCompatPadding(boolean z16) {
        if (this.H != z16) {
            this.H = z16;
            l().y();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public boolean t() {
        return l().u();
    }

    public boolean u() {
        return l().v();
    }

    public void y(@Nullable b bVar) {
        z(bVar, true);
    }

    void z(@Nullable b bVar, boolean z16) {
        l().Y(A(bVar), z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: g, reason: collision with root package name */
        private Rect f33662g;

        /* renamed from: h, reason: collision with root package name */
        private b f33663h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f33664i;

        public BaseBehavior() {
            this.f33664i = true;
        }

        private static boolean c(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i3;
            Rect rect = floatingActionButton.I;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                int i16 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                    i3 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) {
                    i3 = -rect.left;
                } else {
                    i3 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                    i16 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                    i16 = -rect.top;
                }
                if (i16 != 0) {
                    ViewCompat.offsetTopAndBottom(floatingActionButton, i16);
                }
                if (i3 != 0) {
                    ViewCompat.offsetLeftAndRight(floatingActionButton, i3);
                }
            }
        }

        private boolean g(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (!this.f33664i || layoutParams.getAnchorId() != view.getId() || floatingActionButton.a() != 0) {
                return false;
            }
            return true;
        }

        private boolean h(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!g(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f33662g == null) {
                this.f33662g = new Rect();
            }
            Rect rect = this.f33662g;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.m()) {
                floatingActionButton.s(this.f33663h, false);
                return true;
            }
            floatingActionButton.z(this.f33663h, false);
            return true;
        }

        private boolean i(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!g(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.s(this.f33663h, false);
                return true;
            }
            floatingActionButton.z(this.f33663h, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.I;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                h(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (c(view)) {
                i(view, floatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i3) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i16 = 0; i16 < size; i16++) {
                View view = dependencies.get(i16);
                if (view instanceof AppBarLayout) {
                    if (h(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (c(view) && i(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i3);
            d(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f443896h3);
            this.f33664i = obtainStyledAttributes.getBoolean(w0.a.i3, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ag6);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f33661m != colorStateList) {
            this.f33661m = colorStateList;
            l().R(this.f33661m);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r6), attributeSet, i3);
        int i16 = N;
        this.I = new Rect();
        this.J = new Rect();
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.R2, i3, i16, new int[0]);
        this.f33657e = g1.c.a(context2, h16, w0.a.T2);
        this.f33658f = ViewUtils.j(h16.getInt(w0.a.U2, -1), null);
        this.f33661m = g1.c.a(context2, h16, w0.a.f443860e3);
        this.D = h16.getInt(w0.a.Z2, -1);
        this.E = h16.getDimensionPixelSize(w0.a.Y2, 0);
        this.C = h16.getDimensionPixelSize(w0.a.V2, 0);
        float dimension = h16.getDimension(w0.a.W2, 0.0f);
        float dimension2 = h16.getDimension(w0.a.f443824b3, 0.0f);
        float dimension3 = h16.getDimension(w0.a.f443848d3, 0.0f);
        this.H = h16.getBoolean(w0.a.f443884g3, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cu8);
        setMaxImageSize(h16.getDimensionPixelSize(w0.a.f443836c3, 0));
        h c16 = h.c(context2, h16, w0.a.f443872f3);
        h c17 = h.c(context2, h16, w0.a.f443812a3);
        g m3 = g.g(context2, attributeSet, i3, i16, g.f34052m).m();
        boolean z16 = h16.getBoolean(w0.a.X2, false);
        setEnabled(h16.getBoolean(w0.a.S2, true));
        h16.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.K = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i3);
        this.L = new d1.b(this);
        l().T(m3);
        l().t(this.f33657e, this.f33658f, this.f33661m, this.C);
        l().P(dimensionPixelSize);
        l().J(dimension);
        l().M(dimension2);
        l().Q(dimension3);
        l().U(c16);
        l().L(c17);
        l().K(z16);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }
}
