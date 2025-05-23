package com.tencent.guild.aio.input.at.quickAt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public class AtPanelTouchController extends LinearLayout {
    protected a C;
    protected b D;
    protected int E;
    protected boolean F;
    boolean G;
    protected View H;
    protected int I;
    protected float J;
    protected float K;
    private boolean L;
    protected boolean M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    protected float f111014d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f111015e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f111016f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f111017h;

    /* renamed from: i, reason: collision with root package name */
    protected int f111018i;

    /* renamed from: m, reason: collision with root package name */
    protected Scroller f111019m;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z16);

        void b(int i3);

        void scrollToTop();
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean c();
    }

    public AtPanelTouchController(@NonNull Context context) {
        super(context);
        this.f111014d = 0.0f;
        this.f111015e = false;
        this.f111016f = true;
        this.f111017h = false;
        this.f111018i = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        this.M = false;
        this.N = false;
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        if (r5 != 3) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        boolean z16;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.J);
        float abs2 = Math.abs(y16 - this.K);
        float y17 = motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = -(y17 - this.f111014d);
                    float a16 = a(f16);
                    if (QLog.isColorLevel()) {
                        QLog.d("UUUU", 2, "NKSS=" + a16 + " differ=" + f16);
                    }
                    if (this.f111015e && a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                        this.M = true;
                    } else if (this.L && abs2 > this.I && abs2 > abs) {
                        scrollBy(0, (int) a16);
                        this.M = true;
                    } else if (a16 > 0.0f) {
                        scrollBy(0, (int) a16);
                        this.M = true;
                    } else {
                        this.M = false;
                    }
                    if (Math.abs(f16) > 5.0f) {
                        this.f111017h = true;
                    }
                    a aVar = this.C;
                    if (aVar != null) {
                        if (getScrollY() > 0) {
                            z17 = true;
                        }
                        aVar.a(z17);
                    }
                    this.f111014d = y17;
                    if (this.L && !this.M) {
                        super.dispatchTouchEvent(motionEvent);
                    }
                    return true;
                }
            }
            this.f111015e = false;
            if (!this.f111017h) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!this.L) {
                motionEvent.setAction(3);
            }
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                h(0);
            } else if (this.C != null) {
                this.F = true;
                h(-this.E);
            }
            return false;
        }
        this.f111017h = false;
        this.f111014d = motionEvent.getY();
        this.J = x16;
        this.K = y16;
        this.M = false;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private int c() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
            }
        }
        this.E = i3;
        return i3 / 3;
    }

    private void d() {
        this.f111019m = new Scroller(getContext());
        this.I = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static boolean f(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }

    public float a(float f16) {
        float f17;
        if (this.G) {
            f17 = 0.0f;
        } else {
            f17 = 20.0f;
        }
        int n3 = Utils.n(f17, getContext().getResources());
        int scrollY = (int) (getScrollY() + f16);
        if (scrollY < n3) {
            return f16;
        }
        if (scrollY < n3) {
            return 0.0f;
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.scrollToTop();
        }
        return n3 - getScrollY();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f111019m;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f111019m.getCurrX(), this.f111019m.getCurrY());
            invalidate();
        } else if (this.F) {
            this.F = false;
            a aVar = this.C;
            if (aVar != null) {
                aVar.b(this.f111018i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.N) {
            return super.dispatchTouchEvent(motionEvent);
        }
        View view = this.H;
        if (view == null) {
            view = getChildAt(0);
        }
        if (!e(view, motionEvent) && this.f111018i != 1) {
            if (this.L && (bVar = this.D) != null && bVar.c()) {
                return b(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return b(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(View view, MotionEvent motionEvent) {
        if (this.f111015e) {
            return true;
        }
        if (this.f111016f && !f(view, motionEvent)) {
            return false;
        }
        this.f111015e = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(boolean z16) {
        this.N = z16;
    }

    public void h(int i3) {
        Scroller scroller = this.f111019m;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void i(int i3, int i16) {
        Scroller scroller = this.f111019m;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY(), i16);
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAtPanelTouchListener(a aVar) {
        this.C = aVar;
    }

    public void setControlLitTongue(boolean z16) {
        this.f111016f = z16;
    }

    public void setCustomParam(b bVar, boolean z16) {
        this.L = z16;
        this.D = bVar;
    }

    public void setDisableMinScrollY(boolean z16) {
        this.G = z16;
    }

    public void setHeadView(View view) {
        this.H = view;
    }

    public void setMode(int i3) {
        this.f111018i = i3;
    }

    public AtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f111014d = 0.0f;
        this.f111015e = false;
        this.f111016f = true;
        this.f111017h = false;
        this.f111018i = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        this.M = false;
        this.N = false;
        d();
    }

    public AtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f111014d = 0.0f;
        this.f111015e = false;
        this.f111016f = true;
        this.f111017h = false;
        this.f111018i = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        this.M = false;
        this.N = false;
        d();
    }
}
