package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppInfoRsp;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserAppInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppInfo";
    public static final String TAG = "GetUserAppInfoRequest";
    private INTERFACE$StGetUserAppInfoReq req;

    public GetUserAppInfoRequest(COMM.StCommonExt stCommonExt, List<String> list) {
        INTERFACE$StGetUserAppInfoReq iNTERFACE$StGetUserAppInfoReq = new INTERFACE$StGetUserAppInfoReq();
        this.req = iNTERFACE$StGetUserAppInfoReq;
        iNTERFACE$StGetUserAppInfoReq.appIds.set(list);
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
        return "GetUserAppInfo";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_userapp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        INTERFACE$StGetUserAppInfoRsp iNTERFACE$StGetUserAppInfoRsp = new INTERFACE$StGetUserAppInfoRsp();
        iNTERFACE$StGetUserAppInfoRsp.mergeFrom(bArr);
        jSONObject.put("response", iNTERFACE$StGetUserAppInfoRsp);
        jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
        return jSONObject;
    }
}
