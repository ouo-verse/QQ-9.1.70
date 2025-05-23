package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAvatarReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAvatarRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SetAvatarRequest extends ProtoBufRequest {
    private static final String TAG = "SetAvatarRequest";
    private INTERFACE$StSetUserAvatarReq req;

    public SetAvatarRequest(COMM.StCommonExt stCommonExt, String str, String str2, int i3, String str3, String str4) {
        INTERFACE$StSetUserAvatarReq iNTERFACE$StSetUserAvatarReq = new INTERFACE$StSetUserAvatarReq();
        this.req = iNTERFACE$StSetUserAvatarReq;
        iNTERFACE$StSetUserAvatarReq.appid.set(str);
        this.req.uin.set(str2);
        this.req.set_type.set(i3);
        this.req.item_id.set(str3);
        this.req.busi_info.set(str4);
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
        return "SetUserAvatar";
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
        try {
            new INTERFACE$StSetUserAvatarRsp().mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("SetAvatarRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
