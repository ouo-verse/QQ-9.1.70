package com.tencent.biz.qqcircle.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.widget.ScrollerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFLiuHaiUtils;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSlidBottomView extends FrameLayout implements NestedScrollingParent {

    /* renamed from: m0, reason: collision with root package name */
    private static final int f92539m0 = cx.a(5.0f);

    /* renamed from: n0, reason: collision with root package name */
    private static final int f92540n0 = cx.a(30.0f);
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private int K;
    private int L;
    protected Interpolator M;
    protected Interpolator N;
    private int P;
    private float Q;
    private int R;
    private View S;
    private List<d> T;
    private final Interpolator U;
    private ScrollerCompat V;
    private ObjectAnimator W;

    /* renamed from: a0, reason: collision with root package name */
    private ObjectAnimator f92541a0;

    /* renamed from: b0, reason: collision with root package name */
    private ObjectAnimator f92542b0;

    /* renamed from: c0, reason: collision with root package name */
    private ObjectAnimator f92543c0;

    /* renamed from: d, reason: collision with root package name */
    private final NestedScrollingParentHelper f92544d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f92545d0;

    /* renamed from: e, reason: collision with root package name */
    private int f92546e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f92547e0;

    /* renamed from: f, reason: collision with root package name */
    private int f92548f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f92549f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f92550g0;

    /* renamed from: h, reason: collision with root package name */
    private int f92551h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f92552h0;

    /* renamed from: i, reason: collision with root package name */
    private int f92553i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f92554i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f92555j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f92556k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f92557l0;

    /* renamed from: m, reason: collision with root package name */
    private int f92558m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void onConfigurationChanged();

        void onDismiss();

        void onScrollChanged(int i3, int i16, int i17, int i18);

        void onShow();

        void onStatusChange(int i3);
    }

    public QCircleSlidBottomView(@NonNull Context context) {
        this(context, null);
    }

    private void h(int i3, int i16) {
        this.V.abortAnimation();
        this.V.fling(0, getScrollY(), i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.V.computeScrollOffset()) {
            int currY = this.V.getCurrY();
            int finalY = this.V.getFinalY();
            int i17 = finalY - currY;
            if (i17 > 0) {
                if (v() && i17 > this.J / 2) {
                    y();
                }
            } else if (i17 < 0) {
                if (v()) {
                    if (Math.abs(i17) > this.J / 2) {
                        g();
                    }
                } else if (Math.abs(i17) > (this.J * 2.0f) / 3.0f) {
                    g();
                }
            }
            QLog.d("QCircleSlidBottomView", 1, "doFlingAction start y=" + currY + "   end y=" + finalY);
        }
    }

    private boolean i() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_slide_view_use_new_screen_height", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private void j(int i3, int i16) {
        if (Math.abs(i16) < this.f92548f) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return;
        }
        w();
        int i17 = this.f92551h;
        int max = Math.max(-i17, Math.min(i3, i17));
        int i18 = this.f92551h;
        int max2 = Math.max(-i18, Math.min(i16, i18));
        if (Math.abs(max2) < Math.abs(max)) {
            return;
        }
        h(max, max2);
        QLog.d("QCircleSlidBottomView", 1, "fling velocityX=" + max + ",velocityY=" + max2);
    }

    private int l() {
        if (i()) {
            int b16 = cx.b(getContext());
            if (bz.t()) {
                return b16;
            }
            return Math.max(b16, cx.c(getContext()));
        }
        return DisplayUtil.getScreenHeight();
    }

    private int o() {
        DisplayUtil.reset();
        int screenHeight = (int) (DisplayUtil.getScreenHeight() * 0.2d);
        QLog.d("QCircleSlidBottomView", 1, "screenH: " + DisplayUtil.getScreenHeight() + ", spaceH: " + screenHeight);
        return screenHeight;
    }

    private boolean q(RecyclerView recyclerView) {
        if (recyclerView == null || !(recyclerView.getAdapter() instanceof BlockMerger) || ((BlockMerger) recyclerView.getAdapter()).getCount() <= 0) {
            return false;
        }
        return true;
    }

    private void r() {
        int i3;
        int i16;
        int screenWidth;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f92546e = viewConfiguration.getScaledTouchSlop();
        this.f92548f = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f92551h = viewConfiguration.getScaledMaximumFlingVelocity();
        boolean z16 = false;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(getContext()) - 1;
        } else {
            i3 = 0;
        }
        if (RFLiuHaiUtils.enableNotch((Activity) getContext())) {
            RFLiuHaiUtils.initLiuHaiBarHeight((Activity) getContext());
            i16 = RFLiuHaiUtils.liuHaiTopBarHeight();
        } else {
            i16 = 0;
        }
        this.K = Math.max(i3, i16);
        int l3 = l() + this.K;
        this.J = l3;
        this.C = (int) (l3 * this.Q);
        if (this.D == 0) {
            if (bz.k()) {
                screenWidth = o();
            } else {
                screenWidth = (int) (ImmersiveUtils.getScreenWidth() * 0.48d);
            }
            this.D = screenWidth;
        }
        int i17 = this.D;
        int i18 = this.K;
        int i19 = i17 + i18;
        this.F = i19;
        int i26 = this.J;
        this.R = (i26 - i19) - i18;
        this.f92558m = (i26 / 2) - i19;
        if (getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        }
        QLog.d("QCircleSlidBottomView", 1, "initPanelHeight mScreenHeight=" + this.J + ",mPanelHeight=" + this.R + ",instantScreenHeight=" + cx.b(getContext()) + ",instantScreenWidth=" + cx.c(getContext()) + ",isLandscape=" + z16);
    }

    private boolean s(int i3, RecyclerView recyclerView) {
        boolean canScrollVertically;
        if (u()) {
            if (i3 >= 0) {
                return this.f92549f0;
            }
            canScrollVertically = recyclerView.canScrollVertically(-1);
        } else {
            if (v()) {
                if (q(recyclerView) || i3 <= 0) {
                    return true;
                }
                return false;
            }
            if (i3 >= 0) {
                return this.f92549f0;
            }
            canScrollVertically = recyclerView.canScrollVertically(-1);
        }
        return true ^ canScrollVertically;
    }

    private void w() {
        ObjectAnimator objectAnimator = this.W;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f92541a0;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f92543c0;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f92542b0;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
    }

    private void z() {
        ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", getScrollY(), 0).setDuration(200L);
        this.f92543c0 = duration;
        duration.start();
        this.I = 0;
        Iterator<d> it = this.T.iterator();
        while (it.hasNext()) {
            it.next().onStatusChange(this.I);
        }
        QLog.d("QCircleSlidBottomView", 1, "toHalf mCurrentStatus=STATE_HALF");
    }

    public void d(int i3) {
        if (!this.f92552h0) {
            this.f92553i += i3;
            requestLayout();
            this.f92552h0 = true;
            QLog.d("QCircleSlidBottomView", 1, "addBottomPadding bottomPadding=" + i3 + ",mBottomPaddingHeight=" + this.f92553i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            QLog.d("QCircleSlidBottomView", 1, "[dispatchTouchEvent] action down, hashCode:" + hashCode());
            this.f92557l0 = true;
            this.f92556k0 = getScrollY();
        }
        if (motionEvent.getAction() == 1) {
            QLog.d("QCircleSlidBottomView", 1, "[dispatchTouchEvent] action up, hashCode:" + hashCode() + ", mHasConsumeResidualNestedScroll = " + this.f92555j0);
            this.f92557l0 = false;
            if (this.f92555j0) {
                p(this.f92556k0);
            }
            this.f92555j0 = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(d dVar) {
        this.T.add(dVar);
    }

    public void f() {
        if (!this.f92550g0) {
            int i3 = this.D;
            int i16 = this.K;
            int i17 = i3 + i16;
            this.E = i17;
            int i18 = i17 + i16;
            this.F = i18;
            if (this.H) {
                this.F = i18 + 118;
                this.H = false;
            }
            this.f92558m = (this.J / 2) - this.F;
            this.f92550g0 = true;
            QLog.d("QCircleSlidBottomView", 1, "correctedParameters mFullScrollY=" + this.f92558m + ",mFixTopHeight=" + this.F);
        }
    }

    public void g() {
        QLog.d("QCircleSlidBottomView", 1, new Throwable("dismissView debug"), new Object[0]);
        if (this.f92545d0) {
            QLog.d("QCircleSlidBottomView", 1, "dismissView mIsShow, return");
            return;
        }
        int scrollY = getScrollY();
        QLog.d("QCircleSlidBottomView", 1, "dismissView currentY:" + scrollY);
        ObjectAnimator objectAnimator = this.f92542b0;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", scrollY, m()).setDuration(200L);
        this.f92542b0 = duration;
        duration.setInterpolator(this.N);
        this.f92542b0.addListener(new c());
        this.f92542b0.start();
        this.I = -1;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f92544d.getNestedScrollAxes();
    }

    public int k() {
        return this.R;
    }

    public int m() {
        return (-this.R) / 2;
    }

    public int n() {
        int i3;
        if (this.G) {
            i3 = this.F;
        } else {
            i3 = 0;
        }
        return (this.J / 2) - i3;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.d("QCircleSlidBottomView", 1, "onConfigurationChanged:bottom=" + (this.f92553i + this.L));
        r();
        this.f92550g0 = false;
        Iterator<d> it = this.T.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = this.C;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (i26 == 0) {
                childAt.setPadding(childAt.getPaddingStart(), 0, childAt.getPaddingEnd(), this.f92553i + this.L);
            }
            childAt.layout(0, i19, childAt.getMeasuredWidth(), childAt.getMeasuredHeight() + i19 + this.L);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f16, float f17, boolean z16) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f16, float f17) {
        if (view instanceof NestScrollRecyclerView) {
            int i3 = (int) f17;
            if (s(i3, (NestScrollRecyclerView) view)) {
                j((int) f16, i3);
                QLog.d("QCircleSlidBottomView", 1, "fling=" + f16 + " " + f17);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        if ((view instanceof RecyclerView) && s(i16, (RecyclerView) view)) {
            this.f92549f0 = true;
            QLog.d("QCircleSlidBottomView", 1, "onNestedPreScroll dx=" + i3 + ",dy=" + i16);
            if (getScrollY() + i16 > this.f92558m && i16 > 0) {
                iArr[1] = i16;
                return;
            }
            w();
            int i17 = this.f92546e;
            if (i16 > i17 * 2) {
                scrollBy(0, i17 * 2);
            } else if (i16 < i17 * (-2)) {
                scrollBy(0, i17 * (-2));
            } else {
                scrollBy(0, i16);
            }
            iArr[1] = i16;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        if (!this.f92554i0) {
            super.onNestedScroll(view, i3, i16, i17, i18);
            return;
        }
        if ((view instanceof RecyclerView) && this.f92557l0 && s(i18, (RecyclerView) view)) {
            QLog.d("QCircleSlidBottomView", 1, "onNestedScroll dyConsumed =" + i16 + ",dyUnconsumed =" + i18);
            if (getScrollY() + i18 > this.f92558m && i18 > 0) {
                return;
            }
            this.f92555j0 = true;
            w();
            int i19 = this.f92546e;
            if (i18 > i19 * 2) {
                scrollBy(0, i19 * 2);
            } else if (i18 < i19 * (-2)) {
                scrollBy(0, i19 * (-2));
            } else {
                scrollBy(0, i18);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.f92544d.onNestedScrollAccepted(view, view2, i3);
        this.P = getScrollY();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        Iterator<d> it = this.T.iterator();
        while (it.hasNext()) {
            it.next().onScrollChanged(i3, i16, i17, i18);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if (!this.f92545d0 && !this.f92547e0) {
            if ((i3 & 2) == 0) {
                return false;
            }
            return true;
        }
        QLog.d("QCircleSlidBottomView", 1, "onStartNestedScroll mIsShow or mIsOnDismiss,return");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f92544d.onStopNestedScroll(view);
        p(this.P);
        this.f92549f0 = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getY() < this.F) {
            g();
            QLog.d("QCircleSlidBottomView", 1, "onTouchEvent dismissView mFixTopHeight=" + this.F + ",event=" + motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void p(int i3) {
        if (!this.f92547e0 && !this.f92545d0) {
            int scrollY = i3 - getScrollY();
            if (u()) {
                if (scrollY > 0) {
                    if (Math.abs(scrollY) > f92540n0) {
                        g();
                        return;
                    } else {
                        y();
                        return;
                    }
                }
                y();
                return;
            }
            if (v()) {
                if (scrollY > 0) {
                    if (Math.abs(scrollY) > f92540n0) {
                        g();
                        return;
                    } else {
                        z();
                        return;
                    }
                }
                if (Math.abs(scrollY) > this.R / 8.0f) {
                    y();
                    return;
                } else {
                    z();
                    return;
                }
            }
            if (scrollY > 0) {
                if (Math.abs(scrollY) > this.R / 2.0f) {
                    g();
                    return;
                } else if (Math.abs(scrollY) > f92540n0) {
                    z();
                    return;
                } else {
                    y();
                    return;
                }
            }
            return;
        }
        QLog.e("QCircleSlidBottomView", 1, "[handleStopScroll] mIsOnDismiss = " + this.f92547e0 + ", mIsShow = " + this.f92545d0);
    }

    public void setIsShoppingCart(boolean z16) {
        this.H = z16;
    }

    public void setNeedConsumeResidualNestedScroll(boolean z16) {
        this.f92554i0 = z16;
    }

    public void setPanelHeight(int i3) {
        this.R = i3;
    }

    public void setTopSpaceHeight(int i3) {
        this.D = i3;
        int i16 = this.K;
        int i17 = i3 + i16;
        this.F = i17;
        int i18 = this.J;
        this.R = (i18 - i17) - i16;
        this.f92558m = (i18 / 2) - i17;
    }

    public boolean t() {
        if (this.I > -1) {
            return true;
        }
        return false;
    }

    public boolean u() {
        if (this.I == 2) {
            return true;
        }
        return false;
    }

    public boolean v() {
        if (this.I == 0) {
            return true;
        }
        return false;
    }

    public void x(View view) {
        if (this.f92547e0) {
            QLog.d("QCircleSlidBottomView", 1, "showView mIsOnDismiss, return");
            return;
        }
        this.I = 2;
        this.W = ObjectAnimator.ofInt(this, "ScrollY", m(), n()).setDuration(250L);
        QLog.d("QCircleSlidBottomView", 1, "showView mCurrentStatus=STATE_FIX");
        this.S = view;
        setVisibility(0);
        this.W.addListener(new b());
        this.W.setInterpolator(this.M);
        this.W.start();
    }

    public void y() {
        if (this.S == null) {
            return;
        }
        ObjectAnimator duration = ObjectAnimator.ofInt(this, "ScrollY", getScrollY(), this.f92558m).setDuration(250L);
        this.f92541a0 = duration;
        duration.setInterpolator(this.M);
        this.f92541a0.start();
        this.I = 2;
        ViewGroup.LayoutParams layoutParams = this.S.getLayoutParams();
        layoutParams.height = this.R + this.L;
        this.S.setLayoutParams(layoutParams);
        Iterator<d> it = this.T.iterator();
        while (it.hasNext()) {
            it.next().onStatusChange(this.I);
        }
    }

    public QCircleSlidBottomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleSlidBottomView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = -2;
        this.M = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        this.N = new lc0.a(0.39f, 0.0f, 0.23f, 1.0f);
        a aVar = new a();
        this.U = aVar;
        this.V = ScrollerCompat.create(getContext(), aVar);
        this.f92554i0 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.L5);
        this.Q = obtainStyledAttributes.getFloat(y91.a.R5, 0.5f);
        this.f92553i = (int) obtainStyledAttributes.getDimension(y91.a.N5, 0.0f);
        this.G = obtainStyledAttributes.getBoolean(y91.a.T5, true);
        this.D = (int) obtainStyledAttributes.getDimension(y91.a.S5, 0.0f);
        this.L = (int) obtainStyledAttributes.getDimension(y91.a.M5, f92539m0);
        obtainStyledAttributes.recycle();
        this.f92544d = new NestedScrollingParentHelper(this);
        this.T = new ArrayList();
        r();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends com.tencent.mobileqq.widget.ak {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Iterator it = QCircleSlidBottomView.this.T.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a();
            }
            QCircleSlidBottomView.this.f92545d0 = false;
            QLog.d("QCircleSlidBottomView", 1, "showView onAnimationEnd");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCircleSlidBottomView.this.f92545d0 = true;
            Iterator it = QCircleSlidBottomView.this.T.iterator();
            while (it.hasNext()) {
                ((d) it.next()).onShow();
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
    /* loaded from: classes5.dex */
    public class c extends com.tencent.mobileqq.widget.ak {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QLog.d("QCircleSlidBottomView", 1, " onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Iterator it = QCircleSlidBottomView.this.T.iterator();
            while (it.hasNext()) {
                ((d) it.next()).onDismiss();
            }
            QCircleSlidBottomView.this.setVisibility(8);
            QLog.d("QCircleSlidBottomView", 1, "dismissView onAnimationEnd");
            QCircleSlidBottomView.this.f92547e0 = false;
        }

        @Override // com.tencent.mobileqq.widget.ak, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QCircleSlidBottomView.this.f92547e0 = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
