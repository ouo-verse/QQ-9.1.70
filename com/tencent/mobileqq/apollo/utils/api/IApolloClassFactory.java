package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IApolloClassFactory extends QRouteApi {
    String getApolloExtensionHandlerClassName();

    Class getApolloExtensionServletClass();
}
