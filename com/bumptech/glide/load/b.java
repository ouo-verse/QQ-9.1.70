package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f31552a;

        a(InputStream inputStream) {
            this.f31552a = inputStream;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.f31552a);
            } finally {
                this.f31552a.reset();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.bumptech.glide.load.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0214b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f31553a;

        C0214b(ByteBuffer byteBuffer) {
            this.f31553a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.getType(this.f31553a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f31554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r.b f31555b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, r.b bVar) {
            this.f31554a = parcelFileDescriptorRewinder;
            this.f31555b = bVar;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f31554a.a().getFileDescriptor()), this.f31555b);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.f31554a.a();
                return type;
            } catch (Throwable th6) {
                th = th6;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f31554a.a();
                throw th;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class d implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f31556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r.b f31557b;

        d(InputStream inputStream, r.b bVar) {
            this.f31556a = inputStream;
            this.f31557b = bVar;
        }

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f31556a, this.f31557b);
            } finally {
                this.f31556a.reset();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class e implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f31558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r.b f31559b;

        e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, r.b bVar) {
            this.f31558a = parcelFileDescriptorRewinder;
            this.f31559b = bVar;
        }

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f31558a.a().getFileDescriptor()), this.f31559b);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                int a16 = imageHeaderParser.a(recyclableBufferedInputStream, this.f31559b);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.f31558a.a();
                return a16;
            } catch (Throwable th6) {
                th = th6;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f31558a.a();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull r.b bVar) throws IOException {
        return c(list, new e(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull r.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, bVar));
    }

    private static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            int a16 = fVar.a(list.get(i3));
            if (a16 != -1) {
                return a16;
            }
        }
        return -1;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull r.b bVar) throws IOException {
        return g(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    @NonNull
    public static ImageHeaderParser.ImageType e(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull r.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return g(list, new a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType f(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return g(list, new C0214b(byteBuffer));
    }

    @NonNull
    private static ImageHeaderParser.ImageType g(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImageHeaderParser.ImageType a16 = gVar.a(list.get(i3));
            if (a16 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a16;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
