package com.tencent.mobileqq.troop.widget.swipe;

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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CommonSwipeMenuLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    private static final WeakReference<CommonSwipeMenuLayout> Q;
    private static WeakReference<CommonSwipeMenuLayout> R;
    private static boolean S;
    private int C;
    private int D;
    private View E;
    private boolean F;
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
    private final PointF f302652d;

    /* renamed from: e, reason: collision with root package name */
    private final PointF f302653e;

    /* renamed from: f, reason: collision with root package name */
    private int f302654f;

    /* renamed from: h, reason: collision with root package name */
    private int f302655h;

    /* renamed from: i, reason: collision with root package name */
    private int f302656i;

    /* renamed from: m, reason: collision with root package name */
    private int f302657m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                CommonSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CommonSwipeMenuLayout.this.P = true;
                CommonSwipeMenuLayout.b(CommonSwipeMenuLayout.this);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
            } else {
                CommonSwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CommonSwipeMenuLayout.this.P = false;
                CommonSwipeMenuLayout.b(CommonSwipeMenuLayout.this);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        WeakReference<CommonSwipeMenuLayout> weakReference = new WeakReference<>(null);
        Q = weakReference;
        R = weakReference;
    }

    public CommonSwipeMenuLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    static /* synthetic */ com.tencent.mobileqq.troop.widget.swipe.a b(CommonSwipeMenuLayout commonSwipeMenuLayout) {
        commonSwipeMenuLayout.getClass();
        return null;
    }

    private void c(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void d() {
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.N.cancel();
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.M.cancel();
        }
    }

    private void e(int i3, int i16) {
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

    public static WeakReference<CommonSwipeMenuLayout> f() {
        return R;
    }

    private void g(Context context, AttributeSet attributeSet, int i3) {
        this.f302654f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f302655h = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
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

    private void l(boolean z16) {
        if (z16) {
            k();
        } else {
            j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r1 != 3) goto L73;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (QLog.isDebugVersion()) {
            QLog.d("CommonSwipeMenuLayout", 4, "[dispatchTouchEvent] " + motionEvent.getAction());
        }
        if (this.I) {
            c(motionEvent);
            VelocityTracker velocityTracker = this.H;
            int action = motionEvent.getAction();
            boolean z16 = true;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (!this.K) {
                            float rawX = this.f302652d.x - motionEvent.getRawX();
                            if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (Math.abs(rawX) > this.f302654f) {
                                this.F = false;
                            }
                            scrollBy((int) rawX, 0);
                            if (this.L) {
                                if (getScrollX() < 0) {
                                    scrollTo(0, 0);
                                }
                                int scrollX = getScrollX();
                                int i3 = this.C;
                                if (scrollX > i3) {
                                    scrollTo(i3, 0);
                                }
                            } else {
                                int scrollX2 = getScrollX();
                                int i16 = this.C;
                                if (scrollX2 < (-i16)) {
                                    scrollTo(-i16, 0);
                                }
                                if (getScrollX() > 0) {
                                    scrollTo(0, 0);
                                }
                            }
                            this.f302652d.set(motionEvent.getRawX(), motionEvent.getRawY());
                        }
                    }
                }
                if (Math.abs(motionEvent.getRawX() - this.f302653e.x) > this.f302654f) {
                    this.G = true;
                }
                if (!this.K) {
                    velocityTracker.computeCurrentVelocity(1000, this.f302655h);
                    float xVelocity = velocityTracker.getXVelocity(this.f302656i);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            l(this.L);
                        } else {
                            l(!this.L);
                        }
                    } else {
                        if (Math.abs(getScrollX()) <= this.D) {
                            z16 = false;
                        }
                        l(z16);
                    }
                }
                i();
                S = false;
            } else {
                this.G = false;
                this.F = true;
                this.K = false;
                if (S) {
                    return false;
                }
                S = true;
                this.f302652d.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.f302653e.set(motionEvent.getRawX(), motionEvent.getRawY());
                CommonSwipeMenuLayout commonSwipeMenuLayout = R.get();
                if (commonSwipeMenuLayout != null) {
                    if (commonSwipeMenuLayout != this) {
                        commonSwipeMenuLayout.j();
                        this.K = this.J;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f302656i = motionEvent.getPointerId(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
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
        } else if (this == R.get()) {
            d();
            scrollTo(0, 0);
            R = Q;
            this.P = false;
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        R = Q;
        View view = this.E;
        if (view != null) {
            view.setLongClickable(true);
        }
        d();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.N = ofInt;
        ofInt.addUpdateListener(new c());
        this.N.setInterpolator(new AccelerateInterpolator());
        this.N.addListener(new d());
        this.N.setDuration(300L).start();
    }

    public void k() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        R = new WeakReference<>(this);
        View view = this.E;
        if (view != null) {
            view.setLongClickable(false);
        }
        d();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        if (this.L) {
            i3 = this.C;
        } else {
            i3 = -this.C;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this == R.get()) {
            j();
            R = Q;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.I) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.f302653e.x) > this.f302654f) {
                    return true;
                }
            } else {
                if (this.L) {
                    if (getScrollX() > this.f302654f && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.F) {
                            j();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f302654f && motionEvent.getX() > (-getScrollX())) {
                    if (this.F) {
                        j();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
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
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        setClickable(true);
        this.C = 0;
        this.f302657m = 0;
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
                this.f302657m = Math.max(this.f302657m, childAt.getMeasuredHeight());
                if (z16 && marginLayoutParams.height == -1) {
                    z17 = true;
                }
                if (i18 > 0) {
                    this.C += childAt.getMeasuredWidth();
                } else {
                    this.E = childAt;
                    i17 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i17, this.f302657m + getPaddingTop() + getPaddingBottom());
        this.D = (this.C * 4) / 10;
        if (z17) {
            e(childCount, i3);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (Math.abs(getScrollX()) > this.f302654f) {
            return false;
        }
        return super.performLongClick();
    }

    public void setOnAnimationEndListener(com.tencent.mobileqq.troop.widget.swipe.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        }
    }

    public void setSwipeEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.I = z16;
        }
    }

    public CommonSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CommonSwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302652d = new PointF();
        this.f302653e = new PointF();
        this.F = true;
        g(context, attributeSet, i3);
    }
}
