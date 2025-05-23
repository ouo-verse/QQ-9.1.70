package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.w;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.b;
import feedcloud.FeedCloudMeta$RoomInfoData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ua0.c;
import v70.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedLiveItemView extends QFSLayerFeedAbsItemView {
    public QFSLayerFeedLiveItemView(@NonNull Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.geu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSLayerFeedItemView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(b bVar, int i3) {
        if (bVar != null && bVar.g() != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(c.d(bVar));
            String b16 = w.b(bVar.g());
            if (!TextUtils.isEmpty(b16)) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, b16);
            }
            FeedCloudMeta$RoomInfoData h16 = w.h(bVar.g());
            if (h16 != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_ROOM_TYPE, Integer.valueOf(h16.roomType.get()));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_ROOM_ID, Long.valueOf(h16.roomId.get()));
            }
            a.b(buildElementParams, bVar);
            a.a(buildElementParams, bVar);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
            VideoReport.setElementParams(this, buildElementParams);
            VideoReport.setElementReuseIdentifier(this, QCircleDaTongConstant.ElementId.EM_XSJ_MULTIMEDIA + bVar.g().f398449id.get());
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            QLog.i("QFSLayerFeedItemView", 1, "dtReportBindItemView  pos = " + i3 + " , feedType = " + bVar.g().type.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> k3;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (k3 = q06.k()) != null) {
            arrayList.addAll(k3);
        }
        return arrayList;
    }
}
