package com.tencent.qqmini.sdk.core.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SecurityUtil {
    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getFileSHA1(String str) {
        try {
            return getHash(str, "SHA1");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String getHash(String str, String str2) throws Exception {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            bufferedInputStream.close();
            return toHexString(messageDigest.digest());
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(hexChar[(bArr[i3] & 240) >>> 4]);
            sb5.append(hexChar[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
