package com.tencent.hippykotlin.demo.pages.qq_intimate_space.msf;

import c45.e;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQNetworkEngine$QQNetworkEngineOIDBRequest<Req extends e, Rsp extends e> extends BaseOIDBRequest<Req, Rsp> {
    public final Function1<byte[], Rsp> decodeResponse;
    public final int oidbCmd;
    public final int oidbServiceType = 1;
    public final Req req;

    /* JADX WARN: Multi-variable type inference failed */
    public QQNetworkEngine$QQNetworkEngineOIDBRequest(int i3, e eVar, Function1 function1) {
        this.oidbCmd = i3;
        this.req = eVar;
        this.decodeResponse = function1;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final Rsp decodeResponse(byte[] bArr) {
        return this.decodeResponse.invoke(bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbCmd() {
        return this.oidbCmd;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final int getOidbServiceType() {
        return this.oidbServiceType;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
    public final Req getRequest() {
        return this.req;
    }
}
