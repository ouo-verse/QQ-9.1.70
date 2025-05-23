package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;

/* loaded from: classes31.dex */
public interface IBizRequestByProxy<Req extends e, Rsp extends e> {
    Rsp decodeResponse(byte[] bArr);

    int getAppId();

    String getMethod();

    Req getRequest();

    String getService();
}
