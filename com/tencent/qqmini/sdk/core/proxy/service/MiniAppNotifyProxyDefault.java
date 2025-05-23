package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@ProxyService(proxy = IMiniAppNotifyProxy.class)
/* loaded from: classes23.dex */
public class MiniAppNotifyProxyDefault implements IMiniAppNotifyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy
    public void report(String str, int i3, String str2, String str3, long j3) {
        QMLog.d("IMiniAppNotifyProxy", "appid:" + str + " scene:" + i3 + " via:" + str2 + " event:" + str3 + " timestamp:" + j3);
    }
}
