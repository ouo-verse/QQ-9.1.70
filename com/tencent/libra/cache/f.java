package com.tencent.libra.cache;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends a<Drawable> {
    f(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    public static Resource<Drawable> b(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new f(drawable);
        }
        return null;
    }

    @Override // com.tencent.libra.cache.Resource
    @NonNull
    public Class<Drawable> getResourceClass() {
        return this.f118633a.getClass();
    }

    @Override // com.tencent.libra.cache.Resource
    public int getSize() {
        T t16 = this.f118633a;
        if (t16 instanceof r01.e) {
            return ((r01.e) t16).getByteSize();
        }
        return Math.max(1, t16.getIntrinsicWidth() * this.f118633a.getIntrinsicHeight() * 4);
    }

    @Override // com.tencent.libra.cache.Resource
    public void recycle() {
    }
}
