package com.tencent.qzonehub.api.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneExceptionReport extends QRouteApi {
    void doReport(Throwable th5, String str);
}
