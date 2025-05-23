package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppLikeReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppLikeRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
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

    public static INTERFACE$StSetUserAppLikeRsp onResponse(byte[] bArr) {
        INTERFACE$StSetUserAppLikeRsp iNTERFACE$StSetUserAppLikeRsp = new INTERFACE$StSetUserAppLikeRsp();
        try {
            iNTERFACE$StSetUserAppLikeRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StSetUserAppLikeRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("SetUserAppLikeRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
