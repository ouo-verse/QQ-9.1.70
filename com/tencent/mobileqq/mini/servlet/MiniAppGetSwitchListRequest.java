package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetSwitchListReq;
import NS_MINI_INTERFACE.INTERFACE$StGetSwitchListRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetSwitchListRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetSwitchList";
    public static final String TAG = "MiniAppGetSwitchListRequest";
    private static final String unikey = "MiniAppGetSwitchListRequest";
    private INTERFACE$StGetSwitchListReq req;

    public MiniAppGetSwitchListRequest(COMM.StCommonExt stCommonExt) {
        INTERFACE$StGetSwitchListReq iNTERFACE$StGetSwitchListReq = new INTERFACE$StGetSwitchListReq();
        this.req = iNTERFACE$StGetSwitchListReq;
        if (stCommonExt != null) {
            iNTERFACE$StGetSwitchListReq.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetSwitchListRsp onResponse(byte[] bArr) {
        INTERFACE$StGetSwitchListRsp iNTERFACE$StGetSwitchListRsp = new INTERFACE$StGetSwitchListRsp();
        try {
            iNTERFACE$StGetSwitchListRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetSwitchListRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("MiniAppGetSwitchListRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
