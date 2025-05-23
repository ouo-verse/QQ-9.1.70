package com.tencent.mobileqq.qcircle.api;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleClassApi extends QRouteApi {
    Class getQCircleHandlerClass();

    BaseRequest getQQCircleGetGroupCountRequest(long j3);

    void initDelegate();
}
