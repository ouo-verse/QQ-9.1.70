package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.az;
import com.tencent.widget.pull2refresh.AbsPullToRefreshView2;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.anim.DefaultAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* loaded from: classes34.dex */
public abstract class AbsPullToRefreshView extends RelativeLayout implements Handler.Callback {
    private int C;
    private int D;
    private int E;
    private PullToRefreshListener F;
    private int G;
    private Drawable H;
    protected IAnimManager I;
    private float J;
    private float K;

    /* renamed from: d, reason: collision with root package name */
    private int f373345d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f373346e;

    /* renamed from: f, reason: collision with root package name */
    protected View f373347f;

    /* renamed from: h, reason: collision with root package name */
    protected View f373348h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f373349i;

    /* renamed from: m, reason: collision with root package name */
    private int f373350m;

    public AbsPullToRefreshView(Context context) {
        super(context);
        this.f373345d = 0;
        this.f373346e = false;
        this.E = 10;
        this.J = -1.0f;
        this.K = -1.0f;
        i();
    }

    private void c() {
        this.f373349i.removeMessages(1);
        this.f373349i.removeMessages(3);
    }

    private int h() {
        return ((RelativeLayout.LayoutParams) this.f373347f.getLayoutParams()).topMargin;
    }

    private void i() {
        j();
        this.f373345d = 0;
        this.f373349i = new Handler(Looper.getMainLooper(), this);
        this.f373347f = g();
        this.f373348h = f();
        this.G = az.a(getContext(), 15.0f);
        this.D = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        setWillNotDraw(false);
    }

    private void m(String str) {
        Log.d(AbsPullToRefreshView2.TAG, str);
    }

