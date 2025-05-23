package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy;

/* compiled from: P */
@ProxyService(proxy = MiniQMMKVProxy.class)
/* loaded from: classes34.dex */
public class ao extends MiniQMMKVProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public int getMiniAppInt(String str, int i3) {
        return MiniAppMMKVUtils.getInt(str, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public long getMiniAppLong(String str, long j3) {
        return MiniAppMMKVUtils.getLong(str, j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public String getMiniAppString(String str, String str2) {
        return MiniAppMMKVUtils.getString(str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public int getMiniGameInt(String str, int i3) {
        return MiniGameMMKVUtils.INSTANCE.getInt(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public long getMiniGameLong(String str, long j3) {
        return MiniGameMMKVUtils.INSTANCE.getLong(str, j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public String getMiniGameString(String str, String str2) {
        return MiniGameMMKVUtils.INSTANCE.getString(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniAppInt(String str, int i3) {
        MiniAppMMKVUtils.putInt(str, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniAppLong(String str, long j3) {
        MiniAppMMKVUtils.putLong(str, j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniAppString(String str, String str2) {
        MiniAppMMKVUtils.putString(str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniGameInt(String str, int i3) {
        MiniGameMMKVUtils.INSTANCE.saveInt(str, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniGameLong(String str, long j3) {
        MiniGameMMKVUtils.INSTANCE.saveLong(str, j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy
    public void putMiniGameString(String str, String str2) {
        MiniGameMMKVUtils.INSTANCE.saveString(str, str2);
    }
}
