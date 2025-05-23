package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e extends b {

    /* renamed from: d, reason: collision with root package name */
    private final b f34049d;

    /* renamed from: e, reason: collision with root package name */
    private final float f34050e;

    public e(@NonNull b bVar, float f16) {
        this.f34049d = bVar;
        this.f34050e = f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.b
    public boolean a() {
        return this.f34049d.a();
    }

    @Override // com.google.android.material.shape.b
    public void b(float f16, float f17, float f18, @NonNull i iVar) {
        this.f34049d.b(f16, f17 - this.f34050e, f18, iVar);
    }
}
