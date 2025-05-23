package com.tencent.icgame.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IQQLiveReportApi extends QRouteApi {
    String generateTraceId();
}
