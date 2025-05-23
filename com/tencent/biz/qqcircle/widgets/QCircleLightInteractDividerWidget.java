package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleLightInteractDividerWidget extends QCircleBaseLightInteractWidget {

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> f93011i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f93012m;

    public QCircleLightInteractDividerWidget(@NonNull Context context, int i3) {
        super(context, i3);
        l0(this);
    }

    private void l0(View view) {
        this.f93012m = (TextView) view.findViewById(R.id.f32980v8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof FeedCloudMeta$StLightInteractInfo) {
            FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) obj;
            QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData = new QQCircleFeedBase$LightInteractionBusiData();
            try {
                qQCircleFeedBase$LightInteractionBusiData.mergeFrom(feedCloudMeta$StLightInteractInfo.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            this.f93012m.setText(qQCircleFeedBase$LightInteractionBusiData.splitItemText.get());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g3s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleLightInteractPushWidget";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget
    public void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3) {
        this.f92932d = feedCloudMeta$StFeed;
        this.f92935h = qCircleExtraTypeInfo;
        this.f92934f = i3;
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.f93011i = aVar;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.f93011i;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractPushWidget", aVar.getReportBean());
        }
        return null;
    }
}
