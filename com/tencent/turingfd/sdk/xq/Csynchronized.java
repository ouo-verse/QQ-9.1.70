package com.tencent.turingfd.sdk.xq;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.synchronized, reason: invalid class name */
/* loaded from: classes27.dex */
public class Csynchronized {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static byte[] b(String str) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        long length;
        int i3;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                length = randomAccessFile.length();
                i3 = (int) length;
            } catch (Throwable unused) {
                try {
                    bArr = new byte[0];
                    return bArr;
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        if (i3 == length) {
            bArr = new byte[i3];
            randomAccessFile.readFully(bArr);
            try {
                randomAccessFile.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            return bArr;
        }
        throw new IOException("");
    }

    public static byte[] a(String str, int i3) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i3];
                int i16 = 0;
                do {
                    int read = fileInputStream.read(bArr, i16, i3 - i16);
                    if (read == -1) {
                        break;
                    }
                    i16 += read;
                } while (i16 < i3);
                if (i16 == 0) {
                    Eridanus.a(fileInputStream);
                    return null;
                }
                if (i16 < i3) {
                    byte[] bArr2 = new byte[i16];
                    System.arraycopy(bArr, 0, bArr2, 0, i16);
                    bArr = bArr2;
                }
                Eridanus.a(fileInputStream);
                return bArr;
            } catch (Throwable unused) {
                Eridanus.a(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] a(String str) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th5;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th6) {
                th5 = th6;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th7) {
            fileInputStream = null;
            th5 = th7;
            byteArrayOutputStream = null;
        }
        try {
            Eridanus.a(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                byteArray = "".getBytes();
            }
            return byteArray;
        } catch (Throwable th8) {
            th5 = th8;
            try {
                throw th5;
            } finally {
                Eridanus.a(fileInputStream);
                Eridanus.a(byteArrayOutputStream);
            }
        }
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
                return false;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        try {
            return file.delete();
        } catch (Throwable unused2) {
            return false;
        }
    }
}
