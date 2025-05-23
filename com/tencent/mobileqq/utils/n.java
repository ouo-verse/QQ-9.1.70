package com.tencent.mobileqq.utils;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n {
    public static boolean a(Bitmap bitmap, String str) throws IOException, FileNotFoundException {
        BufferedOutputStream bufferedOutputStream;
        if (bitmap != null && str != null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str), 1048576);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, 70, bufferedOutputStream);
                try {
                    bufferedOutputStream.flush();
                } catch (IOException unused) {
                }
                bufferedOutputStream.close();
                return compress;
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.flush();
                    } catch (IOException unused2) {
                    }
                    bufferedOutputStream2.close();
                }
                throw th;
            }
        }
        return false;
    }
}
