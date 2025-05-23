package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.chip.a;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.g;
import com.google.android.material.internal.o;
import com.tencent.ditto.shell.LayoutAttrDefine;
import g1.d;
import j1.f;
import java.util.List;
import x0.h;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0230a, f, g<Chip> {
    private static final int P = 2131953423;
    private static final Rect Q = new Rect();
    private static final int[] R = {R.attr.state_selected};
    private static final int[] S = {R.attr.state_checkable};
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;

    @Dimension(unit = 1)
    private int H;

    @Nullable
    private CharSequence I;

    @NonNull
    private final c J;
    private boolean K;
    private final Rect L;
    private final RectF M;
    private final g1.f N;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private com.google.android.material.chip.a f33439d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private InsetDrawable f33440e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private RippleDrawable f33441f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private View.OnClickListener f33442h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private g.a<Chip> f33443i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f33444m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.f33439d != null) {
                Chip.this.f33439d.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends ExploreByTouchHelper {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            if (Chip.this.s() && Chip.this.p().contains(f16, f17)) {
                return 1;
            }
            return 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.s() && Chip.this.x() && Chip.this.f33442h != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (i16 == 16) {
                if (i3 == 0) {
                    return Chip.this.performClick();
                }
                if (i3 == 1) {
                    return Chip.this.y();
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.w());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            accessibilityNodeInfoCompat.setClassName(Chip.this.getAccessibilityClassName());
            accessibilityNodeInfoCompat.setText(Chip.this.getText());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence = "";
            if (i3 == 1) {
                CharSequence o16 = Chip.this.o();
                if (o16 != null) {
                    accessibilityNodeInfoCompat.setContentDescription(o16);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(com.tencent.mobileqq.R.string.f168472fq, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.q());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.Q);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int i3, boolean z16) {
            if (i3 == 1) {
                Chip.this.E = z16;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A(boolean z16) {
        if (this.D != z16) {
            this.D = z16;
            refreshDrawableState();
        }
    }

    private void B(boolean z16) {
        if (this.C != z16) {
            this.C = z16;
            refreshDrawableState();
        }
    }

    private void D(@Nullable com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.d2(null);
        }
    }

    private void E() {
        if (s() && x() && this.f33442h != null) {
            ViewCompat.setAccessibilityDelegate(this, this.J);
            this.K = true;
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
            this.K = false;
        }
    }

    private void F() {
        if (h1.b.f404037a) {
            G();
            return;
        }
        this.f33439d.y2(true);
        ViewCompat.setBackground(this, m());
        H();
        l();
    }

    private void G() {
        this.f33441f = new RippleDrawable(h1.b.d(this.f33439d.U0()), m(), null);
        this.f33439d.y2(false);
        ViewCompat.setBackground(this, this.f33441f);
        H();
    }

    private void H() {
        com.google.android.material.chip.a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f33439d) != null) {
            int J0 = (int) (aVar.J0() + this.f33439d.X0() + this.f33439d.t0());
            int M0 = (int) (this.f33439d.M0() + this.f33439d.Y0() + this.f33439d.p0());
            if (this.f33440e != null) {
                Rect rect = new Rect();
                this.f33440e.getPadding(rect);
                M0 += rect.left;
                J0 += rect.right;
            }
            ViewCompat.setPaddingRelative(this, M0, getPaddingTop(), J0, getPaddingBottom());
        }
    }

    private void I() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d r16 = r();
        if (r16 != null) {
            r16.n(getContext(), paint, this.N);
        }
    }

    private void J(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", LayoutAttrDefine.Gravity.Gravity, 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    private void i(@NonNull com.google.android.material.chip.a aVar) {
        aVar.d2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    @NonNull
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i3 = isEnabled;
        if (this.E) {
            i3 = isEnabled + 1;
        }
        int i16 = i3;
        if (this.D) {
            i16 = i3 + 1;
        }
        int i17 = i16;
        if (this.C) {
            i17 = i16 + 1;
        }
        int i18 = i17;
        if (isChecked()) {
            i18 = i17 + 1;
        }
        int[] iArr = new int[i18];
        int i19 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i19 = 1;
        }
        if (this.E) {
            iArr[i19] = 16842908;
            i19++;
        }
        if (this.D) {
            iArr[i19] = 16843623;
            i19++;
        }
        if (this.C) {
            iArr[i19] = 16842919;
            i19++;
        }
        if (isChecked()) {
            iArr[i19] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (m() == this.f33440e && this.f33439d.getCallback() == null) {
            this.f33439d.setCallback(this.f33440e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF p() {
        this.M.setEmpty();
        if (s() && this.f33442h != null) {
            this.f33439d.Q0(this.M);
        }
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect q() {
        RectF p16 = p();
        this.L.set((int) p16.left, (int) p16.top, (int) p16.right, (int) p16.bottom);
        return this.L;
    }

    @Nullable
    private d r() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            return aVar.W0();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null && aVar.N0() != null) {
            return true;
        }
        return false;
    }

    private void t(Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray h16 = o.h(context, attributeSet, w0.a.O0, i3, P, new int[0]);
        this.F = h16.getBoolean(w0.a.f444044u1, false);
        this.H = (int) Math.ceil(h16.getDimension(w0.a.f443906i1, (float) Math.ceil(ViewUtils.c(getContext(), 48))));
        h16.recycle();
    }

    private void u() {
        setOutlineProvider(new b());
    }

    private void v(int i3, int i16, int i17, int i18) {
        this.f33440e = new InsetDrawable((Drawable) this.f33439d, i3, i16, i17, i18);
    }

    private void z() {
        if (this.f33440e != null) {
            this.f33440e = null;
            setMinWidth(0);
            setMinHeight((int) n());
            F();
        }
    }

    public boolean C() {
        return this.F;
    }

    @Override // com.google.android.material.chip.a.InterfaceC0230a
    public void a() {
        k(this.H);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.K) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.J.dispatchHoverEvent(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.K) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.J.dispatchKeyEvent(keyEvent) && this.J.getKeyboardFocusedVirtualViewId() != Integer.MIN_VALUE) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z16;
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null && aVar.d1()) {
            z16 = this.f33439d.Z1(j());
        } else {
            z16 = false;
        }
        if (z16) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.I)) {
            return this.I;
        }
        if (w()) {
            ViewParent parent = getParent();
            if ((parent instanceof ChipGroup) && ((ChipGroup) parent).m()) {
                return "android.widget.RadioButton";
            }
            return "android.widget.CompoundButton";
        }
        if (isClickable()) {
            return "android.widget.Button";
        }
        return "android.view.View";
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.K && (this.J.getKeyboardFocusedVirtualViewId() == 1 || this.J.getAccessibilityFocusedVirtualViewId() == 1)) {
            rect.set(q());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public boolean k(@Dimension int i3) {
        int i16;
        this.H = i3;
        int i17 = 0;
        if (!C()) {
            if (this.f33440e != null) {
                z();
            } else {
                F();
            }
            return false;
        }
        int max = Math.max(0, i3 - this.f33439d.getIntrinsicHeight());
        int max2 = Math.max(0, i3 - this.f33439d.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f33440e != null) {
                z();
            } else {
                F();
            }
            return false;
        }
        if (max2 > 0) {
            i16 = max2 / 2;
        } else {
            i16 = 0;
        }
        if (max > 0) {
            i17 = max / 2;
        }
        if (this.f33440e != null) {
            Rect rect = new Rect();
            this.f33440e.getPadding(rect);
            if (rect.top == i17 && rect.bottom == i17 && rect.left == i16 && rect.right == i16) {
                F();
                return true;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        v(i16, i17, i16, i17);
        F();
        return true;
    }

    @Nullable
    public Drawable m() {
        InsetDrawable insetDrawable = this.f33440e;
        if (insetDrawable == null) {
            return this.f33439d;
        }
        return insetDrawable;
    }

    public float n() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    @Nullable
    public CharSequence o() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.f(this, this.f33439d);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, R);
        }
        if (w()) {
            View.mergeDrawableStates(onCreateDrawableState, S);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        super.onFocusChanged(z16, i3, rect);
        if (this.K) {
            this.J.onFocusChanged(z16, i3, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                A(false);
            }
        } else {
            A(p().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(w());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            if (chipGroup.d()) {
                i3 = chipGroup.l(this);
            } else {
                i3 = -1;
            }
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.c(this), 1, i3, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i3) {
        PointerIcon systemIcon;
        if (p().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            systemIcon = PointerIcon.getSystemIcon(getContext(), 1002);
            return systemIcon;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.G != i3) {
            this.G = i3;
            H();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z16;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = p().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.C) {
                        if (!contains) {
                            B(false);
                        }
                        z16 = true;
                    }
                }
                z16 = false;
            } else if (this.C) {
                y();
                z16 = true;
                B(false);
            }
            z16 = false;
            B(false);
        } else {
            if (contains) {
                B(true);
                z16 = true;
            }
            z16 = false;
        }
        if (z16 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setAccessibilityClassName(@Nullable CharSequence charSequence) {
        this.I = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != m() && drawable != this.f33441f) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != m() && drawable != this.f33441f) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.l1(z16);
        }
    }

    public void setCheckableResource(@BoolRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.m1(i3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z16) {
        g.a<Chip> aVar;
        com.google.android.material.chip.a aVar2 = this.f33439d;
        if (aVar2 == null) {
            this.f33444m = z16;
            return;
        }
        if (aVar2.c1()) {
            boolean isChecked = isChecked();
            super.setChecked(z16);
            if (isChecked != z16 && (aVar = this.f33443i) != null) {
                aVar.a(this, z16);
            }
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.n1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z16) {
        setCheckedIconVisible(z16);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(@DrawableRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.o1(i3);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.p1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.q1(i3);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.r1(i3);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.t1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.u1(i3);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.v1(f16);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.w1(i3);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f33439d;
        if (aVar2 != aVar) {
            D(aVar2);
            this.f33439d = aVar;
            aVar.o2(false);
            i(this.f33439d);
            k(this.H);
        }
    }

    public void setChipEndPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.x1(f16);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.y1(i3);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.z1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z16) {
        setChipIconVisible(z16);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(@DrawableRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.A1(i3);
        }
    }

    public void setChipIconSize(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.B1(f16);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.C1(i3);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.D1(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.E1(i3);
        }
    }

    public void setChipIconVisible(@BoolRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.F1(i3);
        }
    }

    public void setChipMinHeight(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.H1(f16);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.I1(i3);
        }
    }

    public void setChipStartPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.J1(f16);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.K1(i3);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.L1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.M1(i3);
        }
    }

    public void setChipStrokeWidth(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.N1(f16);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.O1(i3);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.Q1(drawable);
        }
        E();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.R1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z16) {
        setCloseIconVisible(z16);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.S1(f16);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.T1(i3);
        }
    }

    public void setCloseIconResource(@DrawableRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.U1(i3);
        }
        E();
    }

    public void setCloseIconSize(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.V1(f16);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.W1(i3);
        }
    }

    public void setCloseIconStartPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.X1(f16);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.Y1(i3);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.a2(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.b2(i3);
        }
    }

    public void setCloseIconVisible(@BoolRes int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 == null) {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
                return;
            }
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i16, int i17, int i18) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i17 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i16, i17, i18);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i16, int i17, int i18) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i17 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i3, i16, i17, i18);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.X(f16);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f33439d == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            com.google.android.material.chip.a aVar = this.f33439d;
            if (aVar != null) {
                aVar.e2(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z16) {
        this.F = z16;
        k(this.H);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.f2(hVar);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.g2(i3);
        }
    }

    public void setIconEndPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.h2(f16);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.i2(i3);
        }
    }

    public void setIconStartPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.j2(f16);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.k2(i3);
        }
    }

    @Override // com.google.android.material.internal.g
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable g.a<Chip> aVar) {
        this.f33443i = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f33439d == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 <= 1) {
            super.setLines(i3);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 <= 1) {
            super.setMaxLines(i3);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i3) {
        super.setMaxWidth(i3);
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.l2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 <= 1) {
            super.setMinLines(i3);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f33442h = onClickListener;
        E();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.m2(colorStateList);
        }
        if (!this.f33439d.a1()) {
            G();
        }
    }

    public void setRippleColorResource(@ColorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.n2(i3);
            if (!this.f33439d.a1()) {
                G();
            }
        }
    }

    @Override // j1.f
    public void setShapeAppearanceModel(@NonNull com.google.android.material.shape.g gVar) {
        this.f33439d.setShapeAppearanceModel(gVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.p2(hVar);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.q2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z16) {
        if (z16) {
            super.setSingleLine(z16);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (aVar.z2()) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        super.setText(charSequence2, bufferType);
        com.google.android.material.chip.a aVar2 = this.f33439d;
        if (aVar2 != null) {
            aVar2.r2(charSequence);
        }
    }

    public void setTextAppearance(@Nullable d dVar) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.s2(dVar);
        }
        I();
    }

    public void setTextAppearanceResource(@StyleRes int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.u2(f16);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.v2(i3);
        }
    }

    public void setTextStartPadding(float f16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.w2(f16);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i3) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.x2(i3);
        }
    }

    public boolean w() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null && aVar.c1()) {
            return true;
        }
        return false;
    }

    public boolean x() {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null && aVar.e1()) {
            return true;
        }
        return false;
    }

    @CallSuper
    public boolean y() {
        boolean z16 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f33442h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z16 = true;
        }
        if (this.K) {
            this.J.sendEventForVirtualView(1, 1);
        }
        return z16;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.a67);
    }

    public void setCloseIconVisible(boolean z16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.c2(z16);
        }
        E();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Chip(Context context, AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = P;
        this.L = new Rect();
        this.M = new RectF();
        this.N = new a();
        Context context2 = getContext();
        J(attributeSet);
        com.google.android.material.chip.a y06 = com.google.android.material.chip.a.y0(context2, attributeSet, i3, i16);
        t(context2, attributeSet, i3);
        setChipDrawable(y06);
        y06.X(ViewCompat.getElevation(this));
        TypedArray h16 = o.h(context2, attributeSet, w0.a.O0, i3, i16, new int[0]);
        boolean hasValue = h16.hasValue(w0.a.f444102z1);
        h16.recycle();
        this.J = new c(this);
        E();
        if (!hasValue) {
            u();
        }
        setChecked(this.f33444m);
        setText(y06.V0());
        setEllipsize(y06.T0());
        I();
        if (!this.f33439d.z2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        H();
        if (C()) {
            setMinHeight(this.H);
        }
        this.G = ViewCompat.getLayoutDirection(this);
    }

    public void setCheckedIconVisible(boolean z16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.s1(z16);
        }
    }

    public void setChipIconVisible(boolean z16) {
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.G1(z16);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.t2(i3);
        }
        I();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        com.google.android.material.chip.a aVar = this.f33439d;
        if (aVar != null) {
            aVar.t2(i3);
        }
        I();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends g1.f {
        a() {
        }

        @Override // g1.f
        public void b(@NonNull Typeface typeface, boolean z16) {
            CharSequence text;
            Chip chip = Chip.this;
            if (chip.f33439d.z2()) {
                text = Chip.this.f33439d.V0();
            } else {
                text = Chip.this.getText();
            }
            chip.setText(text);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }

        @Override // g1.f
        public void a(int i3) {
        }
    }
}
