package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetNAppForJumpReq;
import NS_MINI_INTERFACE.INTERFACE$StGetNAppForJumpRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetNativeAppInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetNAppForJump";
    public static final String TAG = "GetAppInfoByIdRequest";
    private INTERFACE$StGetNAppForJumpReq req;

    public GetNativeAppInfoRequest(COMM.StCommonExt stCommonExt, String str, String str2, String str3, int i3) {
        INTERFACE$StGetNAppForJumpReq iNTERFACE$StGetNAppForJumpReq = new INTERFACE$StGetNAppForJumpReq();
        this.req = iNTERFACE$StGetNAppForJumpReq;
        iNTERFACE$StGetNAppForJumpReq.android_pkg_name.set(str3);
        this.req.mini_appid.set(str);
        this.req.native_appid.set(str2);
        this.req.scene.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetNAppForJumpRsp onResponse(byte[] bArr) {
        INTERFACE$StGetNAppForJumpRsp iNTERFACE$StGetNAppForJumpRsp = new INTERFACE$StGetNAppForJumpRsp();
        try {
            iNTERFACE$StGetNAppForJumpRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetNAppForJumpRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetAppInfoByIdRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
