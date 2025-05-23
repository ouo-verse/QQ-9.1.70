package com.tencent.guild.aio.input.at.quickAt.dialogui.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.qphone.base.util.QLog;
import so0.d;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildDialogGestureLayout extends LinearLayout {
    protected float C;
    protected int D;
    protected int E;
    protected Scroller F;
    protected VelocityTracker G;
    protected View H;
    protected c I;
    protected a J;
    protected b K;

    /* renamed from: d, reason: collision with root package name */
    protected int[] f110971d;

    /* renamed from: e, reason: collision with root package name */
    protected int f110972e;

    /* renamed from: f, reason: collision with root package name */
    protected int f110973f;

    /* renamed from: h, reason: collision with root package name */
    protected int f110974h;

    /* renamed from: i, reason: collision with root package name */
    protected float f110975i;

    /* renamed from: m, reason: collision with root package name */
    protected float f110976m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        boolean a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        boolean a(MotionEvent motionEvent, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface c {
        void b();

        void c(int i3);

        void d(boolean z16);
    }

    public GuildDialogGestureLayout(@NonNull Context context) {
        super(context);
        this.f110971d = new int[]{3, 3};
        this.f110972e = -1;
        this.f110973f = 0;
        this.f110974h = 28;
        this.E = 0;
        q();
    }

    private boolean f(int i3, float f16, float f17) {
        boolean z16 = true;
        if (getScrollY() >= 0 && (d(i3) || f17 <= this.f110974h || f17 <= f16)) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildDialogGestureLayout", 4, "canVerticalScroll= " + z16);
        }
        return z16;
    }

    private int j() {
        if (this.D == 1) {
            return l() - this.f110973f;
        }
        return this.f110973f / 3;
    }

    private int k() {
        int height = getHeight() - l();
        int[] iArr = this.f110971d;
        char c16 = 1;
        if (this.D == 1) {
            c16 = 0;
        }
        return height / iArr[c16];
    }

    private int l() {
        if (this.f110972e > 0 && !p(32)) {
            return this.f110972e;
        }
        this.f110972e = (int) (r0.getTop() + getChildAt(0).getTranslationY());
        e(32);
        return this.f110972e;
    }

    public void a() {
        Scroller scroller = this.F;
        if (scroller != null && !scroller.isFinished()) {
            e(256);
            this.F.abortAnimation();
        }
    }

    public void b(int i3) {
        this.E = i3 | this.E;
    }

    public boolean c(MotionEvent motionEvent) {
        if (this.K == null) {
            return true;
        }
        return !r0.a(motionEvent, this.D);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.F;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.F.getCurrX(), this.F.getCurrY());
            invalidate();
        } else if (p(256)) {
            e(256);
            QLog.d("GuildDialogGestureLayout", 4, "clearFlag: SCROLL_TO_BOTTOM");
            c cVar = this.I;
            if (cVar != null) {
                cVar.c(this.D);
            }
        }
    }

    protected boolean d(int i3) {
        a aVar = this.J;
        if (aVar != null) {
            return aVar.a(i3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = !p(512);
        if (motionEvent.getAction() == 0) {
            z16 = c(motionEvent);
            setFlag(512, !z16);
        }
        if (!z16) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return m(motionEvent);
    }

    public void e(int i3) {
        this.E = (~i3) & this.E;
    }

    protected void g() {
        boolean z16;
        c cVar = this.I;
        if (cVar != null) {
            if (getScrollY() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.d(z16);
        }
    }

    protected void h(MotionEvent motionEvent, int i3) {
        this.G.addMovement(motionEvent);
        scrollBy(0, i3);
    }

    protected float i(float f16) {
        int scrollY = getScrollY();
        if (scrollY + f16 > j()) {
            return r1 - scrollY;
        }
        return f16;
    }

    public boolean m(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return u(motionEvent);
                }
            }
            return v(motionEvent);
        }
        return t(motionEvent);
    }

    protected void n(MotionEvent motionEvent) {
        b(2);
        if (p(4)) {
            e(4);
            motionEvent.setAction(0);
        }
        if (!p(8)) {
            super.dispatchTouchEvent(motionEvent);
        } else {
            e(8);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildDialogGestureLayout", 4, "super.dispatchTouchEvent action=" + motionEvent.getAction());
        }
    }

    protected boolean o(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.f110976m);
        float abs2 = Math.abs(y16 - this.C);
        float f16 = this.f110975i - y16;
        int i3 = (int) i(f16);
        boolean z18 = false;
        if (this.D == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!p(1) && (abs <= abs2 || abs <= this.f110974h)) {
            z17 = false;
        } else {
            z17 = true;
        }
        setFlag(1, z17);
        int scrollY = getScrollY();
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildDialogGestureLayout", 4, "scrollByY + currentScrollY=" + (scrollY + f16) + " scrollByY=" + f16 + " currentScrollY=" + scrollY + " mMaxScrollY=" + j());
        }
        if (z16) {
            if (f16 + scrollY > j() + 0) {
                c cVar = this.I;
                if (cVar != null) {
                    cVar.b();
                    h(motionEvent, i3);
                    w();
                }
            } else {
                h(motionEvent, i3);
            }
            if (p(1024) || abs2 > this.f110974h) {
                z18 = true;
            }
            setFlag(1024, z18);
            b(4);
        } else {
            setFlag(128, f((int) f16, abs, abs2));
            if (p(192)) {
                b(4);
                if (p(2)) {
                    e(2);
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    super.dispatchTouchEvent(obtain);
                }
                h(motionEvent, i3);
                if (p(1024) || abs2 > this.f110974h) {
                    z18 = true;
                }
                setFlag(1024, z18);
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildDialogGestureLayout", 4, "panel Scroll displacement=" + i3);
                }
            } else {
                n(motionEvent);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildDialogGestureLayout", 4, "has horizontally scrolled ever: " + p(1) + ", has vertically scrolled ever: " + p(1024));
        }
        g();
        this.f110975i = y16;
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        b(32);
    }

    public boolean p(int i3) {
        if ((i3 & this.E) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        this.F = new Scroller(getContext());
        this.G = VelocityTracker.obtain();
        this.f110974h = (int) (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 1.5d);
    }

    protected boolean r(MotionEvent motionEvent) {
        if (motionEvent.getY() < l()) {
            return true;
        }
        return false;
    }

    protected boolean s(View view, MotionEvent motionEvent) {
        boolean z16;
        if (!p(64) && !d.d(view, motionEvent)) {
            z16 = false;
        } else {
            z16 = true;
        }
        setFlag(64, z16);
        return z16;
    }

    public void setDisplayMode(int i3) {
        this.D = i3;
    }

    public void setFlag(int i3, boolean z16) {
        if (z16) {
            this.E = i3 | this.E;
        } else {
            this.E = (~i3) & this.E;
        }
    }

    public void setNestVerticalChild(a aVar) {
        this.J = aVar;
    }

    public void setOnInterceptTouchListener(b bVar) {
        this.K = bVar;
    }

    public void setScrollListener(c cVar) {
        this.I = cVar;
    }

    public void setTargetView(View view) {
        this.H = view;
    }

    public void setTopPadding(int i3) {
        this.f110973f = i3;
    }

    protected boolean t(MotionEvent motionEvent) {
        e(1159);
        this.G.clear();
        this.G.addMovement(motionEvent);
        this.f110975i = motionEvent.getY();
        this.f110976m = motionEvent.getX();
        this.C = motionEvent.getY();
        View view = this.H;
        if (view == null) {
            view = getChildAt(0);
        }
        setFlag(16, r(motionEvent));
        s(view, motionEvent);
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    protected boolean u(MotionEvent motionEvent) {
        if (p(16)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return o(motionEvent);
    }

    protected boolean v(MotionEvent motionEvent) {
        boolean z16;
        e(64);
        boolean z17 = true;
        if (this.D != 1 ? !p(gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION) : !p(1025)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !p(16)) {
            z17 = false;
        }
        if (!z17) {
            this.G.addMovement(motionEvent);
            motionEvent.setAction(3);
        }
        super.dispatchTouchEvent(motionEvent);
        if (x(motionEvent)) {
            y(0);
        } else if (this.I != null) {
            b(256);
            y(-getHeight());
        }
        return false;
    }

    protected void w() {
        b(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean x(MotionEvent motionEvent) {
        if (getScrollY() + k() > 0) {
            return true;
        }
        return false;
    }

    public void y(int i3) {
        Scroller scroller = this.F;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void z(int i3, int i16) {
        Scroller scroller = this.F;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY(), i16);
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public GuildDialogGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f110971d = new int[]{3, 3};
        this.f110972e = -1;
        this.f110973f = 0;
        this.f110974h = 28;
        this.E = 0;
        q();
    }

    public GuildDialogGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f110971d = new int[]{3, 3};
        this.f110972e = -1;
        this.f110973f = 0;
        this.f110974h = 28;
        this.E = 0;
        q();
    }
}
