package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.w;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.util.ImageContentType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: f, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<DecodeFormat> f31835f = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<PreferredColorSpace> f31836g = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.d<DownsampleStrategy> f31837h = DownsampleStrategy.f31791h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Boolean> f31838i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Boolean> f31839j;

    /* renamed from: k, reason: collision with root package name */
    private static final Set<String> f31840k;

    /* renamed from: l, reason: collision with root package name */
    private static final b f31841l;

    /* renamed from: m, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f31842m;

    /* renamed from: n, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f31843n;

    /* renamed from: a, reason: collision with root package name */
    private final r.d f31844a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f31845b;

    /* renamed from: c, reason: collision with root package name */
    private final r.b f31846c;

    /* renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f31847d;

    /* renamed from: e, reason: collision with root package name */
    private final v f31848e = v.b();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a(r.d dVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f31838i = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f31839j = com.bumptech.glide.load.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f31840k = Collections.unmodifiableSet(new HashSet(Arrays.asList(ImageContentType.MIME_TYPE_WBMP, "image/x-ico")));
        f31841l = new a();
        f31842m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f31843n = h0.k.e(0);
    }

    public q(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, r.d dVar, r.b bVar) {
        this.f31847d = list;
        this.f31845b = (DisplayMetrics) h0.j.d(displayMetrics);
        this.f31844a = (r.d) h0.j.d(dVar);
        this.f31846c = (r.b) h0.j.d(bVar);
    }

    private static int a(double d16) {
        return x((d16 / (r1 / r0)) * x(l(d16) * d16));
    }

    private void b(w wVar, DecodeFormat decodeFormat, boolean z16, boolean z17, BitmapFactory.Options options, int i3, int i16) {
        boolean z18;
        Bitmap.Config config;
        if (this.f31848e.i(i3, i16, options, z16, z17)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            try {
                z18 = wVar.getImageType().hasAlpha();
            } catch (IOException e16) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e16);
                }
                z18 = false;
            }
            if (z18) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, w wVar, b bVar, r.d dVar, DownsampleStrategy downsampleStrategy, int i3, int i16, int i17, int i18, int i19, BitmapFactory.Options options) throws IOException {
        int i26;
        int i27;
        int min;
        int i28;
        int floor;
        double floor2;
        int i29;
        if (i16 > 0 && i17 > 0) {
            if (r(i3)) {
                i27 = i16;
                i26 = i17;
            } else {
                i26 = i16;
                i27 = i17;
            }
            float b16 = downsampleStrategy.b(i26, i27, i18, i19);
            if (b16 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a16 = downsampleStrategy.a(i26, i27, i18, i19);
                if (a16 != null) {
                    float f16 = i26;
                    float f17 = i27;
                    int x16 = i26 / x(b16 * f16);
                    int x17 = i27 / x(b16 * f17);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a16 == sampleSizeRounding) {
                        min = Math.max(x16, x17);
                    } else {
                        min = Math.min(x16, x17);
                    }
                    int i36 = Build.VERSION.SDK_INT;
                    if (i36 > 23 || !f31840k.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(min));
                        if (a16 == sampleSizeRounding && max < 1.0f / b16) {
                            max <<= 1;
                        }
                        i28 = max;
                    } else {
                        i28 = 1;
                    }
                    options.inSampleSize = i28;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(i28, 8);
                        floor = (int) Math.ceil(f16 / min2);
                        i29 = (int) Math.ceil(f17 / min2);
                        int i37 = i28 / 8;
                        if (i37 > 0) {
                            floor /= i37;
                            i29 /= i37;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                                if (i36 >= 24) {
                                    float f18 = i28;
                                    floor = Math.round(f16 / f18);
                                    i29 = Math.round(f17 / f18);
                                } else {
                                    float f19 = i28;
                                    floor = (int) Math.floor(f16 / f19);
                                    floor2 = Math.floor(f17 / f19);
                                }
                            } else if (i26 % i28 == 0 && i27 % i28 == 0) {
                                floor = i26 / i28;
                                i29 = i27 / i28;
                            } else {
                                int[] m3 = m(wVar, options, bVar, dVar);
                                floor = m3[0];
                                i29 = m3[1];
                            }
                        } else {
                            float f26 = i28;
                            floor = (int) Math.floor(f16 / f26);
                            floor2 = Math.floor(f17 / f26);
                        }
                        i29 = (int) floor2;
                    }
                    double b17 = downsampleStrategy.b(floor, i29, i18, i19);
                    options.inTargetDensity = a(b17);
                    options.inDensity = l(b17);
                    if (s(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i16 + HippyTKDListViewAdapter.X + i17 + "], degreesToRotate: " + i3 + ", target: [" + i18 + HippyTKDListViewAdapter.X + i19 + "], power of two scaled: [" + floor + HippyTKDListViewAdapter.X + i29 + "], exact scale factor: " + b16 + ", power of 2 sample size: " + i28 + ", adjusted scale factor: " + b17 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b16 + " from: " + downsampleStrategy + ", source: [" + i16 + HippyTKDListViewAdapter.X + i17 + "], target: [" + i18 + HippyTKDListViewAdapter.X + i19 + "]");
        }
        if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i18 + HippyTKDListViewAdapter.X + i19 + "]");
        }
    }

    private com.bumptech.glide.load.engine.q<Bitmap> e(w wVar, int i3, int i16, com.bumptech.glide.load.e eVar, b bVar) throws IOException {
        boolean z16;
        byte[] bArr = (byte[]) this.f31846c.b(65536, byte[].class);
        BitmapFactory.Options k3 = k();
        k3.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.c(f31835f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) eVar.c(f31836g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f31791h);
        boolean booleanValue = ((Boolean) eVar.c(f31838i)).booleanValue();
        com.bumptech.glide.load.d<Boolean> dVar = f31839j;
        if (eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            return e.b(h(wVar, k3, downsampleStrategy, decodeFormat, preferredColorSpace, z16, i3, i16, booleanValue, bVar), this.f31844a);
        } finally {
            v(k3);
            this.f31846c.put(bArr);
        }
    }

    private Bitmap h(w wVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z16, int i3, int i16, boolean z17, b bVar) throws IOException {
        boolean z18;
        int i17;
        int i18;
        int i19;
        String str;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        int i26;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        float f16;
        int round;
        int round2;
        long b16 = h0.f.b();
        int[] m3 = m(wVar, options, bVar, this.f31844a);
        boolean z19 = false;
        int i27 = m3[0];
        int i28 = m3[1];
        String str2 = options.outMimeType;
        if (i27 != -1 && i28 != -1) {
            z18 = z16;
        } else {
            z18 = false;
        }
        int c16 = wVar.c();
        int g16 = ac.g(c16);
        boolean j3 = ac.j(c16);
        if (i3 == Integer.MIN_VALUE) {
            i17 = i16;
            if (r(g16)) {
                i18 = i28;
            } else {
                i18 = i27;
            }
        } else {
            i17 = i16;
            i18 = i3;
        }
        if (i17 == Integer.MIN_VALUE) {
            if (r(g16)) {
                i19 = i27;
            } else {
                i19 = i28;
            }
        } else {
            i19 = i17;
        }
        ImageHeaderParser.ImageType imageType = wVar.getImageType();
        c(imageType, wVar, bVar, this.f31844a, downsampleStrategy, g16, i27, i28, i18, i19, options);
        b(wVar, decodeFormat, z18, j3, options, i18, i19);
        int i29 = Build.VERSION.SDK_INT;
        int i36 = options.inSampleSize;
        if (!z(imageType)) {
            str = "Downsampler";
        } else {
            if (i27 >= 0 && i28 >= 0 && z17) {
                str = "Downsampler";
                round = i18;
                round2 = i19;
            } else {
                if (s(options)) {
                    f16 = options.inTargetDensity / options.inDensity;
                } else {
                    f16 = 1.0f;
                }
                int i37 = options.inSampleSize;
                float f17 = i37;
                int ceil = (int) Math.ceil(i27 / f17);
                int ceil2 = (int) Math.ceil(i28 / f17);
                round = Math.round(ceil * f16);
                round2 = Math.round(ceil2 * f16);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + round + HippyTKDListViewAdapter.X + round2 + "] for source [" + i27 + HippyTKDListViewAdapter.X + i28 + "], sampleSize: " + i37 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f16);
                }
            }
            if (round > 0 && round2 > 0) {
                y(options, this.f31844a, round, round2);
            }
        }
        if (i29 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = options.outColorSpace;
                if (colorSpace3 != null) {
                    colorSpace4 = options.outColorSpace;
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        z19 = true;
                    }
                }
            }
            colorSpace2 = ColorSpace.get(z19 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            options.inPreferredColorSpace = colorSpace2;
        } else if (i29 >= 26) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
            options.inPreferredColorSpace = colorSpace;
        }
        Bitmap i38 = i(wVar, options, bVar, this.f31844a);
        bVar.a(this.f31844a, i38);
        if (Log.isLoggable(str, 2)) {
            i26 = c16;
            t(i27, i28, str2, options, i38, i3, i16, b16);
        } else {
            i26 = c16;
        }
        if (i38 != null) {
            i38.setDensity(this.f31845b.densityDpi);
            Bitmap k3 = ac.k(this.f31844a, i38, i26);
            if (!i38.equals(k3)) {
                this.f31844a.put(i38);
                return k3;
            }
            return k3;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap i(w wVar, BitmapFactory.Options options, b bVar, r.d dVar) throws IOException {
        if (!options.inJustDecodeBounds) {
            bVar.b();
            wVar.a();
        }
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        String str = options.outMimeType;
        ac.f().lock();
        try {
            try {
                Bitmap b16 = wVar.b(options);
                ac.f().unlock();
                return b16;
            } catch (IllegalArgumentException e16) {
                IOException u16 = u(e16, i3, i16, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", u16);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        dVar.put(bitmap);
                        options.inBitmap = null;
                        Bitmap i17 = i(wVar, options, bVar, dVar);
                        ac.f().unlock();
                        return i17;
                    } catch (IOException unused) {
                        throw u16;
                    }
                }
                throw u16;
            }
        } catch (Throwable th5) {
            ac.f().unlock();
            throw th5;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + HippyTKDListViewAdapter.X + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (q.class) {
            Queue<BitmapFactory.Options> queue = f31843n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d16) {
        if (d16 > 1.0d) {
            d16 = 1.0d / d16;
        }
        return (int) Math.round(d16 * 2.147483647E9d);
    }

    private static int[] m(w wVar, BitmapFactory.Options options, b bVar, r.d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(wVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i3) {
        if (i3 != 90 && i3 != 270) {
            return false;
        }
        return true;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i3;
        int i16 = options.inTargetDensity;
        if (i16 > 0 && (i3 = options.inDensity) > 0 && i16 != i3) {
            return true;
        }
        return false;
    }

    private static void t(int i3, int i16, String str, BitmapFactory.Options options, Bitmap bitmap, int i17, int i18, long j3) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i3 + HippyTKDListViewAdapter.X + i16 + "] " + str + " with inBitmap " + n(options) + " for [" + i17 + HippyTKDListViewAdapter.X + i18 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + h0.f.a(j3));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i3, int i16, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i3 + ", outHeight: " + i16 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f31843n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d16) {
        return (int) (d16 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, r.d dVar, int i3, int i16) {
        Bitmap.Config config;
        Bitmap.Config config2;
        if (Build.VERSION.SDK_INT >= 26) {
            Bitmap.Config config3 = options.inPreferredConfig;
            config2 = Bitmap.Config.HARDWARE;
            if (config3 != config2) {
                config = options.outConfig;
            } else {
                return;
            }
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.b(i3, i16, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    @RequiresApi(21)
    public com.bumptech.glide.load.engine.q<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i3, int i16, com.bumptech.glide.load.e eVar) throws IOException {
        return e(new w.b(parcelFileDescriptor, this.f31847d, this.f31846c), i3, i16, eVar, f31841l);
    }

    public com.bumptech.glide.load.engine.q<Bitmap> f(InputStream inputStream, int i3, int i16, com.bumptech.glide.load.e eVar) throws IOException {
        return g(inputStream, i3, i16, eVar, f31841l);
    }

    public com.bumptech.glide.load.engine.q<Bitmap> g(InputStream inputStream, int i3, int i16, com.bumptech.glide.load.e eVar, b bVar) throws IOException {
        return e(new w.a(inputStream, this.f31847d, this.f31846c), i3, i16, eVar, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.b();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q.b
        public void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q.b
        public void a(r.d dVar, Bitmap bitmap) {
        }
    }
}
