package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StLaunchAppReq;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetLaunchConfigRequest extends ProtoBufRequest {
    public static final String TAG = "GetLaunchConfigRequest";
    private INTERFACE$StLaunchAppReq req;

    public GetLaunchConfigRequest(String str) {
        INTERFACE$StLaunchAppReq iNTERFACE$StLaunchAppReq = new INTERFACE$StLaunchAppReq();
        this.req = iNTERFACE$StLaunchAppReq;
        iNTERFACE$StLaunchAppReq.appid.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
