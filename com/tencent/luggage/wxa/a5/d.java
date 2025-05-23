package com.tencent.luggage.wxa.a5;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String appId) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public abstract void a(com.tencent.luggage.wxa.c5.b bVar);
}
