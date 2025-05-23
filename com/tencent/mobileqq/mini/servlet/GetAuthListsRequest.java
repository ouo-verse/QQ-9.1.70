package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetAuthListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetAuthListsRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetAuthList";
    private INTERFACE$StGetAuthListReq req;

    public GetAuthListsRequest(COMM.StCommonExt stCommonExt, String str) {
        INTERFACE$StGetAuthListReq iNTERFACE$StGetAuthListReq = new INTERFACE$StGetAuthListReq();
        this.req = iNTERFACE$StGetAuthListReq;
        iNTERFACE$StGetAuthListReq.appid.set(str);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StGetAuthListRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetAuthListRsp iNTERFACE$StGetAuthListRsp = new INTERFACE$StGetAuthListRsp();
        try {
            iNTERFACE$StGetAuthListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetAuthListRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
