package com.tencent.qqnt.util.file;

import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f362980a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f362980a = "unknown_";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x012d, code lost:
    
        if (r11 == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00db, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FileUtils", 1, "copyFile error, ", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d9, code lost:
    
        if (r11 == false) goto L122;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4 A[Catch: all -> 0x00e8, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00e8, blocks: (B:77:0x00b7, B:50:0x00e4), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b7 A[Catch: all -> 0x00e8, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00e8, blocks: (B:77:0x00b7, B:50:0x00e4), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, File file2, boolean z16) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        FileInputStream fileInputStream4;
        FileInputStream fileInputStream5;
        ?? r102;
        ?? r103;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
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
            } catch (IOException e16) {
                e = e16;
                fileInputStream2 = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                file2 = 0;
            }
            try {
                FileInputStream fileInputStream6 = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream6);
                } catch (IOException e18) {
                    e = e18;
                    fileInputStream5 = fileInputStream6;
                    r103 = 0;
                    fileOutputStream2 = fileOutputStream;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    fileInputStream4 = fileInputStream6;
                    r102 = 0;
                    fileOutputStream2 = fileOutputStream;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream3 = fileInputStream6;
                    file2 = 0;
                    fileOutputStream2 = fileOutputStream;
                }
                try {
                    byte[] buf = ByteArrayPool.getGenericInstance().getBuf(4096);
                    while (true) {
                        int read = bufferedInputStream.read(buf);
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
                            QLog.e("FileUtils", 1, "copyFile error, ", e26);
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e27) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e27);
                        }
                    }
                    try {
                        fileInputStream6.close();
                        return true;
                    } catch (IOException e28) {
                        if (!z16) {
                            return true;
                        }
                        QLog.e("FileUtils", 1, "copyFile error, ", e28);
                        return true;
                    }
                } catch (IOException e29) {
                    r103 = bufferedInputStream;
                    e = e29;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream5 = fileInputStream6;
                    if (z16) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    if (r103 != 0) {
                    }
                    if (fileInputStream5 != null) {
                    }
                    return false;
                } catch (OutOfMemoryError e36) {
                    r102 = bufferedInputStream;
                    e = e36;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream4 = fileInputStream6;
                    if (z16) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    if (r102 != 0) {
                    }
                    if (fileInputStream4 != null) {
                    }
                    return false;
                } catch (Throwable th7) {
                    file2 = bufferedInputStream;
                    th = th7;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream3 = fileInputStream6;
                    if (fileOutputStream2 != null) {
                    }
                    if (file2 != 0) {
                    }
                    if (fileInputStream3 == null) {
                    }
                }
            } catch (IOException e37) {
                e = e37;
                fileInputStream2 = null;
                fileOutputStream2 = fileOutputStream;
                fileInputStream5 = fileInputStream2;
                r103 = fileInputStream2;
                if (z16) {
                    QLog.e("FileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e38) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e38);
                        }
                    }
                }
                if (r103 != 0) {
                    try {
                        r103.close();
                    } catch (IOException e39) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e39);
                        }
                    }
                }
                if (fileInputStream5 != null) {
                    try {
                        fileInputStream5.close();
                    } catch (IOException e46) {
                        e = e46;
                    }
                }
                return false;
            } catch (OutOfMemoryError e47) {
                e = e47;
                fileInputStream = null;
                fileOutputStream2 = fileOutputStream;
                fileInputStream4 = fileInputStream;
                r102 = fileInputStream;
                if (z16) {
                    QLog.e("FileUtils", 1, "copyFile error, ", e);
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e48) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e48);
                        }
                    }
                }
                if (r102 != 0) {
                    try {
                        r102.close();
                    } catch (IOException e49) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e49);
                        }
                    }
                }
                if (fileInputStream4 != null) {
                    try {
                        fileInputStream4.close();
                    } catch (IOException e56) {
                        e = e56;
                    }
                }
                return false;
            } catch (Throwable th8) {
                th = th8;
                file2 = 0;
                fileOutputStream2 = fileOutputStream;
                fileInputStream3 = file2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e57) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e57);
                        }
                    }
                }
                if (file2 != 0) {
                    try {
                        file2.close();
                    } catch (IOException e58) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e58);
                        }
                    }
                }
                if (fileInputStream3 == null) {
                    try {
                        fileInputStream3.close();
                        throw th;
                    } catch (IOException e59) {
                        if (z16) {
                            QLog.e("FileUtils", 1, "copyFile error, ", e59);
                            throw th;
                        }
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public static boolean b(String str, String str2) {
        return c(str, str2, false);
    }

    public static boolean c(String str, String str2, boolean z16) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return a(file, d(str2), z16);
            } catch (Exception e16) {
                QLog.d("FileUtils", 1, "copyFile fail, from:" + str + ", to:" + str2 + ", exception:" + e16.getMessage());
            }
        } else if (z16) {
            QLog.d("FileUtils", 1, "copyFile failed, file not exists, from path:" + str);
        }
        return false;
    }

    public static File d(String str) throws Exception {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static String e(String str) {
        String str2 = "";
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[2];
                    if (fileInputStream2.read(bArr) != -1) {
                        str2 = f(bArr);
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        QLog.e("FileUtils", 1, e16, new Object[0]);
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    QLog.e("FileUtils", 1, e, new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            QLog.e("FileUtils", 1, e18, new Object[0]);
                        }
                    }
                    return str2;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            QLog.e("FileUtils", 1, e19, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
        return str2;
    }

    public static String f(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null && bArr.length >= 2) {
            for (byte b16 : bArr) {
                sb5.append(b16 & 255);
            }
            int parseInt = Integer.parseInt(sb5.toString());
            if (parseInt != 6677) {
                if (parseInt != 7173) {
                    if (parseInt != 7784) {
                        if (parseInt != 7790) {
                            if (parseInt != 8075) {
                                if (parseInt != 8273) {
                                    if (parseInt != 8297) {
                                        if (parseInt != 13780) {
                                            if (parseInt != 255216) {
                                                return f362980a + ((Object) sb5);
                                            }
                                            return "jpg";
                                        }
                                        return "png";
                                    }
                                    return "rar";
                                }
                                return "webp";
                            }
                            return "zip";
                        }
                        return "exe";
                    }
                    return "midi";
                }
                return "gif";
            }
            return "bmp";
        }
        return f362980a + ((Object) sb5);
    }

    public static String g() {
        String str = BaseApplication.context.getExternalFilesDir(null) + "/flash_transfer_cache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String h() {
        String str = BaseApplication.context.getExternalFilesDir(null) + "/flash_transfer";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }
}
