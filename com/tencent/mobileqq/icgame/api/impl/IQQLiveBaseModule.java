package com.tencent.mobileqq.icgame.api.impl;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class IQQLiveBaseModule implements IQQLiveModule {
    protected IQQLiveSDK sdkImpl;

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.sdkImpl = iQQLiveSDK;
    }
}
