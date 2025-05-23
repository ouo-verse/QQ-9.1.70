package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.f<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f31831a;

    public g(q qVar) {
        this.f31831a = qVar;
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        return this.f31831a.f(h0.a.f(byteBuffer), i3, i16, eVar);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f31831a.q(byteBuffer);
    }
}
