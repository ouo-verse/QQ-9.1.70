package com.tencent.libra.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import com.tencent.cache.api.util.ImageCacheHelper;

/* compiled from: P */
/* loaded from: classes7.dex */
class h implements BitmapPool {
    @Override // com.tencent.libra.cache.BitmapPool
    @NonNull
    public Bitmap get(int i3, int i16, @NonNull Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = i3;
        options.outHeight = i16;
        options.inPreferredConfig = config;
        options.inSampleSize = 1;
        ImageCacheHelper.f98636a.a(options);
        return options.inBitmap;
    }

    @Override // com.tencent.libra.cache.BitmapPool
    public void put(@NonNull Bitmap bitmap) {
        ImageCacheHelper.f98636a.l(bitmap);
    }
}
