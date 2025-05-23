package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import com.tencent.mapsdk.core.utils.log.LogUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mh implements RequestProcessor, ResponseProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f149308a;

    public mh(boolean z16) {
        this.f149308a = z16;
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public final void onRequest(NetRequest netRequest) {
        if (this.f149308a) {
            LogUtil.c(ky.f149106l, "REQ[" + netRequest.mRequestId + "][" + netRequest.mNetMethod.name() + "]: " + netRequest.toString());
        }
    }

    @Override // com.tencent.map.tools.net.processor.ResponseProcessor
    public final void onResponse(NetResponse netResponse) {
        if (this.f149308a) {
            LogUtil.c(ky.f149106l, "RESP[" + netResponse.mRequestId + "]: " + netResponse.toHumanString());
        }
    }
}
