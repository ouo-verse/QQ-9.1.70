package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.request.QFSBatchDoUrgeRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;
import qqcircle.QQCircleLightinteract$StBatchDoUrgeRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSLightInteractUrgeReminderWidget extends QCircleBaseLightInteractWidget {
    private TextView C;
    private TextView D;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> E;
    private Size F;
    private TextView G;

    /* renamed from: i, reason: collision with root package name */
    private QCircleAvatarView f93290i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93291m;

    public QFSLightInteractUrgeReminderWidget(@NonNull Context context, int i3) {
        super(context, i3);
        initView();
        this.F = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.d3_);
    }

    private void A0(final FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f93290i.setUser(feedCloudMeta$StUser, this.F);
        this.f93291m.setText(feedCloudMeta$StUser.nick.get());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSLightInteractUrgeReminderWidget.this.w0(feedCloudMeta$StUser, view);
            }
        };
        this.f93290i.setOnClickListener(onClickListener);
        this.f93291m.setOnClickListener(onClickListener);
    }

    private void B0() {
        this.G.setSelected(true);
        this.G.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1908843a));
    }

    private void q0() {
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_USER_ROW);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_target_qq", this.f92933e.user.f398463id.get());
        VideoReport.setElementParams(this, buildElementParams);
        VideoReport.setElementId(this.f93290i, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        VideoReport.setElementId(this.f93291m, QCircleDaTongConstant.ElementId.EM_XSJ_HANDLE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData, FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (this.C != null && this.D != null) {
            this.C.setText(qQCircleFeedBase$LightInteractionBusiData.urgeUpdateInfo.content.get());
            this.D.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f196344h2) + com.tencent.biz.qqcircle.widgets.comment.b.b(feedCloudMeta$StLightInteractInfo.opTime.get() * 1000));
        }
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
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ag
            @Override // java.lang.Runnable
            public final void run() {
                QFSLightInteractUrgeReminderWidget.this.r0(qQCircleFeedBase$LightInteractionBusiData, feedCloudMeta$StLightInteractInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(QFSBatchDoUrgeRequest qFSBatchDoUrgeRequest, FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleLightinteract$StBatchDoUrgeRsp qQCircleLightinteract$StBatchDoUrgeRsp) {
        QLog.d("QFSLightInteractUrgeReminderWidget", 1, "QFSBatchDoUrgeRequest  | traceId:" + qFSBatchDoUrgeRequest.getTraceId() + " | isSuccess:" + z16 + " | retCode:" + j3 + " | errorMsg:" + str);
        if (z16 && j3 == 0) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f196334h1);
        } else {
            feedCloudMeta$StLightInteractInfo.urgeStatus.set(1);
            x0();
        }
        QCircleToast.o(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(final FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (feedCloudMeta$StLightInteractInfo.urgeStatus.get() != 1) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f196324h0), 0);
        } else {
            feedCloudMeta$StLightInteractInfo.urgeStatus.set(2);
            B0();
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StLightInteractInfo.user.f398463id.get());
            final QFSBatchDoUrgeRequest qFSBatchDoUrgeRequest = new QFSBatchDoUrgeRequest(arrayList);
            VSNetworkHelper.getInstance().sendRequest(qFSBatchDoUrgeRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.widgets.ah
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QFSLightInteractUrgeReminderWidget.this.u0(qFSBatchDoUrgeRequest, feedCloudMeta$StLightInteractInfo, baseRequest, z16, j3, str, (QQCircleLightinteract$StBatchDoUrgeRsp) obj);
                }
            });
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(FeedCloudMeta$StUser feedCloudMeta$StUser, View view) {
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
        if (view == this.f93290i) {
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

    private void x0() {
        this.G.setSelected(false);
        this.G.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f194314bk));
    }

    private void y0(final FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        if (feedCloudMeta$StLightInteractInfo != null && this.C != null && this.D != null) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ad
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLightInteractUrgeReminderWidget.this.s0(feedCloudMeta$StLightInteractInfo);
                }
            });
        }
    }

    private void z0(final FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        int i3;
        if (feedCloudMeta$StLightInteractInfo == null) {
            return;
        }
        if (feedCloudMeta$StLightInteractInfo.urgeStatus.get() == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            x0();
        } else {
            B0();
        }
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSLightInteractUrgeReminderWidget.this.v0(feedCloudMeta$StLightInteractInfo, view);
            }
        });
        VideoReport.setElementId(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_RUSH_UPDATE_BUTTON);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_RUSH_UPDATE, Integer.valueOf(i3 ^ 1));
        VideoReport.setElementParams(this.G, buildElementParams);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof FeedCloudMeta$StLightInteractInfo) {
            FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) obj;
            this.f92933e = feedCloudMeta$StLightInteractInfo;
            y0(feedCloudMeta$StLightInteractInfo);
            A0(this.f92933e.user);
            z0(this.f92933e);
            q0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gtj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLightInteractUrgeReminderWidget";
    }

    protected void initView() {
        this.f93290i = (QCircleAvatarView) findViewById(R.id.f31800s1);
        this.f93291m = (TextView) findViewById(R.id.f31850s6);
        this.C = (TextView) findViewById(R.id.f31810s2);
        this.D = (TextView) findViewById(R.id.f31880s9);
        this.G = (TextView) findViewById(R.id.f112256nf);
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.E = aVar;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QFSLightInteractUrgeReminderWidget", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.E;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QFSLightInteractUrgeReminderWidget", aVar.getReportBean());
        }
        return null;
    }
}
