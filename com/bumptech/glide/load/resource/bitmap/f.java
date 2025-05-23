package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.h<Bitmap> {
    @Override // com.bumptech.glide.load.h
    @NonNull
    public final com.bumptech.glide.load.engine.q<Bitmap> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.q<Bitmap> qVar, int i3, int i16) {
        if (h0.k.s(i3, i16)) {
            r.d f16 = com.bumptech.glide.b.c(context).f();
            Bitmap bitmap = qVar.get();
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getWidth();
            }
            if (i16 == Integer.MIN_VALUE) {
                i16 = bitmap.getHeight();
            }
            Bitmap c16 = c(f16, bitmap, i3, i16);
            if (!bitmap.equals(c16)) {
                return e.b(c16, f16);
            }
            return qVar;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i3 + " or height: " + i16 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16);
}
