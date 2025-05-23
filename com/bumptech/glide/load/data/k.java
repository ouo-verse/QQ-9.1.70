package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclableBufferedInputStream f31589a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final r.b f31590a;

        public a(r.b bVar) {
            this.f31590a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e<InputStream> build(InputStream inputStream) {
            return new k(inputStream, this.f31590a);
        }
    }

    public k(InputStream inputStream, r.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f31589a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void b() {
        this.f31589a.d();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.f31589a.reset();
        return this.f31589a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void cleanup() {
        this.f31589a.release();
    }
}
