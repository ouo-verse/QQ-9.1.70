package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetTCBTicketReq;
import NS_MINI_INTERFACE.INTERFACE$StGetTCBTicketRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetTcbTicketRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetTCBTicket";
    public static final String TAG = "GetTcbTicketRequest";
    private INTERFACE$StGetTCBTicketReq req;

    public GetTcbTicketRequest(COMM.StCommonExt stCommonExt, String str, String str2) {
        INTERFACE$StGetTCBTicketReq iNTERFACE$StGetTCBTicketReq = new INTERFACE$StGetTCBTicketReq();
        this.req = iNTERFACE$StGetTCBTicketReq;
        iNTERFACE$StGetTCBTicketReq.appid.set(str);
        this.req.envId.set(str2);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StGetTCBTicketRsp onResponse(byte[] bArr) {
        INTERFACE$StGetTCBTicketRsp iNTERFACE$StGetTCBTicketRsp = new INTERFACE$StGetTCBTicketRsp();
        try {
            iNTERFACE$StGetTCBTicketRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetTCBTicketRsp;
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
