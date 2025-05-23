package com.tencent.mobileqq.perf.tracker.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICpuMonitorApi extends QRouteApi {
    void startCpuMonitor(Float f16);
}
