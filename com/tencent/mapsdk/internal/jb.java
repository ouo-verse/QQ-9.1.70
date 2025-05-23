package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class jb implements jl<Number> {
    @Override // com.tencent.mapsdk.internal.jl
    public final /* synthetic */ Number a(float f16, Number number, Number number2) {
        double doubleValue = number.doubleValue();
        return Double.valueOf(doubleValue + (f16 * (number2.doubleValue() - doubleValue)));
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static Number a2(float f16, Number number, Number number2) {
        double doubleValue = number.doubleValue();
        return Double.valueOf(doubleValue + (f16 * (number2.doubleValue() - doubleValue)));
    }
}
