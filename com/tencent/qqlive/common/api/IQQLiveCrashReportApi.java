package com.tencent.qqlive.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import et3.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQLiveCrashReportApi extends QRouteApi {
    void reportCrash(b bVar);
}
