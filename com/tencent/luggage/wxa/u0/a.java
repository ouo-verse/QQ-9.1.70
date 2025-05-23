package com.tencent.luggage.wxa.u0;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f142009b = new a();

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f142008a = new HashMap();

    public static final void a(long j3) {
        f142008a.remove(Long.valueOf(j3));
    }

    public static final void a(long j3, c cVar) {
        if (!f142008a.containsKey(Long.valueOf(j3))) {
            f142008a.put(Long.valueOf(j3), cVar);
            return;
        }
        throw new AssertionError("Assertion failed");
    }
}
