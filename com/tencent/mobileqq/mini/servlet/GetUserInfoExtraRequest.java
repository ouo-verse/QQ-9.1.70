package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserInfoExtraReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserInfoExtraRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserInfoExtraRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserInfoExtra";
    public static final String TAG = "GetUserInfoExtra";
    private INTERFACE$StGetUserInfoExtraReq req;

    public GetUserInfoExtraRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetUserInfoExtraReq iNTERFACE$StGetUserInfoExtraReq = new INTERFACE$StGetUserInfoExtraReq();
        this.req = iNTERFACE$StGetUserInfoExtraReq;
        iNTERFACE$StGetUserInfoExtraReq.appid.set(str);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetUserInfoExtraRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserInfoExtraRsp iNTERFACE$StGetUserInfoExtraRsp = new INTERFACE$StGetUserInfoExtraRsp();
        try {
            iNTERFACE$StGetUserInfoExtraRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserInfoExtraRsp;
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
