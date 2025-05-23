package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserHealthDataReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserHealthDataRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserHealthDataRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserHealthData";
    public static final String TAG = "GetUserHealthDataRequest";
    private INTERFACE$StGetUserHealthDataReq req;

    public GetUserHealthDataRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetUserHealthDataReq iNTERFACE$StGetUserHealthDataReq = new INTERFACE$StGetUserHealthDataReq();
        this.req = iNTERFACE$StGetUserHealthDataReq;
        iNTERFACE$StGetUserHealthDataReq.appid.set(str);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetUserHealthDataRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserHealthDataRsp iNTERFACE$StGetUserHealthDataRsp = new INTERFACE$StGetUserHealthDataRsp();
        try {
            iNTERFACE$StGetUserHealthDataRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserHealthDataRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetUserHealthDataRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
