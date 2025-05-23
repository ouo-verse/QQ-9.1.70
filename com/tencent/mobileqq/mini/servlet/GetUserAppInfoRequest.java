package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppInfoRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserAppInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppInfo";
    public static final String TAG = "GetUserAppInfoRequest";
    private INTERFACE$StGetUserAppInfoReq req;

    public GetUserAppInfoRequest(COMM.StCommonExt stCommonExt, List<String> list) {
        INTERFACE$StGetUserAppInfoReq iNTERFACE$StGetUserAppInfoReq = new INTERFACE$StGetUserAppInfoReq();
        this.req = iNTERFACE$StGetUserAppInfoReq;
        iNTERFACE$StGetUserAppInfoReq.appIds.set(list);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetUserAppInfoRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserAppInfoRsp iNTERFACE$StGetUserAppInfoRsp = new INTERFACE$StGetUserAppInfoRsp();
        try {
            iNTERFACE$StGetUserAppInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserAppInfoRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetUserAppInfoRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
