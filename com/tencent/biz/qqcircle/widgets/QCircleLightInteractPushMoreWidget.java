package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageLightInteractInfo;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;

/* loaded from: classes5.dex */
public class QCircleLightInteractPushMoreWidget extends QCircleBaseLightInteractWidget {
    private TextView C;
    private QFSFollowView D;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> E;
    private Size F;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f93024i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93025m;

    public QCircleLightInteractPushMoreWidget(@NonNull Context context, int i3) {
        super(context, i3);
        q0(this);
        this.F = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3_);
    }

    private void p0() {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_USER_ROW);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_target_qq", this.f92933e.user.f398463id.get());
        VideoReport.setElementParams(this, buildElementParams);
        VideoReport.setElementId(this.f93024i, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        QCircleAvatarView qCircleAvatarView = this.f93024i;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(qCircleAvatarView, exposurePolicy);
        VideoReport.setElementId(this.f93025m, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
        VideoReport.setElementExposePolicy(this.f93025m, exposurePolicy);
        VideoReport.setElementId(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
        VideoReport.setElementExposePolicy(this.D, exposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo, QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData) {
        if (this.C == null) {
            return;
        }
        this.C.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(feedCloudMeta$StLightInteractInfo.opTime.get() * 1000) + qQCircleFeedBase$LightInteractionBusiData.urgeUpdateInfo.content.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(final FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (feedCloudMeta$StLightInteractInfo == null) {
            return;
        }
        final QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData = new QQCircleFeedBase$LightInteractionBusiData();
        try {
            qQCircleFeedBase$LightInteractionBusiData.mergeFrom(feedCloudMeta$StLightInteractInfo.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.k
            @Override // java.lang.Runnable
            public final void run() {
                QCircleLightInteractPushMoreWidget.this.r0(feedCloudMeta$StLightInteractInfo, qQCircleFeedBase$LightInteractionBusiData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        String str;
        int i16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f92935h;
        if (qCircleExtraTypeInfo != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
        if (z16) {
            i3 = 73;
        } else {
            i3 = 74;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = a16.setActionType(i3).setSubActionType(2);
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.f92935h;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        QCircleExtraTypeInfo qCircleExtraTypeInfo3 = this.f92935h;
        if (qCircleExtraTypeInfo3 != null) {
            i16 = qCircleExtraTypeInfo3.mDataPosition;
        } else {
            i16 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(getPageId())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(FeedCloudMeta$StUser feedCloudMeta$StUser, View view) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        String str;
        int i16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(feedCloudMeta$StUser);
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.f92935h;
        if (qCircleExtraTypeInfo != null) {
            feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
        if (view == this.f93024i) {
            i3 = 71;
        } else {
            i3 = 72;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = a16.setActionType(i3).setSubActionType(2);
        QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.f92935h;
        if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed2 = qCircleExtraTypeInfo2.mFeed) != null) {
            str = feedCloudMeta$StFeed2.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        QCircleExtraTypeInfo qCircleExtraTypeInfo3 = this.f92935h;
        if (qCircleExtraTypeInfo3 != null) {
            i16 = qCircleExtraTypeInfo3.mDataPosition;
        } else {
            i16 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i16).setPageId(getPageId())));
        EventCollector.getInstance().onViewClicked(view);
    }

    private void w0(final FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (feedCloudMeta$StLightInteractInfo != null && this.C != null) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.h
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleLightInteractPushMoreWidget.this.s0(feedCloudMeta$StLightInteractInfo);
                }
            });
        }
    }

    private void x0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.D.setFollowedDismiss(false);
        this.D.setUserData(feedCloudMeta$StUser);
        this.D.setFollowStateChangeListener(new QFSFollowView.c() { // from class: com.tencent.biz.qqcircle.widgets.j
            @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
            public final void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser2) {
                QCircleLightInteractPushMoreWidget.this.u0(z16, feedCloudMeta$StUser2);
            }
        });
    }

    private void y0(final FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93024i.setUser(feedCloudMeta$StUser, this.F);
        this.f93025m.setText(feedCloudMeta$StUser.nick.get());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleLightInteractPushMoreWidget.this.v0(feedCloudMeta$StUser, view);
            }
        };
        this.f93024i.setOnClickListener(onClickListener);
        this.f93025m.setOnClickListener(onClickListener);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof QFSMessageLightInteractInfo) {
            FeedCloudMeta$StLightInteractInfo stLightInteractInfo = ((QFSMessageLightInteractInfo) obj).getStLightInteractInfo();
            this.f92933e = stLightInteractInfo;
            w0(stLightInteractInfo);
            y0(this.f92933e.user);
            x0(this.f92933e.user);
            p0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleLightInteractPushMoreWidget";
    }

    protected void q0(View view) {
        this.f93024i = (QCircleAvatarView) view.findViewById(R.id.f31800s1);
        this.f93025m = (TextView) view.findViewById(R.id.f31850s6);
        this.C = (TextView) view.findViewById(R.id.f31810s2);
        this.D = (QFSFollowView) view.findViewById(R.id.f31820s3);
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.E = aVar;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushMoreWidget", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.E;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushMoreWidget", aVar.getReportBean());
        }
        return null;
    }
}
