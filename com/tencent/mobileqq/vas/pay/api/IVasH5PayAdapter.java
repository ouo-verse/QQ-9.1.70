package com.tencent.mobileqq.vas.pay.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasH5PayAdapter extends QRouteApi {
    String getDiyCardH5Pay();

    String getSvipCallbackSN();

    long getWebViewTransparentConstants();
}
