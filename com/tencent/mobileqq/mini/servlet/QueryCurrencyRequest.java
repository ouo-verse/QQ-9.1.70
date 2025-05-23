package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class QueryCurrencyRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_pay.QueryStarCurrency";
    public static final String TAG = "QueryCurrencyRequest";
    private static final String unikey = "QueryStarCurrency";
    private MiniAppMidasPay$StQueryStarCurrencyReq req;

    public QueryCurrencyRequest(COMM.StCommonExt stCommonExt, String str, String str2, int i3, int i16) {
        MiniAppMidasPay$StQueryStarCurrencyReq miniAppMidasPay$StQueryStarCurrencyReq = new MiniAppMidasPay$StQueryStarCurrencyReq();
        this.req = miniAppMidasPay$StQueryStarCurrencyReq;
        if (stCommonExt != null) {
            miniAppMidasPay$StQueryStarCurrencyReq.extInfo.set(stCommonExt);
        }
        this.req.appId.set(str);
        this.req.prepayId.set(str2);
        this.req.starCurrency.set(i3);
        this.req.sandboxEnv.set(i16);
    }

    public static MiniAppMidasPay$StQueryStarCurrencyRsp onResponse(byte[] bArr) {
        MiniAppMidasPay$StQueryStarCurrencyRsp miniAppMidasPay$StQueryStarCurrencyRsp = new MiniAppMidasPay$StQueryStarCurrencyRsp();
        try {
            miniAppMidasPay$StQueryStarCurrencyRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppMidasPay$StQueryStarCurrencyRsp;
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
