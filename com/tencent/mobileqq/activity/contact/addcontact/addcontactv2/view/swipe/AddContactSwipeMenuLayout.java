package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe;

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

/* compiled from: P */
/* loaded from: classes10.dex */
public class AddContactSwipeMenuLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    private static AddContactSwipeMenuLayout R;
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
    private c M;
    private ValueAnimator N;
    private ValueAnimator P;
    private boolean Q;

    /* renamed from: d, reason: collision with root package name */
    private int f180969d;

    /* renamed from: e, reason: collision with root package name */
    private int f180970e;

    /* renamed from: f, reason: collision with root package name */
    private int f180971f;

    /* renamed from: h, reason: collision with root package name */
    private int f180972h;

    /* renamed from: i, reason: collision with root package name */
    private int f180973i;

    /* renamed from: m, reason: collision with root package name */
    private int f180974m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddContactSwipeMenuLayout.this.Q = true;
                if (AddContactSwipeMenuLayout.this.M != null) {
                    AddContactSwipeMenuLayout.this.M.onAnimationEnd();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactSwipeMenuLayout.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AddContactSwipeMenuLayout.this.Q = false;
                if (AddContactSwipeMenuLayout.this.M != null) {
                    AddContactSwipeMenuLayout.this.M.onAnimationEnd();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
        }
    }

    public AddContactSwipeMenuLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void f() {
        ValueAnimator valueAnimator = this.P;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.P.cancel();
        }
        ValueAnimator valueAnimator2 = this.N;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.N.cancel();
        }
    }

    private void g(int i3, int i16) {
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

    private void h(Context context, AttributeSet attributeSet, int i3) {
        this.f180969d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f180970e = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.I = true;
        this.J = true;
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }

    private void l() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.H.recycle();
            this.H = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r1 != 3) goto L75;
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
        if (this.I) {
            e(motionEvent);
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
                            if (Math.abs(rawX) > this.f180969d) {
                                this.E = false;
                            }
                            scrollBy((int) rawX, 0);
                            if (this.L) {
                                if (getScrollX() < 0) {
                                    scrollTo(0, 0);
                                }
                                int scrollX = getScrollX();
                                int i3 = this.f180973i;
                                if (scrollX > i3) {
                                    scrollTo(i3, 0);
                                }
                            } else {
                                int scrollX2 = getScrollX();
                                int i16 = this.f180973i;
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
                if (Math.abs(motionEvent.getRawX() - this.F.x) > this.f180969d) {
                    this.G = true;
                }
                if (!this.K) {
                    velocityTracker.computeCurrentVelocity(1000, this.f180970e);
                    float xVelocity = velocityTracker.getXVelocity(this.f180971f);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            if (this.L) {
                                n();
                            } else {
                                m();
                            }
                        } else if (this.L) {
                            m();
                        } else {
                            n();
                        }
                    } else if (Math.abs(getScrollX()) > this.f180974m) {
                        n();
                    } else {
                        m();
                    }
                }
                l();
                S = false;
            } else {
                this.G = false;
                this.E = true;
                this.K = false;
                if (S) {
                    return false;
                }
                S = true;
                this.D.set(motionEvent.getRawX(), motionEvent.getRawY());
                this.F.set(motionEvent.getRawX(), motionEvent.getRawY());
                AddContactSwipeMenuLayout addContactSwipeMenuLayout = R;
                if (addContactSwipeMenuLayout != null) {
                    if (addContactSwipeMenuLayout != this) {
                        addContactSwipeMenuLayout.m();
                        this.K = this.J;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f180971f = motionEvent.getPointerId(0);
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

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this == R) {
            f();
            R.scrollTo(0, 0);
            R = null;
            this.Q = false;
            c cVar = this.M;
            if (cVar != null) {
                cVar.onAnimationEnd();
            }
        }
    }

    public void m() {
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
        f();
        ValueAnimator ofInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.P = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddContactSwipeMenuLayout.this.i(valueAnimator);
            }
        });
        this.P.setInterpolator(new AccelerateInterpolator());
        this.P.addListener(new b());
        this.P.setDuration(300L).start();
    }

    public void n() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        R = this;
        View view = this.C;
        if (view != null) {
            view.setLongClickable(false);
        }
        f();
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        if (this.L) {
            i3 = this.f180973i;
        } else {
            i3 = -this.f180973i;
        }
        iArr[1] = i3;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.N = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddContactSwipeMenuLayout.this.j(valueAnimator);
            }
        });
        this.N.setInterpolator(new OvershootInterpolator());
        this.N.addListener(new a());
        this.N.setDuration(300L).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        AddContactSwipeMenuLayout addContactSwipeMenuLayout = R;
        if (this == addContactSwipeMenuLayout) {
            addContactSwipeMenuLayout.m();
            R = null;
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
                if (action == 2 && Math.abs(motionEvent.getRawX() - this.F.x) > this.f180969d) {
                    return true;
                }
            } else {
                if (this.L) {
                    if (getScrollX() > this.f180969d && motionEvent.getX() < getWidth() - getScrollX()) {
                        if (this.E) {
                            m();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.f180969d && motionEvent.getX() > (-getScrollX())) {
                    if (this.E) {
                        m();
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
        this.f180973i = 0;
        this.f180972h = 0;
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
                this.f180972h = Math.max(this.f180972h, childAt.getMeasuredHeight());
                if (z16 && marginLayoutParams.height == -1) {
                    z17 = true;
                }
                if (i18 > 0) {
                    this.f180973i += childAt.getMeasuredWidth();
                } else {
                    this.C = childAt;
                    i17 = childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i17, this.f180972h + getPaddingTop() + getPaddingBottom());
        this.f180974m = (this.f180973i * 4) / 10;
        if (z17) {
            g(childCount, i3);
        }
    }

    @Override // android.view.View
    public boolean performLongClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (Math.abs(getScrollX()) > this.f180969d) {
            return false;
        }
        return super.performLongClick();
    }

    public void setOnAnimationEndListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else {
            this.M = cVar;
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

    public AddContactSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AddContactSwipeMenuLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = new PointF();
        this.E = true;
        this.F = new PointF();
        h(context, attributeSet, i3);
    }
}
