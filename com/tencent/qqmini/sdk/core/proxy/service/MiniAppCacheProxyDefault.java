package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;

@ProxyService(proxy = MiniAppCacheProxy.class)
/* loaded from: classes23.dex */
public class MiniAppCacheProxyDefault implements MiniAppCacheProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean deleteCacheByTimeStamp(long j3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean enableMiniAppCache() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public long getDeleteIntervalTime() {
        return 0L;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public byte[] getIdInfo(String str, String str2) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public MiniAppCacheProxy.LinkData getLinkInfo(String str, int i3) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean saveIdInfo(String str, String str2, byte[] bArr, long j3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean saveLinkInfo(String str, int i3, String str2, byte[] bArr, long j3) {
        return false;
    }
}
