package com.tencent.mobileqq.qwallet.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;

/* loaded from: classes16.dex */
public class QWalletPayApiImpl implements IQWalletPayApi {
    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public void clearAllPayData() {
        QWalletPushManager.e();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public IQWalletPayApi.a getIdlePayData(boolean z16) {
        return QWalletPushManager.f(z16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public int getIdlePayDataCount() {
        return QWalletPushManager.g();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public int getPayBridgeCode(int i3) {
        return QWalletPushManager.h(i3);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public void onQQForeground(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        QWalletPushManager.n(baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletPayApi
    public void removePayingData() {
        QWalletPushManager.x();
    }
}
