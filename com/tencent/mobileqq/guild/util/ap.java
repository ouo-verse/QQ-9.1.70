package com.tencent.mobileqq.guild.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ap {
    private static void a(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e16) {
            QLog.e("GuildPicFileUtil", 1, "closeOutputStream:" + e16);
        }
    }

    private static boolean b() {
        File file = new File(AppConstants.SDCARD_IMG_SAVE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.canWrite();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r6.exists() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r6.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6.exists() == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(File file, Bitmap bitmap) {
        boolean z16 = false;
        if (!b()) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file), 8192);
                try {
                    z16 = bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bufferedOutputStream2);
                    a(bufferedOutputStream2);
                    if (!z16) {
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e("GuildPicFileUtil", 1, "saveAsCacheImage err" + e);
                    s.f("GuildPicFileUtil", "writeBitmapToFile ERR", e);
                    a(bufferedOutputStream);
                } catch (IllegalStateException e17) {
                    e = e17;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e("GuildPicFileUtil", 1, "saveAsCacheImage err" + e);
                    s.f("GuildPicFileUtil", "writeBitmapToFile ERR", e);
                    a(bufferedOutputStream);
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    bufferedOutputStream = bufferedOutputStream2;
                    QLog.e("GuildPicFileUtil", 1, "saveAsCacheImage err" + e);
                    s.f("GuildPicFileUtil", "writeBitmapToFile ERR", e);
                    a(bufferedOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    a(bufferedOutputStream);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap] */
    public static boolean d(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable e16;
        boolean z16;
        ?? file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file);
            } catch (IOException e17) {
                e = e17;
                bufferedOutputStream = null;
                fileOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (IllegalStateException e18) {
                e = e18;
                bufferedOutputStream = null;
                fileOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bufferedOutputStream = null;
                fileOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (Throwable th5) {
                th = th5;
                file = 0;
                fileOutputStream = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (IOException e26) {
                e = e26;
                bufferedOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (IllegalStateException e27) {
                e = e27;
                bufferedOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (OutOfMemoryError e28) {
                e = e28;
                bufferedOutputStream = null;
                e16 = e;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (Throwable th6) {
                th = th6;
                file = 0;
                th = th;
                a(file);
                a(fileOutputStream);
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bufferedOutputStream);
                bufferedOutputStream.flush();
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = true;
                file = bufferedOutputStream;
            } catch (IOException e29) {
                e16 = e29;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (IllegalStateException e36) {
                e16 = e36;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            } catch (OutOfMemoryError e37) {
                e16 = e37;
                QLog.e("GuildPicFileUtil", 2, "saveAsCacheImage err" + e16);
                s.f("GuildPicFileUtil", "writeBitmapToTmpFile ERR", e16);
                a(bufferedOutputStream);
                a(fileOutputStream);
                z16 = false;
                file = bufferedOutputStream;
                return z16;
            }
            return z16;
        } catch (Throwable th7) {
            th = th7;
            a(file);
            a(fileOutputStream);
            throw th;
        }
    }
}
