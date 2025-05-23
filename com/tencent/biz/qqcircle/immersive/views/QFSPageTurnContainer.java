package com.tencent.biz.qqcircle.immersive.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.views.z;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class QFSPageTurnContainer extends FrameLayout implements QFSPullRefreshLayout.g {
    private j C;
    private g D;
    private QFSLayerRefreshHeaderView E;
    private QFSLayerLoadFooterView F;
    private GestureDetector G;
    private z H;
    private e I;
    private RecyclerView J;
    private e40.p K;
    private ImageView L;
    private int M;
    private int N;
    protected int P;
    private float Q;
    private boolean R;
    private int S;
    private i T;
    private final AtomicInteger U;
    private long V;

    /* renamed from: d, reason: collision with root package name */
    private boolean f90411d;

    /* renamed from: e, reason: collision with root package name */
    private ViewPager2 f90412e;

    /* renamed from: f, reason: collision with root package name */
    private QFSPullRefreshLayout f90413f;

    /* renamed from: h, reason: collision with root package name */
    private int f90414h;

    /* renamed from: i, reason: collision with root package name */
    private h f90415i;

    /* renamed from: m, reason: collision with root package name */
    private int f90416m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        private void o0(int i3) {
            if (QFSPageTurnContainer.this.U.incrementAndGet() != 5) {
                return;
            }
            QLog.d("FSPageTurnContainer", 1, "[checkCurrentRepeatFeedPos] repeat call, current position: " + i3, new Exception());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            super.onPageScrollStateChanged(i3);
            QLog.d("FSPageTurnContainer", 1, "  onPageScrollStateChanged  state = " + i3);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            super.onPageScrolled(i3, f16, i16);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            QLog.d("FSPageTurnContainer", 1, "onPageSelected  position = " + i3);
            if (QFSPageTurnContainer.this.S == i3) {
                o0(i3);
            } else {
                QFSPageTurnContainer.this.U.set(0);
            }
            QFSPageTurnContainer.this.S = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QFSPullRefreshLayout.f {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.f
        public void a(QFSPullRefreshLayout qFSPullRefreshLayout, int i3) {
            QFSPageTurnContainer.this.Q(false, i3);
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.f
        public void b(QFSPullRefreshLayout qFSPullRefreshLayout) {
            QFSPageTurnContainer.this.Q(true, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements QFSPullRefreshLayout.h {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.h
        public void a(MotionEvent motionEvent) {
            if (QFSPageTurnContainer.this.S == 0) {
                if (QFSPageTurnContainer.this.q() == 1) {
                    QCircleFolderFunnelCollect.recordInvalidSlipBeforeLoadMore();
                } else {
                    QCircleFolderFunnelCollect.recordSlipAfterLoadMore();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QFSPageTurnContainer.this.I()) {
                QFSPageTurnContainer.this.l();
            }
            if (QFSPageTurnContainer.this.f90413f != null) {
                QFSPageTurnContainer.this.f90413f.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        boolean isChildDisallowInterceptListener(View view, e40.p pVar);
    }

    /* loaded from: classes4.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f90421a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f90422b;

        public f(boolean z16, boolean z17) {
            this.f90421a = z16;
            this.f90422b = z17;
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        boolean a();
    }

    /* loaded from: classes4.dex */
    public interface h {
        void onLoadData(boolean z16, int i3);
    }

    /* loaded from: classes4.dex */
    public interface i {
        f a(int i3, boolean z16);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(boolean z16);

        void b(boolean z16);

        void c(boolean z16, float f16);

        void onComplete(boolean z16);
    }

    public QFSPageTurnContainer(Context context) {
        this(context, null);
    }

    private void C() {
        if (this.F != null && this.R) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.f90412e, "TranslationY", -r0.getMeasuredHeight(), 0.0f).setDuration(300L);
            duration.addListener(new d());
            duration.start();
            this.R = false;
        }
    }

    private void E() {
        QFSPullRefreshLayout qFSPullRefreshLayout = (QFSPullRefreshLayout) findViewById(R.id.f27760h4);
        this.f90413f = qFSPullRefreshLayout;
        if (qFSPullRefreshLayout == null) {
            return;
        }
        setRefreshEnable(true);
        setLoadMoreEnable(true);
        this.f90413f.setAutoLoadEnable(true);
        QFSLayerRefreshHeaderView qFSLayerRefreshHeaderView = new QFSLayerRefreshHeaderView(getContext());
        this.E = qFSLayerRefreshHeaderView;
        this.f90413f.setHeaderView(qFSLayerRefreshHeaderView, 3);
        this.f90413f.setHeaderViewMarginTop(cx.h());
        QFSLayerLoadFooterView qFSLayerLoadFooterView = new QFSLayerLoadFooterView(getContext());
        this.F = qFSLayerLoadFooterView;
        this.f90413f.setFooterView(qFSLayerLoadFooterView, 1);
        this.f90413f.setOnRefreshListener(new b());
        this.f90413f.setOnVerticalSwipeListener(new c());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f90413f.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + A(), layoutParams.rightMargin, layoutParams.bottomMargin);
        this.f90413f.setLayoutParams(layoutParams);
        this.f90413f.setOnShowFooterViewListener(new WeakReference<>(this));
    }

    private void F() {
        ImageView imageView = (ImageView) findViewById(R.id.f54652fs);
        this.L = imageView;
        if (imageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = A();
        this.L.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(int i3, int i16) {
        boolean z16;
        if (i16 < i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        return R(i16, z16);
    }

    private boolean N() {
        boolean z16;
        g gVar = this.D;
        if (gVar != null) {
            z16 = gVar.a();
        } else {
            z16 = false;
        }
        if (this.R) {
            C();
            return true;
        }
        return z16;
    }

    private boolean O(e40.p pVar) {
        View view;
        if (this.I != null) {
            if (w() != null && t() != null) {
                view = t().findViewByPosition(t().findFirstCompletelyVisibleItemPosition());
            } else {
                view = null;
            }
            if (view != null) {
                boolean isChildDisallowInterceptListener = this.I.isChildDisallowInterceptListener(view, pVar);
                n(isChildDisallowInterceptListener);
                return isChildDisallowInterceptListener;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z16, int i3) {
        QLog.e("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  isLoadMore = " + z16);
        if (z16) {
            if (!this.f90413f.K()) {
                QLog.d("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  hasMoreData = false");
                return;
            }
            if (K()) {
                QLog.d("FSPageTurnContainer", 1, "triggerRefreshOrLoadMore  isLoadMore = true , running preloadLoadMore");
                return;
            }
            h hVar = this.f90415i;
            if (hVar != null) {
                hVar.onLoadData(true, i3);
                return;
            }
            return;
        }
        h hVar2 = this.f90415i;
        if (hVar2 != null) {
            hVar2.onLoadData(false, i3);
        }
    }

    private boolean R(int i3, boolean z16) {
        boolean z17;
        i iVar = this.T;
        if (iVar == null || this.f90413f == null) {
            return false;
        }
        f a16 = iVar.a(i3, z16);
        QFSPullRefreshLayout qFSPullRefreshLayout = this.f90413f;
        if (a16 != null && a16.f90421a) {
            z17 = true;
        } else {
            z17 = false;
        }
        qFSPullRefreshLayout.setSourceToHeadOut(z17);
        if (a16 == null || !a16.f90422b) {
            return false;
        }
        return true;
    }

    private void S(ViewPager2 viewPager2, PagerSnapHelper pagerSnapHelper) {
        try {
            Field declaredField = viewPager2.getClass().getDeclaredField("mPagerSnapHelper");
            declaredField.setAccessible(true);
            declaredField.set(viewPager2, pagerSnapHelper);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mRecyclerView");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(viewPager2);
            if (obj instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.setOnFlingListener(null);
                pagerSnapHelper.attachToRecyclerView(recyclerView);
            }
        } catch (Throwable th5) {
            QLog.e("FSPageTurnContainer", 1, "[updateViewPagerSnapHelper] error: ", th5);
        }
    }

    private boolean j(MotionEvent motionEvent) {
        if (motionEvent == null || !motionEvent.isFromSource(8194)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.V > 1000) {
            this.V = currentTimeMillis;
            return false;
        }
        return true;
    }

    private float r() {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return 0.6f;
        }
        if (QCircleDeviceInfoUtils.isHighDevice()) {
            return 1.0f;
        }
        return 0.8f;
    }

    private RecyclerView w() {
        ViewPager2 viewPager2;
        if (this.J == null && (viewPager2 = this.f90412e) != null && (viewPager2.getChildAt(0) instanceof RecyclerView)) {
            this.J = (RecyclerView) this.f90412e.getChildAt(0);
        }
        return this.J;
    }

    protected int A() {
        return DisplayUtil.getTopHeight(getContext());
    }

    public ViewPager2 B() {
        return this.f90412e;
    }

    public void D() {
        this.f90413f.M();
    }

    protected void G() {
        try {
            LayoutInflater.from(getContext()).inflate(s(), this);
        } catch (Throwable th5) {
            QLog.d("FSPageTurnContainer", 1, "initView error:" + th5.toString());
        }
        F();
        H();
        E();
        this.P = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.Q = r();
    }

    protected void H() {
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.f73923uv);
        this.f90412e = viewPager2;
        if (viewPager2 == null) {
            return;
        }
        viewPager2.setOrientation(this.f90414h);
        this.f90412e.registerOnPageChangeCallback(new a());
        z zVar = new z(this.f90412e, getContext());
        this.H = zVar;
        zVar.n(QCircleDeviceInfoUtils.isLowDevice());
        this.H.m(new z.a() { // from class: com.tencent.biz.qqcircle.immersive.views.y
            @Override // com.tencent.biz.qqcircle.immersive.views.z.a
            public final boolean a(int i3, int i16) {
                boolean M;
                M = QFSPageTurnContainer.this.M(i3, i16);
                return M;
            }
        });
        S(this.f90412e, this.H);
    }

    public boolean I() {
        return this.f90413f.N();
    }

    public boolean J() {
        return this.f90413f.S();
    }

    public boolean K() {
        return this.f90411d;
    }

    public boolean L() {
        return this.f90413f.T();
    }

    public void P(WeakReference<QFSPullRefreshLayout.g> weakReference) {
        this.f90413f.c0(weakReference);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void Y(boolean z16, boolean z17) {
        QLog.d("FSPageTurnContainer", 1, "[onPullUpEnd] visible: " + z17);
        this.R = z17;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        ViewPager2 viewPager2;
        int i3;
        if (motionEvent.getAction() == 8 && motionEvent.isFromSource(8194)) {
            if (j(motionEvent)) {
                QLog.d("FSPageTurnContainer", 1, "[dispatchGenericMotionEvent] fastScroll: true");
                return true;
            }
            float axisValue = motionEvent.getAxisValue(9);
            QLog.d("FSPageTurnContainer", 1, "[dispatchGenericMotionEvent] scrollValue: " + axisValue);
            if (axisValue != 0.0f && (viewPager2 = this.f90412e) != null) {
                if (axisValue > 0.0f) {
                    i3 = -1;
                } else {
                    i3 = 1;
                }
                this.f90412e.setCurrentItem(viewPager2.getCurrentItem() + i3);
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.G;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        z zVar = this.H;
        if (zVar != null) {
            zVar.c(motionEvent);
        }
        if (this.K == null) {
            this.K = new e40.p();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                this.K.e(motionEvent.getX(), motionEvent.getY());
                O(this.K);
            }
        } else {
            QLog.d("FSPageTurnContainer", 1, "[dispatchTouchEvent] notifyActionDownEvent");
            this.K.d(motionEvent.getX(), motionEvent.getY());
            if (N()) {
                QLog.d("FSPageTurnContainer", 1, "[dispatchTouchEvent] notifyActionDownEvent return true. ");
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        h(0);
    }

    public void h(int i3) {
        this.f90413f.s(i3);
    }

    public void i(int i3, int i16) {
        if (!J() || !this.f90413f.P()) {
            return;
        }
        if (i3 < i16 - 1 || i16 == 1) {
            QLog.d("FSPageTurnContainer", 1, "[checkLoadMoreFinishState] position: " + i3 + " | dataSize: " + i16);
            this.f90413f.L();
            this.f90413f.F(this.f90413f.K());
        }
    }

    public void k(int i3, int i16) {
        int i17;
        if (v() && !L() && !J() && !I() && !K() && (i17 = this.f90416m) >= 0 && i3 >= (i16 - 1) - i17) {
            QLog.d("FSPageTurnContainer", 1, "checkNeedTriggerPreloadLoadMore  preload loadMore, current position: ", Integer.valueOf(i3), " | data size: ", Integer.valueOf(i16), " | preloadNum:", Integer.valueOf(this.f90416m));
            Q(true, 1);
            setPreloadLoadMore(true);
        }
    }

    public void l() {
        this.f90413f.x();
    }

    public void m() {
        try {
            ViewPager2 B = B();
            if (B == null) {
                return;
            }
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(B);
            if (obj instanceof RecyclerView) {
                ((RecyclerView) obj).getRecycledViewPool().clear();
            }
            QLog.e("FSPageTurnContainer", 1, "[clearViewPool] succeed");
        } catch (Throwable th5) {
            QLog.e("FSPageTurnContainer", 1, "[clearViewPool] error: ", th5);
        }
    }

    public void n(boolean z16) {
        QFSPullRefreshLayout qFSPullRefreshLayout = this.f90413f;
        if (qFSPullRefreshLayout != null) {
            qFSPullRefreshLayout.y(z16);
        }
        if (B() != null) {
            B().setUserInputEnabled(!z16);
        }
    }

    public void o(boolean z16) {
        this.f90413f.F(z16);
        setPreloadLoadMore(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void onHide(boolean z16) {
        QLog.d("FSPageTurnContainer", 1, "[onHide] ");
        this.R = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int x16 = (int) (motionEvent.getX() + 0.5f);
            int y16 = (int) (motionEvent.getY() + 0.5f);
            int i3 = x16 - this.M;
            int i16 = (int) ((y16 - this.N) * this.Q);
            if (Math.abs(i3) > this.P && Math.abs(i3) >= Math.abs(i16)) {
                return false;
            }
        } else {
            this.M = (int) (motionEvent.getX() + 0.5f);
            this.N = (int) (motionEvent.getY() + 0.5f);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void p(boolean z16) {
        QFSPullRefreshLayout qFSPullRefreshLayout = this.f90413f;
        if (qFSPullRefreshLayout != null) {
            qFSPullRefreshLayout.G(z16);
        }
    }

    public int q() {
        List dataList;
        ViewPager2 B = B();
        if (B == null) {
            return 0;
        }
        RecyclerView.Adapter adapter = B.getAdapter();
        if (!(adapter instanceof BaseListViewAdapter) || (dataList = ((BaseListViewAdapter) adapter).getDataList()) == null) {
            return 0;
        }
        return dataList.size();
    }

    public int s() {
        return R.layout.gk7;
    }

    public void setActionDownEventListener(g gVar) {
        this.D = gVar;
    }

    public void setChildDisallowInterceptListener(e eVar) {
        this.I = eVar;
    }

    public void setCloseFooterMoveRadio(float f16) {
        this.f90413f.setCloseFooterMoveRadio(f16);
    }

    public void setEnableShowFooterViewByForce(boolean z16) {
        this.f90413f.setEnableShowFooterViewByForce(z16);
    }

    public void setEnabledCheckContentBottom(boolean z16) {
        QFSPullRefreshLayout qFSPullRefreshLayout = this.f90413f;
        if (qFSPullRefreshLayout == null) {
            return;
        }
        qFSPullRefreshLayout.setEnabledCheckContentBottom(z16);
    }

    public void setFakeLoadingMoreAnim() {
        this.f90413f.setFakeLoadingMoreAnim();
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.G = gestureDetector;
    }

    public void setLoadFooterView(QFSLayerLoadFooterView qFSLayerLoadFooterView) {
        this.F = qFSLayerLoadFooterView;
        this.f90413f.setFooterView(qFSLayerLoadFooterView, 1);
    }

    public void setLoadMoreBottomMargin(int i3) {
        if (this.f90413f == null) {
            return;
        }
        QLog.d("FSPageTurnContainer", 1, "[setLoadMoreBottomMargin] bottomMargin: " + i3);
        this.f90413f.setViewBottomMargin(i3);
    }

    public void setLoadMoreEnable(boolean z16) {
        QLog.d("FSPageTurnContainer", 1, "setLoadMoreEnable:" + z16);
        this.f90413f.setLoadMoreEnable(z16);
    }

    public void setLoadMorePreloadNum(int i3) {
        this.f90416m = i3;
    }

    public void setOnLoadDataCallback(h hVar) {
        this.f90415i = hVar;
    }

    public void setOnPositionChangeToDataOutListener(i iVar) {
        this.T = iVar;
    }

    public void setOnRefreshViewStatusListener(j jVar) {
        this.C = jVar;
        QFSLayerRefreshHeaderView qFSLayerRefreshHeaderView = this.E;
        if (qFSLayerRefreshHeaderView != null) {
            qFSLayerRefreshHeaderView.setOnRefreshViewStatusListener(jVar);
        }
        QFSLayerLoadFooterView qFSLayerLoadFooterView = this.F;
        if (qFSLayerLoadFooterView != null) {
            qFSLayerLoadFooterView.setOnRefreshViewStatusListener(this.C);
        }
    }

    public void setOnShowFooterViewListener(WeakReference<QFSPullRefreshLayout.g> weakReference) {
        this.f90413f.setOnShowFooterViewListener(weakReference);
    }

    public void setOrientationType(int i3) {
        this.f90414h = i3;
    }

    public void setPreloadLoadMore(boolean z16) {
        this.f90411d = z16;
    }

    public void setRefreshEnable(boolean z16) {
        QLog.d("FSPageTurnContainer", 1, "setRefreshEnable:" + z16);
        this.f90413f.setRefreshEnable(z16);
    }

    public void setTouchEnable(boolean z16) {
        QLog.d("FSPageTurnContainer", 1, "setTouchEnable:" + z16);
        this.f90413f.setTouchEnable(z16);
    }

    public LinearLayoutManager t() {
        if (w() != null) {
            return (LinearLayoutManager) w().getLayoutManager();
        }
        return null;
    }

    public QFSLayerLoadFooterView u() {
        return this.F;
    }

    public boolean v() {
        return this.f90413f.R();
    }

    public QFSLayerRefreshHeaderView x() {
        return this.E;
    }

    public QFSPullRefreshLayout y() {
        return this.f90413f;
    }

    public ImageView z() {
        return this.L;
    }

    public QFSPageTurnContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPageTurnContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90414h = 1;
        this.f90416m = 2;
        this.Q = 1.0f;
        this.U = new AtomicInteger(0);
        this.V = 0L;
        G();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout.g
    public void f0(boolean z16) {
    }
}
