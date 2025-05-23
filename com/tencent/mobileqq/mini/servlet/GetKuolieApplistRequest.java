package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetExpandAppListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetExpandAppListRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetKuolieApplistRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetExpandAppList";
    public static final String TAG = "GetKuolieApplistRequest";
    private INTERFACE$StGetExpandAppListReq req;

    public GetKuolieApplistRequest(COMM.StCommonExt stCommonExt) {
        INTERFACE$StGetExpandAppListReq iNTERFACE$StGetExpandAppListReq = new INTERFACE$StGetExpandAppListReq();
        this.req = iNTERFACE$StGetExpandAppListReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetExpandAppListReq.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetExpandAppListRsp onResponse(byte[] bArr) {
        INTERFACE$StGetExpandAppListRsp iNTERFACE$StGetExpandAppListRsp = new INTERFACE$StGetExpandAppListRsp();
        try {
            iNTERFACE$StGetExpandAppListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetExpandAppListRsp;
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
