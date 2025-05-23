package com.tencent.mobileqq.guild.discover.widget.tab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
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
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
@ViewPager.DecorView
/* loaded from: classes13.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: s0, reason: collision with root package name */
    private static final Pools.Pool<g> f216583s0 = new Pools.SynchronizedPool(16);
    int C;
    int D;
    ColorStateList E;
    ColorStateList F;
    ColorStateList G;

    @NonNull
    Drawable H;
    private int I;
    private int J;
    PorterDuff.Mode K;
    float L;
    float M;
    final int N;
    int P;
    private final int Q;
    private final int R;
    private final int S;
    private int T;
    int U;
    int V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    int f216584a0;

    /* renamed from: b0, reason: collision with root package name */
    boolean f216585b0;

    /* renamed from: c0, reason: collision with root package name */
    boolean f216586c0;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<g> f216587d;

    /* renamed from: d0, reason: collision with root package name */
    int f216588d0;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private g f216589e;

    /* renamed from: e0, reason: collision with root package name */
    int f216590e0;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    final f f216591f;

    /* renamed from: f0, reason: collision with root package name */
    boolean f216592f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.discover.widget.tab.a f216593g0;

    /* renamed from: h, reason: collision with root package name */
    int f216594h;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    private c f216595h0;

    /* renamed from: i, reason: collision with root package name */
    int f216596i;

    /* renamed from: i0, reason: collision with root package name */
    private final ArrayList<c> f216597i0;

    /* renamed from: j0, reason: collision with root package name */
    @Nullable
    private c f216598j0;

    /* renamed from: k0, reason: collision with root package name */
    private ValueAnimator f216599k0;

    /* renamed from: l0, reason: collision with root package name */
    @Nullable
    ViewPager f216600l0;

    /* renamed from: m, reason: collision with root package name */
    int f216601m;

    /* renamed from: m0, reason: collision with root package name */
    @Nullable
    private PagerAdapter f216602m0;

    /* renamed from: n0, reason: collision with root package name */
    private DataSetObserver f216603n0;

    /* renamed from: o0, reason: collision with root package name */
    private h f216604o0;

    /* renamed from: p0, reason: collision with root package name */
    private b f216605p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f216606q0;

    /* renamed from: r0, reason: collision with root package name */
    private final Pools.Pool<TabView> f216607r0;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public @interface LabelVisibility {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes13.dex */
    public @interface Mode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes13.dex */
    public @interface TabGravity {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes13.dex */
    public @interface TabIndicatorAnimationMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes13.dex */
    public @interface TabIndicatorGravity {
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public final class TabView extends LinearLayout {

        @Nullable
        private Drawable C;
        private int D;

        /* renamed from: d, reason: collision with root package name */
        private g f216608d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f216609e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f216610f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        private View f216611h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        private TextView f216612i;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        private ImageView f216613m;

        public TabView(@NonNull Context context) {
            super(context);
            this.D = 2;
            m(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f216594h, TabLayout.this.f216596i, TabLayout.this.f216601m, TabLayout.this.C);
            setGravity(17);
            setOrientation(!TabLayout.this.f216585b0 ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float c(@NonNull Layout layout, int i3, float f16) {
            return layout.getLineWidth(i3) * (f16 / layout.getPaint().getTextSize());
        }

        @NonNull
        private FrameLayout d() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(@NonNull Canvas canvas) {
            Drawable drawable = this.C;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.C.draw(canvas);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void h() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.c.f33274a) {
                frameLayout = d();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.e5m, (ViewGroup) frameLayout, false);
            this.f216610f = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void i() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.c.f33274a) {
                frameLayout = d();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.e5n, (ViewGroup) frameLayout, false);
            this.f216609e = textView;
            frameLayout.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void m(Context context) {
            int i3 = TabLayout.this.N;
            GradientDrawable gradientDrawable = null;
            if (i3 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i3);
                this.C = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.C.setState(getDrawableState());
                }
            } else {
                this.C = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.G != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a16 = h1.b.a(TabLayout.this.G);
                boolean z16 = TabLayout.this.f216592f0;
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

        private void o(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int i3;
            g gVar = this.f216608d;
            if (gVar != null && gVar.f() != null) {
                drawable = DrawableCompat.wrap(this.f216608d.f()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, TabLayout.this.F);
                PorterDuff.Mode mode = TabLayout.this.K;
                if (mode != null) {
                    DrawableCompat.setTintMode(drawable, mode);
                }
            }
            g gVar2 = this.f216608d;
            if (gVar2 != null) {
                charSequence = gVar2.h();
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
                    g gVar3 = this.f216608d;
                    if (gVar3 != null && gVar3.f216635g == 1) {
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
                    i3 = (int) cw.f(8);
                } else {
                    i3 = 0;
                }
                if (TabLayout.this.f216585b0) {
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
            g gVar4 = this.f216608d;
            if (gVar4 != null) {
                CharSequence unused = gVar4.f216632d;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.C;
            boolean z16 = false;
            if (drawable != null && drawable.isStateful()) {
                z16 = false | this.C.setState(drawableState);
            }
            if (z16) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            View[] viewArr = {this.f216609e, this.f216610f, this.f216611h};
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
        public int g() {
            View[] viewArr = {this.f216609e, this.f216610f, this.f216611h};
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

        void j() {
            k(null);
            setSelected(false);
        }

        void k(@Nullable g gVar) {
            if (gVar != this.f216608d) {
                this.f216608d = gVar;
                l();
            }
        }

        final void l() {
            View view;
            boolean z16;
            g gVar = this.f216608d;
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
                this.f216611h = view;
                TextView textView = this.f216609e;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f216610f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f216610f.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(android.R.id.text1);
                this.f216612i = textView2;
                if (textView2 != null) {
                    this.D = TextViewCompat.getMaxLines(textView2);
                }
                this.f216613m = (ImageView) view.findViewById(android.R.id.icon);
            } else {
                View view2 = this.f216611h;
                if (view2 != null) {
                    removeView(view2);
                    this.f216611h = null;
                }
                this.f216612i = null;
                this.f216613m = null;
            }
            if (this.f216611h == null) {
                if (this.f216610f == null) {
                    h();
                }
                if (this.f216609e == null) {
                    i();
                    this.D = TextViewCompat.getMaxLines(this.f216609e);
                }
                TextViewCompat.setTextAppearance(this.f216609e, TabLayout.this.D);
                ColorStateList colorStateList = TabLayout.this.E;
                if (colorStateList != null) {
                    this.f216609e.setTextColor(colorStateList);
                }
                o(this.f216609e, this.f216610f);
            } else {
                TextView textView3 = this.f216612i;
                if (textView3 != null || this.f216613m != null) {
                    o(textView3, this.f216613m);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f216632d)) {
                setContentDescription(gVar.f216632d);
            }
            if (gVar != null && gVar.i()) {
                z16 = true;
            } else {
                z16 = false;
            }
            setSelected(z16);
        }

        final void n() {
            setOrientation(!TabLayout.this.f216585b0 ? 1 : 0);
            TextView textView = this.f216612i;
            if (textView == null && this.f216613m == null) {
                o(this.f216609e, this.f216610f);
            } else {
                o(textView, this.f216613m);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f216608d.g(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i16) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int B = TabLayout.this.B();
            if (B > 0 && (mode == 0 || size > B)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.P, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i16);
            if (this.f216609e != null) {
                float f16 = TabLayout.this.L;
                int i17 = this.D;
                ImageView imageView = this.f216610f;
                boolean z16 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i17 = 1;
                } else {
                    TextView textView = this.f216609e;
                    if (textView != null && textView.getLineCount() > 1) {
                        f16 = TabLayout.this.M;
                    }
                }
                float textSize = this.f216609e.getTextSize();
                int lineCount = this.f216609e.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f216609e);
                if (f16 != textSize || (maxLines >= 0 && i17 != maxLines)) {
                    if (TabLayout.this.f216584a0 == 1 && f16 > textSize && lineCount == 1 && ((layout = this.f216609e.getLayout()) == null || c(layout, 0, f16) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f216609e.setTextSize(0, f16);
                        this.f216609e.setMaxLines(i17);
                        super.onMeasure(i3, i16);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f216608d != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f216608d.k();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            if (isSelected() != z16) {
            }
            super.setSelected(z16);
            TextView textView = this.f216609e;
            if (textView != null) {
                textView.setSelected(z16);
            }
            ImageView imageView = this.f216610f;
            if (imageView != null) {
                imageView.setSelected(z16);
            }
            View view = this.f216611h;
            if (view != null) {
                view.setSelected(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
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
    /* loaded from: classes13.dex */
    public class b implements ViewPager.OnAdapterChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f216615d;

        b() {
        }

        void a(boolean z16) {
            this.f216615d = z16;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f216600l0 == viewPager) {
                tabLayout.O(pagerAdapter2, this.f216615d);
            }
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes13.dex */
    public interface c<T extends g> {
        void Nb(T t16);

        void h8(T t16);

        void mf(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface d extends c<g> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.H();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class f extends LinearLayout {

        /* renamed from: d, reason: collision with root package name */
        ValueAnimator f216618d;

        /* renamed from: e, reason: collision with root package name */
        int f216619e;

        /* renamed from: f, reason: collision with root package name */
        float f216620f;

        /* renamed from: h, reason: collision with root package name */
        private int f216621h;

        /* renamed from: i, reason: collision with root package name */
        private float f216622i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes13.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f216624d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ View f216625e;

            a(View view, View view2) {
                this.f216624d = view;
                this.f216625e = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                f.this.h(this.f216624d, this.f216625e, valueAnimator.getAnimatedFraction());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes13.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f216627d;

            b(int i3) {
                this.f216627d = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.f216619e = this.f216627d;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.f216619e = this.f216627d;
            }
        }

        f(Context context) {
            super(context);
            this.f216619e = -1;
            this.f216621h = -1;
            this.f216622i = 0.0f;
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            View childAt = getChildAt(this.f216619e);
            com.tencent.mobileqq.guild.discover.widget.tab.a aVar = TabLayout.this.f216593g0;
            TabLayout tabLayout = TabLayout.this;
            aVar.f(tabLayout, childAt, tabLayout.H);
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
                com.tencent.mobileqq.guild.discover.widget.tab.a aVar = TabLayout.this.f216593g0;
                TabLayout tabLayout = TabLayout.this;
                aVar.e(tabLayout, view, view2, f16, tabLayout.H);
                this.f216622i = f16;
            } else {
                Drawable drawable = TabLayout.this.H;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.H.getBounds().bottom);
                this.f216622i = 0.0f;
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        private void i(boolean z16, int i3, int i16) {
            View childAt = getChildAt(this.f216619e);
            View childAt2 = getChildAt(i3);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z16) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f216618d = valueAnimator;
                valueAnimator.setInterpolator(x0.a.f446811b);
                valueAnimator.setDuration(i16);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i3));
                valueAnimator.start();
                return;
            }
            this.f216618d.removeAllUpdateListeners();
            this.f216618d.addUpdateListener(aVar);
        }

        void c(int i3, int i16) {
            ValueAnimator valueAnimator = this.f216618d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f216618d.cancel();
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
            int i3 = TabLayout.this.W;
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
            ValueAnimator valueAnimator = this.f216618d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f216618d.cancel();
            }
            this.f216619e = i3;
            this.f216620f = f16;
            h(getChildAt(i3), getChildAt(this.f216619e + 1), this.f216620f);
        }

        void g(int i3) {
            Rect bounds = TabLayout.this.H.getBounds();
            TabLayout.this.H.setBounds(bounds.left, 0, bounds.right, i3);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            ValueAnimator valueAnimator = this.f216618d;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                i(false, this.f216619e, -1);
                return;
            }
            TabLayout.this.H.getBounds();
            if (this.f216622i == 0.0f) {
                e();
                return;
            }
            QLog.i("TabLayout", 2, "onLayout lastFraction=" + this.f216622i);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z16 = true;
            if (tabLayout.U == 1 || tabLayout.f216584a0 == 2) {
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
                if (i17 * childCount <= getMeasuredWidth() - (((int) cw.f(16)) * 2)) {
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
                    tabLayout2.U = 0;
                    tabLayout2.T(false);
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
    /* loaded from: classes13.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private Object f216629a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private Drawable f216630b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private CharSequence f216631c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private CharSequence f216632d;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private View f216634f;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public TabLayout f216636h;

        /* renamed from: i, reason: collision with root package name */
        public TabView f216637i;

        /* renamed from: e, reason: collision with root package name */
        private int f216633e = -1;

        /* renamed from: g, reason: collision with root package name */
        @LabelVisibility
        private int f216635g = 1;

        /* renamed from: j, reason: collision with root package name */
        private int f216638j = -1;

        @Nullable
        public View e() {
            return this.f216634f;
        }

        @Nullable
        public Drawable f() {
            return this.f216630b;
        }

        public int g() {
            return this.f216633e;
        }

        @Nullable
        public CharSequence h() {
            return this.f216631c;
        }

        public boolean i() {
            TabLayout tabLayout = this.f216636h;
            if (tabLayout != null) {
                int y16 = tabLayout.y();
                if (y16 != -1 && y16 == this.f216633e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void j() {
            this.f216636h = null;
            this.f216637i = null;
            this.f216629a = null;
            this.f216630b = null;
            this.f216638j = -1;
            this.f216631c = null;
            this.f216632d = null;
            this.f216633e = -1;
            this.f216634f = null;
        }

        public void k() {
            TabLayout tabLayout = this.f216636h;
            if (tabLayout != null) {
                tabLayout.M(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public g l(@Nullable CharSequence charSequence) {
            this.f216632d = charSequence;
            r();
            return this;
        }

        @NonNull
        public g m(@LayoutRes int i3) {
            return n(LayoutInflater.from(this.f216637i.getContext()).inflate(i3, (ViewGroup) this.f216637i, false));
        }

        @NonNull
        public g n(@Nullable View view) {
            this.f216634f = view;
            r();
            return this;
        }

        @NonNull
        public g o(@Nullable Drawable drawable) {
            this.f216630b = drawable;
            TabLayout tabLayout = this.f216636h;
            if (tabLayout.U == 1 || tabLayout.f216584a0 == 2) {
                tabLayout.T(true);
            }
            r();
            return this;
        }

        void p(int i3) {
            this.f216633e = i3;
        }

        @NonNull
        public g q(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f216632d) && !TextUtils.isEmpty(charSequence)) {
                this.f216637i.setContentDescription(charSequence);
            }
            this.f216631c = charSequence;
            r();
            return this;
        }

        void r() {
            TabView tabView = this.f216637i;
            if (tabView != null) {
                tabView.l();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class h implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private final WeakReference<TabLayout> f216639d;

        /* renamed from: e, reason: collision with root package name */
        private int f216640e;

        /* renamed from: f, reason: collision with root package name */
        private int f216641f;

        public h(TabLayout tabLayout) {
            this.f216639d = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f216641f = 0;
            this.f216640e = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f216640e = this.f216641f;
            this.f216641f = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            TabLayout tabLayout = this.f216639d.get();
            if (tabLayout != null) {
                int i17 = this.f216641f;
                boolean z17 = false;
                if (i17 == 2 && this.f216640e != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f216640e != 0) {
                    z17 = true;
                }
                tabLayout.setScrollPosition(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            TabLayout tabLayout = this.f216639d.get();
            if (tabLayout != null && tabLayout.y() != i3 && i3 < tabLayout.A()) {
                int i16 = this.f216641f;
                if (i16 != 0 && (i16 != 2 || this.f216640e != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                tabLayout.N(tabLayout.z(i3), z16);
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private int C() {
        int i3 = this.Q;
        if (i3 != -1) {
            return i3;
        }
        int i16 = this.f216584a0;
        if (i16 != 0 && i16 != 2) {
            return 0;
        }
        return this.S;
    }

    private int D() {
        return Math.max(0, ((this.f216591f.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void L(int i3) {
        TabView tabView = (TabView) this.f216591f.getChildAt(i3);
        this.f216591f.removeViewAt(i3);
        if (tabView != null) {
            tabView.j();
            this.f216607r0.release(tabView);
        }
        requestLayout();
    }

    private void P(int i3) {
        boolean z16;
        int childCount = this.f216591f.getChildCount();
        if (i3 < childCount) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = this.f216591f.getChildAt(i16);
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

    private void Q(@Nullable ViewPager viewPager, boolean z16, boolean z17) {
        ViewPager viewPager2 = this.f216600l0;
        if (viewPager2 != null) {
            h hVar = this.f216604o0;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f216605p0;
            if (bVar != null) {
                this.f216600l0.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f216598j0;
        if (cVar != null) {
            K(cVar);
            this.f216598j0 = null;
        }
        if (viewPager != null) {
            this.f216600l0 = viewPager;
            if (this.f216604o0 == null) {
                this.f216604o0 = new h(this);
            }
            this.f216604o0.a();
            viewPager.addOnPageChangeListener(this.f216604o0);
            i iVar = new i(viewPager);
            this.f216598j0 = iVar;
            c(iVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                O(adapter, z16);
            }
            if (this.f216605p0 == null) {
                this.f216605p0 = new b();
            }
            this.f216605p0.a(z16);
            viewPager.addOnAdapterChangeListener(this.f216605p0);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f216600l0 = null;
            O(null, false);
        }
        this.f216606q0 = z17;
    }

    private void R() {
        int size = this.f216587d.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f216587d.get(i3).r();
        }
    }

    private void S(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.f216584a0 == 1 && this.U == 0) {
            layoutParams.width = -2;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private void h(@NonNull TabItem tabItem) {
        g G = G();
        CharSequence charSequence = tabItem.f34230d;
        if (charSequence != null) {
            G.q(charSequence);
        }
        Drawable drawable = tabItem.f34231e;
        if (drawable != null) {
            G.o(drawable);
        }
        int i3 = tabItem.f34232f;
        if (i3 != 0) {
            G.m(i3);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            G.l(tabItem.getContentDescription());
        }
        e(G);
    }

    private void i(@NonNull g gVar) {
        TabView tabView = gVar.f216637i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f216591f.addView(tabView, gVar.g(), q(tabView));
    }

    private void j(View view) {
        if (view instanceof TabItem) {
            h((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void k(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f216591f.d()) {
            int scrollX = getScrollX();
            int n3 = n(i3, 0.0f);
            if (scrollX != n3) {
                w();
                this.f216599k0.setIntValues(scrollX, n3);
                this.f216599k0.start();
            }
            this.f216591f.c(i3, this.V);
            return;
        }
        setScrollPosition(i3, 0.0f, true);
    }

    private void l(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
            } else {
                this.f216591f.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f216591f.setGravity(8388611);
    }

    private void m() {
        int max;
        int i3 = this.f216584a0;
        if (i3 != 0 && i3 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.T - this.f216594h);
        }
        ViewCompat.setPaddingRelative(this.f216591f, max, 0, 0, 0);
        int i16 = this.f216584a0;
        if (i16 != 0) {
            if (i16 == 1 || i16 == 2) {
                if (this.U == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f216591f.setGravity(1);
            }
        } else {
            l(this.U);
        }
        T(true);
    }

    private int n(int i3, float f16) {
        View childAt;
        View view;
        int i16 = this.f216584a0;
        int i17 = 0;
        if ((i16 != 0 && i16 != 2) || (childAt = this.f216591f.getChildAt(i3)) == null) {
            return 0;
        }
        int i18 = i3 + 1;
        if (i18 < this.f216591f.getChildCount()) {
            view = this.f216591f.getChildAt(i18);
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

    private void o(@NonNull g gVar, int i3) {
        gVar.p(i3);
        this.f216587d.add(i3, gVar);
        int size = this.f216587d.size();
        while (true) {
            i3++;
            if (i3 < size) {
                this.f216587d.get(i3).p(i3);
            } else {
                return;
            }
        }
    }

    @NonNull
    private static ColorStateList p(int i3, int i16) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i16, i3});
    }

    @NonNull
    private LinearLayout.LayoutParams q(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.rightMargin = layoutParams2.rightMargin;
            layoutParams.leftMargin = layoutParams2.leftMargin;
            layoutParams.topMargin = layoutParams2.topMargin;
            layoutParams.bottomMargin = layoutParams2.bottomMargin;
        }
        S(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView s(@NonNull g gVar) {
        TabView tabView;
        Pools.Pool<TabView> pool = this.f216607r0;
        if (pool != null) {
            tabView = pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.k(gVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(C());
        if (TextUtils.isEmpty(gVar.f216632d)) {
            tabView.setContentDescription(gVar.f216631c);
        } else {
            tabView.setContentDescription(gVar.f216632d);
        }
        return tabView;
    }

    private void t(@NonNull g gVar) {
        for (int size = this.f216597i0.size() - 1; size >= 0; size--) {
            this.f216597i0.get(size).h8(gVar);
        }
    }

    private void u(@NonNull g gVar) {
        for (int size = this.f216597i0.size() - 1; size >= 0; size--) {
            this.f216597i0.get(size).mf(gVar);
        }
    }

    private void v(@NonNull g gVar) {
        for (int size = this.f216597i0.size() - 1; size >= 0; size--) {
            this.f216597i0.get(size).Nb(gVar);
        }
    }

    private void w() {
        if (this.f216599k0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f216599k0 = valueAnimator;
            valueAnimator.setInterpolator(x0.a.f446811b);
            this.f216599k0.setDuration(this.V);
            this.f216599k0.addUpdateListener(new a());
        }
    }

    @Dimension(unit = 0)
    private int x() {
        int size = this.f216587d.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                g gVar = this.f216587d.get(i3);
                if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.h())) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (z16 && !this.f216585b0) {
            return 72;
        }
        return 48;
    }

    public int A() {
        return this.f216587d.size();
    }

    int B() {
        return this.P;
    }

    public int E() {
        return this.J;
    }

    public boolean F() {
        return this.f216586c0;
    }

    @NonNull
    public g G() {
        g r16 = r();
        r16.f216636h = this;
        r16.f216637i = s(r16);
        if (r16.f216638j != -1) {
            r16.f216637i.setId(r16.f216638j);
        }
        return r16;
    }

    void H() {
        int currentItem;
        J();
        PagerAdapter pagerAdapter = this.f216602m0;
        if (pagerAdapter != null) {
            int f373114d = pagerAdapter.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                g(G().q(this.f216602m0.getPageTitle(i3)), false);
            }
            ViewPager viewPager = this.f216600l0;
            if (viewPager != null && f373114d > 0 && (currentItem = viewPager.getCurrentItem()) != y() && currentItem < A()) {
                M(z(currentItem));
            }
        }
    }

    protected boolean I(g gVar) {
        return f216583s0.release(gVar);
    }

    public void J() {
        for (int childCount = this.f216591f.getChildCount() - 1; childCount >= 0; childCount--) {
            L(childCount);
        }
        Iterator<g> it = this.f216587d.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.j();
            I(next);
        }
        this.f216589e = null;
    }

    @Deprecated
    public void K(@Nullable c cVar) {
        this.f216597i0.remove(cVar);
    }

    public void M(@Nullable g gVar) {
        N(gVar, true);
    }

    public void N(@Nullable g gVar, boolean z16) {
        int i3;
        g gVar2 = this.f216589e;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                t(gVar);
                k(gVar.g());
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
                k(i3);
            }
            if (i3 != -1) {
                P(i3);
            }
        }
        this.f216589e = gVar;
        if (gVar2 != null) {
            v(gVar2);
        }
        if (gVar != null) {
            u(gVar);
        }
    }

    void O(@Nullable PagerAdapter pagerAdapter, boolean z16) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f216602m0;
        if (pagerAdapter2 != null && (dataSetObserver = this.f216603n0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f216602m0 = pagerAdapter;
        if (z16 && pagerAdapter != null) {
            if (this.f216603n0 == null) {
                this.f216603n0 = new e();
            }
            pagerAdapter.registerDataSetObserver(this.f216603n0);
        }
        H();
    }

    void T(boolean z16) {
        for (int i3 = 0; i3 < this.f216591f.getChildCount(); i3++) {
            View childAt = this.f216591f.getChildAt(i3);
            childAt.setMinimumWidth(C());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z16) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        j(view);
    }

    @Deprecated
    public void c(@Nullable c cVar) {
        if (!this.f216597i0.contains(cVar)) {
            this.f216597i0.add(cVar);
        }
    }

    public void d(@NonNull d dVar) {
        c(dVar);
    }

    public void e(@NonNull g gVar) {
        g(gVar, this.f216587d.isEmpty());
    }

    public void f(@NonNull g gVar, int i3, boolean z16) {
        if (gVar.f216636h == this) {
            o(gVar, i3);
            i(gVar);
            if (z16) {
                gVar.k();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void g(@NonNull g gVar, boolean z16) {
        f(gVar, this.f216587d.size(), z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.e(this);
        if (this.f216600l0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                Q((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f216606q0) {
            setupWithViewPager(null);
            this.f216606q0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i3 = 0; i3 < this.f216591f.getChildCount(); i3++) {
            View childAt = this.f216591f.getChildAt(i3);
            if (childAt instanceof TabView) {
                ((TabView) childAt).e(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, A(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
    
        if (r0 != 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L29;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int round = Math.round(cw.f(x()));
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
            int i17 = this.R;
            if (i17 <= 0) {
                i17 = (int) (size - cw.f(56));
            }
            this.P = i17;
        }
        super.onMeasure(i3, i16);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i18 = this.f216584a0;
            if (i18 != 0) {
                if (i18 != 1) {
                }
                if (z16) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
        }
    }

    protected g r() {
        g acquire = f216583s0.acquire();
        if (acquire == null) {
            return new g();
        }
        return acquire;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        com.google.android.material.shape.d.d(this, f16);
    }

    public void setInlineLabel(boolean z16) {
        if (this.f216585b0 != z16) {
            this.f216585b0 = z16;
            for (int i3 = 0; i3 < this.f216591f.getChildCount(); i3++) {
                View childAt = this.f216591f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).n();
                }
            }
            m();
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
            int i3 = this.f216588d0;
            if (i3 == -1) {
                i3 = drawable.getIntrinsicHeight();
            }
            this.f216591f.g(i3);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i3) {
        this.I = i3;
        T(false);
    }

    public void setSelectedTabIndicatorGravity(int i3) {
        if (this.W != i3) {
            this.W = i3;
            ViewCompat.postInvalidateOnAnimation(this.f216591f);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i3) {
        this.f216588d0 = i3;
        this.f216591f.g(i3);
    }

    public void setTabGravity(int i3) {
        if (this.U != i3) {
            this.U = i3;
            m();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            R();
        }
    }

    public void setTabIconTintResource(@ColorRes int i3) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setTabIndicatorAnimationDuration(int i3) {
        this.V = i3;
    }

    public void setTabIndicatorAnimationMode(int i3) {
        this.f216590e0 = i3;
        if (i3 == 0) {
            this.f216593g0 = new com.tencent.mobileqq.guild.discover.widget.tab.a();
            return;
        }
        throw new IllegalArgumentException(i3 + " is not a valid TabIndicatorAnimationMode");
    }

    public void setTabIndicatorFullWidth(boolean z16) {
        this.f216586c0 = z16;
        this.f216591f.e();
        ViewCompat.postInvalidateOnAnimation(this.f216591f);
    }

    public void setTabMode(int i3) {
        if (i3 != this.f216584a0) {
            this.f216584a0 = i3;
            m();
        }
    }

    public void setTabPadding(int i3, int i16, int i17, int i18) {
        this.f216594h = i3;
        this.f216596i = i16;
        this.f216601m = i17;
        this.C = i18;
        for (int i19 = 0; i19 < this.f216587d.size(); i19++) {
            ViewCompat.setPaddingRelative(this.f216587d.get(i19).f216637i, i3, i16, i17, i18);
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            for (int i3 = 0; i3 < this.f216591f.getChildCount(); i3++) {
                View childAt = this.f216591f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).m(getContext());
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
            R();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        O(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z16) {
        if (this.f216592f0 != z16) {
            this.f216592f0 = z16;
            for (int i3 = 0; i3 < this.f216591f.getChildCount(); i3++) {
                View childAt = this.f216591f.getChildAt(i3);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).m(getContext());
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
        if (D() > 0) {
            return true;
        }
        return false;
    }

    public int y() {
        g gVar = this.f216589e;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    @Nullable
    public g z(int i3) {
        if (i3 >= 0 && i3 < A()) {
            return this.f216587d.get(i3);
        }
        return null;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3) {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.f216595h0;
        if (cVar2 != null) {
            K(cVar2);
        }
        this.f216595h0 = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollPosition(int i3, float f16, boolean z16, boolean z17) {
        int round = Math.round(i3 + f16);
        if (round < 0 || round >= this.f216591f.getChildCount()) {
            return;
        }
        if (z17) {
            this.f216591f.f(i3, f16);
        }
        ValueAnimator valueAnimator = this.f216599k0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f216599k0.cancel();
        }
        scrollTo(i3 < 0 ? 0 : n(i3, f16), 0);
        if (z16) {
            P(round);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z16) {
        Q(viewPager, z16, false);
    }

    @SuppressLint({"RestrictedApi"})
    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f216587d = new ArrayList<>();
        this.H = new GradientDrawable();
        this.I = 0;
        this.J = -1;
        this.P = Integer.MAX_VALUE;
        this.f216588d0 = -1;
        this.f216597i0 = new ArrayList<>();
        this.f216607r0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.f216591f = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, up1.a.f439727xb);
        int i16 = up1.a.f439740yb;
        if (obtainStyledAttributes.hasValue(i16)) {
            setSelectedTabIndicator(obtainStyledAttributes.getDrawable(i16));
        } else {
            setSelectedTabIndicator(getResources().getDrawable(R.drawable.guild_default_tab_indicator));
        }
        setSelectedTabIndicatorColor(obtainStyledAttributes.getColor(up1.a.f439753zb, SupportMenu.CATEGORY_MASK));
        fVar.g(obtainStyledAttributes.getDimensionPixelSize(up1.a.Cb, (int) cw.b(6)));
        this.J = obtainStyledAttributes.getDimensionPixelSize(up1.a.Db, -1);
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(up1.a.Bb, 0));
        setTabIndicatorAnimationMode(0);
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(up1.a.Ab, true));
        this.C = 0;
        this.f216601m = 0;
        this.f216596i = 0;
        this.f216594h = 0;
        this.f216594h = obtainStyledAttributes.getDimensionPixelSize(up1.a.Ib, 0);
        this.f216601m = obtainStyledAttributes.getDimensionPixelSize(up1.a.Hb, 0);
        this.L = obtainStyledAttributes.getDimensionPixelSize(up1.a.Mb, (int) cw.g(20));
        int i17 = up1.a.Lb;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.E = obtainStyledAttributes.getColorStateList(i17);
        } else {
            this.E = getResources().getColorStateList(R.color.f157167bu3);
        }
        int i18 = up1.a.Kb;
        if (obtainStyledAttributes.hasValue(i18)) {
            this.E = p(this.E.getDefaultColor(), obtainStyledAttributes.getColor(i18, SupportMenu.CATEGORY_MASK));
        } else {
            this.E = p(this.E.getDefaultColor(), SupportMenu.CATEGORY_MASK);
        }
        this.F = getResources().getColorStateList(R.color.f157167bu3);
        this.K = PorterDuff.Mode.SRC_IN;
        int i19 = up1.a.Jb;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.G = obtainStyledAttributes.getColorStateList(i19);
        } else {
            this.G = getResources().getColorStateList(R.color.f157167bu3);
        }
        this.V = 300;
        this.Q = obtainStyledAttributes.getDimensionPixelSize(up1.a.Fb, -1);
        this.R = obtainStyledAttributes.getDimensionPixelSize(up1.a.Eb, -1);
        this.N = 0;
        this.T = 0;
        this.f216584a0 = obtainStyledAttributes.getInt(up1.a.Gb, 1);
        this.U = 0;
        this.f216585b0 = false;
        this.f216592f0 = false;
        this.M = 20.0f;
        this.S = 80;
        obtainStyledAttributes.recycle();
        m();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setTabTextColors(int i3, int i16) {
        setTabTextColors(p(i3, i16));
    }

    public void setSelectedTabIndicator(@DrawableRes int i3) {
        if (i3 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i3));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class i implements d {

        /* renamed from: d, reason: collision with root package name */
        private final ViewPager f216642d;

        public i(ViewPager viewPager) {
            this.f216642d = viewPager;
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void mf(@NonNull g gVar) {
            this.f216642d.setCurrentItem(gVar.g());
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void Nb(g gVar) {
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
        public void h8(g gVar) {
        }
    }
}
