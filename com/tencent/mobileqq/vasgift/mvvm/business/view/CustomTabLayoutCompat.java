package com.tencent.mobileqq.vasgift.mvvm.business.view;

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
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Pools;
import android.support.v4.widget.FastOutSlowInInterpolator;
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
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomTabLayoutCompat extends HorizontalScrollView {

    /* renamed from: h0, reason: collision with root package name */
    private static final Pools.Pool<f> f311844h0 = new Pools.SynchronizedPool(16);

    /* renamed from: i0, reason: collision with root package name */
    private static final int[] f311845i0 = {R.attr.textSize, R.attr.textColor};
    int C;
    int D;
    int E;
    ColorStateList F;
    float G;
    float H;
    int I;
    int J;
    private final int K;
    private final int L;
    private int M;
    private int N;
    private int P;
    int Q;
    int R;
    private c S;
    private final ArrayList<c> T;
    private c U;
    private ValueAnimator V;
    ViewPagerCompat W;

    /* renamed from: a0, reason: collision with root package name */
    private PagerAdapter f311846a0;

    /* renamed from: b0, reason: collision with root package name */
    private d f311847b0;

    /* renamed from: c0, reason: collision with root package name */
    private g f311848c0;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    Drawable f311849d;

    /* renamed from: d0, reason: collision with root package name */
    private b f311850d0;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<f> f311851e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f311852e0;

    /* renamed from: f, reason: collision with root package name */
    private f f311853f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f311854f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Pools.Pool<h> f311855g0;

    /* renamed from: h, reason: collision with root package name */
    private final e f311856h;

    /* renamed from: i, reason: collision with root package name */
    int f311857i;

    /* renamed from: m, reason: collision with root package name */
    int f311858m;

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
            CustomTabLayoutCompat.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements ViewPagerCompat.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f311860a;

        b() {
        }

        void a(boolean z16) {
            this.f311860a = z16;
        }

        @Override // com.tencent.mobileqq.widget.ViewPagerCompat.a
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            CustomTabLayoutCompat customTabLayoutCompat = CustomTabLayoutCompat.this;
            if (customTabLayoutCompat.W == viewPager) {
                customTabLayoutCompat.K(pagerAdapter2, this.f311860a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void a(f fVar);

        void b(f fVar);

        void c(f fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private boolean f311862a;

        d() {
        }

        void a() {
            int currentItem;
            CustomTabLayoutCompat customTabLayoutCompat = CustomTabLayoutCompat.this;
            if (customTabLayoutCompat.W != null && customTabLayoutCompat.f311856h != null && CustomTabLayoutCompat.this.x() == (currentItem = CustomTabLayoutCompat.this.W.getCurrentItem())) {
                CustomTabLayoutCompat.this.f311856h.a(currentItem, 300);
            }
            if (CustomTabLayoutCompat.this.f311848c0 != null) {
                CustomTabLayoutCompat.this.f311848c0.a();
            }
        }

        void b(boolean z16) {
            this.f311862a = z16;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.f311862a) {
                CustomTabLayoutCompat.this.E();
            } else {
                a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            if (this.f311862a) {
                CustomTabLayoutCompat.this.E();
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
        private int f311864d;

        /* renamed from: e, reason: collision with root package name */
        private final Paint f311865e;

        /* renamed from: f, reason: collision with root package name */
        int f311866f;

        /* renamed from: h, reason: collision with root package name */
        float f311867h;

        /* renamed from: i, reason: collision with root package name */
        private int f311868i;

        /* renamed from: m, reason: collision with root package name */
        private int f311869m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f311870d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f311871e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f311872f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f311873h;

            a(int i3, int i16, int i17, int i18) {
                this.f311870d = i3;
                this.f311871e = i16;
                this.f311872f = i17;
                this.f311873h = i18;
            }

            int a(int i3, int i16, float f16) {
                return i3 + Math.round(f16 * (i16 - i3));
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.c(a(this.f311870d, this.f311871e, animatedFraction), a(this.f311872f, this.f311873h, animatedFraction));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public class b extends AnimatorListenerAdapter {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f311875d;

            b(int i3) {
                this.f311875d = i3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar = e.this;
                eVar.f311866f = this.f311875d;
                eVar.f311867h = 0.0f;
            }
        }

        e(Context context) {
            super(context);
            this.f311866f = -1;
            this.f311868i = -1;
            this.f311869m = -1;
            this.C = -1;
            setWillNotDraw(false);
            this.f311865e = new Paint();
        }

        private void j() {
            int i3;
            int i16;
            View childAt = getChildAt(this.f311866f);
            if (childAt != null && childAt.getWidth() > 0) {
                i3 = childAt.getLeft();
                i16 = childAt.getRight();
                if (this.f311867h > 0.0f && this.f311866f < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f311866f + 1);
                    float left = this.f311867h * childAt2.getLeft();
                    float f16 = this.f311867h;
                    i3 = (int) (left + ((1.0f - f16) * i3));
                    i16 = (int) ((f16 * childAt2.getRight()) + ((1.0f - this.f311867h) * i16));
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
            if (Math.abs(i3 - this.f311866f) <= 1) {
                i17 = this.f311869m;
                i18 = this.C;
            } else {
                int u16 = CustomTabLayoutCompat.this.u(24);
                if (i3 >= this.f311866f ? z16 : !z16) {
                    i17 = u16 + right;
                } else {
                    i17 = left - u16;
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
            if (i3 != this.f311869m || i16 != this.C) {
                this.f311869m = i3;
                this.C = i16;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void d(int i3, float f16) {
            ValueAnimator valueAnimator = this.D;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.D.cancel();
            }
            this.f311866f = i3;
            this.f311867h = f16;
            j();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            CustomTabLayoutCompat.this.f311849d.setBounds(this.f311869m + this.E, (getHeight() - this.f311864d) - this.G, this.C - this.F, getHeight() - this.G);
            CustomTabLayoutCompat.this.f311849d.draw(canvas);
        }

        void e(int i3) {
            if (this.f311865e.getColor() != i3) {
                this.f311865e.setColor(i3);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void f(int i3) {
            if (this.f311864d != i3) {
                this.f311864d = i3;
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
                a(this.f311866f, Math.round((1.0f - this.D.getAnimatedFraction()) * ((float) this.D.getDuration())));
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
            CustomTabLayoutCompat customTabLayoutCompat = CustomTabLayoutCompat.this;
            boolean z16 = true;
            if (customTabLayoutCompat.R == 1 && customTabLayoutCompat.Q == 1) {
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
                if (i17 * childCount <= getMeasuredWidth() - (CustomTabLayoutCompat.this.u(16) * 2)) {
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
                    CustomTabLayoutCompat customTabLayoutCompat2 = CustomTabLayoutCompat.this;
                    customTabLayoutCompat2.Q = 0;
                    customTabLayoutCompat2.Q(false);
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
        private Object f311877a;

        /* renamed from: b, reason: collision with root package name */
        private Drawable f311878b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f311879c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f311880d;

        /* renamed from: e, reason: collision with root package name */
        private int f311881e = -1;

        /* renamed from: f, reason: collision with root package name */
        private View f311882f;

        /* renamed from: g, reason: collision with root package name */
        CustomTabLayoutCompat f311883g;

        /* renamed from: h, reason: collision with root package name */
        h f311884h;

        f() {
        }

        @Nullable
        public CharSequence a() {
            return this.f311880d;
        }

        @Nullable
        public View b() {
            return this.f311882f;
        }

        @Nullable
        public Drawable c() {
            return this.f311878b;
        }

        public int d() {
            return this.f311881e;
        }

        @Nullable
        public Object e() {
            return this.f311877a;
        }

        @Nullable
        public CharSequence f() {
            return this.f311879c;
        }

        public boolean g() {
            CustomTabLayoutCompat customTabLayoutCompat = this.f311883g;
            if (customTabLayoutCompat != null) {
                if (customTabLayoutCompat.x() == this.f311881e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void h() {
            this.f311883g = null;
            this.f311884h = null;
            this.f311877a = null;
            this.f311878b = null;
            this.f311879c = null;
            this.f311880d = null;
            this.f311881e = -1;
            this.f311882f = null;
        }

        public void i() {
            CustomTabLayoutCompat customTabLayoutCompat = this.f311883g;
            if (customTabLayoutCompat != null) {
                customTabLayoutCompat.I(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void j(int i3) {
            this.f311881e = i3;
        }

        @android.support.annotation.NonNull
        public f k(@Nullable Object obj) {
            this.f311877a = obj;
            return this;
        }

        @android.support.annotation.NonNull
        public f l(@Nullable CharSequence charSequence) {
            this.f311879c = charSequence;
            m();
            return this;
        }

        void m() {
            h hVar = this.f311884h;
            if (hVar != null) {
                hVar.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<CustomTabLayoutCompat> f311885d;

        /* renamed from: e, reason: collision with root package name */
        private int f311886e;

        /* renamed from: f, reason: collision with root package name */
        private int f311887f;

        public g(CustomTabLayoutCompat customTabLayoutCompat) {
            this.f311885d = new WeakReference<>(customTabLayoutCompat);
        }

        void a() {
            this.f311887f = 0;
            this.f311886e = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.f311886e = this.f311887f;
            this.f311887f = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            boolean z16;
            CustomTabLayoutCompat customTabLayoutCompat = this.f311885d.get();
            if (customTabLayoutCompat != null) {
                int i17 = this.f311887f;
                boolean z17 = false;
                if (i17 == 2 && this.f311886e != 1) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i17 != 2 || this.f311886e != 0) {
                    z17 = true;
                }
                customTabLayoutCompat.L(i3, f16, z16, z17);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            boolean z16;
            CustomTabLayoutCompat customTabLayoutCompat = this.f311885d.get();
            if (customTabLayoutCompat != null && customTabLayoutCompat.x() != i3 && i3 < customTabLayoutCompat.z()) {
                int i16 = this.f311887f;
                if (i16 != 0 && (i16 != 2 || this.f311886e != 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                f unused = customTabLayoutCompat.f311853f;
                customTabLayoutCompat.J(customTabLayoutCompat.y(i3), z16);
                customTabLayoutCompat.y(i3);
                CustomTabLayoutCompat.e(customTabLayoutCompat);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h extends LinearLayout {
        private int C;

        /* renamed from: d, reason: collision with root package name */
        private f f311888d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f311889e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f311890f;

        /* renamed from: h, reason: collision with root package name */
        private View f311891h;

        /* renamed from: i, reason: collision with root package name */
        private TextView f311892i;

        /* renamed from: m, reason: collision with root package name */
        private ImageView f311893m;

        public h(Context context) {
            super(context);
            this.C = 2;
            if (CustomTabLayoutCompat.this.I != 0) {
                setBackgroundDrawable(context.getResources().getDrawable(CustomTabLayoutCompat.this.I));
            }
            ViewCompat.setPaddingRelative(this, CustomTabLayoutCompat.this.f311857i, CustomTabLayoutCompat.this.f311858m, CustomTabLayoutCompat.this.C, CustomTabLayoutCompat.this.D);
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
            f fVar = this.f311888d;
            if (fVar != null) {
                drawable = fVar.c();
            } else {
                drawable = null;
            }
            f fVar2 = this.f311888d;
            if (fVar2 != null) {
                charSequence = fVar2.f();
            } else {
                charSequence = null;
            }
            f fVar3 = this.f311888d;
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
                    i3 = CustomTabLayoutCompat.this.u(8);
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
            if (fVar != this.f311888d) {
                this.f311888d = fVar;
                e();
            }
        }

        final void e() {
            View view;
            TextView textView;
            f fVar = this.f311888d;
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
                this.f311891h = view;
                TextView textView2 = this.f311889e;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView = this.f311890f;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f311890f.setImageDrawable(null);
                }
                TextView textView3 = (TextView) view.findViewById(R.id.text1);
                this.f311892i = textView3;
                if (textView3 != null) {
                    this.C = textView3.getMaxLines();
                }
                this.f311893m = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view2 = this.f311891h;
                if (view2 != null) {
                    removeView(view2);
                    this.f311891h = null;
                }
                this.f311892i = null;
                this.f311893m = null;
            }
            boolean z16 = false;
            if (this.f311891h == null) {
                if (this.f311890f == null) {
                    ImageView imageView2 = new ImageView(getContext());
                    imageView2.setLayoutParams(new ViewGroup.LayoutParams(48, 48));
                    addView(imageView2, 0);
                    this.f311890f = imageView2;
                }
                if (this.f311889e == null) {
                    TextView textView4 = new TextView(getContext());
                    textView4.setMaxLines(1);
                    textView4.setGravity(1);
                    textView4.setEllipsize(TextUtils.TruncateAt.END);
                    textView4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    addView(textView4);
                    this.f311889e = textView4;
                    this.C = textView4.getMaxLines();
                }
                TextView textView5 = this.f311889e;
                textView5.setTextAppearance(textView5.getContext(), CustomTabLayoutCompat.this.E);
                ColorStateList colorStateList = CustomTabLayoutCompat.this.F;
                if (colorStateList != null) {
                    this.f311889e.setTextColor(colorStateList);
                }
                f(this.f311889e, this.f311890f);
            } else {
                if (CustomTabLayoutCompat.this.f311854f0 && CustomTabLayoutCompat.this.F != null && (textView = this.f311892i) != null) {
                    textView.setTextAppearance(textView.getContext(), CustomTabLayoutCompat.this.E);
                    this.f311892i.setTextColor(CustomTabLayoutCompat.this.F);
                }
                TextView textView6 = this.f311892i;
                if (textView6 != null || this.f311893m != null) {
                    f(textView6, this.f311893m);
                }
            }
            if (fVar != null && fVar.g()) {
                z16 = true;
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
            int A = CustomTabLayoutCompat.this.A();
            if (A > 0 && (mode == 0 || size > A)) {
                i3 = View.MeasureSpec.makeMeasureSpec(CustomTabLayoutCompat.this.J, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i16);
            if (this.f311889e != null) {
                getResources();
                float f16 = CustomTabLayoutCompat.this.G;
                int i17 = this.C;
                ImageView imageView = this.f311890f;
                boolean z16 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i17 = 1;
                } else {
                    TextView textView = this.f311889e;
                    if (textView != null && textView.getLineCount() > 1) {
                        f16 = CustomTabLayoutCompat.this.H;
                    }
                }
                float textSize = this.f311889e.getTextSize();
                int lineCount = this.f311889e.getLineCount();
                int maxLines = this.f311889e.getMaxLines();
                if (f16 != textSize || (maxLines >= 0 && i17 != maxLines)) {
                    if (CustomTabLayoutCompat.this.R == 1 && f16 > textSize && lineCount == 1 && ((layout = this.f311889e.getLayout()) == null || b(layout, 0, f16) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z16 = false;
                    }
                    if (z16) {
                        this.f311889e.setTextSize(f16);
                        this.f311889e.setMaxLines(i17);
                        super.onMeasure(i3, i16);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f311888d != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                f unused = CustomTabLayoutCompat.this.f311853f;
                f unused2 = CustomTabLayoutCompat.this.f311853f;
                this.f311888d.i();
                CustomTabLayoutCompat.e(CustomTabLayoutCompat.this);
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            if (isSelected() != z16) {
            }
            super.setSelected(z16);
            TextView textView = this.f311889e;
            if (textView != null) {
                textView.setSelected(z16);
            }
            ImageView imageView = this.f311890f;
            if (imageView != null) {
                imageView.setSelected(z16);
            }
            View view = this.f311891h;
            if (view != null) {
                view.setSelected(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface j {
    }

    public CustomTabLayoutCompat(Context context) {
        this(context, null);
    }

    private int B() {
        int i3 = this.K;
        if (i3 != -1) {
            return i3;
        }
        if (this.R == 0) {
            return this.M;
        }
        return 0;
    }

    private int C() {
        return Math.max(0, ((this.f311856h.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void H(int i3) {
        h hVar = (h) this.f311856h.getChildAt(i3);
        this.f311856h.removeViewAt(i3);
        if (hVar != null) {
            hVar.c();
            this.f311855g0.release(hVar);
        }
        requestLayout();
    }

    private void M(int i3) {
        boolean z16;
        int childCount = this.f311856h.getChildCount();
        if (i3 < childCount) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = this.f311856h.getChildAt(i16);
                if (i16 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childAt.setSelected(z16);
            }
        }
    }

    private void N(@Nullable ViewPagerCompat viewPagerCompat, boolean z16, boolean z17) {
        ViewPagerCompat viewPagerCompat2 = this.W;
        if (viewPagerCompat2 != null) {
            g gVar = this.f311848c0;
            if (gVar != null) {
                viewPagerCompat2.removeOnPageChangeListener(gVar);
            }
            b bVar = this.f311850d0;
            if (bVar != null) {
                this.W.c(bVar);
            }
        }
        c cVar = this.U;
        if (cVar != null) {
            G(cVar);
            this.U = null;
        }
        if (viewPagerCompat != null) {
            this.W = viewPagerCompat;
            if (this.f311848c0 == null) {
                this.f311848c0 = new g(this);
            }
            this.f311848c0.a();
            viewPagerCompat.addOnPageChangeListener(this.f311848c0);
            i iVar = new i(viewPagerCompat);
            this.U = iVar;
            f(iVar);
            PagerAdapter adapter = viewPagerCompat.getAdapter();
            if (adapter != null) {
                K(adapter, z16);
            }
            if (this.f311850d0 == null) {
                this.f311850d0 = new b();
            }
            this.f311850d0.a(z16);
            viewPagerCompat.b(this.f311850d0);
            setScrollPosition(viewPagerCompat.getCurrentItem(), 0.0f, true);
        } else {
            this.W = null;
            K(null, false);
        }
        this.f311852e0 = z17;
    }

    private void O() {
        Iterator<f> it = this.f311851e.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    private void P(LinearLayout.LayoutParams layoutParams) {
        if (this.R == 1 && this.Q == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.weight = 0.0f;
        }
    }

    static /* bridge */ /* synthetic */ j e(CustomTabLayoutCompat customTabLayoutCompat) {
        customTabLayoutCompat.getClass();
        return null;
    }

    private void j(f fVar) {
        this.f311856h.addView(fVar.f311884h, fVar.d(), p());
    }

    private void k(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.f311856h.b()) {
            int scrollX = getScrollX();
            int m3 = m(i3, 0.0f);
            if (scrollX != m3) {
                v();
                this.V.setIntValues(scrollX, m3);
                this.V.start();
            }
            this.f311856h.a(i3, 300);
            return;
        }
        setScrollPosition(i3, 0.0f, true);
    }

    private void l() {
        int i3 = this.N;
        int i16 = this.P;
        if (this.R == 0) {
            i3 = Math.max(0, i3 - this.f311857i);
            i16 = Math.max(0, this.P - this.C);
        }
        ViewCompat.setPaddingRelative(this.f311856h, i3, 0, i16, 0);
        int i17 = this.R;
        if (i17 != 0) {
            if (i17 == 1) {
                this.f311856h.setGravity(1);
            }
        } else {
            this.f311856h.setGravity(8388611);
        }
        Q(true);
    }

    private int m(int i3, float f16) {
        View view;
        int i16;
        int i17;
        int i18 = 0;
        if (this.R != 0) {
            return 0;
        }
        View childAt = this.f311856h.getChildAt(i3);
        int i19 = i3 + 1;
        if (i19 < this.f311856h.getChildCount()) {
            view = this.f311856h.getChildAt(i19);
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
        this.f311851e.add(i3, fVar);
        int size = this.f311851e.size();
        while (true) {
            i3++;
            if (i3 < size) {
                this.f311851e.get(i3).j(i3);
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
        P(layoutParams);
        return layoutParams;
    }

    private h q(@android.support.annotation.NonNull f fVar) {
        h hVar;
        Pools.Pool<h> pool = this.f311855g0;
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

    private void r(@android.support.annotation.NonNull f fVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).a(fVar);
        }
    }

    private void s(@android.support.annotation.NonNull f fVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).c(fVar);
        }
    }

    private void t(@android.support.annotation.NonNull f fVar) {
        for (int size = this.T.size() - 1; size >= 0; size--) {
            this.T.get(size).b(fVar);
        }
    }

    @RequiresApi(api = 11)
    private void v() {
        if (this.V == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.V = valueAnimator;
            valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
            this.V.setDuration(300L);
            this.V.addUpdateListener(new a());
        }
    }

    private int w() {
        int size = this.f311851e.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                f fVar = this.f311851e.get(i3);
                if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.f())) {
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
        return this.J;
    }

    @android.support.annotation.NonNull
    public f D() {
        f acquire = f311844h0.acquire();
        if (acquire == null) {
            acquire = new f();
        }
        acquire.f311883g = this;
        acquire.f311884h = q(acquire);
        return acquire;
    }

    void E() {
        int currentItem;
        F();
        PagerAdapter pagerAdapter = this.f311846a0;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i3 = 0; i3 < count; i3++) {
                i(D().l(this.f311846a0.getPageTitle(i3)), false);
            }
            ViewPagerCompat viewPagerCompat = this.W;
            if (viewPagerCompat != null && count > 0 && (currentItem = viewPagerCompat.getCurrentItem()) != x() && currentItem < z()) {
                I(y(currentItem));
            }
        }
    }

    public void F() {
        for (int childCount = this.f311856h.getChildCount() - 1; childCount >= 0; childCount--) {
            H(childCount);
        }
        Iterator<f> it = this.f311851e.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.h();
            f311844h0.release(next);
        }
        this.f311853f = null;
    }

    public void G(@android.support.annotation.NonNull c cVar) {
        this.T.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(f fVar) {
        J(fVar, true);
    }

    void J(f fVar, boolean z16) {
        int i3;
        f fVar2 = this.f311853f;
        if (fVar2 == fVar) {
            if (fVar2 != null) {
                r(fVar);
                k(fVar.d());
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
                k(i3);
            }
            if (i3 != -1) {
                M(i3);
            }
        }
        if (fVar2 != null) {
            t(fVar2);
        }
        this.f311853f = fVar;
        if (fVar != null) {
            s(fVar);
        }
    }

    void K(@Nullable PagerAdapter pagerAdapter, boolean z16) {
        d dVar;
        PagerAdapter pagerAdapter2 = this.f311846a0;
        if (pagerAdapter2 != null && (dVar = this.f311847b0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dVar);
        }
        this.f311846a0 = pagerAdapter;
        if (pagerAdapter != null) {
            if (this.f311847b0 == null) {
                this.f311847b0 = new d();
            }
            this.f311847b0.b(z16);
            pagerAdapter.registerDataSetObserver(this.f311847b0);
        }
        E();
    }

    void L(int i3, float f16, boolean z16, boolean z17) {
        int round = Math.round(i3 + f16);
        if (round >= 0 && round < this.f311856h.getChildCount()) {
            if (z17) {
                this.f311856h.d(i3, f16);
            }
            ValueAnimator valueAnimator = this.V;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.V.cancel();
            }
            scrollTo(m(i3, f16), 0);
            if (z16) {
                M(round);
            }
        }
    }

    void Q(boolean z16) {
        for (int i3 = 0; i3 < this.f311856h.getChildCount(); i3++) {
            View childAt = this.f311856h.getChildAt(i3);
            childAt.setMinimumWidth(B());
            P((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z16) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
    }

    public void f(@android.support.annotation.NonNull c cVar) {
        if (!this.T.contains(cVar)) {
            this.T.add(cVar);
        }
    }

    public void g(@android.support.annotation.NonNull f fVar) {
        i(fVar, this.f311851e.isEmpty());
    }

    public void h(@android.support.annotation.NonNull f fVar, int i3, boolean z16) {
        if (fVar.f311883g == this) {
            n(fVar, i3);
            j(fVar);
            if (z16) {
                fVar.i();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void i(@android.support.annotation.NonNull f fVar, boolean z16) {
        h(fVar, this.f311851e.size(), z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.W == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPagerCompat) {
                N((ViewPagerCompat) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f311852e0) {
            setupWithViewPager(null);
            this.f311852e0 = false;
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
        if (View.MeasureSpec.getMode(i3) != 0) {
            int i17 = this.L;
            if (i17 <= 0) {
                i17 = size - u(56);
            }
            this.J = i17;
        }
        super.onMeasure(i3, i16);
        boolean z16 = true;
        if (getChildCount() == 1) {
            boolean z17 = false;
            View childAt = getChildAt(0);
            int i18 = this.R;
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
        this.f311854f0 = z16;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.S;
        if (cVar2 != null) {
            G(cVar2);
        }
        this.S = cVar;
        if (cVar != null) {
            f(cVar);
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public void setScrollPosition(int i3, float f16, boolean z16) {
        L(i3, f16, z16, true);
    }

    public void setScrollableTabMinWidth(int i3) {
        this.M = i3;
    }

    public void setSelectedTabIndicator(@androidx.annotation.Nullable Drawable drawable) {
        if (this.f311849d != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f311849d = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i3) {
        this.f311856h.e(i3);
    }

    public void setSelectedTabIndicatorHeight(int i3) {
        this.f311856h.f(i3);
    }

    public void setSelectedTabIndicatorPaddingBottom(int i3) {
        this.f311856h.g(i3);
    }

    public void setSelectedTabIndicatorPaddingLeft(int i3) {
        this.f311856h.h(i3);
    }

    public void setSelectedTabIndicatorPaddingRight(int i3) {
        this.f311856h.i(i3);
    }

    public void setTabBackgroundResId(int i3) {
        if (this.I != i3) {
            this.I = i3;
            Iterator<f> it = this.f311851e.iterator();
            while (it.hasNext()) {
                h hVar = it.next().f311884h;
                if (hVar != null) {
                    hVar.setBackgroundResource(this.I);
                }
            }
        }
    }

    public void setTabGravity(int i3) {
        if (this.Q != i3) {
            this.Q = i3;
            l();
        }
    }

    public void setTabMode(int i3) {
        if (i3 != this.R) {
            this.R = i3;
            l();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            O();
        }
    }

    public void setTabTextSize(float f16) {
        if (this.G != f16) {
            this.G = f16;
            Iterator<f> it = this.f311851e.iterator();
            while (it.hasNext()) {
                f next = it.next();
                h hVar = next.f311884h;
                if (hVar != null && hVar.f311889e != null) {
                    next.f311884h.f311889e.setTextSize(this.G);
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        K(pagerAdapter, false);
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
        f fVar = this.f311853f;
        if (fVar != null) {
            return fVar.d();
        }
        return -1;
    }

    @Nullable
    public f y(int i3) {
        if (i3 >= 0 && i3 < z()) {
            return this.f311851e.get(i3);
        }
        return null;
    }

    public int z() {
        return this.f311851e.size();
    }

    public CustomTabLayoutCompat(Context context, AttributeSet attributeSet) {
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
        N(viewPagerCompat, z16, false);
    }

    public CustomTabLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f311849d = new GradientDrawable();
        this.f311851e = new ArrayList<>();
        this.J = Integer.MAX_VALUE;
        this.T = new ArrayList<>();
        this.f311855g0 = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        e eVar = new e(context);
        this.f311856h = eVar;
        super.addView(eVar, 0, new FrameLayout.LayoutParams(-2, -1));
        eVar.f(x.c(context, 2.0f));
        eVar.e(-1);
        this.f311857i = 0;
        this.f311858m = 0;
        this.C = 0;
        this.D = 0;
        this.G = x.j(context, 12.0f);
        this.F = ColorStateList.valueOf(-1979711488);
        this.I = 0;
        this.N = 0;
        this.P = 0;
        this.R = 1;
        this.Q = 1;
        this.H = x.c(context, 12.0f);
        this.M = x.c(context, 72.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410165p8);
        this.K = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410212t8, -1);
        this.L = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410201s8, -1);
        this.f311857i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410233v8, 0);
        this.C = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410223u8, 0);
        this.N = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410189r8, 0);
        this.P = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410177q8, 0);
        obtainStyledAttributes.recycle();
        l();
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
    /* loaded from: classes20.dex */
    public static class i implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPagerCompat f311894a;

        public i(ViewPagerCompat viewPagerCompat) {
            this.f311894a = viewPagerCompat;
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void c(f fVar) {
            this.f311894a.setCurrentItem(fVar.d());
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void a(f fVar) {
        }

        @Override // com.tencent.mobileqq.vasgift.mvvm.business.view.CustomTabLayoutCompat.c
        public void b(f fVar) {
        }
    }

    public void setViewPagerTabEventListener(j jVar) {
    }
}
