package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
@TargetApi(19)
/* loaded from: classes5.dex */
public class ArtDecoder implements IDecoder {
    public static final int DECODE_BUFFER_SIZE = 16384;
    private static final String TAG = "ArtDecoder";
    BitmapPool mBitmapPool;
    ByteArrayPool mByteArrayPool;

    public ArtDecoder(ByteArrayPool byteArrayPool, BitmapPool bitmapPool) {
        this.mByteArrayPool = byteArrayPool;
        this.mBitmapPool = bitmapPool;
    }

    private Bitmap decodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18) {
        if (i17 >= 0 && i18 >= 0) {
            Bitmap bitmap = this.mBitmapPool.get(i17 * i18 * BitmapUtils.getBytesPerPixel(options.inPreferredConfig));
            options.inBitmap = bitmap;
            options.inDither = true;
            options.inMutable = true;
            if (isPng(options.outMimeType)) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i3, i16, options);
                if (bitmap != decodeByteArray) {
                    ImageManagerLog.w(TAG, "decodeByteArray reuse bitmap false reuse: " + bitmap + ", decodeBitmap: " + decodeByteArray);
                    this.mBitmapPool.release(bitmap);
                    return decodeByteArray;
                }
                return decodeByteArray;
            } catch (RuntimeException e16) {
                ImageManagerLog.e(TAG, "decodeImage byte Array error " + i17 + ", " + i18);
                throw e16;
            }
        }
        Log.e(TAG, "decodeByteArray width " + i17 + ", height " + i18);
        options.inDither = true;
        options.inMutable = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(bArr, i3, i16, options);
        } catch (RuntimeException e17) {
            throw e17;
        }
    }

    private Bitmap decodeImageFromStream(InputStream inputStream, BitmapFactory.Options options) {
        StringBuilder sb5;
        Bitmap bitmap = options.inBitmap;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bArr = this.mByteArrayPool.get(16384);
        Bitmap bitmap2 = null;
        try {
            try {
                try {
                    try {
                        options.inTempStorage = bArr;
                        bitmap2 = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        this.mByteArrayPool.release(bArr);
                    } catch (OutOfMemoryError e16) {
                        ImageManagerLog.e(TAG, "decodeImageFromStream error ! " + Log.getStackTraceString(e16));
                        this.mByteArrayPool.release(bArr);
                        if (bitmap != null && bitmap != null) {
                            sb5 = new StringBuilder();
                        }
                    }
                } catch (Throwable th5) {
                    ImageManagerLog.e(TAG, "decodeImageFromStream error ! " + Log.getStackTraceString(th5));
                    this.mByteArrayPool.release(bArr);
                    if (bitmap != null && bitmap != null) {
                        sb5 = new StringBuilder();
                    }
                }
            } catch (RuntimeException e17) {
                ImageManagerLog.e(TAG, "decodeImageFromStream error ! " + Log.getStackTraceString(e17));
                this.mByteArrayPool.release(bArr);
                if (bitmap != null && bitmap != null) {
                    sb5 = new StringBuilder();
                }
            }
            if (bitmap != bitmap2 && bitmap != null) {
                sb5 = new StringBuilder();
                sb5.append("decodeImageStream reuse bitmap false reuse: ");
                sb5.append(bitmap);
                sb5.append(", decodeBitmap: ");
                sb5.append(bitmap2);
                ImageManagerLog.w(TAG, sb5.toString());
                this.mBitmapPool.release(bitmap);
            }
            return bitmap2;
        } catch (Throwable th6) {
            this.mByteArrayPool.release(bArr);
            if (bitmap != null && bitmap != null) {
                ImageManagerLog.w(TAG, "decodeImageStream reuse bitmap false reuse: " + bitmap + ", decodeBitmap: " + bitmap2);
                this.mBitmapPool.release(bitmap);
            }
            throw th6;
        }
    }

    private BitmapFactory.Options getDecodeOptions(BitmapFactory.Options options, boolean z16) {
        int i3;
        int i16;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inMutable = true;
        Bitmap bitmap = null;
        if (!z16) {
            options.inBitmap = null;
            return options;
        }
        int i17 = options.outHeight;
        if (i17 > 0 && (i3 = options.outWidth) > 0 && (i16 = options.inSampleSize) >= 1) {
            int i18 = ((i3 + i16) - 1) / i16;
            int i19 = ((i17 + i16) - 1) / i16;
            if (isPng(options.outMimeType)) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmap2 = this.mBitmapPool.get(i18 * i19 * BitmapUtils.getBytesPerPixel(options.inPreferredConfig));
            if (bitmap2 == null) {
                Log.e(TAG, "decodeImage Stream error no bitmap");
            } else if (!bitmap2.isMutable()) {
                Log.e(TAG, "decodeImage Stream error bitmap not mutable !");
                options.inBitmap = bitmap;
                return options;
            }
            bitmap = bitmap2;
            options.inBitmap = bitmap;
            return options;
        }
        throw new IllegalArgumentException("options \u53c2\u6570\u9519\u8bef");
    }

    private static boolean isPng(String str) {
        return "image/png".equalsIgnoreCase(str);
    }

    private void reset(FileInputStream fileInputStream) throws IOException {
        fileInputStream.getChannel().position(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.BufferedInputStream] */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeBitmap(File file, int i3, int i16, Bitmap bitmap) {
        ImageLoader.Options options;
        ?? r95;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Bitmap bitmap2 = null;
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        ?? r56 = 16384;
        options2.inTempStorage = this.mByteArrayPool.get(16384);
        try {
        } catch (IOException e16) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(e16));
        }
        try {
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
            } catch (FileNotFoundException e17) {
                e = e17;
                bufferedInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream2 = null;
            }
            try {
                BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                bufferedInputStream2.close();
            } catch (FileNotFoundException e18) {
                e = e18;
                ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                bufferedInputStream2.close();
                r56 = bufferedInputStream2;
                options2.inJustDecodeBounds = false;
                options = new ImageLoader.Options();
                options.clipHeight = i16;
                options.clipWidth = i3;
                if (i16 > 0) {
                    options2.inSampleSize = ImageOptionSampleSize.computeSampleSize(options, options2.outWidth, options2.outHeight);
                }
                r95 = options2.inSampleSize;
                if (r95 < 1) {
                }
                BitmapUtils.addInBitmapOptions(options2, bitmap);
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                    try {
                        bitmap2 = BitmapFactory.decodeStream(bufferedInputStream, null, options2);
                        bufferedInputStream.close();
                    } catch (FileNotFoundException e19) {
                        e = e19;
                        ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                        bufferedInputStream.close();
                        r95 = bufferedInputStream;
                        return bitmap2;
                    } catch (OutOfMemoryError e26) {
                        e = e26;
                        ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                        bufferedInputStream.close();
                        r95 = bufferedInputStream;
                        return bitmap2;
                    } catch (Throwable th6) {
                        th = th6;
                        ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                        bufferedInputStream.close();
                        r95 = bufferedInputStream;
                        return bitmap2;
                    }
                } catch (FileNotFoundException e27) {
                    e = e27;
                    bufferedInputStream = null;
                } catch (OutOfMemoryError e28) {
                    e = e28;
                    bufferedInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedInputStream = null;
                }
                return bitmap2;
            } catch (Throwable th8) {
                th = th8;
                ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                bufferedInputStream2.close();
                r56 = bufferedInputStream2;
                options2.inJustDecodeBounds = false;
                options = new ImageLoader.Options();
                options.clipHeight = i16;
                options.clipWidth = i3;
                if (i16 > 0) {
                }
                r95 = options2.inSampleSize;
                if (r95 < 1) {
                }
                BitmapUtils.addInBitmapOptions(options2, bitmap);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                bitmap2 = BitmapFactory.decodeStream(bufferedInputStream, null, options2);
                bufferedInputStream.close();
                return bitmap2;
            }
            options2.inJustDecodeBounds = false;
            options = new ImageLoader.Options();
            options.clipHeight = i16;
            options.clipWidth = i3;
            if (i16 > 0 && i3 > 0) {
                options2.inSampleSize = ImageOptionSampleSize.computeSampleSize(options, options2.outWidth, options2.outHeight);
            }
            r95 = options2.inSampleSize;
            if (r95 < 1) {
                options2.inSampleSize = 1;
            }
            BitmapUtils.addInBitmapOptions(options2, bitmap);
            try {
            } catch (IOException e29) {
                ImageManagerLog.e(TAG, Log.getStackTraceString(e29));
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                bitmap2 = BitmapFactory.decodeStream(bufferedInputStream, null, options2);
                bufferedInputStream.close();
                return bitmap2;
            } catch (Throwable th9) {
                try {
                    r95.close();
                } catch (IOException e36) {
                    ImageManagerLog.e(TAG, Log.getStackTraceString(e36));
                }
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                r56.close();
            } catch (IOException e37) {
                ImageManagerLog.e(TAG, Log.getStackTraceString(e37));
            }
            throw th10;
        }
    }

    @Override // com.tencent.component.media.image.IDecoder
    public Bitmap decodeFile(File file, BitmapFactory.Options options) {
        Bitmap bitmap;
        boolean z16;
        BitmapFactory.Options decodeOptions;
        Bitmap decodeImageFromStream;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    if (options != null) {
                        try {
                            if (options.outHeight > 0 && options.outWidth > 0) {
                                z16 = true;
                                if (options.inSampleSize < 1) {
                                }
                                decodeOptions = getDecodeOptions(options, z16);
                                decodeImageFromStream = decodeImageFromStream(fileInputStream2, decodeOptions);
                                if (z16 && decodeImageFromStream == null) {
                                    reset(fileInputStream2);
                                    decodeImageFromStream = decodeImageFromStream(fileInputStream2, getDecodeOptions(decodeOptions, false));
                                }
                                fileInputStream2.close();
                                return decodeImageFromStream;
                            }
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            bitmap = null;
                            fileInputStream = fileInputStream2;
                            ImageManagerLog.w(TAG, Log.getStackTraceString(e));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e17) {
                                    e = e17;
                                    e.printStackTrace();
                                    return bitmap;
                                }
                            }
                            return bitmap;
                        } catch (IOException e18) {
                            e = e18;
                            bitmap = null;
                            fileInputStream = fileInputStream2;
                            ImageManagerLog.w(TAG, Log.getStackTraceString(e));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e19) {
                                    e = e19;
                                    e.printStackTrace();
                                    return bitmap;
                                }
                            }
                            return bitmap;
                        } catch (Throwable th5) {
                            th = th5;
                            bitmap = null;
                            fileInputStream = fileInputStream2;
                            ImageManagerLog.w(TAG, Log.getStackTraceString(th));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e26) {
                                    e = e26;
                                    e.printStackTrace();
                                    return bitmap;
                                }
                            }
                            return bitmap;
                        }
                    }
                    fileInputStream2.close();
                    return decodeImageFromStream;
                } catch (IOException e27) {
                    e27.printStackTrace();
                    return decodeImageFromStream;
                }
                z16 = false;
                decodeOptions = getDecodeOptions(options, z16);
                decodeImageFromStream = decodeImageFromStream(fileInputStream2, decodeOptions);
                if (z16) {
                    reset(fileInputStream2);
                    decodeImageFromStream = decodeImageFromStream(fileInputStream2, getDecodeOptions(decodeOptions, false));
                }
            } catch (FileNotFoundException e28) {
                e = e28;
                bitmap = null;
            } catch (IOException e29) {
                e = e29;
                bitmap = null;
            } catch (Throwable th6) {
                th = th6;
                bitmap = null;
            }
        } catch (Throwable th7) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e36) {
                    e36.printStackTrace();
                }
            }
            throw th7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x002f: IF  (r2 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:23:0x0034, block:B:22:0x002f */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BitmapReference decodeImage(File file, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BitmapReference bitmapReference = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                bitmapReference = decodeImage(fileInputStream, options);
            } catch (FileNotFoundException e17) {
                e = e17;
                ImageManagerLog.w(TAG, Log.getStackTraceString(e));
            } catch (Throwable th6) {
                th = th6;
                ImageManagerLog.w(TAG, Log.getStackTraceString(th));
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmapReference;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused) {
                return bitmapReference;
            }
        } catch (Throwable th7) {
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th7;
        }
    }

    public int getHitCount() {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            return bitmapPool.getHitCount();
        }
        return 0;
    }

    public int getMissCount() {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            return bitmapPool.getMissCount();
        }
        return 0;
    }

    public long getTotalExpectSize() {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            return bitmapPool.getTotalExpectSize();
        }
        return 0L;
    }

    public long getTotalRealSize() {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            return bitmapPool.getTotalRealSize();
        }
        return 0L;
    }

    public void resizeCache(float f16) {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            bitmapPool.resizeCache(f16);
        }
    }

    public void trimToSize(float f16) {
        BitmapPool bitmapPool = this.mBitmapPool;
        if (bitmapPool != null) {
            bitmapPool.trimToSize(f16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[Catch: all -> 0x0033, IOException -> 0x003c, FileNotFoundException -> 0x0045, TRY_LEAVE, TryCatch #1 {all -> 0x0033, blocks: (B:22:0x000a, B:24:0x000e, B:26:0x0012, B:29:0x0018, B:9:0x0021, B:11:0x0027, B:8:0x001d), top: B:21:0x000a, outer: #0 }] */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BitmapReference decodeImage(FileInputStream fileInputStream, BitmapFactory.Options options) {
        BitmapFactory.Options decodeOptions;
        Bitmap bitmap = null;
        if (fileInputStream == null) {
            return null;
        }
        if (options != null) {
            try {
                try {
                    try {
                    } catch (IOException e16) {
                        ImageManagerLog.w(TAG, Log.getStackTraceString(e16));
                    }
                } catch (FileNotFoundException e17) {
                    ImageManagerLog.w(TAG, Log.getStackTraceString(e17));
                }
            } catch (Throwable th5) {
                ImageManagerLog.w(TAG, Log.getStackTraceString(th5));
            }
            if (options.outHeight > 0 && options.outWidth > 0 && options.inSampleSize >= 1) {
                decodeOptions = getDecodeOptions(options, true);
                bitmap = decodeImageFromStream(fileInputStream, decodeOptions);
                if (bitmap == null) {
                    reset(fileInputStream);
                    bitmap = decodeImageFromStream(fileInputStream, getDecodeOptions(decodeOptions, false));
                }
                return BitmapReference.getBitmapReference(bitmap);
            }
        }
        decodeOptions = getDecodeOptions(options, false);
        bitmap = decodeImageFromStream(fileInputStream, decodeOptions);
        if (bitmap == null) {
        }
        return BitmapReference.getBitmapReference(bitmap);
    }

    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18) {
        Bitmap bitmap;
        try {
            bitmap = decodeByteArray(bArr, i3, i16, options, i17, i18);
        } catch (Throwable th5) {
            th5.printStackTrace();
            ImageManagerLog.e(TAG, "decodeImage error " + th5.toString());
            bitmap = null;
        }
        return BitmapReference.getBitmapReference(bitmap);
    }
}
