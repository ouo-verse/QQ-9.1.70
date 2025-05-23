package com.tencent.ams.dynamic;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IDynamicApi extends QRouteApi {
    void initDynamicSDK();

    void setGlobalParams();
}
