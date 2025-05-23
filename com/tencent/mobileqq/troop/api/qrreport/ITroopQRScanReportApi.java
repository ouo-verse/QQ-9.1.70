package com.tencent.mobileqq.troop.api.qrreport;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopQRScanReportApi extends QRouteApi {
    void troopQRScanJumpTargetDTReport(String str, String str2);
}
