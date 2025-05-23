package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class VideoDecoder<T> implements com.bumptech.glide.load.f<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Long> f31799d = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f31800e = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f, reason: collision with root package name */
    private static final e f31801f = new e();

    /* renamed from: a, reason: collision with root package name */
    private final f<T> f31802a;

    /* renamed from: b, reason: collision with root package name */
    private final r.d f31803b;

    /* renamed from: c, reason: collision with root package name */
    private final e f31804c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements d.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f31805a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.d.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Long l3, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f31805a) {
                this.f31805a.position(0);
                messageDigest.update(this.f31805a.putLong(l3.longValue()).array());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class b implements d.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f31806a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.d.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f31806a) {
                this.f31806a.position(0);
                messageDigest.update(this.f31806a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c implements f<AssetFileDescriptor> {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(r.d dVar, f<T> fVar) {
        this(dVar, fVar, f31801f);
    }

    public static com.bumptech.glide.load.f<AssetFileDescriptor, Bitmap> c(r.d dVar) {
        return new VideoDecoder(dVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.f<ByteBuffer, Bitmap> d(r.d dVar) {
        return new VideoDecoder(dVar, new d());
    }

    @Nullable
    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3, int i16, int i17, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 27 && i16 != Integer.MIN_VALUE && i17 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f31789f) {
            bitmap = g(mediaMetadataRetriever, j3, i3, i16, i17, downsampleStrategy);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = f(mediaMetadataRetriever, j3, i3);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3) {
        return mediaMetadataRetriever.getFrameAtTime(j3, i3);
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j3, int i3, int i16, int i17, DownsampleStrategy downsampleStrategy) {
        Bitmap scaledFrameAtTime;
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b16 = downsampleStrategy.b(parseInt, parseInt2, i16, i17);
            scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j3, i3, Math.round(parseInt * b16), Math.round(b16 * parseInt2));
            return scaledFrameAtTime;
        } catch (Throwable th5) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th5);
                return null;
            }
            return null;
        }
    }

    public static com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> h(r.d dVar) {
        return new VideoDecoder(dVar, new g());
    }

    @Override // com.bumptech.glide.load.f
    public boolean a(@NonNull T t16, @NonNull com.bumptech.glide.load.e eVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.q<Bitmap> b(@NonNull T t16, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) throws IOException {
        long longValue = ((Long) eVar.c(f31799d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) eVar.c(f31800e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f31791h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f31790g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a16 = this.f31804c.a();
        try {
            this.f31802a.a(a16, t16);
            Bitmap e16 = e(a16, longValue, num.intValue(), i3, i16, downsampleStrategy2);
            a16.release();
            return com.bumptech.glide.load.resource.bitmap.e.b(e16, this.f31803b);
        } catch (Throwable th5) {
            a16.release();
            throw th5;
        }
    }

    @VisibleForTesting
    VideoDecoder(r.d dVar, f<T> fVar, e eVar) {
        this.f31803b = dVar;
        this.f31802a = fVar;
        this.f31804c = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static final class d implements f<ByteBuffer> {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public class a extends MediaDataSource {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f31807d;

            a(ByteBuffer byteBuffer) {
                this.f31807d = byteBuffer;
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f31807d.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j3, byte[] bArr, int i3, int i16) {
                if (j3 >= this.f31807d.limit()) {
                    return -1;
                }
                this.f31807d.position((int) j3);
                int min = Math.min(i16, this.f31807d.remaining());
                this.f31807d.get(bArr, i3, min);
                return min;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }
}
