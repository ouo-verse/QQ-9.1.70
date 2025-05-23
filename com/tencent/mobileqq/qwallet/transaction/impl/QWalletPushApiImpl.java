package com.tencent.mobileqq.qwallet.transaction.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletPushManager;
import com.tencent.mobileqq.qwallet.transaction.IQWalletPushApi;

/* loaded from: classes16.dex */
public class QWalletPushApiImpl implements IQWalletPushApi {
    @Override // com.tencent.mobileqq.qwallet.transaction.IQWalletPushApi
    public void parseMsg0x210Sub0x66(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16) {
        QWalletPushManager.r(baseQQAppInterface, bArr, j3, i3, j16, i16);
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.IQWalletPushApi
    public void parseMsg0x210Sub0x7e(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16) {
        QWalletPushManager.v(baseQQAppInterface, bArr, j3, i3, j16, i16);
    }
}
