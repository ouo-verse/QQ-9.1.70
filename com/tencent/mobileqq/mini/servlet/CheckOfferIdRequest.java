package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StMiniCheckOfferIdReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StMiniCheckOfferIdRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CheckOfferIdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_pay.MiniCheckOfferId";
    public static final String TAG = "CheckOfferIdRequest";
    private MiniAppMidasPay$StMiniCheckOfferIdReq req;

    public CheckOfferIdRequest(COMM.StCommonExt stCommonExt, String str, String str2) {
        MiniAppMidasPay$StMiniCheckOfferIdReq miniAppMidasPay$StMiniCheckOfferIdReq = new MiniAppMidasPay$StMiniCheckOfferIdReq();
        this.req = miniAppMidasPay$StMiniCheckOfferIdReq;
        miniAppMidasPay$StMiniCheckOfferIdReq.appId.set(str);
        this.req.offerId.set(str2);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static MiniAppMidasPay$StMiniCheckOfferIdRsp onResponse(byte[] bArr) {
        MiniAppMidasPay$StMiniCheckOfferIdRsp miniAppMidasPay$StMiniCheckOfferIdRsp = new MiniAppMidasPay$StMiniCheckOfferIdRsp();
        try {
            miniAppMidasPay$StMiniCheckOfferIdRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppMidasPay$StMiniCheckOfferIdRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
