package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ScrollerRunnable implements Runnable {
    private static long X;
    protected boolean D;
    protected Runnable H;
    private View J;
    protected AnimatorSet K;
    protected int L;
    protected MqqHandler Q;
    protected int V;

    /* renamed from: d, reason: collision with root package name */
    protected ListView f316207d;

    /* renamed from: e, reason: collision with root package name */
    protected int f316208e;

    /* renamed from: f, reason: collision with root package name */
    protected int f316209f;

    /* renamed from: h, reason: collision with root package name */
    protected int f316210h;

    /* renamed from: i, reason: collision with root package name */
    protected int f316211i;

    /* renamed from: m, reason: collision with root package name */
    protected final int f316212m;
    protected int C = 0;
    protected int E = 0;
    protected boolean F = false;
    protected int G = -1;
    protected int I = 0;
    protected int M = 0;
    protected boolean N = false;
    protected int P = -1;
    protected long R = -1;
    private int S = 0;
    protected boolean T = false;
    protected boolean U = false;
    HashMap<Integer, Integer> W = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.ScrollerRunnable$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ScrollerRunnable this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    protected enum ScrollType {
        MOVE_DOWN_EXCEED_TIMES,
        MOVE_DOWN_OTHER,
        MOVE_UP_JUMP_DIRECT,
        MOVE_UP_EXCEED_TIMES,
        MOVE_UP_OTHER
    }

    public ScrollerRunnable(ListView listView) {
        this.D = true;
        this.f316207d = listView;
        this.f316212m = ViewConfiguration.get(listView.getContext()).getScaledFadingEdgeLength();
        this.D = com.tencent.mobileqq.utils.m.c() / 1048576 > 512;
        this.V = ((int) (this.f316207d.getContext().getResources().getDimension(R.dimen.title_bar_height) + 0.5d)) + ImmersiveUtils.getStatusBarHeight(listView.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        AnimatorSet animatorSet = this.K;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.K.cancel();
        }
        AnimatorSet a16 = com.tencent.mobileqq.activity.textanimation.a.a(view);
        this.K = a16;
        a16.start();
        this.J = view;
    }

    protected void e() {
        final View i3;
        List<ChatMessage> a16;
        long currentTimeMillis = System.currentTimeMillis();
        if (System.currentTimeMillis() - X < 1000) {
            return;
        }
        if (this.G != -1) {
            X = currentTimeMillis;
        }
        int firstVisiblePosition = this.f316207d.getFirstVisiblePosition() - this.f316207d.getHeaderViewsCount();
        if (this.G < firstVisiblePosition) {
            return;
        }
        if (this.P == 5 && this.R > 0) {
            ListAdapter adapter = this.f316207d.getAdapter();
            if ((adapter instanceof com.tencent.mobileqq.activity.aio.s) && (a16 = ((com.tencent.mobileqq.activity.aio.s) adapter).a()) != null && a16.size() > 0) {
                int size = a16.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        break;
                    }
                    if (a16.get(i16).uniseq == this.R) {
                        this.G = i16;
                        break;
                    }
                    i16++;
                }
            }
        }
        int i17 = this.G;
        if (i17 != -1 && (i3 = i(this.f316207d.getChildAt(i17 - firstVisiblePosition))) != null) {
            if (QLog.isColorLevel()) {
                QLog.i("ScrollerRunnable", 2, "FlushMessageItem:" + i3.hashCode() + "," + i3.getParent());
            }
            if (this.I == 1) {
                i3.setBackgroundColor(0);
                if (com.tencent.mobileqq.activity.textanimation.a.b().booleanValue()) {
                    i3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.bh
                        @Override // java.lang.Runnable
                        public final void run() {
                            ScrollerRunnable.this.m(i3);
                        }
                    }, 300L);
                    return;
                } else {
                    i3.post(new Runnable() { // from class: com.tencent.mobileqq.widget.ScrollerRunnable.3
                        @Override // java.lang.Runnable
                        public void run() {
                            int color;
                            if (ScrollerRunnable.this.J != null) {
                                ScrollerRunnable.this.J.setBackgroundColor(0);
                            }
                            if (QQTheme.isNowThemeIsNight()) {
                                color = BaseApplication.getContext().getResources().getColor(R.color.cdg);
                            } else {
                                color = BaseApplication.getContext().getResources().getColor(R.color.ael);
                            }
                            i3.setBackgroundColor(color);
                            ScrollerRunnable.this.J = i3;
                        }
                    });
                    return;
                }
            }
            if (com.tencent.mobileqq.activity.textanimation.a.b().booleanValue()) {
                i3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.bi
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScrollerRunnable.this.n(i3);
                    }
                }, 300L);
            } else {
                i3.post(new Runnable() { // from class: com.tencent.mobileqq.widget.ScrollerRunnable.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollerRunnable.this.r(i3);
                    }
                });
            }
        }
    }

    protected void h() {
        o();
        if (l()) {
            e();
        }
    }

    protected View i(View view) {
        if (this.I == 2 && view != null) {
            return view.findViewById(R.id.w2j);
        }
        return view;
    }

    protected int j(ScrollType scrollType) {
        if (QLog.isColorLevel()) {
            QLog.d("ScrollerRunnable", 2, "getScrollOffset, TITLE_BAR_HEIGHT = " + this.V + ", animationOffset = " + this.S + ", type = " + scrollType);
        }
        if (!k()) {
            return -this.V;
        }
        return (this.V + this.S) * (-1);
    }

    public boolean k() {
        if (this.S != 0) {
            return true;
        }
        return false;
    }

    protected boolean l() {
        return false;
    }

    protected void o() {
        Runnable runnable = this.H;
        if (runnable != null) {
            runnable.run();
            this.H = null;
        }
        this.f316207d.post(new Runnable() { // from class: com.tencent.mobileqq.widget.ScrollerRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                ScrollerRunnable.this.e();
                ScrollerRunnable.this.g();
            }
        });
    }

    public synchronized void p(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ScrollerRunnable", 2, "resetExtraScrollIfNeeded==>extraType:" + i3);
        }
        if (i3 == 0 && !this.W.isEmpty()) {
            this.W.clear();
            this.C = 0;
        } else {
            if (this.W.containsKey(Integer.valueOf(i3))) {
                this.C -= this.W.remove(Integer.valueOf(i3)).intValue();
            }
        }
    }

    public void q() {
        this.V = 0;
    }

    protected void r(final View view) {
        int i3;
        int i16;
        if (com.tencent.mobileqq.troop.navigatebar.expriment.a.c()) {
            i3 = 16643300;
            i16 = -133916;
        } else {
            i3 = 11580351;
            i16 = 867218367;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(view, "backgroundColor", i3, i16);
        ofInt.setDuration(300L);
        ofInt.setEvaluator(new ArgbEvaluator());
        final ObjectAnimator ofInt2 = ObjectAnimator.ofInt(view, "backgroundColor", i16, i3);
        ofInt2.setDuration(400L);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ofInt.addListener(new f() { // from class: com.tencent.mobileqq.widget.ScrollerRunnable.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                animator.removeAllListeners();
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.ScrollerRunnable.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ofInt2.start();
                    }
                }, 500L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt2.addListener(new a(view));
        ofInt.start();
        this.R = -1L;
    }

    @Override // java.lang.Runnable
    public void run() {
        int firstVisiblePosition;
        int childCount;
        int paddingBottom;
        int paddingTop;
        int firstVisiblePosition2;
        int childCount2;
        int i3;
        if (!this.N) {
            this.N = true;
            this.M = 0;
            this.E = 0;
            if (this.T) {
                firstVisiblePosition2 = Math.max(0, this.f316207d.getFirstVisiblePosition() - this.f316207d.getHeaderViewsCount());
            } else {
                firstVisiblePosition2 = this.f316207d.getFirstVisiblePosition();
            }
            if (this.T) {
                childCount2 = (this.f316207d.getChildCount() + firstVisiblePosition2) - this.f316207d.getFooterViewsCount();
            } else {
                childCount2 = this.f316207d.getChildCount() + firstVisiblePosition2;
            }
            int i16 = childCount2 - 1;
            if (QLog.isColorLevel()) {
                QLog.d("ScrollerRunnable", 2, "run invoke, isNeedIgnoreHeaderView = " + this.T + ", getFirstVisiblePosition = " + this.f316207d.getFirstVisiblePosition() + ", getLastVisiblePosition = " + this.f316207d.getLastVisiblePosition() + ", lastPos = " + i16 + ", firstPos = " + firstVisiblePosition2 + ", getHeaderViewsCount = " + this.f316207d.getHeaderViewsCount() + ", getChildCount = " + this.f316207d.getChildCount() + ", getFooterViewsCount = " + this.f316207d.getFooterViewsCount() + ", jumpToTopDirect = " + this.F);
            }
            int i17 = this.f316209f;
            if (i17 <= firstVisiblePosition2) {
                i3 = (firstVisiblePosition2 - i17) + 1;
                this.f316208e = 2;
            } else if (i17 >= i16) {
                if (k() && this.f316209f == i16) {
                    h();
                    return;
                } else {
                    i3 = (this.f316209f - i16) + 1;
                    this.f316208e = 1;
                }
            } else if (k() && this.f316209f - firstVisiblePosition2 <= 2) {
                this.f316208e = 1;
                if (QLog.isColorLevel()) {
                    QLog.i("ScrollerRunnable", 2, "hit up boundary case");
                }
                i3 = 2;
            } else {
                h();
                return;
            }
            if (i3 > 0) {
                this.f316211i = 1000 / i3;
            } else {
                this.f316211i = 1000;
            }
            this.f316210h = -1;
        }
        f();
        int height = this.f316207d.getHeight();
        if (this.T) {
            firstVisiblePosition = Math.max(0, this.f316207d.getFirstVisiblePosition() - this.f316207d.getHeaderViewsCount());
        } else {
            firstVisiblePosition = this.f316207d.getFirstVisiblePosition();
        }
        QLog.d("ScrollerRunnable", 2, "run invoke, firstPos = " + firstVisiblePosition + ", mLastSeenPos = " + this.f316210h + ", mTargetPos = " + this.f316209f);
        int i18 = this.f316208e;
        if (i18 != 1) {
            if (i18 == 2) {
                if (this.F && this.E > 4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScrollerRunnable", 2, "jumpToTopDirect,listCount = " + this.f316207d.getCount() + " mTargetPos = " + this.f316209f);
                    }
                    this.f316207d.setSelection(this.f316209f + 1);
                    this.f316207d.smoothScrollBy(j(ScrollType.MOVE_UP_JUMP_DIRECT), this.f316211i);
                    o();
                    this.F = false;
                    return;
                }
                this.E++;
                if (firstVisiblePosition == this.f316210h) {
                    int i19 = this.M;
                    if (i19 > 10) {
                        this.f316207d.setSelection(this.f316209f + 1);
                        this.f316207d.smoothScrollBy(j(ScrollType.MOVE_UP_EXCEED_TIMES), this.f316211i);
                        o();
                        return;
                    } else {
                        this.M = i19 + 1;
                        QLog.d("ScrollerRunnable", 2, "run invoke, tryTimes = " + this.M);
                        this.f316207d.post(this);
                        return;
                    }
                }
                this.M = 0;
                int i26 = this.f316209f;
                if (firstVisiblePosition <= i26) {
                    this.f316207d.setSelection(i26 + 1);
                    this.f316207d.smoothScrollBy(j(ScrollType.MOVE_UP_OTHER), this.f316211i);
                    o();
                    return;
                }
                View childAt = this.f316207d.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                int top = childAt.getTop();
                if (firstVisiblePosition > this.f316209f) {
                    paddingTop = this.f316212m;
                } else {
                    paddingTop = this.f316207d.getPaddingTop() + this.C;
                }
                int i27 = top - paddingTop;
                if (this.D) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScrollerRunnable", 2, "getScrollOffset(out), MOVE_UP_POS, distance = " + i27 + ", extraScroll = " + paddingTop);
                    }
                    this.f316207d.smoothScrollBy(i27, this.f316211i);
                } else if (firstVisiblePosition > this.f316209f) {
                    this.f316207d.setSelection(0);
                }
                this.f316210h = firstVisiblePosition;
                if (firstVisiblePosition > this.f316209f) {
                    this.f316207d.post(this);
                    return;
                }
                return;
            }
            return;
        }
        if (this.U) {
            childCount = (this.f316207d.getChildCount() - 1) - this.f316207d.getFooterViewsCount();
        } else {
            childCount = this.f316207d.getChildCount() - 1;
        }
        int i28 = firstVisiblePosition + childCount;
        if (childCount < 0) {
            return;
        }
        if (i28 == this.f316210h) {
            if (this.M > 10) {
                this.f316207d.setSelection(this.f316209f + 1);
                if (i28 != this.f316209f) {
                    this.f316207d.smoothScrollBy(j(ScrollType.MOVE_DOWN_EXCEED_TIMES), this.f316211i);
                }
                o();
                if (this.C != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScrollerRunnable", 2, "getScrollOffset(out), MOVE_DOWN_POS, mlastExtraScroll = " + this.C);
                    }
                    this.f316207d.smoothScrollBy(this.C, this.f316211i);
                    p(0);
                    return;
                }
                return;
            }
            this.f316207d.post(this);
            this.M++;
            return;
        }
        View childAt2 = this.f316207d.getChildAt(childCount);
        int height2 = childAt2.getHeight();
        int paddingBottom2 = (height - this.f316207d.getPaddingBottom()) - childAt2.getTop();
        if (i28 < this.f316207d.getCount() - 1) {
            paddingBottom = this.f316212m;
        } else {
            paddingBottom = this.f316207d.getPaddingBottom();
        }
        int i29 = (height2 - paddingBottom2) + paddingBottom;
        if (QLog.isColorLevel()) {
            QLog.d("ScrollerRunnable", 2, "MOVE_DOWN_POS, lastPos = " + i28 + ", needSmoothScroll = " + this.D + ", distance = " + i29);
        }
        if (this.D) {
            this.f316207d.smoothScrollBy(i29, this.f316211i);
        } else if (i28 < this.f316209f) {
            this.f316207d.setSelection(childCount);
        }
        this.f316210h = i28;
        if (i28 < this.f316209f) {
            this.f316207d.post(this);
        }
        if (l()) {
            e();
        }
        int i36 = this.f316209f;
        if (i28 >= i36) {
            this.f316207d.setSelection(i36 + 1);
            if (i28 != this.f316209f || k()) {
                this.f316207d.smoothScrollBy(j(ScrollType.MOVE_DOWN_OTHER), this.f316211i);
            }
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(View view) {
        AnimatorSet a16 = com.tencent.mobileqq.activity.textanimation.a.a(view);
        a16.addListener(new b(view));
        a16.start();
        this.R = -1L;
    }

    public void stop() {
        this.f316207d.removeCallbacks(this);
        this.N = false;
        this.H = null;
    }

    public void t(int i3, int i16, Runnable runnable, int i17, boolean z16) {
        stop();
        this.G = i16;
        this.f316209f = i3;
        this.H = runnable;
        if (QLog.isColorLevel()) {
            QLog.d("ScrollerRunnable", 2, "start, from:", Integer.valueOf(i17), ", aniPos:", Integer.valueOf(i16), ", mTargetPos:", this.f316209f + ", jumpToTopDirect:" + z16);
        }
        this.F = z16;
        this.L = i17;
        this.f316207d.post(this);
    }

    public void f() {
    }

    public void g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316219d;

        a(View view) {
            this.f316219d = view;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MqqHandler mqqHandler;
            if (this.f316219d.getParent() != null) {
                this.f316219d.clearAnimation();
                if (QLog.isColorLevel()) {
                    QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ScrollerRunnable", 2, "onAnimationEnd:" + hashCode() + "," + this.f316219d.hashCode() + "," + this.f316219d.getParent());
            }
            if (com.tencent.mobileqq.troop.navigatebar.h.a(ScrollerRunnable.this.P) && (mqqHandler = ScrollerRunnable.this.Q) != null) {
                mqqHandler.obtainMessage(52).sendToTarget();
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("ScrollerRunnable", 2, "onAnimationStart:" + hashCode() + "," + this.f316219d.hashCode() + "," + this.f316219d.getParent());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f316221d;

        b(View view) {
            this.f316221d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MqqHandler mqqHandler;
            if (this.f316221d.getParent() != null) {
                this.f316221d.clearAnimation();
                if (QLog.isColorLevel()) {
                    QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("ScrollerRunnable", 2, "onAnimationEnd:" + hashCode() + "," + this.f316221d.hashCode() + "," + this.f316221d.getParent());
            }
            if (com.tencent.mobileqq.troop.navigatebar.h.a(ScrollerRunnable.this.P) && (mqqHandler = ScrollerRunnable.this.Q) != null) {
                mqqHandler.obtainMessage(52).sendToTarget();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("ScrollerRunnable", 2, "onAnimationStart:" + hashCode() + "," + this.f316221d.hashCode() + "," + this.f316221d.getParent());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
