package com.tencent.gdtad.config.impl;

import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.config.data.c;
import com.tencent.gdtad.config.data.j;
import com.tencent.gdtad.config.data.k;
import wm0.b;

/* loaded from: classes6.dex */
public final class GdtConfigAPIImpl implements IGdtConfigAPI {
    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public c getConfigForDeviceInfo() {
        return b.m().d();
    }

    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public j getConfigForQuickApp() {
        return b.m().k();
    }

    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public k getConfigForWXCustomerService() {
        return b.m().l();
    }

    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public boolean isDeviceInfoWXMINIAuthorizationStateEnabled() {
        return b.m().n();
    }

    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public boolean isHippyModuleV2Enabled() {
        return b.m().q();
    }

    @Override // com.tencent.gdtad.config.IGdtConfigAPI
    public boolean isJSBundleV2Enabled() {
        return false;
    }
}
