package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.StringCharacterIterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w {
    public static boolean a(String str, String str2) {
        return a(new File(str), new File(str2));
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean a(File file, File file2) {
        Throwable th5;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th6) {
                th5 = th6;
            }
        } catch (Throwable th7) {
            th5 = th7;
            fileInputStream = null;
        }
        try {
            boolean a16 = a(fileInputStream, fileOutputStream);
            a(fileInputStream);
            a(fileOutputStream);
            return a16;
        } catch (Throwable th8) {
            th5 = th8;
            fileOutputStream2 = fileOutputStream;
            try {
                x0.a("FileUtils", "copyFile error", th5);
                a(fileInputStream);
                a(fileOutputStream2);
                return false;
            } catch (Throwable th9) {
                a(fileInputStream);
                a(fileOutputStream2);
                throw th9;
            }
        }
    }

    public static boolean a(InputStream inputStream, OutputStream outputStream) {
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        a(inputStream);
                        a(outputStream);
                        return true;
                    }
                }
            } catch (IOException e16) {
                x0.a("FileUtils", "copyFile error", e16);
                a(inputStream);
                a(outputStream);
                return false;
            }
        } catch (Throwable th5) {
            a(inputStream);
            a(outputStream);
            throw th5;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream != null && file != null) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                a(inputStream, fileOutputStream);
                a(fileOutputStream);
                return true;
            } catch (Throwable th6) {
                th = th6;
                try {
                    x0.a("FileUtils", "copyStreamToFile, error", th);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        }
        x0.c("FileUtils", "copyStreamToFile, invalid params");
        return false;
    }

    public static boolean a(AssetFileDescriptor assetFileDescriptor, File file) {
        FileOutputStream fileOutputStream;
        if (assetFileDescriptor != null && file != null) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                a(assetFileDescriptor.createInputStream(), fileOutputStream);
                a(fileOutputStream);
                return true;
            } catch (Throwable th6) {
                th = th6;
                try {
                    x0.a("FileUtils", "copyFileDescriptorToFile, error", th);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        }
        x0.c("FileUtils", "copyFileDescriptorToFile, invalid params");
        return false;
    }

    public static boolean a(Context context, Uri uri, File file) {
        InputStream inputStream;
        Throwable th5;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        if (context != null && uri != null && file != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                inputStream2 = context.getContentResolver().openInputStream(uri);
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th7) {
                inputStream = inputStream2;
                th = th7;
                th5 = th;
                inputStream2 = inputStream;
                try {
                    x0.a("FileUtils", "copyUriToFile, error", th5);
                    return false;
                } finally {
                    a(inputStream2);
                    a(fileOutputStream2);
                }
            }
            try {
                a(inputStream2, fileOutputStream);
                a(inputStream2);
                a(fileOutputStream);
                return true;
            } catch (Throwable th8) {
                th5 = th8;
                fileOutputStream2 = fileOutputStream;
                x0.a("FileUtils", "copyUriToFile, error", th5);
                return false;
            }
        }
        x0.c("FileUtils", "copyUriToFile, invalid params");
        return false;
    }

    public static boolean a(String str, String str2, boolean z16) {
        File file = new File(str2);
        if (!file.isDirectory() || !file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return false;
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isFile()) {
                if (!a(listFiles[i3], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i3].getName()))) {
                    return false;
                }
            }
            if (listFiles[i3].isDirectory() && z16) {
                if (!a(str + "/" + listFiles[i3].getName(), str2 + "/" + listFiles[i3].getName(), z16)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(String str) {
        try {
            a(new File(str));
            return true;
        } catch (Throwable th5) {
            x0.d("FileUtils", String.format("deleteAll failed, path:%s, error:%s", str, th5));
            return false;
        }
    }

    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        if (file2.isFile()) {
                            file2.delete();
                        } else {
                            a(file2);
                        }
                    }
                }
            }
            file.delete();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th5) {
            x0.a("FileUtils", "closeable close failed, error", th5);
        }
    }

    public static long a(File file, boolean z16) {
        if (file.isFile()) {
            long length = file.length();
            if (z16 && length > 1048576) {
                x0.d("FileUtils", "getFileSize, size:" + a(length) + ", file:" + file.getName() + ", path:" + file.getAbsolutePath());
            }
            return length;
        }
        File[] listFiles = file.listFiles();
        long j3 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j3 += a(file2, z16);
            }
        }
        return j3;
    }

    public static String a(long j3) {
        long abs = j3 == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j3);
        if (abs < 1024) {
            return j3 + " B";
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        long j16 = abs;
        for (int i3 = 40; i3 >= 0 && abs > (1152865209611504844 >> i3); i3 -= 10) {
            j16 >>= 10;
            stringCharacterIterator.next();
        }
        return String.format("%.1f %ciB", Double.valueOf((j16 * Long.signum(j3)) / 1024.0d), Character.valueOf(stringCharacterIterator.current()));
    }
}
