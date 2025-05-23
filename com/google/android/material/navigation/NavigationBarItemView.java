package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import common.config.service.QzoneConfig;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {

    /* renamed from: c0, reason: collision with root package name */
    private static final int[] f33887c0 = {R.attr.state_checked};

    /* renamed from: d0, reason: collision with root package name */
    private static final c f33888d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final c f33889e0;
    private int C;
    private boolean D;

    @Nullable
    private final FrameLayout E;

    @Nullable
    private final View F;
    private final ImageView G;
    private final ViewGroup H;
    private final TextView I;
    private final TextView J;
    private int K;

    @Nullable
    private MenuItemImpl L;

    @Nullable
    private ColorStateList M;

    @Nullable
    private Drawable N;

    @Nullable
    private Drawable P;
    private ValueAnimator Q;
    private c R;
    private float S;
    private boolean T;
    private int U;
    private int V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private int f33890a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private BadgeDrawable f33891b0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33892d;

    /* renamed from: e, reason: collision with root package name */
    private int f33893e;

    /* renamed from: f, reason: collision with root package name */
    private int f33894f;

    /* renamed from: h, reason: collision with root package name */
    private float f33895h;

    /* renamed from: i, reason: collision with root package name */
    private float f33896i;

    /* renamed from: m, reason: collision with root package name */
    private float f33897m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (NavigationBarItemView.this.G.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.A(navigationBarItemView.G);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f33900d;

        b(float f16) {
            this.f33900d = f16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.t(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f33900d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {
        c() {
        }

        protected float a(@FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
            float f18;
            float f19;
            if (f17 == 0.0f) {
                f18 = 0.8f;
            } else {
                f18 = 0.0f;
            }
            if (f17 == 0.0f) {
                f19 = 1.0f;
            } else {
                f19 = 0.2f;
            }
            return x0.a.b(0.0f, 1.0f, f18, f19, f16);
        }

        protected float b(@FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
            return x0.a.a(0.4f, 1.0f, f16);
        }

        protected float c(@FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
            return 1.0f;
        }

        public void d(@FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17, @NonNull View view) {
            view.setScaleX(b(f16, f17));
            view.setScaleY(c(f16, f17));
            view.setAlpha(a(f16, f17));
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class d extends c {
        d() {
            super(null);
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.c
        protected float c(float f16, float f17) {
            return b(f16, f17);
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f33888d0 = new c(aVar);
        f33889e0 = new d(aVar);
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f33892d = false;
        this.K = -1;
        this.R = f33888d0;
        this.S = 0.0f;
        this.T = false;
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.f33890a0 = 0;
        LayoutInflater.from(context).inflate(k(), (ViewGroup) this, true);
        this.E = (FrameLayout) findViewById(com.tencent.mobileqq.R.id.zmj);
        this.F = findViewById(com.tencent.mobileqq.R.id.zmi);
        ImageView imageView = (ImageView) findViewById(com.tencent.mobileqq.R.id.zmk);
        this.G = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.tencent.mobileqq.R.id.zml);
        this.H = viewGroup;
        TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.zmn);
        this.I = textView;
        TextView textView2 = (TextView) findViewById(com.tencent.mobileqq.R.id.zmm);
        this.J = textView2;
        setBackgroundResource(i());
        this.f33893e = getResources().getDimensionPixelSize(j());
        this.f33894f = viewGroup.getPaddingBottom();
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        e(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view) {
        if (!o()) {
            return;
        }
        com.google.android.material.badge.c.g(this.f33891b0, view, g(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        int i16;
        if (this.F == null) {
            return;
        }
        int min = Math.min(this.U, i3 - (this.f33890a0 * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.F.getLayoutParams();
        if (p()) {
            i16 = min;
        } else {
            i16 = this.V;
        }
        layoutParams.height = i16;
        layoutParams.width = min;
        this.F.setLayoutParams(layoutParams);
    }

    private void C() {
        if (p()) {
            this.R = f33889e0;
        } else {
            this.R = f33888d0;
        }
    }

    private static void D(@NonNull View view, int i3) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    private void e(float f16, float f17) {
        this.f33895h = f16 - f17;
        this.f33896i = (f17 * 1.0f) / f16;
        this.f33897m = (f16 * 1.0f) / f17;
    }

    @Nullable
    private FrameLayout g(View view) {
        ImageView imageView = this.G;
        if (view != imageView || !com.google.android.material.badge.c.f33274a) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private View h() {
        FrameLayout frameLayout = this.E;
        if (frameLayout == null) {
            return this.G;
        }
        return frameLayout;
    }

    private int l() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i3 = 0;
        for (int i16 = 0; i16 < indexOfChild; i16++) {
            View childAt = viewGroup.getChildAt(i16);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i3++;
            }
        }
        return i3;
    }

    private int m() {
        int i3;
        BadgeDrawable badgeDrawable = this.f33891b0;
        if (badgeDrawable != null) {
            i3 = badgeDrawable.getMinimumHeight() / 2;
        } else {
            i3 = 0;
        }
        return Math.max(i3, ((FrameLayout.LayoutParams) h().getLayoutParams()).topMargin) + this.G.getMeasuredWidth() + i3;
    }

    private int n() {
        int minimumWidth;
        BadgeDrawable badgeDrawable = this.f33891b0;
        if (badgeDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = badgeDrawable.getMinimumWidth() - this.f33891b0.h();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) h().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.G.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean o() {
        if (this.f33891b0 != null) {
            return true;
        }
        return false;
    }

    private boolean p() {
        if (this.W && this.C == 2) {
            return true;
        }
        return false;
    }

    private void q(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (this.T && this.f33892d && ViewCompat.isAttachedToWindow(this)) {
            ValueAnimator valueAnimator = this.Q;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.Q = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.S, f16);
            this.Q = ofFloat;
            ofFloat.addUpdateListener(new b(f16));
            this.Q.setInterpolator(f1.a.e(getContext(), com.tencent.mobileqq.R.attr.axk, x0.a.f446811b));
            this.Q.setDuration(f1.a.d(getContext(), com.tencent.mobileqq.R.attr.axa, getResources().getInteger(com.tencent.mobileqq.R.integer.f167190bi)));
            this.Q.start();
            return;
        }
        t(f16, f16);
    }

    private void r() {
        MenuItemImpl menuItemImpl = this.L;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(@FloatRange(from = 0.0d, to = 1.0d) float f16, float f17) {
        View view = this.F;
        if (view != null) {
            this.R.d(f16, f17, view);
        }
        this.S = f16;
    }

    private static void v(TextView textView, @StyleRes int i3) {
        TextViewCompat.setTextAppearance(textView, i3);
        int h16 = g1.c.h(textView.getContext(), i3, 0);
        if (h16 != 0) {
            textView.setTextSize(0, h16);
        }
    }

    private static void w(@NonNull View view, float f16, float f17, int i3) {
        view.setScaleX(f16);
        view.setScaleY(f17);
        view.setVisibility(i3);
    }

    private static void x(@NonNull View view, int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        layoutParams.bottomMargin = i3;
        layoutParams.gravity = i16;
        view.setLayoutParams(layoutParams);
    }

    private void y(@Nullable View view) {
        if (o() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.c.c(this.f33891b0, view, g(view));
        }
    }

    private void z(@Nullable View view) {
        if (!o()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            com.google.android.material.badge.c.f(this.f33891b0, view);
        }
        this.f33891b0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        s();
        this.L = null;
        this.S = 0.0f;
        this.f33892d = false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.L;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H.getLayoutParams();
        return m() + layoutParams.topMargin + this.H.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H.getLayoutParams();
        return Math.max(n(), layoutParams.leftMargin + this.H.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @DrawableRes
    protected int i() {
        return com.tencent.mobileqq.R.drawable.k0t;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i3) {
        CharSequence title;
        int i16;
        this.L = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, title);
        }
        if (menuItemImpl.isVisible()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        setVisibility(i16);
        this.f33892d = true;
    }

    @DimenRes
    protected int j() {
        return com.tencent.mobileqq.R.dimen.cul;
    }

    @LayoutRes
    protected abstract int k();

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        MenuItemImpl menuItemImpl = this.L;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.L.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f33887c0);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.f33891b0;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.L.getTitle();
            if (!TextUtils.isEmpty(this.L.getContentDescription())) {
                title = this.L.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.f33891b0.f()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, l(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(com.tencent.mobileqq.R.string.f161531xz));
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.B(i3);
            }
        });
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    void s() {
        z(this.G);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.F;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public void setActiveIndicatorEnabled(boolean z16) {
        int i3;
        this.T = z16;
        View view = this.F;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i3) {
        this.V = i3;
        B(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i3) {
        this.f33890a0 = i3;
        B(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z16) {
        this.W = z16;
    }

    public void setActiveIndicatorWidth(int i3) {
        this.U = i3;
        B(getWidth());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z16) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z16) {
        float f16;
        this.J.setPivotX(r0.getWidth() / 2);
        this.J.setPivotY(r0.getBaseline());
        this.I.setPivotX(r0.getWidth() / 2);
        this.I.setPivotY(r0.getBaseline());
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        q(f16);
        int i3 = this.C;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        x(h(), this.f33893e, 17);
                        this.J.setVisibility(8);
                        this.I.setVisibility(8);
                    }
                } else {
                    D(this.H, this.f33894f);
                    if (z16) {
                        x(h(), (int) (this.f33893e + this.f33895h), 49);
                        w(this.J, 1.0f, 1.0f, 0);
                        TextView textView = this.I;
                        float f17 = this.f33896i;
                        w(textView, f17, f17, 4);
                    } else {
                        x(h(), this.f33893e, 49);
                        TextView textView2 = this.J;
                        float f18 = this.f33897m;
                        w(textView2, f18, f18, 4);
                        w(this.I, 1.0f, 1.0f, 0);
                    }
                }
            } else {
                if (z16) {
                    x(h(), this.f33893e, 49);
                    D(this.H, this.f33894f);
                    this.J.setVisibility(0);
                } else {
                    x(h(), this.f33893e, 17);
                    D(this.H, 0);
                    this.J.setVisibility(4);
                }
                this.I.setVisibility(4);
            }
        } else if (this.D) {
            if (z16) {
                x(h(), this.f33893e, 49);
                D(this.H, this.f33894f);
                this.J.setVisibility(0);
            } else {
                x(h(), this.f33893e, 17);
                D(this.H, 0);
                this.J.setVisibility(4);
            }
            this.I.setVisibility(4);
        } else {
            D(this.H, this.f33894f);
            if (z16) {
                x(h(), (int) (this.f33893e + this.f33895h), 49);
                w(this.J, 1.0f, 1.0f, 0);
                TextView textView3 = this.I;
                float f19 = this.f33896i;
                w(textView3, f19, f19, 4);
            } else {
                x(h(), this.f33893e, 49);
                TextView textView4 = this.J;
                float f26 = this.f33897m;
                w(textView4, f26, f26, 4);
                w(this.I, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z16);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        this.I.setEnabled(z16);
        this.J.setEnabled(z16);
        this.G.setEnabled(z16);
        if (z16) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.N) {
            return;
        }
        this.N = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.P = drawable;
            ColorStateList colorStateList = this.M;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.G.setImageDrawable(drawable);
    }

    public void setIconSize(int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        this.G.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.M = colorStateList;
        if (this.L != null && (drawable = this.P) != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            this.P.invalidateSelf();
        }
    }

    public void setItemBackground(int i3) {
        setItemBackground(i3 == 0 ? null : ContextCompat.getDrawable(getContext(), i3));
    }

    public void setItemPaddingBottom(int i3) {
        if (this.f33894f != i3) {
            this.f33894f = i3;
            r();
        }
    }

    public void setItemPaddingTop(int i3) {
        if (this.f33893e != i3) {
            this.f33893e = i3;
            r();
        }
    }

    public void setItemPosition(int i3) {
        this.K = i3;
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.C != i3) {
            this.C = i3;
            C();
            B(getWidth());
            r();
        }
    }

    public void setShifting(boolean z16) {
        if (this.D != z16) {
            this.D = z16;
            r();
        }
    }

    public void setTextAppearanceActive(@StyleRes int i3) {
        v(this.J, i3);
        e(this.I.getTextSize(), this.J.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i3) {
        v(this.I, i3);
        e(this.I.getTextSize(), this.J.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.I.setTextColor(colorStateList);
            this.J.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.I.setText(charSequence);
        this.J.setText(charSequence);
        MenuItemImpl menuItemImpl = this.L;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.L;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.L.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(@NonNull BadgeDrawable badgeDrawable) {
        if (this.f33891b0 == badgeDrawable) {
            return;
        }
        if (o() && this.G != null) {
            Log.w(QzoneConfig.MAIN_KEY_NAVIGATOR_BAR, "Multiple badges shouldn't be attached to one item.");
            z(this.G);
        }
        this.f33891b0 = badgeDrawable;
        ImageView imageView = this.G;
        if (imageView != null) {
            y(imageView);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z16, char c16) {
    }
}
