package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ja implements jl<Object> {
    @Override // com.tencent.mapsdk.internal.jl
    public final Object a(float f16, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i3 = intValue >> 24;
        int i16 = (intValue >> 16) & 255;
        int i17 = (intValue >> 8) & 255;
        int i18 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i3 + ((int) (((intValue2 >> 24) - i3) * f16))) << 24) | ((i16 + ((int) ((((intValue2 >> 16) & 255) - i16) * f16))) << 16) | ((i17 + ((int) ((((intValue2 >> 8) & 255) - i17) * f16))) << 8) | (i18 + ((int) (f16 * ((intValue2 & 255) - i18)))));
    }
}
