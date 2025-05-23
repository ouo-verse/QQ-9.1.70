package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserInfoExtraRsp;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserInfoExtraRequest extends ProtoBufRequest {
    private static final String TAG = "GetUserInfoExtraRequest";
    private INTERFACE$StGetUserInfoExtraReq req;

    public GetUserInfoExtraRequest(String str) {
        INTERFACE$StGetUserInfoExtraReq iNTERFACE$StGetUserInfoExtraReq = new INTERFACE$StGetUserInfoExtraReq();
        this.req = iNTERFACE$StGetUserInfoExtraReq;
        iNTERFACE$StGetUserInfoExtraReq.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return com.tencent.mobileqq.mini.servlet.GetUserInfoExtraRequest.TAG;
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetUserInfoExtraRsp iNTERFACE$StGetUserInfoExtraRsp = new INTERFACE$StGetUserInfoExtraRsp();
        try {
            iNTERFACE$StGetUserInfoExtraRsp.mergeFrom(bArr);
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetUserInfoExtraRsp.encryptedData.get());
            jSONObject.put("iv", iNTERFACE$StGetUserInfoExtraRsp.f24963iv.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
