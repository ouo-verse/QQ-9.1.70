package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppLikeReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppLikeRsp;
import cooperation.qzone.QzoneIPCModule;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetUserAppLikeRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppLike";
    public static final String TAG = "SetUserAppLikeRequest";
    private INTERFACE$StSetUserAppLikeReq req;

    public SetUserAppLikeRequest(COMM.StCommonExt stCommonExt, String str, int i3) {
        INTERFACE$StSetUserAppLikeReq iNTERFACE$StSetUserAppLikeReq = new INTERFACE$StSetUserAppLikeReq();
        this.req = iNTERFACE$StSetUserAppLikeReq;
        iNTERFACE$StSetUserAppLikeReq.appId.set(str);
        this.req.doLike.set(i3);
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
        return "SetUserAppLike";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_userapp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        INTERFACE$StSetUserAppLikeRsp iNTERFACE$StSetUserAppLikeRsp = new INTERFACE$StSetUserAppLikeRsp();
        iNTERFACE$StSetUserAppLikeRsp.mergeFrom(bArr);
        jSONObject.put("response", iNTERFACE$StSetUserAppLikeRsp);
        jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
        return jSONObject;
    }
}
