package com.tencent.aelight.camera.ae.album;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumLinearLayout extends LinearLayout implements NestedScrollingParent {
    private Interpolator C;
    private boolean D;
    private int E;
    private int F;
    private ScrollListener G;

    /* renamed from: d, reason: collision with root package name */
    private View f61995d;

    /* renamed from: e, reason: collision with root package name */
    private View f61996e;

    /* renamed from: f, reason: collision with root package name */
    private int f61997f;

    /* renamed from: h, reason: collision with root package name */
    private int f61998h;

    /* renamed from: i, reason: collision with root package name */
    private int f61999i;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f62000m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface ScrollListener {

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes32.dex */
        public @interface ScrollType {
        }

        void a(float f16);

        void b(float f16);

        void c(int i3, boolean z16);

        void onScrollStart(int i3);

        void onStatusChanged(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Integer) {
                if (AEAlbumLinearLayout.this.G != null) {
                    AEAlbumLinearLayout.this.G.a(((Integer) valueAnimator.getAnimatedValue()).intValue() / (AEAlbumLinearLayout.this.f61999i * 1.0f));
                }
                AEAlbumLinearLayout.this.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public AEAlbumLinearLayout(Context context) {
        this(context, null);
    }

    private float g() {
        return (getScrollY() * 1.0f) / this.f61999i;
    }

    private void h() {
        int i3 = this.f61999i / 2;
        if (getScrollY() > 0 && getScrollY() < i3) {
            i();
        } else {
            if (i3 > getScrollY() || getScrollY() >= this.f61999i) {
                return;
            }
            f();
        }
    }

    private void k() {
        ValueAnimator valueAnimator = this.f62000m;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f62000m = valueAnimator2;
            valueAnimator2.setInterpolator(this.C);
            this.f62000m.addUpdateListener(new a());
            this.f62000m.addListener(new b());
            return;
        }
        valueAnimator.cancel();
    }

    public void f() {
        ms.a.a("AEAlbumLinearLayout", "[collapsePreviewContainer]");
        int scrollY = getScrollY();
        int i3 = this.f61999i;
        if (scrollY >= i3) {
            ms.a.a("AEAlbumLinearLayout", "[collapsePreviewContainer], already collapsed");
            return;
        }
        this.F = 1;
        int scrollY2 = i3 - getScrollY();
        int i16 = (int) (((scrollY2 * 1.0f) / this.f61999i) * 275.0f);
        ms.a.a("AEAlbumLinearLayout", "[collapsePreviewContainer], dy=" + scrollY2 + ", duration=" + i16);
        k();
        this.f62000m.setIntValues(getScrollY(), this.f61999i);
        this.f62000m.setDuration((long) i16);
        this.f62000m.start();
        ScrollListener scrollListener = this.G;
        if (scrollListener != null) {
            scrollListener.onStatusChanged(false);
        }
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        ms.a.a("AEAlbumLinearLayout", "[getNestedScrollAxes]");
        return 2;
    }

    public void i() {
        ms.a.a("AEAlbumLinearLayout", "[expandPreviewContainer]");
        if (getScrollY() <= 0) {
            ms.a.a("AEAlbumLinearLayout", "[expandPreviewContainer], already expanded");
            return;
        }
        this.F = 2;
        int scrollY = (int) (((getScrollY() * 1.0f) / this.f61999i) * 275.0f);
        ms.a.a("AEAlbumLinearLayout", "[expandPreviewContainer], dy=" + (-getScrollY()) + ", duration=" + scrollY);
        k();
        this.f62000m.setIntValues(getScrollY(), 0);
        this.f62000m.setDuration((long) scrollY);
        this.f62000m.start();
        ScrollListener scrollListener = this.G;
        if (scrollListener != null) {
            scrollListener.onStatusChanged(true);
        }
    }

    public boolean l() {
        return getScrollY() == this.f61999i;
    }

    public boolean m() {
        return getScrollY() == 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f61995d = getChildAt(0);
        this.f61996e = getChildAt(1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int measuredHeight = this.f61995d.getMeasuredHeight();
        this.f61998h = measuredHeight;
        int i17 = this.f61997f;
        if (measuredHeight < i17 || i17 == 0) {
            this.f61997f = measuredHeight / 3;
        }
        this.f61999i = measuredHeight - this.f61997f;
        this.f61996e.getLayoutParams().height = getMeasuredHeight() - this.f61997f;
        setMeasuredDimension(getMeasuredWidth(), this.f61995d.getMeasuredHeight() + this.f61996e.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        ms.a.a("AEAlbumLinearLayout", "[onNestedFling], velocityX=" + f16 + ", velocityY=" + f17 + ", consumed=" + z16);
        return super.onNestedFling(view, f16, f17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        ms.a.a("AEAlbumLinearLayout", "[onNestedPreFling], velocityX=" + f16 + ", velocityY=" + f17);
        if (f17 > 0.0f && getScrollY() < this.f61999i) {
            f();
            this.D = true;
        }
        return this.D;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        int max;
        ms.a.a("AEAlbumLinearLayout", "[onNestedPreScroll], dy=" + i16 + ", scrollY=" + getScrollY());
        boolean z16 = i16 > 0 && getScrollY() < this.f61999i;
        boolean z17 = i16 < 0 && getScrollY() > 0 && !ViewCompat.canScrollVertically(view, -1);
        if (z16 || z17) {
            if (z16) {
                max = Math.min(i16, this.f61999i - getScrollY());
            } else {
                max = Math.max(i16, -getScrollY());
            }
            scrollBy(0, max);
            iArr[1] = max;
            int i17 = z16 ? 1 : 2;
            this.E = i17;
            ScrollListener scrollListener = this.G;
            if (scrollListener != null) {
                scrollListener.onScrollStart(i17);
                this.G.b(g());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        ms.a.a("AEAlbumLinearLayout", "[onNestedScroll], dxConsumed=" + i3 + ", dyConsumed=" + i16 + ", dxUnconsumed=" + i17 + ", dyUnconsumed=" + i18);
        super.onNestedScroll(view, i3, i16, i17, i18);
        ScrollListener scrollListener = this.G;
        if (scrollListener != null) {
            scrollListener.b(g());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        ms.a.a("AEAlbumLinearLayout", "[onNestedScrollAccepted], axes=" + i3);
        super.onNestedScrollAccepted(view, view2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        ms.a.a("AEAlbumLinearLayout", "[onStartNestedScroll], nestedScrollAxes=" + i3);
        return (i3 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        ms.a.a("AEAlbumLinearLayout", "[onStopNestedScroll], scrollY=" + getScrollY());
        super.onStopNestedScroll(view);
        if (!this.D) {
            h();
        } else {
            this.D = false;
        }
        ScrollListener scrollListener = this.G;
        if (scrollListener != null) {
            int i3 = this.E;
            scrollListener.c(i3, j(i3));
        }
        this.E = 0;
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.G = scrollListener;
    }

    public AEAlbumLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AEAlbumLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = 0;
        this.F = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415477a);
        try {
            try {
                this.f61997f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            } catch (Exception e16) {
                ms.a.d("AEAlbumLinearLayout", "constructor, error=", e16);
            }
            setOrientation(1);
            this.C = new AccelerateDecelerateInterpolator();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(int i3) {
        if (i3 == 1) {
            return l();
        }
        if (i3 == 2) {
            return m();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AEAlbumLinearLayout.this.F = 0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (AEAlbumLinearLayout.this.G != null) {
                ScrollListener scrollListener = AEAlbumLinearLayout.this.G;
                int i3 = AEAlbumLinearLayout.this.F;
                AEAlbumLinearLayout aEAlbumLinearLayout = AEAlbumLinearLayout.this;
                scrollListener.c(i3, aEAlbumLinearLayout.j(aEAlbumLinearLayout.F));
            }
            AEAlbumLinearLayout.this.F = 0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (AEAlbumLinearLayout.this.G != null) {
                AEAlbumLinearLayout.this.G.onScrollStart(AEAlbumLinearLayout.this.F);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
