package com.tencent.halley.downloader.a;

import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    public static long a() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1L;
        }
    }

    public static long b() {
        try {
            String absolutePath = com.tencent.halley.common.a.a().getFilesDir().getAbsolutePath();
            new StatFs(absolutePath).restat(absolutePath);
            return r1.getAvailableBlocks() * r1.getBlockSize();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1L;
        }
    }

    public static boolean c(Exception exc) {
        String message;
        if (exc != null && (message = exc.getMessage()) != null && message.contains("Permission denied")) {
            return true;
        }
        return false;
    }

    public static String a(String str) {
        int indexOf;
        try {
            if (TextUtils.isEmpty(str) || -1 == (indexOf = str.indexOf("filename="))) {
                return null;
            }
            int i3 = indexOf + 9;
            int indexOf2 = str.indexOf(";", i3);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            String substring = str.substring(i3, indexOf2);
            try {
                try {
                    substring = URLDecoder.decode(substring, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                    substring = URLDecoder.decode(substring, "gbk");
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int lastIndexOf = substring.lastIndexOf("/") + 1;
            return lastIndexOf > 0 ? substring.substring(lastIndexOf) : substring;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static String b(String str) {
        int lastIndexOf;
        try {
            String decode = Uri.decode(str);
            if (decode == null) {
                return null;
            }
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (decode.endsWith("/") || (lastIndexOf = decode.lastIndexOf(47) + 1) <= 0) {
                return null;
            }
            return decode.substring(lastIndexOf);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(Throwable th5) {
        return th5.getClass().getName() + ":" + th5.getMessage();
    }

    public static boolean b(Exception exc) {
        String message;
        return exc != null && (exc instanceof IOException) && (message = exc.getMessage()) != null && message.contains("Read-only file system");
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + "_" + System.currentTimeMillis());
        return file.renameTo(file2) ? file2.delete() : file.delete();
    }

    public static boolean a(Exception exc) {
        String message;
        if (exc == null || !(exc instanceof IOException) || (message = exc.getMessage()) == null) {
            return false;
        }
        return message.contains("ENOSPC") || message.contains("No space left on device");
    }
}
