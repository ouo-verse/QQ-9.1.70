package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkAppConfig extends QRouteApi {
    String getCurrentAppConfig();
}
