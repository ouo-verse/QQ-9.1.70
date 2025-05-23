package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetSDKOpenKeyTokenReq;
import NS_MINI_INTERFACE.INTERFACE$StGetSDKOpenKeyTokenRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetSDKOpenKeyTokenRequest extends ProtoBufRequest {
    public static final String TAG = "GetSDKOpenKeyTokenRequest";
    private INTERFACE$StGetSDKOpenKeyTokenReq req;

    public GetSDKOpenKeyTokenRequest(COMM.StCommonExt stCommonExt) {
        INTERFACE$StGetSDKOpenKeyTokenReq iNTERFACE$StGetSDKOpenKeyTokenReq = new INTERFACE$StGetSDKOpenKeyTokenReq();
        this.req = iNTERFACE$StGetSDKOpenKeyTokenReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetSDKOpenKeyTokenReq.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetSDKOpenKeyToken";
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
        INTERFACE$StGetSDKOpenKeyTokenRsp iNTERFACE$StGetSDKOpenKeyTokenRsp = new INTERFACE$StGetSDKOpenKeyTokenRsp();
        try {
            iNTERFACE$StGetSDKOpenKeyTokenRsp.mergeFrom(bArr);
            jSONObject.put("token", iNTERFACE$StGetSDKOpenKeyTokenRsp.token.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
