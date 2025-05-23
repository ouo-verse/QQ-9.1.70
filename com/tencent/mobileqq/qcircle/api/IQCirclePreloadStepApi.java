package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQCirclePreloadStepApi extends QRouteApi {
    void doPreload();
}
