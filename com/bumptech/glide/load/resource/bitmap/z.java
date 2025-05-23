package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes.dex */
public final class z implements com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f31873a;

    public z(q qVar) {
        this.f31873a = qVar;
    }

    @Override // com.bumptech.glide.load.f
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        return this.f31873a.d(parcelFileDescriptor, i3, i16, eVar);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f31873a.o(parcelFileDescriptor);
    }
}
