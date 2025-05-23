package com.tencent.mobileqq.qqlive.api.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveCallMainServiceApi extends QRouteApi {
    void qualityReport(int i3, QQLiveQualityReportData.Builder builder);
}
