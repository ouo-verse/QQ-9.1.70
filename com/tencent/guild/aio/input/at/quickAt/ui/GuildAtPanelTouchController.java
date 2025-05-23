package com.tencent.guild.aio.input.at.quickAt.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public class GuildAtPanelTouchController extends AtPanelTouchController {
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f111020a0;

    /* renamed from: b0, reason: collision with root package name */
    private a f111021b0;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(int i3);
    }

    /* loaded from: classes6.dex */
    public interface b {
    }

    public GuildAtPanelTouchController(@NonNull Context context) {
        super(context);
        this.P = -1;
        this.Q = 0;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f111020a0 = false;
        t();
    }

    private boolean k(int i3) {
        a aVar = this.f111021b0;
        if (aVar != null) {
            return aVar.a(i3);
        }
        return true;
    }

    private boolean l(int i3, float f16, float f17) {
        boolean z16 = true;
        if (getScrollY() >= 0 && (!k(i3) || f17 <= this.I || f17 <= f16)) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildAtPanel", 4, "canVerticalScroll= " + z16);
        }
        return z16;
    }

    private int o() {
        if (this.f111018i == 1) {
            return q() - this.Q;
        }
        return this.Q / 3;
    }

    private int p() {
        int height = getHeight() - q();
        this.E = height * 2;
        return height / 3;
    }

    private int q() {
        int i3 = this.P;
        if (i3 > 0 && !this.R) {
            return i3;
        }
        int top = (int) (r1.getTop() + getChildAt(0).getTranslationY());
        this.P = top;
        this.R = false;
        return top;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z16 = !this.f111020a0;
        if (action == 0) {
            z16 = j(motionEvent);
            this.f111020a0 = !z16;
        }
        if (!z16) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return x(motionEvent);
                }
            }
            return y(motionEvent);
        }
        return w(motionEvent);
    }

    public boolean j(MotionEvent motionEvent) {
        return true;
    }

    protected void m() {
        boolean z16;
        AtPanelTouchController.a aVar = this.C;
        if (aVar != null) {
            if (getScrollY() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.a(z16);
        }
    }

    protected float n(float f16) {
        int scrollY = getScrollY();
        if (scrollY + f16 > o()) {
            return r1 - scrollY;
        }
        return f16;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.R = true;
    }

    protected void r(MotionEvent motionEvent) {
        this.T = true;
        if (this.U) {
            this.U = false;
            motionEvent.setAction(0);
        }
        if (!this.V) {
            super.dispatchTouchEvent(motionEvent);
        } else {
            this.V = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildAtPanel", 2, "super.dispatchTouchEvent action=" + motionEvent.getAction());
        }
    }

    protected boolean s(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.J);
        float abs2 = Math.abs(y16 - this.K);
        float f16 = this.f111014d - y16;
        int n3 = (int) n(f16);
        boolean z18 = false;
        if (this.f111018i == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.S && (abs <= abs2 || abs <= this.I)) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.S = z17;
        int scrollY = getScrollY();
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildAtPanel", 4, "scrollByY + currentScrollY=" + (scrollY + f16) + " scrollByY=" + f16 + " currentScrollY=" + scrollY + " mMaxScrollY=" + o());
        }
        if (z16) {
            if (f16 + scrollY > o()) {
                AtPanelTouchController.a aVar = this.C;
                if (aVar != null) {
                    aVar.scrollToTop();
                    scrollBy(0, n3);
                    v();
                }
            } else {
                scrollBy(0, n3);
            }
            if (this.f111017h || abs2 > this.I) {
                z18 = true;
            }
            this.f111017h = z18;
            this.U = true;
        } else {
            boolean l3 = l((int) f16, abs, abs2);
            this.M = l3;
            if (!this.f111015e && !l3) {
                r(motionEvent);
            } else {
                this.U = true;
                if (this.T) {
                    this.T = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                scrollBy(0, n3);
                if (this.f111017h || abs2 > this.I) {
                    z18 = true;
                }
                this.f111017h = z18;
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildAtPanel", 4, "panel Scroll displacement=" + n3);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildAtPanel", 4, "has horizontally scrolled ever: " + this.S + ", has vertically scrolled ever: " + this.f111017h);
        }
        m();
        this.f111014d = y16;
        return true;
    }

    public void setParams(int i3) {
        this.Q = i3;
    }

    public void setSupportVertScrollListener(a aVar) {
        this.f111021b0 = aVar;
    }

    protected void t() {
        g(true);
        this.I = (int) (this.I * 1.5d);
    }

    protected boolean u(MotionEvent motionEvent) {
        if (motionEvent.getY() < q()) {
            return true;
        }
        return false;
    }

    protected void v() {
        this.V = true;
    }

    protected boolean w(MotionEvent motionEvent) {
        this.f111017h = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.f111014d = motionEvent.getY();
        this.J = motionEvent.getX();
        this.K = motionEvent.getY();
        this.M = false;
        View view = this.H;
        if (view == null) {
            view = getChildAt(0);
        }
        this.W = u(motionEvent);
        e(view, motionEvent);
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    protected boolean x(MotionEvent motionEvent) {
        if (this.W) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return s(motionEvent);
    }

    protected boolean y(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        this.f111015e = false;
        if (this.f111018i != 1 ? !(this.f111017h || this.M) : !(this.f111017h || this.S)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.W) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return super.dispatchTouchEvent(motionEvent);
        }
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
        if (getScrollY() + p() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            h(0);
        } else if (this.C != null) {
            this.F = true;
            h(-this.E);
        }
        return false;
    }

    public GuildAtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = -1;
        this.Q = 0;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f111020a0 = false;
        t();
    }

    public GuildAtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = -1;
        this.Q = 0;
        this.R = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f111020a0 = false;
        t();
    }

    public void setOnInterceptTouchListener(b bVar) {
    }
}
