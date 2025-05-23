package com.tencent.mobileqq.app.handler;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IRegisterProxyService extends QRouteApi {
    void onNewRegisterProxyRestPacketEnd();
}
