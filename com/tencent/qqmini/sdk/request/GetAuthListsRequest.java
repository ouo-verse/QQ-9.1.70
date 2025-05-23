package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetAuthListReq;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetAuthListsRequest extends ProtoBufRequest {
    private static final String TAG = "GetAuthListsRequest";
    private INTERFACE$StGetAuthListReq req;

    public GetAuthListsRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetAuthListReq iNTERFACE$StGetAuthListReq = new INTERFACE$StGetAuthListReq();
        this.req = iNTERFACE$StGetAuthListReq;
        iNTERFACE$StGetAuthListReq.appid.set(str);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetAuthList";
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
        try {
            jSONObject.put("authList", bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
