package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class k extends f {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f31834b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(com.bumptech.glide.load.c.f31560a);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f31834b);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap c(@NonNull r.d dVar, @NonNull Bitmap bitmap, int i3, int i16) {
        return ac.c(dVar, bitmap, i3, i16);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof k;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return -670243078;
    }
}
