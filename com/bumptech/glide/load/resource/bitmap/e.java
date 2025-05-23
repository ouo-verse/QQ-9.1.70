package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.engine.q<Bitmap>, com.bumptech.glide.load.engine.m {

    /* renamed from: d, reason: collision with root package name */
    private final Bitmap f31829d;

    /* renamed from: e, reason: collision with root package name */
    private final r.d f31830e;

    public e(@NonNull Bitmap bitmap, @NonNull r.d dVar) {
        this.f31829d = (Bitmap) h0.j.e(bitmap, "Bitmap must not be null");
        this.f31830e = (r.d) h0.j.e(dVar, "BitmapPool must not be null");
    }

    @Nullable
    public static e b(@Nullable Bitmap bitmap, @NonNull r.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, dVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f31829d;
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return h0.k.g(this.f31829d);
    }

    @Override // com.bumptech.glide.load.engine.m
    public void initialize() {
        this.f31829d.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
        this.f31830e.put(this.f31829d);
    }
}
