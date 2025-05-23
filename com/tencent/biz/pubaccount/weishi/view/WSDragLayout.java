package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDragLayout extends LinearLayout {
    private c C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    boolean H;
    boolean I;
    private ViewGroup J;
    private boolean K;
    private boolean L;
    float M;
    float N;
    float P;

    /* renamed from: d, reason: collision with root package name */
    private float f82407d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f82408e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f82409f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f82410h;

    /* renamed from: i, reason: collision with root package name */
    private int f82411i;

    /* renamed from: m, reason: collision with root package name */
    private Scroller f82412m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f82413d;

        a(int i3) {
            this.f82413d = i3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WSDragLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WSDragLayout wSDragLayout = WSDragLayout.this;
            wSDragLayout.E = wSDragLayout.getChildAt(0).getHeight();
            WSDragLayout.this.o(-(WSDragLayout.this.getHeight() - WSDragLayout.this.E), this.f82413d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f82415d;

        b(int i3) {
            this.f82415d = i3;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WSDragLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WSDragLayout wSDragLayout = WSDragLayout.this;
            wSDragLayout.E = wSDragLayout.getChildAt(0).getHeight();
            WSDragLayout.this.o(0, this.f82415d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(boolean z16);

        void b(int i3);

        void e(float f16);

        boolean g();

        void scrollToTop();
    }

    public WSDragLayout(Context context) {
        super(context);
        this.f82407d = 0.0f;
        this.f82408e = false;
        this.f82409f = true;
        this.f82410h = false;
        this.f82411i = 1;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        j();
    }

    private void g(float f16) {
        float f17 = -(f16 - this.f82407d);
        float c16 = c(f17);
        c cVar = this.C;
        if (cVar != null && this.D > 0) {
            cVar.e(Math.abs(getScrollY() + c16) / this.D);
        }
        if (this.f82408e && c16 != 0.0f) {
            scrollBy(0, (int) c16);
        } else if (c16 > 0.0f) {
            scrollBy(0, (int) c16);
        }
        if (Math.abs(f17) > 5.0f) {
            this.f82410h = true;
            this.L = c16 >= 0.0f;
        }
        c cVar2 = this.C;
        if (cVar2 != null) {
            cVar2.a(getScrollY() > 0);
        }
        this.f82407d = f16;
    }

    private void j() {
        this.f82412m = new Scroller(getContext());
        e();
    }

    private boolean l(View view, MotionEvent motionEvent) {
        if (this.f82408e) {
            return true;
        }
        if (this.f82409f && !m(view, motionEvent)) {
            return false;
        }
        this.f82408e = true;
        return true;
    }

    public float c(float f16) {
        return ((int) (((float) getScrollY()) + f16)) < BaseAIOUtils.f(this.H ? 0.0f : 20.0f, getContext().getResources()) ? f16 : r0 - getScrollY();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f82412m;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f82412m.getCurrX(), this.f82412m.getCurrY());
            x.i("WSDragLayout", "scrollY = " + this.f82412m.getCurrY() + "; dis = " + this.D);
            c cVar = this.C;
            if (cVar != null && this.D > 0) {
                cVar.e(Math.abs(this.f82412m.getCurrY()) / this.D);
            }
            invalidate();
            return;
        }
        if (this.F) {
            this.F = false;
            this.K = true;
            c cVar2 = this.C;
            if (cVar2 != null) {
                cVar2.e(1.0f);
                this.C.b(this.f82411i);
                return;
            }
            return;
        }
        if (this.G) {
            this.G = false;
            this.K = false;
            c cVar3 = this.C;
            if (cVar3 != null) {
                cVar3.e(0.0f);
                this.C.scrollToTop();
            }
        }
    }

    public boolean k() {
        return this.K;
    }

    public void n(int i3) {
        Scroller scroller = this.f82412m;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void o(int i3, int i16) {
        Scroller scroller = this.f82412m;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY(), i16);
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setContentView(ViewGroup viewGroup) {
        this.J = viewGroup;
    }

    public void setControlLitTongue(boolean z16) {
        this.f82409f = z16;
    }

    public void setDisableMinScrollY(boolean z16) {
        this.H = z16;
    }

    public void setMode(int i3) {
        this.f82411i = i3;
    }

    public void setTouchListener(c cVar) {
        this.C = cVar;
    }

    private boolean f(MotionEvent motionEvent) {
        if (getChildAt(0).isShown() && l(getChildAt(0), motionEvent)) {
            return false;
        }
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.P = 0.0f;
            this.I = false;
        }
        c cVar = this.C;
        if ((this.J.canScrollVertically(-1) || (cVar != null && cVar.g())) || motionEvent.getRawY() < this.P) {
            this.P = motionEvent.getRawY();
            this.M = motionEvent.getRawX();
            this.N = motionEvent.getRawY();
            if (getScrollY() == 0) {
                this.I = true;
                return true;
            }
        }
        if (this.I) {
            return true;
        }
        this.P = motionEvent.getRawY();
        return false;
    }

    private boolean h(MotionEvent motionEvent) {
        int i3;
        this.f82408e = false;
        this.I = false;
        if (!this.f82410h) {
            return true;
        }
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
        e();
        this.N = 0.0f;
        this.M = 0.0f;
        if (this.L) {
            this.G = true;
            n(0);
        } else if (this.C != null) {
            this.F = true;
            int i16 = this.E;
            if (i16 > 0) {
                i3 = this.D - i16;
            } else {
                i3 = this.D;
            }
            n(-i3);
        }
        return false;
    }

    public void d(int i3) {
        this.K = false;
        this.G = true;
        if (this.E > 0) {
            o(0, i3);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new b(i3));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 != 3) goto L24;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!l(getChildAt(0), motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (f(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    g(y16);
                    return true;
                }
            }
            if (h(motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
        this.I = false;
        this.f82410h = false;
        this.f82407d = motionEvent.getY();
        this.M = motionEvent.getRawX();
        this.N = motionEvent.getRawY();
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void i(int i3) {
        this.K = true;
        this.F = true;
        if (this.E > 0) {
            o(-(getHeight() - this.E), i3);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new a(i3));
        }
    }

    private int e() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
                if (i16 == 0) {
                    this.E = childAt.getHeight();
                }
            }
        }
        this.D = i3;
        return i3 / 4;
    }

    public static boolean m(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        return rawY >= i16 && rawY <= view.getMeasuredHeight() + i16 && rawX >= i3 && rawX <= view.getMeasuredWidth() + i3;
    }

    public WSDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82407d = 0.0f;
        this.f82408e = false;
        this.f82409f = true;
        this.f82410h = false;
        this.f82411i = 1;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        j();
    }

    public WSDragLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82407d = 0.0f;
        this.f82408e = false;
        this.f82409f = true;
        this.f82410h = false;
        this.f82411i = 1;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.M = 0.0f;
        this.N = 0.0f;
        this.P = 0.0f;
        j();
    }
}
