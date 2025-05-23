package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCheckNavigateRightReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CheckNavigateRightRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckNavigateRight";
    private INTERFACE$StCheckNavigateRightReq req;

    public CheckNavigateRightRequest(String str, String str2) {
        INTERFACE$StCheckNavigateRightReq iNTERFACE$StCheckNavigateRightReq = new INTERFACE$StCheckNavigateRightReq();
        this.req = iNTERFACE$StCheckNavigateRightReq;
        iNTERFACE$StCheckNavigateRightReq.appId.set(str);
        this.req.targetAppId.set(str2);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public CheckNavigateRightRequest(String str, String str2, COMM.StCommonExt stCommonExt) {
        INTERFACE$StCheckNavigateRightReq iNTERFACE$StCheckNavigateRightReq = new INTERFACE$StCheckNavigateRightReq();
        this.req = iNTERFACE$StCheckNavigateRightReq;
        iNTERFACE$StCheckNavigateRightReq.appId.set(str);
        this.req.targetAppId.set(str2);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }
}
