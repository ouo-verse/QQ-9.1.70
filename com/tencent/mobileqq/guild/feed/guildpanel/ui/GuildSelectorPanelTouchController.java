package com.tencent.mobileqq.guild.feed.guildpanel.ui;

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

/* loaded from: classes13.dex */
public class GuildSelectorPanelTouchController extends LinearLayout {
    private int C;
    private float D;
    private float E;
    private float F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;

    /* renamed from: d, reason: collision with root package name */
    protected Scroller f219975d;

    /* renamed from: e, reason: collision with root package name */
    protected View f219976e;

    /* renamed from: f, reason: collision with root package name */
    protected View f219977f;

    /* renamed from: h, reason: collision with root package name */
    private GuildAtPanelTouchController.a f219978h;

    /* renamed from: i, reason: collision with root package name */
    private int f219979i;

    /* renamed from: m, reason: collision with root package name */
    private int f219980m;

    /* loaded from: classes13.dex */
    interface a {
    }

    public GuildSelectorPanelTouchController(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f219979i = -1;
        this.f219980m = 0;
        this.C = 28;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        j();
    }

    private boolean a(int i3) {
        GuildAtPanelTouchController.a aVar = this.f219978h;
        if (aVar != null) {
            return aVar.a(i3);
        }
        return true;
    }

    private boolean b(int i3, float f16, float f17) {
        boolean z16 = true;
        if (getScrollY() >= 0 && (!a(i3) || f17 <= this.C || f17 <= f16)) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildSelectorPanelTouchController", 4, "canVerticalScroll= " + z16);
        }
        return z16;
    }

    private int e() {
        if (this.H == 1) {
            return g() - this.f219980m;
        }
        return this.f219980m / 3;
    }

    private int f() {
        int height = getHeight() - g();
        this.G = height * 2;
        return height / 3;
    }

    private int g() {
        int i3 = this.f219979i;
        if (i3 > 0 && !this.K) {
            return i3;
        }
        int top = (int) (this.f219976e.getTop() + this.f219976e.getTranslationY());
        this.f219979i = top;
        this.K = false;
        return top;
    }

    protected static boolean l(View view, MotionEvent motionEvent) {
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

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f219975d;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f219975d.getCurrX(), this.f219975d.getCurrY());
            invalidate();
        } else if (this.S) {
            this.S = false;
        }
    }

    protected float d(float f16) {
        int scrollY = getScrollY();
        if (scrollY + f16 > e()) {
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
                    return o(motionEvent);
                }
            }
            return p(motionEvent);
        }
        return n(motionEvent);
    }

    protected void h(MotionEvent motionEvent) {
        this.M = true;
        if (this.N) {
            this.N = false;
            motionEvent.setAction(0);
        }
        if (!this.P) {
            super.dispatchTouchEvent(motionEvent);
        } else {
            this.P = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildSelectorPanelTouchController", 2, "super.dispatchTouchEvent action=" + motionEvent.getAction());
        }
    }

    protected boolean i(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.E);
        float abs2 = Math.abs(y16 - this.F);
        float f16 = this.D - y16;
        int d16 = (int) d(f16);
        boolean z18 = false;
        if (this.H == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.L && (abs <= abs2 || abs <= this.C)) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.L = z17;
        int scrollY = getScrollY();
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildSelectorPanelTouchController", 4, "scrollByY + currentScrollY=" + (scrollY + f16) + " scrollByY=" + f16 + " currentScrollY=" + scrollY + " mMaxScrollY=" + e());
        }
        if (z16) {
            if (f16 + scrollY <= e()) {
                scrollBy(0, d16);
            }
            if (this.J || abs2 > this.C) {
                z18 = true;
            }
            this.J = z18;
            this.N = true;
        } else {
            boolean b16 = b((int) f16, abs, abs2);
            this.R = b16;
            if (!this.I && !b16) {
                h(motionEvent);
            } else {
                this.N = true;
                if (this.M) {
                    this.M = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                scrollBy(0, d16);
                if (this.J || abs2 > this.C) {
                    z18 = true;
                }
                this.J = z18;
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildSelectorPanelTouchController", 4, "panel Scroll displacement=" + d16);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildSelectorPanelTouchController", 4, "has horizontally scrolled ever: " + this.L + ", has vertically scrolled ever: " + this.J);
        }
        c();
        this.D = y16;
        return true;
    }

    protected void j() {
        this.f219975d = new Scroller(getContext());
        this.C = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 1.5d);
    }

    protected boolean k(MotionEvent motionEvent) {
        if (motionEvent.getY() < g()) {
            return true;
        }
        return false;
    }

    protected boolean m(View view, MotionEvent motionEvent) {
        if (this.I) {
            return true;
        }
        if (l(view, motionEvent)) {
            this.I = true;
            return true;
        }
        return false;
    }

    protected boolean n(MotionEvent motionEvent) {
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.D = motionEvent.getY();
        this.E = motionEvent.getX();
        this.F = motionEvent.getY();
        this.R = false;
        View view = this.f219977f;
        if (view == null) {
            view = getChildAt(0);
        }
        this.Q = k(motionEvent);
        m(view, motionEvent);
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    protected boolean o(MotionEvent motionEvent) {
        if (this.Q) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return i(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.K = true;
    }

    protected boolean p(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        this.I = false;
        if (this.H != 1 ? !(this.J || this.R) : !(this.J || this.L)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.Q) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            motionEvent.setAction(3);
        }
        super.dispatchTouchEvent(motionEvent);
        if (getScrollY() + f() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            q(0);
        }
        return !z17;
    }

    public void q(int i3) {
        Scroller scroller = this.f219975d;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void setPanelStatus(int i3) {
        this.H = i3;
    }

    public void setParams(int i3) {
        this.f219980m = i3;
    }

    public void setSupportVertScrollListener(GuildAtPanelTouchController.a aVar) {
        this.f219978h = aVar;
    }

    public void setTargetView(View view) {
        this.f219977f = view;
    }

    public GuildSelectorPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f219979i = -1;
        this.f219980m = 0;
        this.C = 28;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        j();
    }

    protected void c() {
    }

    public void setPanelScrollListener(a aVar) {
    }
}
