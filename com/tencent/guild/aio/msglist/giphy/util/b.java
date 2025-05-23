package com.tencent.guild.aio.msglist.giphy.util;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f111306a = a() + "/Tencent/MobileNT/";

    /* renamed from: b, reason: collision with root package name */
    private static String f111307b;

    public static final String a() {
        File externalCacheDir;
        if (f111307b == null && (externalCacheDir = BaseApplication.getContext().getExternalCacheDir()) != null) {
            f111307b = externalCacheDir.getParent();
        }
        return f111307b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        com.tencent.qphone.base.util.QLog.e("EmotionFileUtil", 2, "readFileContent", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        byte[] a16;
        String str = null;
        try {
            int length = (int) file.length();
            byteArrayOutputStream = new ByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    try {
                        a16 = a.b().a(12288);
                    } catch (OutOfMemoryError unused) {
                        a16 = a.b().a(4096);
                    }
                    int i3 = 0;
                    while (i3 < length) {
                        int read = bufferedInputStream.read(a16);
                        byteArrayOutputStream.write(a16, 0, read);
                        i3 += read;
                    }
                    a.b().c(a16);
                    str = byteArrayOutputStream.toString("utf-8");
                    try {
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                    } catch (IOException e16) {
                        e = e16;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("EmotionFileUtil", 2, "readFileContent", th);
                        }
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
                        return str;
                    } catch (Throwable th6) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e18) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("EmotionFileUtil", 2, "readFileContent", e18);
                                }
                                throw th6;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            bufferedInputStream = null;
        }
        return str;
    }

    public static void c(String str, String str2, String str3) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2 + str3);
                try {
                    fileOutputStream2.write(str.getBytes());
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        QLog.e("EmotionFileUtil", 2, e16, new Object[0]);
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    QLog.e("EmotionFileUtil", 2, e, new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e18) {
                            QLog.e("EmotionFileUtil", 2, e18, new Object[0]);
                        }
                    }
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    fileOutputStream = fileOutputStream2;
                    QLog.e("EmotionFileUtil", 2, e, new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e26) {
                            QLog.e("EmotionFileUtil", 2, e26, new Object[0]);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e27) {
                            QLog.e("EmotionFileUtil", 2, e27, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (IOException e28) {
                e = e28;
            } catch (OutOfMemoryError e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
