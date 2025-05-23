package com.qzone.module.feedcomponent.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BitmapUtil {
    private static final int BUFFER_SIZE_DECODE_BITMAP = 8192;
    private static final int BUFFER_SIZE_DECODE_BOUND = 2048;
    private static final String TAG = "BitmapUtils";

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r2 == null) goto L28;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:27:0x004b */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap decodeFileWithBuffer(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        Bitmap decodeStream;
        InputStream inputStream2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
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
                        com.qzone.proxy.feedcomponent.b.d("BitmapUtils", e.toString(), e);
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        com.qzone.proxy.feedcomponent.b.d("BitmapUtils", e.toString(), e);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return bitmap;
                    }
                    if (options.inJustDecodeBounds) {
                        decodeStream = BitmapFactory.decodeStream(new BufferedInputStream(fileInputStream, 2048), null, options);
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
}
