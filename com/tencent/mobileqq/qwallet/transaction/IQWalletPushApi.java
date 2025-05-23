package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletPushApi extends QRouteApi {
    void parseMsg0x210Sub0x66(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16);

    void parseMsg0x210Sub0x7e(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16);
}
