package com.tencent.luggage.wxa.m6;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f134106a = new ConcurrentHashMap();

    public final String a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String localId = j.a(path);
        ConcurrentHashMap concurrentHashMap = this.f134106a;
        Intrinsics.checkNotNullExpressionValue(localId, "localId");
        concurrentHashMap.put(localId, path);
        return localId;
    }

    public final String b(String localId) {
        Intrinsics.checkNotNullParameter(localId, "localId");
        return (String) this.f134106a.get(localId);
    }
}
