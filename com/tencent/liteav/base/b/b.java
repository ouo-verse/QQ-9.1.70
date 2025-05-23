package com.tencent.liteav.base.b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final long f118888a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, a> f118889b = new HashMap();

    public final synchronized a a(String str) {
        a aVar;
        aVar = this.f118889b.get(str);
        if (aVar == null) {
            aVar = new a(f118888a);
            this.f118889b.put(str, aVar);
        }
        return aVar;
    }
}
