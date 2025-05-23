package com.tencent.mobileqq.ark.temp.api.impl;

import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.temp.api.IArkTempApi;
import l91.a;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkTempApiImpl implements IArkTempApi {
    @Override // com.tencent.mobileqq.ark.temp.api.IArkTempApi
    public String getCurrentAppConfig() {
        return f.b();
    }

    @Override // com.tencent.mobileqq.ark.temp.api.IArkTempApi
    public void initArkEnv() {
        a.a();
    }
}
