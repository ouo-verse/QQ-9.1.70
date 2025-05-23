package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
interface w {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.k f31864a;

        /* renamed from: b, reason: collision with root package name */
        private final r.b f31865b;

        /* renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f31866c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(InputStream inputStream, List<ImageHeaderParser> list, r.b bVar) {
            this.f31865b = (r.b) h0.j.d(bVar);
            this.f31866c = (List) h0.j.d(list);
            this.f31864a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public void a() {
            this.f31864a.b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        @Nullable
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f31864a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public int c() throws IOException {
            return com.bumptech.glide.load.b.b(this.f31866c, this.f31864a.a(), this.f31865b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return com.bumptech.glide.load.b.e(this.f31866c, this.f31864a.a(), this.f31865b);
        }
    }

    void a();

    @Nullable
    Bitmap b(BitmapFactory.Options options) throws IOException;

    int c() throws IOException;

    ImageHeaderParser.ImageType getImageType() throws IOException;

    /* compiled from: P */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class b implements w {

        /* renamed from: a, reason: collision with root package name */
        private final r.b f31867a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f31868b;

        /* renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f31869c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, r.b bVar) {
            this.f31867a = (r.b) h0.j.d(bVar);
            this.f31868b = (List) h0.j.d(list);
            this.f31869c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        @Nullable
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f31869c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public int c() throws IOException {
            return com.bumptech.glide.load.b.a(this.f31868b, this.f31869c, this.f31867a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            return com.bumptech.glide.load.b.d(this.f31868b, this.f31869c, this.f31867a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.w
        public void a() {
        }
    }
}
