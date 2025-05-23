package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePushEffectTipInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSCircleProgressView;
import com.tencent.biz.qqcircle.immersive.views.QFSOpenPushBoxLayout;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePushButtonResPackage;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.qqcircle.widgets.QFSPushRocketAnimView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bc extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {

    /* renamed from: i0, reason: collision with root package name */
    private static boolean f86002i0 = uq3.g.c(true, false).getBoolean("sp_key_is_showed_push_tips", false);
    private FrameLayout I;
    private QCircleRecommendImageView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private QFSCircleProgressView N;
    private QFSOpenPushBoxLayout P;
    private QCircleRocketView Q;
    private ImageView R;
    private ImageView S;
    private QFSPushRocketAnimView T;
    private ImageView U;
    private FeedCloudMeta$PushBoxViewInfo W;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f86007e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f86008f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f86009g0;

    /* renamed from: h0, reason: collision with root package name */
    private e30.b f86010h0;
    private boolean V = true;
    private int X = 0;
    private int Y = 0;
    private int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    private long f86003a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f86004b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private int f86005c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private String f86006d0 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86011d;

        a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f86011d = feedCloudMeta$StFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.f86011d.poster;
            if (feedCloudMeta$StUser != null && QCirclePluginUtil.isOwner(feedCloudMeta$StUser.f398463id.get())) {
                bc.this.N1();
            } else {
                QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
                bc.this.J.setOnPushBtnClickDelegate(null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QCircleRecommendImageView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.d
        public void a() {
            bc.this.M1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements QCircleRecommendImageView.e {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.e
        public void a() {
            bc.this.G1();
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.e
        public void b(com.tencent.biz.qqcircle.push.a aVar) {
            bc.this.X1(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements QFSOpenPushBoxLayout.a {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends QFSAsyncUtils.Callback<FeedCloudMeta$StFeed, e40.h> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86016a;

        e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f86016a = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e40.h doBackgroundAction(FeedCloudMeta$StFeed... feedCloudMeta$StFeedArr) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f86016a;
            if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.busiData != null) {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                try {
                    qQCircleFeedBase$StFeedBusiReqData.mergeFrom(this.f86016a.busiData.get().toByteArray());
                    QCirclePushInfoManager.e().p(this.f86016a.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
            return null;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(e40.h hVar) {
            if (hVar != null && hVar.a() != null) {
                bc.this.f2(hVar.a().totalClickCount.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f extends QFSAsyncUtils.Callback<Void, Void> {
        f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            db0.d dVar = new db0.d();
            QCircleExtraTypeInfo qCircleExtraTypeInfo = bc.this.D;
            if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
                dVar.c(ua0.c.c(feedCloudMeta$StFeed).setActionType(34).setSubActionType(2).setToUin(bc.this.D.mFeed.poster.f398463id.get()).setPosition(bc.this.D.mDataPosition).setPlayScene(bc.this.D.mPlayScene).setPageId(bc.this.D.pageType).setExt10(ua0.c.f(bc.this.m0())));
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(bc.this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(bc.this.f85018i + 1));
            T t16 = bc.this.f85017h;
            if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null && ((FeedCloudMeta$StFeed) t16).poster.f398463id != null) {
                buildElementParams.put("xsj_target_qq", ((FeedCloudMeta$StFeed) t16).poster.f398463id.get());
            }
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            if (buildElementParams.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID)) {
                QLog.d("QFSFeedChildPushPresenter", 1, "element param key : xsj_layer_page_ref_eid = " + buildElementParams.get(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            Map<String, Object> S = bc.this.S(buildElementParams);
            S.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) bc.this.C.findViewById(R.id.f40181do))));
            VideoReport.setElementId(bc.this.J, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_ROCKET);
            VideoReport.setElementClickPolicy(bc.this.J, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(bc.this.J, ExposurePolicy.REPORT_NONE);
            dVar.d(QCircleDaTongConstant.EventId.EV_XSJ_PUSH, bc.this.J, S);
            if (bc.this.J == null) {
                return null;
            }
            bc.this.J.setPushReportReqInterceptor(dVar);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class g extends QFSAsyncUtils.Callback<Void, Void> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements IDynamicParams {
            a() {
            }

            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String str) {
                return bc.this.z1();
            }
        }

        g() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            VideoReport.setElementId(bc.this.M, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_ROCKET);
            VideoReport.setEventDynamicParams(bc.this.M, new a());
            VideoReport.setElementExposePolicy(bc.this.M, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(bc.this.M, ClickPolicy.REPORT_ALL);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class h extends QFSAsyncUtils.Callback<Void, Void> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements IDynamicParams {
            a() {
            }

            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String str) {
                Map<String, Object> z16 = bc.this.z1();
                z16.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_NEXT_BOX_TYPE, Integer.valueOf(bc.this.Y));
                if (bc.this.W != null) {
                    z16.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_BOX_PROGRESS, Float.valueOf(bc.this.W.loading.get()));
                }
                return z16;
            }
        }

        h() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            VideoReport.setElementId(bc.this.N, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_PROGRESS);
            VideoReport.setEventDynamicParams(bc.this.N, new a());
            VideoReport.setElementExposePolicy(bc.this.N, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(bc.this.N, ClickPolicy.REPORT_ALL);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class i extends QFSAsyncUtils.Callback<Void, Void> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements IDynamicParams {
            a() {
            }

            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String str) {
                int i3;
                Map<String, Object> z16 = bc.this.z1();
                z16.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_BOX_TYPE, Integer.valueOf(bc.this.Y));
                if (bc.this.X == 3) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                z16.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSH_BUTTON_EXPAND_BOX_TYPE, Integer.valueOf(i3));
                return z16;
            }
        }

        i() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            VideoReport.setElementId(bc.this.P, QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_BOX);
            VideoReport.setEventDynamicParams(bc.this.P, new a());
            VideoReport.setElementExposePolicy(bc.this.P, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(bc.this.P, ClickPolicy.REPORT_ALL);
            return null;
        }
    }

    private void A1() {
        da0.b resManager = QCircleChangeResEngine.INSTANCE.getResManager(QCirclePushButtonResPackage.class);
        if (resManager.e().o().isDefaultRes) {
            return;
        }
        final QCirclePushEffectTipInfo z16 = ((ea0.b) resManager).z();
        if (z16 != null && !TextUtils.isEmpty(z16.pushTipInfo)) {
            final String q16 = com.tencent.biz.qqcircle.f.v().q();
            if (TextUtils.equals(z16.version, q16)) {
                return;
            }
            mc0.a.d(m0(), z16.pushTipInfo).setAnchor(this.J).setPosition(2).setAlignment(0).addStatusCallback(new RFWSmartPopupWindow.IStatusCallback() { // from class: com.tencent.biz.qqcircle.immersive.feed.bb
                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onClick(View view) {
                    a04.d.a(this, view);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public /* synthetic */ void onDismiss() {
                    a04.d.b(this);
                }

                @Override // com.tencent.richframework.widget.popupwindow.RFWSmartPopupWindow.IStatusCallback
                public final void onShow() {
                    bc.J1(QCirclePushEffectTipInfo.this, q16);
                }
            });
            return;
        }
        QLog.d("QFSFeedChildPushPresenter", 1, "QCircleRefreshPushEffect checkAndShowDiffResTips pushTipInfo is null");
    }

    private void B1() {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void C1() {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setVisibility(8);
        }
    }

    private void D1() {
        TextView textView = this.L;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void E1() {
        QFSOpenPushBoxLayout qFSOpenPushBoxLayout = this.P;
        if (qFSOpenPushBoxLayout != null) {
            qFSOpenPushBoxLayout.setVisibility(8);
        }
    }

    private void F1() {
        QFSCircleProgressView qFSCircleProgressView = this.N;
        if (qFSCircleProgressView != null) {
            qFSCircleProgressView.setVisibility(8);
        }
        ImageView imageView = this.R;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        if (this.T == null) {
            ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f41091g5);
            if (viewStub != null && viewStub.getParent() != null && viewStub.getRootView() != null) {
                QFSPushRocketAnimView qFSPushRocketAnimView = (QFSPushRocketAnimView) viewStub.inflate().findViewById(R.id.f41081g4);
                this.T = qFSPushRocketAnimView;
                ImageView imageView = (ImageView) qFSPushRocketAnimView.findViewById(R.id.f5103270);
                this.U = imageView;
                imageView.setVisibility(0);
            } else {
                QLog.d("QFSFeedChildPushPresenter", 1, "view stub is null");
                return;
            }
        }
        u1(this.T, true);
    }

    private void H1() {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView == null) {
            return;
        }
        qCircleRecommendImageView.setContentDescription("\u706b\u7bad");
        this.J.setPageType(5);
        this.J.setEnableCancelPush(true);
        this.J.setUnPushIconId(com.tencent.biz.qqcircle.k.j());
        this.J.setPushedIconId(com.tencent.biz.qqcircle.k.i());
        this.J.setMaxPushedIconId(com.tencent.biz.qqcircle.k.h());
    }

    private void I1(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f40501ej);
        this.I = frameLayout;
        frameLayout.setVisibility(0);
        this.K = (TextView) this.I.findViewById(R.id.y7d);
        QCircleRecommendImageView qCircleRecommendImageView = (QCircleRecommendImageView) this.I.findViewById(R.id.dvj);
        this.J = qCircleRecommendImageView;
        S1(qCircleRecommendImageView);
        H1();
        this.M = (ImageView) this.I.findViewById(R.id.f509726u);
        this.N = (QFSCircleProgressView) this.I.findViewById(R.id.f348810c);
        this.L = (TextView) this.I.findViewById(R.id.f505125l);
        this.P = (QFSOpenPushBoxLayout) this.I.findViewById(R.id.f48061yz);
        this.Q = (QCircleRocketView) this.I.findViewById(R.id.u26);
        this.R = (ImageView) this.I.findViewById(R.id.f348710b);
        this.S = (ImageView) this.I.findViewById(R.id.f348610a);
        x1();
        w1();
        y1();
        v1();
        P1();
        Q1();
        O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J1(QCirclePushEffectTipInfo qCirclePushEffectTipInfo, String str) {
        com.tencent.biz.qqcircle.f.v().Q(qCirclePushEffectTipInfo.version);
        QLog.d("QFSFeedChildPushPresenter", 1, "QCircleRefreshPushEffect show pushTipInfo :" + qCirclePushEffectTipInfo + ",old version:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M1() {
        if (s0() == null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "feed ioc is null");
        } else {
            s0().onHandlerMessage("event_open_push_mission_panel", this.f86006d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void N1() {
        t40.a s06 = s0();
        if (s06 == null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "[openPushPanel] feed ioc should not be null.");
            return;
        }
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.E;
        qFSCommentInfo.mFeed = (FeedCloudMeta$StFeed) this.f85017h;
        qFSCommentInfo.mReportBean = getReportBean();
        QFSCommentInfo.ActionBean actionBean = new QFSCommentInfo.ActionBean();
        actionBean.mShowCommentPanelTabIndex = 2;
        qFSCommentInfo.mActionBean = actionBean;
        s06.onHandlerMessage("event_open_comment", qFSCommentInfo);
    }

    private void O1() {
        QFSAsyncUtils.executeSub(new i(), new Void[0]);
    }

    private void P1() {
        QFSAsyncUtils.executeSub(new g(), new Void[0]);
    }

    private void Q1() {
        QFSAsyncUtils.executeSub(new h(), new Void[0]);
    }

    private void R1() {
        this.f86007e0 = false;
        this.f86008f0 = false;
        this.f86009g0 = false;
        this.f86005c0 = 0;
        QFSPushRocketAnimView qFSPushRocketAnimView = this.T;
        if (qFSPushRocketAnimView != null) {
            qFSPushRocketAnimView.q();
            this.T.u();
            this.T.setVisibility(8);
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setAlpha(1.0f);
            this.S.setScaleX(1.0f);
            this.S.setScaleY(1.0f);
            this.S.setVisibility(8);
        }
    }

    private void S1(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.requestFocusFromTouch();
        }
    }

    private void T1(ImageView imageView) {
        if (imageView != null && this.W != null) {
            imageView.setVisibility(0);
            if (this.W.boxType.get() == 2) {
                imageView.setImageResource(R.drawable.orn);
            } else {
                imageView.setImageResource(R.drawable.oro);
            }
        }
    }

    private void V1() {
        ImageView imageView = this.M;
        if (imageView != null && this.K != null) {
            imageView.setVisibility(0);
            Z1();
            this.M.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187823v1) + ((Object) this.K.getText()));
        }
        C1();
        F1();
        D1();
        E1();
    }

    private void W1(FeedCloudMeta$StPushList feedCloudMeta$StPushList, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setVisibility(0);
            B1();
            F1();
            D1();
            E1();
            a2();
        }
        if (feedCloudMeta$StPushList != null) {
            f2(feedCloudMeta$StPushList.totalClickCount.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(com.tencent.biz.qqcircle.push.a aVar) {
        if (aVar != null && aVar.b() && this.T != null && this.U != null) {
            if (aVar.a() == 0) {
                this.Z = 0;
            } else {
                this.Z = aVar.c();
            }
            this.f86005c0 = aVar.a();
            this.T.setPushRocketCount(this.Z);
            this.T.setFeedId(this.f86006d0);
            this.T.setVisibility(0);
            if (!this.f86008f0 && this.f86005c0 != 0) {
                QLog.d("QFSFeedChildPushPresenter", 1, "set big img box ");
                T1(this.S);
                this.f86008f0 = true;
            }
            if (this.f86005c0 == 0) {
                Z1();
                V1();
            }
            this.T.s(this.f86005c0, this.U);
            RFWLog.d("QFSFeedChildPushPresenter", RFWLog.USR, "test push type is " + this.f86005c0);
        }
    }

    private void Z1() {
        TextView textView = this.K;
        if (textView != null && !this.f86009g0) {
            textView.setVisibility(0);
        }
    }

    private void a2() {
        QFSAsyncUtils.executeSub(new f(), new Void[0]);
    }

    private void c2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.dittoFeed.dittoId.get() == 33) {
            uq3.c.h7("qqcircle", "qqcircle_push_rocket_game_enable", "1");
        }
    }

    private void d2() {
        boolean z16;
        TextView textView;
        FeedCloudMeta$PushBoxViewInfo feedCloudMeta$PushBoxViewInfo = this.W;
        if (feedCloudMeta$PushBoxViewInfo == null) {
            return;
        }
        this.X = feedCloudMeta$PushBoxViewInfo.viewType.get();
        this.Y = this.W.boxType.get();
        long j3 = this.W.drawCount.get();
        this.f86003a0 = j3;
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(j3, 11));
        }
        if (this.X == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.V = z16;
        if (!z16 && (textView = this.L) != null) {
            if (!this.f86007e0) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
        }
    }

    private void e2(String str) {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView == null) {
            return;
        }
        qCircleRecommendImageView.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(int i3) {
        TextView textView = this.K;
        if (textView == null) {
            return;
        }
        if (i3 < 0) {
            QLog.d("QFSFeedChildPushPresenter", 1, "[updatePushCount] pushCount < 0, pushCount: " + i3);
            return;
        }
        if (i3 == 0) {
            textView.setText(R.string.f184613mc);
            this.K.setTextSize(1, 11.0f);
            e2(com.tencent.biz.qqcircle.utils.h.a(R.string.f184613mc));
        } else {
            textView.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(i3, 11));
            this.K.setTextSize(1, 12.0f);
            e2(com.tencent.biz.qqcircle.utils.h.a(R.string.f187823v1) + ((Object) this.K.getText()));
        }
    }

    private void g2(Object obj) {
        if (obj instanceof QQCircleFeedBase$StFeedBusiReqData) {
            f2(((QQCircleFeedBase$StFeedBusiReqData) obj).pushList.totalClickCount.get());
        }
    }

    private void h2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StPushList f16;
        if (feedCloudMeta$StFeed == null || (f16 = QCirclePushInfoManager.e().f(feedCloudMeta$StFeed.f398449id.get())) == null) {
            return;
        }
        QLog.d("QFSFeedChildPushPresenter", 1, "show original push btn1");
        W1(f16, feedCloudMeta$StFeed);
        f2(f16.totalClickCount.get());
    }

    private void u1(View view, boolean z16) {
        LinearLayout linearLayout;
        int height;
        int height2;
        if (view != null && (linearLayout = (LinearLayout) this.C.findViewById(R.id.f33120vl)) != null && this.I != null && this.J != null) {
            if (z16) {
                height = linearLayout.getHeight() - this.I.getBottom();
                height2 = this.I.getHeight() / 2;
            } else {
                height = linearLayout.getHeight() - this.I.getBottom();
                height2 = this.I.getHeight() - this.J.getBottom();
            }
            int i3 = height + height2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.bottomMargin = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    private void v1() {
        QFSOpenPushBoxLayout qFSOpenPushBoxLayout = this.P;
        if (qFSOpenPushBoxLayout == null) {
            return;
        }
        qFSOpenPushBoxLayout.setOpenPushBoxResponseListener(new d());
    }

    private void w1() {
        QFSCircleProgressView qFSCircleProgressView = this.N;
        if (qFSCircleProgressView == null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "push progress btn is null");
        } else {
            qFSCircleProgressView.setOnClickListener(this);
        }
    }

    private void x1() {
        QFSOpenPushBoxLayout qFSOpenPushBoxLayout = this.P;
        if (qFSOpenPushBoxLayout == null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "push box btn is null");
        } else {
            qFSOpenPushBoxLayout.setOnClickListener(this);
        }
    }

    private void y1() {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView == null) {
            return;
        }
        qCircleRecommendImageView.setRecommendViewActionListener(new b());
        this.J.setOverPushListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, Object> z1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(this.E));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null && ((FeedCloudMeta$StFeed) t16).poster.f398463id != null) {
            buildElementParams.put("xsj_target_qq", ((FeedCloudMeta$StFeed) t16).poster.f398463id.get());
        }
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        if (buildElementParams.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID)) {
            QLog.d("QFSFeedChildPushPresenter", 1, "element param key : xsj_layer_page_ref_eid = " + buildElementParams.get(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID));
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        return S(buildElementParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return com.tencent.biz.qqcircle.manager.i.a("qfs_feed_push_show");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        this.f86006d0 = feedCloudMeta$StFeed.f398449id.get();
        c2(feedCloudMeta$StFeed);
        h2(feedCloudMeta$StFeed);
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setOnClickListener(new a(feedCloudMeta$StFeed));
        }
        if (this.J != null && this.K != null) {
            QLog.d("QFSFeedChildPushPresenter", 1, "show original push btn2");
            this.J.setFeedData(this.E, 5);
            this.J.setVisibility(0);
            Z1();
            U1(feedCloudMeta$StFeed);
        }
        this.f86010h0 = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.f86010h0, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            g2(bVar.b("DITTO_FEED_BUSI_REQ_DATA"));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        I1(view);
    }

    public void U1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.busiData.get() != null) {
            QFSAsyncUtils.executeSerial(new e(feedCloudMeta$StFeed), feedCloudMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        return super.getEventClass();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        R1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        R1();
        d2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (E0()) {
            A1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.onStop();
        }
        super.onStop(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildPushPresenter";
    }
}
