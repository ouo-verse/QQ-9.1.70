package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetUserGroupInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StGetUserGroupInfoRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetUserGroupInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetUserGroupInfo";
    public static final String TAG = "GetUserGroupInfoRequest";
    private INTERFACE$StGetUserGroupInfoReq req;

    public GetUserGroupInfoRequest(String str, String str2, long j3, COMM.StCommonExt stCommonExt) {
        INTERFACE$StGetUserGroupInfoReq iNTERFACE$StGetUserGroupInfoReq = new INTERFACE$StGetUserGroupInfoReq();
        this.req = iNTERFACE$StGetUserGroupInfoReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetUserGroupInfoReq.extInfo.set(stCommonExt);
        }
        if (str != null) {
            this.req.appid.set(str);
        }
        if (str2 != null) {
            this.req.groupId.set(str2);
        }
        this.req.groupClass.set(j3);
    }

    public static INTERFACE$StGetUserGroupInfoRsp onResponse(byte[] bArr) {
        INTERFACE$StGetUserGroupInfoRsp iNTERFACE$StGetUserGroupInfoRsp = new INTERFACE$StGetUserGroupInfoRsp();
        try {
            iNTERFACE$StGetUserGroupInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetUserGroupInfoRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("GetUserGroupInfoRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
