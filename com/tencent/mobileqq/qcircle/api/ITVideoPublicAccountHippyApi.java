package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ITVideoPublicAccountHippyApi extends QRouteApi {
    HippyAPIProvider createHippyProvider();

    boolean isTVideoPublicAccountModule(String str);
}
