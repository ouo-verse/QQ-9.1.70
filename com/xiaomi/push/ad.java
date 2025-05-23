package com.xiaomi.push;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ad {
    private static String a(byte b16) {
        int i3;
        String str;
        int i16 = b16 & Byte.MAX_VALUE;
        if (b16 < 0) {
            i3 = 128;
        } else {
            i3 = 0;
        }
        int i17 = i16 + i3;
        StringBuilder sb5 = new StringBuilder();
        if (i17 < 16) {
            str = "0";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(Integer.toHexString(i17).toLowerCase());
        return sb5.toString();
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b16 : messageDigest.digest()) {
                stringBuffer.append(a(b16));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String d(String str) {
        return b(str).subSequence(8, 24).toString();
    }
}
