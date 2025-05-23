package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy;

/* compiled from: P */
@ProxyService(proxy = PrivacyProxy.class)
/* loaded from: classes23.dex */
public class e implements PrivacyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getAndroidId() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getIMEI() {
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getPhoneModel() {
        return DeviceInfoMonitor.getModel();
    }
}
