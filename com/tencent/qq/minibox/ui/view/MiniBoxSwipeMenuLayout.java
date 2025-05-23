package com.tencent.qq.minibox.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MiniBoxSwipeMenuLayout extends ViewGroup {
    private static MiniBoxSwipeMenuLayout Q;
    private static boolean R;
    private View C;
    private PointF D;
    private boolean E;
    private PointF F;
    private boolean G;
    private VelocityTracker H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ValueAnimator M;
    private ValueAnimator N;
    private boolean P;

    /* renamed from: d, reason: collision with root package name */
    private int f344708d;

    /* renamed from: e, reason: collision with root package name */
    private int f344709e;

    /* renamed from: f, reason: collision with root package name */
    private int f344710f;

    /* renamed from: h, reason: collision with root package name */
    private int f344711h;

    /* renamed from: i, reason: collision with root package name */
    private int f344712i;

    /* renamed from: m, reason: collision with root package name */
    private int f344713m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MiniBoxSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MiniBoxSwipeMenuLayout.this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MiniBoxSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MiniBoxSwipeMenuLayout.this.P = false;
        }
    }

    public MiniBoxSwipeMenuLayout(Context context) {
        this(context, null);
    }

    private void b(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void c() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.N.cancel();
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.M.cancel();
        }
    }

    private void d(int i3, int i16) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i17 = 0; i17 < i3; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i18 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i16, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i18;
                }
            }
        }
    }

    private void e(Context context, AttributeSet attributeSet, int i3) {
        this.f344708d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f344709e = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.I = true;
        this.J = true;
        this.L = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, is3.a.K5, i3, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i16 = 0; i16 < indexCount; i16++) {
            int index = obtainStyledAttributes.getIndex(i16);
            if (index == is3.a.N5) {
                this.I = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == is3.a.L5) {
                this.J = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == is3.a.M5) {
                this.L = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void f() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.H.recycle();
            this.H = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r1 != 3) goto L69;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.I) {
            b(motionEvent);
            VelocityTracker velocityTracker = this.H;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (!this.K) {
                            float rawX = this.D.x - motionEvent.getRawX();
                            if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (Math.abs(rawX) > this.f344708d) {
                                this.E = false;
                            }
                            scrollBy((int) rawX, 0);
                            if (this.L) {
                                if (getScrollX() < 0) {
                                    scrollTo(0, 0);
                                }
                                int scrollX = getScrollX();
                                int i3 = this.f344712i;
                                if (scrollX > i3) {
                                    scrollTo(i3, 0);
                                }
                            } else {
                                int scrollX2 = getScrollX();
                                int i16 = this.f344712i;
                                if (scrollX2 < (-i16)) {
                                    scrollTo(-i16, 0);
                                }
                                if (getScrollX() > 0) {
                                    scrollTo(0, 0);
                                }
                            }
                            this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                        }
                    }
                }
                if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f344708d) {
                    this.G = true;
                }
                if (!this.K) {
                    velocityTracker.computeCurrentVelocity(1000, this.f344709e);
                    float xVelocity = velocityTracker.getXVelocity(this.f344710f);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            if (this.L) {
                                h();
                            } else {
                                g();
                            }
                        } else if (this.L) {
                            g();
                        } else {
                            h();
                        }
                    } else if (Math.abs(getScrollX()) > this.f344713m) {
                        h();
                    } else {
                        g();
                    }
                }
                f();
                R = false;
            } else {
                this.G = false;
                this.E = true;
                this.K = false;
                if (R) {
                    return false;
                }
                R = true;
                this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.F.set(motionEvent.getRawX(), motionEvent.getRawY());
                MiniBoxSwipeMenuLayout miniBoxSwipeMenuLayout = Q;
                if (miniBoxSwipeMenuLayout != null) {
                    if (miniBoxSwipeMenuLayout != this) {
                        miniBoxSwipeMenuLayout.g();
                        this.K = this.J;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f344710f = motionEvent.getPointerId(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        Q = null;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.N = ofInt;
        ofInt.addUpdateListener(new c());
        this.N.setInterpolator(new AccelerateInterpolator());
        this.N.addListener(new d());
        this.N.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void h() {
        int i3;
        Q = this;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(false);
        }
        c();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        if (this.L) {
            i3 = this.f344712i;
        } else {
            i3 = -this.f344712i;
        }
        iArr[1] = i3;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.M = ofInt;
        ofInt.addUpdateListener(new a());
        this.M.setInterpolator(new OvershootInterpolator());
        this.M.addListener(new b());
        this.M.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MiniBoxSwipeMenuLayout miniBoxSwipeMenuLayout = Q;
        if (this == miniBoxSwipeMenuLayout) {
            miniBoxSwipeMenuLayout.g();
            Q = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.I) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.F.x) > this.f344708d) {
                    return true;
                }
            } else {
                if (this.L) {
                    if (getScrollX() > this.f344708d && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.E) {
                            g();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f344708d && motionEvent.getX() > (-getScrollX())) {
                    if (this.E) {
                        g();
                    }
                    return true;
                }
                if (this.G) {
                    return true;
                }
            }
            if (this.K) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        int paddingLeft2 = getPaddingLeft() + 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                if (i19 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.L) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, getPaddingTop() + childAt.getMeasuredHeight());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, getPaddingTop() + childAt.getMeasuredHeight());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft += measuredWidth;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        super.onMeasure(i3, i16);
        setClickable(true);
        this.f344712i = 0;
        this.f344711h = 0;
        int childCount = getChildCount();
        if (View.MeasureSpec.getMode(i16) != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = 0;
        boolean z17 = false;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f344711h = Math.max(this.f344711h, childAt.getMeasuredHeight());
                if (z16 && marginLayoutParams.height == -1) {
                    z17 = true;
                }
                if (i18 > 0) {
                    this.f344712i += childAt.getMeasuredWidth();
                } else {
                    this.C = childAt;
                    i17 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i17, this.f344711h + getPaddingTop() + getPaddingBottom());
        this.f344713m = (this.f344712i * 4) / 10;
        if (z17) {
            d(childCount, i3);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f344708d) {
            return false;
        }
        return super.performLongClick();
    }

    public void setSwipeEnable(boolean z16) {
        this.I = z16;
    }

    public MiniBoxSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniBoxSwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new PointF();
        this.E = true;
        this.F = new PointF();
        e(context, attributeSet, i3);
    }
}
