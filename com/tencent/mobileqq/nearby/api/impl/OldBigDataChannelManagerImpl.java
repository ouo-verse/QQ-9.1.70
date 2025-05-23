package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.nearby.api.OldBigDataChannelManager;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OldBigDataChannelManagerImpl implements IOldBigDataChannelManager, Manager {
    private OldBigDataChannelManager mOldBigDataChannelManager;

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public String getCircleSrvUrl() {
        return this.mOldBigDataChannelManager.d();
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public byte[] getSrvKey() {
        return this.mOldBigDataChannelManager.e();
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public byte[] getSrvSig() {
        return this.mOldBigDataChannelManager.f();
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public void init(AppInterface appInterface) {
        this.mOldBigDataChannelManager = new OldBigDataChannelManager(appInterface);
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager, mqq.manager.Manager
    public void onDestroy() {
        this.mOldBigDataChannelManager.onDestroy();
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public void onResponseException() {
        this.mOldBigDataChannelManager.g();
    }

    @Override // com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager
    public void saveSrvParam(byte[] bArr, byte[] bArr2, String[] strArr) {
        this.mOldBigDataChannelManager.i(bArr, bArr2, strArr);
    }
}
