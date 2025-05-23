package com.tencent.mobileqq.ocr.view.gesture.control;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine;
import com.tencent.mobileqq.ocr.view.gesture.state.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GestureController {
    static IPatchRedirector $redirector_;
    private static final PointF H;
    private static final RectF I;
    private static final float[] J;
    protected final com.tencent.mobileqq.ocr.view.gesture.state.c A;
    protected final com.tencent.mobileqq.ocr.view.gesture.state.c B;
    protected final View C;
    protected final Settings D;
    protected final com.tencent.mobileqq.ocr.view.gesture.state.c E;
    protected final com.tencent.mobileqq.ocr.view.gesture.state.c F;
    protected final d G;

    /* renamed from: a, reason: collision with root package name */
    private final int f255019a;

    /* renamed from: b, reason: collision with root package name */
    private final int f255020b;

    /* renamed from: c, reason: collision with root package name */
    private final int f255021c;

    /* renamed from: d, reason: collision with root package name */
    protected b f255022d;

    /* renamed from: e, reason: collision with root package name */
    protected final List<GestureProxy.a> f255023e;

    /* renamed from: f, reason: collision with root package name */
    private final AnimationEngine f255024f;

    /* renamed from: g, reason: collision with root package name */
    private final GestureDetector f255025g;

    /* renamed from: h, reason: collision with root package name */
    private final ScaleGestureDetector f255026h;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.mobileqq.ocr.view.gesture.detector.b f255027i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f255028j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f255029k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f255030l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f255031m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f255032n;

    /* renamed from: o, reason: collision with root package name */
    protected float f255033o;

    /* renamed from: p, reason: collision with root package name */
    protected float f255034p;

    /* renamed from: q, reason: collision with root package name */
    private float f255035q;

    /* renamed from: r, reason: collision with root package name */
    private float f255036r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f255037s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f255038t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f255039u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f255040v;

    /* renamed from: w, reason: collision with root package name */
    private int f255041w;

    /* renamed from: x, reason: collision with root package name */
    private final OverScroller f255042x;

    /* renamed from: y, reason: collision with root package name */
    private final com.tencent.mobileqq.ocr.view.gesture.animation.b f255043y;

    /* renamed from: z, reason: collision with root package name */
    private final com.tencent.mobileqq.ocr.view.gesture.state.a f255044z;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private class LocalAnimationEngine extends AnimationEngine {
        static IPatchRedirector $redirector_;

        LocalAnimationEngine(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureController.this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.animation.AnimationEngine
        public boolean e() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            boolean z17 = true;
            if (GestureController.this.i()) {
                int currX = GestureController.this.f255042x.getCurrX();
                int currY = GestureController.this.f255042x.getCurrY();
                if (GestureController.this.f255042x.computeScrollOffset()) {
                    if (!GestureController.this.s(GestureController.this.f255042x.getCurrX() - currX, GestureController.this.f255042x.getCurrY() - currY)) {
                        GestureController.this.K();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!GestureController.this.i()) {
                    GestureController.this.r(false);
                }
            } else {
                z16 = false;
            }
            if (GestureController.this.j()) {
                GestureController.this.f255043y.a();
                float c16 = GestureController.this.f255043y.c();
                if (!Float.isNaN(GestureController.this.f255033o) && !Float.isNaN(GestureController.this.f255034p) && !Float.isNaN(GestureController.this.f255035q) && !Float.isNaN(GestureController.this.f255036r)) {
                    GestureController gestureController = GestureController.this;
                    com.tencent.mobileqq.ocr.view.gesture.utils.b.c(gestureController.E, gestureController.A, gestureController.f255033o, gestureController.f255034p, gestureController.B, gestureController.f255035q, GestureController.this.f255036r, c16);
                } else {
                    GestureController gestureController2 = GestureController.this;
                    com.tencent.mobileqq.ocr.view.gesture.utils.b.d(gestureController2.E, gestureController2.A, gestureController2.B, c16);
                }
                if (!GestureController.this.j()) {
                    GestureController.this.E(false);
                }
            } else {
                z17 = z16;
            }
            if (z17) {
                GestureController.this.n();
            }
            return z17;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
            return;
        }
        H = new PointF();
        I = new RectF();
        J = new float[2];
    }

    public GestureController(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.f255023e = new ArrayList();
        this.f255033o = Float.NaN;
        this.f255034p = Float.NaN;
        this.f255035q = Float.NaN;
        this.f255036r = Float.NaN;
        this.f255041w = 0;
        this.A = new com.tencent.mobileqq.ocr.view.gesture.state.c();
        this.B = new com.tencent.mobileqq.ocr.view.gesture.state.c();
        this.E = new com.tencent.mobileqq.ocr.view.gesture.state.c();
        this.F = new com.tencent.mobileqq.ocr.view.gesture.state.c();
        Context context = view.getContext();
        this.C = view;
        Settings settings = new Settings();
        this.D = settings;
        this.G = new d(settings);
        this.f255024f = new LocalAnimationEngine(view);
        a aVar = new a(this);
        this.f255025g = new GestureDetector(context, aVar);
        this.f255026h = new com.tencent.mobileqq.ocr.view.gesture.detector.a(context, aVar);
        this.f255027i = new com.tencent.mobileqq.ocr.view.gesture.detector.b(context, aVar);
        this.f255042x = new OverScroller(context);
        this.f255043y = new com.tencent.mobileqq.ocr.view.gesture.animation.b();
        this.f255044z = new com.tencent.mobileqq.ocr.view.gesture.state.a(settings);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f255019a = viewConfiguration.getScaledTouchSlop();
        this.f255020b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f255021c = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private boolean g(com.tencent.mobileqq.ocr.view.gesture.state.c cVar, boolean z16) {
        com.tencent.mobileqq.ocr.view.gesture.state.c cVar2;
        if (cVar == null) {
            return false;
        }
        if (z16) {
            cVar2 = this.G.g(cVar, this.F, this.f255033o, this.f255034p, false, false, true);
        } else {
            cVar2 = null;
        }
        if (cVar2 != null) {
            cVar = cVar2;
        }
        if (cVar.equals(this.E)) {
            return false;
        }
        J();
        this.f255040v = z16;
        this.A.m(this.E);
        this.B.m(cVar);
        if (!Float.isNaN(this.f255033o) && !Float.isNaN(this.f255034p)) {
            float[] fArr = J;
            fArr[0] = this.f255033o;
            fArr[1] = this.f255034p;
            com.tencent.mobileqq.ocr.view.gesture.utils.b.a(fArr, this.A, this.B);
            this.f255035q = fArr[0];
            this.f255036r = fArr[1];
        }
        this.f255043y.f(this.D.c());
        this.f255043y.g(0.0f, 1.0f);
        this.f255024f.g(2);
        m();
        return true;
    }

    private int k(float f16) {
        if (Math.abs(f16) < this.f255020b) {
            return 0;
        }
        if (Math.abs(f16) >= this.f255021c) {
            return ((int) Math.signum(f16)) * this.f255021c;
        }
        return Math.round(f16);
    }

    private void m() {
        int i3;
        if (h()) {
            i3 = 2;
        } else if (!this.f255030l && !this.f255031m && !this.f255032n) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (this.f255041w != i3) {
            this.f255041w = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) scaleGestureDetector);
            return;
        }
        this.f255031m = false;
        this.f255038t = true;
        b bVar = this.f255022d;
        if (bVar != null) {
            bVar.onScaleEnd(scaleGestureDetector);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!this.D.A() || j()) {
            return false;
        }
        if (!this.f255030l) {
            if (Math.abs(motionEvent2.getX() - motionEvent.getX()) <= this.f255019a && Math.abs(motionEvent2.getY() - motionEvent.getY()) <= this.f255019a) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.f255030l = z16;
            if (z16) {
                return false;
            }
        }
        if (this.f255030l) {
            b bVar = this.f255022d;
            if (bVar != null && bVar.onScroll(motionEvent, motionEvent2, f16, f17)) {
                return true;
            }
            this.E.n(-f16, -f17);
            this.f255037s = true;
        }
        return this.f255030l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.D.v()) {
            this.C.performClick();
        }
        b bVar = this.f255022d;
        if (bVar != null && bVar.onSingleTapConfirmed(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean D(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.D.v()) {
            this.C.performClick();
        }
        b bVar = this.f255022d;
        if (bVar != null && bVar.onSingleTapUp(motionEvent)) {
            return true;
        }
        return false;
    }

    protected void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        this.f255040v = false;
        this.f255033o = Float.NaN;
        this.f255034p = Float.NaN;
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (!this.f255028j) {
            G(view, motionEvent);
        }
        this.f255028j = false;
        return this.D.w();
    }

    protected boolean G(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(-view.getPaddingLeft(), -view.getPaddingTop());
        this.f255025g.setIsLongpressEnabled(view.isLongClickable());
        boolean onTouchEvent = this.f255025g.onTouchEvent(obtain);
        if (motionEvent.getPointerCount() > 1) {
            if (this.D.E()) {
                this.f255026h.onTouchEvent(obtain);
            }
            if (this.D.D()) {
                this.f255027i.f(obtain);
            }
            if (!onTouchEvent && !this.f255031m && !this.f255032n) {
                onTouchEvent = false;
            } else {
                onTouchEvent = true;
            }
        }
        m();
        if (this.f255037s) {
            this.f255037s = false;
            this.G.f(this.E, this.F, this.f255033o, this.f255034p, true, true, false);
            if (!this.E.equals(this.F)) {
                n();
            }
        }
        if (this.f255038t || this.f255039u) {
            this.f255038t = false;
            this.f255039u = false;
            g(this.G.g(this.E, this.F, this.f255033o, this.f255034p, true, false, true), false);
        }
        if (obtain.getActionMasked() == 1 || obtain.getActionMasked() == 3) {
            H(obtain);
            m();
        }
        if (!this.f255029k && I(obtain)) {
            this.f255029k = true;
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
        obtain.recycle();
        return onTouchEvent;
    }

    protected void H(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) motionEvent);
            return;
        }
        this.f255030l = false;
        this.f255031m = false;
        this.f255032n = false;
        if (!i() && !this.f255040v) {
            e();
        }
        b bVar = this.f255022d;
        if (bVar != null) {
            bVar.b(motionEvent);
        }
    }

    protected boolean I(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 2) {
            if (actionMasked == 5) {
                if (this.D.E() || this.D.D()) {
                    return true;
                }
                return false;
            }
        } else {
            d dVar = this.G;
            com.tencent.mobileqq.ocr.view.gesture.state.c cVar = this.E;
            RectF rectF = I;
            dVar.d(cVar, rectF);
            if (com.tencent.mobileqq.ocr.view.gesture.state.c.a(rectF.width(), 0.0f) <= 0 && com.tencent.mobileqq.ocr.view.gesture.state.c.a(rectF.height(), 0.0f) <= 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (this.D.A() && (z16 || !this.D.B())) {
                return true;
            }
        }
        return false;
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            L();
            K();
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (i()) {
            this.f255042x.forceFinished(true);
            r(true);
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (j()) {
            this.f255043y.b();
            E(true);
        }
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return g(this.E, true);
    }

    public boolean f(com.tencent.mobileqq.ocr.view.gesture.state.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        return g(cVar, true);
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!j() && !i()) {
            return false;
        }
        return true;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return !this.f255042x.isFinished();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return !this.f255043y.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator<GestureProxy.a> it = this.f255023e.iterator();
        while (it.hasNext()) {
            it.next().a(this.F, this.E);
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.F.m(this.E);
        Iterator<GestureProxy.a> it = this.f255023e.iterator();
        while (it.hasNext()) {
            it.next().b(this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.D.v() || motionEvent.getActionMasked() != 1 || this.f255031m) {
            return false;
        }
        b bVar = this.f255022d;
        if (bVar != null && bVar.onDoubleTap(motionEvent)) {
            return true;
        }
        f(this.G.h(this.E, motionEvent.getX(), motionEvent.getY()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.f255029k = false;
        K();
        b bVar = this.f255022d;
        if (bVar != null) {
            bVar.onDown(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (!this.D.A() || !this.D.y() || j()) {
            return false;
        }
        b bVar = this.f255022d;
        if (bVar != null && bVar.onFling(motionEvent, motionEvent2, f16, f17)) {
            return true;
        }
        K();
        this.f255044z.i(this.E).e(this.E.g(), this.E.h());
        this.f255042x.fling(Math.round(this.E.g()), Math.round(this.E.h()), k(f16 * 0.9f), k(0.9f * f17), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.f255024f.g(3);
        m();
        return true;
    }

    protected void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (!z16) {
            e();
        }
        m();
    }

    protected boolean s(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        float g16 = this.E.g();
        float h16 = this.E.h();
        float f16 = i3 + g16;
        float f17 = i16 + h16;
        if (this.D.B()) {
            com.tencent.mobileqq.ocr.view.gesture.state.a aVar = this.f255044z;
            PointF pointF = H;
            aVar.h(f16, f17, pointF);
            f16 = pointF.x;
            f17 = pointF.y;
        }
        this.E.o(f16, f17);
        if (!com.tencent.mobileqq.ocr.view.gesture.state.c.c(g16, f16) || !com.tencent.mobileqq.ocr.view.gesture.state.c.c(h16, f17)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        this.f255028j = true;
        return G(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) motionEvent);
            return;
        }
        if (this.D.w()) {
            this.C.performLongClick();
            b bVar = this.f255022d;
            if (bVar != null) {
                bVar.onLongPress(motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v(com.tencent.mobileqq.ocr.view.gesture.detector.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) bVar)).booleanValue();
        }
        if (this.D.D() && !j()) {
            this.f255033o = bVar.c();
            this.f255034p = bVar.d();
            this.E.j(bVar.e(), this.f255033o, this.f255034p);
            this.f255037s = true;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w(com.tencent.mobileqq.ocr.view.gesture.detector.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) bVar)).booleanValue();
        }
        boolean D = this.D.D();
        this.f255032n = D;
        return D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(com.tencent.mobileqq.ocr.view.gesture.detector.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bVar);
        } else {
            this.f255032n = false;
            this.f255039u = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        if (this.D.E() && !j()) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            this.f255033o = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            this.f255034p = focusY;
            this.E.q(scaleFactor, this.f255033o, focusY);
            this.f255037s = true;
            b bVar = this.f255022d;
            if (bVar != null) {
                bVar.onScale(scaleGestureDetector);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        this.f255031m = this.D.E();
        b bVar = this.f255022d;
        if (bVar != null) {
            bVar.onScaleBegin(scaleGestureDetector);
        }
        return this.f255031m;
    }
}
