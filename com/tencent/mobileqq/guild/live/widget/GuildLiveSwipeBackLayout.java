package com.tencent.mobileqq.guild.live.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveSwipeBackLayout extends RelativeLayout {
    private boolean C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected boolean I;
    protected Context J;
    protected volatile boolean K;
    private boolean L;
    private boolean M;
    protected boolean N;
    public int P;
    protected GestureDetector Q;
    private c R;
    protected b S;
    protected final d T;

    /* renamed from: d, reason: collision with root package name */
    protected View f227025d;

    /* renamed from: e, reason: collision with root package name */
    protected Scroller f227026e;

    /* renamed from: f, reason: collision with root package name */
    private final List<ViewPager> f227027f;

    /* renamed from: h, reason: collision with root package name */
    protected int f227028h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f227029i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f227030m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    protected class a extends GestureDetector.SimpleOnGestureListener {
        protected a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent != null && motionEvent2 != null) {
                float x16 = motionEvent.getX() - motionEvent2.getX();
                float abs = Math.abs((motionEvent.getY() - motionEvent2.getY()) / x16);
                if (GuildLiveSwipeBackLayout.this.f227029i && f16 >= 200.0f) {
                    if (Math.abs(x16) > 100.0f && abs < 0.5f) {
                        GuildLiveSwipeBackLayout.this.K = true;
                        GuildLiveSwipeBackLayout.this.m();
                    }
                    return super.onFling(motionEvent, motionEvent2, f16, f17);
                }
                return super.onFling(motionEvent, motionEvent2, f16, f17);
            }
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void onPageSwipeClose();

        void onPageSwipeOpen();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        boolean onSwipe(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GuildLiveSwipeBackLayout> f227032a;

        d(GuildLiveSwipeBackLayout guildLiveSwipeBackLayout) {
            this.f227032a = new WeakReference<>(guildLiveSwipeBackLayout);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = this.f227032a.get();
            if (guildLiveSwipeBackLayout != null && message.what == 1) {
                if (!guildLiveSwipeBackLayout.L) {
                    guildLiveSwipeBackLayout.L = true;
                    guildLiveSwipeBackLayout.K = true;
                    b bVar = guildLiveSwipeBackLayout.S;
                    if (bVar != null) {
                        bVar.onPageSwipeClose();
                        return;
                    }
                    return;
                }
                return;
            }
            super.handleMessage(message);
        }
    }

    public GuildLiveSwipeBackLayout(Context context) {
        this(context, null, 0);
    }

    private void d() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.J.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        } catch (Exception e16) {
            QLog.e("GuildLiveSwipeBackLayout", 1, "closeSoftKeyboardIfActive: " + e16.getMessage());
        }
    }

    private void g(List<ViewPager> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewPager) {
                list.add((ViewPager) childAt);
            } else if (childAt instanceof ViewGroup) {
                g(list, (ViewGroup) childAt);
            }
        }
    }

    private void i(MotionEvent motionEvent) {
        if (this.f227029i && this.N) {
            int x16 = (int) motionEvent.getX();
            int i3 = this.H - x16;
            if (x16 - this.F > this.D) {
                if (!this.I && this.R != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildLiveSwipeBackLayout", 2, "waterTest: onSwipe");
                    }
                    boolean onSwipe = this.R.onSwipe(true);
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildLiveSwipeBackLayout", 2, "waterTest: onSwipe result[" + onSwipe + "");
                    }
                    if (!onSwipe) {
                        this.f227029i = false;
                        return;
                    }
                }
                this.I = true;
            }
            if (!this.f227030m) {
                return;
            }
            this.H = x16;
            if (x16 - this.F > 0 && this.I) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildLiveSwipeBackLayout", 2, "moveX:" + x16 + "downX:" + this.F + "deltaX:" + i3);
                }
                if (this.f227025d.getScrollX() + i3 > 0) {
                    i3 = -this.f227025d.getScrollX();
                }
                this.f227025d.scrollBy(i3, 0);
                d();
            }
        }
    }

    private void j(MotionEvent motionEvent) {
        if (this.f227029i && this.N && this.f227030m) {
            this.I = false;
            if (QLog.isColorLevel()) {
                QLog.i("GuildLiveSwipeBackLayout", 2, "event.getX():" + motionEvent.getX() + "mViewWidth:" + this.f227028h);
            }
            if (motionEvent.getX() - this.F >= this.f227028h / 2.0d) {
                this.C = true;
                if (this.f227025d.getScrollX() != 0) {
                    m();
                }
                c cVar = this.R;
                if (cVar != null) {
                    cVar.onSwipe(false);
                    return;
                }
                return;
            }
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildLiveSwipeBackLayout", 2, "isFling:" + GuildLiveSwipeBackLayout.this.K);
                    }
                    if (!GuildLiveSwipeBackLayout.this.K) {
                        GuildLiveSwipeBackLayout.this.k();
                    }
                    if (GuildLiveSwipeBackLayout.this.R != null) {
                        GuildLiveSwipeBackLayout.this.R.onSwipe(false);
                    }
                }
            }, 50L);
            this.C = false;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f227026e.computeScrollOffset()) {
            this.f227025d.scrollTo(this.f227026e.getCurrX(), this.f227026e.getCurrY());
            postInvalidate();
            if (this.f227026e.isFinished() && this.C) {
                m();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && ((int) motionEvent.getX()) < 50) {
            return false;
        }
        if ((this.f227025d.getContext() instanceof Activity) && (((Activity) this.f227025d.getContext()).isDestroyed() || ((Activity) this.f227025d.getContext()).isFinishing())) {
            QLog.i("GuildLiveSwipeBackLayout", 1, "dispatchTouchEvent activity is finishing");
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        this.N = false;
    }

    public void f() {
        this.N = true;
    }

    protected ViewPager h(List<ViewPager> list, MotionEvent motionEvent) {
        if (list != null && list.size() != 0) {
            Rect rect = new Rect();
            for (ViewPager viewPager : list) {
                viewPager.getHitRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return viewPager;
                }
            }
        }
        return null;
    }

    protected void k() {
        l(this.f227025d.getScrollX());
    }

    public void l(int i3) {
        try {
            this.f227026e.startScroll(this.f227025d.getScrollX(), 0, -this.f227025d.getScrollX(), 0, Math.abs(i3));
            postInvalidate();
            b bVar = this.S;
            if (bVar != null) {
                bVar.onPageSwipeOpen();
            }
            this.M = false;
            this.L = false;
            this.K = false;
            this.C = false;
        } catch (Exception unused) {
        }
    }

    protected void m() {
        if (this.M) {
            return;
        }
        this.M = true;
        int scrollX = this.f227028h + this.f227025d.getScrollX();
        try {
            this.f227026e.startScroll(this.f227025d.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs((int) (((scrollX * 1.0d) / this.f227028h) * 700.0d)));
        } catch (Exception unused) {
        }
        this.T.sendEmptyMessageDelayed(1, 200L);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        ViewPager h16 = h(this.f227027f, motionEvent);
        if (h16 != null && h16.getCurrentItem() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && this.f227029i && this.N && ((int) motionEvent.getX()) - this.F > this.D && Math.abs(((int) motionEvent.getY()) - this.G) < this.E) {
                return true;
            }
        } else {
            this.f227029i = false;
            int x16 = (int) motionEvent.getX();
            this.H = x16;
            this.F = x16;
            this.G = (int) motionEvent.getY();
            if (this.F < this.P) {
                this.f227029i = true;
            }
        }
        if (this.N && (gestureDetector = this.Q) != null) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            this.f227028h = getWidth();
            g(this.f227027f, this);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        w.b("GuildLiveSwipeBackLayout", "onMeasure");
        super.onMeasure(i3, i16);
        w.a("GuildLiveSwipeBackLayout", "onMeasure");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f227028h = i3;
        this.P = i3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    i(motionEvent);
                }
            } else {
                j(motionEvent);
            }
            if (this.N && (gestureDetector = this.Q) != null) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnPageSwipeListener(b bVar) {
        this.S = bVar;
    }

    public void setOnSwipeListener(c cVar) {
        this.R = cVar;
    }

    public void setReadyToSlide(boolean z16) {
        this.f227030m = z16;
    }

    public GuildLiveSwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLiveSwipeBackLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f227027f = new LinkedList();
        this.f227029i = false;
        this.f227030m = true;
        this.L = false;
        this.M = false;
        this.N = true;
        this.T = new d(this);
        this.f227025d = this;
        this.J = context;
        this.D = ViewConfiguration.get(context).getScaledTouchSlop() * 4;
        this.E = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f227026e = new Scroller(context);
        this.Q = new GestureDetector(context, new a());
    }
}
