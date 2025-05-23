package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.q;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class ab implements com.bumptech.glide.load.f<InputStream, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final q f31813a;

    /* renamed from: b, reason: collision with root package name */
    private final r.b f31814b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements q.b {

        /* renamed from: a, reason: collision with root package name */
        private final RecyclableBufferedInputStream f31815a;

        /* renamed from: b, reason: collision with root package name */
        private final h0.d f31816b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, h0.d dVar) {
            this.f31815a = recyclableBufferedInputStream;
            this.f31816b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q.b
        public void a(r.d dVar, Bitmap bitmap) throws IOException {
            IOException a16 = this.f31816b.a();
            if (a16 != null) {
                if (bitmap != null) {
                    dVar.put(bitmap);
                    throw a16;
                }
                throw a16;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q.b
        public void b() {
            this.f31815a.d();
        }
    }

    public ab(q qVar, r.b bVar) {
        this.f31813a = qVar;
        this.f31814b = bVar;
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull InputStream inputStream, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        boolean z16;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z16 = false;
        } else {
            z16 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f31814b);
        }
        h0.d b16 = h0.d.b(recyclableBufferedInputStream);
        try {
            return this.f31813a.g(new h0.h(b16), i3, i16, eVar, new a(recyclableBufferedInputStream, b16));
        } finally {
            b16.release();
            if (z16) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f31813a.p(inputStream);
    }
}
