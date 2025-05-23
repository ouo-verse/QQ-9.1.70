package com.tencent.qqperf.debug.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IStartupPerfApi extends QRouteApi {
    long getShowCostTime();

    double getSyncMsgTime();
}
