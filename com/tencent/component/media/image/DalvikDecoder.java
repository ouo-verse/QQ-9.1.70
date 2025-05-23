package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DalvikDecoder implements IDecoder {
    private static final String TAG = "DalvikDecoder";
    public static volatile boolean loadSoSucess = true;
    ByteArrayPool mByteArrayPool;

    static {
        try {
            System.loadLibrary("nativeBitmap");
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().w(TAG, "loadLibrary failed " + Log.getStackTraceString(th5));
            loadSoSucess = false;
        }
    }

    public DalvikDecoder(ByteArrayPool byteArrayPool) {
        this.mByteArrayPool = byteArrayPool;
    }

    private Bitmap decodeByteArray(byte[] bArr, int i3, int i16, BitmapFactory.Options options) {
        Bitmap decodeByteArray;
        Bitmap bitmap = null;
        try {
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, i3, i16, setBitmapOptions(options));
        } catch (Exception e16) {
            e = e16;
        } catch (OutOfMemoryError e17) {
            e = e17;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (decodeByteArray == null) {
                ImageManagerEnv.getLogger().w(TAG, "decodeArray error bitmap is null ");
                return null;
            }
            pinBitmap(decodeByteArray);
            return decodeByteArray;
        } catch (Exception e18) {
            e = e18;
            bitmap = decodeByteArray;
            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
            return bitmap;
        } catch (OutOfMemoryError e19) {
            e = e19;
            bitmap = decodeByteArray;
            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
            return bitmap;
        } catch (Throwable th6) {
            th = th6;
            bitmap = decodeByteArray;
            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(th));
            return bitmap;
        }
    }

    private static BitmapFactory.Options setBitmapOptions(BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inDither = true;
        options.inPurgeable = true;
        options.inMutable = true;
        return options;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4 A[Catch: OutOfMemoryError -> 0x00f9, IOException -> 0x00fb, FileNotFoundException -> 0x00fd, all -> 0x0189, LOOP:0: B:27:0x00cd->B:29:0x00d4, LOOP_END, TryCatch #5 {all -> 0x0189, blocks: (B:26:0x00ca, B:27:0x00cd, B:29:0x00d4, B:31:0x00d9, B:60:0x0104, B:51:0x0131, B:42:0x015e), top: B:22:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[EDGE_INSN: B:30:0x00d9->B:31:0x00d9 BREAK  A[LOOP:0: B:27:0x00cd->B:29:0x00d4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.tencent.component.media.image.ImageLoader$Options, com.tencent.component.media.image.ImageLoader$ImageOptions] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.tencent.component.media.ILog] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.tencent.component.media.ILog] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeBitmap(File file, int i3, int i16, Bitmap bitmap) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        ?? options;
        byte[] bArr;
        BufferedInputStream bufferedInputStream3;
        byte[] bArr2;
        int i17;
        int read;
        InputStream inputStream = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        Bitmap bitmap2 = null;
        if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
            return null;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8096);
            } catch (FileNotFoundException e16) {
                e = e16;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
            try {
                BitmapFactory.decodeStream(bufferedInputStream, null, options2);
                try {
                    bufferedInputStream.close();
                } catch (IOException e17) {
                    ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(e17));
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(e));
                try {
                    bufferedInputStream.close();
                    bufferedInputStream2 = bufferedInputStream;
                } catch (IOException e19) {
                    ?? logger = ImageManagerEnv.getLogger();
                    ?? stackTraceString = Log.getStackTraceString(e19);
                    logger.e(TAG, new Object[]{stackTraceString});
                    bufferedInputStream2 = stackTraceString;
                }
                options2.inJustDecodeBounds = false;
                options = new ImageLoader.Options();
                options.clipHeight = i16;
                options.clipWidth = i3;
                if (i16 > 0) {
                    options2.inSampleSize = ImageOptionSampleSize.computeSampleSize(options, options2.outWidth, options2.outHeight);
                }
                int length = (int) file.length();
                bArr = this.mByteArrayPool.get(length);
                try {
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file), 8192);
                } catch (FileNotFoundException e26) {
                    e = e26;
                    bufferedInputStream3 = null;
                } catch (IOException e27) {
                    e = e27;
                    bufferedInputStream3 = null;
                } catch (OutOfMemoryError e28) {
                    e = e28;
                    bufferedInputStream3 = null;
                } catch (Throwable th6) {
                    th = th6;
                    this.mByteArrayPool.release(bArr);
                    if (inputStream != null) {
                    }
                    throw th;
                }
                try {
                    bArr2 = new byte[4096];
                    i17 = 0;
                    while (true) {
                        read = bufferedInputStream3.read(bArr2);
                        if (read == -1) {
                        }
                        System.arraycopy(bArr2, 0, bArr, i17, read);
                        i17 += read;
                    }
                    bitmap2 = decodeByteArray(bArr, 0, length, options2);
                    this.mByteArrayPool.release(bArr);
                    try {
                        bufferedInputStream3.close();
                    } catch (Exception e29) {
                        ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e29));
                    }
                } catch (FileNotFoundException e36) {
                    e = e36;
                    ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                    this.mByteArrayPool.release(bArr);
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e37) {
                            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e37));
                        }
                    }
                    return bitmap2;
                } catch (IOException e38) {
                    e = e38;
                    ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                    this.mByteArrayPool.release(bArr);
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e39) {
                            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e39));
                        }
                    }
                    return bitmap2;
                } catch (OutOfMemoryError e46) {
                    e = e46;
                    ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(e));
                    this.mByteArrayPool.release(bArr);
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e47) {
                            ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e47));
                        }
                    }
                    return bitmap2;
                }
                return bitmap2;
            } catch (Throwable th7) {
                th = th7;
                ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(th));
                try {
                    bufferedInputStream.close();
                    bufferedInputStream2 = bufferedInputStream;
                } catch (IOException e48) {
                    ?? logger2 = ImageManagerEnv.getLogger();
                    ?? stackTraceString2 = Log.getStackTraceString(e48);
                    logger2.e(TAG, new Object[]{stackTraceString2});
                    bufferedInputStream2 = stackTraceString2;
                }
                options2.inJustDecodeBounds = false;
                options = new ImageLoader.Options();
                options.clipHeight = i16;
                options.clipWidth = i3;
                if (i16 > 0) {
                }
                int length2 = (int) file.length();
                bArr = this.mByteArrayPool.get(length2);
                bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file), 8192);
                bArr2 = new byte[4096];
                i17 = 0;
                while (true) {
                    read = bufferedInputStream3.read(bArr2);
                    if (read == -1) {
                    }
                    System.arraycopy(bArr2, 0, bArr, i17, read);
                    i17 += read;
                }
                bitmap2 = decodeByteArray(bArr, 0, length2, options2);
                this.mByteArrayPool.release(bArr);
                bufferedInputStream3.close();
                return bitmap2;
            }
            options2.inJustDecodeBounds = false;
            options = new ImageLoader.Options();
            options.clipHeight = i16;
            options.clipWidth = i3;
            if (i16 > 0 && i3 > 0) {
                options2.inSampleSize = ImageOptionSampleSize.computeSampleSize(options, options2.outWidth, options2.outHeight);
            }
            int length22 = (int) file.length();
            bArr = this.mByteArrayPool.get(length22);
            try {
                bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file), 8192);
                bArr2 = new byte[4096];
                i17 = 0;
                while (true) {
                    read = bufferedInputStream3.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    System.arraycopy(bArr2, 0, bArr, i17, read);
                    i17 += read;
                }
                bitmap2 = decodeByteArray(bArr, 0, length22, options2);
                this.mByteArrayPool.release(bArr);
                bufferedInputStream3.close();
                return bitmap2;
            } catch (Throwable th8) {
                th = th8;
                inputStream = options;
                this.mByteArrayPool.release(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e49) {
                        ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e49));
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            try {
                bufferedInputStream2.close();
            } catch (IOException e56) {
                ImageManagerEnv.getLogger().e(TAG, Log.getStackTraceString(e56));
            }
            throw th9;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0081: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:130), block:B:32:0x0081 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.component.media.image.IDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap decodeFile(File file, BitmapFactory.Options options) {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        int length = (int) file.length();
        byte[] bArr = this.mByteArrayPool.get(length);
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        InputStream inputStream2 = null;
        try {
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            } catch (FileNotFoundException e17) {
                e = e17;
                bufferedInputStream = null;
            } catch (IOException e18) {
                e = e18;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                this.mByteArrayPool.release(bArr);
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[4096];
                int i3 = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    System.arraycopy(bArr2, 0, bArr, i3, read);
                    i3 += read;
                }
                bitmap = decodeByteArray(bArr, 0, length, options);
                this.mByteArrayPool.release(bArr);
                bufferedInputStream.close();
            } catch (FileNotFoundException e19) {
                e = e19;
                ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                this.mByteArrayPool.release(bArr);
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bitmap;
            } catch (IOException e26) {
                e = e26;
                ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                this.mByteArrayPool.release(bArr);
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return bitmap;
            }
            return bitmap;
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            this.mByteArrayPool.release(bArr);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e27) {
                    e27.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0085: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:48:0x0085 */
    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(File file, BitmapFactory.Options options) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        int length = (int) file.length();
        byte[] bArr = this.mByteArrayPool.get(length);
        Bitmap bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        bitmap = null;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    this.mByteArrayPool.release(bArr);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr2 = new byte[4096];
                    int i3 = 0;
                    while (true) {
                        int read = bufferedInputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        System.arraycopy(bArr2, 0, bArr, i3, read);
                        i3 += read;
                    }
                    bitmap = decodeByteArray(bArr, 0, length, options);
                    this.mByteArrayPool.release(bArr);
                    bufferedInputStream.close();
                } catch (FileNotFoundException e19) {
                    e = e19;
                    ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                    this.mByteArrayPool.release(bArr);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return BitmapReference.getBitmapReference(bitmap);
                } catch (IOException e26) {
                    e = e26;
                    ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                    this.mByteArrayPool.release(bArr);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return BitmapReference.getBitmapReference(bitmap);
                }
            } catch (Exception e27) {
                e27.printStackTrace();
            }
            return BitmapReference.getBitmapReference(bitmap);
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
        }
    }

    public native int pinBitmap(Bitmap bitmap);

    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(FileInputStream fileInputStream, BitmapFactory.Options options) {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        Bitmap bitmap = null;
        if (fileInputStream == null) {
            return null;
        }
        try {
            try {
                try {
                    int available = fileInputStream.available();
                    bArr = this.mByteArrayPool.get(available);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedInputStream = null;
                    } catch (IOException e17) {
                        e = e17;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                    try {
                        byte[] bArr2 = new byte[4096];
                        int i3 = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            System.arraycopy(bArr2, 0, bArr, i3, read);
                            i3 += read;
                        }
                        bitmap = decodeByteArray(bArr, 0, available, options);
                        this.mByteArrayPool.release(bArr);
                        bufferedInputStream.close();
                    } catch (FileNotFoundException e18) {
                        e = e18;
                        ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                        this.mByteArrayPool.release(bArr);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return BitmapReference.getBitmapReference(bitmap);
                    } catch (IOException e19) {
                        e = e19;
                        ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(e));
                        this.mByteArrayPool.release(bArr);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return BitmapReference.getBitmapReference(bitmap);
                    } catch (Throwable th6) {
                        th = th6;
                        ImageManagerEnv.getLogger().w(TAG, Log.getStackTraceString(th));
                        this.mByteArrayPool.release(bArr);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return BitmapReference.getBitmapReference(bitmap);
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                    bArr = null;
                    bufferedInputStream = null;
                } catch (IOException e27) {
                    e = e27;
                    bArr = null;
                    bufferedInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    bArr = null;
                    bufferedInputStream = null;
                }
            } catch (Exception e28) {
                e28.printStackTrace();
            }
            return BitmapReference.getBitmapReference(bitmap);
        } catch (Throwable th8) {
            this.mByteArrayPool.release(bArr);
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e29) {
                    e29.printStackTrace();
                }
            }
            throw th8;
        }
    }

    @Override // com.tencent.component.media.image.IDecoder
    public BitmapReference decodeImage(byte[] bArr, int i3, int i16, BitmapFactory.Options options, int i17, int i18) {
        Bitmap bitmap;
        try {
            bitmap = decodeByteArray(bArr, i3, i16, options);
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().w(TAG, "decodeImage error " + Log.getStackTraceString(th5));
            bitmap = null;
        }
        return BitmapReference.getBitmapReference(bitmap);
    }
}
