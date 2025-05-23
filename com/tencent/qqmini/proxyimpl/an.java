package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.minigame.utils.QQMiniAppUtils;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy;

/* compiled from: P */
@ProxyService(proxy = ConfigProxy.class)
/* loaded from: classes34.dex */
public class an implements ConfigProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy
    public int getMaxContainerStorageSize() {
        return QQMiniAppUtils.getConfig().f391863d.f391864a;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy
    public boolean isloadByContainer() {
        return QQMiniAppUtils.getConfig().f391863d.f391866c;
    }
}
