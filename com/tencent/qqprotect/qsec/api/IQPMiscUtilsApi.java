package com.tencent.qqprotect.qsec.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQPMiscUtilsApi extends QRouteApi {
    String getAppPackageName();
}
