package com.tencent.qqmini.sdk.core.proxy.service;

import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import java.util.Map;

/* compiled from: P */
@ProxyService(proxy = ThirdPartyMiniPageProxy.class)
/* loaded from: classes23.dex */
public class g implements ThirdPartyMiniPageProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public Map<String, String> getShareParam(@Nullable String str, int i3) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needRestart(@Nullable String str, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needShareToQQ(@Nullable String str, int i3) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy
    public boolean needShareToQZone(@Nullable String str, int i3) {
        return true;
    }
}
