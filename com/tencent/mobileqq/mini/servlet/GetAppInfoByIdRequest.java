package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByIdRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetAppInfoByIdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetAppInfoById";
    public static final String TAG = "GetAppInfoByIdRequest";
    private INTERFACE$StGetAppInfoByIdReq req;

    public GetAppInfoByIdRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, String str2, String str3, String str4) {
        INTERFACE$StGetAppInfoByIdReq iNTERFACE$StGetAppInfoByIdReq = new INTERFACE$StGetAppInfoByIdReq();
        this.req = iNTERFACE$StGetAppInfoByIdReq;
        iNTERFACE$StGetAppInfoByIdReq.appid.set(str);
        this.req.needVersionInfo.set(i3);
        this.req.checkDevRight.set(i16);
        this.req.firstPath.set(str2);
        this.req.envVersion.set(str3);
        this.req.fromAppid.set(str4 == null ? "" : str4);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetAppInfoByIdRsp onResponse(byte[] bArr) {
        INTERFACE$StGetAppInfoByIdRsp iNTERFACE$StGetAppInfoByIdRsp = new INTERFACE$StGetAppInfoByIdRsp();
        try {
            iNTERFACE$StGetAppInfoByIdRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetAppInfoByIdRsp;
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
