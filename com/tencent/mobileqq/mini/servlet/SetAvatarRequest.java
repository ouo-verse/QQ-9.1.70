package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAvatarReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAvatarRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetAvatarRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAvatar";
    public static final String TAG = "SetAvatarRequest";
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

    public static INTERFACE$StSetUserAvatarRsp onResponse(byte[] bArr) {
        INTERFACE$StSetUserAvatarRsp iNTERFACE$StSetUserAvatarRsp = new INTERFACE$StSetUserAvatarRsp();
        try {
            iNTERFACE$StSetUserAvatarRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StSetUserAvatarRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
