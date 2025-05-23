package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.rf;
import com.tencent.luggage.wxa.hn.sf;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.n3.h {

    /* renamed from: e, reason: collision with root package name */
    public final String f129214e;

    public c(rf request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f129214e = "/cgi-bin/mmbiz-bin/wxaattr/wxajsapiinfo";
        super.a(request);
        super.a(sf.class);
    }

    @Override // com.tencent.luggage.wxa.n3.e
    public String a() {
        return this.f129214e;
    }
}
