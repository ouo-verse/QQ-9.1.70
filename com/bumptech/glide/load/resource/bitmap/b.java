package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.g<BitmapDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private final r.d f31823a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.g<Bitmap> f31824b;

    public b(r.d dVar, com.bumptech.glide.load.g<Bitmap> gVar) {
        this.f31823a = dVar;
        this.f31824b = gVar;
    }

    @Override // com.bumptech.glide.load.g
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.e eVar) {
        return this.f31824b.b(eVar);
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull com.bumptech.glide.load.engine.q<BitmapDrawable> qVar, @NonNull File file, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f31824b.a(new e(qVar.get().getBitmap(), this.f31823a), file, eVar);
    }
}
