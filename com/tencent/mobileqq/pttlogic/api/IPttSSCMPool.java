package com.tencent.mobileqq.pttlogic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.wstt.SSCM.a;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttSSCMPool extends QRouteApi {
    void clear();

    a getSSCM();

    void returnObject(a aVar);
}
