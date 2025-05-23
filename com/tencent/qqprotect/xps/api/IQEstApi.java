package com.tencent.qqprotect.xps.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQEstApi extends QRouteApi {
    void delayReportSecInfo();

    String getSecInfo();

    void rtReportSecInfo(int i3);
}
