package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSCommentFeedDescFollowView;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.QFSVipNickNameAndIconView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentFeedDescItemView extends QFSCommentBaseItemView {
    private static final boolean P = com.tencent.biz.qqcircle.utils.l.d("exp_tagstrengthen_2");
    private int G;
    private View H;
    private QFSVipNickNameAndIconView I;
    private QFSExpandableAsyncTextView J;
    private FeedCloudMeta$StFeed K;
    private QFSCommentFeedDescFollowView L;
    private TextView M;
    private ImageView N;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.QFSCommentFeedDescItemView$6, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f83198d;
        final /* synthetic */ QFSCommentFeedDescItemView this$0;

        @Override // java.lang.Runnable
        public void run() {
            try {
                QFSExpandableAsyncTextView qFSExpandableAsyncTextView = this.this$0.J;
                VideoReport.setElementId(qFSExpandableAsyncTextView, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_EXPAND_BUTTON);
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
                if (this.f83198d) {
                    VideoReport.reportEvent("dt_clck", qFSExpandableAsyncTextView, buildElementParams);
                } else {
                    VideoReport.setElementParams(qFSExpandableAsyncTextView, buildElementParams);
                }
            } catch (Exception e16) {
                QLog.e("QFSCommentFeedDescItemView", 1, e16.getMessage());
            }
        }
    }

    public QFSCommentFeedDescItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i3, int i16) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
        dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(this.K.poster.f398463id.get()).setPosition(this.G).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
        QCircleLpReportDc05507.report(dataBuilder);
    }

    private void E0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        QFSCommentFeedDescFollowView qFSCommentFeedDescFollowView = (QFSCommentFeedDescFollowView) findViewById(R.id.vcw);
        this.L = qFSCommentFeedDescFollowView;
        qFSCommentFeedDescFollowView.setFollowedDismiss(true);
        if (com.tencent.biz.qqcircle.immersive.utils.r.i0(this.K)) {
            this.L.setVisibility(8);
            return;
        }
        this.L.setDtParentEmId(QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        if (QCircleFollowManager.getInstance().hasUin(feedCloudMeta$StUser.f398463id.get())) {
            i3 = QCircleFollowManager.getInstance().getUinFollowed(feedCloudMeta$StUser.f398463id.get()).intValue();
        } else {
            i3 = feedCloudMeta$StUser.followState.get();
        }
        D0(i3, feedCloudMeta$StUser);
        this.L.setUserData(feedCloudMeta$StUser, this.K);
        this.L.setItemReportListener(new a());
    }

    private void F0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && this.N != null) {
            QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
            try {
                qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StFeed.poster.busiData.get().toByteArray());
            } catch (Exception e16) {
                QLog.e("QFSCommentFeedDescItemView", 1, "[updateAuthorityIcon] ", e16);
            }
            if (qQCircleBase$StUserBusiData.certification.get() == 0) {
                QLog.d("QFSCommentFeedDescItemView", 1, "[updateAuthorityIcon] no authority");
                this.N.setVisibility(8);
                return;
            }
            this.N.setVisibility(0);
            String d16 = com.tencent.biz.qqcircle.immersive.utils.p.d(qQCircleBase$StUserBusiData);
            int a16 = cx.a(14.0f);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(d16).setRequestWidth(a16).setRequestHeight(a16).setTargetView(this.N));
            return;
        }
        QLog.w("QFSCommentFeedDescItemView", 1, "[updateAuthorityIcon] invalid feed or view");
    }

    private void G0(QFSCommentItemInfo qFSCommentItemInfo) {
        String str = this.K.content.get();
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setLimitLines(qFSCommentItemInfo.mContentLimitLines);
        if (qFSCommentItemInfo.mDefaultExpanded) {
            this.J.setExpanded(true);
        }
        this.J.setText(str);
        this.J.setVisibility(0);
    }

    private void H0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.M == null) {
            return;
        }
        if (feedCloudMeta$StFeed.opMask2.get().contains(42) && feedCloudMeta$StFeed.extInfo.has()) {
            String d16 = bh.d(feedCloudMeta$StFeed.extInfo.get(), "qzone-user-area");
            if (!TextUtils.isEmpty(d16)) {
                this.M.setVisibility(0);
                this.M.setText(" \u00b7 " + d16);
                return;
            }
            QLog.d("QFSCommentFeedDescItemView", 1, "[updateIpTerritoryView] ipTerritory string is null");
            this.M.setVisibility(8);
            return;
        }
        QLog.e("QFSCommentFeedDescItemView", 1, "[updateIpTerritoryView] feed do not contain ip info, data.extInfo.has() =" + feedCloudMeta$StFeed.extInfo.has());
    }

    private void I0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        w0(feedCloudMeta$StFeed.poster);
        this.I.setUser(this.K.poster);
        this.I.setReportData(new QFSVipNickNameAndIconView.b().g(this.K).h(88));
        this.I.w0(this.K.poster.nick.get());
    }

    private void initView() {
        this.H = findViewById(R.id.b3r);
        this.I = (QFSVipNickNameAndIconView) findViewById(R.id.fxo);
        this.J = (QFSExpandableAsyncTextView) findViewById(R.id.fxm);
        this.M = (TextView) findViewById(R.id.f40511ek);
        this.N = (ImageView) findViewById(R.id.f26620e1);
        this.J.setSpecialClickAreaColor(R.color.qui_common_text_link);
        this.J.setNeedSpecialHashTagAreaBackground(false);
        this.J.setNeedSpecialAreaBold(P);
    }

    public void D0(int i3, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        String str;
        VideoReport.setElementId(this.L, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.K;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.K.poster.f398463id.get());
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, com.tencent.biz.qqcircle.immersive.utils.r.F(i3));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EID, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
        if (feedCloudMeta$StUser != null) {
            str = feedCloudMeta$StUser.f398463id.get();
        } else {
            str = "";
        }
        buildElementParams.put("xsj_target_qq", str);
        QCircleReportBean reportBean = getReportBean();
        String str2 = QCircleDaTongConstant.PageId.BASE;
        if (reportBean != null && !TextUtils.isEmpty(reportBean.getDtPageId())) {
            str2 = reportBean.getDtPageId();
        }
        buildElementParams.put("dt_pgid", str2);
        VideoReport.setElementReuseIdentifier(this.L, str);
        VideoReport.setElementExposePolicy(this.L, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", this.L, buildElementParams);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g9p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentFeedDescItemView";
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        super.bindData(qFSCommentItemInfo, i3);
        if (this.K != null && qFSCommentItemInfo != null) {
            this.G = i3;
            I0();
            G0(qFSCommentItemInfo);
            x0(this.K.createTime.get());
            E0(this.K.poster);
            H0(this.K);
            F0(this.K);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.biz.qqcircle.utils.l.i("exp_tagstrengthen_2");
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView, android.view.View.OnClickListener
    public void onClick(View view) {
        com.tencent.biz.qqcircle.widgets.comment.c cVar;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (view.getId() == R.id.a2o && (cVar = this.D) != null && (feedCloudMeta$StFeed = this.K) != null) {
            cVar.onClick(view, 1, this.G, feedCloudMeta$StFeed.poster);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSExpandableAsyncTextView qFSExpandableAsyncTextView;
        if (this.K != feedCloudMeta$StFeed && (qFSExpandableAsyncTextView = this.J) != null) {
            qFSExpandableAsyncTextView.w();
        }
        this.K = feedCloudMeta$StFeed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView
    public void w0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        super.w0(feedCloudMeta$StUser);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements QFSFollowView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            com.tencent.biz.qqcircle.widgets.aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            QFSCommentFeedDescItemView.this.C0(130, 2);
            VideoReport.setElementId(QFSCommentFeedDescItemView.this.L, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "follow");
            hashMap.put("xsj_feed_id", QFSCommentFeedDescItemView.this.K.f398449id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, QFSCommentFeedDescItemView.this.K.poster.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EID, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL);
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, QFSCommentFeedDescItemView.this.L, hashMap);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
