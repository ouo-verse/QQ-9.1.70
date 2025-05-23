package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class s implements com.bumptech.glide.load.h<Drawable> {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f31850b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f31851c;

    public s(com.bumptech.glide.load.h<Bitmap> hVar, boolean z16) {
        this.f31850b = hVar;
        this.f31851c = z16;
    }

    private com.bumptech.glide.load.engine.q<Drawable> d(Context context, com.bumptech.glide.load.engine.q<Bitmap> qVar) {
        return y.b(context.getResources(), qVar);
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public com.bumptech.glide.load.engine.q<Drawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.q<Drawable> qVar, int i3, int i16) {
        r.d f16 = com.bumptech.glide.b.c(context).f();
        Drawable drawable = qVar.get();
        com.bumptech.glide.load.engine.q<Bitmap> a16 = r.a(f16, drawable, i3, i16);
        if (a16 == null) {
            if (!this.f31851c) {
                return qVar;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        com.bumptech.glide.load.engine.q<Bitmap> a17 = this.f31850b.a(context, a16, i3, i16);
        if (a17.equals(a16)) {
            a17.recycle();
            return qVar;
        }
        return d(context, a17);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f31850b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f31850b.equals(((s) obj).f31850b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f31850b.hashCode();
    }

    public com.bumptech.glide.load.h<BitmapDrawable> c() {
        return this;
    }
}
