package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopQIPCModuleApi extends QRouteApi {
    public static final String NAME = "TroopQIPCModule";

    QIPCModule getTroopIPCModule();
}
