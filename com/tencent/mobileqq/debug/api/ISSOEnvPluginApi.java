package com.tencent.mobileqq.debug.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eb1.a;
import org.jetbrains.annotations.NotNull;

@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface ISSOEnvPluginApi extends QRouteApi {
    void handleGetConfig(AppInterface appInterface, @NotNull a aVar, String... strArr);

    void handleSetConfig(AppInterface appInterface, @NotNull a aVar, String... strArr);
}
