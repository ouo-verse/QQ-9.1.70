package com.tencent.mobileqq.perf.startup.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IStartupMonitor extends QRouteApi {
    void traceBegin(String str);

    void traceEnd(String str);
}
