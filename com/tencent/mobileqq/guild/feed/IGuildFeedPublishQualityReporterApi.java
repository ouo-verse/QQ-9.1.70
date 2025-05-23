package com.tencent.mobileqq.guild.feed;

import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedPublishQualityReporterApi extends QRouteApi {
    void mapReportEndKey(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);

    void mapReportStartKey(String str);

    void uploadQualityReport(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder);
}
