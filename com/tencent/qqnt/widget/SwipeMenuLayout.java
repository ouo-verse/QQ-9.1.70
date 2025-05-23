package com.tencent.qqnt.widget;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SwipeMenuLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    private static SwipeMenuLayout R;
    private static boolean S;
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
    private e M;
    private ValueAnimator N;
    private ValueAnimator P;
    private boolean Q;

    /* renamed from: d, reason: collision with root package name */
    private int f363004d;

    /* renamed from: e, reason: collision with root package name */
    private int f363005e;

    /* renamed from: f, reason: collision with root package name */
    private int f363006f;

    /* renamed from: h, reason: collision with root package name */
    private int f363007h;

    /* renamed from: i, reason: collision with root package name */
    private int f363008i;

    /* renamed from: m, reason: collision with root package name */
    private int f363009m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwipeMenuLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SwipeMenuLayout.this.Q = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwipeMenuLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SwipeMenuLayout.this.Q = false;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface e {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class f implements Interpolator {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    public SwipeMenuLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void c() {
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.P.cancel();
        }
        ValueAnimator valueAnimator2 = this.N;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.N.cancel();
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

    private int e(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    public static SwipeMenuLayout f() {
        return R;
    }

    private void g(Context context, AttributeSet attributeSet, int i3) {
        try {
            this.f363004d = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f363005e = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        } catch (IndexOutOfBoundsException unused) {
            this.f363004d = 8;
            this.f363005e = 8000;
        }
        this.I = true;
        this.J = true;
        this.L = true;
    }

    private void i() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.H.recycle();
            this.H = null;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 12, (Object) this, (Object) attributeSet);
        }
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (this == R) {
            c();
            R.scrollTo(0, 0);
            R = null;
        }
    }

    public SwipeMenuLayout j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.J = z16;
        return this;
    }

    public SwipeMenuLayout k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SwipeMenuLayout) iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
        this.L = z16;
        return this;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        R = null;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(true);
        }
        c();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.P = ofInt;
        ofInt.addUpdateListener(new c());
        this.P.setInterpolator(new LinearInterpolator());
        this.P.addListener(new d());
        this.P.setDuration(200L).start();
        e eVar = this.M;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void m() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        SwipeMenuLayout swipeMenuLayout = R;
        if (swipeMenuLayout != null && swipeMenuLayout != this) {
            swipeMenuLayout.l();
        }
        R = this;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(false);
        }
        c();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        if (this.L) {
            i3 = this.f363008i;
        } else {
            i3 = -this.f363008i;
        }
        iArr[1] = i3;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.N = ofInt;
        ofInt.addUpdateListener(new a());
        this.N.setInterpolator(new f());
        this.N.addListener(new b());
        this.N.setDuration(e(this.f363008i, this.f363008i - getScrollX())).start();
        e eVar = this.M;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        SwipeMenuLayout swipeMenuLayout = R;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.l();
            R = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r0 != 2) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd A[RETURN] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.I) {
            if (motionEvent.getAction() == 0 && motionEvent.getPointerCount() > 1 && (swipeMenuLayout = R) != null && swipeMenuLayout != this) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    S = false;
                    if (this.L) {
                        if (getScrollX() > this.f363004d && motionEvent.getX() < getWidth() - getScrollX()) {
                            if (this.E) {
                                l();
                            }
                            return true;
                        }
                    } else if ((-getScrollX()) > this.f363004d && motionEvent.getX() > (-getScrollX())) {
                        if (this.E) {
                            l();
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
            } else {
                this.G = false;
                this.E = true;
                this.K = false;
                this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.F.set(motionEvent.getRawX(), motionEvent.getRawY());
                if (S) {
                    return false;
                }
                S = true;
                SwipeMenuLayout swipeMenuLayout2 = R;
                if (swipeMenuLayout2 != null) {
                    if (swipeMenuLayout2 != this) {
                        swipeMenuLayout2.l();
                        this.K = this.J;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f363004d) {
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        setClickable(true);
        this.f363008i = 0;
        this.f363007h = 0;
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
                this.f363007h = Math.max(this.f363007h, childAt.getMeasuredHeight());
                if (z16 && marginLayoutParams.height == -1) {
                    z17 = true;
                }
                if (i18 > 0) {
                    this.f363008i += childAt.getMeasuredWidth();
                } else {
                    this.C = childAt;
                    i17 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i17, this.f363007h + getPaddingTop() + getPaddingBottom());
        this.f363009m = (this.f363008i * 4) / 10;
        if (z17) {
            d(childCount, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        if (r3 != 3) goto L81;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        SwipeMenuLayout swipeMenuLayout = R;
        if (swipeMenuLayout != null && swipeMenuLayout != this) {
            return false;
        }
        if (motionEvent.getPointerId(0) != 0 && motionEvent.getPointerCount() > 1) {
            if (!this.I && !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
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
                            if (Math.abs(rawX) > this.f363004d) {
                                this.E = false;
                            }
                            scrollBy((int) rawX, 0);
                            if (this.L) {
                                if (getScrollX() < 0) {
                                    scrollTo(0, 0);
                                }
                                int scrollX = getScrollX();
                                int i3 = this.f363008i;
                                if (scrollX > i3) {
                                    scrollTo(i3, 0);
                                }
                            } else {
                                int scrollX2 = getScrollX();
                                int i16 = this.f363008i;
                                if (scrollX2 < (-i16)) {
                                    scrollTo(-i16, 0);
                                }
                                if (getScrollX() > 0) {
                                    scrollTo(0, 0);
                                }
                            }
                            R = this;
                            this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                        }
                    }
                }
                if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f363004d) {
                    this.G = true;
                }
                if (!this.K) {
                    velocityTracker.computeCurrentVelocity(1000, this.f363005e);
                    float xVelocity = velocityTracker.getXVelocity(this.f363006f);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            if (this.L) {
                                m();
                            } else {
                                l();
                            }
                        } else if (this.L) {
                            l();
                        } else {
                            m();
                        }
                    } else if (Math.abs(getScrollX()) > this.f363009m) {
                        m();
                    } else {
                        l();
                    }
                }
                i();
                S = false;
            } else {
                this.f363006f = motionEvent.getPointerId(0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (Math.abs(getScrollX()) > this.f363004d) {
            return false;
        }
        return super.performLongClick();
    }

    public void setSwipeEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.I = z16;
        }
    }

    public void setSwipeListener(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        } else {
            this.M = eVar;
        }
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = new PointF();
        this.E = true;
        this.F = new PointF();
        g(context, attributeSet, i3);
    }
}
