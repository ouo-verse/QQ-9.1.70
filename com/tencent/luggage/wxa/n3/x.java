package com.tencent.luggage.wxa.n3;

import com.tencent.luggage.wxa.hn.x0;
import com.tencent.luggage.wxa.hn.y0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x extends com.tencent.luggage.wxa.on.c {

    /* renamed from: d, reason: collision with root package name */
    public final x0 f135270d;

    /* renamed from: e, reason: collision with root package name */
    public final y0 f135271e;

    public x(x0 request, y0 response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f135270d = request;
        this.f135271e = response;
    }

    public final y0 d() {
        return this.f135271e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (Intrinsics.areEqual(this.f135270d, xVar.f135270d) && Intrinsics.areEqual(this.f135271e, xVar.f135271e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f135270d.hashCode() * 31) + this.f135271e.hashCode();
    }

    public String toString() {
        return "OnCheckDemoInfoResponseReceivedEvent(request=" + this.f135270d + ", response=" + this.f135271e + ')';
    }
}
