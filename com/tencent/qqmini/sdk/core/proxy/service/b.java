package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy;

/* compiled from: P */
@ProxyService(proxy = ConfigProxy.class)
/* loaded from: classes23.dex */
public class b implements ConfigProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy
    public int getMaxContainerStorageSize() {
        return 100;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy
    public boolean isloadByContainer() {
        return true;
    }
}
