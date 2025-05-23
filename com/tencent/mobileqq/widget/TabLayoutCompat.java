package com.tencent.mobileqq.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Pools;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabLayoutCompat extends HorizontalScrollView {

    /* renamed from: g0, reason: collision with root package name */
    private static final Pools.Pool<f> f316408g0 = new Pools.SynchronizedPool(16);

    /* renamed from: h0, reason: collision with root package name */
    private static final int[] f316409h0 = {R.attr.textSize, R.attr.textColor};
    int C;
    int D;
    ColorStateList E;
    float F;
    float G;
    int H;
    int I;
    private int J;
    private final int K;
    private int L;
    private int M;
    private int N;
    int P;
    int Q;
    private c R;
    private final ArrayList<c> S;
    private c T;
    private ValueAnimator U;
    ViewPagerCompat V;
    private PagerAdapter W;

    /* renamed from: a0, reason: collision with root package name */
    private d f316410a0;

    /* renamed from: b0, reason: collision with root package name */
    private g f316411b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f316412c0;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<f> f316413d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f316414d0;

    /* renamed from: e, reason: collision with root package name */
    private f f316415e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f316416e0;

    /* renamed from: f, reason: collision with root package name */
    private final e f316417f;

    /* renamed from: f0, reason: collision with root package name */
    private final Pools.Pool<h> f316418f0;

    /* renamed from: h, reason: collision with root package name */
    int f316419h;

    /* renamed from: i, reason: collision with root package name */
    int f316420i;

    /* renamed from: m, reason: collision with root package name */
    int f316421m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes20.dex */
    public @interface Mode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes20.dex */
    public @interface TabGravity {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayoutCompat.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ViewPagerCompat.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f316423a;

        b() {
        }

        void a(boolean z16) {
            this.f316423a = z16;
        }

        @Override // com.tencent.mobileqq.widget.ViewPagerCompat.a
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayoutCompat tabLayoutCompat = TabLayoutCompat.this;
            if (tabLayoutCompat.V == viewPager) {
                tabLayoutCompat.N(pagerAdapter2, this.f316423a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void J8(f fVar);

        void c(f fVar);

        void l3(f fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private boolean f316425a;

        d() {
        }

        void a() {
            int currentItem;
            TabLayoutCompat tabLayoutCompat = TabLayoutCompat.this;
            if (tabLayoutCompat.V != null && tabLayoutCompat.f316417f != null && TabLayoutCompat.this.y() == (currentItem = TabLayoutCompat.this.V.getCurrentItem())) {
                TabLayoutCompat.this.f316417f.a(currentItem, 300);
            }
            if (TabLayoutCompat.this.f316411b0 != null) {
                TabLayoutCompat.this.f316411b0.a();
            }
        }

        void b(boolean z16) {
            this.f316425a = z16;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.f316425a) {
                TabLayoutCompat.this.F();
            } else {
                a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            if (this.f316425a) {
                TabLayoutCompat.this.F();
            } else {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends LinearLayout {
        private int C;
        private ValueAnimator D;
        private int E;
        private int F;
        private int G;

        /* renamed from: d, reason: collision with root package name */
        private int f316427d;

        /* renamed from: e, reason: collision with root package name */
        private final Paint f316428e;

        /* renamed from: f, reason: collision with root package name */
        int f316429f;

        /* renamed from: h, reason: collision with root package name */
        float f316430h;

        /* renamed from: i, reason: collision with root package name */
        private int f316431i;

        /* renamed from: m, reason: collision with root package name */
        private int f316432m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f316433d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f316434e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f316435f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f316436h;

            a(int i3, int i16, int i17, int i18) {
                this.f316433d = i3;
                this.f316434e = i16;
                this.f316435f = i17;
                this.f316436h = i18;
            }

            int a(int i3, int i16, float f16) {
                return i3 + Math.round(f16 * (i16 - i3));
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.c(a(this.f316433d, this.f316434e, animatedFraction), a(this.f316435f, this.f316436h, animatedFraction));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f316438d;

            b(int i3) {
                this.f316438d = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar = e.this;
                eVar.f316429f = this.f316438d;
                eVar.f316430h = 0.0f;
            }
        }

        e(Context context) {
            super(context);
            this.f316429f = -1;
            this.f316431i = -1;
            this.f316432m = -1;
            this.C = -1;
            setWillNotDraw(false);
            this.f316428e = new Paint();
        }

        private void j() {
            int i3;
            int i16;
            View childAt = getChildAt(this.f316429f);
            if (childAt != null && childAt.getWidth() > 0) {
                i3 = childAt.getLeft();
                i16 = childAt.getRight();
                if (this.f316430h > 0.0f && this.f316429f < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f316429f + 1);
                    float left = this.f316430h * childAt2.getLeft();
                    float f16 = this.f316430h;
                    i3 = (int) (left + ((1.0f - f16) * i3));
                    i16 = (int) ((f16 * childAt2.getRight()) + ((1.0f - this.f316430h) * i16));
                }
            } else {
                i3 = -1;
                i16 = -1;
            }
            c(i3, i16);
        }

        void a(int i3, int i16) {
            boolean z16;
            int i17;
            int i18;
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
            }
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            View childAt = getChildAt(i3);
            if (childAt == null) {
                j();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i3 - this.f316429f) <= 1) {
                i17 = this.f316432m;
                i18 = this.C;
            } else {
                int v3 = TabLayoutCompat.this.v(24);
                if (i3 >= this.f316429f ? z16 : !z16) {
                    i17 = v3 + right;
                } else {
                    i17 = left - v3;
                }
                i18 = i17;
            }
            if (i17 != left || i18 != right) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.D = valueAnimator2;
                valueAnimator2.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimator2.setDuration(i16);
                valueAnimator2.setFloatValues(0.0f, 1.0f);
                valueAnimator2.addUpdateListener(new a(i17, left, i18, right));
                valueAnimator2.addListener(new b(i3));
                valueAnimator2.start();
            }
        }

        boolean b() {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        void c(int i3, int i16) {
            if (i3 != this.f316432m || i16 != this.C) {
                this.f316432m = i3;
                this.C = i16;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void d(int i3, float f16) {
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
            }
            this.f316429f = i3;
            this.f316430h = f16;
            j();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            int i3 = this.f316432m;
            if (i3 >= 0 && this.C > i3) {
                canvas.drawRect(i3 + this.E, (getHeight() - this.f316427d) - this.G, this.C - this.F, getHeight() - this.G, this.f316428e);
            }
        }

        void e(int i3) {
            if (this.f316428e.getColor() != i3) {
                this.f316428e.setColor(i3);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void f(int i3) {
            if (this.f316427d != i3) {
                this.f316427d = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void g(int i3) {
            if (this.G != i3) {
                this.G = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void h(int i3) {
            if (this.E != i3) {
                this.E = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void i(int i3) {
            if (this.F != i3) {
                this.F = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
                a(this.f316429f, Math.round((1.0f - this.D.getAnimatedFraction()) * ((float) this.D.getDuration())));
                return;
            }
            j();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            if (View.MeasureSpec.getMode(i3) != 1073741824) {
                return;
            }
            TabLayoutCompat tabLayoutCompat = TabLayoutCompat.this;
            boolean z16 = true;
            if (tabLayoutCompat.Q == 1 && tabLayoutCompat.P == 1) {
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
                if (i17 * childCount <= getMeasuredWidth() - (TabLayoutCompat.this.v(16) * 2)) {
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
                    TabLayoutCompat tabLayoutCompat2 = TabLayoutCompat.this;
                    tabLayoutCompat2.P = 0;
                    tabLayoutCompat2.T(false);
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
    /* loaded from: classes20.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private Object f316440a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f316441b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f316442c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f316443d;

        /* renamed from: e, reason: collision with root package name */
        private int f316444e = -1;

        /* renamed from: f, reason: collision with root package name */
        private View f316445f;

        /* renamed from: g, reason: collision with root package name */
        TabLayoutCompat f316446g;

        /* renamed from: h, reason: collision with root package name */
        h f316447h;

        f() {
        }

        @Nullable
        public CharSequence a() {
            return this.f316443d;
        }

        @Nullable
        public View b() {
            return this.f316445f;
        }

        @Nullable
        public Drawable c() {
            return this.f316441b;
        }

        public int d() {
            return this.f316444e;
        }

        public View e() {
            return this.f316447h;
        }

        @Nullable
        public Object f() {
            return this.f316440a;
        }

        @Nullable
        public CharSequence g() {
            return this.f316442c;
        }

        public boolean h() {
            TabLayoutCompat tabLayoutCompat = this.f316446g;
            if (tabLayoutCompat != null) {
                if (tabLayoutCompat.y() == this.f316444e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void i() {
            this.f316446g = null;
            this.f316447h = null;
            this.f316440a = null;
            this.f316441b = null;
            this.f316442c = null;
            this.f316443d = null;
            this.f316444e = -1;
            this.f316445f = null;
        }

        public void j() {
            TabLayoutCompat tabLayoutCompat = this.f316446g;
            if (tabLayoutCompat != null) {
                tabLayoutCompat.K(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void k() {
            TabLayoutCompat tabLayoutCompat = this.f316446g;
            if (tabLayoutCompat != null) {
                tabLayoutCompat.M(this, true);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f l(int i3) {
            return m(LayoutInflater.from(this.f316447h.getContext()).inflate(i3, (ViewGroup) this.f316447h, false));
        }

        @NonNull
        public f m(@Nullable View view) {
            this.f316445f = view;
            q();
            return this;
        }

        void n(int i3) {
            this.f316444e = i3;
        }

        @NonNull
        public f o(@Nullable Object obj) {
            this.f316440a = obj;
            return this;
        }

        @NonNull
        public f p(@Nullable CharSequence charSequence) {
            this.f316442c = charSequence;
            q();
            return this;
        }

        void q() {
            h hVar = this.f316447h;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TabLayoutCompat> f316448d;

        /* renamed from: e, reason: collision with root package name */
        private int f316449e;

        /* renamed from: f, reason: collision with root package name */
        private int f316450f;

        public g(TabLayoutCompat tabLayoutCompat) {
            this.f316448d = new WeakReference<>(tabLayoutCompat);
        }

        void a() {
            this.f316450f = 0;
            this.f316449e = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f316449e = this.f316450f;
            this.f316450f = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            TabLayoutCompat tabLayoutCompat = this.f316448d.get();
            if (tabLayoutCompat != null) {
                int i17 = this.f316450f;
                boolean z17 = false;
                if (i17 == 2 && this.f316449e != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f316449e != 0) {
                    z17 = true;
                }
                tabLayoutCompat.O(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            TabLayoutCompat tabLayoutCompat = this.f316448d.get();
            if (tabLayoutCompat != null && tabLayoutCompat.y() != i3 && i3 < tabLayoutCompat.A()) {
                int i16 = this.f316450f;
                if (i16 != 0 && (i16 != 2 || this.f316449e != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                f unused = tabLayoutCompat.f316415e;
                tabLayoutCompat.L(tabLayoutCompat.z(i3), z16);
                tabLayoutCompat.z(i3);
                TabLayoutCompat.f(tabLayoutCompat);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h extends LinearLayout {
        private int C;

        /* renamed from: d, reason: collision with root package name */
        private f f316451d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f316452e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f316453f;

        /* renamed from: h, reason: collision with root package name */
        private View f316454h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f316455i;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f316456m;

        public h(Context context) {
            super(context);
            this.C = 2;
            if (TabLayoutCompat.this.H != 0) {
                setBackgroundDrawable(context.getResources().getDrawable(TabLayoutCompat.this.H));
            }
            ViewCompat.setPaddingRelative(this, TabLayoutCompat.this.f316419h, TabLayoutCompat.this.f316420i, TabLayoutCompat.this.f316421m, TabLayoutCompat.this.C);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        private float b(Layout layout, int i3, float f16) {
            return layout.getLineWidth(i3) * (f16 / layout.getPaint().getTextSize());
        }

        private void f(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            f fVar = this.f316451d;
            if (fVar != null) {
                drawable = fVar.c();
            } else {
                drawable = null;
            }
            f fVar2 = this.f316451d;
            if (fVar2 != null) {
                charSequence = fVar2.g();
            } else {
                charSequence = null;
            }
            f fVar3 = this.f316451d;
            if (fVar3 != null) {
                charSequence2 = fVar3.a();
            } else {
                charSequence2 = null;
            }
            int i3 = 0;
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            boolean z16 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z16) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z16 && imageView.getVisibility() == 0) {
                    i3 = TabLayoutCompat.this.v(8);
                }
                if (i3 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i3;
                    imageView.requestLayout();
                }
            }
        }

        void c() {
            d(null);
            setSelected(false);
        }

        void d(@Nullable f fVar) {
            if (fVar != this.f316451d) {
                this.f316451d = fVar;
                e();
            }
        }

        final void e() {
            View view;
            TextView textView;
            f fVar = this.f316451d;
            if (fVar != null) {
                view = fVar.b();
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
                this.f316454h = view;
                TextView textView2 = this.f316452e;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.f316453f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f316453f.setImageDrawable(null);
                }
                TextView textView3 = (TextView) view.findViewById(R.id.text1);
                this.f316455i = textView3;
                if (textView3 != null) {
                    this.C = textView3.getMaxLines();
                }
                this.f316456m = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view2 = this.f316454h;
                if (view2 != null) {
                    removeView(view2);
                    this.f316454h = null;
                }
                this.f316455i = null;
                this.f316456m = null;
            }
            boolean z16 = true;
            if (this.f316454h == null) {
                if (this.f316453f == null) {
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(48, 48));
                    addView(imageView2, 0);
                    this.f316453f = imageView2;
                }
                if (this.f316452e == null) {
                    TextView textView4 = new TextView(getContext());
                    textView4.setMaxLines(2);
                    textView4.setGravity(1);
                    textView4.setEllipsize(TextUtils.TruncateAt.END);
                    textView4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    addView(textView4);
                    this.f316452e = textView4;
                    this.C = textView4.getMaxLines();
                }
                TextView textView5 = this.f316452e;
                textView5.setTextAppearance(textView5.getContext(), TabLayoutCompat.this.D);
                ColorStateList colorStateList = TabLayoutCompat.this.E;
                if (colorStateList != null) {
                    this.f316452e.setTextColor(colorStateList);
                }
                f(this.f316452e, this.f316453f);
            } else {
                if (TabLayoutCompat.this.f316416e0 && TabLayoutCompat.this.E != null && (textView = this.f316455i) != null) {
                    textView.setTextAppearance(textView.getContext(), TabLayoutCompat.this.D);
                    this.f316455i.setTextColor(TabLayoutCompat.this.E);
                }
                TextView textView6 = this.f316455i;
                if (textView6 != null || this.f316456m != null) {
                    f(textView6, this.f316456m);
                }
            }
            if (fVar == null || !fVar.h()) {
                z16 = false;
            }
            setSelected(z16);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i3, int i16) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int B = TabLayoutCompat.this.B();
            if (B > 0 && (mode == 0 || size > B)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayoutCompat.this.I, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i16);
            if (this.f316452e != null) {
                getResources();
                float f16 = TabLayoutCompat.this.F;
                int i17 = this.C;
                ImageView imageView = this.f316453f;
                boolean z16 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i17 = 1;
                } else {
                    TextView textView = this.f316452e;
                    if (textView != null && textView.getLineCount() > 1) {
                        f16 = TabLayoutCompat.this.G;
                    }
                }
                float textSize = this.f316452e.getTextSize();
                int lineCount = this.f316452e.getLineCount();
                int maxLines = this.f316452e.getMaxLines();
                if (f16 != textSize || (maxLines >= 0 && i17 != maxLines)) {
                    if (TabLayoutCompat.this.Q == 1 && f16 > textSize && lineCount == 1 && ((layout = this.f316452e.getLayout()) == null || b(layout, 0, f16) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f316452e.setTextSize(0, f16);
                        this.f316452e.setMaxLines(i17);
                        super.onMeasure(i3, i16);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f316451d != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                f unused = TabLayoutCompat.this.f316415e;
                f unused2 = TabLayoutCompat.this.f316415e;
                this.f316451d.j();
                TabLayoutCompat.f(TabLayoutCompat.this);
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            if (isSelected() != z16) {
            }
            super.setSelected(z16);
            TextView textView = this.f316452e;
            if (textView != null) {
                textView.setSelected(z16);
            }
            ImageView imageView = this.f316453f;
            if (imageView != null) {
                imageView.setSelected(z16);
            }
            View view = this.f316454h;
            if (view != null) {
                view.setSelected(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface j {
    }

    public TabLayoutCompat(Context context) {
        this(context, null);
    }

    private int C() {
        int i3 = this.J;
        if (i3 != -1) {
            return i3;
        }
        if (this.Q == 0) {
            return this.L;
        }
        return 0;
    }

    private int D() {
        return Math.max(0, ((this.f316417f.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void J(int i3) {
        h hVar = (h) this.f316417f.getChildAt(i3);
        this.f316417f.removeViewAt(i3);
        if (hVar != null) {
            hVar.c();
            this.f316418f0.release(hVar);
        }
        requestLayout();
    }

    private void P(int i3) {
        boolean z16;
        int childCount = this.f316417f.getChildCount();
        if (i3 < childCount) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = this.f316417f.getChildAt(i16);
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childAt.setSelected(z16);
            }
        }
    }

    private void Q(@Nullable ViewPagerCompat viewPagerCompat, boolean z16, boolean z17) {
        ViewPagerCompat viewPagerCompat2 = this.V;
        if (viewPagerCompat2 != null) {
            g gVar = this.f316411b0;
            if (gVar != null) {
                viewPagerCompat2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.f316412c0;
            if (bVar != null) {
                this.V.c(bVar);
            }
        }
        c cVar = this.T;
        if (cVar != null) {
            H(cVar);
            this.T = null;
        }
        if (viewPagerCompat != null) {
            this.V = viewPagerCompat;
            if (this.f316411b0 == null) {
                this.f316411b0 = new g(this);
            }
            this.f316411b0.a();
            viewPagerCompat.addOnPageChangeListener(this.f316411b0);
            i iVar = new i(viewPagerCompat);
            this.T = iVar;
            g(iVar);
            PagerAdapter adapter = viewPagerCompat.getAdapter();
            if (adapter != null) {
                N(adapter, z16);
            }
            if (this.f316412c0 == null) {
                this.f316412c0 = new b();
            }
            this.f316412c0.a(z16);
            viewPagerCompat.b(this.f316412c0);
            setScrollPosition(viewPagerCompat.getCurrentItem(), 0.0f, true);
        } else {
            this.V = null;
            N(null, false);
        }
        this.f316414d0 = z17;
    }

    private void R() {
        Iterator<f> it = this.f316413d.iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    private void S(LinearLayout.LayoutParams layoutParams) {
        if (this.Q == 1 && this.P == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = C();
            layoutParams.weight = 0.0f;
        }
    }

    static /* bridge */ /* synthetic */ j f(TabLayoutCompat tabLayoutCompat) {
        tabLayoutCompat.getClass();
        return null;
    }

    private void k(f fVar) {
        this.f316417f.addView(fVar.f316447h, fVar.d(), q());
    }

    private void l(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f316417f.b()) {
            int scrollX = getScrollX();
            int n3 = n(i3, 0.0f);
            if (scrollX != n3) {
                w();
                this.U.setIntValues(scrollX, n3);
                this.U.start();
            }
            this.f316417f.a(i3, 300);
            return;
        }
        setScrollPosition(i3, 0.0f, true);
    }

    private void m() {
        int i3 = this.M;
        int i16 = this.N;
        if (this.Q == 0) {
            i3 = Math.max(0, i3 - this.f316419h);
            i16 = Math.max(0, this.N - this.f316421m);
        }
        ViewCompat.setPaddingRelative(this.f316417f, i3, 0, i16, 0);
        int i17 = this.Q;
        if (i17 != 0) {
            if (i17 == 1) {
                this.f316417f.setGravity(1);
            }
        } else {
            this.f316417f.setGravity(8388611);
        }
        T(true);
    }

    private int n(int i3, float f16) {
        View view;
        int i16;
        int i17;
        int i18 = 0;
        if (this.Q != 0) {
            return 0;
        }
        View childAt = this.f316417f.getChildAt(i3);
        int i19 = i3 + 1;
        if (i19 < this.f316417f.getChildCount()) {
            view = this.f316417f.getChildAt(i19);
        } else {
            view = null;
        }
        if (childAt != null) {
            i16 = childAt.getWidth();
        } else {
            i16 = 0;
        }
        if (childAt != null) {
            i17 = childAt.getLeft();
        } else {
            i17 = 0;
        }
        if (view != null) {
            i18 = view.getWidth();
        }
        int width = (i17 + (i16 / 2)) - (getWidth() / 2);
        int i26 = (int) ((i16 + i18) * 0.5f * f16);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return width + i26;
        }
        return width - i26;
    }

    private void o(f fVar, int i3) {
        fVar.n(i3);
        this.f316413d.add(i3, fVar);
        int size = this.f316413d.size();
        while (true) {
            i3++;
            if (i3 < size) {
                this.f316413d.get(i3).n(i3);
            } else {
                return;
            }
        }
    }

    private static ColorStateList p(int i3, int i16) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i16, i3});
    }

    private LinearLayout.LayoutParams q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        S(layoutParams);
        return layoutParams;
    }

    private h r(@NonNull f fVar) {
        h hVar;
        Pools.Pool<h> pool = this.f316418f0;
        if (pool != null) {
            hVar = pool.acquire();
        } else {
            hVar = null;
        }
        if (hVar == null) {
            hVar = new h(getContext());
        }
        hVar.d(fVar);
        hVar.setFocusable(true);
        hVar.setMinimumWidth(C());
        return hVar;
    }

    private void s(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).J8(fVar);
        }
    }

    private void t(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).c(fVar);
        }
    }

    private void u(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).l3(fVar);
        }
    }

    @RequiresApi(api = 11)
    private void w() {
        if (this.U == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.U = valueAnimator;
            valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
            this.U.setDuration(300L);
            this.U.addUpdateListener(new a());
        }
    }

    private int x() {
        int size = this.f316413d.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                f fVar = this.f316413d.get(i3);
                if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.g())) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (z16) {
            return 72;
        }
        return 48;
    }

    public int A() {
        return this.f316413d.size();
    }

    int B() {
        return this.I;
    }

    @NonNull
    public f E() {
        f acquire = f316408g0.acquire();
        if (acquire == null) {
            acquire = new f();
        }
        acquire.f316446g = this;
        acquire.f316447h = r(acquire);
        return acquire;
    }

    void F() {
        int currentItem;
        G();
        PagerAdapter pagerAdapter = this.W;
        if (pagerAdapter != null) {
            int f373114d = pagerAdapter.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                j(E().p(this.W.getPageTitle(i3)), false);
            }
            ViewPagerCompat viewPagerCompat = this.V;
            if (viewPagerCompat != null && f373114d > 0 && (currentItem = viewPagerCompat.getCurrentItem()) != y() && currentItem < A()) {
                K(z(currentItem));
            }
        }
    }

    public void G() {
        for (int childCount = this.f316417f.getChildCount() - 1; childCount >= 0; childCount--) {
            J(childCount);
        }
        Iterator<f> it = this.f316413d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.i();
            f316408g0.release(next);
        }
        this.f316415e = null;
    }

    public void H(@NonNull c cVar) {
        this.S.remove(cVar);
    }

    public void I(int i3) {
        int i16;
        f fVar;
        f fVar2 = this.f316415e;
        if (fVar2 != null) {
            i16 = fVar2.d();
        } else {
            i16 = 0;
        }
        J(i3);
        f remove = this.f316413d.remove(i3);
        if (remove != null) {
            remove.i();
            f316408g0.release(remove);
        }
        int size = this.f316413d.size();
        for (int i17 = i3; i17 < size; i17++) {
            this.f316413d.get(i17).n(i17);
        }
        if (i16 == i3) {
            if (this.f316413d.isEmpty()) {
                fVar = null;
            } else {
                fVar = this.f316413d.get(Math.max(0, i3 - 1));
            }
            K(fVar);
        }
    }

    void K(f fVar) {
        L(fVar, true);
    }

    void L(f fVar, boolean z16) {
        int i3;
        f fVar2 = this.f316415e;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                s(fVar);
                l(fVar.d());
                return;
            }
            return;
        }
        if (fVar != null) {
            i3 = fVar.d();
        } else {
            i3 = -1;
        }
        if (z16) {
            if ((fVar2 == null || fVar2.d() == -1) && i3 != -1) {
                setScrollPosition(i3, 0.0f, true);
            } else {
                l(i3);
            }
            if (i3 != -1) {
                P(i3);
            }
        }
        if (fVar2 != null) {
            u(fVar2);
        }
        this.f316415e = fVar;
        if (fVar != null) {
            t(fVar);
        }
    }

    void M(f fVar, boolean z16) {
        int i3;
        f fVar2 = this.f316415e;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                l(fVar.d());
                return;
            }
            return;
        }
        if (fVar != null) {
            i3 = fVar.d();
        } else {
            i3 = -1;
        }
        if (z16) {
            if ((fVar2 == null || fVar2.d() == -1) && i3 != -1) {
                setScrollPosition(i3, 0.0f, true);
            } else {
                l(i3);
            }
            if (i3 != -1) {
                P(i3);
            }
        }
        this.f316415e = fVar;
    }

    void N(@Nullable PagerAdapter pagerAdapter, boolean z16) {
        d dVar;
        PagerAdapter pagerAdapter2 = this.W;
        if (pagerAdapter2 != null && (dVar = this.f316410a0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dVar);
        }
        this.W = pagerAdapter;
        if (pagerAdapter != null) {
            if (this.f316410a0 == null) {
                this.f316410a0 = new d();
            }
            this.f316410a0.b(z16);
            pagerAdapter.registerDataSetObserver(this.f316410a0);
        }
        F();
    }

    void O(int i3, float f16, boolean z16, boolean z17) {
        int round = Math.round(i3 + f16);
        if (round >= 0 && round < this.f316417f.getChildCount()) {
            if (z17) {
                this.f316417f.d(i3, f16);
            }
            ValueAnimator valueAnimator = this.U;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.U.cancel();
            }
            scrollTo(n(i3, f16), 0);
            if (z16) {
                P(round);
            }
        }
    }

    void T(boolean z16) {
        for (int i3 = 0; i3 < this.f316417f.getChildCount(); i3++) {
            View childAt = this.f316417f.getChildAt(i3);
            childAt.setMinimumWidth(C());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z16) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    public void g(@NonNull c cVar) {
        if (!this.S.contains(cVar)) {
            this.S.add(cVar);
        }
    }

    public void h(@NonNull f fVar) {
        j(fVar, this.f316413d.isEmpty());
    }

    public void i(@NonNull f fVar, int i3, boolean z16) {
        if (fVar.f316446g == this) {
            o(fVar, i3);
            k(fVar);
            if (z16) {
                fVar.j();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void j(@NonNull f fVar, boolean z16) {
        i(fVar, this.f316413d.size(), z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.V == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPagerCompat) {
                Q((ViewPagerCompat) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f316414d0) {
            setupWithViewPager(null);
            this.f316414d0 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L28;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int v3 = v(x()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(v3, 1073741824);
            }
        } else {
            i16 = View.MeasureSpec.makeMeasureSpec(Math.min(v3, View.MeasureSpec.getSize(i16)), 1073741824);
        }
        int size = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 0) {
            int i17 = this.K;
            if (i17 <= 0) {
                i17 = size - v(56);
            }
            this.I = i17;
        }
        super.onMeasure(i3, i16);
        boolean z16 = true;
        if (getChildCount() == 1) {
            boolean z17 = false;
            View childAt = getChildAt(0);
            int i18 = this.Q;
            if (i18 != 0) {
                if (i18 == 1) {
                }
            }
            if (z17) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setCutomViewBeRelated(boolean z16) {
        this.f316416e0 = z16;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.R;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.R = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public void setRequestedTabMinWidth(int i3) {
        this.J = i3;
    }

    public void setScrollPosition(int i3, float f16, boolean z16) {
        O(i3, f16, z16, true);
    }

    public void setScrollableTabMinWidth(int i3) {
        this.L = i3;
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i3) {
        this.f316417f.e(i3);
    }

    public void setSelectedTabIndicatorHeight(int i3) {
        this.f316417f.f(i3);
    }

    public void setSelectedTabIndicatorPaddingBottom(int i3) {
        this.f316417f.g(i3);
    }

    public void setSelectedTabIndicatorPaddingLeft(int i3) {
        this.f316417f.h(i3);
    }

    public void setSelectedTabIndicatorPaddingRight(int i3) {
        this.f316417f.i(i3);
    }

    public void setTabBackgroundResId(int i3) {
        if (this.H != i3) {
            this.H = i3;
            Iterator<f> it = this.f316413d.iterator();
            while (it.hasNext()) {
                h hVar = it.next().f316447h;
                if (hVar != null) {
                    hVar.setBackgroundResource(this.H);
                }
            }
        }
    }

    public void setTabGravity(int i3) {
        if (this.P != i3) {
            this.P = i3;
            m();
        }
    }

    public void setTabMode(int i3) {
        if (i3 != this.Q) {
            this.Q = i3;
            m();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            R();
        }
    }

    public void setTabTextSize(int i3) {
        float f16 = i3;
        if (this.F != f16) {
            this.F = f16;
            Iterator<f> it = this.f316413d.iterator();
            while (it.hasNext()) {
                f next = it.next();
                h hVar = next.f316447h;
                if (hVar != null && hVar.f316452e != null) {
                    next.f316447h.f316452e.setTextSize(this.F);
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        N(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPagerCompat viewPagerCompat) {
        setupWithViewPager(viewPagerCompat, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (D() > 0) {
            return true;
        }
        return false;
    }

    int v(int i3) {
        return Math.round(getResources().getDisplayMetrics().density * i3);
    }

    public int y() {
        f fVar = this.f316415e;
        if (fVar != null) {
            return fVar.d();
        }
        return -1;
    }

    @Nullable
    public f z(int i3) {
        if (i3 >= 0 && i3 < A()) {
            return this.f316413d.get(i3);
        }
        return null;
    }

    public TabLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void setupWithViewPager(@Nullable ViewPagerCompat viewPagerCompat, boolean z16) {
        Q(viewPagerCompat, z16, false);
    }

    public TabLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316413d = new ArrayList<>();
        this.I = Integer.MAX_VALUE;
        this.S = new ArrayList<>();
        this.f316418f0 = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.f316417f = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        eVar.f(com.tencent.mobileqq.util.x.c(context, 2.0f));
        eVar.e(-1);
        this.f316419h = 0;
        this.f316420i = 0;
        this.f316421m = 0;
        this.C = 0;
        this.F = com.tencent.mobileqq.util.x.j(context, 12.0f);
        this.E = ColorStateList.valueOf(-1979711488);
        this.H = 0;
        this.M = 0;
        this.N = 0;
        this.Q = 1;
        this.P = 1;
        this.G = com.tencent.mobileqq.util.x.c(context, 12.0f);
        this.L = com.tencent.mobileqq.util.x.c(context, 72.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410165p8);
        this.J = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410212t8, -1);
        this.K = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410201s8, -1);
        this.f316419h = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410233v8, 0);
        this.f316421m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410223u8, 0);
        this.M = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410189r8, 0);
        this.N = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410177q8, 0);
        obtainStyledAttributes.recycle();
        m();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    public void setTabTextColors(int i3, int i16) {
        setTabTextColors(p(i3, i16));
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class i implements c {

        /* renamed from: d, reason: collision with root package name */
        private final ViewPagerCompat f316457d;

        public i(ViewPagerCompat viewPagerCompat) {
            this.f316457d = viewPagerCompat;
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void c(f fVar) {
            this.f316457d.setCurrentItem(fVar.d());
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void J8(f fVar) {
        }

        @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
        public void l3(f fVar) {
        }
    }

    public void setViewPagerTabEventListener(j jVar) {
    }
}
