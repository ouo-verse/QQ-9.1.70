package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUpdateUserSettingReq;
import NS_MINI_INTERFACE.INTERFACE$StUpdateUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UpdateUserSettingRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.UpdateUserSetting";
    private INTERFACE$StUpdateUserSettingReq req;

    public UpdateUserSettingRequest(COMM.StCommonExt stCommonExt, String str, INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo) {
        INTERFACE$StUpdateUserSettingReq iNTERFACE$StUpdateUserSettingReq = new INTERFACE$StUpdateUserSettingReq();
        this.req = iNTERFACE$StUpdateUserSettingReq;
        iNTERFACE$StUpdateUserSettingReq.appid.set(str);
        if (iNTERFACE$StUserSettingInfo != null) {
            this.req.setting.set(iNTERFACE$StUserSettingInfo);
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StUpdateUserSettingRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StUpdateUserSettingRsp iNTERFACE$StUpdateUserSettingRsp = new INTERFACE$StUpdateUserSettingRsp();
        try {
            iNTERFACE$StUpdateUserSettingRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StUpdateUserSettingRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
