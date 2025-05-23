package com.tencent.libra.cache;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
class g<Z> implements com.tencent.cache.api.e {

    /* renamed from: d, reason: collision with root package name */
    private final EngineResource<Z> f118635d;

    public g(@NonNull EngineResource<Z> engineResource) {
        this.f118635d = engineResource;
    }

    public EngineResource<Z> a() {
        return this.f118635d;
    }

    @Override // com.tencent.cache.api.e
    @Nullable
    public Bitmap getBitmap() {
        Z z16 = this.f118635d.get();
        if (z16 instanceof Bitmap) {
            return (Bitmap) z16;
        }
        return null;
    }

    @Override // com.tencent.cache.api.f
    public int getByteSize() {
        return this.f118635d.getSize();
    }

    @NonNull
    public String toString() {
        return "QQEngineResourceAdapter{mEngineResource=" + this.f118635d + '}';
    }
}
