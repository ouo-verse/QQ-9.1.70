package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
@ViewPager.DecorView
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: r0, reason: collision with root package name */
    private static final int f34233r0 = 2131953249;

    /* renamed from: s0, reason: collision with root package name */
    private static final Pools.Pool<g> f34234s0 = new Pools.SynchronizedPool(16);
    int C;
    int D;
    ColorStateList E;
    ColorStateList F;
    ColorStateList G;

    @NonNull
    Drawable H;
    private int I;
    PorterDuff.Mode J;
    float K;
    float L;
    final int M;
    int N;
    private final int P;
    private final int Q;
    private final int R;
    private int S;
    int T;
    int U;
    int V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    boolean f34235a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f34236b0;

    /* renamed from: c0, reason: collision with root package name */
    int f34237c0;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<g> f34238d;

    /* renamed from: d0, reason: collision with root package name */
    int f34239d0;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private g f34240e;

    /* renamed from: e0, reason: collision with root package name */
    boolean f34241e0;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    final f f34242f;

    /* renamed from: f0, reason: collision with root package name */
    private com.google.android.material.tabs.c f34243f0;

    /* renamed from: g0, reason: collision with root package name */
    @Nullable
    private c f34244g0;

    /* renamed from: h, reason: collision with root package name */
    int f34245h;

    /* renamed from: h0, reason: collision with root package name */
    private final ArrayList<c> f34246h0;

    /* renamed from: i, reason: collision with root package name */
    int f34247i;

    /* renamed from: i0, reason: collision with root package name */
    @Nullable
    private c f34248i0;

    /* renamed from: j0, reason: collision with root package name */
    private ValueAnimator f34249j0;

    /* renamed from: k0, reason: collision with root package name */
    @Nullable
    ViewPager f34250k0;

    /* renamed from: l0, reason: collision with root package name */
    @Nullable
    private PagerAdapter f34251l0;

    /* renamed from: m, reason: collision with root package name */
    int f34252m;

    /* renamed from: m0, reason: collision with root package name */
    private DataSetObserver f34253m0;

    /* renamed from: n0, reason: collision with root package name */
    private h f34254n0;

    /* renamed from: o0, reason: collision with root package name */
    private b f34255o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f34256p0;

    /* renamed from: q0, reason: collision with root package name */
    private final Pools.Pool<TabView> f34257q0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public @interface LabelVisibility {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface Mode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TabGravity {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TabIndicatorAnimationMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface TabIndicatorGravity {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class TabView extends LinearLayout {

        @Nullable
        private TextView C;

        @Nullable
        private ImageView D;

        @Nullable
        private Drawable E;
        private int F;

        /* renamed from: d, reason: collision with root package name */
        private g f34258d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f34259e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f34260f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private View f34261h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        private BadgeDrawable f34262i;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private View f34263m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements View.OnLayoutChangeListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f34264d;

            a(View view) {
                this.f34264d = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                if (this.f34264d.getVisibility() == 0) {
                    TabView.this.v(this.f34264d);
                }
            }
        }

        public TabView(@NonNull Context context) {
            super(context);
            this.F = 2;
            x(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f34245h, TabLayout.this.f34247i, TabLayout.this.f34252m, TabLayout.this.C);
            setGravity(17);
            setOrientation(!TabLayout.this.f34235a0 ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void f(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float g(@NonNull Layout layout, int i3, float f16) {
            return layout.getLineWidth(i3) * (f16 / layout.getPaint().getTextSize());
        }

        private void h(boolean z16) {
            setClipChildren(z16);
            setClipToPadding(z16);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z16);
                viewGroup.setClipToPadding(z16);
            }
        }

        @NonNull
        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(@NonNull Canvas canvas) {
            Drawable drawable = this.E;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.E.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout m(@NonNull View view) {
            if ((view != this.f34260f && view != this.f34259e) || !com.google.android.material.badge.c.f33274a) {
                return null;
            }
            return (FrameLayout) view.getParent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean n() {
            if (this.f34262i != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void o() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.c.f33274a) {
                frameLayout = i();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.e5m, (ViewGroup) frameLayout, false);
            this.f34260f = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void p() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.c.f33274a) {
                frameLayout = i();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.e5n, (ViewGroup) frameLayout, false);
            this.f34259e = textView;
            frameLayout.addView(textView);
        }

        private void s(@Nullable View view) {
            if (n() && view != null) {
                h(false);
                com.google.android.material.badge.c.c(this.f34262i, view, m(view));
                this.f34261h = view;
            }
        }

        private void t() {
            if (!n()) {
                return;
            }
            h(true);
            View view = this.f34261h;
            if (view != null) {
                com.google.android.material.badge.c.f(this.f34262i, view);
                this.f34261h = null;
            }
        }

        private void u() {
            g gVar;
            g gVar2;
            if (!n()) {
                return;
            }
            if (this.f34263m != null) {
                t();
                return;
            }
            if (this.f34260f != null && (gVar2 = this.f34258d) != null && gVar2.f() != null) {
                View view = this.f34261h;
                ImageView imageView = this.f34260f;
                if (view != imageView) {
                    t();
                    s(this.f34260f);
                    return;
                } else {
                    v(imageView);
                    return;
                }
            }
            if (this.f34259e != null && (gVar = this.f34258d) != null && gVar.h() == 1) {
                View view2 = this.f34261h;
                TextView textView = this.f34259e;
                if (view2 != textView) {
                    t();
                    s(this.f34259e);
                    return;
                } else {
                    v(textView);
                    return;
                }
            }
            t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(@NonNull View view) {
            if (n() && view == this.f34261h) {
                com.google.android.material.badge.c.g(this.f34262i, view, m(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void x(Context context) {
            int i3 = TabLayout.this.M;
            GradientDrawable gradientDrawable = null;
            if (i3 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i3);
                this.E = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.E.setState(getDrawableState());
                }
            } else {
                this.E = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.G != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a16 = h1.b.a(TabLayout.this.G);
                boolean z16 = TabLayout.this.f34241e0;
                if (z16) {
                    gradientDrawable2 = null;
                }
                if (!z16) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(a16, gradientDrawable2, gradientDrawable);
            }
            ViewCompat.setBackground(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        private void z(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int i3;
            g gVar = this.f34258d;
            CharSequence charSequence2 = null;
            if (gVar != null && gVar.f() != null) {
                drawable = DrawableCompat.wrap(this.f34258d.f()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, TabLayout.this.F);
                PorterDuff.Mode mode = TabLayout.this.J;
                if (mode != null) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
            g gVar2 = this.f34258d;
            if (gVar2 != null) {
                charSequence = gVar2.j();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z16 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z16) {
                    textView.setText(charSequence);
                    if (this.f34258d.f34286g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z16 && imageView.getVisibility() == 0) {
                    i3 = (int) ViewUtils.c(getContext(), 8);
                } else {
                    i3 = 0;
                }
                if (TabLayout.this.f34235a0) {
                    if (i3 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, i3);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i3 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i3;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.f34258d;
            if (gVar3 != null) {
                charSequence2 = gVar3.f34283d;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!z16) {
                    charSequence = charSequence2;
                }
                TooltipCompat.setTooltipText(this, charSequence);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.E;
            boolean z16 = false;
            if (drawable != null && drawable.isStateful()) {
                z16 = false | this.E.setState(drawableState);
            }
            if (z16) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int k() {
            View[] viewArr = {this.f34259e, this.f34260f, this.f34263m};
            int i3 = 0;
            int i16 = 0;
            boolean z16 = false;
            for (int i17 = 0; i17 < 3; i17++) {
                View view = viewArr[i17];
                if (view != null && view.getVisibility() == 0) {
                    if (z16) {
                        i16 = Math.min(i16, view.getTop());
                    } else {
                        i16 = view.getTop();
                    }
                    if (z16) {
                        i3 = Math.max(i3, view.getBottom());
                    } else {
                        i3 = view.getBottom();
                    }
                    z16 = true;
                }
            }
            return i3 - i16;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int l() {
            View[] viewArr = {this.f34259e, this.f34260f, this.f34263m};
            int i3 = 0;
            int i16 = 0;
            boolean z16 = false;
            for (int i17 = 0; i17 < 3; i17++) {
                View view = viewArr[i17];
                if (view != null && view.getVisibility() == 0) {
                    if (z16) {
                        i16 = Math.min(i16, view.getLeft());
                    } else {
                        i16 = view.getLeft();
                    }
                    if (z16) {
                        i3 = Math.max(i3, view.getRight());
                    } else {
                        i3 = view.getRight();
                    }
                    z16 = true;
                }
            }
            return i3 - i16;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f34262i;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f34262i.f()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f34258d.g(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription(getResources().getString(R.string.f161531xz));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i16) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int D = TabLayout.this.D();
            if (D > 0 && (mode == 0 || size > D)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.N, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i16);
            if (this.f34259e != null) {
                float f16 = TabLayout.this.K;
                int i17 = this.F;
                ImageView imageView = this.f34260f;
                boolean z16 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i17 = 1;
                } else {
                    TextView textView = this.f34259e;
                    if (textView != null && textView.getLineCount() > 1) {
                        f16 = TabLayout.this.L;
                    }
                }
                float textSize = this.f34259e.getTextSize();
                int lineCount = this.f34259e.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f34259e);
                if (f16 != textSize || (maxLines >= 0 && i17 != maxLines)) {
                    if (TabLayout.this.W == 1 && f16 > textSize && lineCount == 1 && ((layout = this.f34259e.getLayout()) == null || g(layout, 0, f16) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f34259e.setTextSize(0, f16);
                        this.f34259e.setMaxLines(i17);
                        super.onMeasure(i3, i16);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f34258d != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f34258d.m();
                return true;
            }
            return performClick;
        }

        void q() {
            r(null);
            setSelected(false);
        }

        void r(@Nullable g gVar) {
            if (gVar != this.f34258d) {
                this.f34258d = gVar;
                w();
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            if (isSelected() != z16) {
            }
            super.setSelected(z16);
            TextView textView = this.f34259e;
            if (textView != null) {
                textView.setSelected(z16);
            }
            ImageView imageView = this.f34260f;
            if (imageView != null) {
                imageView.setSelected(z16);
            }
            View view = this.f34263m;
            if (view != null) {
                view.setSelected(z16);
            }
        }

        final void w() {
            View view;
            boolean z16;
            g gVar = this.f34258d;
            if (gVar != null) {
                view = gVar.e();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f34263m = view;
                TextView textView = this.f34259e;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f34260f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f34260f.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.C = textView2;
                if (textView2 != null) {
                    this.F = TextViewCompat.getMaxLines(textView2);
                }
                this.D = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view2 = this.f34263m;
                if (view2 != null) {
                    removeView(view2);
                    this.f34263m = null;
                }
                this.C = null;
                this.D = null;
            }
            if (this.f34263m == null) {
                if (this.f34260f == null) {
                    o();
                }
                if (this.f34259e == null) {
                    p();
                    this.F = TextViewCompat.getMaxLines(this.f34259e);
                }
                TextViewCompat.setTextAppearance(this.f34259e, TabLayout.this.D);
                ColorStateList colorStateList = TabLayout.this.E;
                if (colorStateList != null) {
                    this.f34259e.setTextColor(colorStateList);
                }
                z(this.f34259e, this.f34260f);
                u();
                f(this.f34260f);
                f(this.f34259e);
            } else {
                TextView textView3 = this.C;
                if (textView3 != null || this.D != null) {
                    z(textView3, this.D);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f34283d)) {
                setContentDescription(gVar.f34283d);
            }
            if (gVar != null && gVar.k()) {
                z16 = true;
            } else {
                z16 = false;
            }
            setSelected(z16);
        }

        final void y() {
            setOrientation(!TabLayout.this.f34235a0 ? 1 : 0);
            TextView textView = this.C;
            if (textView == null && this.D == null) {
                z(this.f34259e, this.f34260f);
            } else {
                z(textView, this.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnAdapterChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f34267d;

        b() {
        }

        void a(boolean z16) {
            this.f34267d = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f34250k0 == viewPager) {
                tabLayout.S(pagerAdapter2, this.f34267d);
            }
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface c<T extends g> {
        void onTabReselected(T t16);

        void onTabSelected(T t16);

        void onTabUnselected(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d extends c<g> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.K();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        ValueAnimator f34270d;

        /* renamed from: e, reason: collision with root package name */
        int f34271e;

        /* renamed from: f, reason: collision with root package name */
        float f34272f;

        /* renamed from: h, reason: collision with root package name */
        private int f34273h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f34275d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f34276e;

            a(View view, View view2) {
                this.f34275d = view;
                this.f34276e = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                f.this.h(this.f34275d, this.f34276e, valueAnimator.getAnimatedFraction());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f34278d;

            b(int i3) {
                this.f34278d = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.f34271e = this.f34278d;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f34271e = this.f34278d;
            }
        }

        f(Context context) {
            super(context);
            this.f34271e = -1;
            this.f34273h = -1;
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            View childAt = getChildAt(this.f34271e);
            com.google.android.material.tabs.c cVar = TabLayout.this.f34243f0;
            TabLayout tabLayout = TabLayout.this;
            cVar.c(tabLayout, childAt, tabLayout.H);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f16) {
            boolean z16;
            if (view != null && view.getWidth() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.google.android.material.tabs.c cVar = TabLayout.this.f34243f0;
                TabLayout tabLayout = TabLayout.this;
                cVar.d(tabLayout, view, view2, f16, tabLayout.H);
            } else {
                Drawable drawable = TabLayout.this.H;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.H.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void i(boolean z16, int i3, int i16) {
            View childAt = getChildAt(this.f34271e);
            View childAt2 = getChildAt(i3);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z16) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f34270d = valueAnimator;
                valueAnimator.setInterpolator(x0.a.f446811b);
                valueAnimator.setDuration(i16);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i3));
                valueAnimator.start();
                return;
            }
            this.f34270d.removeAllUpdateListeners();
            this.f34270d.addUpdateListener(aVar);
        }

        void c(int i3, int i16) {
            ValueAnimator valueAnimator = this.f34270d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f34270d.cancel();
            }
            i(true, i3, i16);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height;
            int height2 = TabLayout.this.H.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.H.getIntrinsicHeight();
            }
            int i3 = TabLayout.this.V;
            if (i3 != 0) {
                if (i3 != 1) {
                    height = 0;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (TabLayout.this.H.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.H.getBounds();
                TabLayout.this.H.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.H;
                if (tabLayout.I != 0) {
                    drawable = DrawableCompat.wrap(drawable);
                    DrawableCompat.setTint(drawable, TabLayout.this.I);
                } else {
                    DrawableCompat.setTintList(drawable, null);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i3, float f16) {
            ValueAnimator valueAnimator = this.f34270d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f34270d.cancel();
            }
            this.f34271e = i3;
            this.f34272f = f16;
            h(getChildAt(i3), getChildAt(this.f34271e + 1), this.f34272f);
        }

        void g(int i3) {
            Rect bounds = TabLayout.this.H.getBounds();
            TabLayout.this.H.setBounds(bounds.left, 0, bounds.right, i3);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            ValueAnimator valueAnimator = this.f34270d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                i(false, this.f34271e, -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z16 = true;
            if (tabLayout.T == 1 || tabLayout.W == 2) {
                int childCount = getChildCount();
                int i17 = 0;
                for (int i18 = 0; i18 < childCount; i18++) {
                    View childAt = getChildAt(i18);
                    if (childAt.getVisibility() == 0) {
                        i17 = Math.max(i17, childAt.getMeasuredWidth());
                    }
                }
                if (i17 <= 0) {
                    return;
                }
                if (i17 * childCount <= getMeasuredWidth() - (((int) ViewUtils.c(getContext(), 16)) * 2)) {
                    boolean z17 = false;
                    for (int i19 = 0; i19 < childCount; i19++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i19).getLayoutParams();
                        if (layoutParams.width != i17 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i17;
                            layoutParams.weight = 0.0f;
                            z17 = true;
                        }
                    }
                    z16 = z17;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.T = 0;
                    tabLayout2.X(false);
                }
                if (z16) {
                    super.onMeasure(i3, i16);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i3) {
            super.onRtlPropertiesChanged(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private Object f34280a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private Drawable f34281b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private CharSequence f34282c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private CharSequence f34283d;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private View f34285f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public TabLayout f34287h;

        /* renamed from: i, reason: collision with root package name */
        @NonNull
        public TabView f34288i;

        /* renamed from: e, reason: collision with root package name */
        private int f34284e = -1;

        /* renamed from: g, reason: collision with root package name */
        @LabelVisibility
        private int f34286g = 1;

        /* renamed from: j, reason: collision with root package name */
        private int f34289j = -1;

        @Nullable
        public View e() {
            return this.f34285f;
        }

        @Nullable
        public Drawable f() {
            return this.f34281b;
        }

        public int g() {
            return this.f34284e;
        }

        @LabelVisibility
        public int h() {
            return this.f34286g;
        }

        @Nullable
        public Object i() {
            return this.f34280a;
        }

        @Nullable
        public CharSequence j() {
            return this.f34282c;
        }

        public boolean k() {
            TabLayout tabLayout = this.f34287h;
            if (tabLayout != null) {
                int A = tabLayout.A();
                if (A != -1 && A == this.f34284e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void l() {
            this.f34287h = null;
            this.f34288i = null;
            this.f34280a = null;
            this.f34281b = null;
            this.f34289j = -1;
            this.f34282c = null;
            this.f34283d = null;
            this.f34284e = -1;
            this.f34285f = null;
        }

        public void m() {
            TabLayout tabLayout = this.f34287h;
            if (tabLayout != null) {
                tabLayout.Q(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public g n(@Nullable CharSequence charSequence) {
            this.f34283d = charSequence;
            u();
            return this;
        }

        @NonNull
        public g o(@LayoutRes int i3) {
            return p(LayoutInflater.from(this.f34288i.getContext()).inflate(i3, (ViewGroup) this.f34288i, false));
        }

        @NonNull
        public g p(@Nullable View view) {
            this.f34285f = view;
            u();
            return this;
        }

        @NonNull
        public g q(@Nullable Drawable drawable) {
            this.f34281b = drawable;
            TabLayout tabLayout = this.f34287h;
            if (tabLayout.T == 1 || tabLayout.W == 2) {
                tabLayout.X(true);
            }
            u();
            if (com.google.android.material.badge.c.f33274a && this.f34288i.n() && this.f34288i.f34262i.isVisible()) {
                this.f34288i.invalidate();
            }
            return this;
        }

        void r(int i3) {
            this.f34284e = i3;
        }

        @NonNull
        public g s(@Nullable Object obj) {
            this.f34280a = obj;
            return this;
        }

        @NonNull
        public g t(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f34283d) && !TextUtils.isEmpty(charSequence)) {
                this.f34288i.setContentDescription(charSequence);
            }
            this.f34282c = charSequence;
            u();
            return this;
        }

        void u() {
            TabView tabView = this.f34288i;
            if (tabView != null) {
                tabView.w();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class h implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final WeakReference<TabLayout> f34290d;

        /* renamed from: e, reason: collision with root package name */
        private int f34291e;

        /* renamed from: f, reason: collision with root package name */
        private int f34292f;

        public h(TabLayout tabLayout) {
            this.f34290d = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f34292f = 0;
            this.f34291e = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f34291e = this.f34292f;
            this.f34292f = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            TabLayout tabLayout = this.f34290d.get();
            if (tabLayout != null) {
                int i17 = this.f34292f;
                boolean z17 = false;
                if (i17 == 2 && this.f34291e != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f34291e != 0) {
                    z17 = true;
                }
                tabLayout.setScrollPosition(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            TabLayout tabLayout = this.f34290d.get();
            if (tabLayout != null && tabLayout.A() != i3 && i3 < tabLayout.C()) {
                int i16 = this.f34292f;
                if (i16 != 0 && (i16 != 2 || this.f34291e != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                tabLayout.R(tabLayout.B(i3), z16);
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private int E() {
        int i3 = this.P;
        if (i3 != -1) {
            return i3;
        }
        int i16 = this.W;
        if (i16 != 0 && i16 != 2) {
            return 0;
        }
        return this.R;
    }

    private int G() {
        return Math.max(0, ((this.f34242f.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private boolean H() {
        if (F() != 0 && F() != 2) {
            return false;
        }
        return true;
    }

    private void P(int i3) {
        TabView tabView = (TabView) this.f34242f.getChildAt(i3);
        this.f34242f.removeViewAt(i3);
        if (tabView != null) {
            tabView.q();
            this.f34257q0.release(tabView);
        }
        requestLayout();
    }

    private void T(int i3) {
        boolean z16;
        int childCount = this.f34242f.getChildCount();
        if (i3 < childCount) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = this.f34242f.getChildAt(i16);
                boolean z17 = true;
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childAt.setSelected(z16);
                if (i16 != i3) {
                    z17 = false;
                }
                childAt.setActivated(z17);
            }
        }
    }

    private void U(@Nullable ViewPager viewPager, boolean z16, boolean z17) {
        ViewPager viewPager2 = this.f34250k0;
        if (viewPager2 != null) {
            h hVar = this.f34254n0;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f34255o0;
            if (bVar != null) {
                this.f34250k0.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f34248i0;
        if (cVar != null) {
            N(cVar);
            this.f34248i0 = null;
        }
        if (viewPager != null) {
            this.f34250k0 = viewPager;
            if (this.f34254n0 == null) {
                this.f34254n0 = new h(this);
            }
            this.f34254n0.a();
            viewPager.addOnPageChangeListener(this.f34254n0);
            i iVar = new i(viewPager);
            this.f34248i0 = iVar;
            e(iVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                S(adapter, z16);
            }
            if (this.f34255o0 == null) {
                this.f34255o0 = new b();
            }
            this.f34255o0.a(z16);
            viewPager.addOnAdapterChangeListener(this.f34255o0);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f34250k0 = null;
            S(null, false);
        }
        this.f34256p0 = z17;
    }

    private void V() {
        int size = this.f34238d.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f34238d.get(i3).u();
        }
    }

    private void W(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.W == 1 && this.T == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private void j(@NonNull TabItem tabItem) {
        g J = J();
        CharSequence charSequence = tabItem.f34230d;
        if (charSequence != null) {
            J.t(charSequence);
        }
        Drawable drawable = tabItem.f34231e;
        if (drawable != null) {
            J.q(drawable);
        }
        int i3 = tabItem.f34232f;
        if (i3 != 0) {
            J.o(i3);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            J.n(tabItem.getContentDescription());
        }
        g(J);
    }

    private void k(@NonNull g gVar) {
        TabView tabView = gVar.f34288i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f34242f.addView(tabView, gVar.g(), s());
    }

    private void l(View view) {
        if (view instanceof TabItem) {
            j((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void m(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f34242f.d()) {
            int scrollX = getScrollX();
            int p16 = p(i3, 0.0f);
            if (scrollX != p16) {
                y();
                this.f34249j0.setIntValues(scrollX, p16);
                this.f34249j0.start();
            }
            this.f34242f.c(i3, this.U);
            return;
        }
        setScrollPosition(i3, 0.0f, true);
    }

    private void n(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
            } else {
                this.f34242f.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f34242f.setGravity(8388611);
    }

    private void o() {
        int max;
        int i3 = this.W;
        if (i3 != 0 && i3 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.S - this.f34245h);
        }
        ViewCompat.setPaddingRelative(this.f34242f, max, 0, 0, 0);
        int i16 = this.W;
        if (i16 != 0) {
            if (i16 == 1 || i16 == 2) {
                if (this.T == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f34242f.setGravity(1);
            }
        } else {
            n(this.T);
        }
        X(true);
    }

    private int p(int i3, float f16) {
        View childAt;
        View view;
        int i16 = this.W;
        int i17 = 0;
        if ((i16 != 0 && i16 != 2) || (childAt = this.f34242f.getChildAt(i3)) == null) {
            return 0;
        }
        int i18 = i3 + 1;
        if (i18 < this.f34242f.getChildCount()) {
            view = this.f34242f.getChildAt(i18);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i17 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i19 = (int) ((width + i17) * 0.5f * f16);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return left + i19;
        }
        return left - i19;
    }

    private void q(@NonNull g gVar, int i3) {
        gVar.r(i3);
        this.f34238d.add(i3, gVar);
        int size = this.f34238d.size();
        while (true) {
            i3++;
            if (i3 < size) {
                this.f34238d.get(i3).r(i3);
            } else {
                return;
            }
        }
    }

    @NonNull
    private static ColorStateList r(int i3, int i16) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i16, i3});
    }

    @NonNull
    private LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        W(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView u(@NonNull g gVar) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.f34257q0;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.r(gVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(E());
        if (TextUtils.isEmpty(gVar.f34283d)) {
            tabView.setContentDescription(gVar.f34282c);
        } else {
            tabView.setContentDescription(gVar.f34283d);
        }
        return tabView;
    }

    private void v(@NonNull g gVar) {
        for (int size = this.f34246h0.size() - 1; size >= 0; size--) {
            this.f34246h0.get(size).onTabReselected(gVar);
        }
    }

    private void w(@NonNull g gVar) {
        for (int size = this.f34246h0.size() - 1; size >= 0; size--) {
            this.f34246h0.get(size).onTabSelected(gVar);
        }
    }

    private void x(@NonNull g gVar) {
        for (int size = this.f34246h0.size() - 1; size >= 0; size--) {
            this.f34246h0.get(size).onTabUnselected(gVar);
        }
    }

    private void y() {
        if (this.f34249j0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f34249j0 = valueAnimator;
            valueAnimator.setInterpolator(x0.a.f446811b);
            this.f34249j0.setDuration(this.U);
            this.f34249j0.addUpdateListener(new a());
        }
    }

    @Dimension(unit = 0)
    private int z() {
        int size = this.f34238d.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                g gVar = this.f34238d.get(i3);
                if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.j())) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (z16 && !this.f34235a0) {
            return 72;
        }
        return 48;
    }

    public int A() {
        g gVar = this.f34240e;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    @Nullable
    public g B(int i3) {
        if (i3 >= 0 && i3 < C()) {
            return this.f34238d.get(i3);
        }
        return null;
    }

    public int C() {
        return this.f34238d.size();
    }

    int D() {
        return this.N;
    }

    public int F() {
        return this.W;
    }

    public boolean I() {
        return this.f34236b0;
    }

    @NonNull
    public g J() {
        g t16 = t();
        t16.f34287h = this;
        t16.f34288i = u(t16);
        if (t16.f34289j != -1) {
            t16.f34288i.setId(t16.f34289j);
        }
        return t16;
    }

    void K() {
        int currentItem;
        M();
        PagerAdapter pagerAdapter = this.f34251l0;
        if (pagerAdapter != null) {
            int f373114d = pagerAdapter.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                i(J().t(this.f34251l0.getPageTitle(i3)), false);
            }
            ViewPager viewPager = this.f34250k0;
            if (viewPager != null && f373114d > 0 && (currentItem = viewPager.getCurrentItem()) != A() && currentItem < C()) {
                Q(B(currentItem));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean L(g gVar) {
        return f34234s0.release(gVar);
    }

    public void M() {
        for (int childCount = this.f34242f.getChildCount() - 1; childCount >= 0; childCount--) {
            P(childCount);
        }
        Iterator<g> it = this.f34238d.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.l();
            L(next);
        }
        this.f34240e = null;
    }

    @Deprecated
    public void N(@Nullable c cVar) {
        this.f34246h0.remove(cVar);
    }

    public void O(@NonNull d dVar) {
        N(dVar);
    }

    public void Q(@Nullable g gVar) {
        R(gVar, true);
    }

    public void R(@Nullable g gVar, boolean z16) {
        int i3;
        g gVar2 = this.f34240e;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                v(gVar);
                m(gVar.g());
                return;
            }
            return;
        }
        if (gVar != null) {
            i3 = gVar.g();
        } else {
            i3 = -1;
        }
        if (z16) {
            if ((gVar2 == null || gVar2.g() == -1) && i3 != -1) {
                setScrollPosition(i3, 0.0f, true);
            } else {
                m(i3);
            }
            if (i3 != -1) {
                T(i3);
            }
        }
        this.f34240e = gVar;
        if (gVar2 != null) {
            x(gVar2);
        }
        if (gVar != null) {
            w(gVar);
        }
    }

    void S(@Nullable PagerAdapter pagerAdapter, boolean z16) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f34251l0;
        if (pagerAdapter2 != null && (dataSetObserver = this.f34253m0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f34251l0 = pagerAdapter;
        if (z16 && pagerAdapter != null) {
            if (this.f34253m0 == null) {
                this.f34253m0 = new e();
            }
            pagerAdapter.registerDataSetObserver(this.f34253m0);
        }
        K();
    }

    void X(boolean z16) {
        for (int i3 = 0; i3 < this.f34242f.getChildCount(); i3++) {
            View childAt = this.f34242f.getChildAt(i3);
            childAt.setMinimumWidth(E());
            W((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z16) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        l(view);
    }

    @Deprecated
    public void e(@Nullable c cVar) {
        if (!this.f34246h0.contains(cVar)) {
            this.f34246h0.add(cVar);
        }
    }

    public void f(@NonNull d dVar) {
        e(dVar);
    }

    public void g(@NonNull g gVar) {
        i(gVar, this.f34238d.isEmpty());
    }

    public void h(@NonNull g gVar, int i3, boolean z16) {
        if (gVar.f34287h == this) {
            q(gVar, i3);
            k(gVar);
            if (z16) {
                gVar.m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void i(@NonNull g gVar, boolean z16) {
        h(gVar, this.f34238d.size(), z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.e(this);
        if (this.f34250k0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                U((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f34256p0) {
            setupWithViewPager(null);
            this.f34256p0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i3 = 0; i3 < this.f34242f.getChildCount(); i3++) {
            View childAt = this.f34242f.getChildAt(i3);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, C(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (H() && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (r0 != 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L29;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int round = Math.round(ViewUtils.c(getContext(), z()));
        int mode = View.MeasureSpec.getMode(i16);
        boolean z16 = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i16) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 0) {
            int i17 = this.Q;
            if (i17 <= 0) {
                i17 = (int) (size - ViewUtils.c(getContext(), 56));
            }
            this.N = i17;
        }
        super.onMeasure(i3, i16);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i18 = this.W;
            if (i18 != 0) {
                if (i18 != 1) {
                }
                if (z16) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && !H()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        com.google.android.material.shape.d.d(this, f16);
    }

    public void setInlineLabel(boolean z16) {
        if (this.f34235a0 != z16) {
            this.f34235a0 = z16;
            for (int i3 = 0; i3 < this.f34242f.getChildCount(); i3++) {
                View childAt = this.f34242f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y();
                }
            }
            o();
        }
    }

    public void setInlineLabelResource(@BoolRes int i3) {
        setInlineLabel(getResources().getBoolean(i3));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollPosition(int i3, float f16, boolean z16) {
        setScrollPosition(i3, f16, z16, true);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.H != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.H = drawable;
            int i3 = this.f34237c0;
            if (i3 == -1) {
                i3 = drawable.getIntrinsicHeight();
            }
            this.f34242f.g(i3);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i3) {
        this.I = i3;
        X(false);
    }

    public void setSelectedTabIndicatorGravity(int i3) {
        if (this.V != i3) {
            this.V = i3;
            ViewCompat.postInvalidateOnAnimation(this.f34242f);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i3) {
        this.f34237c0 = i3;
        this.f34242f.g(i3);
    }

    public void setTabGravity(int i3) {
        if (this.T != i3) {
            this.T = i3;
            o();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            V();
        }
    }

    public void setTabIconTintResource(@ColorRes int i3) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setTabIndicatorAnimationMode(int i3) {
        this.f34239d0 = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f34243f0 = new com.google.android.material.tabs.b();
                    return;
                }
                throw new IllegalArgumentException(i3 + " is not a valid TabIndicatorAnimationMode");
            }
            this.f34243f0 = new com.google.android.material.tabs.a();
            return;
        }
        this.f34243f0 = new com.google.android.material.tabs.c();
    }

    public void setTabIndicatorFullWidth(boolean z16) {
        this.f34236b0 = z16;
        this.f34242f.e();
        ViewCompat.postInvalidateOnAnimation(this.f34242f);
    }

    public void setTabMode(int i3) {
        if (i3 != this.W) {
            this.W = i3;
            o();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            for (int i3 = 0; i3 < this.f34242f.getChildCount(); i3++) {
                View childAt = this.f34242f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i3) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            V();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        S(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z16) {
        if (this.f34241e0 != z16) {
            this.f34241e0 = z16;
            for (int i3 = 0; i3 < this.f34242f.getChildCount(); i3++) {
                View childAt = this.f34242f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).x(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i3) {
        setUnboundedRipple(getResources().getBoolean(i3));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (G() > 0) {
            return true;
        }
        return false;
    }

    protected g t() {
        g acquire = f34234s0.acquire();
        if (acquire == null) {
            return new g();
        }
        return acquire;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bec);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3) {
        l(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.f34244g0;
        if (cVar2 != null) {
            N(cVar2);
        }
        this.f34244g0 = cVar;
        if (cVar != null) {
            e(cVar);
        }
    }

    public void setScrollPosition(int i3, float f16, boolean z16, boolean z17) {
        int round = Math.round(i3 + f16);
        if (round < 0 || round >= this.f34242f.getChildCount()) {
            return;
        }
        if (z17) {
            this.f34242f.f(i3, f16);
        }
        ValueAnimator valueAnimator = this.f34249j0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f34249j0.cancel();
        }
        scrollTo(i3 < 0 ? 0 : p(i3, f16), 0);
        if (z16) {
            T(round);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z16) {
        U(viewPager, z16, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f34233r0;
        this.f34238d = new ArrayList<>();
        this.H = new GradientDrawable();
        this.I = 0;
        this.N = Integer.MAX_VALUE;
        this.f34237c0 = -1;
        this.f34246h0 = new ArrayList<>();
        this.f34257q0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f34242f = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = w0.a.f444085x8;
        int i17 = w0.a.V8;
        TypedArray h16 = o.h(context2, attributeSet, iArr, i3, i16, i17);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.Y(ColorStateList.valueOf(colorDrawable.getColor()));
            materialShapeDrawable.N(context2);
            materialShapeDrawable.X(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        setSelectedTabIndicator(g1.c.e(context2, h16, w0.a.D8));
        setSelectedTabIndicatorColor(h16.getColor(w0.a.G8, 0));
        fVar.g(h16.getDimensionPixelSize(w0.a.J8, -1));
        setSelectedTabIndicatorGravity(h16.getInt(w0.a.I8, 0));
        setTabIndicatorAnimationMode(h16.getInt(w0.a.F8, 0));
        setTabIndicatorFullWidth(h16.getBoolean(w0.a.H8, true));
        int dimensionPixelSize = h16.getDimensionPixelSize(w0.a.O8, 0);
        this.C = dimensionPixelSize;
        this.f34252m = dimensionPixelSize;
        this.f34247i = dimensionPixelSize;
        this.f34245h = dimensionPixelSize;
        this.f34245h = h16.getDimensionPixelSize(w0.a.R8, dimensionPixelSize);
        this.f34247i = h16.getDimensionPixelSize(w0.a.S8, this.f34247i);
        this.f34252m = h16.getDimensionPixelSize(w0.a.Q8, this.f34252m);
        this.C = h16.getDimensionPixelSize(w0.a.P8, this.C);
        int resourceId = h16.getResourceId(i17, R.style.f173673ab2);
        this.D = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.K = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.E = g1.c.a(context2, obtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            int i18 = w0.a.W8;
            if (h16.hasValue(i18)) {
                this.E = g1.c.a(context2, h16, i18);
            }
            int i19 = w0.a.U8;
            if (h16.hasValue(i19)) {
                this.E = r(this.E.getDefaultColor(), h16.getColor(i19, 0));
            }
            this.F = g1.c.a(context2, h16, w0.a.B8);
            this.J = ViewUtils.j(h16.getInt(w0.a.C8, -1), null);
            this.G = g1.c.a(context2, h16, w0.a.T8);
            this.U = h16.getInt(w0.a.E8, 300);
            this.P = h16.getDimensionPixelSize(w0.a.M8, -1);
            this.Q = h16.getDimensionPixelSize(w0.a.L8, -1);
            this.M = h16.getResourceId(w0.a.f444097y8, 0);
            this.S = h16.getDimensionPixelSize(w0.a.f444109z8, 0);
            this.W = h16.getInt(w0.a.N8, 1);
            this.T = h16.getInt(w0.a.A8, 0);
            this.f34235a0 = h16.getBoolean(w0.a.K8, false);
            this.f34241e0 = h16.getBoolean(w0.a.X8, false);
            h16.recycle();
            Resources resources = getResources();
            this.L = resources.getDimensionPixelSize(R.dimen.c9c);
            this.R = resources.getDimensionPixelSize(R.dimen.c9a);
            o();
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    public void setTabTextColors(int i3, int i16) {
        setTabTextColors(r(i3, i16));
    }

    public void setSelectedTabIndicator(@DrawableRes int i3) {
        if (i3 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i3));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class i implements d {

        /* renamed from: d, reason: collision with root package name */
        private final ViewPager f34293d;

        public i(ViewPager viewPager) {
            this.f34293d = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NonNull g gVar) {
            this.f34293d.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(g gVar) {
        }
    }
}
