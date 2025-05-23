package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDoubleClickLayout extends FrameLayout {
    private static final int R = com.tencent.mobileqq.qcircle.api.constant.a.f261576a;
    private final Handler C;
    private int D;
    private boolean E;
    private boolean F;
    private MotionEvent G;
    private MotionEvent H;
    private MotionEvent I;
    private MotionEvent J;
    private MotionEvent K;
    private long L;
    private long M;
    private boolean N;
    private Runnable P;
    private Runnable Q;

    /* renamed from: d, reason: collision with root package name */
    private boolean f92958d;

    /* renamed from: e, reason: collision with root package name */
    private int f92959e;

    /* renamed from: f, reason: collision with root package name */
    private int f92960f;

    /* renamed from: h, reason: collision with root package name */
    private int f92961h;

    /* renamed from: i, reason: collision with root package name */
    private c f92962i;

    /* renamed from: m, reason: collision with root package name */
    private b f92963m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onLongClick();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(MotionEvent motionEvent);
    }

    public QCircleDoubleClickLayout(@NonNull Context context) {
        super(context);
        this.f92958d = true;
        this.C = new Handler(Looper.getMainLooper());
        this.E = false;
        this.F = false;
        this.L = 0L;
        this.M = 0L;
        this.Q = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (QCircleDoubleClickLayout.this.f92963m != null) {
                    if (QCircleDoubleClickLayout.this.getParent() != null) {
                        QCircleDoubleClickLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    QCircleDoubleClickLayout.this.f92963m.onLongClick();
                    QLog.d("QCircleDoubleClickLayout", 1, "onLongClick:" + QCircleDoubleClickLayout.this.D);
                }
            }
        };
        r();
    }

    private void m(final MotionEvent motionEvent) {
        int i3;
        if (motionEvent == null) {
            QLog.e("QCircleDoubleClickLayout", 1, "[dealActionDown] ev should not be null.");
            return;
        }
        if (this.G == null) {
            this.G = MotionEvent.obtain(motionEvent);
            this.D = 1;
            QLog.d("QCircleDoubleClickLayout", 4, "firstdown clickcount:" + this.D);
        }
        if (this.D >= 1 && s(this.I, this.J, motionEvent)) {
            this.D++;
            QLog.d("QCircleDoubleClickLayout", 4, "considerdown clickcount:" + this.D);
        }
        if (u()) {
            this.N = false;
        }
        if (!this.E) {
            this.C.removeCallbacks(this.P);
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    QCircleDoubleClickLayout.this.E = false;
                    QLog.d("QCircleDoubleClickLayout", 1, "[run] mClickCount: " + QCircleDoubleClickLayout.this.D);
                    if (QCircleDoubleClickLayout.this.D >= 2) {
                        QCircleDoubleClickLayout.this.z(motionEvent.getX(), motionEvent.getY());
                    } else if (QCircleDoubleClickLayout.this.D == 1 && QCircleDoubleClickLayout.this.N) {
                        QCircleDoubleClickLayout.this.z(motionEvent.getX(), motionEvent.getY());
                    } else if (QCircleDoubleClickLayout.this.D == 1) {
                        QCircleDoubleClickLayout.this.q();
                    }
                    QCircleDoubleClickLayout.this.D = 0;
                    QCircleDoubleClickLayout.this.G = null;
                    QCircleDoubleClickLayout.this.H = null;
                    QCircleDoubleClickLayout.this.I = null;
                    QCircleDoubleClickLayout.this.J = null;
                    QCircleDoubleClickLayout.this.K = null;
                }
            };
            this.P = runnable;
            Handler handler = this.C;
            if (this.N) {
                i3 = com.tencent.mobileqq.qcircle.api.constant.a.f261577b;
            } else {
                i3 = com.tencent.mobileqq.qcircle.api.constant.a.f261576a;
            }
            handler.postDelayed(runnable, i3);
            this.C.removeCallbacks(this.Q);
            this.C.postDelayed(this.Q, com.tencent.mobileqq.qcircle.api.constant.a.f261578c);
            this.E = true;
        }
        MotionEvent motionEvent2 = this.I;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.I = MotionEvent.obtain(motionEvent);
    }

    private void n(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        MotionEvent motionEvent2 = this.K;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.K = obtain;
        if (t(this.I, obtain)) {
            this.C.removeCallbacks(this.Q);
            p();
            A();
            this.F = true;
        }
    }

    private void o(MotionEvent motionEvent) {
        if (motionEvent == null) {
            QLog.e("QCircleDoubleClickLayout", 1, "[dealActionUp] ev should not be null.");
            return;
        }
        if (this.H == null) {
            this.H = MotionEvent.obtain(motionEvent);
        }
        MotionEvent motionEvent2 = this.J;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.J = MotionEvent.obtain(motionEvent);
    }

    private void p() {
        MotionEvent motionEvent;
        boolean z16;
        if (this.K != null && (motionEvent = this.I) != null) {
            w(motionEvent);
            MotionEvent motionEvent2 = this.K;
            boolean z17 = true;
            if (this.I.getX() > this.K.getX()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.I.getY() <= this.K.getY()) {
                z17 = false;
            }
            x(motionEvent2, z16, z17);
            QLog.d("QCircleDoubleClickLayout", 4, "move success");
            return;
        }
        QLog.d("QCircleDoubleClickLayout", 4, "move error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!u()) {
            QLog.d("QCircleDoubleClickLayout", 1, "[dispatchSingleClickEvent] current not need single click time, end flow.");
            return;
        }
        this.M = System.currentTimeMillis();
        if (v(this.G, this.H)) {
            w(this.G);
            y(this.H);
            c cVar = this.f92962i;
            if (cVar != null) {
                cVar.a(this.G);
            }
            QLog.d("QCircleDoubleClickLayout", 1, "singleTap success");
            return;
        }
        QLog.d("QCircleDoubleClickLayout", 1, "singleTap error");
    }

    private void r() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f92959e = scaledDoubleTapSlop;
        this.f92960f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f92961h = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
    }

    private boolean s(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || motionEvent3.getEventTime() - motionEvent2.getEventTime() > R || t(motionEvent, motionEvent2)) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x16 * x16) + (y16 * y16) >= this.f92960f) {
            return false;
        }
        return true;
    }

    private boolean t(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        int x16 = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
        int y16 = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
        if ((x16 * x16) + (y16 * y16) <= this.f92961h) {
            return false;
        }
        return true;
    }

    private boolean u() {
        if (System.currentTimeMillis() - this.L >= 500) {
            return true;
        }
        return false;
    }

    private boolean v(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent != null && motionEvent2 != null) {
            boolean z16 = !t(motionEvent, motionEvent2);
            if (QLog.isColorLevel()) {
                QLog.d("QCircleDoubleClickLayout", 2, "[isSingleTap] isNotConsideredScroll: " + z16);
            }
            return z16;
        }
        QLog.d("QCircleDoubleClickLayout", 1, "[isSingleTap] firstDown: " + motionEvent + " | firstUp: " + motionEvent2);
        return false;
    }

    private void w(MotionEvent motionEvent) {
        if (motionEvent != null) {
            super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, motionEvent.getX(), motionEvent.getY(), 0));
        }
    }

    private void x(MotionEvent motionEvent, boolean z16, boolean z17) {
        float x16;
        float f16;
        if (motionEvent == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (z16) {
            x16 = motionEvent.getX() - this.f92961h;
        } else {
            x16 = motionEvent.getX() + this.f92961h;
        }
        float f17 = x16;
        float y16 = motionEvent.getY();
        float f18 = this.f92961h;
        if (z17) {
            f16 = y16 - f18;
        } else {
            f16 = y16 + f18;
        }
        super.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 2, f17, f16, 0));
    }

    private void y(MotionEvent motionEvent) {
        if (motionEvent != null) {
            super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, motionEvent.getX(), motionEvent.getY(), 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(float f16, float f17) {
        QLog.e("QCircleDoubleClickLayout", 1, "[notifyDoubleClick] double click listener should not be null.");
    }

    public void A() {
        this.f92958d = true;
        this.D = 0;
        this.E = false;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.F = false;
        this.L = 0L;
        this.M = 0L;
        this.C.removeCallbacks(this.P);
        this.C.removeCallbacks(this.Q);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f92958d && motionEvent.getSource() != 0) {
            if (motionEvent.getAction() == 0) {
                m(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                this.C.removeCallbacks(this.Q);
                if (this.F) {
                    QLog.w("QCircleDoubleClickLayout", 1, "[dispatchTouchEvent] isRestByMove == true...");
                    this.F = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
                o(motionEvent);
            } else if (motionEvent.getAction() == 2) {
                n(motionEvent);
            } else if (motionEvent.getAction() == 3) {
                A();
            }
            if (this.E) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        QLog.d("QCircleDoubleClickLayout", 4, "not intercept");
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setEnableDoubleClick(boolean z16) {
        this.f92958d = z16;
    }

    public void setOnLongClickListener(b bVar) {
        this.f92963m = bVar;
    }

    public void setOnTapClickListener(c cVar) {
        this.f92962i = cVar;
    }

    public QCircleDoubleClickLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f92958d = true;
        this.C = new Handler(Looper.getMainLooper());
        this.E = false;
        this.F = false;
        this.L = 0L;
        this.M = 0L;
        this.Q = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (QCircleDoubleClickLayout.this.f92963m != null) {
                    if (QCircleDoubleClickLayout.this.getParent() != null) {
                        QCircleDoubleClickLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    QCircleDoubleClickLayout.this.f92963m.onLongClick();
                    QLog.d("QCircleDoubleClickLayout", 1, "onLongClick:" + QCircleDoubleClickLayout.this.D);
                }
            }
        };
        r();
    }

    public QCircleDoubleClickLayout(@NonNull Context context, @NonNull AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f92958d = true;
        this.C = new Handler(Looper.getMainLooper());
        this.E = false;
        this.F = false;
        this.L = 0L;
        this.M = 0L;
        this.Q = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (QCircleDoubleClickLayout.this.f92963m != null) {
                    if (QCircleDoubleClickLayout.this.getParent() != null) {
                        QCircleDoubleClickLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    QCircleDoubleClickLayout.this.f92963m.onLongClick();
                    QLog.d("QCircleDoubleClickLayout", 1, "onLongClick:" + QCircleDoubleClickLayout.this.D);
                }
            }
        };
        r();
    }

    public void setOnDoubleClickListener(a aVar) {
    }
}
