package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$SetWXAppURLRequest;
import NS_MINI_INTERFACE.INTERFACE$URLMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetWxAppUrlRequest extends ProtoBufRequest {
    private final INTERFACE$SetWXAppURLRequest request;

    public SetWxAppUrlRequest(int i3, String str, String str2) {
        INTERFACE$SetWXAppURLRequest iNTERFACE$SetWXAppURLRequest = new INTERFACE$SetWXAppURLRequest();
        this.request = iNTERFACE$SetWXAppURLRequest;
        INTERFACE$URLMap iNTERFACE$URLMap = new INTERFACE$URLMap();
        iNTERFACE$URLMap.codeType.set(i3);
        iNTERFACE$URLMap.code.set(str);
        iNTERFACE$URLMap.URL.set(str2);
        iNTERFACE$SetWXAppURLRequest.URLMap.set(iNTERFACE$URLMap);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.request.toByteArray();
    }
}
