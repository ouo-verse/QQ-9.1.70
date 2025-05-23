package com.qzone.reborn.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneSwipeMenuLayout extends ViewGroup {
    private static QZoneSwipeMenuLayout Q;
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
    private int f59644d;

    /* renamed from: e, reason: collision with root package name */
    private int f59645e;

    /* renamed from: f, reason: collision with root package name */
    private int f59646f;

    /* renamed from: h, reason: collision with root package name */
    private int f59647h;

    /* renamed from: i, reason: collision with root package name */
    private int f59648i;

    /* renamed from: m, reason: collision with root package name */
    private int f59649m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZoneSwipeMenuLayout.this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QZoneSwipeMenuLayout.this.P = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface e {
    }

    public QZoneSwipeMenuLayout(Context context) {
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
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.M.cancel();
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

    private void f(Context context, AttributeSet attributeSet, int i3) {
        this.f59644d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f59645e = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.I = true;
        this.J = true;
        this.L = true;
    }

    private void h() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.H.recycle();
            this.H = null;
        }
    }

    public void g() {
        if (this == Q) {
            c();
            Q.scrollTo(0, 0);
            Q = null;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void j() {
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
            i3 = this.f59648i;
        } else {
            i3 = -this.f59648i;
        }
        iArr[1] = i3;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.M = ofInt;
        ofInt.addUpdateListener(new a());
        this.M.setInterpolator(new f());
        this.M.addListener(new b());
        this.M.setDuration(e(this.f59648i, this.f59648i - getScrollX())).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QZoneSwipeMenuLayout qZoneSwipeMenuLayout = Q;
        if (this == qZoneSwipeMenuLayout) {
            qZoneSwipeMenuLayout.i();
            Q = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 2) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b1 A[RETURN] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.I) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.G = false;
                this.E = true;
                this.K = false;
                this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.F.set(motionEvent.getRawX(), motionEvent.getRawY());
                if (R) {
                    return false;
                }
                R = true;
                QZoneSwipeMenuLayout qZoneSwipeMenuLayout = Q;
                if (qZoneSwipeMenuLayout != null) {
                    if (qZoneSwipeMenuLayout != this) {
                        qZoneSwipeMenuLayout.i();
                        this.K = this.J;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else {
                if (action == 1) {
                    if (this.L) {
                        if (getScrollX() > this.f59644d && motionEvent.getX() < getWidth() - getScrollX()) {
                            if (this.E) {
                                i();
                            }
                            return true;
                        }
                    } else if ((-getScrollX()) > this.f59644d && motionEvent.getX() > (-getScrollX())) {
                        if (this.E) {
                            i();
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
            if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f59644d) {
                return true;
            }
            if (this.K) {
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft();
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
        super.onMeasure(i3, i16);
        setClickable(true);
        this.f59648i = 0;
        this.f59647h = 0;
        int childCount = getChildCount();
        boolean z16 = View.MeasureSpec.getMode(i16) != 1073741824;
        int i17 = 0;
        boolean z17 = false;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i16);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.f59647h = Math.max(this.f59647h, childAt.getMeasuredHeight());
                if (z16 && marginLayoutParams.height == -1) {
                    z17 = true;
                }
                if (i18 > 0) {
                    this.f59648i += childAt.getMeasuredWidth();
                } else {
                    this.C = childAt;
                    i17 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i17, this.f59647h + getPaddingTop() + getPaddingBottom());
        this.f59649m = (this.f59648i * 4) / 10;
        if (z17) {
            d(childCount, i3);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        return Math.abs(getScrollX()) <= this.f59644d && super.performLongClick();
    }

    public void setSwipeEnable(boolean z16) {
        this.I = z16;
    }

    public QZoneSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void i() {
        Q = null;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.N = ofInt;
        ofInt.addUpdateListener(new c());
        this.N.setInterpolator(new LinearInterpolator());
        this.N.addListener(new d());
        this.N.setDuration(200L).start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r2 != 3) goto L64;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerId(0) != 0) {
            return false;
        }
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
                            if (Math.abs(rawX) > this.f59644d) {
                                this.E = false;
                            }
                            scrollBy((int) rawX, 0);
                            if (this.L) {
                                if (getScrollX() < 0) {
                                    scrollTo(0, 0);
                                }
                                int scrollX = getScrollX();
                                int i3 = this.f59648i;
                                if (scrollX > i3) {
                                    scrollTo(i3, 0);
                                }
                            } else {
                                int scrollX2 = getScrollX();
                                int i16 = this.f59648i;
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
                if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f59644d) {
                    this.G = true;
                }
                if (!this.K) {
                    velocityTracker.computeCurrentVelocity(1000, this.f59645e);
                    float xVelocity = velocityTracker.getXVelocity(this.f59646f);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            if (this.L) {
                                j();
                            } else {
                                i();
                            }
                        } else if (this.L) {
                            i();
                        } else {
                            j();
                        }
                    } else if (Math.abs(getScrollX()) > this.f59649m) {
                        j();
                    } else {
                        i();
                    }
                }
                h();
                R = false;
            } else {
                this.f59646f = motionEvent.getPointerId(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public QZoneSwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new PointF();
        this.E = true;
        this.F = new PointF();
        f(context, attributeSet, i3);
    }

    private int e(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class f implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    public void setSwipeListener(e eVar) {
    }
}
