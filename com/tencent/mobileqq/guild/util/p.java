package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes14.dex */
public class p {
    private static void a(BufferedOutputStream bufferedOutputStream) {
        if (bufferedOutputStream == null) {
            return;
        }
        try {
            bufferedOutputStream.close();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildFileUtil", 2, e16.getMessage());
            }
        }
    }

    public static String b(File file) {
        byte[] fileToBytes = FileUtils.fileToBytes(file);
        if (fileToBytes == null || fileToBytes.length <= 0) {
            return null;
        }
        try {
            return new String(fileToBytes, StandardCharsets.UTF_8);
        } catch (Error e16) {
            QLog.e("GuildFileUtil", 1, "loadFileContent error, " + e16.getMessage());
            return null;
        }
    }

    public static String c(String str) {
        if (FileUtils.fileExists(str)) {
            return b(new File(str));
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(File file, Bitmap bitmap) {
        boolean z16;
        ?? r06 = 0;
        r0 = null;
        r0 = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    z16 = bitmap.compress(compressFormat, 75, bufferedOutputStream2);
                    a(bufferedOutputStream2);
                    r06 = compressFormat;
                    if (!z16) {
                        boolean exists = file.exists();
                        r06 = exists;
                        if (exists) {
                            file.delete();
                            r06 = exists;
                        }
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.w("GuildFileUtil", 1, "writeBitmapToFile ", e);
                    a(bufferedOutputStream);
                    if (file.exists()) {
                        file.delete();
                    }
                    z16 = false;
                    r06 = bufferedOutputStream;
                    return z16;
                } catch (IllegalStateException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.w("GuildFileUtil", 1, "writeBitmapToFile ", e);
                    a(bufferedOutputStream);
                    if (file.exists()) {
                    }
                    z16 = false;
                    r06 = bufferedOutputStream;
                    return z16;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.w("GuildFileUtil", 1, "writeBitmapToFile ", e);
                    a(bufferedOutputStream);
                    if (file.exists()) {
                    }
                    z16 = false;
                    r06 = bufferedOutputStream;
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    r06 = bufferedOutputStream2;
                    a(r06);
                    if (file.exists()) {
                        file.delete();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
            } catch (IllegalStateException e26) {
                e = e26;
            } catch (OutOfMemoryError e27) {
                e = e27;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
