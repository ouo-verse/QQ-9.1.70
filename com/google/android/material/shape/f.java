package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends j1.d {

    /* renamed from: a, reason: collision with root package name */
    float f34051a = -1.0f;

    @Override // j1.d
    public void a(@NonNull i iVar, float f16, float f17, float f18) {
        iVar.o(0.0f, f18 * f17, 180.0f, 180.0f - f16);
        float f19 = f18 * 2.0f * f17;
        iVar.a(0.0f, 0.0f, f19, f19, 180.0f, f16);
    }
}
