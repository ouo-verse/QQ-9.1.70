package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class x implements com.bumptech.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final d f31870a = new d();

    @Override // com.bumptech.glide.load.f
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull InputStream inputStream, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(h0.a.b(inputStream));
        return this.f31870a.b(createSource, i3, i16, eVar);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        return true;
    }
}
