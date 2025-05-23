package com.tencent.mobileqq.aio.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AIOMsgAvatarAreaGroup extends FrameLayout implements NestedScrollingChild3 {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    private final int[] F;
    private final int[] G;
    private boolean H;
    private int I;
    int J;

    @SuppressLint({"DrawAllocation"})
    int[] K;

    /* renamed from: d, reason: collision with root package name */
    private final NestedScrollingChildHelper f194182d;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f194183e;

    /* renamed from: f, reason: collision with root package name */
    private int f194184f;

    /* renamed from: h, reason: collision with root package name */
    private int f194185h;

    /* renamed from: i, reason: collision with root package name */
    private OverScroller f194186i;

    /* renamed from: m, reason: collision with root package name */
    private int f194187m;

    public AIOMsgAvatarAreaGroup(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = -1;
        this.F = new int[2];
        this.G = new int[2];
        this.H = false;
        this.J = 0;
        this.K = new int[2];
        this.f194182d = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.f194186i = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f194187m = viewConfiguration.getScaledTouchSlop();
        this.C = viewConfiguration.getScaledMinimumFlingVelocity();
        this.D = viewConfiguration.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(true);
    }

    private void a() {
        this.f194186i.abortAnimation();
        stopNestedScroll(1);
    }

    private void b() {
        this.H = false;
        h();
        stopNestedScroll(0);
    }

    private boolean d(int i3, int i16) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i16 < childAt.getTop() - scrollY || i16 >= childAt.getBottom() - scrollY || i3 < childAt.getLeft() || i3 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void e() {
        VelocityTracker velocityTracker = this.f194183e;
        if (velocityTracker == null) {
            this.f194183e = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void f() {
        if (this.f194183e == null) {
            this.f194183e = VelocityTracker.obtain();
        }
    }

    private void g(MotionEvent motionEvent) {
        int i3;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.E) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.I = (int) motionEvent.getY(i3);
            this.E = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f194183e;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void h() {
        VelocityTracker velocityTracker = this.f194183e;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f194183e = null;
        }
    }

    private void i(boolean z16) {
        if (z16) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.f194185h = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else if (getChildCount() > 0) {
            this.f194186i.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            i(true);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.f194186i.isFinished()) {
            return;
        }
        this.f194186i.computeScrollOffset();
        int currY = this.f194186i.getCurrY();
        int i3 = currY - this.f194185h;
        this.f194185h = currY;
        int[] iArr = this.G;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i3, iArr, null, 1);
        int i16 = i3 - this.G[1];
        if (i16 != 0) {
            int scrollY = getScrollY() - getScrollY();
            int[] iArr2 = this.G;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY, 0, i16 - scrollY, this.F, 1, iArr2);
            int i17 = this.G[1];
        }
        if (!this.f194186i.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            stopNestedScroll(1);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16))).booleanValue();
        }
        return this.f194182d.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        return this.f194182d.dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, iArr2, Integer.valueOf(i17))).booleanValue();
        }
        return this.f194182d.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f194182d.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
        } else {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), iArr, Integer.valueOf(i19), iArr2);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f194182d.hasNestedScrollingParent(i3) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f194182d.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.H) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            g(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.E;
                    if (i16 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i16)) != -1) {
                        int y16 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y16 - this.I) > this.f194187m && (2 & getNestedScrollAxes()) == 0) {
                            this.H = true;
                            this.I = y16;
                            f();
                            this.f194183e.addMovement(motionEvent);
                            this.f194184f = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
            }
            this.H = false;
            this.E = -1;
            h();
            stopNestedScroll(0);
        } else {
            int y17 = (int) motionEvent.getY();
            if (!d((int) motionEvent.getX(), y17)) {
                this.H = false;
                h();
            } else {
                this.I = y17;
                this.E = motionEvent.getPointerId(0);
                e();
                this.f194183e.addMovement(motionEvent);
                this.f194186i.computeScrollOffset();
                this.H = !this.f194186i.isFinished();
                startNestedScroll(2, 0);
            }
        }
        return this.H;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        getLocationInWindow(this.K);
        int i19 = this.K[1];
        int i26 = this.J;
        if (i19 != i26) {
            this.I -= i19 - i26;
        }
        this.J = i19;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        VelocityTracker velocityTracker;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f194184f = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f194184f);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                g(motionEvent);
                                this.I = (int) motionEvent.getY(motionEvent.findPointerIndex(this.E));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.I = (int) motionEvent.getY(actionIndex);
                            this.E = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        this.E = -1;
                        b();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.E);
                    if (findPointerIndex != -1) {
                        int y16 = (int) motionEvent.getY(findPointerIndex);
                        int i3 = this.I - y16;
                        if (dispatchNestedPreScroll(0, i3, this.G, this.F, 0)) {
                            i3 -= this.G[1];
                            this.f194184f += this.F[1];
                        }
                        int i16 = i3;
                        if (this.H) {
                            this.I = y16 - this.F[1];
                            if (!hasNestedScrollingParent(0) && (velocityTracker = this.f194183e) != null) {
                                velocityTracker.clear();
                            }
                            int[] iArr = this.G;
                            iArr[1] = 0;
                            dispatchNestedScroll(0, 0, 0, i16, this.F, 0, iArr);
                            int i17 = this.I;
                            int i18 = this.F[1];
                            this.I = i17 - i18;
                            this.f194184f += i18;
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker2 = this.f194183e;
                velocityTracker2.computeCurrentVelocity(1000, this.D);
                int yVelocity = (int) velocityTracker2.getYVelocity(this.E);
                if (Math.abs(yVelocity) >= this.C) {
                    int i19 = -yVelocity;
                    float f16 = i19;
                    if (!dispatchNestedPreFling(0.0f, f16)) {
                        dispatchNestedFling(0.0f, f16, true);
                        c(i19);
                    }
                }
                this.E = -1;
                b();
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean z16 = !this.f194186i.isFinished();
            this.H = z16;
            if (z16 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f194186i.isFinished()) {
                a();
            }
            this.I = (int) motionEvent.getY();
            this.E = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker3 = this.f194183e;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(obtain);
        }
        obtain.recycle();
        return this.H;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        if (z16) {
            h();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            super.setNestedScrollingEnabled(z16);
            this.f194182d.setNestedScrollingEnabled(z16);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f194182d.startNestedScroll(i3, i16) : ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f194182d.stopNestedScroll(i3);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this.f194182d.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19) : ((Boolean) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), iArr, Integer.valueOf(i19))).booleanValue();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? hasNestedScrollingParent(0) : ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? startNestedScroll(i3, 0) : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            stopNestedScroll(0);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
