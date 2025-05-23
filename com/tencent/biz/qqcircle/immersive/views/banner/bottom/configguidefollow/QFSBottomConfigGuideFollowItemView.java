package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSShowPersonalPanelEvent;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomConfigGuideFollowItemView extends QCircleBaseWidgetView<d> implements View.OnClickListener {
    private Size C;
    private FeedCloudMeta$StUser D;
    private e30.b E;
    private int F;
    private int G;
    private final QFSBottomConfigRecycleAdapter.ShowScene H;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f90625d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f90626e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarView f90627f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90628h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90629i;

    /* renamed from: m, reason: collision with root package name */
    private QFSFollowView f90630m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f90631d;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f90631d = feedCloudMeta$StUser;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (r.j0(this.f90631d)) {
                QLog.d("QFSBottomConfigGuideFollowItemView", 1, "[updateFollowState] is followed. uin =" + this.f90631d.f398463id.get());
            } else {
                QFSBottomConfigGuideFollowItemView.this.f90630m.onClick(view);
                QFSBottomConfigGuideFollowItemView.this.r0();
                QFSBottomConfigGuideFollowItemView.this.q0(11);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSBottomConfigGuideFollowItemView(@NonNull @NotNull Context context, QFSBottomConfigRecycleAdapter.ShowScene showScene) {
        super(context);
        this.H = showScene;
        w0();
    }

    private void o0() {
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.D;
        if (feedCloudMeta$StUser != null) {
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        }
        if (r.j0(this.D)) {
            str = QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        } else {
            str = "follow";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, str);
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.F + 1));
        int i3 = this.G;
        if (i3 == 2) {
            str2 = "more";
        } else if (i3 == 1) {
            str2 = SemanticAttributes.DbCassandraConsistencyLevelValues.ONE;
        } else {
            str2 = "";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, str2);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.f90625d, QCircleDaTongConstant.ElementId.EM_XSJ_AUTHOR_CARD);
        VideoReport.setElementParams(this.f90625d, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f90625d, String.valueOf(this.F));
        VideoReport.setElementExposePolicy(this.f90625d, ExposurePolicy.REPORT_ALL);
    }

    private void p0() {
        String str;
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.D;
        if (feedCloudMeta$StUser != null) {
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        }
        if (r.j0(this.D)) {
            str = QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        } else {
            str = "follow";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, str);
        buildElementParams.put("xsj_item_index", Integer.valueOf(this.F + 1));
        int i3 = this.G;
        if (i3 == 2) {
            str2 = "more";
        } else if (i3 == 1) {
            str2 = SemanticAttributes.DbCassandraConsistencyLevelValues.ONE;
        } else {
            str2 = "";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, str2);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.f90625d, QCircleDaTongConstant.ElementId.EM_XSJ_AUTHOR_CARD);
        VideoReport.setElementParams(this.f90625d, buildElementParams);
        VideoReport.setElementReuseIdentifier(this.f90625d, String.valueOf(this.F));
        VideoReport.setElementExposePolicy(this.f90625d, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i3) {
        String str;
        QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder();
        dataBuilder.setActionType(80).setSubActionType(i3).setPosition(this.F).setPageId(getPageId()).setFirstFeedId(w20.a.j().h());
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.D;
        if (feedCloudMeta$StUser != null) {
            dataBuilder.setExt2(feedCloudMeta$StUser.f398463id.get());
        }
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            if (this.E.g().type.get() == 2) {
                str = "1";
            } else {
                str = "2";
            }
            dataBuilder.setExt1(str);
        }
        QCircleLpReportDc05507.report(dataBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null) {
            buildElementParams.put("xsj_feed_id", this.E.g().f398449id.get());
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.D;
        if (feedCloudMeta$StUser != null) {
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StUser.f398463id.get());
        }
        int i3 = this.G;
        if (i3 == 2) {
            str = "more";
        } else if (i3 == 1) {
            str = SemanticAttributes.DbCassandraConsistencyLevelValues.ONE;
        } else {
            str = "";
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, str);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        VideoReport.setElementId(this.f90626e, QCircleDaTongConstant.ElementId.EM_XSJ_AUTHOR_FOLLOW_CARD);
        VideoReport.setElementReuseIdentifier(this.f90626e, String.valueOf(this.F));
        VideoReport.reportEvent("dt_clck", this.f90626e, buildElementParams);
    }

    private void s0(View view) {
        if (r.j0(this.D)) {
            QLog.d("QFSBottomConfigGuideFollowItemView", 1, "[handleFollowBtnClick] is followed.");
        } else {
            this.f90630m.onClick(view);
        }
    }

    private void u0() {
        boolean v06 = v0();
        QLog.d("QFSBottomConfigGuideFollowItemView", 1, "handleUserClick isFollowUserScene:" + v06);
        if (v06) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.poster.set(this.D);
            SimpleEventBus.getInstance().dispatchEvent(new QFSShowPersonalPanelEvent(feedCloudMeta$StFeed, true, getContext().hashCode()));
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.D;
        if (feedCloudMeta$StUser != null) {
            qCircleInitBean.setUin(feedCloudMeta$StUser.f398463id.get());
        }
        com.tencent.biz.qqcircle.launcher.c.d0(getContext(), qCircleInitBean);
    }

    private boolean v0() {
        if (this.H != QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FOLLOW_AUTHOR && !r.P(this.E)) {
            return false;
        }
        return true;
    }

    private void w0() {
        this.f90627f = (QCircleAvatarView) findViewById(R.id.f39591c3);
        this.f90628h = (TextView) findViewById(R.id.f39651c9);
        this.f90629i = (TextView) findViewById(R.id.f39671ca);
        this.f90625d = (LinearLayout) findViewById(R.id.f56952m0);
        this.f90626e = (LinearLayout) findViewById(R.id.f42101iv);
        QFSFollowView qFSFollowView = (QFSFollowView) findViewById(R.id.f39631c7);
        this.f90630m = qFSFollowView;
        qFSFollowView.setFollowedDismiss(false);
        this.f90630m.setFollowedDrawable(0);
        this.f90630m.setFollowedTextColor(R.color.cli);
        this.C = n.a(getContext(), R.dimen.d1b);
        this.f90625d.setOnClickListener(this);
        this.f90626e.setOnClickListener(this);
    }

    private void x0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSBottomConfigGuideFollowItemView", 1, "[updateFollowState] stUser should not be null");
        } else {
            this.f90630m.setUserData(feedCloudMeta$StUser);
            this.f90630m.setOnClickListener(new a(feedCloudMeta$StUser));
        }
    }

    private void y0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSBottomConfigGuideFollowItemView", 1, "[updateNickName] stUser should not be null");
        } else {
            this.f90628h.setText(feedCloudMeta$StUser.nick.get());
        }
    }

    private void z0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (v0()) {
            if (feedCloudMeta$StUser == null) {
                QLog.e("QFSBottomConfigGuideFollowItemView", 1, "[updateRecommendReason] stUser should not be null");
                return;
            }
            TextView textView = this.f90629i;
            if (textView != null) {
                textView.setText(this.D.desc.get());
                this.f90629i.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        if (i.f90684a.b()) {
            return R.layout.g8e;
        }
        return R.layout.g8d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(d dVar, int i3) {
        if (dVar == null) {
            QLog.e("QFSBottomConfigGuideFollowItemView", 1, "[bindData] followItemInfo should not be null");
            return;
        }
        QLog.d("QFSBottomConfigGuideFollowItemView", 1, "[bindData] followItemInfo =" + dVar);
        this.F = i3;
        this.D = dVar.e();
        this.E = dVar.c();
        this.G = dVar.d();
        this.f90627f.setUser(this.D, this.C);
        y0(this.D);
        z0(this.D);
        x0(this.D);
        o0();
        q0(10);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f56952m0) {
            u0();
            p0();
        } else if (view.getId() == R.id.f42101iv) {
            s0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
