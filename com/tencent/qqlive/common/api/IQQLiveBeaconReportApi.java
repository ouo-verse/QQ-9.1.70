package com.tencent.qqlive.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import ft3.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQLiveBeaconReportApi extends QRouteApi {
    void init();

    c newReportTask();
}
