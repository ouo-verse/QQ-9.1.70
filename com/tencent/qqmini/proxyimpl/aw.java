package com.tencent.qqmini.proxyimpl;

import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy;

/* compiled from: P */
/* loaded from: classes34.dex */
public class aw implements PrivacyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getAndroidId() {
        return com.tencent.mobileqq.utils.ah.e();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getIMEI() {
        return MobileInfoUtil.getImei();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PrivacyProxy
    public String getPhoneModel() {
        return DeviceInfoMonitor.getModel();
    }
}
