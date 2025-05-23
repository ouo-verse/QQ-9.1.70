package com.tencent.mobileqq.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cr {
    public static void a(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    g(file2);
                }
                return;
            }
            return;
        }
        g(file);
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        return true;
    }

    public static int c(String str, String str2, boolean z16) {
        return d(str, str2, z16, false, false);
    }

    public static int d(String str, String str2, boolean z16, boolean z17, boolean z18) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return -1;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isDirectory()) {
                d(listFiles[i3].getPath() + "/", str2 + listFiles[i3].getName() + "/", z16, z17, z18);
            } else {
                File file3 = new File(listFiles[i3].getPath());
                File file4 = new File(str2 + listFiles[i3].getName());
                if (file3.exists()) {
                    if (z17 && file4.exists() && !file4.delete() && z18) {
                        QLog.d("QManagerFileUtils", 1, "copyDirectory fail, delete file name:", file3.getPath());
                    }
                    if (!file4.exists()) {
                        try {
                            file4.createNewFile();
                            if (!e(file3, file4, z18) && z18) {
                                QLog.d("QManagerFileUtils", 1, "copyDirectory fail, file name:", file3.getPath());
                            }
                        } catch (IOException e16) {
                            if (z18) {
                                QLog.e("QManagerFileUtils", 1, "copyDirectory error, ", e16);
                            }
                        }
                    }
                    if (z16) {
                        file3.delete();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QManagerFileUtils", 1, "copyFile error, ", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x009d, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(File file, File file2, boolean z16) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream((File) file2);
                try {
                    file2 = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e16) {
                    e = e16;
                    file2 = 0;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    file2 = 0;
                } catch (Throwable th5) {
                    th = th5;
                    file2 = 0;
                }
            } catch (IOException e18) {
                e = e18;
                bufferedInputStream2 = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                file2 = 0;
            }
            try {
                byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                while (true) {
                    int read = file2.read(buf);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(buf, 0, read);
                    fileOutputStream.flush();
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                try {
                    fileOutputStream.close();
                } catch (IOException e26) {
                    if (z16) {
                        QLog.e("QManagerFileUtils", 1, "copyFile error, ", e26);
                    }
                }
                try {
                    file2.close();
                    return true;
                } catch (IOException e27) {
                    if (!z16) {
                        return true;
                    }
                    QLog.e("QManagerFileUtils", 1, "copyFile error, ", e27);
                    return true;
                }
            } catch (IOException e28) {
                e = e28;
                fileOutputStream2 = fileOutputStream;
                bufferedInputStream2 = file2;
                if (z16) {
                    QLog.e("QManagerFileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e29) {
                        if (z16) {
                            QLog.e("QManagerFileUtils", 1, "copyFile error, ", e29);
                        }
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e36) {
                        e = e36;
                    }
                }
                return false;
            } catch (OutOfMemoryError e37) {
                e = e37;
                fileOutputStream2 = fileOutputStream;
                bufferedInputStream = file2;
                if (z16) {
                    QLog.e("QManagerFileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e38) {
                        if (z16) {
                            QLog.e("QManagerFileUtils", 1, "copyFile error, ", e38);
                        }
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e39) {
                        e = e39;
                    }
                }
                return false;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e46) {
                        if (z16) {
                            QLog.e("QManagerFileUtils", 1, "copyFile error, ", e46);
                        }
                    }
                }
                if (file2 != 0) {
                    try {
                        file2.close();
                    } catch (IOException e47) {
                        if (z16) {
                            QLog.e("QManagerFileUtils", 1, "copyFile error, ", e47);
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static void f(String str, boolean z16) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            f(file2.getAbsolutePath(), z16);
        }
        if (!z16) {
            file.delete();
        }
    }

    private static boolean g(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!g(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void h(File file) {
        File[] listFiles;
        try {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    h(file2);
                }
            }
            file.delete();
        } catch (Exception unused) {
            QLog.e("QManagerFileUtils", 1, "deleteFile error");
        }
    }

    public static File i(String str, String str2) {
        if (b(str)) {
            return new File(str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QManagerFileUtils", 2, "mkdir dir failed, dir=" + str);
            return null;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #9 {IOException -> 0x00ae, blocks: (B:59:0x00aa, B:52:0x00b2), top: B:58:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.tencent.commonsdk.pool.ByteArrayPool] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.tencent.commonsdk.pool.ByteArrayPool] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] j(String str) {
        FileInputStream fileInputStream;
        ?? r56;
        ?? r65;
        int length;
        byte[] bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
        } catch (IOException e16) {
            QLog.e("QManagerFileUtils", 1, "readFileContent", e16);
        }
        try {
            try {
                length = (int) file.length();
                r56 = new ByteArrayOutputStream(length);
            } catch (Exception e17) {
                e = e17;
                r56 = 0;
                r65 = 0;
            } catch (OutOfMemoryError e18) {
                e = e18;
                r56 = 0;
                r65 = 0;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                if (byteArrayOutputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                r65 = new FileInputStream(file);
                ?? r75 = 4096;
                try {
                    try {
                        try {
                            if (length < 4096) {
                                r75 = ByteArrayPool.getGenericInstance().getBuf(4096);
                            } else {
                                r75 = ByteArrayPool.getGenericInstance().getBuf(12288);
                            }
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            QLog.e("QManagerFileUtils", 1, "readFileContent OutOfMemoryError", e);
                            if (r56 != 0) {
                                r56.close();
                            }
                            if (r65 != 0) {
                                r65.close();
                            }
                            return bArr;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        QLog.e("QManagerFileUtils", 1, "readFileContent", e);
                        if (r56 != 0) {
                            r56.close();
                        }
                        if (r65 != 0) {
                            r65.close();
                        }
                        return bArr;
                    }
                } catch (OutOfMemoryError unused) {
                    r75 = ByteArrayPool.getGenericInstance().getBuf(r75);
                }
                int i3 = 0;
                while (i3 < length) {
                    int read = r65.read(r75);
                    r56.write(r75, 0, read);
                    i3 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(r75);
                bArr = r56.toByteArray();
                r56.close();
                r65.close();
            } catch (Exception e27) {
                e = e27;
                r65 = 0;
            } catch (OutOfMemoryError e28) {
                e = e28;
                r65 = 0;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                byteArrayOutputStream = r56;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e29) {
                        QLog.e("QManagerFileUtils", 1, "readFileContent", e29);
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
            return bArr;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QManagerFileUtils", 2, "readFileContent", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(File file, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        byte[] buf;
        String str = null;
        try {
            int length = (int) file.length();
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable unused) {
                bufferedInputStream = null;
            }
            try {
                try {
                    buf = ByteArrayPool.getGenericInstance().getBuf(12288);
                } catch (OutOfMemoryError unused2) {
                    buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                }
                int i16 = 0;
                while (i16 < length) {
                    int read = bufferedInputStream.read(buf);
                    byteArrayOutputStream.write(buf, 0, read);
                    i16 += read;
                }
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                str = byteArrayOutputStream.toString("utf-8");
                try {
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                } catch (IOException e16) {
                    e = e16;
                }
            } catch (Throwable unused3) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e17) {
                        e = e17;
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (str != null) {
                    QLog.e("QConfigServlet.CORE", 1, "file size: ", Integer.valueOf(str.length()), ", type: ", Integer.valueOf(i3));
                }
                return str;
            }
        } catch (Throwable unused4) {
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        }
        if (str != null && str.length() > 10240 && Looper.myLooper() == Looper.getMainLooper()) {
            QLog.e("QConfigServlet.CORE", 1, "file size: ", Integer.valueOf(str.length()), ", type: ", Integer.valueOf(i3));
        }
        return str;
    }

    public static boolean l(String str, String str2) {
        return m(str, str2, true);
    }

    public static boolean m(String str, String str2, boolean z16) {
        boolean z17;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (IOException unused) {
                z17 = false;
            }
        }
        z17 = true;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (FileNotFoundException unused2) {
            fileOutputStream = null;
            z17 = false;
        }
        if (z16) {
            try {
                str2 = str2 + "\r\n";
            } catch (IOException unused3) {
                z17 = false;
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.write(str2.getBytes());
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused4) {
                z17 = false;
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                return false;
            }
        }
        return z17;
    }

    public static boolean n(byte[] bArr, String str) {
        return o(bArr, str, false);
    }

    public static boolean o(byte[] bArr, String str, boolean z16) {
        return p(bArr, str, z16, bArr.length);
    }

    public static boolean p(byte[] bArr, String str, boolean z16, int i3) {
        File file = new File(str);
        boolean z17 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z16);
                try {
                    fileOutputStream2.write(bArr, 0, i3);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    z17 = true;
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z17;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException unused4) {
        }
        return z17;
    }
}
