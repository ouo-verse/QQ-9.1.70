package com.tencent.gdtad.config;

import com.tencent.gdtad.config.data.c;
import com.tencent.gdtad.config.data.j;
import com.tencent.gdtad.config.data.k;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtConfigAPI extends QRouteApi {
    c getConfigForDeviceInfo();

    j getConfigForQuickApp();

    k getConfigForWXCustomerService();

    boolean isDeviceInfoWXMINIAuthorizationStateEnabled();

    boolean isHippyModuleV2Enabled();

    boolean isJSBundleV2Enabled();
}
