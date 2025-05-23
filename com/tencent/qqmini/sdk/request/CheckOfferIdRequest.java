package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StMiniCheckOfferIdReq;
import NS_MINI_APP_PAY.MiniAppMidasPay$StMiniCheckOfferIdRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CheckOfferIdRequest extends ProtoBufRequest {
    private static final String TAG = "CheckOfferIdRequest";
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

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "MiniCheckOfferId";
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
        MiniAppMidasPay$StMiniCheckOfferIdRsp miniAppMidasPay$StMiniCheckOfferIdRsp = new MiniAppMidasPay$StMiniCheckOfferIdRsp();
        try {
            miniAppMidasPay$StMiniCheckOfferIdRsp.mergeFrom(bArr);
            jSONObject.put("result", miniAppMidasPay$StMiniCheckOfferIdRsp.result.get());
            jSONObject.put("ext", miniAppMidasPay$StMiniCheckOfferIdRsp.extInfo);
            jSONObject.put("firstRefer", miniAppMidasPay$StMiniCheckOfferIdRsp.firstRefer);
            jSONObject.put("firstVia", miniAppMidasPay$StMiniCheckOfferIdRsp.firstVia);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("CheckOfferIdRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
