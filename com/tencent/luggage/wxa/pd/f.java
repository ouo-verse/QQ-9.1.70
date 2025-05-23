package com.tencent.luggage.wxa.pd;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public b f137498a;

    /* renamed from: b, reason: collision with root package name */
    public Map f137499b;

    public f(boolean z16) {
        if (z16) {
            this.f137498a = new b();
            this.f137499b = new HashMap();
        }
    }

    public String toString() {
        return "UPnPMessage{headers=" + this.f137498a + ", bodes=" + this.f137499b + '}';
    }
}
