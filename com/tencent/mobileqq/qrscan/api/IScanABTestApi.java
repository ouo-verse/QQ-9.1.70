package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IScanABTestApi extends QRouteApi {
    boolean isScanUIExpOnline();

    boolean isScanUIExperimentB();

    void reportScanUIExpExposure();
}
