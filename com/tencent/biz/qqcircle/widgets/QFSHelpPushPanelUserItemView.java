package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSHelpPushPanelItemInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSPlusFollowView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class QFSHelpPushPanelUserItemView extends QCircleBaseWidgetView<QFSHelpPushPanelItemInfo> {

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f93271d;

    /* renamed from: e, reason: collision with root package name */
    private QFSPlusFollowView f93272e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93273f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93274h;

    /* renamed from: i, reason: collision with root package name */
    private Size f93275i;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, Object> f93276m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f93277d;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f93277d = feedCloudMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUser(this.f93277d);
            if (QFSHelpPushPanelUserItemView.this.getReportBean() != null) {
                qCircleInitBean.setFromReportBean(QFSHelpPushPanelUserItemView.this.getReportBean().m466clone());
            }
            com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSHelpPushPanelUserItemView(@NonNull Context context) {
        super(context);
        p0(this);
    }

    private void n0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93272e.setItemReportListener(new b(feedCloudMeta$StUser));
    }

    private void o0() {
        this.f93272e.setFollowedDismiss(true);
        this.f93272e.setVisibility(8);
    }

    private void p0(View view) {
        this.f93271d = (QCircleAvatarView) view.findViewById(R.id.f43551ms);
        this.f93272e = (QFSPlusFollowView) view.findViewById(R.id.f43591mw);
        this.f93273f = (TextView) view.findViewById(R.id.f43611my);
        this.f93274h = (TextView) view.findViewById(R.id.f43571mu);
        this.f93275i = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d4f);
        o0();
    }

    private void q0(int i3) {
        RFWTypefaceUtil.setNumberTypeface(this.f93274h, true);
        this.f93274h.setText(String.valueOf(i3));
    }

    private void r0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSHelpPushPanelUserItemView", 1, "[updateUserAvatarView] user should not be null.");
            return;
        }
        this.f93271d.setUser(feedCloudMeta$StUser, this.f93275i);
        this.f93273f.setText(feedCloudMeta$StUser.nick.get());
        a aVar = new a(feedCloudMeta$StUser);
        this.f93271d.setOnClickListener(aVar);
        this.f93273f.setOnClickListener(aVar);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gda;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSHelpPushPanelUserItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSHelpPushPanelItemInfo qFSHelpPushPanelItemInfo, int i3) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = qFSHelpPushPanelItemInfo.getStHelperInfo().user;
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSHelpPushPanelUserItemView", 1, "[bindData] user should not be null.");
            return;
        }
        r0(feedCloudMeta$StUser);
        q0(qFSHelpPushPanelItemInfo.getStHelperInfo().rocketNum.get());
        this.f93272e.setUserData(feedCloudMeta$StUser);
        n0(feedCloudMeta$StUser);
    }

    public void setDtParams(Map<String, Object> map) {
        this.f93276m = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements QFSFollowView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f93279a;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f93279a = feedCloudMeta$StUser;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            if (i3 == 0) {
                VideoReport.setElementId(QFSHelpPushPanelUserItemView.this.f93272e, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_action_type", "follow");
                hashMap.put("xsj_target_qq", this.f93279a.f398463id.get());
                hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                hashMap.putAll(QFSHelpPushPanelUserItemView.this.f93276m);
                VideoReport.reportEvent("dt_clck", QFSHelpPushPanelUserItemView.this.f93272e, hashMap);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
        }
    }
}
