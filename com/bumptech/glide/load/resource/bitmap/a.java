package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public class a<DataType> implements com.bumptech.glide.load.f<DataType, BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.f<DataType, Bitmap> f31809a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f31810b;

    public a(@NonNull Resources resources, @NonNull com.bumptech.glide.load.f<DataType, Bitmap> fVar) {
        this.f31810b = (Resources) h0.j.d(resources);
        this.f31809a = (com.bumptech.glide.load.f) h0.j.d(fVar);
    }

    @Override // com.bumptech.glide.load.f
    public boolean a(@NonNull DataType datatype, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        return this.f31809a.a(datatype, eVar);
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.q<BitmapDrawable> b(@NonNull DataType datatype, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        return y.b(this.f31810b, this.f31809a.b(datatype, i3, i16, eVar));
    }
}
