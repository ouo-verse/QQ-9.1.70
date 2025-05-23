package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE$StGetFormIdRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetFormIdRequest extends ProtoBufRequest {
    private static final String TAG = "GetFormIdRequest";
    private INTERFACE$StGetFormIdReq req;

    public GetFormIdRequest(String str) {
        INTERFACE$StGetFormIdReq iNTERFACE$StGetFormIdReq = new INTERFACE$StGetFormIdReq();
        this.req = iNTERFACE$StGetFormIdReq;
        iNTERFACE$StGetFormIdReq.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetFormId";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_userapp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetFormIdRsp iNTERFACE$StGetFormIdRsp = new INTERFACE$StGetFormIdRsp();
        try {
            iNTERFACE$StGetFormIdRsp.mergeFrom(bArr);
            jSONObject.put("formId", iNTERFACE$StGetFormIdRsp.formId.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
