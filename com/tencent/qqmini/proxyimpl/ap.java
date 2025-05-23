package com.tencent.qqmini.proxyimpl;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy;

/* compiled from: P */
@ProxyService(proxy = IMiniReportProxy.class)
/* loaded from: classes34.dex */
public class ap implements IMiniReportProxy {

    /* renamed from: a, reason: collision with root package name */
    private static String f347786a;

    public static String a() {
        return f347786a;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMiniReportProxy
    public void setMiniAppInfo(String str) {
        f347786a = str;
    }
}
