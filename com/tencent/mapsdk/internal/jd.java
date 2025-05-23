package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jd implements jl<Integer> {
    @Override // com.tencent.mapsdk.internal.jl
    public final /* synthetic */ Integer a(float f16, Integer num, Integer num2) {
        return Integer.valueOf((int) (num.intValue() + (f16 * (num2.intValue() - r3))));
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static Integer a2(float f16, Integer num, Integer num2) {
        return Integer.valueOf((int) (num.intValue() + (f16 * (num2.intValue() - r2))));
    }
}
