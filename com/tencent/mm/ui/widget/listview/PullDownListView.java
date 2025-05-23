package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.q;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class PullDownListView extends ListView implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static final long DURATION = 300;
    public float C;
    public View D;
    public Rect E;
    public int F;
    public int G;
    public IPullDownCallback H;
    public int I;
    public int J;
    public boolean K;
    public float L;
    public float M;
    public final int N;
    public final int O;
    public final int P;
    public View Q;
    public View R;
    public float S;
    public float T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a, reason: collision with root package name */
    public boolean f153369a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f153370a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f153371b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f153372b0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f153373c;

    /* renamed from: c0, reason: collision with root package name */
    public float f153374c0;

    /* renamed from: d, reason: collision with root package name */
    public float f153375d;

    /* renamed from: d0, reason: collision with root package name */
    public float f153376d0;

    /* renamed from: e, reason: collision with root package name */
    public float f153377e;

    /* renamed from: e0, reason: collision with root package name */
    public int f153378e0;

    /* renamed from: f, reason: collision with root package name */
    public int f153379f;

    /* renamed from: f0, reason: collision with root package name */
    public int f153380f0;

    /* renamed from: g, reason: collision with root package name */
    public int f153381g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f153382g0;

    /* renamed from: h, reason: collision with root package name */
    public int f153383h;

    /* renamed from: h0, reason: collision with root package name */
    public float f153384h0;

    /* renamed from: i, reason: collision with root package name */
    public float f153385i;

    /* renamed from: i0, reason: collision with root package name */
    public int f153386i0;

    /* renamed from: j, reason: collision with root package name */
    public float f153387j;

    /* renamed from: j0, reason: collision with root package name */
    public int f153388j0;

    /* renamed from: k, reason: collision with root package name */
    public Vibrator f153389k;

    /* renamed from: k0, reason: collision with root package name */
    public int f153390k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f153391l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f153392l0;

    /* renamed from: m, reason: collision with root package name */
    public View f153393m;

    /* renamed from: m0, reason: collision with root package name */
    public long f153394m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f153395n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f153396o0;

    /* renamed from: p0, reason: collision with root package name */
    public OnTranslationChangeListener f153397p0;

    /* renamed from: q0, reason: collision with root package name */
    public AdapterView.OnItemClickListener f153398q0;

    /* renamed from: r0, reason: collision with root package name */
    public AdapterView.OnItemLongClickListener f153399r0;

    /* renamed from: s0, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f153400s0;

    /* loaded from: classes9.dex */
    public interface IPullDownCallback {
        void init();

        void onCoordinationViewClosing(int i3);

        void onCoordinationViewOpening(int i3);

        void onListInnerScroll(int i3);

        void onMuteIn();

        void onMuteOut();

        void onPostClose();

        void onPostOpen(boolean z16);

        void onPreClose();

        void onPreOpen();
    }

    /* loaded from: classes9.dex */
    public interface OnTranslationChangeListener {
        void onTranslationYChange(float f16);
    }

    /* loaded from: classes9.dex */
    public static class WorkspaceOvershootInterpolator implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public float f153410a = 1.3f;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            float f18 = this.f153410a;
            float f19 = (f17 * f17 * (((f18 + 1.0f) * f17) + f18)) + 1.0f;
            if (f19 > 1.0f) {
                return 1.0f;
            }
            return f19;
        }
    }

    public PullDownListView(Context context) {
        this(context, null);
        a(context);
    }

    public void addOverScrollCallback(IPullDownCallback iPullDownCallback) {
        this.H = iPullDownCallback;
    }

    public final int d(int i3) {
        return (int) (i3 * 3.0f);
    }

    public void disableHover() {
        this.f153371b = false;
        this.f153373c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final int e(int i3) {
        return (int) (i3 / 2.0f);
    }

    public void enableHover(int i3, int i16) {
        this.f153371b = true;
        this.I = i3;
        this.f153373c = false;
        this.J = i16;
    }

    public boolean isSupportOverscroll() {
        return this.f153369a;
    }

    public boolean isVisible() {
        return this.V;
    }

    public final void j() {
        View view = this.D;
        if (view != null) {
            float translationX = view.getTranslationX();
            float translationY = this.D.getTranslationY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, "translationX", translationX, this.f153385i);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "translationY", translationY, this.f153387j);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mm.ui.widget.listview.PullDownListView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (PullDownListView.this.D != null) {
                        PullDownListView.this.D.setVisibility(8);
                    }
                    n.c("MicroMsg.PullDownListView", "onAnimationCancel ", new Object[0]);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullDownListView.this.D != null) {
                        PullDownListView.this.D.setVisibility(8);
                    }
                }
            });
            animatorSet.start();
        }
    }

    @Override // android.widget.ListView, android.view.View
    @TargetApi(11)
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f153393m = this;
        this.f153374c0 = getTranslationY();
        n.a("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", Integer.valueOf(this.f153393m.getLeft()), Integer.valueOf(this.f153393m.getTop()), Integer.valueOf(this.f153393m.getRight()), Integer.valueOf(this.f153393m.getBottom()));
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.V && this.f153371b && motionEvent.getRawY() > this.J) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        n.c("MicroMsg.PullDownListView", "onItemClick isMove:%s isVisible:%s mIsNeedHover:%s position:%s mItemSelectedListener:%s", Boolean.valueOf(this.U), Boolean.valueOf(this.V), Boolean.valueOf(this.f153371b), Integer.valueOf(i3), this.f153400s0);
        AdapterView.OnItemClickListener onItemClickListener = this.f153398q0;
        if (onItemClickListener != null && !this.U && this.V && !this.W) {
            this.K = true;
            onItemClickListener.onItemClick(adapterView, view, i3, j3);
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.f153399r0;
        if (onItemLongClickListener != null) {
            if (this.V || this.f153371b) {
                this.K = true;
                return onItemLongClickListener.onItemLongClick(adapterView, view, i3, j3);
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f153400s0;
        if (onItemSelectedListener != null && !this.U && this.V && !this.W) {
            this.K = true;
            onItemSelectedListener.onItemSelected(adapterView, view, i3, j3);
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f153400s0;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
    }

    public void onPause() {
        n.c("MicroMsg.PullDownListView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Object[0]);
        this.f153391l = false;
    }

    public void onResume() {
        n.c("MicroMsg.PullDownListView", "onResume", new Object[0]);
        this.f153391l = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x04c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x04c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.widget.AbsListView, android.view.View
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        n.a("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", Boolean.valueOf(this.f153369a), Integer.valueOf(getScrollY()));
        if (motionEvent.getActionMasked() != 2) {
            n.c("MicroMsg.PullDownListView", "onTouchEvent, supportOverscroll:%s, scrollY:%s action:%s", Boolean.valueOf(this.f153369a), Integer.valueOf(getScrollY()), MotionEvent.actionToString(motionEvent.getActionMasked()));
        }
        if (this.f153369a && this.f153393m != null && !this.W) {
            int actionMasked = motionEvent.getActionMasked();
            n.a("MicroMsg.PullDownListView", "onTouchEvent %s", Integer.valueOf(actionMasked));
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    this.U = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.f153386i0);
                    if (findPointerIndex == -1) {
                        n.e("MicroMsg.PullDownListView", "eventIndex == -1 ,mActivePointerId:%s", Integer.valueOf(this.f153386i0));
                    } else {
                        this.S = motionEvent.getY(findPointerIndex);
                        this.T = motionEvent.getX(findPointerIndex);
                        j();
                        this.C = 0.0f;
                        this.f153384h0 = 0.0f;
                        this.f153370a0 = false;
                        this.f153395n0 = System.currentTimeMillis() - this.f153394m0;
                        n.a("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", Integer.valueOf(this.F), Integer.valueOf(a()), Integer.valueOf(this.f153393m.getBottom()), Long.valueOf(this.f153395n0));
                        if (g() && this.H != null && !this.W && this.f153391l && !this.f153392l0) {
                            n.a("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s, mIsNeedHover=%s", Integer.valueOf(this.f153388j0), Float.valueOf(this.f153376d0), Boolean.valueOf(this.f153371b));
                            if (e()) {
                                if ((!this.V || this.F < h()) && (this.V || this.F < a())) {
                                    i3 = 0;
                                } else {
                                    i3 = this.f153393m.getBottom() + this.G;
                                    if (this.f153371b) {
                                        i3 = this.I;
                                        this.f153396o0 = i3;
                                    }
                                }
                                a(this.F, i3, a(motionEvent));
                            } else if (f()) {
                                int i16 = this.F;
                                a(this.F, (i16 >= 0 && i16 >= a()) ? this.f153393m.getBottom() : 0, false);
                            }
                        }
                        this.K = false;
                        this.f153382g0 = false;
                        this.f153388j0 = 0;
                        this.f153386i0 = -1;
                        this.f153392l0 = false;
                        this.f153395n0 = 0L;
                        this.f153394m0 = 0L;
                    }
                } else if (actionMasked == 2) {
                    this.U = true;
                    if (!this.f153382g0) {
                        if (!this.V) {
                            this.f153386i0 = motionEvent.getPointerId(0);
                            this.C = motionEvent.getY(0);
                            this.L = motionEvent.getY(0);
                            if (this.f153371b) {
                                this.f153376d0 = this.I;
                            } else {
                                this.f153376d0 = this.f153383h - this.f153380f0;
                            }
                            this.f153388j0 = (int) this.f153376d0;
                            this.f153382g0 = true;
                        } else {
                            this.f153386i0 = motionEvent.getPointerId(0);
                            c();
                            this.K = false;
                            float y16 = motionEvent.getY(0);
                            this.C = y16;
                            this.S = y16;
                            this.T = motionEvent.getX(0);
                            this.E.setEmpty();
                            this.L = motionEvent.getY(0);
                            this.M = motionEvent.getX(0);
                            this.f153376d0 = 0.0f;
                            this.f153388j0 = (int) 0.0f;
                            this.f153382g0 = true;
                            i();
                        }
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.f153386i0);
                    if (findPointerIndex2 != -1) {
                        this.S = motionEvent.getY(findPointerIndex2);
                        this.T = motionEvent.getX(findPointerIndex2);
                        if (this.S - this.L >= 0.0f) {
                            this.f153390k0 = 2;
                        } else {
                            this.f153390k0 = 1;
                        }
                        if (d()) {
                            this.f153392l0 = true;
                        }
                        if (!this.f153392l0) {
                            n.a("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", Float.valueOf(motionEvent.getRawY()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getY(findPointerIndex2)), Float.valueOf(motionEvent.getX(findPointerIndex2)));
                            n.a("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", Integer.valueOf((int) (this.C - this.S)), Boolean.valueOf(this.W), Integer.valueOf(this.F), Boolean.valueOf(this.K), Float.valueOf(this.f153376d0));
                            if (!this.K && !this.W) {
                                if (this.E.isEmpty()) {
                                    this.f153374c0 = getTranslationY();
                                    this.E.set(this.f153393m.getLeft(), this.f153393m.getTop(), this.f153393m.getRight(), this.f153393m.getBottom());
                                    n.a("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", Integer.valueOf(this.f153393m.getLeft()), Integer.valueOf(this.f153393m.getTop()), Integer.valueOf(this.f153393m.getRight()), Integer.valueOf(this.f153393m.getBottom()));
                                }
                                n.a("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", Integer.valueOf(findPointerIndex2), Float.valueOf(motionEvent.getY(findPointerIndex2)), Float.valueOf(this.L), Float.valueOf(motionEvent.getY(findPointerIndex2) - this.L));
                                int e16 = this.f153388j0 + e((int) (this.S - this.C));
                                this.f153388j0 = e16;
                                this.F = Math.max(0, e16);
                                n.a("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", Integer.valueOf(this.f153393m.getTop()), Integer.valueOf(this.f153393m.getBottom()), Integer.valueOf(this.F), Integer.valueOf(this.f153388j0));
                                if (Math.abs(this.f153388j0) > 50) {
                                    if (!this.f153370a0 && this.F >= h() && this.F <= a()) {
                                        if (this.f153373c) {
                                            this.f153389k.vibrate(10L);
                                        }
                                        this.f153370a0 = true;
                                        this.f153384h0 = this.f153388j0;
                                    }
                                    n.a("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", Integer.valueOf(this.E.top + this.F), Boolean.valueOf(this.K), Boolean.valueOf(this.V));
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                this.f153393m.setTranslationY(this.F);
                                b();
                                b(motionEvent);
                                n.a("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", Integer.valueOf(this.f153393m.getLeft()), Integer.valueOf(this.f153393m.getTop()), Integer.valueOf(this.f153393m.getRight()), Integer.valueOf(this.f153393m.getBottom()));
                                this.C = this.S;
                                n.a("MicroMsg.PullDownListView", "consumed: %b", Boolean.valueOf(z16));
                                if (z16) {
                                    motionEvent.setAction(3);
                                }
                                if (!this.V && this.f153371b) {
                                    z16 = true;
                                }
                                if (z16) {
                                    return true;
                                }
                                try {
                                    boolean onTouchEvent = super.onTouchEvent(motionEvent);
                                    n.a("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", Boolean.valueOf(onTouchEvent));
                                    if (this.H != null && getChildCount() > 0) {
                                        int top = getChildAt(0).getTop();
                                        n.a("MicroMsg.PullDownListView", "scrolled %s", Integer.valueOf(top));
                                        this.H.onListInnerScroll(top);
                                    }
                                    return onTouchEvent;
                                } catch (Exception e17) {
                                    n.a("MicroMsg.PullDownListView", e17, "%b, %d", Boolean.valueOf(z16), Integer.valueOf(actionMasked));
                                    return true;
                                }
                            }
                        }
                        z16 = false;
                        this.C = this.S;
                        n.a("MicroMsg.PullDownListView", "consumed: %b", Boolean.valueOf(z16));
                        if (z16) {
                        }
                        if (!this.V) {
                            z16 = true;
                        }
                        if (z16) {
                        }
                    }
                } else if (actionMasked == 3) {
                    j();
                    this.f153382g0 = false;
                    this.K = false;
                    this.C = 0.0f;
                    this.f153384h0 = 0.0f;
                    this.f153370a0 = false;
                    if (this.H != null) {
                        resetLayout();
                    }
                    this.f153388j0 = 0;
                    this.f153386i0 = -1;
                    this.f153392l0 = false;
                    this.f153395n0 = 0L;
                    this.f153394m0 = 0L;
                } else if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex != -1) {
                        this.C = (int) motionEvent.getY(actionIndex);
                        this.f153386i0 = motionEvent.getPointerId(actionIndex);
                    }
                } else if (actionMasked == 6) {
                    c(motionEvent);
                    if (motionEvent.getActionIndex() != -1) {
                        this.C = (int) motionEvent.getY(r8);
                    }
                }
            } else if (!this.f153382g0) {
                this.f153386i0 = motionEvent.getPointerId(0);
                c();
                this.K = false;
                float y17 = motionEvent.getY(0);
                this.C = y17;
                this.S = y17;
                this.T = motionEvent.getX(0);
                this.E.setEmpty();
                this.L = motionEvent.getY(0);
                this.M = motionEvent.getX(0);
                this.f153376d0 = 0.0f;
                if (this.f153371b && !this.V) {
                    this.f153376d0 = getTranslationY();
                }
                this.f153388j0 = (int) this.f153376d0;
                this.f153382g0 = true;
                this.f153392l0 = false;
                this.f153394m0 = System.currentTimeMillis();
                this.f153395n0 = 0L;
                i();
            }
            z16 = false;
            n.a("MicroMsg.PullDownListView", "consumed: %b", Boolean.valueOf(z16));
            if (z16) {
            }
            if (!this.V) {
            }
            if (z16) {
            }
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    @TargetApi(11)
    public void resetLayout() {
        this.F = 0;
        n.a("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", Integer.valueOf(this.f153393m.getLeft()), Integer.valueOf(this.f153393m.getTop()), Integer.valueOf(this.f153393m.getRight()), Integer.valueOf(this.f153393m.getBottom()));
    }

    public void setCoordinationView(View view, int i3) {
        setCoordinationView(view, i3, this.f153383h / 3);
    }

    public void setMuteView(final View view) {
        if (view != null) {
            post(new Runnable() { // from class: com.tencent.mm.ui.widget.listview.PullDownListView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PullDownListView.this.D != null) {
                        PullDownListView.this.f153385i = -r0.D.getWidth();
                        PullDownListView.this.f153387j = r0.D.getHeight();
                        PullDownListView.this.D.setVisibility(8);
                    }
                    view.bringToFront();
                }
            });
        } else {
            this.f153385i = 0.0f;
            this.f153387j = 0.0f;
        }
        this.D = view;
    }

    public void setNavigationBarHeight(int i3) {
        n.c("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", Integer.valueOf(i3));
        this.G = i3;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f153398q0 = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.f153399r0 = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f153400s0 = onItemSelectedListener;
    }

    public void setSupportOverscroll(boolean z16) {
        this.f153369a = z16;
    }

    public void setTabView(View view) {
        this.Q = view;
    }

    public void setTranslationListener(OnTranslationChangeListener onTranslationChangeListener) {
        this.f153397p0 = onTranslationChangeListener;
    }

    @Override // android.view.View
    public void setTranslationY(float f16) {
        super.setTranslationY(f16);
        OnTranslationChangeListener onTranslationChangeListener = this.f153397p0;
        if (onTranslationChangeListener != null) {
            onTranslationChangeListener.onTranslationYChange(f16);
        }
    }

    public void switchNormalStatus() {
        n.c("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
        if (!this.V) {
            if (this.f153371b) {
                a((int) (this.I * (1.0f - this.f153377e)), 0, false);
            } else {
                a(a() - 1, 0, false);
            }
        }
    }

    public void switchNormalStatusImmediately() {
        n.c("MicroMsg.PullDownListView", "switchNormalStatusImme", new Object[0]);
        if (!this.V) {
            if (this.f153371b) {
                b((int) (this.I * (1.0f - this.f153377e)), 0, false);
            } else {
                b(a() - 1, 0, false);
            }
        }
    }

    public void switchPullDownStatus() {
        setSelectionFromTop(0, 0);
        n.c("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
        if (this.V) {
            if (this.f153371b) {
                a(h() + 1, this.I, false);
            } else {
                a(h() + 1, this.f153393m.getBottom() + this.G, false);
            }
        }
    }

    public final boolean f() {
        return ((float) this.f153388j0) - this.f153376d0 < 0.0f;
    }

    public final boolean g() {
        return !this.E.isEmpty() && Math.abs(this.F) > 0;
    }

    public final int h() {
        if (this.f153379f == 0) {
            this.f153379f = (int) (this.f153383h * this.f153375d);
        }
        return this.f153379f;
    }

    public final void i() {
        View view = this.D;
        if (view != null) {
            view.setTranslationX(this.f153385i);
            this.D.setTranslationY(this.f153387j);
            this.D.setVisibility(8);
        }
    }

    public void setCoordinationView(View view, int i3, int i16) {
        this.R = view;
        this.f153380f0 = i3;
        this.f153378e0 = i16;
        this.f153381g = 0;
        this.f153379f = 0;
    }

    public PullDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153369a = false;
        this.f153371b = false;
        this.f153373c = true;
        this.f153375d = 0.05f;
        this.f153377e = 0.05f;
        this.f153379f = 0;
        this.f153381g = 0;
        this.f153383h = 0;
        this.f153385i = 0.0f;
        this.f153387j = 0.0f;
        this.f153391l = true;
        this.E = new Rect();
        this.F = 0;
        this.G = 0;
        this.K = false;
        this.N = 1;
        this.O = 2;
        this.P = 200;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = false;
        this.V = true;
        this.W = false;
        this.f153370a0 = false;
        this.f153372b0 = false;
        this.f153376d0 = 0.0f;
        this.f153378e0 = 0;
        this.f153380f0 = 0;
        this.f153382g0 = false;
        this.f153384h0 = 0.0f;
        this.f153386i0 = -1;
        this.f153388j0 = 0;
        this.f153390k0 = 0;
        this.f153392l0 = false;
        this.f153394m0 = 0L;
        this.f153395n0 = 0L;
        this.f153397p0 = null;
        a(context);
    }

    public final void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f153386i0) {
            int i3 = actionIndex == 0 ? 1 : 0;
            this.C = (int) motionEvent.getY(i3);
            this.f153386i0 = motionEvent.getPointerId(i3);
        }
    }

    public final int a() {
        if (this.f153381g == 0) {
            this.f153381g = (int) ((this.f153383h - this.f153380f0) * (1.0f - this.f153377e));
        }
        return this.f153381g;
    }

    public final void b(int i3, int i16, boolean z16) {
        n.c("MicroMsg.PullDownListView", "story_cat startAnimationImmediately: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", Integer.valueOf(this.E.left), Integer.valueOf(this.E.top), Integer.valueOf(this.E.right), Integer.valueOf(this.E.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(h()), Integer.valueOf(a()), Boolean.valueOf(z16));
        float f16 = i16;
        setTranslationY(f16);
        if (this.Q != null && i3 > h() && i3 < a()) {
            if (i16 != 0) {
                this.Q.setTranslationY(f16);
            } else {
                this.Q.setTranslationY(i16 - this.G);
            }
        }
        n.c("MicroMsg.PullDownListView", "onImmeStart start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i3), Integer.valueOf(h()), Integer.valueOf(a()));
        this.W = true;
        if (i16 == 0) {
            this.V = true;
        } else {
            this.V = false;
        }
        if (this.H != null && i3 > h() && i3 < a()) {
            if (this.V) {
                this.H.onPreClose();
            } else {
                this.H.onPreOpen();
            }
        }
        n.c("MicroMsg.PullDownListView", "onImmeEnd start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i3), Integer.valueOf(h()), Integer.valueOf(a()));
        this.U = false;
        this.W = false;
        this.f153370a0 = false;
        this.f153372b0 = false;
        if (this.H != null && i3 > h() && i3 < a()) {
            if (this.V) {
                this.H.onPostClose();
            } else {
                this.H.onPostOpen(z16);
            }
        }
        resetLayout();
    }

    public final boolean d() {
        int childCount = getChildCount();
        if (childCount <= 0 || !this.V) {
            return false;
        }
        int i3 = this.f153390k0;
        if (i3 == 2) {
            if (getChildAt(0).getTop() >= getPaddingTop() + 0) {
                return false;
            }
        } else if (i3 != 1 || getChildAt(childCount - 1).getBottom() < getHeight() - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        return ((float) this.f153388j0) - this.f153376d0 > 0.0f;
    }

    public final void a(Context context) {
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        if (q.b(context) != null) {
            this.f153383h = q.b(context).y;
        }
        this.f153389k = (Vibrator) getContext().getSystemService("vibrator");
        post(new Runnable() { // from class: com.tencent.mm.ui.widget.listview.PullDownListView.2
            @Override // java.lang.Runnable
            public void run() {
                n.a("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", Integer.valueOf(PullDownListView.this.f153393m.getLeft()), Integer.valueOf(PullDownListView.this.f153393m.getTop()), Integer.valueOf(PullDownListView.this.f153393m.getRight()), Integer.valueOf(PullDownListView.this.f153393m.getBottom()));
                PullDownListView.this.E.set(PullDownListView.this.f153393m.getLeft(), PullDownListView.this.f153393m.getTop(), PullDownListView.this.f153393m.getRight(), PullDownListView.this.f153393m.getBottom());
            }
        });
    }

    public final int c(int i3) {
        float f16 = i3;
        int abs = (int) Math.abs((f16 / this.f153383h) * this.f153378e0);
        n.a("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", Integer.valueOf(i3), Float.valueOf(f16 / this.f153383h), Integer.valueOf(Math.abs(this.f153378e0)), Integer.valueOf(abs));
        return abs;
    }

    public final void c() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void a(final int i3, final int i16, final boolean z16) {
        n.c("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", Integer.valueOf(this.E.left), Integer.valueOf(this.E.top), Integer.valueOf(this.E.right), Integer.valueOf(this.E.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(h()), Integer.valueOf(a()), Boolean.valueOf(z16));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float f16 = i3;
        float f17 = i16;
        arrayList.add(ObjectAnimator.ofFloat(this, "translationY", f16, f17));
        if (this.Q != null && i3 > h() && i3 < a()) {
            if (i16 != 0) {
                arrayList.add(ObjectAnimator.ofFloat(this.Q, "translationY", f16, f17));
            } else {
                arrayList.add(ObjectAnimator.ofFloat(this.Q, "translationY", f16, i16 - this.G));
            }
        }
        if (this.R != null) {
            if (i16 >= getBottom()) {
                arrayList.add(a(((ViewGroup.MarginLayoutParams) this.R.getLayoutParams()).topMargin, 0));
            } else {
                arrayList.add(a(((ViewGroup.MarginLayoutParams) this.R.getLayoutParams()).topMargin, this.f153378e0));
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mm.ui.widget.listview.PullDownListView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                n.c("MicroMsg.PullDownListView", "onAnimationCancel ", new Object[0]);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                n.c("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i3), Integer.valueOf(PullDownListView.this.h()), Integer.valueOf(PullDownListView.this.a()));
                PullDownListView.this.U = false;
                PullDownListView.this.W = false;
                PullDownListView.this.f153370a0 = false;
                PullDownListView.this.f153372b0 = false;
                if (PullDownListView.this.H != null && i3 > PullDownListView.this.h() && i3 < PullDownListView.this.a()) {
                    if (PullDownListView.this.V) {
                        PullDownListView.this.H.onPostClose();
                        View unused = PullDownListView.this.Q;
                    } else {
                        PullDownListView.this.H.onPostOpen(z16);
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                n.c("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i3), Integer.valueOf(PullDownListView.this.h()), Integer.valueOf(PullDownListView.this.a()));
                PullDownListView.this.W = true;
                if (i16 == 0) {
                    PullDownListView.this.V = true;
                } else {
                    PullDownListView.this.V = false;
                }
                if (PullDownListView.this.H != null && i3 > PullDownListView.this.h() && i3 < PullDownListView.this.a()) {
                    if (PullDownListView.this.V) {
                        PullDownListView.this.H.onPreClose();
                    } else {
                        PullDownListView.this.H.onPreOpen();
                    }
                }
            }
        });
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(300L);
        animatorSet.start();
        resetLayout();
    }

    public final void b(MotionEvent motionEvent) {
        float f16 = this.f153384h0;
        if (f16 != 0.0f) {
            int d16 = d((int) (this.f153388j0 - f16));
            if (this.V && d16 > 0 && this.H != null) {
                a(d16);
                if (!this.f153372b0 && a(motionEvent)) {
                    if (this.f153373c) {
                        this.f153389k.vibrate(20L);
                    }
                    this.f153372b0 = true;
                } else if (!a(motionEvent)) {
                    this.f153372b0 = false;
                }
                if (this.f153372b0) {
                    this.H.onMuteIn();
                    return;
                } else {
                    this.H.onMuteOut();
                    return;
                }
            }
            c();
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.D == null) {
            return false;
        }
        if (motionEvent.getActionMasked() == 1 && this.f153395n0 < 200) {
            return false;
        }
        if (this.M < this.D.getRight()) {
            if (rawX <= this.D.getLeft() || rawX >= this.D.getRight() || rawY <= this.D.getTop() - (this.D.getHeight() / 2) || rawY >= this.D.getBottom() + this.G) {
                return false;
            }
        } else if (rawX <= this.D.getLeft() || rawX >= this.D.getRight() || rawY <= this.D.getTop() || rawY >= this.D.getBottom() + this.G) {
            return false;
        }
        return true;
    }

    public final void b(int i3) {
        View view = this.R;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i16 = this.f153378e0;
            marginLayoutParams.topMargin = Math.max(i16, Math.min(0, i3 + i16));
            n.a("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", Integer.valueOf(marginLayoutParams.bottomMargin));
            this.R.setLayoutParams(marginLayoutParams);
        }
    }

    public final void a(float f16) {
        View view = this.D;
        if (view != null) {
            view.setTranslationX(Math.min(this.f153385i + f16, 0.0f));
            this.D.setTranslationY(Math.max(this.f153387j - f16, 0.0f));
            this.D.setVisibility(0);
        }
    }

    public final ValueAnimator a(int i3, int i16) {
        n.a("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", Integer.valueOf(i3), Integer.valueOf(i16));
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i16);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.listview.PullDownListView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PullDownListView.this.R.getLayoutParams();
                marginLayoutParams.topMargin = num.intValue();
                PullDownListView.this.R.setLayoutParams(marginLayoutParams);
            }
        });
        return ofInt;
    }

    public final void b() {
        if (this.V) {
            b(c(Math.max(this.F - ((int) this.f153376d0), 0)));
            IPullDownCallback iPullDownCallback = this.H;
            if (iPullDownCallback != null) {
                iPullDownCallback.onCoordinationViewOpening(c(Math.max((this.F - h()) - ((int) this.f153376d0), 0)));
                return;
            }
            return;
        }
        a(c(Math.max(((int) this.f153376d0) - this.F, 0)));
        IPullDownCallback iPullDownCallback2 = this.H;
        if (iPullDownCallback2 != null) {
            iPullDownCallback2.onCoordinationViewClosing(c(Math.max(a() - this.F, 0)));
        }
    }

    public final void a(int i3) {
        View view = this.R;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = Math.min(0, Math.max(this.f153378e0, -i3));
            n.a("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", Integer.valueOf(marginLayoutParams.bottomMargin));
            this.R.setLayoutParams(marginLayoutParams);
        }
    }
}
