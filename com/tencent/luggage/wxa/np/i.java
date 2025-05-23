package com.tencent.luggage.wxa.np;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {
    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }

    public static String b(String str) {
        return str == null ? "" : str;
    }

    public static boolean a(int[] iArr) {
        return iArr == null || iArr.length <= 0;
    }

    public static boolean b(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static long a() {
        return System.nanoTime();
    }

    public static long a(long j3) {
        return ((System.nanoTime() - j3) / 1000) / 1000;
    }

    public static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
