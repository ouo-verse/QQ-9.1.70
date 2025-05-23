package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.xd.m;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static final a a(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        a aVar = (a) gVar.c(a.class);
        if (aVar == null) {
            a aVar2 = new a();
            gVar.a((m) aVar2);
            return aVar2;
        }
        return aVar;
    }
}
