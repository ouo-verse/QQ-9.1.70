package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IARGLSurfaceViewUtilApi extends QRouteApi {
    boolean doNotInterceptOpenCamera(AppRuntime appRuntime);

    boolean isNeedCloseCamera(AppRuntime appRuntime);
}
