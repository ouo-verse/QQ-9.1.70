package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ct extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements Observer<e30.b>, View.OnClickListener {
    private FrameLayout I;
    private QCircleRecommendImageView J;
    private TextView K;
    private QCircleRocketView L;
    private ViewStub M;
    private e30.b N;
    private final int P = 5;
    private QCircleRecommendImageView.f Q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QCircleRecommendImageView.f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.f
        public boolean a() {
            return false;
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
            ct.this.D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends QFSAsyncUtils.Callback<FeedCloudMeta$StFeed, e40.h> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f85578a;

        c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f85578a = feedCloudMeta$StFeed;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e40.h doBackgroundAction(FeedCloudMeta$StFeed... feedCloudMeta$StFeedArr) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f85578a;
            if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.busiData != null) {
                QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
                try {
                    qQCircleFeedBase$StFeedBusiReqData.mergeFrom(this.f85578a.busiData.get().toByteArray());
                    QCirclePushInfoManager.e().p(this.f85578a.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
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
                ct.this.H1(hVar.a().totalClickCount.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d extends QFSAsyncUtils.Callback<Void, Void> {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            db0.d dVar = new db0.d();
            if (((QFSBaseFeedChildPresenter) ct.this).D != null && ((QFSBaseFeedChildPresenter) ct.this).D.mFeed != null) {
                dVar.c(ua0.c.c(((QFSBaseFeedChildPresenter) ct.this).D.mFeed).setActionType(34).setSubActionType(2).setToUin(((QFSBaseFeedChildPresenter) ct.this).D.mFeed.poster.f398463id.get()).setPosition(((QFSBaseFeedChildPresenter) ct.this).D.mDataPosition).setPlayScene(((QFSBaseFeedChildPresenter) ct.this).D.mPlayScene).setPageId(((QFSBaseFeedChildPresenter) ct.this).D.pageType).setExt10(ua0.c.f(ct.this.m0())));
            }
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(((QFSBaseFeedChildPresenter) ct.this).E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(((QFSBaseFeedChildPresenter) ct.this).f85018i + 1));
            if (((QFSBaseFeedChildPresenter) ct.this).f85017h != null && ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) ct.this).f85017h).poster != null && ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) ct.this).f85017h).poster.f398463id != null) {
                buildElementParams.put("xsj_target_qq", ((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) ct.this).f85017h).poster.f398463id.get());
            }
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            if (buildElementParams.containsKey(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID)) {
                QLog.d("QFSFeedChildAdPushPresenter", 1, "element param key : xsj_layer_page_ref_eid = " + buildElementParams.get(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID));
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            Map<String, Object> S = ct.this.S(buildElementParams);
            S.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) ((QFSBaseFeedChildPresenter) ct.this).C.findViewById(R.id.f40181do))));
            dVar.d(QCircleDaTongConstant.EventId.EV_XSJ_PUSH, ((QFSBaseFeedChildPresenter) ct.this).C, S);
            if (ct.this.J == null) {
                return null;
            }
            ct.this.J.setPushReportReqInterceptor(dVar);
            return null;
        }
    }

    private void A1() {
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView == null) {
            return;
        }
        qCircleRecommendImageView.setRecommendViewActionListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void D1() {
        String str;
        if (s0() == null) {
            QLog.d("QFSFeedChildAdPushPresenter", 1, "feed ioc is null");
            return;
        }
        t40.a s06 = s0();
        Object[] objArr = new Object[1];
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        objArr[0] = str;
        s06.onHandlerMessage("event_open_push_mission_panel", objArr);
    }

    private void E1(View view) {
        if (view == null) {
            return;
        }
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.requestFocusFromTouch();
    }

    private void G1() {
        QFSAsyncUtils.executeSub(new d(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1(int i3) {
        TextView textView = this.K;
        if (textView != null && i3 >= 0) {
            if (i3 == 0) {
                textView.setText(R.string.f184613mc);
                this.K.setTextSize(1, 11.0f);
                return;
            } else {
                textView.setText(com.tencent.biz.qqcircle.immersive.utils.r.d(i3, 11));
                this.K.setTextSize(1, 12.0f);
                return;
            }
        }
        QLog.d("QFSFeedChildAdPushPresenter", 1, "[updatePushFeedDataText] mFeedPushText should not be null.");
    }

    private void I1(Object obj) {
        if (obj instanceof QQCircleFeedBase$StFeedBusiReqData) {
            H1(((QQCircleFeedBase$StFeedBusiReqData) obj).pushList.totalClickCount.get());
        }
    }

    private void J1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null) {
            qCircleRecommendImageView.setVisibility(0);
            this.J.setFeedData(this.E, 5);
            G1();
        }
        QCircleRocketView qCircleRocketView = this.L;
        if (qCircleRocketView != null) {
            qCircleRocketView.setFeedId(feedCloudMeta$StFeed.f398449id.get());
            this.L.setPageType(5);
            this.L.setFeedType(feedCloudMeta$StFeed.feedType.get());
        }
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(feedCloudMeta$StFeed.f398449id.get());
        if (f16 != null) {
            H1(f16.totalClickCount.get());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K1() {
        if (this.J == null) {
            return;
        }
        if (((FeedCloudMeta$StFeed) this.f85017h).opMask2.get().contains(24)) {
            this.Q = new a();
            T t16 = this.f85017h;
            if (((FeedCloudMeta$StFeed) t16).poster != null && QCirclePluginUtil.isOwner(((FeedCloudMeta$StFeed) t16).poster.f398463id.get())) {
                this.J.setOnPushBtnClickDelegate(this.Q);
            }
            this.J.setEnableCancelPush(true);
            this.J.setOnClickListener(null);
            A1();
            return;
        }
        this.J.setOnPushBtnClickDelegate(null);
        this.J.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSFeedChildAdPushPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        J1(feedCloudMeta$StFeed);
        K1();
        QCircleRecommendImageView qCircleRecommendImageView = this.J;
        if (qCircleRecommendImageView != null && this.K != null) {
            qCircleRecommendImageView.setVisibility(0);
            this.K.setVisibility(0);
            F1(feedCloudMeta$StFeed);
        }
        this.N = new e30.b(feedCloudMeta$StFeed);
        w20.a.j().observerGlobalState(this.N, this);
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar == null) {
            return;
        }
        I1(bVar.b("DITTO_FEED_BUSI_REQ_DATA"));
    }

    public void F1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.busiData.get() != null) {
            QFSAsyncUtils.executeSerial(new c(feedCloudMeta$StFeed), feedCloudMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f40501ej);
        this.I = frameLayout;
        frameLayout.setVisibility(0);
        this.K = (TextView) this.I.findViewById(R.id.y7d);
        QCircleRecommendImageView qCircleRecommendImageView = (QCircleRecommendImageView) this.I.findViewById(R.id.dvj);
        this.J = qCircleRecommendImageView;
        E1(qCircleRecommendImageView);
        this.J.setContentDescription("\u706b\u7bad");
        this.J.setUnPushIconId(com.tencent.biz.qqcircle.k.j());
        this.J.setPushedIconId(com.tencent.biz.qqcircle.k.i());
        this.J.setMaxPushedIconId(com.tencent.biz.qqcircle.k.h());
        ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f41051g1);
        this.M = viewStub;
        this.L = (QCircleRocketView) viewStub.inflate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleToast.h(R.string.f187913v_, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return null;
    }
}
