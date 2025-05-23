package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.n;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleMultiFollowUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedBottomConfigGuideFollowView extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.c implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: e0, reason: collision with root package name */
    private static final float f90646e0 = (QCircleApplication.getAPP().getResources().getDimension(R.dimen.d07) + QCircleApplication.getAPP().getResources().getDimension(R.dimen.d09)) - QCircleApplication.getAPP().getResources().getDimension(R.dimen.d0_);

    /* renamed from: f0, reason: collision with root package name */
    private static final float f90647f0 = (QCircleApplication.getAPP().getResources().getDimension(R.dimen.d08) + QCircleApplication.getAPP().getResources().getDimension(R.dimen.d09)) - QCircleApplication.getAPP().getResources().getDimension(R.dimen.d0_);
    private ViewStub D;
    private View E;
    private LinearLayout F;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private TextView J;
    private ImageView K;
    private RecyclerView L;
    private QFSConfigGuideFollowHintView M;
    private QFSBottomConfigRecycleAdapter N;
    private FrameLayout P;
    private View Q;
    private RelativeLayout R;
    private ViewGroup S;
    private View T;
    private Runnable U;
    private int V;
    private String W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f90648a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f90649b0;

    /* renamed from: c0, reason: collision with root package name */
    private h f90650c0;

    /* renamed from: d0, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.views.banner.bottom.a f90651d0;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomConfigGuideFollowView$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f90652d;
        final /* synthetic */ QFSFeedBottomConfigGuideFollowView this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f90652d == null) {
                return;
            }
            for (int i3 = 1; i3 < this.f90652d.size(); i3++) {
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setFromPreLoad(true).setUrl(((e30.b) this.f90652d.get(i3)).g().cover.picUrl.get()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSBottomConfigGuideFollowReqUtils.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils.a
        public void a(boolean z16, List<com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.d> list, int i3, String str) {
            if (QFSFeedBottomConfigGuideFollowView.this.N == null) {
                return;
            }
            if (z16 && list != null) {
                QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[fetchDataFromNetWork] onCallBack fetch success. type =" + i3);
                QFSFeedBottomConfigGuideFollowView.this.V = i3;
                QFSFeedBottomConfigGuideFollowView qFSFeedBottomConfigGuideFollowView = QFSFeedBottomConfigGuideFollowView.this;
                qFSFeedBottomConfigGuideFollowView.n0(qFSFeedBottomConfigGuideFollowView.Z());
                if (QFSFeedBottomConfigGuideFollowView.this.M != null) {
                    QFSFeedBottomConfigGuideFollowView.this.M.o0();
                }
                QFSFeedBottomConfigGuideFollowView.this.N.setData(list);
                return;
            }
            if (QFSFeedBottomConfigGuideFollowView.this.M != null) {
                QFSFeedBottomConfigGuideFollowView.this.M.p0();
            }
            QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[fetchDataFromNetWork] onCallBack fetch fail. resultList =" + list);
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
            rect.left = 0;
            if (childAdapterPosition == QFSFeedBottomConfigGuideFollowView.this.N.getItemCount() - 1) {
                rect.right = 0;
            } else {
                rect.right = ImmersiveUtils.dpToPx(6.0f);
            }
        }
    }

    public QFSFeedBottomConfigGuideFollowView(com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f90651d0 = aVar;
    }

    private void H() {
        if (TextUtils.isEmpty(this.Y)) {
            this.Y = "\u5173\u6ce8\u4f5c\u8005\uff0c\u7cbe\u5f69\u4e0d\u9519\u8fc7";
        }
        if (TextUtils.isEmpty(this.W)) {
            this.W = "\u63d0\u53ca\u4f5c\u8005";
        }
        n0(Z());
    }

    private void I() {
        if (this.U != null) {
            n().removeCallbacks(this.U);
        }
    }

    private void J() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, S(), 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new c());
        this.S.startAnimation(animationSet);
    }

    private void K() {
        n0(false);
        r.T0(this.f90601d, false);
        i0();
        p0();
        QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "closeWithAni traceId:" + ba.c(this.f90601d) + "feedId:" + this.f90601d.g().f398449id.get());
    }

    private void L(int i3) {
        String str;
        if (RFSafeListUtils.isEmpty(r.m(this.f90601d))) {
            QLog.e("QFSFeedBottomConfigGuideFollowView", 1, "[dcReport] stUserList should not be null");
            return;
        }
        for (FeedCloudMeta$StUser feedCloudMeta$StUser : r.m(this.f90601d)) {
            if (feedCloudMeta$StUser != null) {
                QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
                dataBuilder.setActionType(80).setSubActionType(i3).setPosition(this.f90603f).setExt2(feedCloudMeta$StUser.f398463id.get()).setFirstFeedId(w20.a.j().h());
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
                if (feedCloudMeta$StFeed != null) {
                    if (feedCloudMeta$StFeed.type.get() == 2) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    dataBuilder.setExt1(str);
                }
                QCircleLpReportDc05507.report(dataBuilder);
            }
        }
    }

    private void M(QFSSeekEvent qFSSeekEvent) {
        e30.b bVar;
        if (r.R(this.f90601d) && this.E != null && (bVar = this.f90601d) != null && qFSSeekEvent.mFeedId.equals(bVar.g().f398449id.get())) {
            if (qFSSeekEvent.mIsOnSeek) {
                this.E.setVisibility(8);
                this.S.setVisibility(8);
                return;
            }
            this.E.setVisibility(0);
            if (Z()) {
                this.S.setVisibility(8);
            } else {
                this.S.setVisibility(0);
            }
        }
    }

    private void N(boolean z16) {
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.f90602e.f398449id.get());
        if (z16) {
            str = "open";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str);
        int i3 = this.V;
        if (i3 == 2) {
            str2 = "more";
        } else if (i3 == 1) {
            str2 = SemanticAttributes.DbCassandraConsistencyLevelValues.ONE;
        } else {
            str2 = "";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, str2);
        VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_GUIDE_OPEN_FOLD_BUTTON);
        VideoReport.reportEvent("dt_clck", this.J, buildElementParams);
    }

    private void O() {
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.f90602e.f398449id.get());
        TextView textView = this.J;
        if (textView != null && textView.getText() != null) {
            if (TextUtils.equals(this.J.getText().toString(), com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih))) {
                str2 = QCircleDaTongConstant.ElementParamValue.CONTAINER_STATUS_STOW;
            } else {
                str2 = "open";
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
        }
        int i3 = this.V;
        if (i3 == 2) {
            str = "more";
        } else if (i3 == 1) {
            str = SemanticAttributes.DbCassandraConsistencyLevelValues.ONE;
        } else {
            str = "";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, str);
        VideoReport.setElementId(this.J, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_GUIDE_OPEN_FOLD_BUTTON);
        VideoReport.setElementParams(this.J, buildElementParams);
        VideoReport.setElementClickPolicy(this.J, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.J, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.J, ExposurePolicy.REPORT_ALL);
    }

    private void P() {
        QFSConfigGuideFollowHintView qFSConfigGuideFollowHintView;
        QFSBottomConfigRecycleAdapter qFSBottomConfigRecycleAdapter = this.N;
        if ((qFSBottomConfigRecycleAdapter == null || qFSBottomConfigRecycleAdapter.getItemCount() < 1) && (qFSConfigGuideFollowHintView = this.M) != null) {
            qFSConfigGuideFollowHintView.q0();
        }
        QFSBottomConfigGuideFollowReqUtils.f(this.f90601d, QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FEED_MASK, new a());
    }

    private void Q() {
        if (this.N == null) {
            return;
        }
        if (r.P(this.f90601d) && this.f90650c0 == null) {
            this.f90650c0 = new h();
            this.f90650c0.f(true, r.r(this.f90601d), Integer.valueOf(r.t(this.f90601d)), r.s(this.f90601d));
        }
        h hVar = this.f90650c0;
        if (hVar == null) {
            return;
        }
        if (!hVar.e()) {
            QFSConfigGuideFollowHintView qFSConfigGuideFollowHintView = this.M;
            if (qFSConfigGuideFollowHintView != null) {
                qFSConfigGuideFollowHintView.p0();
            }
            QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[fillDataFromFollowAuthorModel] rsp is empty. ");
            return;
        }
        QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[fillDataFromFollowAuthorModel] get rsp success. type =" + this.f90650c0.getDrawerType());
        this.V = this.f90650c0.getDrawerType();
        this.X = this.f90650c0.a();
        n0(Z());
        QFSConfigGuideFollowHintView qFSConfigGuideFollowHintView2 = this.M;
        if (qFSConfigGuideFollowHintView2 != null) {
            qFSConfigGuideFollowHintView2.o0();
        }
        i.f90684a.c(bj.g(this.f90602e));
        this.N.setData(this.f90650c0.d());
    }

    private void R() {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_SHOW_STYLE, "top");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TARGET_QQ_GROUP, r.M(r.m(this.f90601d)));
        if (r.k0(r.m(this.f90601d))) {
            str = QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        } else {
            str = "total";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, str);
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.f90603f + 1));
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_TOTAL_FOLLOW_GUIDE_BUTTON);
        VideoReport.setElementParams(this.G, buildElementParams);
    }

    private float S() {
        if (X()) {
            return f90647f0;
        }
        return f90646e0;
    }

    private Context T() {
        if (j() == null) {
            QLog.d(m(), 1, "getResContext, use app.");
            return QCircleApplication.getAPP();
        }
        return j();
    }

    private QFSBottomConfigRecycleAdapter.ShowScene U() {
        if (X()) {
            return QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FOLLOW_AUTHOR;
        }
        return QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FEED_MASK;
    }

    private void V(com.tencent.biz.qqcircle.immersive.feed.event.g gVar) {
        QLog.d(m(), 1, "Receive QFSAllPushPageClickFollowPosterEvent.");
        if (!QFSFeedBottomPYMLFeatManager.f90657a.k()) {
            QLog.i("QFSFeedBottomConfigGuideFollowView", 1, "Exceed limit count, do nothing.");
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(m(), 1, "Study mode do nothing.");
            return;
        }
        if (p() != null && p().getPageId() == 503) {
            if (r.R(this.f90601d)) {
                QLog.d(m(), 1, "Has config guide follow list.");
                return;
            }
            if (Y()) {
                QLog.d(m(), 1, "GuideFollowView is already visible.");
                return;
            } else {
                if (com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(this) != null) {
                    QLog.i("QFSFeedBottomConfigGuideFollowView", 1, "have activating element, do nothing.");
                    return;
                }
                if (this.f90650c0 == null) {
                    this.f90650c0 = new h();
                }
                this.f90650c0.c(this.f90601d, new QFSBottomConfigGuideFollowReqUtils.a() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.f
                    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowReqUtils.a
                    public final void a(boolean z16, List list, int i3, String str) {
                        QFSFeedBottomConfigGuideFollowView.this.b0(z16, list, i3, str);
                    }
                });
                return;
            }
        }
        QLog.d(m(), 1, "Not all push page do nothing.");
    }

    private void W() {
        if (fb0.a.a("QFSFeedBottomConfigGuideFollowViewhandleClickFollowAllUSerBtn")) {
            return;
        }
        l0();
        L(11);
    }

    private boolean X() {
        if (!this.f90649b0 && !r.P(this.f90601d)) {
            return false;
        }
        return true;
    }

    private boolean Y() {
        View view = this.E;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        FrameLayout frameLayout = this.P;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(boolean z16, List list, int i3, String str) {
        if (!z16) {
            QLog.e(m(), 1, "getRecommendAuthorsByClickFollow, request failed.");
            return;
        }
        this.f90650c0.f(z16, list, Integer.valueOf(i3), str);
        if (this.f90650c0.e()) {
            QLog.d(m(), 1, "Try show follow guide view.");
            this.f90649b0 = true;
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.g
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedBottomConfigGuideFollowView.this.a0();
                }
            });
        } else {
            QLog.d(m(), 1, "rsp is empty, only save request count.");
            QFSFeedBottomPYMLFeatManager.f90657a.j();
        }
    }

    private void c0(@NotNull View view) {
        if (this.D != null) {
            return;
        }
        this.D = (ViewStub) view.findViewById(R.id.f39661c_);
        this.S = (ViewGroup) view.findViewById(R.id.v_p);
        View inflate = this.D.inflate();
        this.E = inflate;
        if (inflate == null) {
            QLog.e("QFSFeedBottomConfigGuideFollowView", 1, "[makeSureInflate] mInflateView should not be null");
            return;
        }
        this.I = (TextView) inflate.findViewById(R.id.f34450z7);
        this.F = (LinearLayout) this.E.findViewById(R.id.f34410z3);
        LinearLayout linearLayout = (LinearLayout) this.E.findViewById(R.id.f34400z2);
        this.G = linearLayout;
        linearLayout.setOnClickListener(this);
        this.H = (TextView) this.E.findViewById(R.id.f34420z4);
        this.K = (ImageView) this.E.findViewById(R.id.f34390z1);
        this.J = (TextView) this.E.findViewById(R.id.f34440z6);
        View findViewById = this.E.findViewById(R.id.f33130vm);
        this.Q = findViewById;
        findViewById.setOnClickListener(this);
        this.L = (RecyclerView) this.E.findViewById(R.id.f34460z8);
        this.M = (QFSConfigGuideFollowHintView) this.E.findViewById(R.id.f39621c6);
        this.P = (FrameLayout) this.E.findViewById(R.id.f34490za);
        this.R = (RelativeLayout) this.E.findViewById(R.id.f34480z_);
        this.T = this.E.findViewById(R.id.f34430z5);
        this.N = new QFSBottomConfigRecycleAdapter(U());
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(view.getContext());
        safeLinearLayoutManager.setOrientation(0);
        this.L.setLayoutManager(safeLinearLayoutManager);
        this.L.addItemDecoration(new b());
        this.L.setAdapter(this.N);
        this.U = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomConfigGuideFollowView.4
            @Override // java.lang.Runnable
            public void run() {
                if (QFSFeedBottomConfigGuideFollowView.this.Z()) {
                    return;
                }
                QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[mPopRunnable] open with ani");
                QFSFeedBottomConfigGuideFollowView.this.f0();
                r.U0(((com.tencent.biz.qqcircle.immersive.views.banner.bottom.c) QFSFeedBottomConfigGuideFollowView.this).f90601d, true);
            }
        };
    }

    private void d0() {
        if (Z()) {
            K();
            N(false);
        } else {
            f0();
            N(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        this.S.startAnimation(alphaAnimation);
        this.S.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        if (X()) {
            Q();
            s0();
        } else {
            P();
        }
        r.T0(this.f90601d, true);
        n0(true);
        j0();
        J();
        q0();
        QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "openWithAni traceId:" + ba.c(this.f90601d) + "|feedId:" + this.f90601d.g().f398449id.get());
        R();
    }

    private void g0() {
        int i3;
        if (this.P != null && this.L != null && this.S != null) {
            boolean t06 = r.t0(this.f90601d);
            FrameLayout frameLayout = this.P;
            int i16 = 0;
            if (t06) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
            ViewGroup viewGroup = this.S;
            if (t06) {
                i16 = 4;
            }
            viewGroup.setVisibility(i16);
            QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[recoverRecStatus] isOpen:" + t06 + "| isOpen():" + Z() + "| traceId:" + ba.c(this.f90601d) + "| feedId:" + this.f90601d.g().f398449id.get());
            return;
        }
        QLog.e("QFSFeedBottomConfigGuideFollowView", 1, "[recoverRecStatus] mBottomListFrame || mRecycleView || mInfoView is null");
    }

    private void i0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, S());
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.P.startAnimation(animationSet);
        animationSet.setAnimationListener(new d());
    }

    private void j0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, S(), 0.0f);
        translateAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.P.setVisibility(0);
        this.P.startAnimation(animationSet);
    }

    private void k0() {
        r.U0(this.f90601d, false);
        r.T0(this.f90601d, false);
    }

    private void l0() {
        HashMap hashMap = new HashMap();
        for (FeedCloudMeta$StUser feedCloudMeta$StUser : r.m(this.f90601d)) {
            if (feedCloudMeta$StUser != null && !QCircleFollowManager.getInstance().isUinFollowed(feedCloudMeta$StUser.f398463id.get())) {
                hashMap.put(feedCloudMeta$StUser.f398463id.get(), 1);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleMultiFollowUpdateEvent(hashMap));
    }

    private void m0() {
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar = this.f90651d0;
        if (aVar != null) {
            aVar.E(new n());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(boolean z16) {
        if (z16) {
            this.J.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183183ih));
            this.K.setRotation(0.0f);
        } else {
            this.J.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f183193ii));
            this.K.setRotation(180.0f);
        }
        o0(z16);
    }

    private void o0(boolean z16) {
        if (this.I != null && this.F != null) {
            QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[setLeftTopStatus] isOpen = " + z16 + ", mType =" + this.V);
            if (z16) {
                int i3 = this.V;
                if (i3 == 2) {
                    this.I.setVisibility(8);
                    this.F.setVisibility(0);
                    r0(r.k0(r.m(this.f90601d)));
                    return;
                } else if (i3 == 1) {
                    this.F.setVisibility(8);
                    this.I.setVisibility(0);
                    this.I.setText(this.Y);
                    return;
                } else {
                    this.F.setVisibility(8);
                    this.I.setVisibility(0);
                    this.I.setText("");
                    return;
                }
            }
            this.F.setVisibility(8);
            this.I.setVisibility(0);
            if (X()) {
                this.I.setText(this.X);
                return;
            } else {
                this.I.setText(this.W);
                return;
            }
        }
        QLog.e("QFSFeedBottomConfigGuideFollowView", 1, "[setLeftTopStatus] mTitleDes || mFollowAllWrapper should not be null");
    }

    private void p0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, S());
        translateAnimation.setDuration(200L);
        this.R.startAnimation(translateAnimation);
    }

    private void q0() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, S(), 0.0f);
        translateAnimation.setDuration(200L);
        this.R.startAnimation(translateAnimation);
    }

    private void r0(boolean z16) {
        int i3;
        TextView textView = this.H;
        if (textView != null && this.G != null) {
            int i16 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            LinearLayout linearLayout = this.G;
            if (z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
            this.G.setClickable(!z16);
            if (this.G.getVisibility() == 0) {
                L(10);
            }
        }
    }

    private void s0() {
        if (X()) {
            int dimension = (int) T().getResources().getDimension(R.dimen.d08);
            ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
            if (layoutParams.height != dimension) {
                layoutParams.height = dimension;
                this.L.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
            if (layoutParams.height != dimension) {
                layoutParams.height = dimension;
                this.M.setLayoutParams(layoutParams2);
            }
        }
    }

    private void t0(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        String g16 = bj.g(this.f90602e);
        if (!TextUtils.equals(this.Z, g16) || !TextUtils.equals(qCircleFollowUpdateEvent.mUserId, this.f90648a0)) {
            if (QLog.isDebugVersion()) {
                QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[updateShowUserFollowStatus] follow uin :" + qCircleFollowUpdateEvent.mUserId + ", follow state : " + qCircleFollowUpdateEvent.mFollowStatus);
            }
            this.Z = g16;
            this.f90648a0 = qCircleFollowUpdateEvent.mUserId;
        }
        QCircleFollowManager.getInstance().setUinFollowed(qCircleFollowUpdateEvent.mUserId, qCircleFollowUpdateEvent.mFollowStatus);
        r0(r.k0(r.m(this.f90601d)));
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.g) {
            V((com.tencent.biz.qqcircle.immersive.feed.event.g) hVar);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 122;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void h(e30.b bVar, int i3) {
        super.h(bVar, i3);
        if (bVar != null) {
            this.f90602e = bVar.g();
        }
        this.W = this.f90602e.feedDrawerBase.desc.get();
        this.Y = this.f90602e.feedDrawerBase.drawerDesc.get();
        QLog.d(m(), 1, "onBindData, " + hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (r.W(this.f90601d)) {
            return r.R(this.f90601d);
        }
        return X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public String m() {
        return "QFSFeedBottomConfigGuideFollowView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f33130vm) {
            d0();
        } else if (id5 == R.id.f34400z2) {
            W();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (r.R(this.f90601d)) {
            O();
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[onElementActivated]");
        c0(this.f90604h);
        View view = this.E;
        if (view == null) {
            QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[onElementActivated] mInflateView is null");
            return;
        }
        view.setVisibility(0);
        g0();
        H();
        if (X()) {
            I();
            n().post(this.U);
            if (this.f90649b0) {
                QFSFeedBottomPYMLFeatManager.f90657a.j();
            }
        } else if (!r.l(this.f90601d)) {
            I();
            n().postDelayed(this.U, 3000L);
        }
        m0();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        QLog.d("QFSFeedBottomConfigGuideFollowView", 1, "[onElementInactivated]");
        I();
        View view = this.E;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        k0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            t0((QCircleFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSSeekEvent) {
            M((QFSSeekEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        I();
        k0();
        this.f90649b0 = false;
        i.f90684a.c(null);
        QLog.d(m(), 1, "onDetached, " + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedBottomConfigGuideFollowView.this.S.setVisibility(4);
            QFSFeedBottomConfigGuideFollowView.this.T.setVisibility(4);
            VideoReport.traversePage(QFSFeedBottomConfigGuideFollowView.this.L);
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
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedBottomConfigGuideFollowView.this.P.setVisibility(8);
            QFSFeedBottomConfigGuideFollowView.this.T.setVisibility(0);
            QFSFeedBottomConfigGuideFollowView.this.e0();
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
