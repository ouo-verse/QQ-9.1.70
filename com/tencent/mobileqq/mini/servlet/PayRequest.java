package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayRsp;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class PayRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_pay.GamePay";
    public static final String TAG = "MiniAppPayRequest";
    private MiniAppMidasPay$StGamePayReq req;

    public PayRequest(String str, COMM.StCommonExt stCommonExt, String str2, int i3, int i16, int i17, int i18, int i19) {
        MiniAppMidasPay$StGamePayReq miniAppMidasPay$StGamePayReq = new MiniAppMidasPay$StGamePayReq();
        this.req = miniAppMidasPay$StGamePayReq;
        if (stCommonExt != null) {
            miniAppMidasPay$StGamePayReq.extInfo.set(stCommonExt);
        }
        this.req.appId.set(str);
        this.req.prepayId.set(str2);
        this.req.starCurrency.set(i3);
        this.req.balanceAmount.set(i16);
        this.req.topupAmount.set(i17);
        this.req.payChannel.set(i18);
        this.req.sandboxEnv.set(i19);
    }

    public static MiniAppMidasPay$StGamePayRsp onResponse(byte[] bArr) {
        MiniAppMidasPay$StGamePayRsp miniAppMidasPay$StGamePayRsp = new MiniAppMidasPay$StGamePayRsp();
        try {
            miniAppMidasPay$StGamePayRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppMidasPay$StGamePayRsp;
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
