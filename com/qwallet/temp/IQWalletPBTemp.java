package com.qwallet.temp;

import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66$MsgBody;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x7e$MsgBody$OnlinePush;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQWalletPBTemp extends QRouteApi {
    QWalletSubmsgtype0x66$MsgBody convertToMsgBody(byte[] bArr) throws Exception;

    QWalletSubmsgtype0x7e$MsgBody$OnlinePush convertToOnlinePush(byte[] bArr) throws Exception;

    QWalletGoldMsgTipsElem convertTroopTips(Object obj) throws Exception;

    QWalletGoldMsgTipsElem convertTroopTips(byte[] bArr) throws Exception;
}
