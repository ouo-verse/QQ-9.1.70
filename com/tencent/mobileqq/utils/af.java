package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes20.dex */
public class af {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (8 > bArr.length) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, 8);
        }
        return bArr2;
    }

    public static boolean b(String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    boolean z16 = true;
                    for (byte b16 : "ENCRYPT:".getBytes("UTF-8")) {
                        int read = fileInputStream2.read();
                        if (read == -1 || read != b16) {
                            z16 = false;
                        }
                    }
                    try {
                        fileInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return z16;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("DESUtil", 2, "CheckFileHadEncrypt Exception:" + e.getMessage());
                    }
                    if (fileInputStream == null) {
                        return false;
                    }
                    try {
                        fileInputStream.close();
                        return false;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d A[Catch: IOException -> 0x0099, TRY_LEAVE, TryCatch #1 {IOException -> 0x0099, blocks: (B:42:0x0095, B:35:0x009d), top: B:41:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(File file, File file2, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        CipherOutputStream cipherOutputStream;
        Cipher cipher;
        CipherOutputStream cipherOutputStream2 = null;
        cipherOutputStream2 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(a(bArr), TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
                cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
                cipher.init(2, secretKeySpec);
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Exception e16) {
                e = e16;
                cipherOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
            }
            try {
                randomAccessFile.seek("ENCRYPT:".getBytes("UTF-8").length);
                cipherOutputStream = new CipherOutputStream(new FileOutputStream(file2), cipher);
            } catch (Exception e17) {
                e = e17;
                cipherOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                if (cipherOutputStream2 != null) {
                }
                if (randomAccessFile != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = randomAccessFile.read(bArr2);
                    if (read != -1) {
                        cipherOutputStream.write(bArr2, 0, read);
                    } else {
                        cipherOutputStream.close();
                        randomAccessFile.close();
                        return;
                    }
                }
            } catch (Exception e18) {
                e = e18;
                randomAccessFile2 = randomAccessFile;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("DESUtil", 2, "DES Decrypt Exception:" + e.getMessage());
                    }
                    if (cipherOutputStream != null) {
                        cipherOutputStream.close();
                    }
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    randomAccessFile = randomAccessFile2;
                    cipherOutputStream2 = cipherOutputStream;
                    if (cipherOutputStream2 != null) {
                        try {
                            cipherOutputStream2.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            throw th;
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
                cipherOutputStream2 = cipherOutputStream;
                if (cipherOutputStream2 != null) {
                }
                if (randomAccessFile != null) {
                }
                throw th;
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
    }

    public static void d(String str, String str2, String str3) {
        if (!b(str)) {
            FileUtils.copyFile(str, str2);
            return;
        }
        try {
            c(new File(str), new File(str2), str3.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("DESUtil", 2, "DES Decrypt Exception:" + e16.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1 A[Catch: IOException -> 0x00ad, TryCatch #8 {IOException -> 0x00ad, blocks: (B:49:0x00a9, B:40:0x00b1, B:42:0x00b6), top: B:48:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6 A[Catch: IOException -> 0x00ad, TRY_LEAVE, TryCatch #8 {IOException -> 0x00ad, blocks: (B:49:0x00a9, B:40:0x00b1, B:42:0x00b6), top: B:48:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(File file, File file2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        CipherInputStream cipherInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        r1 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(a(bArr), TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
                Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
                cipher.init(1, secretKeySpec);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        cipherInputStream = new CipherInputStream(bufferedInputStream, cipher);
                    } catch (Exception e16) {
                        e = e16;
                        cipherInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        cipherInputStream = null;
                    }
                } catch (Exception e17) {
                    e = e17;
                    cipherInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                    cipherInputStream = null;
                }
            } catch (Exception e18) {
                e = e18;
                cipherInputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
                cipherInputStream = null;
                if (bufferedInputStream2 != null) {
                }
                if (cipherInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[4096];
                fileOutputStream.write("ENCRYPT:".getBytes("UTF-8"));
                while (true) {
                    int read = cipherInputStream.read(bArr2);
                    if (read != -1) {
                        fileOutputStream.write(bArr2, 0, read);
                    } else {
                        bufferedInputStream.close();
                        cipherInputStream.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } catch (Exception e19) {
                e = e19;
                fileOutputStream2 = fileOutputStream;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("DESUtil", 2, "DES Encrpt Exception:" + e.getMessage());
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th8) {
                    th = th8;
                    fileOutputStream = fileOutputStream2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            throw th;
                        }
                    }
                    if (cipherInputStream != null) {
                        cipherInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (cipherInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e27) {
            e27.printStackTrace();
        }
    }

    public static void f(String str, String str2, String str3) {
        try {
            if (b(str)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("DESUtil", 2, "encrypt had encrypt,file:" + str);
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            long length = file.length() / 1024;
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            e(file, file2, str3.getBytes("UTF-8"));
            file.delete();
            if (QLog.isDevelopLevel()) {
                QLog.d("DESUtil", 4, "DES Encrypt filePath:" + str + ",key:" + str3 + ",costTime:" + (System.currentTimeMillis() - currentTimeMillis) + ",fileSize:" + length + "KB");
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }
}
