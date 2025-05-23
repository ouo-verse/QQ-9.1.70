package com.tencent.mobileqq.winkpublish.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ImageUtil {
    public static final int BUFFER_SIZE_DECODE_BOUND = 8192;
    private static final String TAG = "ImageUtil";

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class Size {
        public int height;
        public int width;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077 A[Catch: all -> 0x006d, TryCatch #10 {all -> 0x006d, blocks: (B:47:0x000a, B:49:0x000e, B:14:0x0071, B:16:0x0077, B:28:0x007f, B:30:0x0085, B:4:0x002c, B:6:0x0037, B:10:0x003f, B:45:0x0056), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #10 {all -> 0x006d, blocks: (B:47:0x000a, B:49:0x000e, B:14:0x0071, B:16:0x0077, B:28:0x007f, B:30:0x0085, B:4:0x002c, B:6:0x0037, B:10:0x003f, B:45:0x0056), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBuffer(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        FileInputStream fileInputStream2 = null;
        try {
            if (options != null) {
                try {
                    if (options.inJustDecodeBounds) {
                        FileInputStream fileInputStream3 = new FileInputStream(str);
                        try {
                            fileInputStream2 = fileInputStream3;
                            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream3, 8192), null, options);
                            if (fileInputStream2 == null) {
                                try {
                                    fileInputStream2.close();
                                    return bitmap;
                                } catch (IOException unused) {
                                    return bitmap;
                                }
                            }
                            return bitmap;
                        } catch (Exception e16) {
                            e = e16;
                            fileInputStream = null;
                            fileInputStream2 = fileInputStream3;
                            if (QLog.isColorLevel()) {
                            }
                            if (fileInputStream2 != null) {
                            }
                            return fileInputStream;
                        } catch (OutOfMemoryError e17) {
                            e = e17;
                            fileInputStream = null;
                            fileInputStream2 = fileInputStream3;
                            if (QLog.isColorLevel()) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream3;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    fileInputStream = fileInputStream2;
                }
            }
            if (SharpPUtils.isSharpP(new File(str))) {
                Bitmap decodeSharpP = SharpPUtils.decodeSharpP(str);
                bitmap = decodeSharpP;
                bitmap = decodeSharpP;
                if (decodeSharpP != 0 && options != null) {
                    try {
                        options.outHeight = decodeSharpP.getHeight();
                        options.outWidth = decodeSharpP.getWidth();
                        bitmap = decodeSharpP;
                    } catch (Exception e26) {
                        fileInputStream = decodeSharpP;
                        e = e26;
                        if (QLog.isColorLevel()) {
                            QLog.e("ImageUtil", 2, "", e);
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return fileInputStream;
                    } catch (OutOfMemoryError e27) {
                        fileInputStream = decodeSharpP;
                        e = e27;
                        if (QLog.isColorLevel()) {
                            QLog.e("ImageUtil", 2, "", e);
                        }
                    }
                }
            } else {
                bitmap = ImageManager.getInstance().getDecoder().decodeFile(new File(str), options);
            }
            if (fileInputStream2 == null) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static Size getBitmapSize(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFileWithBuffer(str, options);
        options.inJustDecodeBounds = false;
        return new Size(options.outWidth, options.outHeight);
    }

    public static int readPictureDegree(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation != 3) {
            if (readOrientation != 6) {
                if (readOrientation != 8) {
                    return 0;
                }
                return 270;
            }
            return 90;
        }
        return 180;
    }
}
