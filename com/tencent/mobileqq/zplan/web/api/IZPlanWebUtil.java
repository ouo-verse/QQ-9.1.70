package com.tencent.mobileqq.zplan.web.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanWebUtil extends QRouteApi {
    boolean isApolloProxyEnable();

    boolean isZPlanWebOfflineResLoaded();
}
