package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class u extends f {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f31852b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(com.bumptech.glide.load.c.f31560a);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f31852b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16) {
        return ac.e(dVar, bitmap, i3, i16);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return 1572326941;
    }
}
