package com.tencent.mobileqq.webview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IARTransparentWebViewPluginApi extends QRouteApi {
    void startRender();
}
