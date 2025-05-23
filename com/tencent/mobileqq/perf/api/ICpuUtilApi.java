package com.tencent.mobileqq.perf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICpuUtilApi extends QRouteApi {
    float getCpuUsage(int i3);
}
