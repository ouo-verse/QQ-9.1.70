package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy;

/* compiled from: P */
@ProxyService(proxy = ThreadProxy.class)
/* loaded from: classes34.dex */
public class bu implements ThreadProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runComputationTask(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runIOTask(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 64, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runNetTask(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 128, null, false);
    }
}
