package com.tencent.mobileqq.vas.svip.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISVIPHandlerProxy extends QRouteApi {
    String getImplClassName();
}
