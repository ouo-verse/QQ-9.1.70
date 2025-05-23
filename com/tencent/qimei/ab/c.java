package com.tencent.qimei.ab;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f342923a = "c";

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        String absolutePath = new File(str, str2).getAbsolutePath();
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e16) {
            com.tencent.qimei.ad.c.a(e16);
        }
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(absolutePath);
                try {
                    bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    fileInputStream2.close();
                } catch (FileNotFoundException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    com.tencent.qimei.ad.c.a(e);
                } catch (IOException e18) {
                    e = e18;
                    fileInputStream = fileInputStream2;
                    com.tencent.qimei.ad.c.a(e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return new String(bArr);
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            com.tencent.qimei.ad.c.a(e19);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
            } catch (IOException e27) {
                e = e27;
            }
            return new String(bArr);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void a(String str, String str2, String str3) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str, str3);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e16) {
                com.tencent.qimei.ad.c.a(e16);
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(str2.getBytes());
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e17) {
                        com.tencent.qimei.ad.c.a(e17);
                    }
                    com.tencent.qimei.ad.c.b(f342923a, "%s write success.", str3);
                } catch (FileNotFoundException e18) {
                    e = e18;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.qimei.ad.c.a(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e19) {
                            com.tencent.qimei.ad.c.a(e19);
                        }
                        com.tencent.qimei.ad.c.b(f342923a, "%s write success.", str3);
                    }
                } catch (IOException e26) {
                    e = e26;
                    fileOutputStream = fileOutputStream2;
                    com.tencent.qimei.ad.c.a(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e27) {
                            com.tencent.qimei.ad.c.a(e27);
                        }
                        com.tencent.qimei.ad.c.b(f342923a, "%s write success.", str3);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e28) {
                            com.tencent.qimei.ad.c.a(e28);
                        }
                        com.tencent.qimei.ad.c.b(f342923a, "%s write success.", str3);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e29) {
                e = e29;
            } catch (IOException e36) {
                e = e36;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean a(String str) {
        File file;
        File parentFile;
        if (TextUtils.isEmpty(str) || (parentFile = (file = new File(com.tencent.qimei.u.a.a(str))).getParentFile()) == null) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdir();
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
