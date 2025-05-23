package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;

@MiniKeep
/* loaded from: classes23.dex */
public class FakeProxyManager implements IProxyManager {
    @Override // com.tencent.qqmini.sdk.launcher.core.IProxyManager
    public <T> T get(Class cls) {
        return (T) ProxyManager.get(cls);
    }
}
