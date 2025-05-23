package com.tencent.luggage.wxa.mc;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f134343a = new m0();

    public static final boolean a(o oVar, d record) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(record, "record");
        if (oVar instanceof l0) {
            return ((l0) oVar).c((h0) record);
        }
        if (oVar instanceof j0) {
            return ((j0) oVar).a((h0) record);
        }
        if (oVar instanceof e0) {
            return ((e0) oVar).b((i0) record);
        }
        if (oVar instanceof d0) {
            return ((d0) oVar).a((i0) record);
        }
        return false;
    }

    public static final boolean b(o oVar, d record) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Intrinsics.checkNotNullParameter(record, "record");
        if (oVar instanceof l0) {
            return ((l0) oVar).d((h0) record);
        }
        if (oVar instanceof j0) {
            return ((j0) oVar).b((h0) record);
        }
        if (oVar instanceof e0) {
            return ((e0) oVar).c((i0) record);
        }
        if (oVar instanceof d0) {
            return ((d0) oVar).b((i0) record);
        }
        return false;
    }
}
