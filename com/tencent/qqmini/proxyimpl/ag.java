package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;

/* compiled from: P */
@ProxyService(proxy = IMiniAppNotifyProxy.class)
/* loaded from: classes34.dex */
public class ag implements IMiniAppNotifyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy
    public void report(String str, int i3, String str2, String str3, long j3) {
        MiniAppNotify.f246657g.notify(str, i3, str2, str3, j3);
    }
}
