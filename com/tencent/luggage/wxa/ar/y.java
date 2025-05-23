package com.tencent.luggage.wxa.ar;

import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y {
    public static final String a(InputStream inputStream, int i3) {
        int i16;
        if (inputStream != null && i3 > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                StringBuilder sb5 = new StringBuilder(32);
                byte[] bArr = new byte[i3];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                for (byte b16 : messageDigest.digest()) {
                    sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
                }
                return sb5.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return a(file, RFixConstants.MD5_FILE_BUF_LENGTH);
        }
        return null;
    }

    public static String a(File file) {
        return a(file, RFixConstants.MD5_FILE_BUF_LENGTH);
    }

    public static String a(File file, int i3) {
        FileInputStream fileInputStream;
        if (file != null && i3 > 0 && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                long j3 = i3;
                try {
                    if (j3 > file.length()) {
                        j3 = file.length();
                    }
                    String a16 = a(fileInputStream, (int) j3);
                    fileInputStream.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return a16;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        String a16 = a(str);
        return (a16 == null || str2 == null || !str2.equalsIgnoreCase(a16)) ? false : true;
    }
}
