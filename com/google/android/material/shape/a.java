package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends j1.d {

    /* renamed from: a, reason: collision with root package name */
    float f34047a = -1.0f;

    @Override // j1.d
    public void a(@NonNull i iVar, float f16, float f17, float f18) {
        iVar.o(0.0f, f18 * f17, 180.0f, 180.0f - f16);
        double d16 = f18;
        double d17 = f17;
        iVar.m((float) (Math.sin(Math.toRadians(f16)) * d16 * d17), (float) (Math.sin(Math.toRadians(90.0f - f16)) * d16 * d17));
    }
}
