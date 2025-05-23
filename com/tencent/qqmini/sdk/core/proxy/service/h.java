package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.utils.thread.ThreadPools;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy;

/* compiled from: P */
@ProxyService(proxy = ThreadProxy.class)
/* loaded from: classes23.dex */
public class h implements ThreadProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runComputationTask(Runnable runnable) {
        ThreadPools.getComputationThreadPool().execute(runnable);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runIOTask(Runnable runnable) {
        ThreadPools.getDiskIOThreadPool().execute(runnable);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThreadProxy
    public void runNetTask(Runnable runnable) {
        ThreadPools.getNetworkIOThreadPool().execute(runnable);
    }
}
