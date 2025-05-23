package com.tencent.luggage.wxa.k6;

import com.tencent.xweb.WebView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends b {

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.qc.b f131666m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(WebView webView, com.tencent.luggage.wxa.m6.d urlCheckLogic) {
        super(webView, urlCheckLogic);
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(urlCheckLogic, "urlCheckLogic");
        this.f131666m = com.tencent.luggage.wxa.qc.b.BACKGROUND;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public String getAppId() {
        return "";
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.qc.b getAppState() {
        return this.f131666m;
    }
}
