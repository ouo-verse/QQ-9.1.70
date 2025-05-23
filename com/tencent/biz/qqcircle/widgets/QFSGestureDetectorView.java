package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSLongPressOpenShareEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.qqcircle.utils.ce;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSRatePlayGestureDetectorView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGestureDetectorView extends FrameLayout {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f93249b0 = cx.a(30.0f);
    private float C;
    private float D;
    private float E;
    private float F;
    private int G;
    private MotionEvent H;
    private Handler I;
    private Runnable J;
    private QFSRatePlayGestureDetectorView.a K;
    private final Rect L;
    private QFSRatePlayGestureDetectorView.b M;
    private float N;
    private float P;
    private float Q;
    private MotionEvent R;
    private MotionEvent S;
    private int T;
    private int U;
    private long V;
    private List<View> W;

    /* renamed from: a0, reason: collision with root package name */
    private a f93250a0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f93251d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93252e;

    /* renamed from: f, reason: collision with root package name */
    private ScaleGestureDetector f93253f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93254h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93255i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f93256m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        boolean Q(MotionEvent motionEvent, float f16, float f17);

        void b(MotionEvent motionEvent, boolean z16);

        boolean x(boolean z16);
    }

    public QFSGestureDetectorView(Context context) {
        super(context);
        this.f93252e = false;
        this.I = new Handler(Looper.getMainLooper());
        this.L = new Rect();
        this.N = 0.0f;
        this.P = 0.0f;
        this.T = -1;
        this.W = new ArrayList();
        q();
    }

    private void B(boolean z16) {
        ViewParent parent = getParent();
        while (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
            parent = parent.getParent();
            if (parent instanceof QFSPageTurnContainer) {
                ((QFSPageTurnContainer) parent).n(z16);
                return;
            }
        }
    }

    private void C() {
        this.f93251d = false;
        this.f93252e = false;
        this.T = -1;
        this.f93255i = false;
        this.f93254h = false;
        this.N = 0.0f;
        this.P = 0.0f;
        this.L.top = 0;
    }

    private void D() {
        this.f93251d = false;
        this.f93255i = false;
        this.N = 0.0f;
        this.P = 0.0f;
    }

    private boolean i(MotionEvent motionEvent) {
        if (!TextUtils.equals(com.tencent.biz.qqcircle.utils.l.b("exp_immersiveviewing_renew"), "exp_immersiveviewing_renew_B")) {
            return false;
        }
        float rawX = motionEvent.getRawX() - this.E;
        float rawY = motionEvent.getRawY() - this.F;
        if ((-rawY) <= 100.0f || Math.abs(rawY) <= Math.abs(rawX)) {
            return false;
        }
        return true;
    }

    private boolean j(MotionEvent motionEvent) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_check_mock_event_by_tool_type", true) && motionEvent.getToolType(0) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(MotionEvent motionEvent) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_check_mock_click_loop", true)) {
            return false;
        }
        if (this.U == 0) {
            this.V = motionEvent.getDownTime();
        } else if (motionEvent.getDownTime() - this.V > 500) {
            this.U = 0;
            this.V = motionEvent.getDownTime();
        }
        int i3 = this.U + 1;
        this.U = i3;
        if (i3 > 4) {
            return true;
        }
        return false;
    }

    private boolean l(MotionEvent motionEvent) {
        if (motionEvent != this.S && motionEvent != this.R && motionEvent.getSource() != 0 && motionEvent.getSource() != 2 && !j(motionEvent)) {
            return false;
        }
        return true;
    }

    private void m(a aVar, MotionEvent motionEvent) {
        if (this.f93254h) {
            return;
        }
        if (!aVar.Q(motionEvent, motionEvent.getRawX() - this.E, motionEvent.getRawY() - this.F)) {
            if (ce.c(getContext())) {
                this.f93255i = true;
                QFSFeedItemScaleGestureEvent feed = new QFSFeedItemScaleGestureEvent(1.0f, 3).setFeed(this.f93256m);
                feed.mHashCode = n();
                SimpleEventBus.getInstance().dispatchEvent(feed);
                return;
            }
            if (!this.f93255i) {
                if (this.f93254h) {
                    D();
                } else {
                    C();
                }
                B(false);
            }
        }
    }

    private int n() {
        if (getContext() == null) {
            return 0;
        }
        return getContext().hashCode();
    }

    private String o() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f93256m;
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    private void p() {
        Rect rect = this.L;
        if (rect.top == 0) {
            getGlobalVisibleRect(rect);
        }
    }

    private void q() {
        this.G = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ab
            @Override // java.lang.Runnable
            public final void run() {
                QFSGestureDetectorView.this.v();
            }
        };
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.biz.qqcircle.widgets.ac
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                QFSGestureDetectorView.this.w(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    private boolean r(MotionEvent motionEvent, View view) {
        if (ce.c(getContext()) || motionEvent == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (view == null) {
            QLog.e("QFSGestureDetectorView", 1, "has not set bottom recommend recyclerview. ");
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        view.getRootView().getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    private boolean s(@NonNull MotionEvent motionEvent) {
        Iterator<View> it = this.W.iterator();
        while (it.hasNext()) {
            if (r(motionEvent, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean t() {
        boolean z16;
        boolean z17;
        float f16;
        if (ce.c(getContext()) || cb.b()) {
            return true;
        }
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        int a16 = cx.a(110.0f);
        float f17 = this.E;
        if (f17 >= rect.left && f17 < r4 + a16) {
            float f18 = this.F;
            if (f18 >= rect.top && f18 < rect.bottom) {
                z16 = true;
                if (f17 <= rect.right && f17 > r5 - a16) {
                    f16 = this.F;
                    if (f16 >= rect.top && f16 < rect.bottom) {
                        z17 = true;
                        QLog.d("QFSGestureDetectorView", 4, "isInPlayRateArea :" + z16 + "|" + z17);
                        if (z16 && !z17) {
                            return false;
                        }
                    }
                }
                z17 = false;
                QLog.d("QFSGestureDetectorView", 4, "isInPlayRateArea :" + z16 + "|" + z17);
                return z16 ? true : true;
            }
        }
        z16 = false;
        if (f17 <= rect.right) {
            f16 = this.F;
            if (f16 >= rect.top) {
                z17 = true;
                QLog.d("QFSGestureDetectorView", 4, "isInPlayRateArea :" + z16 + "|" + z17);
                if (z16) {
                }
            }
        }
        z17 = false;
        QLog.d("QFSGestureDetectorView", 4, "isInPlayRateArea :" + z16 + "|" + z17);
        if (z16) {
        }
    }

    private boolean u(float f16, float f17) {
        if (Math.abs(f16 - this.E) <= this.G && Math.abs(f17 - this.F) <= this.G) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.f93251d = true;
        if (t()) {
            this.T = 1;
            QFSRatePlayGestureDetectorView.a aVar = this.K;
            if (aVar != null) {
                aVar.w(this);
            }
        } else {
            this.T = 2;
            SimpleEventBus.getInstance().dispatchEvent(new QFSLongPressOpenShareEvent(n(), o()));
        }
        QLog.d("QFSGestureDetectorView", 1, "long progress, type: " + this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.L.top = 0;
        QLog.d("QFSGestureDetectorView", 4, "onLayout change");
    }

    private void x(final MotionEvent motionEvent, final MotionEvent motionEvent2) {
        postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QFSGestureDetectorView.1
            @Override // java.lang.Runnable
            public void run() {
                QFSGestureDetectorView.this.I.removeCallbacks(QFSGestureDetectorView.this.J);
                MotionEvent motionEvent3 = motionEvent;
                if (motionEvent3 != null && motionEvent2 != null) {
                    if (!QFSGestureDetectorView.this.k(motionEvent3)) {
                        QFSGestureDetectorView.this.y(motionEvent);
                        QFSGestureDetectorView.this.z(motionEvent2);
                        motionEvent.recycle();
                        motionEvent2.recycle();
                        return;
                    }
                    QLog.d("QFSGestureDetectorView", 1, "[mockClickEvent] checkMockLoop: true. ");
                }
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(MotionEvent motionEvent) {
        if (motionEvent != null) {
            p();
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, SystemClock.uptimeMillis(), 0, motionEvent.getX() + this.L.left, motionEvent.getY() + this.L.top, 0);
            this.R = obtain;
            obtain.setSource(motionEvent.getSource());
            QLog.d("QFSGestureDetectorView", 1, "mockDown:" + uptimeMillis + " | x:" + motionEvent.getX() + " | left:" + this.L.left + " | y:" + motionEvent.getY() + " | top: " + this.L.top);
            getRootView().dispatchTouchEvent(this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(MotionEvent motionEvent) {
        long downTime;
        if (motionEvent != null) {
            try {
                p();
                MotionEvent motionEvent2 = this.R;
                if (motionEvent2 == null) {
                    downTime = SystemClock.uptimeMillis();
                } else {
                    downTime = motionEvent2.getDownTime();
                }
                MotionEvent obtain = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), 1, motionEvent.getX() + this.L.left, motionEvent.getY() + this.L.top, 0);
                this.S = obtain;
                obtain.setSource(motionEvent.getSource());
                QLog.d("QFSGestureDetectorView", 1, "mockup:" + downTime + " | x:" + motionEvent.getX() + " | left:" + this.L.left + " | y:" + motionEvent.getY() + " | top:" + this.L.top);
                getRootView().dispatchTouchEvent(this.S);
            } catch (Exception e16) {
                QLog.d("QFSGestureDetectorView", 1, e16, new Object[0]);
            }
        }
    }

    public void A(View view) {
        if (!this.W.contains(view)) {
            return;
        }
        this.W.remove(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        QFSRatePlayGestureDetectorView.b bVar;
        String str;
        QFSRatePlayGestureDetectorView.a aVar;
        a aVar2 = this.f93250a0;
        if (aVar2 != null) {
            aVar2.b(motionEvent, this.f93254h);
        }
        boolean z16 = true;
        if (l(motionEvent)) {
            if (motionEvent.getActionMasked() == 0 && ce.c(getContext())) {
                ce.e(true, getParent());
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        boolean z17 = false;
        if (s(motionEvent)) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        this.I.removeCallbacks(this.J);
                        if (this.f93251d && (aVar = this.K) != null && this.T == 1) {
                            aVar.q(this);
                            QLog.d("QFSGestureDetectorView", 4, "ACTION_cancel notify up");
                        }
                        C();
                        B(false);
                        QLog.d("QFSGestureDetectorView", 4, "ACTION_cancel");
                    }
                } else {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    boolean z18 = this.f93251d;
                    if (z18 && this.T == 1) {
                        B(true);
                        float f16 = this.Q;
                        if (rawY > f16 && this.N >= 0.0f) {
                            this.N = -1.0f;
                            this.D = rawY;
                            this.C = rawX;
                            QLog.d("QFSGestureDetectorView", 4, "scrollY orient change down");
                        } else if (rawY < f16 && this.N <= 0.0f) {
                            this.N = 1.0f;
                            this.D = rawY;
                            this.C = rawX;
                            QLog.d("QFSGestureDetectorView", 4, "scrollY orient change up");
                        }
                        float f17 = rawX - this.C;
                        float f18 = rawY - this.D;
                        if (Math.abs(f18) >= Math.abs(f17) && Math.abs(f18) > f93249b0 && (bVar = this.M) != null) {
                            float f19 = this.P;
                            float f26 = this.N;
                            if (f19 != f26) {
                                this.P = f26;
                                if (f26 != 1.0f) {
                                    z16 = false;
                                }
                                bVar.D(this, z16);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("notify orient change:");
                                if (this.P == 1.0f) {
                                    str = "up";
                                } else {
                                    str = "down";
                                }
                                sb5.append(str);
                                QLog.d("QFSGestureDetectorView", 4, sb5.toString());
                            }
                        }
                    } else if (z18 && this.T == 2) {
                        B(true);
                    } else if (u(rawX, rawY)) {
                        this.f93252e = true;
                        this.I.removeCallbacks(this.J);
                        a aVar3 = this.f93250a0;
                        if (aVar3 != null) {
                            m(aVar3, motionEvent);
                        } else {
                            if (!this.f93254h && ce.c(getContext())) {
                                this.f93255i = true;
                                QLog.d("QFSGestureDetectorView", 1, "move exit");
                                QFSFeedItemScaleGestureEvent feed = new QFSFeedItemScaleGestureEvent(1.0f, 3).setFeed(this.f93256m);
                                feed.mHashCode = n();
                                SimpleEventBus.getInstance().dispatchEvent(feed);
                            } else if (!this.f93255i) {
                                if (this.f93254h) {
                                    D();
                                } else {
                                    C();
                                }
                                B(false);
                            }
                            if (this.f93255i && i(motionEvent)) {
                                QLog.d("QFSGestureDetectorView", 1, "allow parent intercept. ");
                                ce.e(false, getParent());
                            }
                        }
                    }
                    this.Q = rawY;
                }
            } else {
                this.I.removeCallbacks(this.J);
                if (!this.f93251d && !this.f93254h && !this.f93255i) {
                    a aVar4 = this.f93250a0;
                    if (aVar4 == null || !aVar4.x(this.f93252e)) {
                        z17 = true;
                    }
                    if (z17) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setSource(motionEvent.getSource());
                        x(this.H, obtain);
                    }
                    return true;
                }
                QFSRatePlayGestureDetectorView.a aVar5 = this.K;
                if (aVar5 != null && this.T == 1) {
                    aVar5.q(this);
                }
                QLog.d("QFSGestureDetectorView", 4, "ACTION_UP:longPressUp");
                C();
                B(false);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        QLog.d("QFSGestureDetectorView", 4, "ACTION_down");
        ce.e(true, getParent());
        C();
        this.I.removeCallbacks(this.J);
        this.I.postDelayed(this.J, 400L);
        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
        this.H = obtain2;
        obtain2.setSource(motionEvent.getSource());
        this.E = motionEvent.getRawX();
        this.F = motionEvent.getRawY();
        this.f93252e = false;
        return true;
    }

    public void h(View view) {
        if (this.W.contains(view)) {
            return;
        }
        this.W.add(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (l(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector;
        if (l(motionEvent)) {
            return false;
        }
        try {
            if (motionEvent.getPointerCount() > 1 && (scaleGestureDetector = this.f93253f) != null && this.T == -1) {
                boolean z16 = this.f93254h;
                boolean onTouchEvent = scaleGestureDetector.onTouchEvent(motionEvent);
                this.f93254h = onTouchEvent;
                if (z16 != onTouchEvent) {
                    QLog.d("QFSGestureDetectorView", 1, "onTouchEvent isConsume: " + this.f93254h);
                }
                if (this.f93254h) {
                    this.I.removeCallbacks(this.J);
                    ce.e(true, getParent());
                }
                return true;
            }
        } catch (Exception e16) {
            QLog.e("QFSGestureDetectorView", 1, e16, new Object[0]);
        }
        return true;
    }

    public void setDetector(ScaleGestureDetector scaleGestureDetector) {
        this.f93253f = scaleGestureDetector;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f93256m = feedCloudMeta$StFeed;
    }

    public void setRatePlayLongPressListener(QFSRatePlayGestureDetectorView.a aVar) {
        this.K = aVar;
    }

    public void setTouchEventDirector(a aVar) {
        this.f93250a0 = aVar;
    }

    public void setYOrientationChangeListener(QFSRatePlayGestureDetectorView.b bVar) {
        this.M = bVar;
    }

    public QFSGestureDetectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93252e = false;
        this.I = new Handler(Looper.getMainLooper());
        this.L = new Rect();
        this.N = 0.0f;
        this.P = 0.0f;
        this.T = -1;
        this.W = new ArrayList();
        q();
    }

    public QFSGestureDetectorView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93252e = false;
        this.I = new Handler(Looper.getMainLooper());
        this.L = new Rect();
        this.N = 0.0f;
        this.P = 0.0f;
        this.T = -1;
        this.W = new ArrayList();
        q();
    }
}
