package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleRMonitorApi;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleRMonitorApiImpl implements IQCircleRMonitorApi {
    private final IPerfApi mPerfApi = (IPerfApi) QRoute.api(IPerfApi.class);

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRMonitorApi
    public void traceEnd(String str) {
        this.mPerfApi.traceEnd(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleRMonitorApi
    public void traceStart(String str) {
        this.mPerfApi.traceStart(str);
    }
}
