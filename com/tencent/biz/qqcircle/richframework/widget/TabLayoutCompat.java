package com.tencent.biz.qqcircle.richframework.widget;

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
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TabLayoutCompat extends HorizontalScrollView {

    /* renamed from: h0, reason: collision with root package name */
    private static final Pools.Pool<f> f92090h0 = new Pools.SynchronizedPool(16);

    /* renamed from: i0, reason: collision with root package name */
    private static final int[] f92091i0 = {R.attr.textSize, R.attr.textColor};
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
    private d f92092a0;

    /* renamed from: b0, reason: collision with root package name */
    private g f92093b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f92094c0;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<f> f92095d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f92096d0;

    /* renamed from: e, reason: collision with root package name */
    private f f92097e;

    /* renamed from: e0, reason: collision with root package name */
    private j f92098e0;

    /* renamed from: f, reason: collision with root package name */
    private final e f92099f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f92100f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Pools.Pool<h> f92101g0;

    /* renamed from: h, reason: collision with root package name */
    int f92102h;

    /* renamed from: i, reason: collision with root package name */
    int f92103i;

    /* renamed from: m, reason: collision with root package name */
    int f92104m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface Mode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface TabGravity {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public class b implements ViewPagerCompat.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f92106a;

        b() {
        }

        void a(boolean z16) {
            this.f92106a = z16;
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat.a
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayoutCompat tabLayoutCompat = TabLayoutCompat.this;
            if (tabLayoutCompat.V == viewPager) {
                tabLayoutCompat.L(pagerAdapter2, this.f92106a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(f fVar);

        void b(f fVar);

        void c(f fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private boolean f92108a;

        d() {
        }

        void a() {
            int currentItem;
            TabLayoutCompat tabLayoutCompat = TabLayoutCompat.this;
            if (tabLayoutCompat.V != null && tabLayoutCompat.f92099f != null && TabLayoutCompat.this.x() == (currentItem = TabLayoutCompat.this.V.getCurrentItem())) {
                TabLayoutCompat.this.f92099f.a(currentItem, 300);
            }
            if (TabLayoutCompat.this.f92093b0 != null) {
                TabLayoutCompat.this.f92093b0.a();
            }
        }

        void b(boolean z16) {
            this.f92108a = z16;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.f92108a) {
                TabLayoutCompat.this.F();
            } else {
                a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            if (this.f92108a) {
                TabLayoutCompat.this.F();
            } else {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends LinearLayout {
        private int C;
        private ValueAnimator D;
        private int E;
        private int F;
        private int G;
        private int H;

        /* renamed from: d, reason: collision with root package name */
        private int f92110d;

        /* renamed from: e, reason: collision with root package name */
        private final Paint f92111e;

        /* renamed from: f, reason: collision with root package name */
        int f92112f;

        /* renamed from: h, reason: collision with root package name */
        float f92113h;

        /* renamed from: i, reason: collision with root package name */
        private int f92114i;

        /* renamed from: m, reason: collision with root package name */
        private int f92115m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f92116d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f92117e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f92118f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f92119h;

            a(int i3, int i16, int i17, int i18) {
                this.f92116d = i3;
                this.f92117e = i16;
                this.f92118f = i17;
                this.f92119h = i18;
            }

            int a(int i3, int i16, float f16) {
                return i3 + Math.round(f16 * (i16 - i3));
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.c(a(this.f92116d, this.f92117e, animatedFraction), a(this.f92118f, this.f92119h, animatedFraction));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f92121d;

            b(int i3) {
                this.f92121d = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar = e.this;
                eVar.f92112f = this.f92121d;
                eVar.f92113h = 0.0f;
            }
        }

        e(Context context) {
            super(context);
            this.f92112f = -1;
            this.f92114i = -1;
            this.f92115m = -1;
            this.C = -1;
            this.F = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.f92111e = paint;
            paint.setShadowLayer(2.0f, 0.0f, 1.0f, getResources().getColor(com.tencent.mobileqq.R.color.coe));
        }

        private void m() {
            int i3;
            int i16;
            View childAt = getChildAt(this.f92112f);
            if (childAt != null && childAt.getWidth() > 0) {
                i3 = childAt.getLeft();
                i16 = childAt.getRight();
                if (this.f92113h > 0.0f && this.f92112f < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f92112f + 1);
                    float left = this.f92113h * childAt2.getLeft();
                    float f16 = this.f92113h;
                    i3 = (int) (left + ((1.0f - f16) * i3));
                    i16 = (int) ((f16 * childAt2.getRight()) + ((1.0f - this.f92113h) * i16));
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
                m();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i3 - this.f92112f) <= 1) {
                i17 = this.f92115m;
                i18 = this.C;
            } else {
                int u16 = TabLayoutCompat.this.u(24);
                if (i3 >= this.f92112f ? z16 : !z16) {
                    i17 = u16 + right;
                } else {
                    i17 = left - u16;
                }
                i18 = i17;
            }
            if (i17 != left || i18 != right) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.D = valueAnimator2;
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
            if (i3 != this.f92115m || i16 != this.C) {
                this.f92115m = i3;
                this.C = i16;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void d(int i3, float f16) {
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
            }
            this.f92112f = i3;
            this.f92113h = f16;
            m();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int i3;
            int i16;
            super.draw(canvas);
            int i17 = this.f92115m;
            if (i17 >= 0 && (i3 = this.C) > i17) {
                int i18 = i17 + this.E;
                int i19 = i3 - this.G;
                int i26 = this.F;
                if (i26 != -1 && (i16 = (i19 - i18) - i26) > 0) {
                    int i27 = i16 / 2;
                    i18 += i27;
                    i19 -= i27;
                }
                canvas.drawRect(i18, (getHeight() - this.f92110d) - this.H, i19, getHeight() - this.H, this.f92111e);
            }
        }

        void e(int i3) {
            if (this.f92111e.getColor() != i3) {
                this.f92111e.setColor(i3);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void f(int i3) {
            if (this.f92110d != i3) {
                this.f92110d = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void g(int i3) {
            if (this.F != i3) {
                this.F = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void h() {
            Paint paint = this.f92111e;
            if (paint != null) {
                paint.clearShadowLayer();
            }
        }

        public void i(int i3) {
            if (this.H != i3) {
                this.H = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void j(int i3) {
            if (this.E != i3) {
                this.E = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void k(int i3) {
            if (this.G != i3) {
                this.G = i3;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void l(float f16, float f17, float f18, @ColorInt int i3) {
            Paint paint = this.f92111e;
            if (paint != null) {
                paint.setShadowLayer(f16, f17, f18, i3);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
                a(this.f92112f, Math.round((1.0f - this.D.getAnimatedFraction()) * ((float) this.D.getDuration())));
                return;
            }
            m();
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
                if (i17 * childCount <= getMeasuredWidth() - (TabLayoutCompat.this.u(16) * 2)) {
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
                    tabLayoutCompat2.R(false);
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
    /* loaded from: classes5.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private Object f92123a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f92124b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f92125c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f92126d;

        /* renamed from: e, reason: collision with root package name */
        private int f92127e = -1;

        /* renamed from: f, reason: collision with root package name */
        private View f92128f;

        /* renamed from: g, reason: collision with root package name */
        TabLayoutCompat f92129g;

        /* renamed from: h, reason: collision with root package name */
        h f92130h;

        f() {
        }

        @Nullable
        public CharSequence a() {
            return this.f92126d;
        }

        @Nullable
        public View b() {
            return this.f92128f;
        }

        @Nullable
        public Drawable c() {
            return this.f92124b;
        }

        public int d() {
            return this.f92127e;
        }

        @Nullable
        public CharSequence e() {
            return this.f92125c;
        }

        public boolean f() {
            TabLayoutCompat tabLayoutCompat = this.f92129g;
            if (tabLayoutCompat != null) {
                if (tabLayoutCompat.x() == this.f92127e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void g() {
            this.f92129g = null;
            this.f92130h = null;
            this.f92123a = null;
            this.f92124b = null;
            this.f92125c = null;
            this.f92126d = null;
            this.f92127e = -1;
            this.f92128f = null;
        }

        public void h() {
            TabLayoutCompat tabLayoutCompat = this.f92129g;
            if (tabLayoutCompat != null) {
                tabLayoutCompat.J(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public f i(@Nullable View view) {
            this.f92128f = view;
            l();
            return this;
        }

        void j(int i3) {
            this.f92127e = i3;
        }

        @NonNull
        public f k(@Nullable CharSequence charSequence) {
            this.f92125c = charSequence;
            l();
            return this;
        }

        void l() {
            h hVar = this.f92130h;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class g implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TabLayoutCompat> f92131d;

        /* renamed from: e, reason: collision with root package name */
        private int f92132e;

        /* renamed from: f, reason: collision with root package name */
        private int f92133f;

        public g(TabLayoutCompat tabLayoutCompat) {
            this.f92131d = new WeakReference<>(tabLayoutCompat);
        }

        void a() {
            this.f92133f = 0;
            this.f92132e = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f92132e = this.f92133f;
            this.f92133f = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            TabLayoutCompat tabLayoutCompat = this.f92131d.get();
            if (tabLayoutCompat != null) {
                int i17 = this.f92133f;
                boolean z17 = false;
                if (i17 == 2 && this.f92132e != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f92132e != 0) {
                    z17 = true;
                }
                tabLayoutCompat.M(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            TabLayoutCompat tabLayoutCompat = this.f92131d.get();
            if (tabLayoutCompat != null && tabLayoutCompat.x() != i3 && i3 < tabLayoutCompat.z()) {
                int i16 = this.f92133f;
                if (i16 != 0 && (i16 != 2 || this.f92132e != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                f fVar = tabLayoutCompat.f92097e;
                tabLayoutCompat.K(tabLayoutCompat.y(i3), z16);
                f y16 = tabLayoutCompat.y(i3);
                if (tabLayoutCompat.f92098e0 != null && y16 != null) {
                    tabLayoutCompat.f92098e0.a(y16, fVar, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class h extends LinearLayout {
        private int C;

        /* renamed from: d, reason: collision with root package name */
        private f f92134d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f92135e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f92136f;

        /* renamed from: h, reason: collision with root package name */
        private View f92137h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f92138i;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f92139m;

        public h(Context context) {
            super(context);
            this.C = 2;
            if (TabLayoutCompat.this.H != 0) {
                setBackgroundDrawable(context.getResources().getDrawable(TabLayoutCompat.this.H));
            }
            ViewCompat.setPaddingRelative(this, TabLayoutCompat.this.f92102h, TabLayoutCompat.this.f92103i, TabLayoutCompat.this.f92104m, TabLayoutCompat.this.C);
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
            f fVar = this.f92134d;
            if (fVar != null) {
                drawable = fVar.c();
            } else {
                drawable = null;
            }
            f fVar2 = this.f92134d;
            if (fVar2 != null) {
                charSequence = fVar2.e();
            } else {
                charSequence = null;
            }
            f fVar3 = this.f92134d;
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
                    i3 = TabLayoutCompat.this.u(8);
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
            if (fVar != this.f92134d) {
                this.f92134d = fVar;
                e();
            }
        }

        final void e() {
            View view;
            TextView textView;
            f fVar = this.f92134d;
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
                    addView(view, new LinearLayout.LayoutParams(-2, -1));
                }
                this.f92137h = view;
                TextView textView2 = this.f92135e;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.f92136f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f92136f.setImageDrawable(null);
                }
                TextView textView3 = (TextView) view.findViewById(R.id.text1);
                this.f92138i = textView3;
                if (textView3 != null) {
                    this.C = textView3.getMaxLines();
                }
                this.f92139m = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view2 = this.f92137h;
                if (view2 != null) {
                    removeView(view2);
                    this.f92137h = null;
                }
                this.f92138i = null;
                this.f92139m = null;
            }
            boolean z16 = true;
            if (this.f92137h == null) {
                if (this.f92136f == null) {
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(48, 48));
                    addView(imageView2, 0);
                    this.f92136f = imageView2;
                }
                if (this.f92135e == null) {
                    TextView textView4 = new TextView(getContext());
                    textView4.setMaxLines(2);
                    textView4.setGravity(1);
                    textView4.setEllipsize(TextUtils.TruncateAt.END);
                    textView4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    addView(textView4);
                    this.f92135e = textView4;
                    this.C = textView4.getMaxLines();
                }
                TextView textView5 = this.f92135e;
                textView5.setTextAppearance(textView5.getContext(), TabLayoutCompat.this.D);
                ColorStateList colorStateList = TabLayoutCompat.this.E;
                if (colorStateList != null) {
                    this.f92135e.setTextColor(colorStateList);
                }
                f(this.f92135e, this.f92136f);
            } else {
                if (TabLayoutCompat.this.f92100f0 && TabLayoutCompat.this.E != null && (textView = this.f92138i) != null) {
                    textView.setTextAppearance(textView.getContext(), TabLayoutCompat.this.D);
                    this.f92138i.setTextColor(TabLayoutCompat.this.E);
                }
                TextView textView6 = this.f92138i;
                if (textView6 != null || this.f92139m != null) {
                    f(textView6, this.f92139m);
                }
            }
            if (fVar == null || !fVar.f()) {
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
            int A = TabLayoutCompat.this.A();
            if (A > 0 && (mode == 0 || size > A)) {
                i3 = View.MeasureSpec.makeMeasureSpec(TabLayoutCompat.this.I, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i16);
            if (this.f92135e != null) {
                getResources();
                float f16 = TabLayoutCompat.this.F;
                int i17 = this.C;
                ImageView imageView = this.f92136f;
                boolean z16 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i17 = 1;
                } else {
                    TextView textView = this.f92135e;
                    if (textView != null && textView.getLineCount() > 1) {
                        f16 = TabLayoutCompat.this.G;
                    }
                }
                float textSize = this.f92135e.getTextSize();
                int lineCount = this.f92135e.getLineCount();
                int maxLines = this.f92135e.getMaxLines();
                if (f16 != textSize || (maxLines >= 0 && i17 != maxLines)) {
                    if (TabLayoutCompat.this.Q == 1 && f16 > textSize && lineCount == 1 && ((layout = this.f92135e.getLayout()) == null || b(layout, 0, f16) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f92135e.setTextSize(0, f16);
                        this.f92135e.setMaxLines(i17);
                        super.onMeasure(i3, i16);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f92134d != null) {
                boolean z16 = false;
                if (!performClick) {
                    playSoundEffect(0);
                }
                f fVar = TabLayoutCompat.this.f92097e;
                f fVar2 = TabLayoutCompat.this.f92097e;
                f fVar3 = this.f92134d;
                if (fVar2 == fVar3) {
                    z16 = true;
                }
                fVar3.h();
                if (TabLayoutCompat.this.f92098e0 != null && !z16) {
                    TabLayoutCompat.this.f92098e0.a(this.f92134d, fVar, 1);
                }
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            if (isSelected() != z16) {
            }
            super.setSelected(z16);
            TextView textView = this.f92135e;
            if (textView != null) {
                textView.setSelected(z16);
            }
            ImageView imageView = this.f92136f;
            if (imageView != null) {
                imageView.setSelected(z16);
            }
            View view = this.f92137h;
            if (view != null) {
                view.setSelected(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface j {
        void a(f fVar, @Nullable f fVar2, int i3);

        View b(ViewGroup viewGroup, int i3);
    }

    public TabLayoutCompat(Context context) {
        this(context, null);
    }

    private int B() {
        int i3 = this.J;
        if (i3 != -1) {
            return i3;
        }
        if (this.Q == 0) {
            return this.L;
        }
        return 0;
    }

    private int C() {
        return Math.max(0, ((this.f92099f.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void I(int i3) {
        h hVar = (h) this.f92099f.getChildAt(i3);
        this.f92099f.removeViewAt(i3);
        if (hVar != null) {
            hVar.c();
            this.f92101g0.release(hVar);
        }
        requestLayout();
    }

    private void N(int i3) {
        boolean z16;
        int childCount = this.f92099f.getChildCount();
        if (i3 < childCount) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = this.f92099f.getChildAt(i16);
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childAt.setSelected(z16);
            }
        }
    }

    private void O(@Nullable ViewPagerCompat viewPagerCompat, boolean z16, boolean z17) {
        ViewPagerCompat viewPagerCompat2 = this.V;
        if (viewPagerCompat2 != null) {
            g gVar = this.f92093b0;
            if (gVar != null) {
                viewPagerCompat2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.f92094c0;
            if (bVar != null) {
                this.V.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.T;
        if (cVar != null) {
            H(cVar);
            this.T = null;
        }
        if (viewPagerCompat != null) {
            this.V = viewPagerCompat;
            if (this.f92093b0 == null) {
                this.f92093b0 = new g(this);
            }
            this.f92093b0.a();
            viewPagerCompat.addOnPageChangeListener(this.f92093b0);
            i iVar = new i(viewPagerCompat);
            this.T = iVar;
            f(iVar);
            PagerAdapter adapter = viewPagerCompat.getAdapter();
            if (adapter != null) {
                L(adapter, z16);
            }
            if (this.f92094c0 == null) {
                this.f92094c0 = new b();
            }
            this.f92094c0.a(z16);
            viewPagerCompat.addOnAdapterChangeListener(this.f92094c0);
            setScrollPosition(viewPagerCompat.getCurrentItem(), 0.0f, true);
        } else {
            this.V = null;
            L(null, false);
        }
        this.f92096d0 = z17;
    }

    private void P() {
        Iterator<f> it = this.f92095d.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    private void Q(LinearLayout.LayoutParams layoutParams) {
        if (this.Q == 1 && this.P == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private void i(f fVar) {
        this.f92099f.addView(fVar.f92130h, fVar.d(), p());
    }

    private void j(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f92099f.b()) {
            int scrollX = getScrollX();
            int l3 = l(i3, 0.0f);
            if (scrollX != l3) {
                v();
                this.U.setIntValues(scrollX, l3);
                this.U.start();
            }
            this.f92099f.a(i3, 300);
            return;
        }
        setScrollPosition(i3, 0.0f, true);
    }

    private void k() {
        int i3 = this.M;
        int i16 = this.N;
        if (this.Q == 0) {
            i3 = Math.max(0, i3 - this.f92102h);
            i16 = Math.max(0, this.N - this.f92104m);
        }
        ViewCompat.setPaddingRelative(this.f92099f, i3, 0, i16, 0);
        int i17 = this.Q;
        if (i17 != 0) {
            if (i17 == 1) {
                this.f92099f.setGravity(1);
            }
        } else {
            this.f92099f.setGravity(8388611);
        }
        R(true);
    }

    private int l(int i3, float f16) {
        View view;
        int i16;
        int i17;
        int i18 = 0;
        if (this.Q != 0) {
            return 0;
        }
        View childAt = this.f92099f.getChildAt(i3);
        int i19 = i3 + 1;
        if (i19 < this.f92099f.getChildCount()) {
            view = this.f92099f.getChildAt(i19);
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

    private void n(f fVar, int i3) {
        fVar.j(i3);
        this.f92095d.add(i3, fVar);
        int size = this.f92095d.size();
        while (true) {
            i3++;
            if (i3 < size) {
                this.f92095d.get(i3).j(i3);
            } else {
                return;
            }
        }
    }

    private static ColorStateList o(int i3, int i16) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i16, i3});
    }

    private LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        Q(layoutParams);
        return layoutParams;
    }

    private h q(@NonNull f fVar) {
        h hVar;
        Pools.Pool<h> pool = this.f92101g0;
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
        hVar.setMinimumWidth(B());
        return hVar;
    }

    private void r(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).c(fVar);
        }
    }

    private void s(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).a(fVar);
        }
    }

    private void t(@NonNull f fVar) {
        for (int size = this.S.size() - 1; size >= 0; size--) {
            this.S.get(size).b(fVar);
        }
    }

    private void v() {
        if (this.U == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.U = valueAnimator;
            valueAnimator.setDuration(300L);
            this.U.addUpdateListener(new a());
        }
    }

    private int w() {
        int size = this.f92095d.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                f fVar = this.f92095d.get(i3);
                if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.e())) {
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

    int A() {
        return this.I;
    }

    public void D() {
        ViewPagerCompat viewPagerCompat = this.V;
        if (viewPagerCompat == null) {
            return;
        }
        int currentItem = viewPagerCompat.getCurrentItem();
        QLog.d("TabLayoutCompat", 1, "moveFocusToSelectTab curItem:" + currentItem);
        j(currentItem);
    }

    @NonNull
    public f E(int i3) {
        f acquire = f92090h0.acquire();
        if (acquire == null) {
            acquire = new f();
        }
        acquire.f92129g = this;
        h q16 = q(acquire);
        acquire.f92130h = q16;
        j jVar = this.f92098e0;
        if (jVar != null) {
            acquire.i(jVar.b(q16, i3));
        }
        return acquire;
    }

    void F() {
        int currentItem;
        G();
        PagerAdapter pagerAdapter = this.W;
        if (pagerAdapter != null) {
            int f373114d = pagerAdapter.getF373114d();
            for (int i3 = 0; i3 < f373114d; i3++) {
                h(E(i3).k(this.W.getPageTitle(i3)), false);
            }
            ViewPagerCompat viewPagerCompat = this.V;
            if (viewPagerCompat != null && f373114d > 0 && (currentItem = viewPagerCompat.getCurrentItem()) != x() && currentItem < z()) {
                J(y(currentItem));
            }
        }
    }

    public void G() {
        for (int childCount = this.f92099f.getChildCount() - 1; childCount >= 0; childCount--) {
            I(childCount);
        }
        Iterator<f> it = this.f92095d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.g();
            f92090h0.release(next);
        }
        this.f92097e = null;
    }

    public void H(@NonNull c cVar) {
        this.S.remove(cVar);
    }

    void J(f fVar) {
        K(fVar, true);
    }

    void K(f fVar, boolean z16) {
        int i3;
        f fVar2 = this.f92097e;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                r(fVar);
                j(fVar.d());
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
                j(i3);
            }
            if (i3 != -1) {
                N(i3);
            }
        }
        if (fVar2 != null) {
            t(fVar2);
        }
        this.f92097e = fVar;
        if (fVar != null) {
            s(fVar);
        }
    }

    void L(@Nullable PagerAdapter pagerAdapter, boolean z16) {
        d dVar;
        PagerAdapter pagerAdapter2 = this.W;
        if (pagerAdapter2 != null && (dVar = this.f92092a0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dVar);
        }
        this.W = pagerAdapter;
        if (pagerAdapter != null) {
            if (this.f92092a0 == null) {
                this.f92092a0 = new d();
            }
            this.f92092a0.b(z16);
            pagerAdapter.registerDataSetObserver(this.f92092a0);
        }
        F();
    }

    void M(int i3, float f16, boolean z16, boolean z17) {
        int round = Math.round(i3 + f16);
        if (round >= 0 && round < this.f92099f.getChildCount()) {
            if (z17) {
                this.f92099f.d(i3, f16);
            }
            ValueAnimator valueAnimator = this.U;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.U.cancel();
            }
            scrollTo(l(i3, f16), 0);
            if (z16) {
                N(round);
            }
        }
    }

    void R(boolean z16) {
        for (int i3 = 0; i3 < this.f92099f.getChildCount(); i3++) {
            View childAt = this.f92099f.getChildAt(i3);
            childAt.setMinimumWidth(B());
            Q((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z16) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    public void f(@NonNull c cVar) {
        if (!this.S.contains(cVar)) {
            this.S.add(cVar);
        }
    }

    public void g(@NonNull f fVar, int i3, boolean z16) {
        if (fVar.f92129g == this) {
            n(fVar, i3);
            i(fVar);
            if (z16) {
                fVar.h();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void h(@NonNull f fVar, boolean z16) {
        g(fVar, this.f92095d.size(), z16);
    }

    public void m() {
        this.S.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.V == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPagerCompat) {
                O((ViewPagerCompat) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f92096d0) {
            setupWithViewPager(null);
            this.f92096d0 = false;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int u16 = u(w()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(u16, 1073741824);
            }
        } else {
            i16 = View.MeasureSpec.makeMeasureSpec(Math.min(u16, View.MeasureSpec.getSize(i16)), 1073741824);
        }
        int size = View.MeasureSpec.getSize(i3);
        boolean z16 = false;
        if (View.MeasureSpec.getMode(i3) != 0) {
            int i17 = this.K;
            if (i17 <= 0) {
                i17 = size - u(0);
            }
            this.I = i17;
        }
        super.onMeasure(i3, i16);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i18 = this.Q;
            if (i18 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i18 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z16 = true;
            }
            if (z16) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void setContentEnd(int i3) {
        this.N = i3;
    }

    public void setContentStart(int i3) {
        this.M = i3;
    }

    public void setCutomViewBeRelated(boolean z16) {
        this.f92100f0 = z16;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.R;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.R = cVar;
        if (cVar != null) {
            f(cVar);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public void setRequestedTabMinWidth(int i3) {
        this.J = i3;
        k();
    }

    public void setScrollPosition(int i3, float f16, boolean z16) {
        M(i3, f16, z16, true);
    }

    public void setScrollableTabMinWidth(int i3) {
        this.L = i3;
    }

    public void setSelectedIndicatorNoShadowLayer() {
        this.f92099f.h();
    }

    public void setSelectedIndicatorShadowLayer(float f16, float f17, float f18, @ColorInt int i3) {
        this.f92099f.l(f16, f17, f18, i3);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i3) {
        this.f92099f.e(i3);
    }

    public void setSelectedTabIndicatorHeight(int i3) {
        this.f92099f.f(i3);
    }

    public void setSelectedTabIndicatorPaddingBottom(int i3) {
        this.f92099f.i(i3);
    }

    public void setSelectedTabIndicatorPaddingLeft(int i3) {
        this.f92099f.j(i3);
    }

    public void setSelectedTabIndicatorPaddingRight(int i3) {
        this.f92099f.k(i3);
    }

    public void setSelectedTabIndicatorWidth(int i3) {
        this.f92099f.g(i3);
    }

    public void setTabBackgroundResId(int i3) {
        if (this.H != i3) {
            this.H = i3;
            Iterator<f> it = this.f92095d.iterator();
            while (it.hasNext()) {
                h hVar = it.next().f92130h;
                if (hVar != null) {
                    hVar.setBackgroundResource(this.H);
                }
            }
        }
    }

    public void setTabGravity(int i3) {
        if (this.P != i3) {
            this.P = i3;
            k();
        }
    }

    public void setTabMode(int i3) {
        if (i3 != this.Q) {
            this.Q = i3;
            k();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            P();
        }
    }

    public void setTabTextSize(int i3) {
        float f16 = i3;
        if (this.F != f16) {
            this.F = f16;
            Iterator<f> it = this.f92095d.iterator();
            while (it.hasNext()) {
                f next = it.next();
                h hVar = next.f92130h;
                if (hVar != null && hVar.f92135e != null) {
                    next.f92130h.f92135e.setTextSize(this.F);
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        L(pagerAdapter, false);
    }

    public void setViewPagerTabEventListener(j jVar) {
        this.f92098e0 = jVar;
    }

    public void setupWithViewPager(@Nullable ViewPagerCompat viewPagerCompat) {
        setupWithViewPager(viewPagerCompat, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (C() > 0) {
            return true;
        }
        return false;
    }

    int u(int i3) {
        return Math.round(getResources().getDisplayMetrics().density * i3);
    }

    public int x() {
        f fVar = this.f92097e;
        if (fVar != null) {
            return fVar.d();
        }
        return -1;
    }

    @Nullable
    public f y(int i3) {
        if (i3 >= 0 && i3 < z()) {
            return this.f92095d.get(i3);
        }
        return null;
    }

    public int z() {
        return this.f92095d.size();
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
        O(viewPagerCompat, z16, false);
    }

    public TabLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92095d = new ArrayList<>();
        this.I = Integer.MAX_VALUE;
        this.S = new ArrayList<>();
        this.f92101g0 = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.f92099f = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        eVar.f(cx.a(2.0f));
        eVar.e(-1);
        this.f92102h = 0;
        this.f92103i = 0;
        this.f92104m = 0;
        this.C = 0;
        this.F = cx.k(12.0f);
        this.E = ColorStateList.valueOf(-1979711488);
        this.H = 0;
        this.M = 0;
        this.N = 0;
        this.Q = 1;
        this.P = 1;
        this.G = cx.a(12.0f);
        this.L = cx.a(72.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410165p8);
        this.J = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410212t8, -1);
        this.K = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410201s8, -1);
        this.f92102h = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410233v8, 0);
        this.f92104m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410223u8, 0);
        this.M = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410189r8, 0);
        this.N = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410177q8, 0);
        obtainStyledAttributes.recycle();
        k();
        v();
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
        setTabTextColors(o(i3, i16));
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class i implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPagerCompat f92140a;

        public i(ViewPagerCompat viewPagerCompat) {
            this.f92140a = viewPagerCompat;
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void a(f fVar) {
            this.f92140a.setCurrentItem(fVar.d());
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void b(f fVar) {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.c
        public void c(f fVar) {
        }
    }
}
