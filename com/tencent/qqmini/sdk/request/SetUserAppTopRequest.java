package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppTopReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppTopRsp;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetUserAppTopRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppTop";
    private INTERFACE$StSetUserAppTopReq req;

    public SetUserAppTopRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, int i17, int i18, int i19) {
        INTERFACE$StSetUserAppTopReq iNTERFACE$StSetUserAppTopReq = new INTERFACE$StSetUserAppTopReq();
        this.req = iNTERFACE$StSetUserAppTopReq;
        iNTERFACE$StSetUserAppTopReq.appId.set(str);
        this.req.verType.set(i16);
        this.req.putTop.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
        this.req.oldIdx.set(i17);
        this.req.newIdx.set(i18);
        this.req.fromNewDownload.set(i19);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "SetUserAppTop";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_userapp";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        new INTERFACE$StSetUserAppTopRsp().mergeFrom(bArr);
        return jSONObject;
    }
}
