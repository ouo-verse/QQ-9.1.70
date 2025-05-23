package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o {
    public static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
    public static final int BUFFER_SIZE_DECODE_BOUND = 8192;
    private static final String TAG = "BasePhotoUtils";

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        if (r4 != null) goto L44;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0051: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:82), block:B:32:0x0051 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBuffer(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        Bitmap decodeStream;
        InputStream inputStream2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        Bitmap bitmap = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                if (options != null) {
                    try {
                    } catch (Exception e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "", e);
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return bitmap;
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "", e);
                        }
                    }
                    if (options.inJustDecodeBounds) {
                        decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
                        bitmap = decodeStream;
                        fileInputStream.close();
                    }
                }
                fileInputStream.close();
            } catch (IOException unused) {
                return bitmap;
            }
            decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 8192), null, options);
            bitmap = decodeStream;
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static String getImageMimeType(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFileWithBuffer(str, options);
        return options.outMimeType;
    }
}
