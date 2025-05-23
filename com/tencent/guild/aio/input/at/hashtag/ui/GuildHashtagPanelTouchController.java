package com.tencent.guild.aio.input.at.hashtag.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.ui.GuildAtPanelTouchController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public class GuildHashtagPanelTouchController extends LinearLayout {
    private static String U = "GuildHashtagPanel";
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    protected Scroller f110901d;

    /* renamed from: e, reason: collision with root package name */
    protected View f110902e;

    /* renamed from: f, reason: collision with root package name */
    protected View f110903f;

    /* renamed from: h, reason: collision with root package name */
    private a f110904h;

    /* renamed from: i, reason: collision with root package name */
    private GuildAtPanelTouchController.a f110905i;

    /* renamed from: m, reason: collision with root package name */
    private int f110906m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z16);

        void b(int i3);

        void scrollToTop();
    }

    public GuildHashtagPanelTouchController(@NonNull Context context, View view) {
        super(context);
        this.f110906m = -1;
        this.C = 0;
        this.D = 28;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.f110902e = view;
        k();
    }

    private boolean a(int i3) {
        GuildAtPanelTouchController.a aVar = this.f110905i;
        if (aVar != null) {
            return aVar.a(i3);
        }
        return true;
    }

    private boolean b(int i3, float f16, float f17) {
        boolean z16 = true;
        if (getScrollY() >= 0 && (!a(i3) || f17 <= this.D || f17 <= f16)) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(U, 4, "canVerticalScroll= " + z16);
        }
        return z16;
    }

    private int f() {
        if (this.I == 1) {
            return h() - this.C;
        }
        return this.C / 3;
    }

    private int g() {
        int height = getHeight() - h();
        this.H = height * 2;
        return height / 3;
    }

    private int h() {
        int i3 = this.f110906m;
        if (i3 > 0 && !this.L) {
            return i3;
        }
        int top = (int) (this.f110902e.getTop() + this.f110902e.getTranslationY());
        this.f110906m = top;
        this.L = false;
        return top;
    }

    protected static boolean m(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        view.getLocationOnScreen(new int[2]);
        int rawX = (int) (motionEvent.getRawX() - r1[0]);
        int rawY = (int) (motionEvent.getRawY() - r1[1]);
        if (rawX < 0 || rawY < 0 || rawX >= view.getMeasuredWidth() || rawY >= view.getMeasuredHeight()) {
            return false;
        }
        return true;
    }

    protected void c() {
        boolean z16;
        a aVar = this.f110904h;
        if (aVar != null) {
            if (getScrollY() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.a(z16);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f110901d;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f110901d.getCurrX(), this.f110901d.getCurrY());
            invalidate();
        } else if (this.T) {
            this.T = false;
            a aVar = this.f110904h;
            if (aVar != null) {
                aVar.b(this.I);
            }
        }
    }

    protected float d(float f16) {
        int scrollY = getScrollY();
        if (scrollY + f16 > f()) {
            return r1 - scrollY;
        }
        return f16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return q(motionEvent);
                }
            }
            return r(motionEvent);
        }
        return p(motionEvent);
    }

    public View e() {
        return this.f110902e;
    }

    protected void i(MotionEvent motionEvent) {
        this.N = true;
        if (this.P) {
            this.P = false;
            motionEvent.setAction(0);
        }
        if (!this.Q) {
            super.dispatchTouchEvent(motionEvent);
        } else {
            this.Q = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(U, 2, "super.dispatchTouchEvent action=" + motionEvent.getAction());
        }
    }

    protected boolean j(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.F);
        float abs2 = Math.abs(y16 - this.G);
        float f16 = this.E - y16;
        int d16 = (int) d(f16);
        boolean z18 = false;
        if (this.I == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.M && (abs <= abs2 || abs <= this.D)) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.M = z17;
        int scrollY = getScrollY();
        if (QLog.isDevelopLevel()) {
            QLog.d(U, 4, "scrollByY + currentScrollY=" + (scrollY + f16) + " scrollByY=" + f16 + " currentScrollY=" + scrollY + " mMaxScrollY=" + f());
        }
        if (z16) {
            if (f16 + scrollY > f()) {
                a aVar = this.f110904h;
                if (aVar != null) {
                    aVar.scrollToTop();
                    scrollBy(0, d16);
                    o();
                }
            } else {
                scrollBy(0, d16);
            }
            if (this.K || abs2 > this.D) {
                z18 = true;
            }
            this.K = z18;
            this.P = true;
        } else {
            boolean b16 = b((int) f16, abs, abs2);
            this.S = b16;
            if (!this.J && !b16) {
                i(motionEvent);
            } else {
                this.P = true;
                if (this.N) {
                    this.N = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                scrollBy(0, d16);
                if (this.K || abs2 > this.D) {
                    z18 = true;
                }
                this.K = z18;
                if (QLog.isDevelopLevel()) {
                    QLog.d(U, 4, "panel Scroll displacement=" + d16);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(U, 4, "has horizontally scrolled ever: " + this.M + ", has vertically scrolled ever: " + this.K);
        }
        c();
        this.E = y16;
        return true;
    }

    protected void k() {
        this.f110901d = new Scroller(getContext());
        this.D = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 1.5d);
    }

    protected boolean l(MotionEvent motionEvent) {
        if (motionEvent.getY() < h()) {
            return true;
        }
        return false;
    }

    protected boolean n(View view, MotionEvent motionEvent) {
        if (this.J) {
            return true;
        }
        if (m(view, motionEvent)) {
            this.J = true;
            return true;
        }
        return false;
    }

    protected void o() {
        this.Q = true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.L = true;
    }

    protected boolean p(MotionEvent motionEvent) {
        this.K = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.E = motionEvent.getY();
        this.F = motionEvent.getX();
        this.G = motionEvent.getY();
        this.S = false;
        View view = this.f110903f;
        if (view == null) {
            view = getChildAt(0);
        }
        this.R = l(motionEvent);
        n(view, motionEvent);
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    protected boolean q(MotionEvent motionEvent) {
        if (this.R) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return j(motionEvent);
    }

    protected boolean r(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        this.J = false;
        if (this.I != 1 ? !(this.K || this.S) : !(this.K || this.M)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.R) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            motionEvent.setAction(3);
        }
        super.dispatchTouchEvent(motionEvent);
        if (getScrollY() + g() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            s(0);
        } else if (this.f110904h != null) {
            this.T = true;
            s(-this.H);
        }
        return !z17;
    }

    public void s(int i3) {
        Scroller scroller = this.f110901d;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void setPanelScrollListener(a aVar) {
        this.f110904h = aVar;
    }

    public void setPanelStatus(int i3) {
        this.I = i3;
    }

    public void setParams(int i3) {
        this.C = i3;
    }

    public void setSupportVertScrollListener(GuildAtPanelTouchController.a aVar) {
        this.f110905i = aVar;
    }

    public void setTargetView(View view) {
        this.f110903f = view;
    }

    public void t(int i3, int i16) {
        Scroller scroller = this.f110901d;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY(), i16);
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public GuildHashtagPanelTouchController(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f110906m = -1;
        this.C = 0;
        this.D = 28;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        k();
    }

    public GuildHashtagPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f110906m = -1;
        this.C = 0;
        this.D = 28;
        this.K = false;
        this.L = true;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        k();
    }
}