    private void n(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void o(int i3) {
        m("moveHeaderBy dy=" + i3);
        if (i3 == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f373347f.getLayoutParams();
        layoutParams.topMargin -= i3;
        this.f373347f.setLayoutParams(layoutParams);
        invalidate();
    }

    private void p(int i3) {
        m("moveHeaderSmoothlyBy dy=" + i3);
        if (Math.abs(i3) > this.G * 2) {
            return;
        }
        o(i3);
    }

    private void q(int i3, int i16, boolean z16) {
        m("moveHeaderTo:" + i3 + ",duration=" + i16 + ",getHeaderCurPos()=" + h());
        if (i3 == h()) {
            return;
        }
        this.f373349i.removeMessages(1);
        this.f373349i.sendMessage(this.f373349i.obtainMessage(1, i3, i16, Boolean.valueOf(z16)));
    }

    private void r(int i3) {
        PullToRefreshListener pullToRefreshListener = this.F;
        if (pullToRefreshListener == null) {
            return;
        }
        if (i3 == 1) {
            if (this.f373346e) {
                return;
            }
            this.f373346e = true;
            pullToRefreshListener.onViewCompleteVisableAndReleased(this.f373347f);
            return;
        }
        if (i3 == 2) {
            if (this.f373346e) {
                pullToRefreshListener.onRefreshCompleted(this.f373347f, true);
                Handler handler = this.f373349i;
                handler.sendMessageDelayed(handler.obtainMessage(0), 0L);
            }
            this.f373346e = false;
            this.f373349i.removeMessages(2);
            return;
        }
        if (i3 == 3) {
            if (this.f373346e) {
                pullToRefreshListener.onRefreshCompleted(this.f373347f, false);
                Handler handler2 = this.f373349i;
                handler2.sendMessageDelayed(handler2.obtainMessage(0), 1000L);
            }
            this.f373346e = false;
            this.f373349i.removeMessages(2);
            return;
        }
        if (i3 == 4) {
            if (this.f373346e) {
                return;
            }
            pullToRefreshListener.onViewCompleteVisable(this.f373347f);
        } else {
            if (i3 != 5) {
                return;
            }
            int abs = 100 - Math.abs((int) (((h() * 1.0f) / (-this.f373350m)) * 100.0f));
            int i16 = abs >= 0 ? abs : 0;
            if (this.f373346e) {
                return;
            }
            this.F.onNotCompleteVisable(this.f373347f, i16);
        }
    }

    private void v(boolean z16) {
        d(z16);
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    protected void b(int i3) {
        if (this.f373345d != i3 || i3 == 5) {
            m("change to state:" + i3);
            this.f373345d = i3;
            if (i3 == 0) {
                q(-this.f373350m, 200, false);
                this.f373349i.removeMessages(2);
            } else if (i3 == 1) {
                q(this.C - this.f373350m, 200, false);
            }
            r(this.f373345d);
        }
    }

    protected abstract void d(boolean z16);

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r0 != 3) goto L66;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IAnimManager iAnimManager;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x16 = this.K - motionEvent.getX();
                    float y16 = this.J - motionEvent.getY();
                    int h16 = h();
                    m("dispatchTouchEvent: move getY=" + motionEvent.getY() + ",isScroll2Top()()=" + l() + ",mHeaderHeight=" + this.f373350m + ",currentHeaderPos=" + h16 + ",dy=" + y16 + ",dx=" + x16);
                    this.K = motionEvent.getX();
                    this.J = motionEvent.getY();
                    if (Math.abs(y16) / Math.abs(x16) < 5.0f) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        if (l() && y16 < 0.0f) {
                            p(((int) y16) / 2);
                            v(true);
                        } else {
                            int i3 = this.f373350m;
                            if (h16 > (-i3)) {
                                if (motionEvent.getPointerCount() > 1) {
                                    v(true);
                                } else if (Math.abs(y16) > 0.0f) {
                                    float f16 = h16 - y16;
                                    int i16 = this.f373350m;
                                    if (f16 < (-i16)) {
                                        y16 = h16 + i16;
                                    }
                                    p((int) y16);
                                    v(true);
                                }
                            } else if (h16 < (-i3)) {
                                if (motionEvent.getPointerCount() > 1) {
                                    v(true);
                                } else if (Math.abs(y16) > 0.0f) {
                                    float f17 = h16 - y16;
                                    int i17 = this.f373350m;
                                    if (f17 > (-i17)) {
                                        y16 = h16 + i17;
                                    }
                                    p((int) y16);
                                    v(true);
                                }
                            } else {
                                v(false);
                            }
                        }
                        int h17 = h();
                        int i18 = this.C;
                        int i19 = this.f373350m;
                        if (h17 > i18 - i19) {
                            b(4);
                        } else if (h17 > (-i19)) {
                            b(5);
                        } else if (h17 < (-i19)) {
                            b(6);
                        }
                        int i26 = this.f373350m;
                        if (h17 > (-i26) && (iAnimManager = this.I) != null) {
                            iAnimManager.onTouchPullDistance(h17 + i26, 0);
                        }
                    }
                }
            }
            m("dispatchTouchEvent: *******up****** mState=" + this.f373345d);
            getParent().requestDisallowInterceptTouchEvent(false);
            this.J = -1.0f;
            this.K = -1.0f;
            int i27 = this.f373345d;
            if (i27 == 4) {
                b(1);
            } else if (i27 == 5) {
                b(0);
            } else if (i27 == 6) {
                b(0);
            } else if (h() != (-this.f373350m)) {
                Handler handler = this.f373349i;
                handler.sendMessage(handler.obtainMessage(3));
            }
        } else {
            m("dispatchTouchEvent: ------down------ getY=" + motionEvent.getY());
            c();
            this.K = motionEvent.getX();
            this.J = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected int e() {
        return az.a(getContext(), 60.0f);
    }

    protected abstract View f();

    protected abstract View g();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            b(0);
        } else if (i3 == 1) {
            int i16 = message.arg1;
            int i17 = message.arg2;
            boolean booleanValue = ((Boolean) message.obj).booleanValue();
            int h16 = i16 - h();
            int i18 = this.E;
            int i19 = (h16 * i18) / i17;
            int i26 = i17 - i18;
            if (i26 > 0 && (i19 != 0 || h() - i16 <= 0)) {
                o(-i19);
                this.f373349i.sendMessageDelayed(this.f373349i.obtainMessage(1, i16, i26, Boolean.valueOf(booleanValue)), this.E);
            } else {
                o(h() - i16);
            }
            IAnimManager iAnimManager = this.I;
            if (iAnimManager != null && !booleanValue && i19 <= 0) {
                iAnimManager.onTouchPullDistance(h() + this.f373350m, 0);
            }
        } else if (i3 == 2) {
            b(3);
        } else if (i3 == 3) {
            q(-this.f373350m, 100, true);
            this.f373349i.removeMessages(2);
        }
        return true;
    }

    protected void j() {
        setAnimType(new DefaultAnimManager(getContext()));
    }

    protected abstract boolean k();

    protected abstract boolean l();

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f373349i.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        int h16 = h() + this.f373350m;
        if (h16 > 0 && (drawable = this.H) != null) {
            drawable.setBounds(0, 0, getWidth(), h16);
            this.H.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public void setAnimType(IAnimManager iAnimManager) {
        IAnimManager iAnimManager2 = this.I;
        if (iAnimManager2 != null && iAnimManager2.isSkinAnimManager()) {
            this.I.onDestroy();
        }
        this.I = iAnimManager;
    }

    public void setPullHeaderBgDrawable(Drawable drawable) {
        this.H = drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        if (l()) {
            this.f373349i.removeMessages(3);
            q((this.C / 2) - this.f373350m, 100, true);
            Handler handler = this.f373349i;
            handler.sendMessageDelayed(handler.obtainMessage(3), 100L);
            return;
        }
        if (k()) {
            this.f373349i.removeMessages(3);
            q((-this.f373350m) - this.C, 100, true);
            Handler handler2 = this.f373349i;
            handler2.sendMessageDelayed(handler2.obtainMessage(3), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(PullToRefreshListener pullToRefreshListener) {
        this.F = pullToRefreshListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (view == null) {
            return;
        }
        n(view);
        this.C = e();
        this.f373350m = view.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f373350m);
        layoutParams.topMargin = -this.f373350m;
        super.addView(view, layoutParams);
    }

    public void s(boolean z16) {
        if (z16) {
            b(2);
        } else {
            b(3);
        }
    }

    public AbsPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f373345d = 0;
        this.f373346e = false;
        this.E = 10;
        this.J = -1.0f;
        this.K = -1.0f;
        i();
    }

    public AbsPullToRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f373345d = 0;
        this.f373346e = false;
        this.E = 10;
        this.J = -1.0f;
        this.K = -1.0f;
        i();
    }
}
