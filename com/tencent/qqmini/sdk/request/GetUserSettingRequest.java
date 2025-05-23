package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetUserSettingRequest extends ProtoBufRequest {
    private static final String TAG = "VerifyPluginRequest";
    private INTERFACE$StGetUserSettingReq req;

    public GetUserSettingRequest(String str, String str2, String str3) {
        INTERFACE$StGetUserSettingReq iNTERFACE$StGetUserSettingReq = new INTERFACE$StGetUserSettingReq();
        this.req = iNTERFACE$StGetUserSettingReq;
        iNTERFACE$StGetUserSettingReq.appid.set(str);
        this.req.openid.set(str2);
        this.req.settingItem.set(str3);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetUserSetting";
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
        INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
        try {
            iNTERFACE$StGetUserSettingRsp.mergeFrom(bArr);
            INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = iNTERFACE$StGetUserSettingRsp.setting;
            if (iNTERFACE$StUserSettingInfo != null) {
                jSONObject.put("settingItem", iNTERFACE$StUserSettingInfo.settingItem.get());
                jSONObject.put("desc", iNTERFACE$StGetUserSettingRsp.setting.desc.get());
                jSONObject.put("authState", iNTERFACE$StGetUserSettingRsp.setting.authState.get());
                return jSONObject;
            }
            QMLog.d("VerifyPluginRequest", "onResponse fail.rsp = null");
            return null;
        } catch (Exception e16) {
            QMLog.d("VerifyPluginRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
