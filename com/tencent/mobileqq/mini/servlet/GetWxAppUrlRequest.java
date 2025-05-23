package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetWXAppURLRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetWxAppUrlRequest extends ProtoBufRequest {
    private final INTERFACE$GetWXAppURLRequest request;

    public GetWxAppUrlRequest(int i3, String str) {
        INTERFACE$GetWXAppURLRequest iNTERFACE$GetWXAppURLRequest = new INTERFACE$GetWXAppURLRequest();
        this.request = iNTERFACE$GetWXAppURLRequest;
        iNTERFACE$GetWXAppURLRequest.codeType.set(i3);
        iNTERFACE$GetWXAppURLRequest.code.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.request.toByteArray();
    }
}
