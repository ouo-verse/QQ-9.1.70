package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ua0.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedHobbyLabelItemView extends QFSLayerDittoItemView {
    public QFSLayerFeedHobbyLabelItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    private String E0(b bVar) {
        if (bVar != null && bVar.g() != null) {
            return bVar.g().f398449id.get();
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ged;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        int i16;
        if (bVar != null && bVar.g() != null && bVar.g().dittoFeed != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.d(bVar));
            if (bVar.g().dittoFeed.dittoId.get() == 41) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_INTEREST_TAG, Integer.valueOf(i16));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            QLog.i("QFSLayerFeedHobbyLabelItemView", 1, "dtReportBindItemView  pos = " + i3 + " , dittoId = " + bVar.g().dittoFeed.dittoId.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> h16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (h16 = q06.h()) != null) {
            arrayList.addAll(h16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(b bVar, int i3) {
        super.bindData(bVar, i3);
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(615).setSubActionType(1).setFeedId(E0(bVar)).setPageId(503));
    }
}
