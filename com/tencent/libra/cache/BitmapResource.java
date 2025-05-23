package com.tencent.libra.cache;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.tencent.libra.util.LibraImageUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final Bitmap bitmap;
    private BitmapPool bitmapPool;

    @SuppressLint({"RestrictedApi"})
    public BitmapResource(@NonNull Bitmap bitmap, BitmapPool bitmapPool) {
        this.bitmap = (Bitmap) Preconditions.checkNotNull(bitmap, "Bitmap must not be null");
        this.bitmapPool = bitmapPool;
    }

    @Nullable
    public static BitmapResource obtain(@Nullable Bitmap bitmap, @Nullable BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // com.tencent.libra.cache.Resource
    public int getSize() {
        return LibraImageUtil.getBitmapByteSize(this.bitmap);
    }

    @Override // com.tencent.libra.cache.Initializable
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    @Override // com.tencent.libra.cache.Resource
    public void recycle() {
        BitmapPool bitmapPool = this.bitmapPool;
        if (bitmapPool != null) {
            bitmapPool.put(this.bitmap);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Bitmap get() {
        return this.bitmap;
    }
}
