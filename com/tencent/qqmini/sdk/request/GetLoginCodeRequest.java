package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE$StGetCodeRsp;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetCodeRequest;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetLoginCodeRequest extends ProtoBufRequest {
    private INTERFACE$StGetCodeReq req;

    public GetLoginCodeRequest(String str) {
        INTERFACE$StGetCodeReq iNTERFACE$StGetCodeReq = new INTERFACE$StGetCodeReq();
        this.req = iNTERFACE$StGetCodeReq;
        iNTERFACE$StGetCodeReq.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return HttpGetCodeRequest.CMD_STRING;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_program_auth";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetCodeRsp iNTERFACE$StGetCodeRsp = new INTERFACE$StGetCodeRsp();
        try {
            iNTERFACE$StGetCodeRsp.mergeFrom(bArr);
            jSONObject.put("code", iNTERFACE$StGetCodeRsp.code.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
