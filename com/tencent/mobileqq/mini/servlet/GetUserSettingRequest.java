package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserSettingRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserSetting";
    public static final String TAG = "VerifyPluginRequest";
    private INTERFACE$StGetUserSettingReq req;

    public GetUserSettingRequest(String str, String str2, String str3, List<String> list) {
        INTERFACE$StGetUserSettingReq iNTERFACE$StGetUserSettingReq = new INTERFACE$StGetUserSettingReq();
        this.req = iNTERFACE$StGetUserSettingReq;
        if (str != null) {
            iNTERFACE$StGetUserSettingReq.appid.set(str);
        }
        if (str2 != null) {
            this.req.openid.set(str2);
        }
        if (str3 != null) {
            this.req.settingItem.set(str3);
        }
        if (list != null) {
            this.req.templateIds.set(list);
        }
    }

    public static INTERFACE$StGetUserSettingRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
        try {
            iNTERFACE$StGetUserSettingRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserSettingRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("VerifyPluginRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
