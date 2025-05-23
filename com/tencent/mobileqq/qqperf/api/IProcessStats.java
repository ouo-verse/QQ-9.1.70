package com.tencent.mobileqq.qqperf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IProcessStats extends QRouteApi {
    double getCpuUsage();
}
