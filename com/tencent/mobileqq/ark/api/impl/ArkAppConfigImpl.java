package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkAppConfig;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppConfigImpl implements IArkAppConfig {
    private static final String TAG = "ArkAppConfigImpl";

    @Override // com.tencent.mobileqq.ark.api.IArkAppConfig
    public String getCurrentAppConfig() {
        return ArkHelperImpl.getCurrentAppConfig();
    }
}
