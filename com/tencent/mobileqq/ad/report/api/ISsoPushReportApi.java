package com.tencent.mobileqq.ad.report.api;

import com.tencent.mobileqq.ad.report.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ISsoPushReportApi extends QRouteApi {
    void report(a aVar);
}
