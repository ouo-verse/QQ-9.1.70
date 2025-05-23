package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserAppListRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserAppListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetUserAppList";
    private INTERFACE$StGetUserAppListReq req;

    public GetUserAppListRequest(COMM.StCommonExt stCommonExt, long j3, long j16) {
        INTERFACE$StGetUserAppListReq iNTERFACE$StGetUserAppListReq = new INTERFACE$StGetUserAppListReq();
        this.req = iNTERFACE$StGetUserAppListReq;
        iNTERFACE$StGetUserAppListReq.uin.set(j3);
        this.req.num.set(j16);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
        QLog.d("ProtoBufRequest", 1, "MiniAppSummaryCard GetFriendPlayListV2Request uin:", Long.valueOf(j3), " num:", Long.valueOf(j16));
    }

    public static INTERFACE$StGetUserAppListRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserAppListRsp iNTERFACE$StGetUserAppListRsp = new INTERFACE$StGetUserAppListRsp();
        try {
            iNTERFACE$StGetUserAppListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserAppListRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
