package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.kuikly.core.log.KLog;
import u35.a;
import u35.b;

/* loaded from: classes31.dex */
public final class CommonProxyRequest extends NearbyBasePbRequest<a, b> {
    public final int appId;
    public final c45.a bizBuf;
    public final String method;
    public final String service;

    public CommonProxyRequest(int i3, String str, String str2, c45.a aVar) {
        this.appId = i3;
        this.service = str;
        this.method = str2;
        this.bizBuf = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        try {
            return (b) i.b(new b(0, null, null, 7, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("CommonProxyService", "ProxyRsp decode error: " + th5);
            return new b(0, null, null, 7, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new a(this.service, this.method, this.appId, this.bizBuf);
    }
}
