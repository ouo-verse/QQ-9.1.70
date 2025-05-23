package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import w35.a;
import w35.b;

/* loaded from: classes31.dex */
public final class NBPVasSsoRequest extends NearbyBasePbRequest<a, b> {
    public final a req;

    public NBPVasSsoRequest(a aVar) {
        this.req = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (b) i.b(new b(0, null, null, null, 0L, null, 63, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPVasSsoRequest", "decode error: " + th5);
            return new b(0, null, null, null, 0L, null, 63, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.qmeta.mob_proxy_svr.MobProxy.SsoHandle";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return this.req;
    }
}
