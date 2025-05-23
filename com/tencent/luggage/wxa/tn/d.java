package com.tencent.luggage.wxa.tn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.tn.n0;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f141555a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f141556b = (long) (Runtime.getRuntime().maxMemory() * 0.05d);

    /* renamed from: c, reason: collision with root package name */
    public static DisplayMetrics f141557c = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends n0.b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0.b.C6773b[] f141558a;

        public a(n0.b.C6773b[] c6773bArr) {
            this.f141558a = c6773bArr;
        }

        @Override // com.tencent.luggage.wxa.tn.n0.b.a
        public void b(n0.b.C6773b c6773b) {
            this.f141558a[0] = c6773b;
        }
    }

    public static void a(BitmapFactory.Options options) {
    }

    public static boolean b() {
        return f141555a;
    }

    public static boolean c(String str) {
        if (b(str) && !f141555a && Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public static int a(int i3, int i16, int i17, int i18) {
        int round;
        if (i3 <= i18 && i16 <= i17) {
            return 1;
        }
        if (i16 > i3) {
            round = Math.round((i3 / i18) + 0.5f);
        } else {
            round = Math.round((i16 / i17) + 0.5f);
        }
        while ((i16 * i3) / (round * round) > i17 * i18 * 2) {
            round++;
        }
        return round;
    }

    public static boolean b(String str) {
        return str.contains(com.tencent.luggage.wxa.db.a.c());
    }

    public static Bitmap a(int i3, int i16, Bitmap.Config config, boolean z16) {
        Bitmap bitmap;
        Bitmap createBitmap;
        int i17;
        try {
            createBitmap = Bitmap.createBitmap(i3, i16, config);
        } catch (Throwable unused) {
            bitmap = null;
            if (z16) {
                return null;
            }
            try {
                DisplayMetrics a16 = a();
                int i18 = a16.widthPixels;
                if (i3 > i18 && i16 > (i17 = a16.heightPixels)) {
                    i16 = i17;
                    i3 = i18;
                }
                createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
            } catch (Throwable unused2) {
            }
        }
        bitmap = createBitmap;
        a(bitmap);
        return c.a(bitmap);
    }

    public static Bitmap a(int i3, int i16, Bitmap.Config config) {
        return a(i3, i16, config, false);
    }

    public static Bitmap a(String str) {
        return a(str, (BitmapFactory.Options) null);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x001a */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        InputStream inputStream2;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        InputStream inputStream3 = null;
        try {
            try {
                inputStream = com.tencent.luggage.wxa.cp.x.n(str);
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream3 != null) {
                }
                throw th;
            }
            try {
                a(options);
                Bitmap a16 = MMBitmapFactory.a(inputStream, null, options);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a16;
            } catch (IOException e17) {
                e = e17;
                w.b("MicroMsg.BitmapUtil", "Cannot decode file '%s': %s", str, e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream3 = inputStream2;
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public static Bitmap a(InputStream inputStream, float f16, int i3, int i16) {
        return a(inputStream, f16, i3, i16, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(InputStream inputStream, float f16, int i3, int i16, boolean z16) {
        InputStream bufferedInputStream;
        int i17;
        int i18;
        Bitmap a16;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (f16 != 0.0f) {
            options.inDensity = (int) (f16 * 160.0f);
        }
        if (i3 != 0 || i16 != 0) {
            if (i3 == 0) {
                i3 = Integer.MAX_VALUE;
            }
            if (i16 == 0) {
                i16 = Integer.MAX_VALUE;
            }
            try {
                if (inputStream instanceof FileInputStream) {
                    bufferedInputStream = new n((FileInputStream) inputStream);
                } else {
                    if (!inputStream.markSupported()) {
                        bufferedInputStream = new BufferedInputStream(inputStream, 65536);
                    }
                    inputStream.mark(25165824);
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.a(inputStream, null, options);
                    i17 = options.outWidth;
                    i18 = options.outHeight;
                    if ((i3 > i16 && i17 < i18) || (i3 < i16 && i17 > i18)) {
                        i18 = i17;
                        i17 = i18;
                    }
                    if (z16) {
                        options.inSampleSize = a(i17, i18, i3, i16);
                    } else if (i17 > i3 || i18 > i16) {
                        options.inSampleSize = (int) Math.max(i17 / i3, i18 / i16);
                    }
                    options.inJustDecodeBounds = false;
                    inputStream.reset();
                }
                if (i3 > i16) {
                    i18 = i17;
                    i17 = i18;
                    if (z16) {
                    }
                    options.inJustDecodeBounds = false;
                    inputStream.reset();
                }
                inputStream.reset();
            } catch (IOException e16) {
                w.a("MicroMsg.BitmapUtil", e16, "Failed seeking InputStream.", new Object[0]);
            }
            inputStream = bufferedInputStream;
            inputStream.mark(25165824);
            options.inJustDecodeBounds = true;
            MMBitmapFactory.a(inputStream, null, options);
            i17 = options.outWidth;
            i18 = options.outHeight;
            i18 = i17;
            i17 = i18;
            if (z16) {
            }
            options.inJustDecodeBounds = false;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        a(options);
        try {
            a16 = MMBitmapFactory.a(inputStream, null, options);
        } catch (OutOfMemoryError unused) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            a(options);
            try {
                a16 = MMBitmapFactory.a(inputStream, null, options);
            } catch (OutOfMemoryError unused2) {
                w.b("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                return null;
            }
        }
        return a16;
    }

    public static Bitmap a(InputStream inputStream) {
        return a(inputStream, 0.0f, 0, 0);
    }

    public static DisplayMetrics a() {
        if (f141557c == null) {
            f141557c = z.c().getResources().getDisplayMetrics();
        }
        return f141557c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        if (r2 <= 1.001d) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Bitmap bitmap, float f16, float f17) {
        Bitmap bitmap2;
        if (bitmap == null) {
            return null;
        }
        double d16 = f16;
        if (d16 > 0.999d && d16 < 1.001d) {
            double d17 = f17;
            if (d17 > 0.999d && d17 < 1.001d) {
                return bitmap;
            }
        }
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        if (d16 >= 0.999d && d16 <= 1.001d) {
            double d18 = f17;
            if (d18 >= 0.999d) {
            }
        }
        matrix.postScale(f16, f17);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th5) {
            th = th5;
            bitmap2 = bitmap;
        }
        try {
            a(bitmap2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resultBmp is null: ");
            sb5.append(bitmap2 == null);
            w.a("MicroMsg.BitmapUtil", sb5.toString());
            if (bitmap != bitmap2) {
                w.d("MicroMsg.BitmapUtil", "scale bitmap recycle. %s", bitmap);
                bitmap.recycle();
            }
            return c.a(bitmap2);
        } catch (Throwable th6) {
            th = th6;
            w.a("MicroMsg.BitmapUtil", "scaleBitmap failed : %s ", w0.a(th));
            return bitmap2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public static Bitmap a(Bitmap bitmap, int i3, int i16, boolean z16, boolean z17) {
        BitmapFactory.Options options;
        double d16;
        double d17;
        double d18;
        double d19;
        int i17;
        int i18;
        int i19;
        String str;
        double ceil;
        double ceil2;
        int i26;
        int i27;
        int i28;
        int i29;
        Bitmap bitmap2 = bitmap;
        Bitmap bitmap3 = z17;
        String str2 = "MicroMsg.BitmapUtil";
        if (bitmap2 == null) {
            w.b("MicroMsg.BitmapUtil", "extractThumbNail bitmap is null.");
            return null;
        }
        try {
            if (i3 > 0 && i16 > 0) {
                try {
                    options = new BitmapFactory.Options();
                    a(options);
                    options.outHeight = bitmap.getHeight();
                    options.outWidth = bitmap.getWidth();
                    w.d("MicroMsg.BitmapUtil", "extractThumbNail: round=" + i16 + HippyTKDListViewAdapter.X + i3 + ", crop=" + z16 + ", recycle=" + ((boolean) bitmap3));
                    d16 = (double) i3;
                    d17 = (((double) options.outHeight) * 1.0d) / d16;
                    d18 = (double) i16;
                    d19 = (((double) options.outWidth) * 1.0d) / d18;
                    w.a("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d19 + ", beY = " + d17);
                    i17 = (int) ((!z16 ? d17 < d19 : d17 > d19) ? d17 : d19);
                } catch (Throwable th5) {
                    th = th5;
                    bitmap3 = bitmap2;
                }
                try {
                    options.inSampleSize = i17;
                    if (i17 <= 1) {
                        options.inSampleSize = 1;
                    }
                    while (true) {
                        i18 = options.outHeight;
                        i19 = options.outWidth;
                        int i36 = options.inSampleSize;
                        str = str2;
                        if (((i18 * i19) / i36) / i36 <= 2764800) {
                            break;
                        }
                        options.inSampleSize = i36 + 1;
                        str2 = str;
                    }
                    if (z16) {
                        if (d17 > d19) {
                            ceil2 = Math.ceil(((d18 * 1.0d) * i18) / i19);
                            i27 = (int) ceil2;
                            i26 = i16;
                        } else {
                            ceil = Math.ceil(((d16 * 1.0d) * i19) / i18);
                            i26 = (int) ceil;
                            i27 = i3;
                        }
                    } else if (d17 < d19) {
                        ceil2 = Math.ceil(((d18 * 1.0d) * i18) / i19);
                        i27 = (int) ceil2;
                        i26 = i16;
                    } else {
                        ceil = Math.ceil(((d16 * 1.0d) * i19) / i18);
                        i26 = (int) ceil;
                        i27 = i3;
                    }
                    options.inJustDecodeBounds = false;
                    w.d(str, "bitmap required size=" + i26 + HippyTKDListViewAdapter.X + i27 + ", orig=" + options.outWidth + HippyTKDListViewAdapter.X + options.outHeight + ", sample=" + options.inSampleSize);
                    Bitmap bitmap4 = bitmap;
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap4, i26, i27, true);
                    if (createScaledBitmap != null) {
                        if (z17 && bitmap4 != createScaledBitmap) {
                            w.d(str, "extractThumbNail bitmap recycle asdfjasjdfja asdfasd. %s", bitmap4);
                            bitmap.recycle();
                        }
                        bitmap4 = createScaledBitmap;
                    }
                    if (z16) {
                        if (bitmap4.getWidth() < i16) {
                            w.b(str, "bmw < width %d %d", Integer.valueOf(bitmap4.getWidth()), Integer.valueOf(i16));
                            i28 = bitmap4.getWidth();
                        } else {
                            i28 = i16;
                        }
                        if (bitmap4.getHeight() < i3) {
                            w.b(str, "bmh < height %d %d", Integer.valueOf(bitmap4.getHeight()), Integer.valueOf(i3));
                            i29 = bitmap4.getHeight();
                        } else {
                            i29 = i3;
                        }
                        bitmap2 = Bitmap.createBitmap(bitmap4, (bitmap4.getWidth() - i28) >> 1, (bitmap4.getHeight() - i29) >> 1, i28, i29);
                        if (bitmap2 == null) {
                            a(bitmap4);
                            return bitmap4;
                        }
                        if (z17 && bitmap4 != bitmap2) {
                            w.d(str, "extractThumbNail bitmap recycle ajdfjajsdfjdsajjfsad. %s", bitmap4);
                            bitmap4.recycle();
                        }
                        w.a(str, "bitmap croped size=" + bitmap2.getWidth() + HippyTKDListViewAdapter.X + bitmap2.getHeight());
                        bitmap4 = bitmap2;
                    }
                    a(bitmap4);
                    return bitmap4;
                } catch (Throwable th6) {
                    th = th6;
                    bitmap3 = bitmap;
                    a(bitmap3);
                    throw th;
                }
            }
            w.b("MicroMsg.BitmapUtil", "extractThumbNail height:" + i3 + " width:" + i16);
            a(bitmap);
            return null;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f16) {
        Bitmap createBitmap;
        if (bitmap != null && f16 % 360.0f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(f16, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            try {
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                a(createBitmap);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("resultBmp is null: ");
                sb5.append(createBitmap == null);
                sb5.append("  degree:");
                sb5.append(f16);
                w.a("MicroMsg.BitmapUtil", sb5.toString());
                if (bitmap != createBitmap) {
                    w.d("MicroMsg.BitmapUtil", "rotate bitmap recycle ajsdfasdf adsf. %s", bitmap);
                    bitmap.recycle();
                }
                return c.a(createBitmap);
            } catch (Throwable th6) {
                th = th6;
                bitmap = createBitmap;
                w.a("MicroMsg.BitmapUtil", "createBitmap failed : %s ", w0.a(th));
                return bitmap;
            }
        }
        return bitmap;
    }

    public static boolean a(Bitmap bitmap, int i3, Bitmap.CompressFormat compressFormat, OutputStream outputStream, boolean z16) {
        boolean a16 = a(bitmap, compressFormat, i3, outputStream);
        if (z16) {
            w.d("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", bitmap);
            bitmap.recycle();
        }
        return a16;
    }

    public static boolean a(Bitmap bitmap, int i3, Bitmap.CompressFormat compressFormat, String str, boolean z16) {
        if (!w0.c(str)) {
            w.d("MicroMsg.BitmapUtil", "saving to " + str);
            com.tencent.luggage.wxa.cp.x.m(com.tencent.luggage.wxa.cp.x.k(str));
            OutputStream outputStream = null;
            try {
                try {
                    if (c(str)) {
                        n0.b.C6773b[] c6773bArr = new n0.b.C6773b[1];
                        n0.a.a(z.c(), str, new a(c6773bArr));
                        n0.b.C6773b c6773b = c6773bArr[0];
                        if (c6773b == null) {
                            if (z16) {
                                w.d("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                                bitmap.recycle();
                            }
                            return false;
                        }
                        OutputStream b16 = c6773b.b();
                        boolean a16 = a(bitmap, i3, compressFormat, b16, z16);
                        c6773bArr[0].c();
                        if (z16) {
                            w.d("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                            bitmap.recycle();
                        }
                        if (b16 != null) {
                            try {
                                b16.close();
                            } catch (IOException unused) {
                            }
                        }
                        return a16;
                    }
                    OutputStream o16 = com.tencent.luggage.wxa.cp.x.o(str);
                    boolean a17 = a(bitmap, i3, compressFormat, o16, z16);
                    if (z16) {
                        w.d("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                        bitmap.recycle();
                    }
                    if (o16 != null) {
                        try {
                            o16.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return a17;
                } catch (Exception e16) {
                    w.a("MicroMsg.BitmapUtil", e16, "saveBitmapToImage failed: %s", str);
                    throw new IOException(e16);
                }
            } catch (Throwable th5) {
                if (z16) {
                    w.d("MicroMsg.BitmapUtil", "bitmap recycle %s", bitmap.toString());
                    bitmap.recycle();
                }
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th5;
            }
        }
        throw new IOException("saveBitmapToImage pathName null or nil");
    }

    public static Bitmap a(Bitmap bitmap, int i3, int i16, boolean z16) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        a(bitmap);
        float f16 = i3;
        float width = bitmap.getWidth();
        float f17 = i16;
        float height = bitmap.getHeight();
        float max = Math.max(f16 / width, f17 / height);
        float f18 = width * max;
        float f19 = max * height;
        float f26 = (f16 - f18) / 2.0f;
        float f27 = (f17 - f19) / 2.0f;
        RectF rectF = new RectF(f26, f27, f18 + f26, f19 + f27);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            w.f("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
            config = Bitmap.Config.ARGB_8888;
        }
        try {
            try {
                createBitmap = Bitmap.createBitmap(i3, i16, config);
            } catch (Throwable unused) {
                w.b("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
                return bitmap;
            }
        } catch (Throwable unused2) {
            createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.RGB_565);
        }
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        if (z16) {
            w.d("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
        a(createBitmap);
        return c.a(createBitmap);
    }

    public static Bitmap a(Bitmap bitmap, boolean z16, float f16, boolean z17) {
        return a(bitmap, z16, f16, z17, (int[]) null);
    }

    public static Bitmap a(Bitmap bitmap, boolean z16, float f16, boolean z17, int[] iArr) {
        if (bitmap != null && !bitmap.isRecycled()) {
            a(bitmap);
            int[] iArr2 = iArr == null ? new int[]{bitmap.getWidth(), bitmap.getHeight()} : iArr;
            Bitmap a16 = a(iArr2[0], iArr2[1], Bitmap.Config.ARGB_8888, z17);
            if (a16 == null) {
                return null;
            }
            Canvas canvas = new Canvas(a16);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, a16.getWidth(), a16.getHeight());
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-4144960);
            canvas.drawPath(a(rectF, f16, f16, f16, f16, 0.6f), paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            if (z16) {
                w.d("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            a(a16);
            return c.a(a16);
        }
        w.b("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
        return null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z16, float f16) {
        return a(bitmap, z16, f16, false, (int[]) null);
    }

    public static Path a(RectF rectF, float f16, float f17, float f18, float f19, float f26) {
        float f27;
        float f28;
        Path path = new Path();
        float f29 = f16 < 0.0f ? 0.0f : f16;
        float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
        float min2 = Math.min(f29, min);
        float min3 = Math.min((f26 + 1.0f) * min2, min);
        float f36 = min / 2.0f;
        if (f29 <= f36) {
            f27 = (1.0f - f26) * 90.0f;
            f28 = f26 * 45.0f;
        } else {
            float f37 = 1.0f - ((min2 - f36) / f36);
            f27 = (1.0f - (f26 * f37)) * 90.0f;
            f28 = f37 * f26 * 45.0f;
        }
        float f38 = (90.0f - f27) / 2.0f;
        double d16 = min2;
        float tan = (float) (Math.tan((f38 / 2.0f) * 0.017453292f) * d16);
        float sin = (float) (Math.sin((f27 / 2.0f) * 0.017453292f) * d16 * Math.sqrt(2.0d));
        double d17 = f28 * 0.017453292f;
        float cos = (float) (tan * Math.cos(d17));
        float tan2 = (float) (cos * Math.tan(d17));
        float f39 = (((min3 - sin) - cos) - tan2) / 3.0f;
        float f46 = 90.0f - (f38 * 2.0f);
        float width = rectF.width();
        float height = rectF.height();
        float f47 = width / 2.0f;
        float f48 = width - min3;
        path.moveTo(Math.max(f47, f48), 0.0f);
        float f49 = min3 - (f39 * 2.0f);
        float f56 = width - f49;
        float f57 = f49 - f39;
        float f58 = width - f57;
        float f59 = f57 - cos;
        path.cubicTo(f56, 0.0f, f58, 0.0f, width - f59, tan2);
        float f65 = min2 * 2.0f;
        float f66 = width - f65;
        path.arcTo(new RectF(f66, 0.0f, width, f65), 270.0f + f38, f46, false);
        float f67 = height / 2.0f;
        path.cubicTo(width, f57, width, f49, width, Math.min(f67, min3));
        float f68 = height - min3;
        path.lineTo(width, Math.max(f67, f68));
        float f69 = height - f49;
        float f75 = height - f57;
        path.cubicTo(width, f69, width, f75, width - tan2, height - f59);
        float f76 = height - f65;
        path.arcTo(new RectF(f66, f76, width, height), f38 + 0.0f, f46, false);
        path.cubicTo(f58, height, f56, height, Math.max(f47, f48), height);
        path.lineTo(Math.min(f47, min3), height);
        path.cubicTo(f49, height, f57, height, f59, height - tan2);
        path.arcTo(new RectF(0.0f, f76, f65, height), f38 + 90.0f, f46, false);
        path.cubicTo(0.0f, f75, 0.0f, f69, 0.0f, Math.max(f67, f68));
        path.lineTo(0.0f, Math.min(f67, min3));
        path.cubicTo(0.0f, f49, 0.0f, f57, tan2, f59);
        path.arcTo(new RectF(0.0f, 0.0f, f65, f65), f38 + 180.0f, f46, false);
        path.cubicTo(f57, 0.0f, f49, 0.0f, Math.min(f47, min3), 0.0f);
        path.lineTo(Math.max(f47, f48), 0.0f);
        path.close();
        return path;
    }

    public static Bitmap a(Bitmap bitmap, int i3) {
        int[] iArr;
        int i16 = i3;
        if (bitmap == null) {
            w.f("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i16 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i17 = width * height;
        int[] iArr2 = new int[i17];
        StringBuilder sb5 = new StringBuilder();
        sb5.append(width);
        String str = " ";
        sb5.append(" ");
        sb5.append(height);
        sb5.append(" ");
        sb5.append(i17);
        w.b("pix", sb5.toString());
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i18 = width - 1;
        int i19 = height - 1;
        int i26 = i16 + i16 + 1;
        int[] iArr3 = new int[i17];
        int[] iArr4 = new int[i17];
        int[] iArr5 = new int[i17];
        int[] iArr6 = new int[Math.max(width, height)];
        int i27 = (i26 + 1) >> 1;
        int i28 = i27 * i27;
        int i29 = i28 * 256;
        int[] iArr7 = new int[i29];
        for (int i36 = 0; i36 < i29; i36++) {
            iArr7[i36] = i36 / i28;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i26, 3);
        int i37 = i16 + 1;
        int i38 = 0;
        int i39 = 0;
        int i46 = 0;
        while (i38 < height) {
            String str2 = str;
            int i47 = -i16;
            int i48 = 0;
            int i49 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            while (i47 <= i16) {
                int i68 = height;
                int i69 = i19;
                int i75 = iArr2[i39 + Math.min(i18, Math.max(i47, 0))];
                int[] iArr9 = iArr8[i47 + i16];
                iArr9[0] = (i75 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr9[1] = (i75 & 65280) >> 8;
                iArr9[2] = i75 & 255;
                int abs = i37 - Math.abs(i47);
                int i76 = iArr9[0];
                i56 += i76 * abs;
                int i77 = iArr9[1];
                i49 += i77 * abs;
                int i78 = iArr9[2];
                i48 += abs * i78;
                if (i47 > 0) {
                    i65 += i76;
                    i66 += i77;
                    i67 += i78;
                } else {
                    i59 += i76;
                    i58 += i77;
                    i57 += i78;
                }
                i47++;
                height = i68;
                i19 = i69;
            }
            int i79 = height;
            int i85 = i19;
            int i86 = i16;
            int i87 = 0;
            while (i87 < width) {
                iArr3[i39] = iArr7[i56];
                iArr4[i39] = iArr7[i49];
                iArr5[i39] = iArr7[i48];
                int i88 = i56 - i59;
                int i89 = i49 - i58;
                int i95 = i48 - i57;
                int[] iArr10 = iArr8[((i86 - i16) + i26) % i26];
                int i96 = i59 - iArr10[0];
                int i97 = i58 - iArr10[1];
                int i98 = i57 - iArr10[2];
                if (i38 == 0) {
                    iArr = iArr7;
                    iArr6[i87] = Math.min(i87 + i16 + 1, i18);
                } else {
                    iArr = iArr7;
                }
                int i99 = iArr2[i46 + iArr6[i87]];
                int i100 = (i99 & ITVKAsset.VOD_ASSET_MASK_BIT) >> 16;
                iArr10[0] = i100;
                int i101 = (i99 & 65280) >> 8;
                iArr10[1] = i101;
                int i102 = i99 & 255;
                iArr10[2] = i102;
                int i103 = i65 + i100;
                int i104 = i66 + i101;
                int i105 = i67 + i102;
                i56 = i88 + i103;
                i49 = i89 + i104;
                i48 = i95 + i105;
                i86 = (i86 + 1) % i26;
                int[] iArr11 = iArr8[i86 % i26];
                int i106 = iArr11[0];
                i59 = i96 + i106;
                int i107 = iArr11[1];
                i58 = i97 + i107;
                int i108 = iArr11[2];
                i57 = i98 + i108;
                i65 = i103 - i106;
                i66 = i104 - i107;
                i67 = i105 - i108;
                i39++;
                i87++;
                iArr7 = iArr;
            }
            i46 += width;
            i38++;
            str = str2;
            height = i79;
            i19 = i85;
        }
        int[] iArr12 = iArr7;
        int i109 = height;
        int i110 = i19;
        String str3 = str;
        int i111 = 0;
        while (i111 < width) {
            int i112 = -i16;
            int i113 = i112 * width;
            int i114 = 0;
            int i115 = 0;
            int i116 = 0;
            int i117 = 0;
            int i118 = 0;
            int i119 = 0;
            int i120 = 0;
            int i121 = 0;
            int i122 = 0;
            while (i112 <= i16) {
                int[] iArr13 = iArr6;
                int max = Math.max(0, i113) + i111;
                int[] iArr14 = iArr8[i112 + i16];
                iArr14[0] = iArr3[max];
                iArr14[1] = iArr4[max];
                iArr14[2] = iArr5[max];
                int abs2 = i37 - Math.abs(i112);
                i116 += iArr3[max] * abs2;
                i115 += iArr4[max] * abs2;
                i114 += iArr5[max] * abs2;
                if (i112 > 0) {
                    i120 += iArr14[0];
                    i121 += iArr14[1];
                    i122 += iArr14[2];
                } else {
                    i119 += iArr14[0];
                    i118 += iArr14[1];
                    i117 += iArr14[2];
                }
                int i123 = i110;
                if (i112 < i123) {
                    i113 += width;
                }
                i112++;
                i110 = i123;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i124 = i110;
            int i125 = i111;
            int i126 = i16;
            int i127 = i109;
            int i128 = 0;
            while (i128 < i127) {
                iArr2[i125] = (iArr2[i125] & (-16777216)) | (iArr12[i116] << 16) | (iArr12[i115] << 8) | iArr12[i114];
                int i129 = i116 - i119;
                int i130 = i115 - i118;
                int i131 = i114 - i117;
                int[] iArr16 = iArr8[((i126 - i16) + i26) % i26];
                int i132 = i119 - iArr16[0];
                int i133 = i118 - iArr16[1];
                int i134 = i117 - iArr16[2];
                if (i111 == 0) {
                    iArr15[i128] = Math.min(i128 + i37, i124) * width;
                }
                int i135 = iArr15[i128] + i111;
                int i136 = iArr3[i135];
                iArr16[0] = i136;
                int i137 = iArr4[i135];
                iArr16[1] = i137;
                int i138 = iArr5[i135];
                iArr16[2] = i138;
                int i139 = i120 + i136;
                int i140 = i121 + i137;
                int i141 = i122 + i138;
                i116 = i129 + i139;
                i115 = i130 + i140;
                i114 = i131 + i141;
                i126 = (i126 + 1) % i26;
                int[] iArr17 = iArr8[i126];
                int i142 = iArr17[0];
                i119 = i132 + i142;
                int i143 = iArr17[1];
                i118 = i133 + i143;
                int i144 = iArr17[2];
                i117 = i134 + i144;
                i120 = i139 - i142;
                i121 = i140 - i143;
                i122 = i141 - i144;
                i125 += width;
                i128++;
                i16 = i3;
            }
            i111++;
            i16 = i3;
            i109 = i127;
            i110 = i124;
            iArr6 = iArr15;
        }
        int i145 = i109;
        w.b("pix", width + str3 + i145 + str3 + i17);
        copy.setPixels(iArr2, 0, width, 0, 0, width, i145);
        a(copy);
        return c.a(copy);
    }

    public static boolean a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i3, OutputStream outputStream) {
        if (bitmap == null) {
            w.b("MicroMsg.BitmapUtil", "bitmap error %s", bitmap);
            return false;
        }
        boolean compress = bitmap.compress(compressFormat, i3, outputStream);
        if (!compress) {
            w.b("MicroMsg.BitmapUtil", "compress error %s", w0.b().toString());
        }
        return compress;
    }

    public static void a(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.setDensity(z.c().getResources().getDisplayMetrics().densityDpi);
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setDefaultDensity", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, Integer.valueOf(z.c().getResources().getDisplayMetrics().densityDpi));
            } catch (Exception e16) {
                w.b("MicroMsg.BitmapUtil", "Exception:%s", e16);
            }
        }
    }

    public static Bitmap a(String str, int i3) {
        return a(str, i3, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(String str, int i3, int i16) {
        Bitmap bitmap;
        com.tencent.luggage.wxa.ba.b bVar = new com.tencent.luggage.wxa.ba.b();
        try {
            try {
                bVar.setDataSource(str);
                bitmap = bVar.getFrameAtTime(i16);
                try {
                    bVar.release();
                } catch (IOException | RuntimeException unused) {
                }
            } catch (IllegalArgumentException | RuntimeException unused2) {
                bVar.release();
                bitmap = null;
                if (bitmap == null) {
                }
            } catch (Throwable th5) {
                try {
                    bVar.release();
                } catch (IOException | RuntimeException unused3) {
                }
                throw th5;
            }
        } catch (IOException | RuntimeException unused4) {
            bitmap = null;
            if (bitmap == null) {
            }
        }
        if (bitmap == null) {
            return null;
        }
        if (i3 == 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float f16 = 512.0f / max;
                int round = Math.round(width * f16);
                int round2 = Math.round(f16 * height);
                if (round <= 0 || round2 <= 0) {
                    return null;
                }
                return Bitmap.createScaledBitmap(bitmap, round, round2, true);
            }
        } else if (i3 == 3) {
            return ThumbnailUtils.extractThumbnail(bitmap, 96, 96, 2);
        }
        return bitmap;
    }
}
