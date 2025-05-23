package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.shape.d;
import com.google.android.material.shape.g;
import g1.c;
import j1.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, f {
    private static final int[] Q = {R.attr.state_checkable};
    private static final int[] R = {R.attr.state_checked};
    private static final int S = 2131953409;

    @NonNull
    private final com.google.android.material.button.a C;

    @NonNull
    private final LinkedHashSet<a> D;

    @Nullable
    private b E;

    @Nullable
    private PorterDuff.Mode F;

    @Nullable
    private ColorStateList G;

    @Nullable
    private Drawable H;

    @Px
    private int I;

    @Px
    private int J;

    @Px
    private int K;

    @Px
    private int L;
    private boolean M;
    private boolean N;
    private int P;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface IconGravity {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        boolean f33369d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            boolean z16 = true;
            if (parcel.readInt() != 1) {
                z16 = false;
            }
            this.f33369d = z16;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f33369d ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z16);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    private String b() {
        Class cls;
        if (k()) {
            cls = CompoundButton.class;
        } else {
            cls = Button.class;
        }
        return cls.getName();
    }

    private Layout.Alignment c() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return d();
    }

    private Layout.Alignment d() {
        int gravity = getGravity() & 8388615;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int i() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int j() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private boolean l() {
        int i3 = this.P;
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    private boolean m() {
        int i3 = this.P;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    private boolean n() {
        int i3 = this.P;
        if (i3 != 16 && i3 != 32) {
            return false;
        }
        return true;
    }

    private boolean o() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    private boolean p() {
        com.google.android.material.button.a aVar = this.C;
        if (aVar != null && !aVar.j()) {
            return true;
        }
        return false;
    }

    private void q() {
        if (m()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.H, null, null, null);
        } else if (l()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.H, null);
        } else if (n()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.H, null, null);
        }
    }

    private void u(boolean z16) {
        Drawable drawable = this.H;
        boolean z17 = true;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.H = mutate;
            DrawableCompat.setTintList(mutate, this.G);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                DrawableCompat.setTintMode(this.H, mode);
            }
            int i3 = this.I;
            if (i3 == 0) {
                i3 = this.H.getIntrinsicWidth();
            }
            int i16 = this.I;
            if (i16 == 0) {
                i16 = this.H.getIntrinsicHeight();
            }
            Drawable drawable2 = this.H;
            int i17 = this.J;
            int i18 = this.K;
            drawable2.setBounds(i17, i18, i3 + i17, i16 + i18);
            this.H.setVisible(true, z16);
        }
        if (z16) {
            q();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!m() || drawable3 == this.H) && ((!l() || drawable5 == this.H) && (!n() || drawable4 == this.H))) {
            z17 = false;
        }
        if (z17) {
            q();
        }
    }

    private void v(int i3, int i16) {
        if (this.H != null && getLayout() != null) {
            if (!m() && !l()) {
                if (n()) {
                    this.J = 0;
                    if (this.P == 16) {
                        this.K = 0;
                        u(false);
                        return;
                    }
                    int i17 = this.I;
                    if (i17 == 0) {
                        i17 = this.H.getIntrinsicHeight();
                    }
                    int i18 = (((((i16 - i()) - getPaddingTop()) - i17) - this.L) - getPaddingBottom()) / 2;
                    if (this.K != i18) {
                        this.K = i18;
                        u(false);
                        return;
                    }
                    return;
                }
                return;
            }
            this.K = 0;
            Layout.Alignment c16 = c();
            int i19 = this.P;
            boolean z16 = true;
            if (i19 != 1 && i19 != 3 && ((i19 != 2 || c16 != Layout.Alignment.ALIGN_NORMAL) && (i19 != 4 || c16 != Layout.Alignment.ALIGN_OPPOSITE))) {
                int i26 = this.I;
                if (i26 == 0) {
                    i26 = this.H.getIntrinsicWidth();
                }
                int j3 = ((((i3 - j()) - ViewCompat.getPaddingEnd(this)) - i26) - this.L) - ViewCompat.getPaddingStart(this);
                if (c16 == Layout.Alignment.ALIGN_CENTER) {
                    j3 /= 2;
                }
                boolean o16 = o();
                if (this.P != 4) {
                    z16 = false;
                }
                if (o16 != z16) {
                    j3 = -j3;
                }
                if (this.J != j3) {
                    this.J = j3;
                    u(false);
                    return;
                }
                return;
            }
            this.J = 0;
            u(false);
        }
    }

    public Drawable e() {
        return this.H;
    }

    @Px
    public int f() {
        return this.I;
    }

    @NonNull
    public g g() {
        if (p()) {
            return this.C.e();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (p()) {
            return this.C.g();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (p()) {
            return this.C.h();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Px
    public int h() {
        if (p()) {
            return this.C.f();
        }
        return 0;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.M;
    }

    public boolean k() {
        com.google.android.material.button.a aVar = this.C;
        if (aVar != null && aVar.k()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (p()) {
            d.f(this, this.C.c());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (k()) {
            View.mergeDrawableStates(onCreateDrawableState, Q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, R);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(b());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(b());
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        v(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f33369d);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f33369d = this.M;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        super.onTextChanged(charSequence, i3, i16, i17);
        v(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.H != null) {
            if (this.H.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@Nullable b bVar) {
        this.E = bVar;
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i3) {
        if (p()) {
            this.C.m(i3);
        } else {
            super.setBackgroundColor(i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (p()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.C.n();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i3) {
        Drawable drawable;
        if (i3 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i3);
        } else {
            drawable = null;
        }
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z16) {
        if (p()) {
            this.C.o(z16);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        if (k() && isEnabled() && this.M != z16) {
            this.M = z16;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).p(this, this.M);
            }
            if (this.N) {
                return;
            }
            this.N = true;
            Iterator<a> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.M);
            }
            this.N = false;
        }
    }

    public void setCornerRadius(@Px int i3) {
        if (p()) {
            this.C.p(i3);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i3) {
        if (p()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        if (p()) {
            this.C.c().X(f16);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.H != drawable) {
            this.H = drawable;
            u(true);
            v(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.P != i3) {
            this.P = i3;
            v(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i3) {
        if (this.L != i3) {
            this.L = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(@DrawableRes int i3) {
        Drawable drawable;
        if (i3 != 0) {
            drawable = AppCompatResources.getDrawable(getContext(), i3);
        } else {
            drawable = null;
        }
        setIcon(drawable);
    }

    public void setIconSize(@Px int i3) {
        if (i3 >= 0) {
            if (this.I != i3) {
                this.I = i3;
                u(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            u(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.F != mode) {
            this.F = mode;
            u(false);
        }
    }

    public void setIconTintResource(@ColorRes int i3) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setInsetBottom(@Dimension int i3) {
        this.C.q(i3);
    }

    public void setInsetTop(@Dimension int i3) {
        this.C.r(i3);
    }

    @Override // android.view.View
    public void setPressed(boolean z16) {
        b bVar = this.E;
        if (bVar != null) {
            bVar.a(this, z16);
        }
        super.setPressed(z16);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (p()) {
            this.C.s(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i3) {
        if (p()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i3));
        }
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull g gVar) {
        if (p()) {
            this.C.t(gVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (p()) {
            this.C.v(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i3) {
        if (p()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i3));
        }
    }

    public void setStrokeWidth(@Px int i3) {
        if (p()) {
            this.C.w(i3);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i3) {
        if (p()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (p()) {
            this.C.x(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (p()) {
            this.C.y(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        v(getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z16) {
        if (p()) {
            this.C.u(z16);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.M);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.aui);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r6), attributeSet, i3);
        int i16 = S;
        this.D = new LinkedHashSet<>();
        this.M = false;
        this.N = false;
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.T3, i3, i16, new int[0]);
        this.L = h16.getDimensionPixelSize(w0.a.f443885g4, 0);
        this.F = ViewUtils.j(h16.getInt(w0.a.f443919j4, -1), PorterDuff.Mode.SRC_IN);
        this.G = c.a(getContext(), h16, w0.a.f443908i4);
        this.H = c.e(getContext(), h16, w0.a.f443861e4);
        this.P = h16.getInteger(w0.a.f443873f4, 1);
        this.I = h16.getDimensionPixelSize(w0.a.f443897h4, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, g.e(context2, attributeSet, i3, i16).m());
        this.C = aVar;
        aVar.l(h16);
        h16.recycle();
        setCompoundDrawablePadding(this.L);
        u(this.H != null);
    }
}
