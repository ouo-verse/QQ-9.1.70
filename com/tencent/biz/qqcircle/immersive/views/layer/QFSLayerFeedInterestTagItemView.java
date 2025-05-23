package com.tencent.biz.qqcircle.immersive.views.layer;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.luggage.wxa.c8.c;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J4\u0010\r\u001a.\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bj\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t`\fH\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/layer/QFSLayerFeedInterestTagItemView;", "Lcom/tencent/biz/qqcircle/immersive/views/layer/QFSLayerDittoItemView;", "Le30/b;", "data", "", c.G, "", "n0", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lkotlin/collections/ArrayList;", "p0", "getLayoutId", "Landroid/content/Context;", "context", "viewType", "<init>", "(Landroid/content/Context;I)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLayerFeedInterestTagItemView extends QFSLayerDittoItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSLayerFeedInterestTagItemView(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gei;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    protected void n0(@NotNull b data, int pos) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.g() != null && data.g().dittoFeed != null) {
            VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_INTEREST_COLLECTION_CARD);
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            Map<String, Object> d16 = ua0.c.d(data);
            Intrinsics.checkNotNullExpressionValue(d16, "convertDataToDTParamsMap(data)");
            map.putAll(d16);
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(pos + 1));
            VideoReport.setElementParams(this, map);
            VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this, EndExposurePolicy.REPORT_ALL);
            QLog.i("QFSLayerFeedInterestTagItemView", 1, "dtReportBindItemView  pos = " + pos + " , dittoId = " + data.g().dittoFeed.dittoId.get());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.layer.QFSLayerFeedAbsItemView
    @NotNull
    protected ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> p0() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> j3;
        ArrayList<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> arrayList = new ArrayList<>();
        com.tencent.biz.qqcircle.immersive.layer.base.b q06 = q0();
        if (q06 != null && (j3 = q06.j()) != null) {
            arrayList.addAll(j3);
        }
        return arrayList;
    }
}
