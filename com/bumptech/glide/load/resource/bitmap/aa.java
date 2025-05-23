package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.oskplayer.datasource.RawResourceDataSource;

/* compiled from: P */
/* loaded from: classes.dex */
public class aa implements com.bumptech.glide.load.f<Uri, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final x.e f31811a;

    /* renamed from: b, reason: collision with root package name */
    private final r.d f31812b;

    public aa(x.e eVar, r.d dVar) {
        this.f31811a = eVar;
        this.f31812b = dVar;
    }

    @Override // com.bumptech.glide.load.f
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        com.bumptech.glide.load.engine.q<Drawable> b16 = this.f31811a.b(uri, i3, i16, eVar);
        if (b16 == null) {
            return null;
        }
        return r.a(this.f31812b, b16.get(), i3, i16);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.e eVar) {
        return RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
