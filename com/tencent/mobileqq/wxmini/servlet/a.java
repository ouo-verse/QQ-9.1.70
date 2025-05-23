package com.tencent.mobileqq.wxmini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetTeenagerConfigReq;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private INTERFACE$StGetTeenagerConfigReq f327816a;

    public a(String str) {
        INTERFACE$StGetTeenagerConfigReq iNTERFACE$StGetTeenagerConfigReq = new INTERFACE$StGetTeenagerConfigReq();
        this.f327816a = iNTERFACE$StGetTeenagerConfigReq;
        iNTERFACE$StGetTeenagerConfigReq.extInfo.set(str);
    }

    @Override // com.tencent.mobileqq.wxmini.servlet.b
    public byte[] b() {
        return this.f327816a.toByteArray();
    }
}
