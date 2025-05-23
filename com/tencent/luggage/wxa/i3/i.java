package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.h6;
import com.tencent.luggage.wxa.hn.i6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public final h6 f129249d;

    /* renamed from: e, reason: collision with root package name */
    public final i6 f129250e;

    public i(h6 request, i6 response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f129249d = request;
        this.f129250e = response;
    }

    public final h6 d() {
        return this.f129249d;
    }

    public final i6 e() {
        return this.f129250e;
    }
}
