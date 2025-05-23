package com.tencent.hippykotlin.demo.pages.foundation.module;

import c45.e;

/* loaded from: classes31.dex */
public abstract class BasePbRequest<Req extends e, Rsp extends e> {
    public abstract Rsp decodeResponse(byte[] bArr);

    public abstract String getCmd();

    public abstract Req getRequest();
}
