package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.SafeBitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
    }

    public static boolean a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i3, String str) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        SystemClock.uptimeMillis();
        File file = new File(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (!file.exists() && !file.createNewFile()) {
                    hd0.c.g("BitmapUtils", "createNewFile() failed.");
                    return false;
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    if (bitmap.isRecycled()) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused) {
                        }
                        return false;
                    }
                    if (!bitmap.compress(compressFormat, i3, bufferedOutputStream2)) {
                        hd0.c.g("BitmapUtils", "bitmap compress failed.");
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused2) {
                        }
                        return false;
                    }
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (Exception unused3) {
                        return true;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    hd0.c.h("BitmapUtils", e.getMessage(), e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    return false;
                } catch (IOException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    hd0.c.h("BitmapUtils", e.getMessage(), e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    return false;
                } catch (IllegalStateException e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    hd0.c.h("BitmapUtils", e.getMessage(), e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
            } catch (IOException e26) {
                e = e26;
            } catch (IllegalStateException e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean b(Bitmap bitmap, String str) {
        return a(bitmap, Bitmap.CompressFormat.JPEG, 80, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0021 -> B:11:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap c(String str) {
        BufferedInputStream bufferedInputStream;
        ?? isEmpty = TextUtils.isEmpty(str);
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                } catch (IOException e16) {
                    hd0.c.h("BitmapUtils", "close exception", e16);
                    isEmpty = isEmpty;
                }
                if (isEmpty != 0) {
                    return null;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                } catch (FileNotFoundException e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                }
                try {
                    bitmap = BitmapFactory.decodeStream(bufferedInputStream);
                    bufferedInputStream.close();
                    isEmpty = bufferedInputStream;
                } catch (FileNotFoundException e19) {
                    e = e19;
                    hd0.c.h("BitmapUtils", "decodeFile FileNotFoundException", e);
                    isEmpty = bufferedInputStream;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                        isEmpty = bufferedInputStream;
                    }
                    return bitmap;
                } catch (OutOfMemoryError e26) {
                    e = e26;
                    hd0.c.h("BitmapUtils", "decodeFile failed", e);
                    throw e;
                }
                return bitmap;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedInputStream2 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = isEmpty;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e27) {
                    hd0.c.h("BitmapUtils", "close exception", e27);
                }
            }
            throw th;
        }
    }

    public static Bitmap d(Bitmap bitmap, Rect rect, boolean z16) {
        Bitmap f16;
        if (bitmap == null || (f16 = f(rect.width(), rect.height(), g(bitmap), false)) == null) {
            return null;
        }
        new Canvas(f16).drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, new Paint(6));
        if (z16) {
            m(bitmap);
        }
        return f16;
    }

    public static Bitmap e(Bitmap bitmap, int i3, int i16, boolean z16, boolean z17) {
        int round;
        int i17;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float width2 = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        float f16 = (i3 * 1.0f) / i16;
        if (f16 == width2) {
            hd0.c.a("BitmapUtils", "fillBackground. no need to resize");
            return bitmap;
        }
        if (width2 > f16) {
            i17 = Math.round(width / f16);
            round = width;
        } else {
            round = Math.round(height * f16);
            i17 = height;
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap f17 = f(round, i17, config, false);
        if (f17 == null) {
            return null;
        }
        Canvas canvas = new Canvas(f17);
        if (!z16) {
            canvas.drawColor(-16777216);
        }
        canvas.drawBitmap(bitmap, (round - width) / 2, (i17 - height) / 2, new Paint(6));
        canvas.setBitmap(null);
        if (z17) {
            m(bitmap);
        }
        return f17;
    }

    public static Bitmap f(int i3, int i16, Bitmap.Config config, boolean z16) {
        if (i3 <= 0 || i16 <= 0) {
            return null;
        }
        try {
            return Bitmap.createBitmap(i3, i16, config);
        } catch (OutOfMemoryError e16) {
            hd0.c.h("BitmapUtils", "OutOfMemoryError", e16);
            return null;
        }
    }

    private static Bitmap.Config g(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            return Bitmap.Config.ARGB_8888;
        }
        return config;
    }

    public static String h(String str) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                try {
                    SafeBitmapFactory.decodeStream(bufferedInputStream2, null, options);
                    String format = String.format("w=%d,h=%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    return format;
                } catch (Exception e17) {
                    e = e17;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return "";
                        } catch (Exception e18) {
                            e18.printStackTrace();
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static Bitmap i(Bitmap bitmap, Bitmap bitmap2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Paint paint = new Paint();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            Matrix matrix = new Matrix();
            matrix.postScale(width / bitmap2.getWidth(), height / bitmap2.getHeight());
            canvas.drawBitmap(Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true), 0.0f, 0.0f, (Paint) null);
            canvas.save();
            return createBitmap;
        } catch (Exception e16) {
            hd0.c.h("BitmapUtils", "mergeBitmap:" + e16.getMessage(), e16);
            return null;
        } catch (OutOfMemoryError e17) {
            hd0.c.h("BitmapUtils", e17.getMessage(), e17);
            return null;
        }
    }

    public static Bitmap j(Bitmap bitmap, Bitmap bitmap2) {
        return k(bitmap, bitmap2, false);
    }

    public static Bitmap k(Bitmap bitmap, Bitmap bitmap2, boolean z16) {
        if (bitmap != null && bitmap2 != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    return null;
                }
                if (z16) {
                    createBitmap.setDensity(bitmap.getDensity());
                }
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                float width2 = width / bitmap2.getWidth();
                float height2 = height / bitmap2.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(width2, height2);
                canvas.drawBitmap(bitmap2, matrix, null);
                canvas.save();
                return createBitmap;
            } catch (OutOfMemoryError e16) {
                hd0.c.h("BitmapUtils", e16.getMessage(), e16);
            }
        }
        return null;
    }

    public static Bitmap l(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap copy;
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float width2 = bitmap2.getWidth();
        float height2 = bitmap2.getHeight();
        float min = Math.min(width / width2, height / height2);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, (int) (width2 * min), (int) (min * height2), false);
        int width3 = createScaledBitmap.getWidth();
        int height3 = createScaledBitmap.getHeight();
        if (bitmap.isMutable()) {
            copy = bitmap;
        } else {
            copy = bitmap.copy(bitmap.getConfig(), true);
        }
        Canvas canvas = new Canvas(copy);
        canvas.drawBitmap(createScaledBitmap, (width - width3) / 2, (height - height3) / 2, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmap;
    }

    public static void m(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        bitmap.recycle();
    }

    public static Bitmap n(Bitmap bitmap, int i3, int i16, boolean z16) {
        return o(bitmap, i3, i16, z16, false);
    }

    public static Bitmap o(Bitmap bitmap, int i3, int i16, boolean z16, boolean z17) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i3 && height == i16) {
            return bitmap;
        }
        float max = Math.max(i3 / width, i16 / height);
        Bitmap f16 = f(i3, i16, g(bitmap), false);
        if (f16 == null) {
            return null;
        }
        if (z17) {
            f16.setDensity(bitmap.getDensity());
        }
        int round = Math.round(bitmap.getWidth() * max);
        int round2 = Math.round(bitmap.getHeight() * max);
        Canvas canvas = new Canvas(f16);
        canvas.translate((i3 - round) / 2.0f, (i16 - round2) / 2.0f);
        canvas.scale(max, max);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z16) {
            m(bitmap);
        }
        return f16;
    }

    public static Bitmap p(Bitmap bitmap, int i3, int i16, boolean z16, boolean z17) {
        Rect rect;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i3 && height == i16) {
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap f16 = f(i3, i16, config, false);
        if (f16 == null) {
            return null;
        }
        Canvas canvas = new Canvas(f16);
        if (!z16) {
            canvas.drawColor(-16777216);
        }
        float f17 = (width * 1.0f) / height;
        float f18 = i3;
        float f19 = i16;
        if (f17 > (1.0f * f18) / f19) {
            int round = Math.round(f18 / f17);
            rect = new Rect(0, (i16 - round) / 2, i3, Math.round((f19 / 2.0f) + (round / 2.0f)));
        } else {
            int round2 = Math.round(f19 * f17);
            rect = new Rect((i3 - round2) / 2, 0, Math.round((f18 / 2.0f) + (round2 / 2.0f)), i16);
        }
        hd0.c.p("BitmapUtils", "resizeAndFillBitmapEdge srcWidth=%s, srcHeight=%s, targetWidth=%s, targetHeight=%s, destRect=%s", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i3), Integer.valueOf(i16), rect);
        canvas.drawBitmap(bitmap, (Rect) null, rect, new Paint(6));
        canvas.setBitmap(null);
        if (z17) {
            m(bitmap);
        }
        return f16;
    }

    public static Bitmap q(Bitmap bitmap, float f16, boolean z16) {
        if (bitmap == null) {
            return null;
        }
        int round = Math.round(bitmap.getWidth() * f16);
        int round2 = Math.round(bitmap.getHeight() * f16);
        if (round == bitmap.getWidth() && round2 == bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap f17 = f(round, round2, g(bitmap), false);
        if (f17 == null) {
            return null;
        }
        Canvas canvas = new Canvas(f17);
        canvas.scale(f16, f16);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, new Paint(6));
        if (z16) {
            m(bitmap);
        }
        return f17;
    }

    @TargetApi(12)
    public static void r(Bitmap bitmap, String str, a aVar) throws IOException {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (str != null) {
                DataOutputStream dataOutputStream = null;
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(new File(str)));
                    try {
                        dataOutputStream2.writeInt(187);
                        dataOutputStream2.writeInt(1);
                        dataOutputStream2.writeBoolean(bitmap.isMutable());
                        dataOutputStream2.writeInt(bitmap.getConfig().ordinal());
                        dataOutputStream2.writeInt(bitmap.getWidth());
                        dataOutputStream2.writeInt(bitmap.getHeight());
                        dataOutputStream2.writeInt(bitmap.getRowBytes());
                        dataOutputStream2.writeInt(bitmap.getDensity());
                        byte[] bArr = new byte[bitmap.getByteCount()];
                        bitmap.copyPixelsToBuffer(ByteBuffer.wrap(bArr));
                        dataOutputStream2.writeInt(bArr.length);
                        dataOutputStream2.write(bArr, 0, bArr.length);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                throw new IllegalArgumentException("outFilePath should not be null");
            }
        } else {
            throw new IllegalArgumentException("bitmap is illegal");
        }
    }

    @TargetApi(12)
    public static void s(Bitmap bitmap, String str, a aVar) throws IOException {
        try {
            r(bitmap, str, aVar);
        } catch (OutOfMemoryError e16) {
            hd0.c.h("BitmapUtils", "serializeBitmapToFile failed", e16);
            ImageCacheHelper.f98636a.e();
            r(bitmap, str, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap t(String str, a aVar) throws IOException {
        Throwable th5;
        OutOfMemoryError e16;
        DataInputStream dataInputStream;
        if (str != 0) {
            try {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File((String) str)));
                } catch (OutOfMemoryError e17) {
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    str = 0;
                    if (str != 0) {
                    }
                    throw th5;
                }
                try {
                    int readInt = dataInputStream.readInt();
                    dataInputStream.readInt();
                    if (readInt == 187) {
                        dataInputStream.readBoolean();
                        Bitmap.Config config = Bitmap.Config.values()[dataInputStream.readInt()];
                        int readInt2 = dataInputStream.readInt();
                        int readInt3 = dataInputStream.readInt();
                        dataInputStream.readInt();
                        dataInputStream.readInt();
                        byte[] bArr = new byte[dataInputStream.readInt()];
                        dataInputStream.read(bArr);
                        Bitmap createBitmap = Bitmap.createBitmap(readInt2, readInt3, config);
                        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
                        dataInputStream.close();
                        return createBitmap;
                    }
                    throw new IOException("illegal file with magic code = " + readInt);
                } catch (OutOfMemoryError e18) {
                    e16 = e18;
                    throw new IOException("create bitmap object failed", e16);
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (str != 0) {
                    str.close();
                }
                throw th5;
            }
        }
        throw new IllegalArgumentException("inFilePath should not be null");
    }
}
