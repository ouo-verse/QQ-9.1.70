package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_PAY.MiniAppMidasPay$StWxpayCheckMWebURLReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StWxpayCheckMWebURLRsp;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class WxPayCheckUrlRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_pay.WxpayCheckMWebURL";
    public static final String TAG = "WxPayCheckUrlRequest";
    private MiniAppMidasPay$StWxpayCheckMWebURLReq req;

    public WxPayCheckUrlRequest(String str, String str2) {
        MiniAppMidasPay$StWxpayCheckMWebURLReq miniAppMidasPay$StWxpayCheckMWebURLReq = new MiniAppMidasPay$StWxpayCheckMWebURLReq();
        this.req = miniAppMidasPay$StWxpayCheckMWebURLReq;
        miniAppMidasPay$StWxpayCheckMWebURLReq.appid.set(str);
        this.req.mweb_url.set(str2);
    }

    public static MiniAppMidasPay$StWxpayCheckMWebURLRsp onResponse(byte[] bArr) {
        MiniAppMidasPay$StWxpayCheckMWebURLRsp miniAppMidasPay$StWxpayCheckMWebURLRsp = new MiniAppMidasPay$StWxpayCheckMWebURLRsp();
        try {
            miniAppMidasPay$StWxpayCheckMWebURLRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppMidasPay$StWxpayCheckMWebURLRsp;
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
