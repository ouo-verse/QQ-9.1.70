package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQFSPlayerStrategyApi extends QRouteApi {
    int getAV1Flag();

    String getCurrentAv1ExpName();

    boolean isEnableAV1();
}
