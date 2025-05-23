package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSInteractActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildContentQualityFeedbackPresenter;
import com.tencent.biz.qqcircle.immersive.request.QFSGetFeedBottomContentQualityFeedbackGuildRequest;
import com.tencent.biz.qqcircle.immersive.views.QFSFeedBottomContentQualityFeedbackItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.NumberUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StChoiceQuestionBanner;
import feedcloud.FeedCloudRead$StChoiceQuestionBannerOption;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSFeedChildContentQualityFeedbackPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private ViewStub I;
    private View J;
    private LinearLayout K;
    private TextView L;
    private ImageView M;
    private LinearLayout N;
    private ViewGroup P;
    private Runnable Q;
    private String R;
    private String S;
    private String T;
    private int U;
    private long V;
    private int W;
    private String X;
    private boolean Y;
    private t40.c Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f85068a0 = NumberUtil.stringToFloat("-1");

    /* renamed from: b0, reason: collision with root package name */
    private long f85069b0 = NumberUtil.stringToInt("-1");

    /* renamed from: c0, reason: collision with root package name */
    private int f85070c0 = NumberUtil.stringToInt("3");

    /* renamed from: d0, reason: collision with root package name */
    private int f85071d0 = NumberUtil.stringToInt("4");

    /* renamed from: e0, reason: collision with root package name */
    private int f85072e0 = NumberUtil.stringToInt("3");

    /* renamed from: f0, reason: collision with root package name */
    private boolean f85073f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f85074g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f85075h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f85076i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f85077j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildContentQualityFeedbackPresenter$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass4 implements QFSFeedBottomContentQualityFeedbackItemView.a {
        AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(QFSFeedChildContentQualityFeedbackPresenter.this.A1(), 3));
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSFeedBottomContentQualityFeedbackItemView.a
        public void a(final String str) {
            QFSFeedChildContentQualityFeedbackPresenter.this.x0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildContentQualityFeedbackPresenter.4.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildContentQualityFeedbackPresenter.this.F1();
                    QFSFeedChildContentQualityFeedbackPresenter.this.L1(2, str);
                }
            }, 320L);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.QFSFeedBottomContentQualityFeedbackItemView.a
        public void b() {
            QFSFeedChildContentQualityFeedbackPresenter.this.x0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.w
                @Override // java.lang.Runnable
                public final void run() {
                    QFSFeedChildContentQualityFeedbackPresenter.AnonymousClass4.this.d();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String A1() {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            return this.E.g().f398449id.get();
        }
        return "";
    }

    private void B1(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 1) {
            this.Y = qCirclePanelStateEvent.isShowing();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C1(QFSInteractActionEvent qFSInteractActionEvent) {
        if (qFSInteractActionEvent.getInteractActionType() == 6 && this.f85017h != 0 && !TextUtils.equals(qFSInteractActionEvent.getRelationId(), ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get())) {
            return;
        }
        if (qFSInteractActionEvent.getInteractActionType() != 6 && !TextUtils.equals(qFSInteractActionEvent.getRelationId(), A1())) {
            return;
        }
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[handleInteractActionEvent] interact action type = " + qFSInteractActionEvent.getInteractActionType());
        this.f85074g0 = true;
    }

    private void D1(com.tencent.biz.qqcircle.immersive.feed.event.an anVar) {
        this.f85076i0 = anVar.e();
        if (this.f85073f0) {
            return;
        }
        if ((this.f85069b0 != -1 && anVar.e() >= this.f85069b0) || (this.f85068a0 != -1.0f && anVar.b() >= this.f85068a0)) {
            s1();
            this.f85073f0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1() {
        if (this.P == null) {
            QLog.e(getTAG(), 1, "[hideBottomInfoViewWithAniWhenOpen] mBottomInfoView is null");
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(160L);
        alphaAnimation.setAnimationListener(new a());
        this.P.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        if (this.K == null) {
            QLog.e(getTAG(), 1, "[hideFeedbackViewWithAniWhenClose] mContainer is null");
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(160L);
        alphaAnimation.setAnimationListener(new b());
        this.K.startAnimation(alphaAnimation);
    }

    private boolean G1() {
        int e16 = uq3.k.a().e("sp_key_feed_content_quality_feedback_showed_times", 0);
        QLog.i("QFSFeedChildContentQualityFeedbackPresenter", 1, "[isFeedContentQualityFeedbackCanShow] showed times:" + e16 + ", mMaxDisplayCount = " + this.f85072e0);
        if (uq3.n.c(System.currentTimeMillis(), uq3.k.a().f("sp_key_feed_content_quality_feedback_show_timestamp", 0L)) && e16 >= this.f85072e0) {
            QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[isFeedContentQualityFeedbackCanShow] is same day, return.");
            return false;
        }
        if (!com.tencent.biz.qqcircle.utils.bq.e("sp_key_feed_content_quality_feedback_close_key", 1)) {
            return true;
        }
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[isFeedContentQualityFeedbackCanShow] closed during one day, return.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(QFSGetFeedBottomContentQualityFeedbackGuildRequest qFSGetFeedBottomContentQualityFeedbackGuildRequest, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp) {
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[sendReq] requestFeedBottomContentQualityFeedbackGuildData onReceive: dispatch Success:" + z16 + " | TraceId:" + qFSGetFeedBottomContentQualityFeedbackGuildRequest.getTraceId() + " | SeqId:" + qFSGetFeedBottomContentQualityFeedbackGuildRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
        if (z16 && j3 == 0 && feedCloudRead$StFeedDeatilSecondaryLoadRsp != null) {
            com.tencent.biz.qqcircle.immersive.utils.r.W0(this.E, feedCloudRead$StFeedDeatilSecondaryLoadRsp.quality_feedback_banner.get());
            z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        if (this.C == null) {
            QLog.e(getTAG(), 1, "[makeSureInflate] mRootView is null");
            return;
        }
        if (this.I != null) {
            return;
        }
        QLog.d(getTAG(), 1, "[makeSureInflate] do inflate");
        this.I = (ViewStub) this.C.findViewById(R.id.f39741ch);
        this.P = (ViewGroup) this.C.findViewById(R.id.f34500zb);
        View inflate = this.I.inflate();
        this.J = inflate;
        this.K = (LinearLayout) inflate.findViewById(R.id.f39691cc);
        t1();
        this.L = (TextView) this.J.findViewById(R.id.f39751ci);
        this.N = (LinearLayout) this.J.findViewById(R.id.f39731cg);
        ImageView imageView = (ImageView) this.J.findViewById(R.id.f39681cb);
        this.M = imageView;
        imageView.setOnClickListener(this);
    }

    private void K1() {
        ViewGroup viewGroup = this.P;
        if (viewGroup != null && this.K != null) {
            viewGroup.setVisibility(0);
            this.K.setVisibility(8);
        } else {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[recoverRecStatus] mBottomInfoView || mContainer is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void L1(int i3, String str) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) this.f85017h).setActionType(131).setSubActionType(i3).setExt10(str).setVideoPlayTime(this.f85076i0).setPageId(y0())));
    }

    private void M1() {
        x1();
        K1();
        this.f85074g0 = false;
        this.f85073f0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        if (this.P == null) {
            QLog.e(getTAG(), 1, "[showBottomInfoViewWithAniWhenClose] mBottomInfoView is null");
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(160L);
        this.P.startAnimation(alphaAnimation);
        this.P.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        if (this.K == null) {
            QLog.e(getTAG(), 1, "[showFeedbackViewWithAniWhenOpen] mContainer is null");
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(160L);
        this.K.startAnimation(alphaAnimation);
        this.K.setVisibility(0);
        uq3.k.a().n("sp_key_feed_content_quality_feedback_show_timestamp", System.currentTimeMillis());
        uq3.k.a().m("sp_key_feed_content_quality_feedback_showed_times", uq3.k.a().e("sp_key_feed_content_quality_feedback_showed_times", 0) + 1);
        com.tencent.biz.qqcircle.utils.bq.i("sp_key_feed_content_quality_feedback_show_pos", this.f85075h0, this.f85071d0);
        com.tencent.biz.qqcircle.immersive.utils.r.V0(this.E, true);
        L1(1, "");
    }

    private void Q1() {
        HashMap hashMap = new HashMap();
        hashMap.put("beginTime", "-1");
        hashMap.put("beginRatio", "-1");
        hashMap.put("minBeginIndex", "3");
        hashMap.put("minDeltaIndex", "4");
        hashMap.put("maxDisplayCount", "3");
        Map<String, String> M = uq3.o.M("qqcircle_video_feed_back_trigger_config", hashMap);
        this.f85069b0 = NumberUtil.stringToLong(M.get("beginTime"));
        this.f85068a0 = NumberUtil.stringToFloat(M.get("beginRatio"));
        this.f85070c0 = NumberUtil.stringToInt(M.get("minBeginIndex"));
        this.f85071d0 = NumberUtil.stringToInt(M.get("minDeltaIndex"));
        this.f85072e0 = NumberUtil.stringToInt(M.get("maxDisplayCount"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s1() {
        if (!G1()) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] the feed should not show content quality feedback. feed = " + A1());
            return;
        }
        if (!com.tencent.biz.qqcircle.utils.bq.f("sp_key_feed_content_quality_feedback_show_pos", this.f85075h0, this.f85071d0)) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] delta is not satisfied. mPos = " + this.f85075h0 + ", feed = " + A1() + ", mMinDeltaIndex = " + this.f85071d0);
            return;
        }
        if (this.f85075h0 < this.f85070c0 - 1) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] mPos = " + this.f85075h0 + ", feed = " + A1() + ", mMinBeginIndex = " + this.f85070c0);
            return;
        }
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).type.get() == 3) {
            T t17 = this.f85017h;
            if (t17 != 0 && ((FeedCloudMeta$StFeed) t17).buttomBanner.style_type.get() != 1 && ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.style_type.get() != 1 && ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.style_type.get() != 4) {
                if (!com.tencent.biz.qqcircle.immersive.utils.r.S(this.E)) {
                    QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] the feed not contains content quality feedback. feed = " + A1());
                    return;
                }
                if (com.tencent.biz.qqcircle.immersive.utils.r.n(this.E) == null) {
                    QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] do secondary request. feed = " + A1());
                    N1();
                    return;
                }
                if (!com.tencent.biz.qqcircle.immersive.utils.r.o(this.E)) {
                    QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] do mPopRunnable. feed = " + A1());
                    z1();
                    return;
                }
                return;
            }
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] has another type show. feed = " + A1());
            return;
        }
        QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[active] is not MEDIA_TYPE_VIDEO type. feed = " + A1());
    }

    private void t1() {
        LinearLayout linearLayout = this.K;
        if (linearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        int i3 = (int) (com.tencent.biz.qqcircle.utils.bz.i(this.K.getContext()) * 0.72f);
        if (i3 == this.f85077j0) {
            return;
        }
        this.f85077j0 = i3;
        layoutParams.width = i3;
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[adjustFeedInfoViewSize] params.width: " + layoutParams.width);
        this.K.setLayoutParams(layoutParams);
        this.K.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(FeedCloudRead$StChoiceQuestionBanner feedCloudRead$StChoiceQuestionBanner) {
        String str = feedCloudRead$StChoiceQuestionBanner.title.get();
        this.R = str;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(str);
        } else {
            QLog.e(getTAG(), 1, "[bindData] mTvTitle is null");
        }
        this.S = QCirclePluginUtil.getValueFromListEntry(feedCloudRead$StChoiceQuestionBanner.ext_info.get(), "task_id");
        this.T = QCirclePluginUtil.getValueFromListEntry(feedCloudRead$StChoiceQuestionBanner.ext_info.get(), "tabExp");
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[bindData] mExp =" + this.T);
        w1(feedCloudRead$StChoiceQuestionBanner.options.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.E.g().poster.f398463id.get());
        }
        buildElementParams.put("xsj_tianshu_task_id", this.S);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_TITLE, this.R);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_SUM_NUM, Integer.valueOf(this.U));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDBACK_ITEM_SUM_TEXT, this.X);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_FEEDBACK_ITEM_CONTAIN_EMOJI, Integer.valueOf(this.W));
        VideoReport.setElementId(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_FEED_QUALITY_FEEDBACK_GUIDE_BAR);
        VideoReport.reportEvent("dt_imp", this.K, buildElementParams);
        LinearLayout linearLayout = this.K;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(linearLayout, clickPolicy);
        Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar2 = this.E;
        if (bVar2 != null && bVar2.g() != null) {
            buildElementParams2.put("xsj_feed_id", this.E.g().f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.E.g().poster.f398463id.get());
        }
        buildElementParams2.put("xsj_tianshu_task_id", this.S);
        VideoReport.setElementId(this.M, "em_xsj_close_button");
        VideoReport.reportEvent("dt_imp", this.M, buildElementParams2);
        VideoReport.setElementClickPolicy(this.M, clickPolicy);
    }

    private void w1(List<FeedCloudRead$StChoiceQuestionBannerOption> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[bindOptionListData] bannerOptionList should not be null");
            return;
        }
        LinearLayout linearLayout = this.N;
        if (linearLayout == null) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[bindOptionListData] mOptionsLl should not be null");
            return;
        }
        linearLayout.removeAllViews();
        this.U = list.size();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.U; i3++) {
            QFSFeedBottomContentQualityFeedbackItemView qFSFeedBottomContentQualityFeedbackItemView = new QFSFeedBottomContentQualityFeedbackItemView(m0());
            qFSFeedBottomContentQualityFeedbackItemView.setOnSelectedListener(new AnonymousClass4());
            qFSFeedBottomContentQualityFeedbackItemView.setFeedBlockData(this.E);
            qFSFeedBottomContentQualityFeedbackItemView.setTotalOptions(this.U);
            qFSFeedBottomContentQualityFeedbackItemView.setFeedbackTitle(this.R);
            qFSFeedBottomContentQualityFeedbackItemView.setTaskId(this.S);
            FeedCloudRead$StChoiceQuestionBannerOption feedCloudRead$StChoiceQuestionBannerOption = list.get(i3);
            qFSFeedBottomContentQualityFeedbackItemView.bindData(feedCloudRead$StChoiceQuestionBannerOption, i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((((this.K.getLayoutParams().width - this.K.getPaddingLeft()) - this.K.getPaddingRight()) - ((this.U - 1) * com.tencent.biz.qqcircle.utils.cx.a(8.0f))) / this.U, this.N.getLayoutParams().height);
            if (i3 != 0) {
                layoutParams.leftMargin = com.tencent.biz.qqcircle.utils.cx.a(8.0f);
            }
            qFSFeedBottomContentQualityFeedbackItemView.setLayoutParams(layoutParams);
            this.N.addView(qFSFeedBottomContentQualityFeedbackItemView);
            this.W = !TextUtils.isEmpty(feedCloudRead$StChoiceQuestionBannerOption.icon.get()) ? 1 : 0;
            sb5.append(feedCloudRead$StChoiceQuestionBannerOption.f398470id.get());
            if (i3 < this.U - 1) {
                sb5.append(",");
            }
        }
        this.X = sb5.toString();
    }

    private void x1() {
        if (this.Q != null) {
            x0().removeCallbacks(this.Q);
        }
    }

    private void y1() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
        }
        buildElementParams.put("xsj_tianshu_task_id", this.S);
        buildElementParams.put("play_duration", Long.valueOf(System.currentTimeMillis() - this.V));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
        VideoReport.setElementId(this.M, "em_xsj_close_button");
        VideoReport.reportEvent("dt_clck", this.M, buildElementParams);
        VideoReport.setElementExposePolicy(this.M, ExposurePolicy.REPORT_NONE);
    }

    private void z1() {
        x1();
        x0().post(this.Q);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.an) {
            D1((com.tencent.biz.qqcircle.immersive.feed.event.an) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        Q1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.Q = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildContentQualityFeedbackPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudRead$StChoiceQuestionBanner n3 = com.tencent.biz.qqcircle.immersive.utils.r.n(QFSFeedChildContentQualityFeedbackPresenter.this.E);
                if (n3 == null) {
                    QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[mPopRunnable] stChoiceQuestionBanner should not be null.");
                    return;
                }
                int i3 = n3.type.get();
                if (i3 != 1) {
                    QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[mPopRunnable] is not CHOICE_QUESTION_BANNER_TYPE_QUALITY_FEEDBACK. | type = " + i3);
                    return;
                }
                if (!RFSafeListUtils.isEmpty(n3.options.get())) {
                    QFSFeedChildContentQualityFeedbackPresenter.this.I1();
                    if (QFSFeedChildContentQualityFeedbackPresenter.this.K != null && QFSFeedChildContentQualityFeedbackPresenter.this.P != null && QFSFeedChildContentQualityFeedbackPresenter.this.K.getVisibility() != 0) {
                        QFSFeedChildContentQualityFeedbackPresenter.this.u1(n3);
                        QFSFeedChildContentQualityFeedbackPresenter.this.v1();
                        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[mPopRunnable] open with ani");
                        QFSFeedChildContentQualityFeedbackPresenter.this.E1();
                        return;
                    }
                    QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[mPopRunnable] is opened");
                    return;
                }
                QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[mPopRunnable] options should not be null.");
            }
        };
    }

    public void N1() {
        int feedSourceType;
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            if (this.Z == null) {
                this.Z = (t40.c) u0(t40.c.class);
            }
            QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[sendReq] mHasBehavior = " + this.f85074g0);
            FeedCloudMeta$StFeed g16 = this.E.g();
            t40.c cVar = this.Z;
            if (cVar == null) {
                feedSourceType = 0;
            } else {
                feedSourceType = cVar.getFeedSourceType();
            }
            final QFSGetFeedBottomContentQualityFeedbackGuildRequest qFSGetFeedBottomContentQualityFeedbackGuildRequest = new QFSGetFeedBottomContentQualityFeedbackGuildRequest(g16, feedSourceType, this.f85074g0);
            VSNetworkHelper.getInstance().sendRequest(qFSGetFeedBottomContentQualityFeedbackGuildRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.feed.v
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QFSFeedChildContentQualityFeedbackPresenter.this.H1(qFSGetFeedBottomContentQualityFeedbackGuildRequest, baseRequest, z16, j3, str, (FeedCloudRead$StFeedDeatilSecondaryLoadRsp) obj);
                }
            });
            return;
        }
        QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[sendReq] feed should not be null");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCirclePanelStateEvent.class);
        eventClass.add(QFSInteractActionEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f39681cb) {
            F1();
            y1();
            com.tencent.biz.qqcircle.utils.bq.g("sp_key_feed_content_quality_feedback_close_key");
            L1(3, "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        QLog.d("QFSFeedChildContentQualityFeedbackPresenter", 1, "[onFeedSelected] selectInfo = " + rFWFeedSelectInfo + "| traceId:" + com.tencent.biz.qqcircle.immersive.utils.ba.c(this.E) + "| feedId:" + A1());
        this.V = System.currentTimeMillis();
        this.f85075h0 = rFWFeedSelectInfo.getPosition();
        K1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        M1();
        this.Y = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        if (this.Y) {
            QLog.e("QFSFeedChildContentQualityFeedbackPresenter", 1, "[onPaused] share panel open, return.");
        } else {
            M1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            B1((QCirclePanelStateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSInteractActionEvent) {
            C1((QFSInteractActionEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            t1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildContentQualityFeedbackPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedChildContentQualityFeedbackPresenter.this.P.setVisibility(4);
            QFSFeedChildContentQualityFeedbackPresenter.this.P1();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSFeedChildContentQualityFeedbackPresenter.this.K.setVisibility(8);
            QFSFeedChildContentQualityFeedbackPresenter.this.O1();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
