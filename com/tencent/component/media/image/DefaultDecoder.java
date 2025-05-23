package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DefaultDecoder implements IDecoder {
    private static final String TAG = "DefaultDecoder";

    private Bitmap decodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18) {
        Log.e(TAG, "decodeByteArray width " + i17 + ", height " + i18);
        options.inDither = true;
        options.inMutable = true;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(bArr, i3, i16, options);
        } catch (OutOfMemoryError e16) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(e16));
            return null;
        } catch (RuntimeException e17) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(e17));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.BufferedInputStream] */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeBitmap(File file, int i3, int i16, Bitmap bitmap) {
        BufferedInputStream bufferedInputStream;
        ImageLoader.Options options;
        ?? r95;
        BufferedInputStream bufferedInputStream2;
        Bitmap bitmap2 = null;
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                }
                try {
                    BitmapFactory.decodeStream(bufferedInputStream, null, options2);
                    bufferedInputStream.close();
                } catch (FileNotFoundException e17) {
                    e = e17;
                    ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                    bufferedInputStream.close();
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
                    try {
                        try {
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            bufferedInputStream2 = null;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            bufferedInputStream2 = null;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedInputStream2 = null;
                        }
                        try {
                            BitmapUtils.addInBitmapOptions(options2, bitmap);
                            bitmap2 = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                            bufferedInputStream2.close();
                        } catch (FileNotFoundException e26) {
                            e = e26;
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            bufferedInputStream2.close();
                            r95 = bufferedInputStream2;
                            return bitmap2;
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            ImageManagerLog.e(TAG, Log.getStackTraceString(e));
                            bufferedInputStream2.close();
                            r95 = bufferedInputStream2;
                            return bitmap2;
                        } catch (Throwable th7) {
                            th = th7;
                            ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                            bufferedInputStream2.close();
                            r95 = bufferedInputStream2;
                            return bitmap2;
                        }
                    } catch (IOException e28) {
                        ImageManagerLog.e(TAG, Log.getStackTraceString(e28));
                    }
                    return bitmap2;
                } catch (Throwable th8) {
                    th = th8;
                    ImageManagerLog.e(TAG, Log.getStackTraceString(th));
                    bufferedInputStream.close();
                    options2.inJustDecodeBounds = false;
                    options = new ImageLoader.Options();
                    options.clipHeight = i16;
                    options.clipWidth = i3;
                    if (i16 > 0) {
                    }
                    r95 = options2.inSampleSize;
                    if (r95 < 1) {
                    }
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                    BitmapUtils.addInBitmapOptions(options2, bitmap);
                    bitmap2 = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                    bufferedInputStream2.close();
                    return bitmap2;
                }
            } catch (IOException e29) {
                ImageManagerLog.e(TAG, Log.getStackTraceString(e29));
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
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 8192);
                BitmapUtils.addInBitmapOptions(options2, bitmap);
                bitmap2 = BitmapFactory.decodeStream(bufferedInputStream2, null, options2);
                bufferedInputStream2.close();
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
                bufferedInputStream.close();
            } catch (IOException e37) {
                ImageManagerLog.e(TAG, Log.getStackTraceString(e37));
            }
            throw th10;
        }
    }

    @Override // com.tencent.component.media.image.IDecoder
    public Bitmap decodeFile(File file, BitmapFactory.Options options) {
        if (file == null) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e16) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(e16));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r3 == null) goto L21;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0050: IF  (r3 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:23:0x0055, block:B:22:0x0050 */
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
                ImageManagerLog.e(TAG, "decodeImage error " + Log.getStackTraceString(e));
            } catch (Throwable th6) {
                th = th6;
                ImageManagerLog.e(TAG, "decodeImage error " + Log.getStackTraceString(th));
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

    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(FileInputStream fileInputStream, BitmapFactory.Options options) {
        BitmapReference bitmapReference;
        if (fileInputStream == null) {
            return null;
        }
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
                if ("meizu".equalsIgnoreCase(Build.MANUFACTURER)) {
                    byte[] bArr = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    bitmapReference = BitmapReference.getBitmapReference(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options));
                } else {
                    bitmapReference = BitmapReference.getBitmapReference(BitmapFactory.decodeStream(bufferedInputStream, null, options));
                }
                return bitmapReference;
            } catch (OutOfMemoryError e16) {
                ImageManagerLog.e(TAG, "decodeImage error " + Log.getStackTraceString(e16));
                return null;
            }
        } catch (Exception e17) {
            ImageManagerLog.e(TAG, "decodeImage error " + Log.getStackTraceString(e17));
            return null;
        }
    }

    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18) {
        Bitmap bitmap;
        try {
            bitmap = decodeByteArray(bArr, i3, i16, options, i17, i18);
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, "decodeImage error " + Log.getStackTraceString(th5));
            bitmap = null;
        }
        return BitmapReference.getBitmapReference(bitmap);
    }
}
