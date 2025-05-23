package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class QFSRatePlayGestureDetectorView extends FrameLayout {
    private static final int N = cx.a(30.0f);
    private MotionEvent C;
    private Handler D;
    private Runnable E;
    private a F;
    private final Rect G;
    private b H;
    private float I;
    private float J;
    private float K;
    private MotionEvent L;
    private MotionEvent M;

    /* renamed from: d, reason: collision with root package name */
    private boolean f93390d;

    /* renamed from: e, reason: collision with root package name */
    private float f93391e;

    /* renamed from: f, reason: collision with root package name */
    private float f93392f;

    /* renamed from: h, reason: collision with root package name */
    private float f93393h;

    /* renamed from: i, reason: collision with root package name */
    private float f93394i;

    /* renamed from: m, reason: collision with root package name */
    private int f93395m;

    /* loaded from: classes5.dex */
    public interface a {
        void q(View view);

        void w(View view);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void D(View view, boolean z16);
    }

    public QFSRatePlayGestureDetectorView(Context context) {
        super(context);
        this.D = new Handler(Looper.getMainLooper());
        this.G = new Rect();
        this.I = 0.0f;
        this.J = 0.0f;
        i();
    }

    private boolean g(MotionEvent motionEvent) {
        if (motionEvent != this.M && motionEvent != this.L && motionEvent.getSource() != 0 && motionEvent.getSource() != 2) {
            return false;
        }
        return true;
    }

    private void h() {
        Rect rect = this.G;
        if (rect.top == 0) {
            getGlobalVisibleRect(rect);
            QLog.d("QFSRatePlayGestureDetectorView", 1, "getGlobalRect:" + this.G.top);
        }
    }

    private void i() {
        this.f93395m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.E = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bk
            @Override // java.lang.Runnable
            public final void run() {
                QFSRatePlayGestureDetectorView.this.k();
            }
        };
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.biz.qqcircle.widgets.bl
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                QFSRatePlayGestureDetectorView.this.l(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    private boolean j(float f16, float f17) {
        if (Math.abs(f16 - this.f93393h) <= this.f93395m && Math.abs(f17 - this.f93394i) <= this.f93395m) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f93390d = true;
        a aVar = this.F;
        if (aVar != null) {
            aVar.w(this);
        }
        QLog.d("QFSRatePlayGestureDetectorView", 4, "long progress");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.G.top = 0;
        QLog.d("QFSRatePlayGestureDetectorView", 4, "onLayout change");
    }

    private void m(final MotionEvent motionEvent, final MotionEvent motionEvent2) {
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView.1
            @Override // java.lang.Runnable
            public void run() {
                QFSRatePlayGestureDetectorView.this.D.removeCallbacks(QFSRatePlayGestureDetectorView.this.E);
                MotionEvent motionEvent3 = motionEvent;
                if (motionEvent3 != null && motionEvent2 != null) {
                    QFSRatePlayGestureDetectorView.this.n(motionEvent3);
                    QFSRatePlayGestureDetectorView.this.o(motionEvent2);
                    motionEvent.recycle();
                    motionEvent2.recycle();
                }
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(MotionEvent motionEvent) {
        if (motionEvent != null) {
            h();
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 0, motionEvent.getX() + this.G.left, motionEvent.getY() + this.G.top, 0);
            this.L = obtain;
            obtain.setSource(motionEvent.getSource());
            QLog.d("QFSRatePlayGestureDetectorView", 1, "mockDown:" + uptimeMillis + " | x:" + motionEvent.getX() + " | left:" + this.G.left + " | y:" + motionEvent.getY() + " | top: " + this.G.top);
            getRootView().dispatchTouchEvent(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(MotionEvent motionEvent) {
        long downTime;
        if (motionEvent != null) {
            h();
            MotionEvent motionEvent2 = this.L;
            if (motionEvent2 == null) {
                downTime = SystemClock.uptimeMillis();
            } else {
                downTime = motionEvent2.getDownTime();
            }
            MotionEvent obtain = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), 1, motionEvent.getX() + this.G.left, motionEvent.getY() + this.G.top, 0);
            this.M = obtain;
            obtain.setSource(motionEvent.getSource());
            QLog.d("QFSRatePlayGestureDetectorView", 1, "mockup:" + downTime + " | x:" + motionEvent.getX() + " | left:" + this.G.left + " | y:" + motionEvent.getY() + " | top:" + this.G.top);
            getRootView().dispatchTouchEvent(this.M);
        }
    }

    private void p(boolean z16) {
        ViewParent parent = getParent();
        while (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
            parent = parent.getParent();
            if (parent instanceof QFSPageTurnContainer) {
                return;
            }
        }
    }

    private void q() {
        this.f93390d = false;
        this.I = 0.0f;
        this.J = 0.0f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar;
        String str;
        a aVar;
        if (g(motionEvent)) {
            QLog.d("QFSRatePlayGestureDetectorView", 1, "dispatchTouchEvent not reWrite mock:" + motionEvent.getActionMasked());
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            boolean z16 = false;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        this.D.removeCallbacks(this.E);
                        if (this.f93390d && (aVar = this.F) != null) {
                            aVar.q(this);
                            QLog.d("QFSRatePlayGestureDetectorView", 4, "ACTION_cancel notify up");
                        }
                        q();
                        p(false);
                        QLog.d("QFSRatePlayGestureDetectorView", 4, "ACTION_cancel");
                    }
                } else {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (this.f93390d) {
                        p(true);
                        float f16 = this.K;
                        if (rawY > f16 && this.I >= 0.0f) {
                            this.I = -1.0f;
                            this.f93392f = rawY;
                            this.f93391e = rawX;
                            QLog.d("QFSRatePlayGestureDetectorView", 4, "scrollY orient change down");
                        } else if (rawY < f16 && this.I <= 0.0f) {
                            this.I = 1.0f;
                            this.f93392f = rawY;
                            this.f93391e = rawX;
                            QLog.d("QFSRatePlayGestureDetectorView", 4, "scrollY orient change up");
                        }
                        float f17 = rawX - this.f93391e;
                        float f18 = rawY - this.f93392f;
                        if (Math.abs(f18) >= Math.abs(f17) && Math.abs(f18) > N && (bVar = this.H) != null) {
                            float f19 = this.J;
                            float f26 = this.I;
                            if (f19 != f26) {
                                this.J = f26;
                                if (f26 == 1.0f) {
                                    z16 = true;
                                }
                                bVar.D(this, z16);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("notify orient change:");
                                if (this.J == 1.0f) {
                                    str = "up";
                                } else {
                                    str = "down";
                                }
                                sb5.append(str);
                                QLog.d("QFSRatePlayGestureDetectorView", 4, sb5.toString());
                            }
                        }
                    } else if (j(rawX, rawY)) {
                        this.D.removeCallbacks(this.E);
                        q();
                        p(false);
                    }
                    this.K = rawY;
                }
            } else {
                this.D.removeCallbacks(this.E);
                if (!this.f93390d) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setSource(motionEvent.getSource());
                    m(this.C, obtain);
                    QLog.d("QFSRatePlayGestureDetectorView", 4, "ACTION_UP:mockClick");
                } else {
                    a aVar2 = this.F;
                    if (aVar2 != null) {
                        aVar2.q(this);
                    }
                    QLog.d("QFSRatePlayGestureDetectorView", 4, "ACTION_UP:longPressUp");
                }
                q();
                p(false);
            }
            return true;
        }
        q();
        this.D.removeCallbacks(this.E);
        this.D.postDelayed(this.E, 500L);
        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
        this.C = obtain2;
        obtain2.setSource(motionEvent.getSource());
        this.f93393h = motionEvent.getRawX();
        this.f93394i = motionEvent.getRawY();
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!g(motionEvent)) {
            return true;
        }
        QLog.d("QFSRatePlayGestureDetectorView", 1, "onInterceptTouchEvent not reWrite mock:" + motionEvent.getActionMasked());
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!g(motionEvent)) {
            return true;
        }
        QLog.d("QFSRatePlayGestureDetectorView", 1, "onTouchEvent not reWrite mock:" + motionEvent.getActionMasked());
        return false;
    }

    public void setLongPressListener(a aVar) {
        this.F = aVar;
    }

    public void setYOrientationChangeListener(b bVar) {
        this.H = bVar;
    }

    public QFSRatePlayGestureDetectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new Handler(Looper.getMainLooper());
        this.G = new Rect();
        this.I = 0.0f;
        this.J = 0.0f;
        i();
    }

    public QFSRatePlayGestureDetectorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new Handler(Looper.getMainLooper());
        this.G = new Rect();
        this.I = 0.0f;
        this.J = 0.0f;
        i();
    }
}
