package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LyricViewScroll extends ScrollView {
    static IPatchRedirector $redirector_;
    private a C;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f243244d;

    /* renamed from: e, reason: collision with root package name */
    protected Timer f243245e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile boolean f243246f;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f243247h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile int f243248i;

    /* renamed from: m, reason: collision with root package name */
    protected Scroller f243249m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(int i3);

        void b(int i3);
    }

    public LyricViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243244d = true;
        this.f243246f = false;
        this.f243249m = new Scroller(context, new AccelerateDecelerateInterpolator());
    }

    public boolean c(MotionEvent motionEvent) {
        Timer timer;
        Timer timer2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f243244d) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        Log.v("LyricViewScroll", "default:" + motionEvent.getAction());
                    } else {
                        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
                        this.f243248i = getScrollY();
                        this.C.b(this.f243248i);
                        this.f243247h = false;
                        if (this.f243246f && (timer2 = this.f243245e) != null) {
                            timer2.cancel();
                            this.f243246f = false;
                        }
                    }
                } else {
                    this.f243247h = true;
                    a aVar = this.C;
                    if (aVar != null) {
                        aVar.a(getScrollY());
                    }
                }
            } else {
                Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
                if (!this.f243246f) {
                    this.f243246f = true;
                    BaseTimer baseTimer = new BaseTimer();
                    this.f243245e = baseTimer;
                    baseTimer.scheduleAtFixedRate(new TimerTask() { // from class: com.tencent.mobileqq.lyric.widget.LyricViewScroll.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        int f243250d;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LyricViewScroll.this);
                            }
                        }

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            Log.v("LyricViewScroll", "fling detect running");
                            if (this.f243250d == LyricViewScroll.this.getScrollY()) {
                                LyricViewScroll.this.f243248i = this.f243250d;
                                LyricViewScroll.this.C.b(this.f243250d);
                                Log.d("LyricViewScroll", "fling stop");
                                LyricViewScroll.this.f243245e.cancel();
                                LyricViewScroll.this.f243246f = false;
                                LyricViewScroll.this.f243247h = false;
                                return;
                            }
                            this.f243250d = LyricViewScroll.this.getScrollY();
                            LyricViewScroll.this.C.a(this.f243250d);
                        }
                    }, 100L, 100L);
                }
            }
        } else {
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
            this.f243247h = true;
            if (this.f243246f && (timer = this.f243245e) != null) {
                timer.cancel();
                this.f243246f = false;
            }
        }
        try {
            this.f243249m.forceFinished(true);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            Log.e("LyricViewScroll", e16.toString());
            return false;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.computeScroll();
        if (this.f243249m.computeScrollOffset() && !this.f243247h) {
            smoothScrollTo(this.f243249m.getCurrX(), this.f243249m.getCurrY());
            postInvalidate();
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (!this.f243247h) {
            this.f243249m.forceFinished(true);
            this.f243248i = i3;
            scrollTo(0, i3);
        }
    }

    public void e(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (!this.f243247h && (i16 = i3 - this.f243248i) != 0) {
            Scroller scroller = this.f243249m;
            scroller.startScroll(scroller.getFinalX(), this.f243248i, 0, i16, 500);
            this.f243248i = this.f243249m.getFinalY();
            invalidate();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    public void setScrollEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f243244d = z16;
        }
    }

    public void setScrollListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }
}
