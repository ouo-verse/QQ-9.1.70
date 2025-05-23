package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StDelPhoneNumbersReq;
import NS_MINI_INTERFACE.INTERFACE$StDelPhoneNumbersRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class DelPhoneNumberRequest extends ProtoBufRequest {
    private static final String TAG = "DelPhoneNumberRequest";
    private INTERFACE$StDelPhoneNumbersReq req;

    public DelPhoneNumberRequest(String str, String str2) {
        INTERFACE$StDelPhoneNumbersReq iNTERFACE$StDelPhoneNumbersReq = new INTERFACE$StDelPhoneNumbersReq();
        this.req = iNTERFACE$StDelPhoneNumbersReq;
        iNTERFACE$StDelPhoneNumbersReq.purePhoneNumber.set(str2);
        this.req.appId.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return new byte[0];
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "DelPhoneNumbers";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        try {
            new INTERFACE$StDelPhoneNumbersRsp().mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
