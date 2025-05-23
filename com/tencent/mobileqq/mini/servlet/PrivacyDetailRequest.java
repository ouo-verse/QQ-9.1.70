package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetPrivacyInfoRequest;

/* loaded from: classes33.dex */
public class PrivacyDetailRequest extends ProtoBufRequest {
    private INTERFACE$GetPrivacyInfoRequest mReq;

    public PrivacyDetailRequest(String str, String str2) {
        INTERFACE$GetPrivacyInfoRequest iNTERFACE$GetPrivacyInfoRequest = new INTERFACE$GetPrivacyInfoRequest();
        this.mReq = iNTERFACE$GetPrivacyInfoRequest;
        iNTERFACE$GetPrivacyInfoRequest.appid.set(str);
        this.mReq.privacy_api.set(str2);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.mReq.toByteArray();
    }
}
