package com.tencent.biz.qqcircle.comment.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentGestureDetectLayout extends RelativeLayout {
    private static final int Q = com.tencent.mobileqq.qcircle.api.constant.a.f261576a;
    private boolean C;
    private boolean D;
    private MotionEvent E;
    private MotionEvent F;
    private MotionEvent G;
    private MotionEvent H;
    private MotionEvent I;
    private MotionEvent J;
    private long K;
    private long L;
    private boolean M;
    private Runnable N;
    private Runnable P;

    /* renamed from: d, reason: collision with root package name */
    private boolean f84036d;

    /* renamed from: e, reason: collision with root package name */
    private int f84037e;

    /* renamed from: f, reason: collision with root package name */
    private int f84038f;

    /* renamed from: h, reason: collision with root package name */
    private int f84039h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f84040i;

    /* renamed from: m, reason: collision with root package name */
    private int f84041m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
    }

    public QFSCommentGestureDetectLayout(@NonNull Context context) {
        super(context);
        this.f84036d = true;
        this.f84040i = new Handler(Looper.getMainLooper());
        this.C = false;
        this.D = false;
        this.K = 0L;
        this.L = 0L;
        this.P = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentGestureDetectLayout.c(QFSCommentGestureDetectLayout.this);
            }
        };
        r();
    }

    static /* bridge */ /* synthetic */ b c(QFSCommentGestureDetectLayout qFSCommentGestureDetectLayout) {
        qFSCommentGestureDetectLayout.getClass();
        return null;
    }

    private void m(final MotionEvent motionEvent) {
        int i3;
        if (motionEvent == null) {
            QLog.e("QFSCommentGestureDetectLayout", 1, "[dealActionDown] ev should not be null.");
            return;
        }
        this.E = MotionEvent.obtain(motionEvent);
        if (this.F == null) {
            this.F = MotionEvent.obtain(motionEvent);
            this.f84041m = 1;
            QLog.d("QFSCommentGestureDetectLayout", 4, "firstdown clickcount:" + this.f84041m);
        }
        if (this.f84041m >= 1 && s(this.H, this.I, motionEvent)) {
            this.f84041m++;
            QLog.d("QFSCommentGestureDetectLayout", 4, "considerdown clickcount:" + this.f84041m);
        }
        if (u()) {
            this.M = false;
        }
        if (!this.C) {
            this.f84040i.removeCallbacks(this.N);
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSCommentGestureDetectLayout.this.C = false;
                    QLog.d("QFSCommentGestureDetectLayout", 1, "[run] mClickCount: " + QFSCommentGestureDetectLayout.this.f84041m);
                    if (QFSCommentGestureDetectLayout.this.f84041m >= 2) {
                        QFSCommentGestureDetectLayout.this.z(motionEvent);
                    } else if (QFSCommentGestureDetectLayout.this.f84041m == 1 && QFSCommentGestureDetectLayout.this.M) {
                        QFSCommentGestureDetectLayout.this.z(motionEvent);
                    } else if (QFSCommentGestureDetectLayout.this.f84041m == 1) {
                        QFSCommentGestureDetectLayout.this.q();
                    }
                    QFSCommentGestureDetectLayout.this.f84041m = 0;
                    QFSCommentGestureDetectLayout.this.F = null;
                    QFSCommentGestureDetectLayout.this.G = null;
                    QFSCommentGestureDetectLayout.this.H = null;
                    QFSCommentGestureDetectLayout.this.I = null;
                    QFSCommentGestureDetectLayout.this.J = null;
                }
            };
            this.N = runnable;
            Handler handler = this.f84040i;
            if (this.M) {
                i3 = com.tencent.mobileqq.qcircle.api.constant.a.f261577b;
            } else {
                i3 = com.tencent.mobileqq.qcircle.api.constant.a.f261576a;
            }
            handler.postDelayed(runnable, i3);
            this.f84040i.removeCallbacks(this.P);
            this.f84040i.postDelayed(this.P, com.tencent.mobileqq.qcircle.api.constant.a.f261578c);
            this.C = true;
        }
        MotionEvent motionEvent2 = this.H;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.H = MotionEvent.obtain(motionEvent);
    }

    private void n(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        MotionEvent motionEvent2 = this.J;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.J = obtain;
        if (t(this.H, obtain)) {
            this.f84040i.removeCallbacks(this.P);
            p();
            A();
            this.D = true;
        }
    }

    private void o(MotionEvent motionEvent) {
        if (motionEvent == null) {
            QLog.e("QFSCommentGestureDetectLayout", 1, "[dealActionUp] ev should not be null.");
            return;
        }
        if (this.G == null) {
            this.G = MotionEvent.obtain(motionEvent);
        }
        MotionEvent motionEvent2 = this.I;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.I = MotionEvent.obtain(motionEvent);
    }

    private void p() {
        MotionEvent motionEvent;
        boolean z16;
        if (this.J != null && (motionEvent = this.H) != null) {
            w(motionEvent);
            MotionEvent motionEvent2 = this.J;
            boolean z17 = true;
            if (this.H.getX() > this.J.getX()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.H.getY() <= this.J.getY()) {
                z17 = false;
            }
            x(motionEvent2, z16, z17);
            QLog.d("QFSCommentGestureDetectLayout", 4, "move success");
            return;
        }
        QLog.d("QFSCommentGestureDetectLayout", 4, "move error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!u()) {
            QLog.d("QFSCommentGestureDetectLayout", 1, "[dispatchSingleClickEvent] current not need single click time, end flow.");
            return;
        }
        this.L = System.currentTimeMillis();
        if (v(this.F, this.G)) {
            w(this.F);
            y(this.G);
            QLog.d("QFSCommentGestureDetectLayout", 1, "singleTap success");
            return;
        }
        QLog.d("QFSCommentGestureDetectLayout", 1, "singleTap error");
    }

    private void r() {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f84037e = scaledDoubleTapSlop;
        this.f84038f = scaledDoubleTapSlop * scaledDoubleTapSlop;
        this.f84039h = viewConfiguration.getScaledTouchSlop() * viewConfiguration.getScaledTouchSlop();
    }

    private boolean s(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || motionEvent3.getEventTime() - motionEvent2.getEventTime() > Q || t(motionEvent, motionEvent2)) {
            return false;
        }
        int x16 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y16 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        if ((x16 * x16) + (y16 * y16) >= this.f84038f) {
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
        if ((x16 * x16) + (y16 * y16) <= this.f84039h) {
            return false;
        }
        return true;
    }

    private boolean u() {
        if (System.currentTimeMillis() - this.K >= 500) {
            return true;
        }
        return false;
    }

    private boolean v(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent != null && motionEvent2 != null) {
            boolean z16 = !t(motionEvent, motionEvent2);
            if (QLog.isColorLevel()) {
                QLog.d("QFSCommentGestureDetectLayout", 2, "[isSingleTap] isNotConsideredScroll: " + z16);
            }
            return z16;
        }
        QLog.d("QFSCommentGestureDetectLayout", 1, "[isSingleTap] firstDown: " + motionEvent + " | firstUp: " + motionEvent2);
        return false;
    }

    private void w(MotionEvent motionEvent) {
        if (motionEvent != null) {
            super.dispatchTouchEvent(motionEvent);
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
            x16 = motionEvent.getX() - this.f84039h;
        } else {
            x16 = motionEvent.getX() + this.f84039h;
        }
        float f17 = x16;
        float y16 = motionEvent.getY();
        float f18 = this.f84039h;
        if (z17) {
            f16 = y16 - f18;
        } else {
            f16 = y16 + f18;
        }
        super.dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, 2, f17, f16, 0));
    }

    private void y(MotionEvent motionEvent) {
        if (motionEvent != null) {
            super.dispatchTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(MotionEvent motionEvent) {
        QLog.e("QFSCommentGestureDetectLayout", 1, "[notifyDoubleClick] double click listener should not be null.");
    }

    public void A() {
        this.f84041m = 0;
        this.C = false;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.D = false;
        this.K = 0L;
        this.L = 0L;
        this.f84040i.removeCallbacks(this.N);
        this.f84040i.removeCallbacks(this.P);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f84036d && motionEvent != this.F && motionEvent != this.G) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSCommentGestureDetectLayout", 2, "event:" + motionEvent.getAction() + " mIsRunnablePosting:" + this.C);
            }
            if (motionEvent.getAction() == 0) {
                m(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                this.f84040i.removeCallbacks(this.P);
                if (this.D) {
                    QLog.w("QFSCommentGestureDetectLayout", 1, "[dispatchTouchEvent] isRestByMove == true...");
                    this.D = false;
                    return super.dispatchTouchEvent(motionEvent);
                }
                o(motionEvent);
            } else if (motionEvent.getAction() == 2) {
                n(motionEvent);
            } else if (motionEvent.getAction() == 3) {
                A();
            }
            if (this.C) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        QLog.d("QFSCommentGestureDetectLayout", 4, "not intercept");
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setEnableDoubleClick(boolean z16) {
        this.f84036d = z16;
    }

    public QFSCommentGestureDetectLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f84036d = true;
        this.f84040i = new Handler(Looper.getMainLooper());
        this.C = false;
        this.D = false;
        this.K = 0L;
        this.L = 0L;
        this.P = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentGestureDetectLayout.c(QFSCommentGestureDetectLayout.this);
            }
        };
        r();
    }

    public QFSCommentGestureDetectLayout(@NonNull Context context, @NonNull AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f84036d = true;
        this.f84040i = new Handler(Looper.getMainLooper());
        this.C = false;
        this.D = false;
        this.K = 0L;
        this.L = 0L;
        this.P = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.widget.QFSCommentGestureDetectLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentGestureDetectLayout.c(QFSCommentGestureDetectLayout.this);
            }
        };
        r();
    }

    public void setOnDoubleClickListener(a aVar) {
    }

    public void setOnLongClickListener(b bVar) {
    }
}
