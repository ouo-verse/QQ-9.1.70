package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleFollowUserBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.list.bizblocks.QCircleFollowUserListBlock;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import java.util.HashMap;
import qqcircle.QQCircleFeedBase$StUinBannerData;
import qqcircle.QQCircleFeedBase$StUserRecomInfoBusiData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleFollowUserListItemView extends QCircleBaseWidgetView<FeedCloudMeta$StUserRecomInfo> implements View.OnClickListener {
    private TextView C;
    private TextView D;
    private URLImageView E;
    private QFSFollowView F;
    private View G;
    private View H;
    private String I;
    private TextView J;
    private String K;
    private int L;
    private int M;
    private Size N;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f92994d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleAvatarView f92995e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f92996f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAvatarView f92997h;

    /* renamed from: i, reason: collision with root package name */
    private View f92998i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f92999m;

    public QCircleFollowUserListItemView(Context context, String str, int i3) {
        super(context);
        this.M = -1;
        q0(this);
        this.I = str;
        this.L = i3;
        this.N = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159403d24);
    }

    private int p0() {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if ((qCircleInitBean instanceof QCircleFollowUserBean) && ((QCircleFollowUserBean) qCircleInitBean).getListType() == 5) {
            return 6;
        }
        return 3;
    }

    private void q0(View view) {
        QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) view.findViewById(R.id.f31150q_);
        this.f92994d = qCircleAvatarView;
        qCircleAvatarView.setOnClickListener(this);
        this.f92995e = (QCircleAvatarView) view.findViewById(R.id.f31100q5);
        this.f92996f = (QCircleAvatarView) view.findViewById(R.id.f31120q7);
        this.f92997h = (QCircleAvatarView) view.findViewById(R.id.f31110q6);
        this.C = (TextView) view.findViewById(R.id.f31200qe);
        this.f92998i = view.findViewById(R.id.yo7);
        this.f92999m = (TextView) view.findViewById(R.id.f31170qb);
        this.D = (TextView) view.findViewById(R.id.f31160qa);
        this.J = (TextView) view.findViewById(R.id.f31080q3);
        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f31180qc);
        this.E = uRLImageView;
        uRLImageView.setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200619175130_E9peEWVngd.png");
        QFSFollowView qFSFollowView = (QFSFollowView) view.findViewById(R.id.f31140q9);
        this.F = qFSFollowView;
        qFSFollowView.setItemReportListener(new a());
        this.G = view.findViewById(R.id.f31190qd);
        View findViewById = view.findViewById(R.id.f31130q8);
        this.H = findViewById;
        findViewById.setOnClickListener(this);
    }

    private void r0() {
        if (this.M == 1) {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(29).setThrActionType(3).setExt1(this.K));
        }
    }

    private void s0(QQCircleFeedBase$StUserRecomInfoBusiData qQCircleFeedBase$StUserRecomInfoBusiData) {
        if (qQCircleFeedBase$StUserRecomInfoBusiData == null) {
            return;
        }
        if (qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().size() == 1) {
            this.f92995e.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(0), this.N);
            this.f92995e.setVisibility(0);
            this.f92996f.setVisibility(8);
            this.f92997h.setVisibility(8);
            return;
        }
        if (qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().size() == 2) {
            this.f92995e.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(0), this.N);
            this.f92996f.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(1), this.N);
            this.f92995e.setVisibility(0);
            this.f92996f.setVisibility(0);
            this.f92997h.setVisibility(8);
            return;
        }
        if (qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().size() > 2) {
            this.f92995e.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(0), this.N);
            this.f92996f.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(1), this.N);
            this.f92997h.setUser(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().get(2), this.N);
            this.f92995e.setVisibility(0);
            this.f92996f.setVisibility(0);
            this.f92997h.setVisibility(0);
            return;
        }
        this.f92995e.setVisibility(8);
        this.f92996f.setVisibility(8);
        this.f92997h.setVisibility(8);
    }

    private void u0(QQCircleFeedBase$StUserRecomInfoBusiData qQCircleFeedBase$StUserRecomInfoBusiData) {
        if (qQCircleFeedBase$StUserRecomInfoBusiData == null) {
            return;
        }
        QQCircleFeedBase$StUinBannerData qQCircleFeedBase$StUinBannerData = qQCircleFeedBase$StUserRecomInfoBusiData.bannerData;
        if (qQCircleFeedBase$StUinBannerData != null && qQCircleFeedBase$StUinBannerData.text.get() != null && !TextUtils.isEmpty(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.text.get())) {
            this.C.setText(qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.text.get());
        }
        QQCircleFeedBase$StUinBannerData qQCircleFeedBase$StUinBannerData2 = qQCircleFeedBase$StUserRecomInfoBusiData.bannerData;
        if (qQCircleFeedBase$StUinBannerData2 != null && qQCircleFeedBase$StUinBannerData2.userList.get() != null && !qQCircleFeedBase$StUserRecomInfoBusiData.bannerData.userList.get().isEmpty()) {
            s0(qQCircleFeedBase$StUserRecomInfoBusiData);
        }
    }

    private void v0(QQCircleFeedBase$StUserRecomInfoBusiData qQCircleFeedBase$StUserRecomInfoBusiData) {
        if (qQCircleFeedBase$StUserRecomInfoBusiData == null) {
            return;
        }
        if (qQCircleFeedBase$StUserRecomInfoBusiData.recomSource.get() == 1) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(8);
        }
    }

    private void w0(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo) {
        String str = feedCloudMeta$StUserRecomInfo.user.desc.get();
        this.D.setText(str);
        if (TextUtils.isEmpty(str)) {
            ((RelativeLayout.LayoutParams) this.f92998i.getLayoutParams()).addRule(15);
        } else {
            ((RelativeLayout.LayoutParams) this.f92998i.getLayoutParams()).removeRule(15);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g3a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleFollowUserListItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo, int i3) {
        if (feedCloudMeta$StUserRecomInfo == null) {
            return;
        }
        QQCircleFeedBase$StUserRecomInfoBusiData qQCircleFeedBase$StUserRecomInfoBusiData = new QQCircleFeedBase$StUserRecomInfoBusiData();
        try {
            qQCircleFeedBase$StUserRecomInfoBusiData.mergeFrom(feedCloudMeta$StUserRecomInfo.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        int i16 = 8;
        if (qQCircleFeedBase$StUserRecomInfoBusiData.pattonType.get() == 1) {
            this.H.setVisibility(0);
            this.G.setVisibility(8);
            u0(qQCircleFeedBase$StUserRecomInfoBusiData);
        } else {
            this.H.setVisibility(8);
            this.G.setVisibility(0);
            this.f92994d.setUser(feedCloudMeta$StUserRecomInfo.user, this.N);
            this.K = feedCloudMeta$StUserRecomInfo.user.f398463id.get();
            this.f92999m.setText(feedCloudMeta$StUserRecomInfo.user.nick.get());
            w0(feedCloudMeta$StUserRecomInfo);
            URLImageView uRLImageView = this.E;
            if (feedCloudMeta$StUserRecomInfo.user.frdState.get() == 1) {
                i16 = 0;
            }
            uRLImageView.setVisibility(i16);
            this.F.setUserData(feedCloudMeta$StUserRecomInfo.user);
            if (this.M == -1) {
                if (feedCloudMeta$StUserRecomInfo.user.followState.get() == 0) {
                    this.M = 1;
                } else {
                    this.M = 0;
                }
            }
            r0();
        }
        v0(qQCircleFeedBase$StUserRecomInfoBusiData);
    }

    public void o0(String str) {
        QFSFollowView qFSFollowView = this.F;
        if (qFSFollowView != null && qFSFollowView.o() != null) {
            VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", str);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, com.tencent.biz.qqcircle.immersive.utils.r.F(this.F.o().followState.get()));
            hashMap.put("xsj_target_qq", this.F.o().f398463id.get());
            hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, this.F, hashMap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i3 = 28;
        if (id5 == R.id.f31130q8) {
            QCircleFollowUserBean qCircleFollowUserBean = new QCircleFollowUserBean();
            qCircleFollowUserBean.setUin(this.I);
            qCircleFollowUserBean.setAdapterClassName(QCircleFollowUserListBlock.class.getName());
            qCircleFollowUserBean.setListType(p0());
            com.tencent.biz.qqcircle.launcher.c.J(getContext(), qCircleFollowUserBean);
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(28).setThrActionType(5));
        } else if (id5 == R.id.f31150q_ && !TextUtils.isEmpty(this.K)) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(this.K);
            qCircleInitBean.setFromReportBean(getReportBean().m466clone());
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            QCircleLpReportDc05504.DataBuilder actionType = new QCircleLpReportDc05504.DataBuilder().setToUin(this.K).setActionType(11);
            if (this.L != 0) {
                i3 = 30;
            }
            QCircleLpReportDc05504.report(actionType.setSubActionType(i3).setThrActionType(2));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements QFSFollowView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            int i3;
            if (QCircleFollowUserListItemView.this.M == 1) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.this.K).setActionType(11).setSubActionType(29).setThrActionType(4));
            } else {
                QCircleLpReportDc05504.DataBuilder actionType = new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.this.K).setActionType(11);
                if (QCircleFollowUserListItemView.this.L == 0) {
                    i3 = 28;
                } else {
                    i3 = 30;
                }
                QCircleLpReportDc05504.report(actionType.setSubActionType(i3).setThrActionType(4));
            }
            QCircleFollowUserListItemView.this.o0("cancel");
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            int i16;
            if (i3 == 0) {
                if (QCircleFollowUserListItemView.this.M == 1) {
                    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.this.K).setActionType(11).setSubActionType(29).setThrActionType(3));
                } else {
                    QCircleLpReportDc05504.DataBuilder actionType = new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.this.K).setActionType(11);
                    if (QCircleFollowUserListItemView.this.L == 0) {
                        i16 = 28;
                    } else {
                        i16 = 30;
                    }
                    QCircleLpReportDc05504.report(actionType.setSubActionType(i16).setThrActionType(3));
                }
            }
            if (i3 == 0 || i3 == 2) {
                QCircleFollowUserListItemView.this.o0("follow");
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
