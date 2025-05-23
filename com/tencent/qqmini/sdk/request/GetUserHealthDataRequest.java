package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserHealthDataReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserHealthDataRsp;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserHealthDataRequest extends ProtoBufRequest {
    public static final String TAG = "GetUserHealthDataRequest";
    private INTERFACE$StGetUserHealthDataReq req;

    public GetUserHealthDataRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetUserHealthDataReq iNTERFACE$StGetUserHealthDataReq = new INTERFACE$StGetUserHealthDataReq();
        this.req = iNTERFACE$StGetUserHealthDataReq;
        iNTERFACE$StGetUserHealthDataReq.appid.set(str);
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
        return "GetUserHealthData";
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
        INTERFACE$StGetUserHealthDataRsp iNTERFACE$StGetUserHealthDataRsp = new INTERFACE$StGetUserHealthDataRsp();
        try {
            iNTERFACE$StGetUserHealthDataRsp.mergeFrom(bArr);
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetUserHealthDataRsp.encryptedData.get());
            jSONObject.put("iv", iNTERFACE$StGetUserHealthDataRsp.f24962iv.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetUserHealthDataRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
