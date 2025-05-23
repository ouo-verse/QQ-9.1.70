package com.tencent.mobileqq.hitrate.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IPreloadProcHitMgrApi extends QRouteApi {
    void exitProcess(String str);
}
