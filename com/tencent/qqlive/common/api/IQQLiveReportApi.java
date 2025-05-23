package com.tencent.qqlive.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQLiveReportApi extends QRouteApi {
    String generateTraceId();

    void mapEndKeyReport(String str, QQLiveQualityReportData.Builder builder);

    void mapStartKey(String str);

    void qualityReport(QQLiveQualityReportData.Builder builder);
}
