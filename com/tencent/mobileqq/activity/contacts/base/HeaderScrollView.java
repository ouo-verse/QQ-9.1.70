package com.tencent.mobileqq.activity.contacts.base;

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
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.activity.contacts.base.h;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class HeaderScrollView extends LinearLayout {
    static IPatchRedirector $redirector_;
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
    private boolean M;
    private a N;
    private h P;
    private float Q;
    private float R;
    private float S;
    public boolean T;
    private boolean U;
    private float V;

    /* renamed from: d, reason: collision with root package name */
    private int f181491d;

    /* renamed from: e, reason: collision with root package name */
    private Scroller f181492e;

    /* renamed from: f, reason: collision with root package name */
    private int f181493f;

    /* renamed from: h, reason: collision with root package name */
    private int f181494h;

    /* renamed from: i, reason: collision with root package name */
    private int f181495i;

    /* renamed from: m, reason: collision with root package name */
    private int f181496m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void onScroll(int i3, int i16);
    }

    public HeaderScrollView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
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
    private int d(int i3, int i16) {
        Scroller scroller = this.f181492e;
        if (scroller == null) {
            return 0;
        }
        if (this.f181496m >= 14) {
            return (int) scroller.getCurrVelocity();
        }
        return i3 / i16;
    }

    private void g(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    private void h() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.E;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f181492e.computeScrollOffset()) {
            int currY = this.f181492e.getCurrY();
            if (this.I == 1) {
                if (f()) {
                    int finalY = this.f181492e.getFinalY() - currY;
                    int a16 = a(this.f181492e.getDuration(), this.f181492e.timePassed());
                    this.P.h(d(finalY, a16), finalY, a16);
                    this.f181492e.abortAnimation();
                    return;
                }
                scrollTo(0, currY);
                invalidate();
            } else {
                if (this.P.e() || this.L || this.M) {
                    scrollTo(0, getScrollY() + (currY - this.J));
                    if (this.G <= this.F) {
                        this.M = false;
                        this.f181492e.abortAnimation();
                        return;
                    }
                }
                invalidate();
            }
            this.J = currY;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.Q);
        float abs2 = Math.abs(y16 - this.R);
        g(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            int i3 = 2;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        FrameHelperActivity.gj(true, HippyHeaderScrollViewController.CLASS_NAME);
                        h();
                    }
                } else if (!this.K) {
                    this.V = this.S - y16;
                    this.S = y16;
                    int i16 = this.f181493f;
                    if (abs > i16 && abs > 2.0f * abs2) {
                        this.T = false;
                    } else if (abs2 > i16 && abs2 > abs) {
                        this.T = true;
                    }
                    boolean f16 = f();
                    if (this.T && ((this.V > 0.0f && !f16) || this.P.e() || this.L)) {
                        if (!this.U) {
                            this.U = true;
                            this.P.f(false);
                        }
                        scrollBy(0, (int) (this.V + 0.5d));
                        invalidate();
                    }
                }
            } else {
                if (this.T) {
                    if (this.V < 0.0f || !f()) {
                        this.H.computeCurrentVelocity(1000, this.f181495i);
                        float yVelocity = this.H.getYVelocity();
                        if (yVelocity <= 0.0f) {
                            i3 = 1;
                        }
                        this.I = i3;
                        this.f181492e.fling(0, getScrollY(), 0, -((int) yVelocity), 0, 0, -2147483647, Integer.MAX_VALUE);
                        this.J = getScrollY();
                        invalidate();
                    }
                    int i17 = this.f181493f;
                    if ((abs > i17 || abs2 > i17) && (this.L || (this.G > 0 && !f()))) {
                        int action2 = motionEvent.getAction();
                        motionEvent.setAction(3);
                        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                        motionEvent.setAction(action2);
                        return dispatchTouchEvent;
                    }
                }
                FrameHelperActivity.gj(true, HippyHeaderScrollViewController.CLASS_NAME);
                h();
            }
        } else {
            this.P.f(true);
            this.U = false;
            this.K = false;
            this.T = false;
            this.Q = x16;
            this.R = y16;
            this.S = y16;
            this.V = 0.0f;
            b((int) y16, this.D, getScrollY());
            this.f181492e.abortAnimation();
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.G == this.F && this.P.e()) {
            return true;
        }
        return false;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.G == this.E) {
            return true;
        }
        return false;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.M = true;
        this.I = 2;
        this.f181492e.startScroll(0, getScrollY(), 0, -getScrollY());
        this.J = getScrollY();
        this.P.i();
        invalidate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onFinishInflate();
        View view = this.C;
        if (view != null && !view.isClickable()) {
            this.C.setClickable(true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        View childAt = getChildAt(0);
        this.C = childAt;
        measureChildWithMargins(childAt, i3, 0, 0, 0);
        if (this.C.getVisibility() == 8) {
            this.D = 0;
        } else {
            this.D = this.C.getMeasuredHeight();
        }
        this.E = this.D - this.f181491d;
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i16) + this.E, 1073741824));
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = this.E;
        if (i16 >= i17) {
            i16 = i17;
        } else {
            int i18 = this.F;
            if (i16 <= i18) {
                i16 = i18;
            }
        }
        this.G = i16;
        a aVar = this.N;
        if (aVar != null) {
            aVar.onScroll(i16, i17);
        }
        super.scrollTo(i3, i16);
    }

    public void setCurrentScrollableContainer(h.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) aVar);
        } else {
            this.P.g(aVar);
        }
    }

    public void setOnScrollListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.N = aVar;
        }
    }

    public void setTopOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f181491d = i3;
        }
    }

    public HeaderScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public HeaderScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181491d = 0;
        this.E = 0;
        this.F = 0;
        this.T = false;
        this.U = false;
        this.V = 0.0f;
        this.f181492e = new Scroller(context);
        this.P = new h();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f181493f = viewConfiguration.getScaledTouchSlop();
        this.f181494h = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f181495i = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f181496m = Build.VERSION.SDK_INT;
    }
}
