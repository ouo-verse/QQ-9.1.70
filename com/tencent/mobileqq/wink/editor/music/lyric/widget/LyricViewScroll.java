package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricViewScroll extends ScrollView {
    protected int C;
    private c D;
    private Handler E;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f321079d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f321080e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile int f321081f;

    /* renamed from: h, reason: collision with root package name */
    protected Scroller f321082h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f321083i;

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f321084m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        int f321085a;

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    LyricViewScroll.this.f321084m = true;
                    LyricViewScroll.b(LyricViewScroll.this);
                    return;
                }
                return;
            }
            if (this.f321085a == LyricViewScroll.this.getScrollY()) {
                LyricViewScroll.this.f321081f = this.f321085a;
                if (LyricViewScroll.this.D != null) {
                    LyricViewScroll.this.D.b(this.f321085a);
                }
                Log.d("LyricViewScroll", "fling stop");
                LyricViewScroll.this.f321080e = false;
                LyricViewScroll.this.E.sendEmptyMessageDelayed(2, LyricViewScroll.this.C);
                LyricViewScroll.this.f321084m = false;
                LyricViewScroll.b(LyricViewScroll.this);
                return;
            }
            this.f321085a = LyricViewScroll.this.getScrollY();
            if (LyricViewScroll.this.D != null) {
                LyricViewScroll.this.D.a(this.f321085a);
            }
            LyricViewScroll.this.E.sendEmptyMessageDelayed(1, 100L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void a(int i3);

        void b(int i3);
    }

    public LyricViewScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f321079d = true;
        this.f321083i = false;
        this.f321084m = true;
        this.C = 150;
        this.E = new a();
        this.f321082h = new Scroller(context, new AccelerateDecelerateInterpolator());
    }

    static /* bridge */ /* synthetic */ b b(LyricViewScroll lyricViewScroll) {
        lyricViewScroll.getClass();
        return null;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (!this.f321080e && this.f321082h.computeScrollOffset()) {
            smoothScrollTo(this.f321082h.getCurrX(), this.f321082h.getCurrY());
            postInvalidate();
            this.f321082h.isFinished();
        }
    }

    public boolean e(MotionEvent motionEvent) {
        if (!this.f321079d) {
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
                        this.f321081f = getScrollY();
                        c cVar = this.D;
                        if (cVar != null) {
                            cVar.b(this.f321081f);
                        }
                        this.f321080e = false;
                        this.E.sendEmptyMessageDelayed(1, 100L);
                    }
                } else {
                    this.f321080e = true;
                    c cVar2 = this.D;
                    if (cVar2 != null) {
                        cVar2.a(getScrollY());
                    }
                }
            } else {
                Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP, Y:" + motionEvent.getY() + " scrollY:" + getScrollY());
                this.E.sendEmptyMessageDelayed(1, 100L);
            }
        } else {
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
            this.f321080e = true;
            this.E.removeMessages(1);
        }
        try {
            this.f321082h.forceFinished(true);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            Log.e("LyricViewScroll", e16.toString());
            return false;
        }
    }

    public void f(int i3) {
        if (!this.f321080e) {
            this.f321082h.forceFinished(true);
            this.f321081f = i3;
            scrollTo(0, i3);
        }
    }

    public void g(int i3) {
        int i16;
        if (!this.f321080e && this.f321084m && (i16 = i3 - this.f321081f) != 0) {
            Math.abs(i16);
            Scroller scroller = this.f321082h;
            scroller.startScroll(scroller.getFinalX(), this.f321081f, 0, i16, 600);
            this.f321081f = this.f321082h.getFinalY();
            invalidate();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        Log.d("LyricViewScroll", "setOverScrollMode begin -> mIsNeedEdgeGlow:" + this.f321083i);
        if (this.f321083i) {
            Log.d("LyricViewScroll", "setOverScrollMode -> mode:" + i3);
            super.setOverScrollMode(i3);
            return;
        }
        super.setOverScrollMode(2);
    }

    public void setScrollEnable(boolean z16) {
        this.f321079d = z16;
    }

    public void setScrollListener(c cVar) {
        this.D = cVar;
    }
}
