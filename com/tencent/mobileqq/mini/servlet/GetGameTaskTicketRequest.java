package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGenTaskTicketReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGameTaskTicketRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.UseUserApp";
    public static final String TAG = "UseUserAppRequest";
    private INTERFACE$StGenTaskTicketReq req;

    public GetGameTaskTicketRequest(String str, int i3) {
        INTERFACE$StGenTaskTicketReq iNTERFACE$StGenTaskTicketReq = new INTERFACE$StGenTaskTicketReq();
        this.req = iNTERFACE$StGenTaskTicketReq;
        iNTERFACE$StGenTaskTicketReq.appid.set(str);
        this.req.taskID.set(i3);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
