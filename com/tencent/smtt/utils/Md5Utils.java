package com.tencent.smtt.utils;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Md5Utils {
    public static String getMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bytes);
            return ByteUtils.a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            } catch (FileNotFoundException unused) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                return null;
            } catch (IOException unused2) {
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            messageDigest = null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String a16 = ByteUtils.a(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            return a16;
        } catch (FileNotFoundException unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            return null;
        } catch (IOException unused4) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static byte[] getMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            if (messageDigest == null) {
                return null;
            }
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return messageDigest.digest();
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
