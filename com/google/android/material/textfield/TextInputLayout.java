package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.g;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: f1, reason: collision with root package name */
    private static final int f34371f1 = 2131953251;
    private final SparseArray<com.google.android.material.textfield.d> A0;

    @NonNull
    private final CheckableImageButton B0;
    private int C;
    private final LinkedHashSet<e> C0;
    private int D;
    private ColorStateList D0;
    private int E;
    private PorterDuff.Mode E0;
    private int F;

    @Nullable
    private Drawable F0;
    private final f G;
    private int G0;
    boolean H;
    private Drawable H0;
    private int I;
    private View.OnLongClickListener I0;
    private boolean J;
    private View.OnLongClickListener J0;

    @Nullable
    private TextView K;

    @NonNull
    private final CheckableImageButton K0;
    private int L;
    private ColorStateList L0;
    private int M;
    private PorterDuff.Mode M0;
    private CharSequence N;
    private ColorStateList N0;
    private ColorStateList O0;
    private boolean P;

    @ColorInt
    private int P0;
    private TextView Q;

    @ColorInt
    private int Q0;

    @Nullable
    private ColorStateList R;

    @ColorInt
    private int R0;
    private int S;
    private ColorStateList S0;

    @Nullable
    private Fade T;

    @ColorInt
    private int T0;

    @Nullable
    private Fade U;

    @ColorInt
    private int U0;

    @Nullable
    private ColorStateList V;

    @ColorInt
    private int V0;

    @Nullable
    private ColorStateList W;

    @ColorInt
    private int W0;

    @ColorInt
    private int X0;
    private boolean Y0;
    final com.google.android.material.internal.b Z0;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private CharSequence f34372a0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f34373a1;

    /* renamed from: b0, reason: collision with root package name */
    @NonNull
    private final TextView f34374b0;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f34375b1;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f34376c0;

    /* renamed from: c1, reason: collision with root package name */
    private ValueAnimator f34377c1;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final FrameLayout f34378d;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence f34379d0;

    /* renamed from: d1, reason: collision with root package name */
    private boolean f34380d1;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final h f34381e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f34382e0;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f34383e1;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final LinearLayout f34384f;

    /* renamed from: f0, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f34385f0;

    /* renamed from: g0, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f34386g0;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private final FrameLayout f34387h;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    private MaterialShapeDrawable f34388h0;

    /* renamed from: i, reason: collision with root package name */
    EditText f34389i;

    /* renamed from: i0, reason: collision with root package name */
    @NonNull
    private com.google.android.material.shape.g f34390i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f34391j0;

    /* renamed from: k0, reason: collision with root package name */
    private final int f34392k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f34393l0;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f34394m;

    /* renamed from: m0, reason: collision with root package name */
    private int f34395m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f34396n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f34397o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f34398p0;

    /* renamed from: q0, reason: collision with root package name */
    @ColorInt
    private int f34399q0;

    /* renamed from: r0, reason: collision with root package name */
    @ColorInt
    private int f34400r0;

    /* renamed from: s0, reason: collision with root package name */
    private final Rect f34401s0;

    /* renamed from: t0, reason: collision with root package name */
    private final Rect f34402t0;

    /* renamed from: u0, reason: collision with root package name */
    private final RectF f34403u0;

    /* renamed from: v0, reason: collision with root package name */
    private Typeface f34404v0;

    /* renamed from: w0, reason: collision with root package name */
    @Nullable
    private Drawable f34405w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f34406x0;

    /* renamed from: y0, reason: collision with root package name */
    private final LinkedHashSet<d> f34407y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f34408z0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface BoxBackgroundMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface EndIconMode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        CharSequence f34409d;

        /* renamed from: e, reason: collision with root package name */
        boolean f34410e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        CharSequence f34411f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        CharSequence f34412h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        CharSequence f34413i;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f34409d) + " hint=" + ((Object) this.f34411f) + " helperText=" + ((Object) this.f34412h) + " placeholderText=" + ((Object) this.f34413i) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f34409d, parcel, i3);
            parcel.writeInt(this.f34410e ? 1 : 0);
            TextUtils.writeToParcel(this.f34411f, parcel, i3);
            TextUtils.writeToParcel(this.f34412h, parcel, i3);
            TextUtils.writeToParcel(this.f34413i, parcel, i3);
        }

        SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f34409d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f34410e = parcel.readInt() == 1;
            this.f34411f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f34412h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f34413i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
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
            TextInputLayout.this.Z0.l0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f34416a;

        public c(@NonNull TextInputLayout textInputLayout) {
            this.f34416a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence;
            boolean z16;
            String str;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText L = this.f34416a.L();
            if (L != null) {
                charSequence = L.getText();
            } else {
                charSequence = null;
            }
            CharSequence U = this.f34416a.U();
            CharSequence R = this.f34416a.R();
            CharSequence X = this.f34416a.X();
            int J = this.f34416a.J();
            CharSequence K = this.f34416a.K();
            boolean z17 = !TextUtils.isEmpty(charSequence);
            boolean z18 = !TextUtils.isEmpty(U);
            boolean z19 = !this.f34416a.h0();
            boolean z26 = !TextUtils.isEmpty(R);
            if (!z26 && TextUtils.isEmpty(K)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z18) {
                str = U.toString();
            } else {
                str = "";
            }
            this.f34416a.f34381e.u(accessibilityNodeInfoCompat);
            if (z17) {
                accessibilityNodeInfoCompat.setText(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (z19 && X != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + ((Object) X));
                }
            } else if (X != null) {
                accessibilityNodeInfoCompat.setText(X);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (z17) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z17);
            }
            if (charSequence == null || charSequence.length() != J) {
                J = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(J);
            if (z16) {
                if (!z26) {
                    R = K;
                }
                accessibilityNodeInfoCompat.setError(R);
            }
            View r16 = this.f34416a.G.r();
            if (r16 != null) {
                accessibilityNodeInfoCompat.setLabelFor(r16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface e {
        void a(@NonNull TextInputLayout textInputLayout, int i3);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private boolean A() {
        if (this.f34376c0 && !TextUtils.isEmpty(this.f34379d0) && (this.f34385f0 instanceof com.google.android.material.textfield.c)) {
            return true;
        }
        return false;
    }

    private boolean A0() {
        if ((this.K0.getVisibility() == 0 || ((c0() && e0()) || this.f34372a0 != null)) && this.f34384f.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void B() {
        Iterator<d> it = this.f34407y0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private boolean B0() {
        if ((a0() != null || (Y() != null && Z().getVisibility() == 0)) && this.f34381e.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    private void C(int i3) {
        Iterator<e> it = this.C0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
    }

    private boolean C0() {
        EditText editText = this.f34389i;
        if (editText != null && this.f34385f0 != null && editText.getBackground() == null && this.f34393l0 != 0) {
            return true;
        }
        return false;
    }

    private void D(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.f34388h0 != null && (materialShapeDrawable = this.f34386g0) != null) {
            materialShapeDrawable.draw(canvas);
            if (this.f34389i.isFocused()) {
                Rect bounds = this.f34388h0.getBounds();
                Rect bounds2 = this.f34386g0.getBounds();
                float z16 = this.Z0.z();
                int centerX = bounds2.centerX();
                bounds.left = x0.a.c(centerX, bounds2.left, z16);
                bounds.right = x0.a.c(centerX, bounds2.right, z16);
                this.f34388h0.draw(canvas);
            }
        }
    }

    private void D0() {
        if (this.Q != null && this.P && !TextUtils.isEmpty(this.N)) {
            this.Q.setText(this.N);
            TransitionManager.beginDelayedTransition(this.f34378d, this.T);
            this.Q.setVisibility(0);
            this.Q.bringToFront();
            announceForAccessibility(this.N);
        }
    }

    private void E(@NonNull Canvas canvas) {
        if (this.f34376c0) {
            this.Z0.l(canvas);
        }
    }

    private void E0(boolean z16) {
        if (z16 && O() != null) {
            Drawable mutate = DrawableCompat.wrap(O()).mutate();
            DrawableCompat.setTint(mutate, this.G.o());
            this.B0.setImageDrawable(mutate);
            return;
        }
        com.google.android.material.textfield.e.a(this, this.B0, this.D0, this.E0);
    }

    private void F(boolean z16) {
        ValueAnimator valueAnimator = this.f34377c1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f34377c1.cancel();
        }
        if (z16 && this.f34375b1) {
            k(0.0f);
        } else {
            this.Z0.l0(0.0f);
        }
        if (A() && ((com.google.android.material.textfield.c) this.f34385f0).n0()) {
            x();
        }
        this.Y0 = true;
        d0();
        this.f34381e.h(true);
        Z0();
    }

    private void F0() {
        if (this.f34393l0 == 1) {
            if (g1.c.j(getContext())) {
                this.f34395m0 = getResources().getDimensionPixelSize(R.dimen.cpd);
            } else if (g1.c.i(getContext())) {
                this.f34395m0 = getResources().getDimensionPixelSize(R.dimen.cpc);
            }
        }
    }

    private void G0(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.f34386g0;
        if (materialShapeDrawable != null) {
            int i3 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i3 - this.f34397o0, rect.right, i3);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.f34388h0;
        if (materialShapeDrawable2 != null) {
            int i16 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i16 - this.f34398p0, rect.right, i16);
        }
    }

    private void H0() {
        int length;
        if (this.K != null) {
            EditText editText = this.f34389i;
            if (editText == null) {
                length = 0;
            } else {
                length = editText.getText().length();
            }
            I0(length);
        }
    }

    private static void J0(@NonNull Context context, @NonNull TextView textView, int i3, int i16, boolean z16) {
        int i17;
        if (z16) {
            i17 = R.string.ziz;
        } else {
            i17 = R.string.ziy;
        }
        textView.setContentDescription(context.getString(i17, Integer.valueOf(i3), Integer.valueOf(i16)));
    }

    private void K0() {
        int i3;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.K;
        if (textView != null) {
            if (this.J) {
                i3 = this.L;
            } else {
                i3 = this.M;
            }
            z0(textView, i3);
            if (!this.J && (colorStateList2 = this.V) != null) {
                this.K.setTextColor(colorStateList2);
            }
            if (this.J && (colorStateList = this.W) != null) {
                this.K.setTextColor(colorStateList);
            }
        }
    }

    private void L0() {
        if (this.f34408z0 == 3 && this.f34393l0 == 2) {
            ((DropdownMenuEndIconDelegate) this.A0.get(3)).J((AutoCompleteTextView) this.f34389i);
        }
    }

    private com.google.android.material.textfield.d N() {
        com.google.android.material.textfield.d dVar = this.A0.get(this.f34408z0);
        if (dVar == null) {
            return this.A0.get(0);
        }
        return dVar;
    }

    private boolean O0() {
        int max;
        if (this.f34389i == null || this.f34389i.getMeasuredHeight() >= (max = Math.max(this.f34384f.getMeasuredHeight(), this.f34381e.getMeasuredHeight()))) {
            return false;
        }
        this.f34389i.setMinimumHeight(max);
        return true;
    }

    @Nullable
    private CheckableImageButton P() {
        if (this.K0.getVisibility() == 0) {
            return this.K0;
        }
        if (c0() && e0()) {
            return this.B0;
        }
        return null;
    }

    private void P0() {
        int i3;
        boolean z16;
        boolean z17;
        FrameLayout frameLayout = this.f34387h;
        int i16 = 8;
        if (this.B0.getVisibility() == 0 && !f0()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
        if (this.f34372a0 != null && !h0()) {
            z16 = false;
        } else {
            z16 = 8;
        }
        if (!e0() && !f0() && z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        LinearLayout linearLayout = this.f34384f;
        if (z17) {
            i16 = 0;
        }
        linearLayout.setVisibility(i16);
    }

    private void Q0() {
        boolean z16;
        int i3 = 0;
        if (S() != null && this.G.x() && this.G.l()) {
            z16 = true;
        } else {
            z16 = false;
        }
        CheckableImageButton checkableImageButton = this.K0;
        if (!z16) {
            i3 = 8;
        }
        checkableImageButton.setVisibility(i3);
        P0();
        Y0();
        if (!c0()) {
            M0();
        }
    }

    private void R0() {
        if (this.f34393l0 != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f34378d.getLayoutParams();
            int u16 = u();
            if (u16 != layoutParams.topMargin) {
                layoutParams.topMargin = u16;
                this.f34378d.requestLayout();
            }
        }
    }

    private void T0(boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        ColorStateList colorStateList;
        TextView textView;
        int i3;
        boolean isEnabled = isEnabled();
        EditText editText = this.f34389i;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z18 = true;
        } else {
            z18 = false;
        }
        EditText editText2 = this.f34389i;
        if (editText2 != null && editText2.hasFocus()) {
            z19 = true;
        } else {
            z19 = false;
        }
        boolean l3 = this.G.l();
        ColorStateList colorStateList2 = this.N0;
        if (colorStateList2 != null) {
            this.Z0.W(colorStateList2);
            this.Z0.g0(this.N0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.N0;
            if (colorStateList3 != null) {
                i3 = colorStateList3.getColorForState(new int[]{-16842910}, this.X0);
            } else {
                i3 = this.X0;
            }
            this.Z0.W(ColorStateList.valueOf(i3));
            this.Z0.g0(ColorStateList.valueOf(i3));
        } else if (l3) {
            this.Z0.W(this.G.p());
        } else if (this.J && (textView = this.K) != null) {
            this.Z0.W(textView.getTextColors());
        } else if (z19 && (colorStateList = this.O0) != null) {
            this.Z0.W(colorStateList);
        }
        if (!z18 && this.f34373a1 && (!isEnabled() || !z19)) {
            if (z17 || !this.Y0) {
                F(z16);
                return;
            }
            return;
        }
        if (z17 || this.Y0) {
            y(z16);
        }
    }

    private void U0() {
        EditText editText;
        if (this.Q != null && (editText = this.f34389i) != null) {
            this.Q.setGravity(editText.getGravity());
            this.Q.setPadding(this.f34389i.getCompoundPaddingLeft(), this.f34389i.getCompoundPaddingTop(), this.f34389i.getCompoundPaddingRight(), this.f34389i.getCompoundPaddingBottom());
        }
    }

    private int V(int i3, boolean z16) {
        int compoundPaddingLeft = i3 + this.f34389i.getCompoundPaddingLeft();
        if (Y() != null && !z16) {
            return (compoundPaddingLeft - Z().getMeasuredWidth()) + Z().getPaddingLeft();
        }
        return compoundPaddingLeft;
    }

    private void V0() {
        int length;
        EditText editText = this.f34389i;
        if (editText == null) {
            length = 0;
        } else {
            length = editText.getText().length();
        }
        W0(length);
    }

    private int W(int i3, boolean z16) {
        int compoundPaddingRight = i3 - this.f34389i.getCompoundPaddingRight();
        if (Y() != null && z16) {
            return compoundPaddingRight + (Z().getMeasuredWidth() - Z().getPaddingRight());
        }
        return compoundPaddingRight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(int i3) {
        if (i3 == 0 && !this.Y0) {
            D0();
        } else {
            d0();
        }
    }

    private void X0(boolean z16, boolean z17) {
        int defaultColor = this.S0.getDefaultColor();
        int colorForState = this.S0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.S0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z16) {
            this.f34399q0 = colorForState2;
        } else if (z17) {
            this.f34399q0 = colorForState;
        } else {
            this.f34399q0 = defaultColor;
        }
    }

    private void Y0() {
        int i3;
        if (this.f34389i == null) {
            return;
        }
        if (!e0() && !f0()) {
            i3 = ViewCompat.getPaddingEnd(this.f34389i);
        } else {
            i3 = 0;
        }
        ViewCompat.setPaddingRelative(this.f34374b0, getContext().getResources().getDimensionPixelSize(R.dimen.cph), this.f34389i.getPaddingTop(), i3, this.f34389i.getPaddingBottom());
    }

    private void Z0() {
        int i3;
        int visibility = this.f34374b0.getVisibility();
        boolean z16 = false;
        if (this.f34372a0 != null && !h0()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (visibility != i3) {
            com.google.android.material.textfield.d N = N();
            if (i3 == 0) {
                z16 = true;
            }
            N.c(z16);
        }
        P0();
        this.f34374b0.setVisibility(i3);
        M0();
    }

    private boolean c0() {
        if (this.f34408z0 != 0) {
            return true;
        }
        return false;
    }

    private void d0() {
        TextView textView = this.Q;
        if (textView != null && this.P) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.f34378d, this.U);
            this.Q.setVisibility(4);
        }
    }

    private boolean f0() {
        if (this.K0.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private void i() {
        TextView textView = this.Q;
        if (textView != null) {
            this.f34378d.addView(textView);
            this.Q.setVisibility(0);
        }
    }

    private void j() {
        if (this.f34389i != null && this.f34393l0 == 1) {
            if (g1.c.j(getContext())) {
                EditText editText = this.f34389i;
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R.dimen.cpb), ViewCompat.getPaddingEnd(this.f34389i), getResources().getDimensionPixelSize(R.dimen.cpa));
            } else if (g1.c.i(getContext())) {
                EditText editText2 = this.f34389i;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.cp_), ViewCompat.getPaddingEnd(this.f34389i), getResources().getDimensionPixelSize(R.dimen.cp9));
            }
        }
    }

    private boolean j0() {
        if (this.f34393l0 == 1 && this.f34389i.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    private void k0() {
        o();
        t0();
        a1();
        F0();
        j();
        if (this.f34393l0 != 0) {
            R0();
        }
    }

    private void l() {
        MaterialShapeDrawable materialShapeDrawable = this.f34385f0;
        if (materialShapeDrawable == null) {
            return;
        }
        com.google.android.material.shape.g E = materialShapeDrawable.E();
        com.google.android.material.shape.g gVar = this.f34390i0;
        if (E != gVar) {
            this.f34385f0.setShapeAppearanceModel(gVar);
            L0();
        }
        if (v()) {
            this.f34385f0.g0(this.f34396n0, this.f34399q0);
        }
        int p16 = p();
        this.f34400r0 = p16;
        this.f34385f0.Y(ColorStateList.valueOf(p16));
        if (this.f34408z0 == 3) {
            this.f34389i.getBackground().invalidateSelf();
        }
        m();
        invalidate();
    }

    private void l0() {
        if (!A()) {
            return;
        }
        RectF rectF = this.f34403u0;
        this.Z0.o(rectF, this.f34389i.getWidth(), this.f34389i.getGravity());
        n(rectF);
        rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f34396n0);
        ((com.google.android.material.textfield.c) this.f34385f0).q0(rectF);
    }

    private void m() {
        ColorStateList valueOf;
        if (this.f34386g0 != null && this.f34388h0 != null) {
            if (w()) {
                MaterialShapeDrawable materialShapeDrawable = this.f34386g0;
                if (this.f34389i.isFocused()) {
                    valueOf = ColorStateList.valueOf(this.P0);
                } else {
                    valueOf = ColorStateList.valueOf(this.f34399q0);
                }
                materialShapeDrawable.Y(valueOf);
                this.f34388h0.Y(ColorStateList.valueOf(this.f34399q0));
            }
            invalidate();
        }
    }

    private void m0() {
        if (A() && !this.Y0) {
            x();
            l0();
        }
    }

    private void n(@NonNull RectF rectF) {
        float f16 = rectF.left;
        int i3 = this.f34392k0;
        rectF.left = f16 - i3;
        rectF.right += i3;
    }

    private static void n0(@NonNull ViewGroup viewGroup, boolean z16) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z16);
            if (childAt instanceof ViewGroup) {
                n0((ViewGroup) childAt, z16);
            }
        }
    }

    private void o() {
        int i3 = this.f34393l0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    if (this.f34376c0 && !(this.f34385f0 instanceof com.google.android.material.textfield.c)) {
                        this.f34385f0 = new com.google.android.material.textfield.c(this.f34390i0);
                    } else {
                        this.f34385f0 = new MaterialShapeDrawable(this.f34390i0);
                    }
                    this.f34386g0 = null;
                    this.f34388h0 = null;
                    return;
                }
                throw new IllegalArgumentException(this.f34393l0 + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.f34385f0 = new MaterialShapeDrawable(this.f34390i0);
            this.f34386g0 = new MaterialShapeDrawable();
            this.f34388h0 = new MaterialShapeDrawable();
            return;
        }
        this.f34385f0 = null;
        this.f34386g0 = null;
        this.f34388h0 = null;
    }

    private int p() {
        int i3 = this.f34400r0;
        if (this.f34393l0 == 1) {
            return z0.a.g(z0.a.e(this, R.attr.a8g, 0), this.f34400r0);
        }
        return i3;
    }

    @NonNull
    private Rect q(@NonNull Rect rect) {
        if (this.f34389i != null) {
            Rect rect2 = this.f34402t0;
            boolean i3 = ViewUtils.i(this);
            rect2.bottom = rect.bottom;
            int i16 = this.f34393l0;
            if (i16 != 1) {
                if (i16 != 2) {
                    rect2.left = V(rect.left, i3);
                    rect2.top = getPaddingTop();
                    rect2.right = W(rect.right, i3);
                    return rect2;
                }
                rect2.left = rect.left + this.f34389i.getPaddingLeft();
                rect2.top = rect.top - u();
                rect2.right = rect.right - this.f34389i.getPaddingRight();
                return rect2;
            }
            rect2.left = V(rect.left, i3);
            rect2.top = rect.top + this.f34395m0;
            rect2.right = W(rect.right, i3);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int r(@NonNull Rect rect, @NonNull Rect rect2, float f16) {
        if (j0()) {
            return (int) (rect2.top + f16);
        }
        return rect.bottom - this.f34389i.getCompoundPaddingBottom();
    }

    private void r0() {
        TextView textView = this.Q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private int s(@NonNull Rect rect, float f16) {
        if (j0()) {
            return (int) (rect.centerY() - (f16 / 2.0f));
        }
        return rect.top + this.f34389i.getCompoundPaddingTop();
    }

    private void s0(EditText editText) {
        if (this.f34389i == null) {
            if (this.f34408z0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f34389i = editText;
            int i3 = this.C;
            if (i3 != -1) {
                setMinEms(i3);
            } else {
                setMinWidth(this.E);
            }
            int i16 = this.D;
            if (i16 != -1) {
                setMaxEms(i16);
            } else {
                setMaxWidth(this.F);
            }
            k0();
            setTextInputAccessibilityDelegate(new c(this));
            this.Z0.y0(this.f34389i.getTypeface());
            this.Z0.i0(this.f34389i.getTextSize());
            this.Z0.d0(this.f34389i.getLetterSpacing());
            int gravity = this.f34389i.getGravity();
            this.Z0.X((gravity & (-113)) | 48);
            this.Z0.h0(gravity);
            this.f34389i.addTextChangedListener(new a());
            if (this.N0 == null) {
                this.N0 = this.f34389i.getHintTextColors();
            }
            if (this.f34376c0) {
                if (TextUtils.isEmpty(this.f34379d0)) {
                    CharSequence hint = this.f34389i.getHint();
                    this.f34394m = hint;
                    setHint(hint);
                    this.f34389i.setHint((CharSequence) null);
                }
                this.f34382e0 = true;
            }
            if (this.K != null) {
                I0(this.f34389i.getText().length());
            }
            N0();
            this.G.f();
            this.f34381e.bringToFront();
            this.f34384f.bringToFront();
            this.f34387h.bringToFront();
            this.K0.bringToFront();
            B();
            Y0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            T0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    @NonNull
    private Rect t(@NonNull Rect rect) {
        if (this.f34389i != null) {
            Rect rect2 = this.f34402t0;
            float y16 = this.Z0.y();
            rect2.left = rect.left + this.f34389i.getCompoundPaddingLeft();
            rect2.top = s(rect, y16);
            rect2.right = rect.right - this.f34389i.getCompoundPaddingRight();
            rect2.bottom = r(rect, rect2, y16);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private void t0() {
        if (C0()) {
            ViewCompat.setBackground(this.f34389i, this.f34385f0);
        }
    }

    private int u() {
        float q16;
        if (!this.f34376c0) {
            return 0;
        }
        int i3 = this.f34393l0;
        if (i3 != 0) {
            if (i3 != 2) {
                return 0;
            }
            q16 = this.Z0.q() / 2.0f;
        } else {
            q16 = this.Z0.q();
        }
        return (int) q16;
    }

    private void u0(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f34379d0)) {
            this.f34379d0 = charSequence;
            this.Z0.w0(charSequence);
            if (!this.Y0) {
                l0();
            }
        }
    }

    private boolean v() {
        if (this.f34393l0 == 2 && w()) {
            return true;
        }
        return false;
    }

    private static void v0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean z16;
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z17 = false;
        int i3 = 1;
        if (onLongClickListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (hasOnClickListeners || z16) {
            z17 = true;
        }
        checkableImageButton.setFocusable(z17);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z16);
        if (!z17) {
            i3 = 2;
        }
        ViewCompat.setImportantForAccessibility(checkableImageButton, i3);
    }

    private boolean w() {
        if (this.f34396n0 > -1 && this.f34399q0 != 0) {
            return true;
        }
        return false;
    }

    private static void w0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        v0(checkableImageButton, onLongClickListener);
    }

    private void x() {
        if (A()) {
            ((com.google.android.material.textfield.c) this.f34385f0).o0();
        }
    }

    private static void x0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v0(checkableImageButton, onLongClickListener);
    }

    private void y(boolean z16) {
        ValueAnimator valueAnimator = this.f34377c1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f34377c1.cancel();
        }
        if (z16 && this.f34375b1) {
            k(1.0f);
        } else {
            this.Z0.l0(1.0f);
        }
        this.Y0 = false;
        if (A()) {
            l0();
        }
        V0();
        this.f34381e.h(false);
        Z0();
    }

    private void y0(boolean z16) {
        if (this.P == z16) {
            return;
        }
        if (z16) {
            i();
        } else {
            r0();
            this.Q = null;
        }
        this.P = z16;
    }

    private Fade z() {
        Fade fade = new Fade();
        fade.setDuration(87L);
        fade.setInterpolator(x0.a.f446810a);
        return fade;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable G() {
        int i3 = this.f34393l0;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalStateException();
        }
        return this.f34385f0;
    }

    public int H() {
        return this.f34400r0;
    }

    public int I() {
        return this.f34393l0;
    }

    void I0(int i3) {
        boolean z16;
        boolean z17 = this.J;
        int i16 = this.I;
        if (i16 == -1) {
            this.K.setText(String.valueOf(i3));
            this.K.setContentDescription(null);
            this.J = false;
        } else {
            if (i3 > i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.J = z16;
            J0(getContext(), this.K, i3, this.I, this.J);
            if (z17 != this.J) {
                K0();
            }
            this.K.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.f170717zj0, Integer.valueOf(i3), Integer.valueOf(this.I))));
        }
        if (this.f34389i != null && z17 != this.J) {
            S0(false);
            a1();
            N0();
        }
    }

    public int J() {
        return this.I;
    }

    @Nullable
    CharSequence K() {
        TextView textView;
        if (this.H && this.J && (textView = this.K) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public EditText L() {
        return this.f34389i;
    }

    @Nullable
    public CharSequence M() {
        return this.B0.getContentDescription();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M0() {
        boolean z16;
        if (this.f34389i == null) {
            return false;
        }
        boolean z17 = true;
        if (B0()) {
            int measuredWidth = this.f34381e.getMeasuredWidth() - this.f34389i.getPaddingLeft();
            if (this.f34405w0 == null || this.f34406x0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f34405w0 = colorDrawable;
                this.f34406x0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f34389i);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f34405w0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f34389i, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z16 = true;
            }
            z16 = false;
        } else {
            if (this.f34405w0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f34389i);
                TextViewCompat.setCompoundDrawablesRelative(this.f34389i, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f34405w0 = null;
                z16 = true;
            }
            z16 = false;
        }
        if (A0()) {
            int measuredWidth2 = this.f34374b0.getMeasuredWidth() - this.f34389i.getPaddingRight();
            CheckableImageButton P = P();
            if (P != null) {
                measuredWidth2 = measuredWidth2 + P.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) P.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f34389i);
            Drawable drawable3 = this.F0;
            if (drawable3 != null && this.G0 != measuredWidth2) {
                this.G0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f34389i, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.F0, compoundDrawablesRelative3[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.F0 = colorDrawable2;
                    this.G0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.F0;
                if (drawable4 != drawable5) {
                    this.H0 = drawable4;
                    TextViewCompat.setCompoundDrawablesRelative(this.f34389i, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z17 = z16;
                }
            }
        } else if (this.F0 != null) {
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f34389i);
            if (compoundDrawablesRelative4[2] == this.F0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f34389i, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.H0, compoundDrawablesRelative4[3]);
            } else {
                z17 = z16;
            }
            this.F0 = null;
        } else {
            return z16;
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f34389i;
        if (editText == null || this.f34393l0 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.G.l()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.G.o(), PorterDuff.Mode.SRC_IN));
        } else if (this.J && (textView = this.K) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f34389i.refreshDrawableState();
        }
    }

    @Nullable
    public Drawable O() {
        return this.B0.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton Q() {
        return this.B0;
    }

    @Nullable
    public CharSequence R() {
        if (this.G.x()) {
            return this.G.n();
        }
        return null;
    }

    @Nullable
    public Drawable S() {
        return this.K0.getDrawable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S0(boolean z16) {
        T0(z16, false);
    }

    @Nullable
    public CharSequence T() {
        if (this.G.y()) {
            return this.G.q();
        }
        return null;
    }

    @Nullable
    public CharSequence U() {
        if (this.f34376c0) {
            return this.f34379d0;
        }
        return null;
    }

    @Nullable
    public CharSequence X() {
        if (this.P) {
            return this.N;
        }
        return null;
    }

    @Nullable
    public CharSequence Y() {
        return this.f34381e.a();
    }

    @NonNull
    public TextView Z() {
        return this.f34381e.b();
    }

    @Nullable
    public Drawable a0() {
        return this.f34381e.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1() {
        boolean z16;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f34385f0 != null && this.f34393l0 != 0) {
            boolean z17 = false;
            if (!isFocused() && ((editText2 = this.f34389i) == null || !editText2.hasFocus())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (isHovered() || ((editText = this.f34389i) != null && editText.isHovered())) {
                z17 = true;
            }
            if (!isEnabled()) {
                this.f34399q0 = this.X0;
            } else if (this.G.l()) {
                if (this.S0 != null) {
                    X0(z16, z17);
                } else {
                    this.f34399q0 = this.G.o();
                }
            } else if (this.J && (textView = this.K) != null) {
                if (this.S0 != null) {
                    X0(z16, z17);
                } else {
                    this.f34399q0 = textView.getCurrentTextColor();
                }
            } else if (z16) {
                this.f34399q0 = this.R0;
            } else if (z17) {
                this.f34399q0 = this.Q0;
            } else {
                this.f34399q0 = this.P0;
            }
            Q0();
            p0();
            q0();
            o0();
            if (N().d()) {
                E0(this.G.l());
            }
            if (this.f34393l0 == 2) {
                int i3 = this.f34396n0;
                if (z16 && isEnabled()) {
                    this.f34396n0 = this.f34398p0;
                } else {
                    this.f34396n0 = this.f34397o0;
                }
                if (this.f34396n0 != i3) {
                    m0();
                }
            }
            if (this.f34393l0 == 1) {
                if (!isEnabled()) {
                    this.f34400r0 = this.U0;
                } else if (z17 && !z16) {
                    this.f34400r0 = this.W0;
                } else if (z16) {
                    this.f34400r0 = this.V0;
                } else {
                    this.f34400r0 = this.T0;
                }
            }
            l();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i3, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f34378d.addView(view, layoutParams2);
            this.f34378d.setLayoutParams(layoutParams);
            R0();
            s0((EditText) view);
            return;
        }
        super.addView(view, i3, layoutParams);
    }

    @Nullable
    public CharSequence b0() {
        return this.f34372a0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i3) {
        EditText editText = this.f34389i;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f34394m == null) {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i3);
            onProvideAutofillVirtualStructure(viewStructure, i3);
            viewStructure.setChildCount(this.f34378d.getChildCount());
            for (int i16 = 0; i16 < this.f34378d.getChildCount(); i16++) {
                View childAt = this.f34378d.getChildAt(i16);
                ViewStructure newChild = viewStructure.newChild(i16);
                childAt.dispatchProvideAutofillStructure(newChild, i3);
                if (childAt == this.f34389i) {
                    newChild.setHint(U());
                }
            }
            return;
        }
        boolean z16 = this.f34382e0;
        this.f34382e0 = false;
        CharSequence hint = editText.getHint();
        this.f34389i.setHint(this.f34394m);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
        } finally {
            this.f34389i.setHint(hint);
            this.f34382e0 = z16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.f34383e1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f34383e1 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z16;
        if (this.f34380d1) {
            return;
        }
        boolean z17 = true;
        this.f34380d1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.b bVar = this.Z0;
        if (bVar != null) {
            z16 = bVar.v0(drawableState) | false;
        } else {
            z16 = false;
        }
        if (this.f34389i != null) {
            if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                z17 = false;
            }
            S0(z17);
        }
        N0();
        a1();
        if (z16) {
            invalidate();
        }
        this.f34380d1 = false;
    }

    public boolean e0() {
        if (this.f34387h.getVisibility() == 0 && this.B0.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void g(@NonNull d dVar) {
        this.f34407y0.add(dVar);
        if (this.f34389i != null) {
            dVar.a(this);
        }
    }

    public boolean g0() {
        return this.G.y();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f34389i;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + u();
        }
        return super.getBaseline();
    }

    public void h(@NonNull e eVar) {
        this.C0.add(eVar);
    }

    final boolean h0() {
        return this.Y0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean i0() {
        return this.f34382e0;
    }

    @VisibleForTesting
    void k(float f16) {
        if (this.Z0.z() == f16) {
            return;
        }
        if (this.f34377c1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f34377c1 = valueAnimator;
            valueAnimator.setInterpolator(x0.a.f446811b);
            this.f34377c1.setDuration(167L);
            this.f34377c1.addUpdateListener(new b());
        }
        this.f34377c1.setFloatValues(this.Z0.z(), f16);
        this.f34377c1.start();
    }

    public void o0() {
        com.google.android.material.textfield.e.c(this, this.B0, this.D0);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.Z0.M(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        EditText editText = this.f34389i;
        if (editText != null) {
            Rect rect = this.f34401s0;
            com.google.android.material.internal.d.a(this, editText, rect);
            G0(rect);
            if (this.f34376c0) {
                this.Z0.i0(this.f34389i.getTextSize());
                int gravity = this.f34389i.getGravity();
                this.Z0.X((gravity & (-113)) | 48);
                this.Z0.h0(gravity);
                this.Z0.T(q(rect));
                this.Z0.c0(t(rect));
                this.Z0.P();
                if (A() && !this.Y0) {
                    l0();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        boolean O0 = O0();
        boolean M0 = M0();
        if (O0 || M0) {
            this.f34389i.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f34389i.requestLayout();
                }
            });
        }
        U0();
        Y0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f34409d);
        if (savedState.f34410e) {
            this.B0.post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.B0.performClick();
                    TextInputLayout.this.B0.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.f34411f);
        setHelperText(savedState.f34412h);
        setPlaceholderText(savedState.f34413i);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        boolean z16;
        float f16;
        float f17;
        super.onRtlPropertiesChanged(i3);
        boolean z17 = false;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = this.f34391j0;
        if (z16 != z18) {
            if (z16 && !z18) {
                z17 = true;
            }
            float a16 = this.f34390i0.r().a(this.f34403u0);
            float a17 = this.f34390i0.t().a(this.f34403u0);
            float a18 = this.f34390i0.j().a(this.f34403u0);
            float a19 = this.f34390i0.l().a(this.f34403u0);
            if (z17) {
                f16 = a16;
            } else {
                f16 = a17;
            }
            if (z17) {
                a16 = a17;
            }
            if (z17) {
                f17 = a18;
            } else {
                f17 = a19;
            }
            if (z17) {
                a18 = a19;
            }
            setBoxCornerRadii(f16, a16, f17, a18);
        }
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        boolean z16;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.G.l()) {
            savedState.f34409d = R();
        }
        if (c0() && this.B0.isChecked()) {
            z16 = true;
        } else {
            z16 = false;
        }
        savedState.f34410e = z16;
        savedState.f34411f = U();
        savedState.f34412h = T();
        savedState.f34413i = X();
        return savedState;
    }

    public void p0() {
        com.google.android.material.textfield.e.c(this, this.K0, this.L0);
    }

    public void q0() {
        this.f34381e.i();
    }

    public void setBoxBackgroundColor(@ColorInt int i3) {
        if (this.f34400r0 != i3) {
            this.f34400r0 = i3;
            this.T0 = i3;
            this.V0 = i3;
            this.W0 = i3;
            l();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i3) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.T0 = defaultColor;
        this.f34400r0 = defaultColor;
        this.U0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.V0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.W0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        l();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.f34393l0) {
            return;
        }
        this.f34393l0 = i3;
        if (this.f34389i != null) {
            k0();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.f34395m0 = i3;
    }

    public void setBoxCornerRadii(float f16, float f17, float f18, float f19) {
        float f26;
        float f27;
        boolean i3 = ViewUtils.i(this);
        this.f34391j0 = i3;
        if (i3) {
            f26 = f17;
        } else {
            f26 = f16;
        }
        if (!i3) {
            f16 = f17;
        }
        if (i3) {
            f27 = f19;
        } else {
            f27 = f18;
        }
        if (!i3) {
            f18 = f19;
        }
        MaterialShapeDrawable materialShapeDrawable = this.f34385f0;
        if (materialShapeDrawable == null || materialShapeDrawable.G() != f26 || this.f34385f0.H() != f16 || this.f34385f0.s() != f27 || this.f34385f0.t() != f18) {
            this.f34390i0 = this.f34390i0.v().E(f26).I(f16).v(f27).z(f18).m();
            l();
        }
    }

    public void setBoxCornerRadiiResources(@DimenRes int i3, @DimenRes int i16, @DimenRes int i17, @DimenRes int i18) {
        setBoxCornerRadii(getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i16), getContext().getResources().getDimension(i18), getContext().getResources().getDimension(i17));
    }

    public void setBoxStrokeColor(@ColorInt int i3) {
        if (this.R0 != i3) {
            this.R0 = i3;
            a1();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.P0 = colorStateList.getDefaultColor();
            this.X0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.Q0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.R0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.R0 != colorStateList.getDefaultColor()) {
            this.R0 = colorStateList.getDefaultColor();
        }
        a1();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.S0 != colorStateList) {
            this.S0 = colorStateList;
            a1();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.f34397o0 = i3;
        a1();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.f34398p0 = i3;
        a1();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z16) {
        if (this.H != z16) {
            if (z16) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.K = appCompatTextView;
                appCompatTextView.setId(R.id.f95945gc);
                Typeface typeface = this.f34404v0;
                if (typeface != null) {
                    this.K.setTypeface(typeface);
                }
                this.K.setMaxLines(1);
                this.G.e(this.K, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.K.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.f159187cw3));
                K0();
                H0();
            } else {
                this.G.z(this.K, 2);
                this.K = null;
            }
            this.H = z16;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.I != i3) {
            if (i3 > 0) {
                this.I = i3;
            } else {
                this.I = -1;
            }
            if (this.H) {
                H0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.L != i3) {
            this.L = i3;
            K0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            K0();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.M != i3) {
            this.M = i3;
            K0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            K0();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.N0 = colorStateList;
        this.O0 = colorStateList;
        if (this.f34389i != null) {
            S0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        n0(this, z16);
        super.setEnabled(z16);
    }

    public void setEndIconActivated(boolean z16) {
        this.B0.setActivated(z16);
    }

    public void setEndIconCheckable(boolean z16) {
        this.B0.setCheckable(z16);
    }

    public void setEndIconContentDescription(@StringRes int i3) {
        setEndIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i3) {
        setEndIconDrawable(i3 != 0 ? AppCompatResources.getDrawable(getContext(), i3) : null);
    }

    public void setEndIconMode(int i3) {
        boolean z16;
        int i16 = this.f34408z0;
        if (i16 == i3) {
            return;
        }
        this.f34408z0 = i3;
        C(i16);
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setEndIconVisible(z16);
        if (N().b(this.f34393l0)) {
            N().a();
            com.google.android.material.textfield.e.a(this, this.B0, this.D0, this.E0);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f34393l0 + " is not supported by the end icon mode " + i3);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        w0(this.B0, onClickListener, this.I0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.I0 = onLongClickListener;
        x0(this.B0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            com.google.android.material.textfield.e.a(this, this.B0, colorStateList, this.E0);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.E0 != mode) {
            this.E0 = mode;
            com.google.android.material.textfield.e.a(this, this.B0, this.D0, mode);
        }
    }

    public void setEndIconVisible(boolean z16) {
        int i3;
        if (e0() != z16) {
            CheckableImageButton checkableImageButton = this.B0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            checkableImageButton.setVisibility(i3);
            P0();
            Y0();
            M0();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.G.x()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.G.M(charSequence);
        } else {
            this.G.t();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.G.B(charSequence);
    }

    public void setErrorEnabled(boolean z16) {
        this.G.C(z16);
    }

    public void setErrorIconDrawable(@DrawableRes int i3) {
        setErrorIconDrawable(i3 != 0 ? AppCompatResources.getDrawable(getContext(), i3) : null);
        p0();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        w0(this.K0, onClickListener, this.J0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.J0 = onLongClickListener;
        x0(this.K0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.L0 != colorStateList) {
            this.L0 = colorStateList;
            com.google.android.material.textfield.e.a(this, this.K0, colorStateList, this.M0);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.M0 != mode) {
            this.M0 = mode;
            com.google.android.material.textfield.e.a(this, this.K0, this.L0, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i3) {
        this.G.D(i3);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.G.E(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z16) {
        if (this.f34373a1 != z16) {
            this.f34373a1 = z16;
            S0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (g0()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!g0()) {
                setHelperTextEnabled(true);
            }
            this.G.N(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.G.H(colorStateList);
    }

    public void setHelperTextEnabled(boolean z16) {
        this.G.G(z16);
    }

    public void setHelperTextTextAppearance(@StyleRes int i3) {
        this.G.F(i3);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.f34376c0) {
            u0(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z16) {
        this.f34375b1 = z16;
    }

    public void setHintEnabled(boolean z16) {
        if (z16 != this.f34376c0) {
            this.f34376c0 = z16;
            if (!z16) {
                this.f34382e0 = false;
                if (!TextUtils.isEmpty(this.f34379d0) && TextUtils.isEmpty(this.f34389i.getHint())) {
                    this.f34389i.setHint(this.f34379d0);
                }
                u0(null);
            } else {
                CharSequence hint = this.f34389i.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f34379d0)) {
                        setHint(hint);
                    }
                    this.f34389i.setHint((CharSequence) null);
                }
                this.f34382e0 = true;
            }
            if (this.f34389i != null) {
                R0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i3) {
        this.Z0.U(i3);
        this.O0 = this.Z0.p();
        if (this.f34389i != null) {
            S0(false);
            R0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.O0 != colorStateList) {
            if (this.N0 == null) {
                this.Z0.W(colorStateList);
            }
            this.O0 = colorStateList;
            if (this.f34389i != null) {
                S0(false);
            }
        }
    }

    public void setMaxEms(int i3) {
        this.D = i3;
        EditText editText = this.f34389i;
        if (editText != null && i3 != -1) {
            editText.setMaxEms(i3);
        }
    }

    public void setMaxWidth(@Px int i3) {
        this.F = i3;
        EditText editText = this.f34389i;
        if (editText != null && i3 != -1) {
            editText.setMaxWidth(i3);
        }
    }

    public void setMaxWidthResource(@DimenRes int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.C = i3;
        EditText editText = this.f34389i;
        if (editText != null && i3 != -1) {
            editText.setMinEms(i3);
        }
    }

    public void setMinWidth(@Px int i3) {
        this.E = i3;
        EditText editText = this.f34389i;
        if (editText != null && i3 != -1) {
            editText.setMinWidth(i3);
        }
    }

    public void setMinWidthResource(@DimenRes int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i3) {
        setPasswordVisibilityToggleContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i3) {
        setPasswordVisibilityToggleDrawable(i3 != 0 ? AppCompatResources.getDrawable(getContext(), i3) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z16) {
        if (z16 && this.f34408z0 != 1) {
            setEndIconMode(1);
        } else if (!z16) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.D0 = colorStateList;
        com.google.android.material.textfield.e.a(this, this.B0, colorStateList, this.E0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.E0 = mode;
        com.google.android.material.textfield.e.a(this, this.B0, this.D0, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.Q == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.Q = appCompatTextView;
            appCompatTextView.setId(R.id.f95975gf);
            ViewCompat.setImportantForAccessibility(this.Q, 2);
            Fade z16 = z();
            this.T = z16;
            z16.setStartDelay(67L);
            this.U = z();
            setPlaceholderTextAppearance(this.S);
            setPlaceholderTextColor(this.R);
        }
        if (TextUtils.isEmpty(charSequence)) {
            y0(false);
        } else {
            if (!this.P) {
                y0(true);
            }
            this.N = charSequence;
        }
        V0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i3) {
        this.S = i3;
        TextView textView = this.Q;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i3);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.R != colorStateList) {
            this.R = colorStateList;
            TextView textView = this.Q;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.f34381e.j(charSequence);
    }

    public void setPrefixTextAppearance(@StyleRes int i3) {
        this.f34381e.k(i3);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f34381e.l(colorStateList);
    }

    public void setStartIconCheckable(boolean z16) {
        this.f34381e.m(z16);
    }

    public void setStartIconContentDescription(@StringRes int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i3) {
        setStartIconDrawable(i3 != 0 ? AppCompatResources.getDrawable(getContext(), i3) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f34381e.p(onClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f34381e.q(onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        this.f34381e.r(colorStateList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        this.f34381e.s(mode);
    }

    public void setStartIconVisible(boolean z16) {
        this.f34381e.t(z16);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f34372a0 = charSequence2;
        this.f34374b0.setText(charSequence);
        Z0();
    }

    public void setSuffixTextAppearance(@StyleRes int i3) {
        TextViewCompat.setTextAppearance(this.f34374b0, i3);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f34374b0.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable c cVar) {
        EditText editText = this.f34389i;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, cVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f34404v0) {
            this.f34404v0 = typeface;
            this.Z0.y0(typeface);
            this.G.J(typeface);
            TextView textView = this.K;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z0(@NonNull TextView textView, @StyleRes int i3) {
        boolean z16 = true;
        try {
            TextViewCompat.setTextAppearance(textView, i3);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z16 = false;
            }
        } catch (Exception unused) {
        }
        if (z16) {
            TextViewCompat.setTextAppearance(textView, R.style.a_b);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.bhj));
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bg5);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (M() != charSequence) {
            this.B0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.B0.setImageDrawable(drawable);
        if (drawable != null) {
            com.google.android.material.textfield.e.a(this, this.B0, this.D0, this.E0);
            o0();
        }
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        this.f34381e.n(charSequence);
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f34381e.o(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v109 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r9), attributeSet, i3);
        int i16;
        ?? r36;
        boolean z16;
        int i17;
        int i18 = f34371f1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
        this.G = new f(this);
        this.f34401s0 = new Rect();
        this.f34402t0 = new Rect();
        this.f34403u0 = new RectF();
        this.f34407y0 = new LinkedHashSet<>();
        this.f34408z0 = 0;
        SparseArray<com.google.android.material.textfield.d> sparseArray = new SparseArray<>();
        this.A0 = sparseArray;
        this.C0 = new LinkedHashSet<>();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.Z0 = bVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f34378d = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f34387h = frameLayout2;
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f34384f = linearLayout;
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.f34374b0 = appCompatTextView;
        linearLayout.setVisibility(8);
        frameLayout2.setVisibility(8);
        appCompatTextView.setVisibility(8);
        LayoutInflater from = LayoutInflater.from(context2);
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(R.layout.e5v, (ViewGroup) linearLayout, false);
        this.K0 = checkableImageButton;
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) from.inflate(R.layout.e5v, (ViewGroup) frameLayout2, false);
        this.B0 = checkableImageButton2;
        frameLayout.setAddStatesFromChildren(true);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = x0.a.f446810a;
        bVar.x0(timeInterpolator);
        bVar.t0(timeInterpolator);
        bVar.X(8388659);
        int[] iArr = w0.a.f443980o9;
        int i19 = w0.a.L9;
        int i26 = w0.a.J9;
        int i27 = w0.a.Y9;
        int i28 = w0.a.f443855da;
        int i29 = w0.a.f443903ha;
        TintTypedArray i36 = o.i(context2, attributeSet, iArr, i3, i18, i19, i26, i27, i28, i29);
        h hVar = new h(this, i36);
        this.f34381e = hVar;
        this.f34376c0 = i36.getBoolean(w0.a.f443891ga, true);
        setHint(i36.getText(w0.a.f444040t9));
        this.f34375b1 = i36.getBoolean(w0.a.f443879fa, true);
        this.f34373a1 = i36.getBoolean(w0.a.f443819aa, true);
        int i37 = w0.a.f444063v9;
        if (i36.hasValue(i37)) {
            i16 = -1;
            setMinEms(i36.getInt(i37, -1));
        } else {
            i16 = -1;
            int i38 = w0.a.f444028s9;
            if (i36.hasValue(i38)) {
                setMinWidth(i36.getDimensionPixelSize(i38, -1));
            }
        }
        int i39 = w0.a.f444052u9;
        if (i36.hasValue(i39)) {
            setMaxEms(i36.getInt(i39, i16));
        } else {
            int i46 = w0.a.f444016r9;
            if (i36.hasValue(i46)) {
                setMaxWidth(i36.getDimensionPixelSize(i46, i16));
            }
        }
        this.f34390i0 = com.google.android.material.shape.g.e(context2, attributeSet, i3, i18).m();
        this.f34392k0 = context2.getResources().getDimensionPixelOffset(R.dimen.f159184cw0);
        this.f34395m0 = i36.getDimensionPixelOffset(w0.a.f444098y9, 0);
        this.f34397o0 = i36.getDimensionPixelSize(w0.a.F9, context2.getResources().getDimensionPixelSize(R.dimen.f159185cw1));
        this.f34398p0 = i36.getDimensionPixelSize(w0.a.G9, context2.getResources().getDimensionPixelSize(R.dimen.f159186cw2));
        this.f34396n0 = this.f34397o0;
        float dimension = i36.getDimension(w0.a.C9, -1.0f);
        float dimension2 = i36.getDimension(w0.a.B9, -1.0f);
        float dimension3 = i36.getDimension(w0.a.f444110z9, -1.0f);
        float dimension4 = i36.getDimension(w0.a.A9, -1.0f);
        g.b v3 = this.f34390i0.v();
        if (dimension >= 0.0f) {
            v3.E(dimension);
        }
        if (dimension2 >= 0.0f) {
            v3.I(dimension2);
        }
        if (dimension3 >= 0.0f) {
            v3.z(dimension3);
        }
        if (dimension4 >= 0.0f) {
            v3.v(dimension4);
        }
        this.f34390i0 = v3.m();
        ColorStateList b16 = g1.c.b(context2, i36, w0.a.f444074w9);
        if (b16 != null) {
            int defaultColor = b16.getDefaultColor();
            this.T0 = defaultColor;
            this.f34400r0 = defaultColor;
            if (b16.isStateful()) {
                this.U0 = b16.getColorForState(new int[]{-16842910}, -1);
                this.V0 = b16.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.W0 = b16.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.V0 = this.T0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, R.color.c65);
                this.U0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.W0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.f34400r0 = 0;
            this.T0 = 0;
            this.U0 = 0;
            this.V0 = 0;
            this.W0 = 0;
        }
        int i47 = w0.a.f444004q9;
        if (i36.hasValue(i47)) {
            ColorStateList colorStateList2 = i36.getColorStateList(i47);
            this.O0 = colorStateList2;
            this.N0 = colorStateList2;
        }
        int i48 = w0.a.D9;
        ColorStateList b17 = g1.c.b(context2, i36, i48);
        this.R0 = i36.getColor(i48, 0);
        this.P0 = ContextCompat.getColor(context2, R.color.c6r);
        this.X0 = ContextCompat.getColor(context2, R.color.c6s);
        this.Q0 = ContextCompat.getColor(context2, R.color.c6v);
        if (b17 != null) {
            setBoxStrokeColorStateList(b17);
        }
        int i49 = w0.a.E9;
        if (i36.hasValue(i49)) {
            setBoxStrokeErrorColor(g1.c.b(context2, i36, i49));
        }
        if (i36.getResourceId(i29, -1) != -1) {
            r36 = 0;
            setHintTextAppearance(i36.getResourceId(i29, 0));
        } else {
            r36 = 0;
        }
        int resourceId = i36.getResourceId(i27, r36);
        CharSequence text = i36.getText(w0.a.T9);
        boolean z17 = i36.getBoolean(w0.a.U9, r36);
        checkableImageButton.setId(R.id.f95445f0);
        if (g1.c.i(context2)) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), r36);
        }
        int i56 = w0.a.W9;
        if (i36.hasValue(i56)) {
            this.L0 = g1.c.b(context2, i36, i56);
        }
        int i57 = w0.a.X9;
        if (i36.hasValue(i57)) {
            this.M0 = ViewUtils.j(i36.getInt(i57, -1), null);
        }
        int i58 = w0.a.V9;
        if (i36.hasValue(i58)) {
            setErrorIconDrawable(i36.getDrawable(i58));
        }
        checkableImageButton.setContentDescription(getResources().getText(R.string.zvq));
        ViewCompat.setImportantForAccessibility(checkableImageButton, 2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = i36.getResourceId(i28, 0);
        boolean z18 = i36.getBoolean(w0.a.f443843ca, false);
        CharSequence text2 = i36.getText(w0.a.f443831ba);
        int resourceId3 = i36.getResourceId(w0.a.f443993pa, 0);
        CharSequence text3 = i36.getText(w0.a.f443981oa);
        int resourceId4 = i36.getResourceId(w0.a.Aa, 0);
        CharSequence text4 = i36.getText(w0.a.f444111za);
        boolean z19 = i36.getBoolean(w0.a.H9, false);
        setCounterMaxLength(i36.getInt(w0.a.I9, -1));
        this.M = i36.getResourceId(i19, 0);
        this.L = i36.getResourceId(i26, 0);
        setBoxBackgroundMode(i36.getInt(w0.a.f444086x9, 0));
        if (g1.c.i(context2)) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        int resourceId5 = i36.getResourceId(w0.a.P9, 0);
        sparseArray.append(-1, new com.google.android.material.textfield.a(this, resourceId5));
        sparseArray.append(0, new g(this));
        if (resourceId5 == 0) {
            z16 = z18;
            i17 = i36.getResourceId(w0.a.f443936ka, 0);
        } else {
            z16 = z18;
            i17 = resourceId5;
        }
        sparseArray.append(1, new PasswordToggleEndIconDelegate(this, i17));
        sparseArray.append(2, new ClearTextEndIconDelegate(this, resourceId5));
        sparseArray.append(3, new DropdownMenuEndIconDelegate(this, resourceId5));
        int i59 = w0.a.f443947la;
        if (!i36.hasValue(i59)) {
            int i65 = w0.a.R9;
            if (i36.hasValue(i65)) {
                this.D0 = g1.c.b(context2, i36, i65);
            }
            int i66 = w0.a.S9;
            if (i36.hasValue(i66)) {
                this.E0 = ViewUtils.j(i36.getInt(i66, -1), null);
            }
        }
        int i67 = w0.a.Q9;
        if (i36.hasValue(i67)) {
            setEndIconMode(i36.getInt(i67, 0));
            int i68 = w0.a.O9;
            if (i36.hasValue(i68)) {
                setEndIconContentDescription(i36.getText(i68));
            }
            setEndIconCheckable(i36.getBoolean(w0.a.N9, true));
        } else if (i36.hasValue(i59)) {
            int i69 = w0.a.f443958ma;
            if (i36.hasValue(i69)) {
                this.D0 = g1.c.b(context2, i36, i69);
            }
            int i75 = w0.a.f443969na;
            if (i36.hasValue(i75)) {
                this.E0 = ViewUtils.j(i36.getInt(i75, -1), null);
            }
            setEndIconMode(i36.getBoolean(i59, false) ? 1 : 0);
            setEndIconContentDescription(i36.getText(w0.a.f443925ja));
        }
        appCompatTextView.setId(R.id.f95995gh);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        setErrorContentDescription(text);
        setCounterOverflowTextAppearance(this.L);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.M);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setSuffixTextAppearance(resourceId4);
        int i76 = w0.a.Z9;
        if (i36.hasValue(i76)) {
            setErrorTextColor(i36.getColorStateList(i76));
        }
        int i77 = w0.a.f443867ea;
        if (i36.hasValue(i77)) {
            setHelperTextColor(i36.getColorStateList(i77));
        }
        int i78 = w0.a.f443914ia;
        if (i36.hasValue(i78)) {
            setHintTextColor(i36.getColorStateList(i78));
        }
        int i79 = w0.a.M9;
        if (i36.hasValue(i79)) {
            setCounterTextColor(i36.getColorStateList(i79));
        }
        int i85 = w0.a.K9;
        if (i36.hasValue(i85)) {
            setCounterOverflowTextColor(i36.getColorStateList(i85));
        }
        int i86 = w0.a.f444005qa;
        if (i36.hasValue(i86)) {
            setPlaceholderTextColor(i36.getColorStateList(i86));
        }
        int i87 = w0.a.Ba;
        if (i36.hasValue(i87)) {
            setSuffixTextColor(i36.getColorStateList(i87));
        }
        setEnabled(i36.getBoolean(w0.a.f443992p9, true));
        i36.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
        frameLayout2.addView(checkableImageButton2);
        linearLayout.addView(appCompatTextView);
        linearLayout.addView(checkableImageButton);
        linearLayout.addView(frameLayout2);
        frameLayout.addView(hVar);
        frameLayout.addView(linearLayout);
        addView(frameLayout);
        setHelperTextEnabled(z16);
        setErrorEnabled(z17);
        setCounterEnabled(z19);
        setHelperText(text2);
        setSuffixText(text4);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.K0.setImageDrawable(drawable);
        Q0();
        com.google.android.material.textfield.e.a(this, this.K0, this.L0, this.M0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.B0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.B0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout.this.S0(!r0.f34383e1);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.H) {
                textInputLayout.I0(editable.length());
            }
            if (TextInputLayout.this.P) {
                TextInputLayout.this.W0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
