package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    private final float f34048d;

    public c(float f16) {
        this.f34048d = f16 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.b
    public boolean a() {
        return true;
    }

    @Override // com.google.android.material.shape.b
    public void b(float f16, float f17, float f18, @NonNull i iVar) {
        float sqrt = (float) ((this.f34048d * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f34048d, 2.0d) - Math.pow(sqrt, 2.0d));
        iVar.n(f17 - sqrt, ((float) (-((this.f34048d * Math.sqrt(2.0d)) - this.f34048d))) + sqrt2);
        iVar.m(f17, (float) (-((this.f34048d * Math.sqrt(2.0d)) - this.f34048d)));
        iVar.m(f17 + sqrt, ((float) (-((this.f34048d * Math.sqrt(2.0d)) - this.f34048d))) + sqrt2);
    }
}
