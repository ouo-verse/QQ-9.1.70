package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import u35.a;
import u35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQStrangerSsoRequest extends NearbyBasePbRequest<a, b> {
    public final a req;

    public QQStrangerSsoRequest(a aVar) {
        this.req = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (b) i.b(new b(0, null, null, 7, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("QQStrangerSsoRequest", "decode error: " + th5);
            return new b(0, null, null, 7, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return this.req;
    }
}
