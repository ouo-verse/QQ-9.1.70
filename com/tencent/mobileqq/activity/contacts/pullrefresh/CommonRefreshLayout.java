package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CommonRefreshLayout extends ViewGroup implements AutoScroller.a {
    static IPatchRedirector $redirector_;
    private int C;
    private float D;
    private ViewGroup E;
    private View F;
    private int G;
    private float H;
    private float I;
    private int J;
    private int K;
    private boolean L;
    private float M;
    private float N;
    private float P;
    private float Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private com.tencent.mobileqq.activity.contacts.pullrefresh.a V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private b f181688a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f181689b0;

    /* renamed from: c0, reason: collision with root package name */
    ListView f181690c0;

    /* renamed from: d, reason: collision with root package name */
    private int f181691d;

    /* renamed from: d0, reason: collision with root package name */
    c f181692d0;

    /* renamed from: e, reason: collision with root package name */
    private int f181693e;

    /* renamed from: f, reason: collision with root package name */
    private int f181694f;

    /* renamed from: h, reason: collision with root package name */
    private int f181695h;

    /* renamed from: i, reason: collision with root package name */
    private int f181696i;

    /* renamed from: m, reason: collision with root package name */
    private AutoScroller f181697m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        static IPatchRedirector $redirector_;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends c {
        static IPatchRedirector $redirector_;

        a() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonRefreshLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            if (CommonRefreshLayout.this.E != null && (CommonRefreshLayout.this.E instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.c) && (d.v(CommonRefreshLayout.this.S) || d.m(CommonRefreshLayout.this.S))) {
                ((com.tencent.mobileqq.activity.contacts.pullrefresh.c) CommonRefreshLayout.this.E).a();
            }
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101787", false);
            if (QLog.isColorLevel()) {
                QLog.i("CommonRefreshLayout", 1, "performSwitch: " + isSwitchOn);
            }
            if (isSwitchOn && CommonRefreshLayout.this.E != null && (CommonRefreshLayout.this.E instanceof SimpleContactRefreshHeader) && d.v(CommonRefreshLayout.this.S)) {
                ((q) CommonRefreshLayout.this.E).j(27, null);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
        public void e(int i3, boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (CommonRefreshLayout.this.E != null && (CommonRefreshLayout.this.E instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.c) && d.p(CommonRefreshLayout.this.S)) {
                if (CommonRefreshLayout.this.E.getVisibility() != 0) {
                    CommonRefreshLayout.this.E.setVisibility(0);
                }
                ((com.tencent.mobileqq.activity.contacts.pullrefresh.c) CommonRefreshLayout.this.E).e(i3, z16, z17);
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
        public void onPrepare() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (CommonRefreshLayout.this.E != null && (CommonRefreshLayout.this.E instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.c)) {
                if (d.v(CommonRefreshLayout.this.S) || d.m(CommonRefreshLayout.this.S)) {
                    CommonRefreshLayout.this.E.setVisibility(0);
                    ((com.tencent.mobileqq.activity.contacts.pullrefresh.c) CommonRefreshLayout.this.E).onPrepare();
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.b
        public void onRefresh() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (CommonRefreshLayout.this.E != null && d.q(CommonRefreshLayout.this.S)) {
                if (CommonRefreshLayout.this.E instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.b) {
                    ((com.tencent.mobileqq.activity.contacts.pullrefresh.b) CommonRefreshLayout.this.E).onRefresh();
                }
                if (CommonRefreshLayout.this.V != null) {
                    CommonRefreshLayout.this.V.onRefresh();
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.c
        public void onRelease() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else if (CommonRefreshLayout.this.E != null && (CommonRefreshLayout.this.E instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.c) && d.s(CommonRefreshLayout.this.S)) {
                ((com.tencent.mobileqq.activity.contacts.pullrefresh.c) CommonRefreshLayout.this.E).onRelease();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        void onFlingScrollHeader(int i3, int i16);

        void onTouchMoving(CommonRefreshLayout commonRefreshLayout, int i3, MotionEvent motionEvent);

        int onViewCompleteAfterRefresh(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public abstract class c implements com.tencent.mobileqq.activity.contacts.pullrefresh.c, com.tencent.mobileqq.activity.contacts.pullrefresh.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonRefreshLayout.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean m(int i3) {
            if (i3 == 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(int i3) {
            if (i3 == 2) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(int i3) {
            if (i3 >= 1) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(int i3) {
            if (i3 < 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean q(int i3) {
            if (i3 == -3) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean r(int i3) {
            if (i3 == 4) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean s(int i3) {
            if (i3 == -2) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean t(int i3) {
            if (i3 > 2) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean u(int i3) {
            if (i3 == 3) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean v(int i3) {
            if (i3 == 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean w(int i3) {
            if (i3 == 5) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean x(int i3) {
            if (i3 == -1) {
                return true;
            }
            return false;
        }
    }

    public CommonRefreshLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void C() {
        if (this.f181697m.h()) {
            this.f181697m.f(m() - this.J, this.f181693e);
        }
    }

    private void D() {
        if (this.f181697m.h()) {
            this.f181697m.f(-this.J, this.f181691d);
        }
    }

    private void F(int i3) {
        this.S = i3;
    }

    private void G(float f16) {
        if (f16 == 0.0f) {
            return;
        }
        this.K = (int) (this.K + f16);
        if (d.p(this.S) || d.o(this.S)) {
            this.J = this.K;
        }
        s();
        requestLayout();
        invalidate();
    }

    private void h(float f16) {
        float f17 = f16 * this.D;
        int i3 = this.K;
        float f18 = i3 + f17;
        if ((i3 > 0 && f18 < 0.0f) || (i3 < 0 && f18 > 0.0f)) {
            f17 = -i3;
        }
        float f19 = this.I;
        if (f19 > this.H && f18 > f19) {
            f17 = f19 - i3;
        }
        if (d.p(this.S)) {
            int i16 = this.K;
            if (q()) {
                i16 = this.K - (((int) this.H) - this.f181689b0);
            }
            this.f181692d0.e(i16, false, false);
        }
        G(f17);
    }

    private void i() {
        if (d.q(this.S)) {
            int i3 = (int) (this.H + 0.5f);
            this.K = i3;
            this.J = i3;
            s();
            requestLayout();
            invalidate();
            return;
        }
        if (d.v(this.S)) {
            this.K = 0;
            this.J = 0;
            s();
            requestLayout();
            invalidate();
            return;
        }
        if (d.m(this.S)) {
            int i16 = ((int) (this.H + 0.5f)) - this.f181689b0;
            this.K = i16;
            this.J = i16;
            s();
            requestLayout();
            invalidate();
        }
    }

    private float k(MotionEvent motionEvent, int i3) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getX(motionEvent, findPointerIndex);
    }

    private float l(MotionEvent motionEvent, int i3) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i3);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private void r() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.F == null) {
            return;
        }
        ViewGroup viewGroup = this.E;
        if (viewGroup != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            int i3 = marginLayoutParams.leftMargin + paddingLeft;
            int i16 = ((marginLayoutParams.topMargin + paddingTop) - this.G) + this.J;
            viewGroup.layout(i3, i16, viewGroup.getMeasuredWidth() + i3, viewGroup.getMeasuredHeight() + i16);
        }
        View view = this.F;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i17 = paddingLeft + marginLayoutParams2.leftMargin;
            int i18 = paddingTop + marginLayoutParams2.topMargin + this.K;
            if (i18 < 0) {
                i18 = 0;
            }
            view.layout(i17, i18, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i18);
        }
    }

    private void s() {
        int paddingTop = getPaddingTop();
        if (this.F == null) {
            return;
        }
        ViewGroup viewGroup = this.E;
        if (viewGroup != null) {
            viewGroup.setTop(((((ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams()).topMargin + paddingTop) - this.G) + this.J);
        }
        View view = this.F;
        if (view != null) {
            int i3 = paddingTop + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin + this.K;
            if (i3 < 0) {
                i3 = 0;
            }
            view.setTop(i3);
        }
    }

    private void t() {
        if (d.x(this.S)) {
            if (q()) {
                E();
                return;
            } else {
                D();
                return;
            }
        }
        if (d.s(this.S)) {
            this.f181692d0.onRelease();
            C();
            return;
        }
        if (d.q(this.S)) {
            B();
            return;
        }
        if (!d.w(this.S) && !d.r(this.S)) {
            if (d.u(this.S) || d.n(this.S)) {
                A();
                return;
            }
            return;
        }
        E();
    }

    private boolean u() {
        if (this.U && !com.tencent.mobileqq.activity.contacts.pullrefresh.d.a(this.F) && this.L && this.H > 0.0f) {
            return true;
        }
        return false;
    }

    private void v(MotionEvent motionEvent) {
        int i3;
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.C) {
            if (actionIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.C = MotionEventCompat.getPointerId(motionEvent, i3);
        }
    }

    private void w(float f16) {
        if (d.v(this.S) && this.f181688a0 != null && f16 > 0.0f) {
            F(3);
            if (this.E.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
        }
        if (d.t(this.S)) {
            if (f16 < 0.0f) {
                F(2);
            } else {
                int i3 = this.K;
                float f17 = i3;
                float f18 = this.H;
                if (f17 >= f18) {
                    F(4);
                } else if (i3 >= (f18 - this.f181689b0) / 2.0f) {
                    F(5);
                } else {
                    F(3);
                }
            }
            h(f16);
        }
        if (d.m(this.S) || d.n(this.S)) {
            if (f16 < 0.0f) {
                F(2);
            } else {
                F(1);
            }
            h(f16);
        }
        if ((d.v(this.S) || d.m(this.S)) && f16 > 0.0f && u()) {
            this.f181692d0.onPrepare();
            F(-1);
        }
        if (d.p(this.S)) {
            if (!d.x(this.S) && !d.s(this.S)) {
                if (f16 < 0.0f && this.f181688a0 != null) {
                    F(2);
                }
            } else if (this.K >= this.H) {
                F(-2);
            } else {
                F(-1);
            }
            h(f16);
        }
    }

    private void z() {
        if (this.f181697m.h()) {
            this.f181697m.f((int) (this.H + 0.5f), this.f181696i);
        }
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else if (this.f181697m.h()) {
            this.f181697m.f(-this.K, this.f181695h);
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.f181697m.h()) {
            this.f181697m.f(-m(), this.f181695h);
            ViewParent viewParent = this.E;
            if (viewParent instanceof q) {
                ((q) viewParent).j(26, null);
            }
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (this.f181697m.h()) {
            this.f181697m.f((((int) (this.H + 0.5f)) - this.f181689b0) - this.K, this.f181695h);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller.a
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        if (d.x(this.S)) {
            this.f181692d0.e(this.K, false, true);
        } else if (d.s(this.S)) {
            this.f181692d0.e(this.K, false, true);
        } else if (d.q(this.S)) {
            this.f181692d0.e(this.K, true, true);
        }
        G(f16);
    }

    @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.AutoScroller.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (d.s(this.S)) {
            F(-3);
            i();
            this.f181692d0.onRefresh();
            return;
        }
        if (d.q(this.S)) {
            if (q()) {
                F(1);
            } else {
                F(0);
            }
            i();
            this.f181692d0.a();
            return;
        }
        if (d.x(this.S)) {
            if (this.T) {
                this.T = false;
                F(-3);
                i();
                this.f181692d0.onRefresh();
                return;
            }
            if (q()) {
                F(1);
            } else {
                F(0);
            }
            i();
            this.f181692d0.a();
            return;
        }
        if (!d.w(this.S) && !d.r(this.S)) {
            if (d.u(this.S) || d.n(this.S)) {
                F(0);
                i();
                return;
            }
            return;
        }
        F(1);
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) canvas);
            return;
        }
        b bVar = this.f181688a0;
        if (bVar != null) {
            bVar.onFlingScrollHeader(this.S, -this.K);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        b bVar = this.f181688a0;
        if (bVar != null) {
            bVar.onTouchMoving(this, -this.K, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            t();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 16, (Object) this, (Object) layoutParams);
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.G;
    }

    protected int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        int i3 = this.G;
        ViewParent viewParent = this.E;
        if (viewParent instanceof q) {
            Object f16 = ((q) viewParent).f(25, null);
            if (f16 instanceof Integer) {
                return ((Integer) f16).intValue();
            }
            return i3;
        }
        return i3;
    }

    protected float n(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16))).floatValue();
        }
        int i3 = this.G;
        if (f16 < i3) {
            f16 = i3;
        }
        ViewParent viewParent = this.E;
        if (viewParent instanceof q) {
            if (((q) viewParent).f(25, null) instanceof Integer) {
                return ((Integer) r0).intValue();
            }
            return f16;
        }
        return f16;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.U;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        if (childCount > 0 && childCount < 4) {
            this.E = (ViewGroup) findViewById(R.id.j8x);
            View findViewById = findViewById(R.id.j8y);
            this.F = findViewById;
            if (findViewById != null && (viewGroup = this.E) != null && (viewGroup instanceof com.tencent.mobileqq.activity.contacts.pullrefresh.c)) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        throw new IllegalStateException("Children num must equal or less than 3");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:
    
        if (r0 != 3) goto L55;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        ListView listView = this.f181690c0;
        boolean z17 = false;
        if (listView != null) {
            i3 = listView.getListViewScrollY();
        } else {
            i3 = 0;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i16 = this.C;
                    if (i16 == -1) {
                        return false;
                    }
                    float k3 = k(motionEvent, i16);
                    float l3 = l(motionEvent, this.C);
                    float f16 = k3 - this.M;
                    float f17 = l3 - this.N;
                    this.P = k3;
                    this.Q = l3;
                    if (Math.abs(f16) < Math.abs(f17) && Math.abs(f17) > this.R) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (f17 > 0.0f && u()) {
                        z17 = true;
                    }
                    if (i3 == 0 && z16 && (z17 || d.q(this.S) || d.o(this.S))) {
                        return true;
                    }
                }
            }
            this.C = -1;
        } else {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.C = pointerId;
            float k16 = k(motionEvent, pointerId);
            this.M = k16;
            this.P = k16;
            float l16 = l(motionEvent, this.C);
            this.N = l16;
            this.Q = l16;
            if (d.x(this.S) || d.s(this.S)) {
                this.f181697m.e();
            }
            if ((d.x(this.S) || d.s(this.S)) && i3 == 0) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        r();
        if (this.E == null) {
            z17 = false;
        }
        this.L = z17;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        ViewGroup viewGroup = this.E;
        if (viewGroup != null) {
            measureChildWithMargins(viewGroup, i3, 0, i16, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
            this.G = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            this.H = n(this.H);
        }
        View view = this.F;
        if (view != null) {
            measureChildWithMargins(view, i3, 0, i16, 0);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                v(motionEvent);
                                this.P = k(motionEvent, this.C);
                                this.Q = l(motionEvent, this.C);
                            }
                        } else {
                            int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                            if (pointerId != -1) {
                                this.C = pointerId;
                            }
                            this.P = k(motionEvent, this.C);
                            this.Q = l(motionEvent, this.C);
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                } else {
                    float k3 = k(motionEvent, this.C);
                    float l3 = l(motionEvent, this.C);
                    float f16 = k3 - this.P;
                    float f17 = l3 - this.Q;
                    this.P = k3;
                    this.Q = l3;
                    if (Math.abs(f16) >= Math.abs(f17) && Math.abs(f16) > this.R) {
                        return false;
                    }
                    w(f17);
                    return true;
                }
            }
            if (this.C == -1) {
                return false;
            }
            this.C = -1;
            return super.onTouchEvent(motionEvent);
        }
        this.C = MotionEventCompat.getPointerId(motionEvent, 0);
        return true;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return d.p(this.S);
        }
        return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.W;
    }

    public void setMiniAppScrollListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bVar);
        } else {
            this.f181688a0 = bVar;
        }
    }

    public void setOnRefreshListener(com.tencent.mobileqq.activity.contacts.pullrefresh.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.V = aVar;
        }
    }

    public void setRefreshCompleteDelayDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f181694f = i3;
        }
    }

    public void setRefreshEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.U = z16;
        }
    }

    public void setRefreshing(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (o() && this.E != null) {
            this.T = z16;
            if (z16) {
                if (d.v(this.S)) {
                    F(-1);
                    z();
                    return;
                }
                return;
            }
            if (d.q(this.S)) {
                this.f181692d0.a();
                postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CommonRefreshLayout.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (CommonRefreshLayout.this.f181688a0 != null) {
                            CommonRefreshLayout.this.f181688a0.onViewCompleteAfterRefresh(CommonRefreshLayout.this.W);
                        }
                        CommonRefreshLayout.this.B();
                    }
                }, this.f181694f);
            }
        }
    }

    public void setShowMiniAppPanel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.W = z16;
        }
    }

    public void setTargetListView(ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listView);
        } else {
            this.f181690c0 = listView;
        }
    }

    public void x(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) viewGroup);
            return;
        }
        if (viewGroup != null) {
            int indexOfChild = indexOfChild(this.E);
            if (indexOfChild < 0) {
                indexOfChild = 0;
            }
            removeView(this.E);
            addView(viewGroup, indexOfChild, new ViewGroup.MarginLayoutParams(-1, -2));
            this.E = viewGroup;
        } else {
            removeView(this.E);
        }
        this.H = n(this.H);
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        F(0);
        i();
        this.f181692d0.a();
        this.H = 0.0f;
    }

    public CommonRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 17, (Object) this, (Object) attributeSet);
    }

    public CommonRefreshLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181691d = 200;
        this.f181693e = 200;
        this.f181694f = 300;
        this.f181695h = 500;
        this.f181696i = 500;
        this.D = 0.5f;
        this.S = 0;
        this.U = true;
        this.f181692d0 = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RefreshLayout, i3, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i16 = 0; i16 < indexCount; i16++) {
                int index = obtainStyledAttributes.getIndex(i16);
                if (index == R.styleable.RefreshLayout_refresh_enabled) {
                    setRefreshEnabled(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.RefreshLayout_drag_ratio) {
                    this.D = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.RefreshLayout_refresh_final_drag_offset) {
                    this.I = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                } else if (index == R.styleable.RefreshLayout_refresh_trigger_offset) {
                    this.H = obtainStyledAttributes.getDimensionPixelOffset(index, 0);
                } else if (index == R.styleable.RefreshLayout_swiping_to_refresh_to_default_scrolling_duration) {
                    this.f181691d = obtainStyledAttributes.getInt(index, 200);
                } else if (index == R.styleable.RefreshLayout_release_to_refreshing_scrolling_duration) {
                    this.f181693e = obtainStyledAttributes.getInt(index, 200);
                } else if (index == R.styleable.RefreshLayout_refresh_complete_delay_duration) {
                    setRefreshCompleteDelayDuration(obtainStyledAttributes.getInt(index, 300));
                } else if (index == R.styleable.RefreshLayout_refresh_complete_to_default_scrolling_duration) {
                    this.f181695h = obtainStyledAttributes.getInt(index, 500);
                } else if (index == R.styleable.RefreshLayout_default_to_refreshing_scrolling_duration) {
                    this.f181696i = obtainStyledAttributes.getInt(index, 500);
                }
            }
            obtainStyledAttributes.recycle();
            this.R = ViewConfiguration.get(context).getScaledTouchSlop();
            AutoScroller autoScroller = new AutoScroller(this);
            this.f181697m = autoScroller;
            autoScroller.i(this);
            this.f181689b0 = getResources().getDimensionPixelOffset(R.dimen.auf);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }
}
