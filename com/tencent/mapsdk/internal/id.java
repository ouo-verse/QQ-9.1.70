package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class id implements jl<fw> {
    @Override // com.tencent.mapsdk.internal.jl
    public final /* synthetic */ fw a(float f16, fw fwVar, fw fwVar2) {
        fw fwVar3 = fwVar;
        fw fwVar4 = fwVar2;
        double d16 = fwVar3.f148383a;
        double d17 = f16;
        double d18 = d16 + ((fwVar4.f148383a - d16) * d17);
        double d19 = fwVar3.f148384b;
        return new fw(d18, d19 + (d17 * (fwVar4.f148384b - d19)));
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static fw a2(float f16, fw fwVar, fw fwVar2) {
        double d16 = fwVar.f148383a;
        double d17 = f16;
        double d18 = d16 + ((fwVar2.f148383a - d16) * d17);
        double d19 = fwVar.f148384b;
        return new fw(d18, d19 + (d17 * (fwVar2.f148384b - d19)));
    }
}
