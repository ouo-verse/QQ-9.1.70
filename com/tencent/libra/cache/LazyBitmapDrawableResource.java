package com.tencent.libra.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    @SuppressLint({"RestrictedApi"})
    LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        this.resources = (Resources) Preconditions.checkNotNull(resources);
        this.bitmapResource = (Resource) Preconditions.checkNotNull(resource);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(context.getResources(), BitmapResource.obtain(bitmap, null));
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // com.tencent.libra.cache.Resource
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // com.tencent.libra.cache.Initializable
    public void initialize() {
        Resource<Bitmap> resource = this.bitmapResource;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
    }

    @Override // com.tencent.libra.cache.Resource
    public void recycle() {
        this.bitmapResource.recycle();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(resources, BitmapResource.obtain(bitmap, bitmapPool));
    }

    @Nullable
    public static Resource<BitmapDrawable> obtain(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }
}
