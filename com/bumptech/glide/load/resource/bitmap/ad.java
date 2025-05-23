package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ad implements com.bumptech.glide.load.f<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.load.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull Bitmap bitmap, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return new a(bitmap);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.e eVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.load.engine.q<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Bitmap f31822d;

        a(@NonNull Bitmap bitmap) {
            this.f31822d = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.q
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f31822d;
        }

        @Override // com.bumptech.glide.load.engine.q
        @NonNull
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.q
        public int getSize() {
            return h0.k.g(this.f31822d);
        }

        @Override // com.bumptech.glide.load.engine.q
        public void recycle() {
        }
    }
}
