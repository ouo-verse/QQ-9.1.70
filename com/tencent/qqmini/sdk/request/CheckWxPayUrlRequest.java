package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_PAY.MiniAppMidasPay$StWxpayCheckMWebURLReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StWxpayCheckMWebURLRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class CheckWxPayUrlRequest extends ProtoBufRequest {
    public static final String KEY_URL_VALID = "key_url_valid";
    private static final String TAG = "CheckWxPayUrlRequest";
    private MiniAppMidasPay$StWxpayCheckMWebURLReq req;

    public CheckWxPayUrlRequest(String str, String str2) {
        MiniAppMidasPay$StWxpayCheckMWebURLReq miniAppMidasPay$StWxpayCheckMWebURLReq = new MiniAppMidasPay$StWxpayCheckMWebURLReq();
        this.req = miniAppMidasPay$StWxpayCheckMWebURLReq;
        miniAppMidasPay$StWxpayCheckMWebURLReq.appid.set(str);
        this.req.mweb_url.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "WxpayCheckMWebURL";
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
        MiniAppMidasPay$StWxpayCheckMWebURLRsp miniAppMidasPay$StWxpayCheckMWebURLRsp = new MiniAppMidasPay$StWxpayCheckMWebURLRsp();
        try {
            miniAppMidasPay$StWxpayCheckMWebURLRsp.mergeFrom(bArr);
            jSONObject.put("key_url_valid", miniAppMidasPay$StWxpayCheckMWebURLRsp.is_valid);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
