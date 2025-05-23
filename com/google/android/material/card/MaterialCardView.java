package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.o;
import com.google.android.material.shape.d;
import com.google.android.material.shape.g;
import j1.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, f {
    private static final int D = 2131953421;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.card.a f33407d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33408e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33409f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33410h;

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f33405i = {R.attr.state_checkable};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f33406m = {R.attr.state_checked};
    private static final int[] C = {com.tencent.mobileqq.R.attr.bco};

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CheckedIconGravity {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void h() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f33407d.i();
        }
    }

    @NonNull
    private RectF i() {
        RectF rectF = new RectF();
        rectF.set(this.f33407d.j().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f33407d.k();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f33407d.p().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f33407d.p().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f33407d.p().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f33407d.p().top;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f33407d.n();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f33409f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return super.getRadius();
    }

    public boolean k() {
        com.google.android.material.card.a aVar = this.f33407d;
        if (aVar != null && aVar.s()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return this.f33410h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i3, int i16, int i17, int i18) {
        super.setContentPadding(i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.f(this, this.f33407d.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 3);
        if (k()) {
            View.mergeDrawableStates(onCreateDrawableState, f33405i);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f33406m);
        }
        if (l()) {
            View.mergeDrawableStates(onCreateDrawableState, C);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f33407d.w(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f33408e) {
            if (!this.f33407d.r()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f33407d.x(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i3) {
        this.f33407d.y(ColorStateList.valueOf(i3));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f16) {
        super.setCardElevation(f16);
        this.f33407d.S();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f33407d.z(colorStateList);
    }

    public void setCheckable(boolean z16) {
        this.f33407d.A(z16);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        if (this.f33409f != z16) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f33407d.C(drawable);
    }

    public void setCheckedIconGravity(int i3) {
        if (this.f33407d.l() != i3) {
            this.f33407d.D(i3);
        }
    }

    public void setCheckedIconMargin(@Dimension int i3) {
        this.f33407d.E(i3);
    }

    public void setCheckedIconMarginResource(@DimenRes int i3) {
        if (i3 != -1) {
            this.f33407d.E(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i3) {
        this.f33407d.C(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setCheckedIconSize(@Dimension int i3) {
        this.f33407d.F(i3);
    }

    public void setCheckedIconSizeResource(@DimenRes int i3) {
        if (i3 != 0) {
            this.f33407d.F(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f33407d.G(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z16) {
        super.setClickable(z16);
        com.google.android.material.card.a aVar = this.f33407d;
        if (aVar != null) {
            aVar.Q();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i3, int i16, int i17, int i18) {
        this.f33407d.N(i3, i16, i17, i18);
    }

    public void setDragged(boolean z16) {
        if (this.f33410h != z16) {
            this.f33410h = z16;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f16) {
        super.setMaxCardElevation(f16);
        this.f33407d.U();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z16) {
        super.setPreventCornerOverlap(z16);
        this.f33407d.U();
        this.f33407d.R();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f33407d.I(f16);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f16) {
        super.setRadius(f16);
        this.f33407d.H(f16);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f33407d.J(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i3) {
        this.f33407d.J(AppCompatResources.getColorStateList(getContext(), i3));
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        setClipToOutline(gVar.u(i()));
        this.f33407d.K(gVar);
    }

    public void setStrokeColor(@ColorInt int i3) {
        setStrokeColor(ColorStateList.valueOf(i3));
    }

    public void setStrokeWidth(@Dimension int i3) {
        this.f33407d.M(i3);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z16) {
        super.setUseCompatPadding(z16);
        this.f33407d.U();
        this.f33407d.R();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (k() && isEnabled()) {
            this.f33409f = !this.f33409f;
            refreshDrawableState();
            h();
            this.f33407d.B(this.f33409f);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.f155870av3);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f33407d.y(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f33407d.L(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r6), attributeSet, i3);
        int i16 = D;
        this.f33409f = false;
        this.f33410h = false;
        this.f33408e = true;
        TypedArray h16 = o.h(getContext(), attributeSet, w0.a.L4, i3, i16, new int[0]);
        com.google.android.material.card.a aVar = new com.google.android.material.card.a(this, attributeSet, i3, i16);
        this.f33407d = aVar;
        aVar.y(super.getCardBackgroundColor());
        aVar.N(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.v(h16);
        h16.recycle();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
    }
}
