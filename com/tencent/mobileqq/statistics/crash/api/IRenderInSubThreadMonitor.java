package com.tencent.mobileqq.statistics.crash.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRenderInSubThreadMonitor extends QRouteApi {
    void disableMonitor();

    void enableMonitor();
}
