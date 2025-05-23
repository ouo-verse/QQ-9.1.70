package com.tencent.mobileqq.guild.media.thirdapp.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMediaNestedFrameLayout extends FrameLayout implements NestedScrollingChild3 {
    private int C;
    private int D;
    private int E;
    private OverScroller F;
    private int G;
    private int H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f229570d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f229571e;

    /* renamed from: f, reason: collision with root package name */
    private int f229572f;

    /* renamed from: h, reason: collision with root package name */
    private NestedScrollingChildHelper f229573h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f229574i;

    /* renamed from: m, reason: collision with root package name */
    private VelocityTracker f229575m;

    public GuildMediaNestedFrameLayout(Context context) {
        this(context, null);
    }

    private void a() {
        this.F.abortAnimation();
        stopNestedScroll(1);
    }

    private void b() {
        this.f229574i = false;
        j();
        stopNestedScroll();
    }

    private void c(int i3) {
        this.F.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight() / 2);
        k(true);
    }

    private void e() {
        VelocityTracker velocityTracker = this.f229575m;
        if (velocityTracker == null) {
            this.f229575m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void f() {
        this.F = new OverScroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.C = viewConfiguration.getScaledTouchSlop();
        this.G = viewConfiguration.getScaledMinimumFlingVelocity();
        this.H = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void g() {
        if (this.f229575m == null) {
            this.f229575m = VelocityTracker.obtain();
        }
    }

    private void h(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.D) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f229572f = (int) motionEvent.getY(i3);
            this.D = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.f229575m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean i(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i29;
        int i36;
        boolean z27;
        boolean z28;
        int overScrollMode = getOverScrollMode();
        if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (overScrollMode != 0 && (overScrollMode != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i37 = i17 + i3;
        if (!z19) {
            i29 = 0;
        } else {
            i29 = i27;
        }
        int i38 = i18 + i16;
        if (!z26) {
            i36 = 0;
        } else {
            i36 = i28;
        }
        int i39 = -i29;
        int i46 = i29 + i19;
        int i47 = -i36;
        int i48 = i36 + i26;
        if (i37 > i46) {
            i37 = i46;
            z27 = true;
        } else if (i37 < i39) {
            z27 = true;
            i37 = i39;
        } else {
            z27 = false;
        }
        if (i38 > i48) {
            i38 = i48;
            z28 = true;
        } else if (i38 < i47) {
            z28 = true;
            i38 = i47;
        } else {
            z28 = false;
        }
        if (z28 && !hasNestedScrollingParent(1)) {
            this.F.springBack(i37, i38, 0, 0, 0, d());
        }
        onOverScrolled(i37, i38, z27, z28);
        if (!z27 && !z28) {
            return false;
        }
        return true;
    }

    private void j() {
        VelocityTracker velocityTracker = this.f229575m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f229575m = null;
        }
    }

    private void k(boolean z16) {
        if (z16) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.I = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.F.isFinished()) {
            return;
        }
        this.F.computeScrollOffset();
        int currY = this.F.getCurrY();
        int i3 = currY - this.I;
        this.I = currY;
        int[] iArr = this.f229571e;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i3, iArr, null, 1);
        int i16 = i3 - this.f229571e[1];
        if (i16 != 0) {
            int scrollY = getScrollY();
            i(0, i16, getScrollX(), scrollY, 0, d(), 0, 0, false);
            int scrollY2 = i16 - (getScrollY() - scrollY);
            int[] iArr2 = this.f229571e;
            iArr2[1] = 0;
            dispatchNestedScroll(0, 0, 0, scrollY2, this.f229570d, 1, iArr2);
            i16 = scrollY2 - this.f229571e[1];
        }
        if (i16 != 0) {
            a();
        }
        if (!this.F.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int d() {
        return computeVerticalScrollRange();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.f229573h.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.f229573h.dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i3, i16, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return dispatchNestedScroll(i3, i16, i17, i18, iArr, 0);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return this.f229573h.hasNestedScrollingParent(i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f229573h.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f229574i) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            h(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.D;
                    if (i16 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i16);
                        if (findPointerIndex == -1) {
                            QLog.e("NestedWebView", 1, "Invalid pointerId=" + i16 + " in onInterceptTouchEvent");
                        } else {
                            int y16 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y16 - this.f229572f) > this.C && (2 & getNestedScrollAxes()) == 0) {
                                this.f229574i = true;
                                this.f229572f = y16;
                                g();
                                this.f229575m.addMovement(motionEvent);
                                this.E = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f229574i = false;
            this.D = -1;
            j();
            if (this.F.springBack(getScrollX(), getScrollY(), 0, 0, 0, d())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll();
        } else {
            this.f229572f = (int) motionEvent.getY();
            this.D = motionEvent.getPointerId(0);
            e();
            this.f229575m.addMovement(motionEvent);
            this.F.computeScrollOffset();
            this.f229574i = !this.F.isFinished();
            startNestedScroll(2);
        }
        return this.f229574i;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        VelocityTracker velocityTracker;
        g();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.E = 0;
        }
        obtain.offsetLocation(0.0f, this.E);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                h(motionEvent);
                                this.f229572f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.D));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f229572f = (int) motionEvent.getY(actionIndex);
                            this.D = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.f229574i && this.F.springBack(getScrollX(), getScrollY(), 0, 0, 0, d())) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                        this.D = -1;
                        b();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.D);
                    if (findPointerIndex == -1) {
                        QLog.e("NestedWebView", 1, "Invalid pointerId=" + this.D + " in onTouchEvent");
                    } else {
                        int y16 = (int) motionEvent.getY(findPointerIndex);
                        int i3 = this.f229572f - y16;
                        if (dispatchNestedPreScroll(0, i3, this.f229571e, this.f229570d, 0)) {
                            i3 -= this.f229571e[1];
                            this.E += this.f229570d[1];
                        }
                        if (!this.f229574i && Math.abs(i3) > this.C) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.f229574i = true;
                            if (i3 > 0) {
                                i3 -= this.C;
                            } else {
                                i3 += this.C;
                            }
                        }
                        int i16 = i3;
                        if (this.f229574i) {
                            this.f229572f = y16 - this.f229570d[1];
                            int scrollY = getScrollY();
                            if (i(0, i16, 0, scrollY, 0, d(), 0, 0, true) && !hasNestedScrollingParent(0) && (velocityTracker = this.f229575m) != null) {
                                velocityTracker.clear();
                            }
                            int scrollY2 = getScrollY() - scrollY;
                            int[] iArr = this.f229571e;
                            iArr[1] = 0;
                            dispatchNestedScroll(0, scrollY2, 0, i16 - scrollY2, this.f229570d, 0, iArr);
                            int i17 = this.f229572f;
                            int i18 = this.f229570d[1];
                            this.f229572f = i17 - i18;
                            this.E += i18;
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker2 = this.f229575m;
                velocityTracker2.computeCurrentVelocity(1000, this.H);
                int yVelocity = (int) velocityTracker2.getYVelocity(this.D);
                if (Math.abs(yVelocity) > this.G) {
                    int i19 = -yVelocity;
                    float f16 = i19;
                    if (!dispatchNestedPreFling(0.0f, f16)) {
                        dispatchNestedFling(0.0f, f16, true);
                        c(i19);
                    }
                } else if (this.F.springBack(getScrollX(), getScrollY(), 0, 0, 0, d())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.D = -1;
                b();
            }
        } else {
            boolean z16 = !this.F.isFinished();
            this.f229574i = z16;
            if (z16 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.F.isFinished()) {
                a();
            }
            this.f229572f = (int) motionEvent.getY();
            this.D = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker3 = this.f229575m;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(obtain);
        }
        obtain.recycle();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (!this.f229574i) {
            i(i3, i16, i17, i18, i19, i26, i27, i28, z16);
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        if (z16) {
            j();
        }
        super.requestDisallowInterceptTouchEvent(z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.f229573h.setNestedScrollingEnabled(z16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return this.f229573h.startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        this.f229573h.stopNestedScroll(i3);
    }

    public GuildMediaNestedFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.webViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return this.f229573h.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return this.f229573h.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return startNestedScroll(i3, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public GuildMediaNestedFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f229570d = new int[2];
        this.f229571e = new int[2];
        this.f229574i = false;
        this.D = -1;
        setOverScrollMode(2);
        f();
        this.f229573h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        this.f229573h.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
    }
}
