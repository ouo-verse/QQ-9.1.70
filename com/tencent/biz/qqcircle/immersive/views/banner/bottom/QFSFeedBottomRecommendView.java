package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.al;
import com.tencent.biz.qqcircle.immersive.feed.event.ap;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecAdapter;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecReqUtils;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$PopUpControl;
import feedcloud.FeedCloudMeta$StButtomBanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedBottomRecommendView extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener, SimpleEventReceiver {
    private static final float X = (QCircleApplication.getAPP().getResources().getDimension(R.dimen.d07) + QCircleApplication.getAPP().getResources().getDimension(R.dimen.d09)) - QCircleApplication.getAPP().getResources().getDimension(R.dimen.d0_);
    private ViewStub D;
    private View E;
    private TextView F;
    private TextView G;
    private ImageView H;
    private RecyclerView I;
    private QFSBottomBannerRecAdapter J;
    private RoundCorneredFrameLayout K;
    private View L;
    private RelativeLayout M;
    private ViewGroup N;
    private View P;
    private View Q;
    private int R;
    private int S;
    private Runnable T;
    private FeedCloudMeta$StButtomBanner U;
    private int V;
    private String W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSBottomBannerRecReqUtils.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomBannerRecReqUtils.a
        public void a(boolean z16, List<e30.b> list) {
            if (QFSFeedBottomRecommendView.this.J == null) {
                return;
            }
            QFSFeedBottomRecommendView.this.J.setData(list);
            QFSFeedBottomRecommendView.this.I();
            QFSFeedBottomRecommendView.this.Y(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                rect.left = ImmersiveUtils.dpToPx(12.0f);
            } else {
                rect.left = 0;
            }
            if (childAdapterPosition == QFSFeedBottomRecommendView.this.J.getItemCount() - 1) {
                rect.right = 0;
            } else {
                rect.right = ImmersiveUtils.dpToPx(6.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(recyclerView);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.putAll(ua0.c.e(QFSFeedBottomRecommendView.this.f90601d.e()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(QFSFeedBottomRecommendView.this.f90603f + 1));
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                VideoReport.setElementId(recyclerView, QCircleDaTongConstant.ElementId.EM_XSJ_REC_SLOT_LIST);
                VideoReport.reportEvent("ev_xsj_left_right_slide", recyclerView, buildElementParams);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (i3 > 0) {
                QFSFeedBottomRecommendView.this.W = "left_slide";
            } else {
                QFSFeedBottomRecommendView.this.W = "right_slide";
            }
        }
    }

    public QFSFeedBottomRecommendView(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        this.W = "left_slide";
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void F() {
        QLog.d("QFSFeedBottomRecommendView", 2, "bind bindRecycleViewData:" + this.f90601d.g().f398449id.get());
        List<e30.b> D = com.tencent.biz.qqcircle.immersive.utils.r.D(this.f90601d);
        if (D == null || D.size() == 0) {
            D = new ArrayList<>();
            D.add(this.f90601d);
        }
        this.J.setData(D);
        I();
    }

    private void G() {
        String str = this.U.title.get();
        if (!TextUtils.isEmpty(str)) {
            this.F.setText(str);
        }
        c0(S());
    }

    private void H() {
        if (this.T != null) {
            n().removeCallbacks(this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        QFSBottomBannerRecAdapter qFSBottomBannerRecAdapter = this.J;
        if (qFSBottomBannerRecAdapter != null && this.Q != null) {
            if (qFSBottomBannerRecAdapter.getItemCount() <= 4) {
                this.Q.setVisibility(8);
            } else {
                this.Q.setVisibility(0);
            }
        }
    }

    private void J() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new d());
        this.N.startAnimation(animationSet);
    }

    private void K() {
        c0(false);
        com.tencent.biz.qqcircle.immersive.utils.r.X0(this.f90601d, false, this.I.computeHorizontalScrollOffset(), true);
        a0();
        d0();
        QLog.d("QFSFeedBottomRecommendView", 1, "openWithAni traceId:" + ba.c(this.f90601d) + "feedId:" + this.f90601d.g().f398449id.get());
    }

    private void L(QFSSeekEvent qFSSeekEvent) {
        e30.b bVar;
        if (com.tencent.biz.qqcircle.immersive.utils.r.V(this.f90601d) && this.E != null && (bVar = this.f90601d) != null && qFSSeekEvent.mFeedId.equals(bVar.g().f398449id.get())) {
            if (qFSSeekEvent.mIsOnSeek) {
                this.E.setVisibility(8);
                this.N.setVisibility(8);
                return;
            }
            this.E.setVisibility(0);
            if (S()) {
                this.N.setVisibility(8);
            } else {
                this.N.setVisibility(0);
            }
        }
    }

    private void M(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.e(this.f90601d.e()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f90603f + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, this.U.title.get());
        RelativeLayout relativeLayout = this.M;
        if (z16) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_REC_SLOT_UNFOLD;
        } else {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_REC_SLOT_FOLD;
        }
        VideoReport.setElementId(relativeLayout, str);
        VideoReport.reportEvent("dt_clck", this.L, buildElementParams);
    }

    private void N() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.e(this.f90601d.e()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f90603f + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_EXP_STATUS, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.C(this.f90601d)));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REC_SLOT_TYPE, this.U.title.get());
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_REC_SLOT);
        VideoReport.setElementParams(this.E, buildElementParams);
    }

    private void O() {
        QFSBottomBannerRecAdapter qFSBottomBannerRecAdapter = this.J;
        if (qFSBottomBannerRecAdapter != null && qFSBottomBannerRecAdapter.getItemCount() > 1) {
            QLog.d("QFSFeedBottomRecommendView", 1, "fetchDataFromNetWork return hasData already");
        } else {
            QFSBottomBannerRecReqUtils.f(this.f90601d, new a());
        }
    }

    private void P() {
        if (!com.tencent.biz.qqcircle.immersive.utils.r.V(this.f90601d)) {
            return;
        }
        int i3 = this.V + 1;
        this.V = i3;
        if (i3 != this.R || com.tencent.biz.qqcircle.immersive.utils.r.U(this.f90601d)) {
            return;
        }
        H();
        if (this.S > 0) {
            O();
        }
        n().postDelayed(this.T, this.S);
        QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoLooperEndEvent current:" + this.R);
    }

    private void Q(ap apVar) {
        if (!com.tencent.biz.qqcircle.immersive.utils.r.V(this.f90601d)) {
            QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoStatusEvent no recommend return");
            return;
        }
        QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoStatusEvent firstStart:" + apVar.c());
        if (!apVar.c()) {
            return;
        }
        if (this.R != 0) {
            QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoStatusEvent firstStart return mPopPlayCount:" + this.R);
            return;
        }
        if (com.tencent.biz.qqcircle.immersive.utils.r.U(this.f90601d)) {
            QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoStatusEvent firstStart return has operated");
            return;
        }
        H();
        if (this.S > 0) {
            O();
        }
        n().postDelayed(this.T, this.S);
        QLog.d("QFSFeedBottomRecommendView", 1, "handleVideoLooperEndEvent current:" + this.R);
    }

    private void R() {
        this.I.addOnScrollListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.K;
        if (roundCorneredFrameLayout == null || roundCorneredFrameLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T() {
        e30.b bVar = this.f90601d;
        if (bVar != null) {
            boolean k3 = com.tencent.biz.qqcircle.immersive.adapter.n.k(bVar.g());
            QLog.d("QFSFeedBottomRecommendView", 1, "isTopViewFeed :" + k3);
            return k3;
        }
        return false;
    }

    private void U(@NonNull View view) {
        if (this.D != null) {
            return;
        }
        this.D = (ViewStub) view.findViewById(R.id.f40001d7);
        this.N = (ViewGroup) view.findViewById(R.id.v_p);
        View inflate = this.D.inflate();
        this.E = inflate;
        this.F = (TextView) inflate.findViewById(R.id.f34450z7);
        this.H = (ImageView) this.E.findViewById(R.id.f34390z1);
        this.G = (TextView) this.E.findViewById(R.id.f34440z6);
        this.L = this.E.findViewById(R.id.f33130vm);
        this.I = (RecyclerView) this.E.findViewById(R.id.f34460z8);
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) this.E.findViewById(R.id.f34490za);
        this.K = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(0.0f, ImmersiveUtils.dpToPx(4.0f), ImmersiveUtils.dpToPx(4.0f), 0.0f);
        RelativeLayout relativeLayout = (RelativeLayout) this.E.findViewById(R.id.f34480z_);
        this.M = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.P = this.E.findViewById(R.id.f34430z5);
        this.J = new QFSBottomBannerRecAdapter();
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(view.getContext());
        safeLinearLayoutManager.setOrientation(0);
        this.Q = this.E.findViewById(R.id.f34470z9);
        this.I.setLayoutManager(safeLinearLayoutManager);
        this.I.addItemDecoration(new b());
        R();
        this.I.setAdapter(this.J);
        this.T = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomRecommendView.4
            @Override // java.lang.Runnable
            public void run() {
                if (!QFSFeedBottomRecommendView.this.S() && !QFSFeedBottomRecommendView.this.T()) {
                    QFSFeedBottomRecommendView.this.X();
                }
            }
        };
    }

    private void V() {
        if (S()) {
            K();
            M(false);
        } else {
            X();
            M(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        this.N.startAnimation(alphaAnimation);
        this.N.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        O();
        com.tencent.biz.qqcircle.immersive.utils.r.X0(this.f90601d, true, this.I.computeHorizontalScrollOffset(), true);
        c0(true);
        b0();
        J();
        e0();
        QLog.d("QFSFeedBottomRecommendView", 1, "openWithAni traceId:" + ba.c(this.f90601d) + "|feedId:" + this.f90601d.g().f398449id.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(final List<e30.b> list) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomRecommendView.2
            @Override // java.lang.Runnable
            public void run() {
                if (list == null) {
                    return;
                }
                for (int i3 = 1; i3 < list.size(); i3++) {
                    QCircleFeedPicLoader.g().loadImage(Option.obtain().setFromPreLoad(true).setUrl(((e30.b) list.get(i3)).g().cover.picUrl.get()));
                }
            }
        });
    }

    private void Z() {
        int i3;
        if (this.K != null && this.I != null && this.N != null) {
            boolean s06 = com.tencent.biz.qqcircle.immersive.utils.r.s0(this.f90601d);
            RoundCorneredFrameLayout roundCorneredFrameLayout = this.K;
            int i16 = 0;
            if (s06) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            roundCorneredFrameLayout.setVisibility(i3);
            ViewGroup viewGroup = this.N;
            if (s06) {
                i16 = 8;
            }
            viewGroup.setVisibility(i16);
            n().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomRecommendView.6
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedBottomRecommendView.this.I.scrollToPosition(com.tencent.biz.qqcircle.immersive.utils.r.G(QFSFeedBottomRecommendView.this.f90601d));
                }
            });
            QLog.d("QFSFeedBottomRecommendView", 1, "recoverRecStatus:" + s06 + "| pos\uff1a" + com.tencent.biz.qqcircle.immersive.utils.r.G(this.f90601d) + "|traceId:" + ba.c(this.f90601d) + "|feedId:" + this.f90601d.g().f398449id.get());
        }
    }

    private void a0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, X);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.K.startAnimation(animationSet);
        animationSet.setAnimationListener(new e());
    }

    private void b0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.K.setVisibility(0);
        this.K.startAnimation(animationSet);
    }

    private void c0(boolean z16) {
        if (z16) {
            this.G.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih));
            this.H.setRotation(0.0f);
        } else {
            this.G.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183193ii));
            this.H.setRotation(180.0f);
        }
    }

    private void d0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, X);
        translateAnimation.setDuration(200L);
        this.M.startAnimation(translateAnimation);
    }

    private void e0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, X, 0.0f);
        translateAnimation.setDuration(200L);
        this.M.startAnimation(translateAnimation);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (hVar instanceof al) {
            P();
        }
        if (hVar instanceof ap) {
            Q((ap) hVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 119;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        com.tencent.biz.qqcircle.immersive.utils.r.R0(this.f90601d);
        FeedCloudMeta$PopUpControl feedCloudMeta$PopUpControl = this.f90601d.e().buttomBanner.pop_up_ctrl.get();
        this.R = feedCloudMeta$PopUpControl.play_times.get();
        this.S = feedCloudMeta$PopUpControl.play_duration_seconds.get() * 1000;
        this.U = this.f90601d.e().buttomBanner.get();
        QLog.d("QFSFeedBottomRecommendView", 2, "bind data:" + bVar.g().f398449id.get() + "|mPopPlayCount:" + this.R + "|mPopPlayCount:" + this.S);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return com.tencent.biz.qqcircle.immersive.utils.r.V(this.f90601d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f34480z_) {
            V();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        U(this.f90604h);
        if (this.E == null) {
            return;
        }
        N();
        this.E.setVisibility(0);
        H();
        F();
        Z();
        G();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        H();
        ViewGroup viewGroup = this.N;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        View view = this.E;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        this.V = 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            L((QFSSeekEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        this.V = 0;
        H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedBottomRecommendView.this.N.setVisibility(8);
            QFSFeedBottomRecommendView.this.P.setVisibility(8);
            VideoReport.traversePage(QFSFeedBottomRecommendView.this.I);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedBottomRecommendView.this.K.setVisibility(8);
            QFSFeedBottomRecommendView.this.P.setVisibility(0);
            QFSFeedBottomRecommendView.this.W();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }
}
