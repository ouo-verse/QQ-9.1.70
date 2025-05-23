package com.tencent.mobileqq.persistence.service;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IDBMonitorService extends QRouteApi {
    int getDBSizeReportedSampling();

    int getMarketDBCostReportedSampling(String str);

    int getOperateCostReportedSampling();

    int getOperateCostReportedThreshold();

    boolean isDBSizeReported();

    boolean isMarketDBCostReported();

    boolean isOperateCostReported();

    void reportDBEventByBeacon(String str, String str2, Map<String, String> map);
}
