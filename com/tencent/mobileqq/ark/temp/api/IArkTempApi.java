package com.tencent.mobileqq.ark.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkTempApi extends QRouteApi {
    String getCurrentAppConfig();

    void initArkEnv();
}
