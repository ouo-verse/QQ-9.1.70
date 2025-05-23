package com.tencent.mobileqq.filemanager.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.filemanager.widget.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class HeaderScrollView extends LinearLayout {
    private View C;
    private int D;
    private int E;
    private int F;
    private int G;
    private VelocityTracker H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private c M;
    private float N;
    private float P;
    private float Q;
    public boolean R;
    private boolean S;
    private float T;

    /* renamed from: d, reason: collision with root package name */
    private int f209412d;

    /* renamed from: e, reason: collision with root package name */
    private Scroller f209413e;

    /* renamed from: f, reason: collision with root package name */
    private int f209414f;

    /* renamed from: h, reason: collision with root package name */
    private int f209415h;

    /* renamed from: i, reason: collision with root package name */
    private int f209416i;

    /* renamed from: m, reason: collision with root package name */
    private int f209417m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
    }

    public HeaderScrollView(Context context) {
        this(context, null);
    }

    private int a(int i3, int i16) {
        return i3 - i16;
    }

    private void b(int i3, int i16, int i17) {
        boolean z16;
        if (i3 + i17 <= i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.L = z16;
    }

    @SuppressLint({"NewApi"})
    private int c(int i3, int i16) {
        Scroller scroller = this.f209413e;
        if (scroller == null) {
            return 0;
        }
        if (this.f209417m >= 14) {
            return (int) scroller.getCurrVelocity();
        }
        return i3 / i16;
    }

    private void e(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void f() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f209413e.computeScrollOffset()) {
            int currY = this.f209413e.getCurrY();
            if (this.I == 1) {
                if (d()) {
                    int finalY = this.f209413e.getFinalY() - currY;
                    int a16 = a(this.f209413e.getDuration(), this.f209413e.timePassed());
                    this.M.h(c(finalY, a16), finalY, a16);
                    this.f209413e.abortAnimation();
                    return;
                }
                scrollTo(0, currY);
                invalidate();
            } else {
                if (this.M.e() || this.L) {
                    scrollTo(0, getScrollY() + (currY - this.J));
                    if (this.G <= this.F) {
                        this.f209413e.abortAnimation();
                        return;
                    }
                }
                invalidate();
            }
            this.J = currY;
        }
    }

    public boolean d() {
        if (this.G == this.E) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.N);
        float abs2 = Math.abs(y16 - this.P);
        e(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            int i3 = 2;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        f();
                    }
                } else if (!this.K) {
                    this.T = this.Q - y16;
                    this.Q = y16;
                    int i16 = this.f209414f;
                    if (abs > i16 && abs > 2.0f * abs2) {
                        this.R = false;
                    } else if (abs2 > i16 && abs2 > abs) {
                        this.R = true;
                    }
                    boolean d16 = d();
                    if (this.R && ((this.T > 0.0f && !d16) || this.M.e() || this.L)) {
                        if (!this.S) {
                            this.S = true;
                            this.M.f(false);
                        }
                        scrollBy(0, (int) (this.T + 0.5d));
                        invalidate();
                    }
                }
            } else {
                if (this.R) {
                    if (this.T < 0.0f || !d()) {
                        this.H.computeCurrentVelocity(1000, this.f209416i);
                        float yVelocity = this.H.getYVelocity();
                        if (yVelocity <= 0.0f) {
                            i3 = 1;
                        }
                        this.I = i3;
                        this.f209413e.fling(0, getScrollY(), 0, -((int) yVelocity), 0, 0, -2147483647, Integer.MAX_VALUE);
                        this.J = getScrollY();
                        invalidate();
                    }
                    int i17 = this.f209414f;
                    if ((abs > i17 || abs2 > i17) && (this.L || (this.G > 0 && !d()))) {
                        int action2 = motionEvent.getAction();
                        motionEvent.setAction(3);
                        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        motionEvent.setAction(action2);
                        return dispatchTouchEvent;
                    }
                }
                f();
            }
        } else {
            this.M.f(true);
            this.S = false;
            this.K = false;
            this.R = false;
            this.N = x16;
            this.P = y16;
            this.Q = y16;
            this.T = 0.0f;
            b((int) y16, this.D, getScrollY());
            this.f209413e.abortAnimation();
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view = this.C;
        if (view != null && !view.isClickable()) {
            this.C.setClickable(true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        View childAt = getChildAt(0);
        this.C = childAt;
        measureChildWithMargins(childAt, i3, 0, 0, 0);
        if (this.C.getVisibility() == 8) {
            this.D = 0;
        } else {
            this.D = this.C.getMeasuredHeight();
        }
        this.E = this.D - this.f209412d;
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16) + this.E, 1073741824));
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        int scrollY = getScrollY();
        int i17 = i16 + scrollY;
        int i18 = this.E;
        if (i17 >= i18 || i17 <= (i18 = this.F)) {
            i17 = i18;
        }
        super.scrollBy(i3, i17 - scrollY);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        int i17 = this.E;
        if (i16 >= i17 || i16 <= (i17 = this.F)) {
            i16 = i17;
        }
        this.G = i16;
        super.scrollTo(i3, i16);
    }

    public void setCurrentScrollableContainer(c.a aVar) {
        this.M.g(aVar);
    }

    public void setTopOffset(int i3) {
        this.f209412d = i3;
    }

    public HeaderScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeaderScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209412d = 0;
        this.E = 0;
        this.F = 0;
        this.R = false;
        this.S = false;
        this.T = 0.0f;
        this.f209413e = new Scroller(context);
        this.M = new c();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f209414f = viewConfiguration.getScaledTouchSlop();
        this.f209415h = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f209416i = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f209417m = Build.VERSION.SDK_INT;
    }

    public void setOnScrollListener(a aVar) {
    }
}
