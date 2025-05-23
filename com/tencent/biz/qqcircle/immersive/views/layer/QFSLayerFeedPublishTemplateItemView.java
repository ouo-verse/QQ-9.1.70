package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import ua0.c;

/* loaded from: classes4.dex */
public class QFSLayerFeedPublishTemplateItemView extends QFSLayerFeedAbsItemView {
    public QFSLayerFeedPublishTemplateItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gf5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedPublishTemp";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew;
        if (bVar != null && (qQCircleDitto$StCircleDittoDataNew = (QQCircleDitto$StCircleDittoDataNew) bVar.b("DITTO_FEED_PUBLISH_TEMPLATE")) != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.get() != null && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.size() > 0 && qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.size() > 0) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qQCircleDitto$StCircleDittoDataNew.itemContainter.items.get(0).feeds.get(0);
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.e(feedCloudMeta$StFeed));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_TIMESTAMP, Long.valueOf(feedCloudMeta$StFeed.createTime.get()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUBLISH_COVER_URL, feedCloudMeta$StFeed.cover.picUrl.get());
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + feedCloudMeta$StFeed.f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            if (QLog.isColorLevel()) {
                QLog.i(getLogTag(), 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().feedType.get());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> s16;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (s16 = q06.s()) != null) {
            arrayList.addAll(s16);
        }
        return arrayList;
    }
}
