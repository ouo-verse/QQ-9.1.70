package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import k91.b;

@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkIPCService extends QRouteApi {
    public static final String NAME = "ArkQQAPIIPCModule";

    void call(b bVar);

    QIPCModule getModule();
}
