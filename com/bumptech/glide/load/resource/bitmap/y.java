package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class y implements com.bumptech.glide.load.engine.q<BitmapDrawable>, com.bumptech.glide.load.engine.m {

    /* renamed from: d, reason: collision with root package name */
    private final Resources f31871d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.q<Bitmap> f31872e;

    y(@NonNull Resources resources, @NonNull com.bumptech.glide.load.engine.q<Bitmap> qVar) {
        this.f31871d = (Resources) h0.j.d(resources);
        this.f31872e = (com.bumptech.glide.load.engine.q) h0.j.d(qVar);
    }

    @Nullable
    public static com.bumptech.glide.load.engine.q<BitmapDrawable> b(@NonNull Resources resources, @Nullable com.bumptech.glide.load.engine.q<Bitmap> qVar) {
        if (qVar == null) {
            return null;
        }
        return new y(resources, qVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f31871d, this.f31872e.get());
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return this.f31872e.getSize();
    }

    @Override // com.bumptech.glide.load.engine.m
    public void initialize() {
        com.bumptech.glide.load.engine.q<Bitmap> qVar = this.f31872e;
        if (qVar instanceof com.bumptech.glide.load.engine.m) {
            ((com.bumptech.glide.load.engine.m) qVar).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
        this.f31872e.recycle();
    }
}
