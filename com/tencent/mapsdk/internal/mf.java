package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.processor.RequestProcessor;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mf implements RequestProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f149305a;

    mf(boolean z16) {
        this.f149305a = z16;
    }

    public static mf a(boolean z16) {
        return new mf(z16);
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public final void onRequest(NetRequest netRequest) {
        if (this.f149305a) {
            String str = netRequest.url;
            if (str.startsWith("http://")) {
                str = str.replaceFirst("http://", "https://");
            }
            netRequest.url = str;
        }
    }
}
