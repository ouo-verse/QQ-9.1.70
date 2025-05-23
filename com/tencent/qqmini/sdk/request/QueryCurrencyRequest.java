package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QueryCurrencyRequest extends ProtoBufRequest {
    private static final String TAG = "QueryCurrencyRequest";
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

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "QueryStarCurrency";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_pay";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MiniAppMidasPay$StQueryStarCurrencyRsp miniAppMidasPay$StQueryStarCurrencyRsp = new MiniAppMidasPay$StQueryStarCurrencyRsp();
        try {
            miniAppMidasPay$StQueryStarCurrencyRsp.mergeFrom(bArr);
            jSONObject.put("response", miniAppMidasPay$StQueryStarCurrencyRsp);
            jSONObject.put(QzoneIPCModule.RESULT_CODE, jSONObject.get("retCode"));
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("QueryCurrencyRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
