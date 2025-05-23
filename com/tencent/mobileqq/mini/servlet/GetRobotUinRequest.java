package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinReq;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetRobotUinRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetRobotUin";
    public static final String TAG = "GetRobotUinRequest";
    private INTERFACE$StGetRobotUinReq req;

    public GetRobotUinRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetRobotUinReq iNTERFACE$StGetRobotUinReq = new INTERFACE$StGetRobotUinReq();
        this.req = iNTERFACE$StGetRobotUinReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetRobotUinReq.extInfo.set(stCommonExt);
        }
        this.req.appid.set(str);
    }

    public static INTERFACE$StGetRobotUinRsp onResponse(byte[] bArr) {
        INTERFACE$StGetRobotUinRsp iNTERFACE$StGetRobotUinRsp = new INTERFACE$StGetRobotUinRsp();
        try {
            iNTERFACE$StGetRobotUinRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetRobotUinRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetRobotUinRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
