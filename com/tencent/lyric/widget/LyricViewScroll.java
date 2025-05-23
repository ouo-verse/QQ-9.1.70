package com.tencent.lyric.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricViewScroll extends ScrollView {
    static IPatchRedirector $redirector_;
    protected int C;
    private c D;
    private b E;
    private float F;
    private float G;
    private int H;
    private Handler I;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f147256d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f147257e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile int f147258f;

    /* renamed from: h, reason: collision with root package name */
    protected Scroller f147259h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f147260i;

    /* renamed from: m, reason: collision with root package name */
    protected volatile boolean f147261m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f147262a;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricViewScroll.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    LyricViewScroll.this.f147261m = true;
                    if (LyricViewScroll.this.E != null) {
                        LyricViewScroll.this.E.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f147262a == LyricViewScroll.this.getScrollY()) {
                LyricViewScroll.this.f147258f = this.f147262a;
                if (LyricViewScroll.this.D != null) {
                    LyricViewScroll.this.D.b(this.f147262a);
                }
                Log.i("LyricViewScroll", "fling stop");
                LyricViewScroll.this.f147257e = false;
                LyricViewScroll.this.I.sendEmptyMessageDelayed(2, LyricViewScroll.this.C);
                LyricViewScroll.this.f147261m = false;
                if (LyricViewScroll.this.E != null) {
                    LyricViewScroll.this.E.a();
                    return;
                }
                return;
            }
            this.f147262a = LyricViewScroll.this.getScrollY();
            if (LyricViewScroll.this.D != null) {
                LyricViewScroll.this.D.a(this.f147262a);
            }
            LyricViewScroll.this.I.sendEmptyMessageDelayed(1, 100L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
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
        this.f147256d = true;
        this.f147260i = false;
        this.f147261m = true;
        this.C = 150;
        this.I = new a(Looper.getMainLooper());
        this.f147259h = new Scroller(context, new AccelerateDecelerateInterpolator());
        this.H = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.computeScroll();
        if (!this.f147257e && this.f147259h.computeScrollOffset()) {
            smoothScrollTo(this.f147259h.getCurrX(), this.f147259h.getCurrY());
            postInvalidate();
            if (this.f147259h.isFinished() && (bVar = this.E) != null) {
                bVar.b();
            }
        }
    }

    public boolean e(MotionEvent motionEvent) {
        boolean z16;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f147256d) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        Log.v("LyricViewScroll", "default:" + motionEvent.getAction());
                    } else {
                        Log.v("LyricViewScroll", "onTouchEvent -> ACTION_CANCEL");
                        this.f147258f = getScrollY();
                        if (this.f147257e) {
                            c cVar2 = this.D;
                            if (cVar2 != null) {
                                cVar2.b(this.f147258f);
                            }
                            this.f147257e = false;
                        }
                        this.I.removeMessages(1);
                    }
                } else {
                    Math.abs(x16 - this.F);
                    if (((int) Math.abs(y16 - this.G)) > this.H) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.f147257e = true;
                        c cVar3 = this.D;
                        if (cVar3 != null) {
                            cVar3.a(getScrollY());
                        }
                    } else if (this.f147257e && (cVar = this.D) != null) {
                        cVar.a(getScrollY());
                    }
                }
            } else {
                Log.v("LyricViewScroll", "onTouchEvent -> ACTION_UP");
                if (this.f147257e) {
                    this.I.sendEmptyMessageDelayed(1, 100L);
                }
            }
        } else {
            Log.v("LyricViewScroll", "onTouchEvent -> ACTION_DOWN");
            this.F = x16;
            this.G = y16;
            this.I.removeMessages(1);
        }
        try {
            this.f147259h.forceFinished(true);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            Log.e("LyricViewScroll", e16.toString());
            return false;
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (!this.f147257e) {
            this.f147259h.forceFinished(true);
            this.f147258f = i3;
            scrollTo(0, i3);
        }
    }

    public void g(int i3) {
        int i16;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (!this.f147257e && this.f147261m && (i16 = i3 - this.f147258f) != 0) {
            if (Math.abs(i16) > 300 && (bVar = this.E) != null) {
                bVar.a();
            }
            Scroller scroller = this.f147259h;
            scroller.startScroll(scroller.getFinalX(), this.f147258f, 0, i16, 600);
            this.f147258f = this.f147259h.getFinalY();
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

    public void setAutoScrollDelayTime(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.C = i3;
        }
    }

    public void setIsNeedEdgeGlow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f147260i = z16;
        }
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        Log.i("LyricViewScroll", "setOverScrollMode begin -> mIsNeedEdgeGlow:" + this.f147260i);
        if (this.f147260i) {
            Log.i("LyricViewScroll", "setOverScrollMode -> mode:" + i3);
            super.setOverScrollMode(i3);
            return;
        }
        super.setOverScrollMode(2);
    }

    public void setScrollEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.f147256d = z16;
        if (!z16) {
            this.f147258f = getScrollY();
            if (this.f147257e) {
                c cVar = this.D;
                if (cVar != null) {
                    cVar.b(this.f147258f);
                }
                this.f147257e = false;
            }
            this.I.removeMessages(1);
        }
    }

    public void setScrollListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.D = cVar;
        }
    }

    public void setSeekScrollListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            this.E = bVar;
        }
    }
}
