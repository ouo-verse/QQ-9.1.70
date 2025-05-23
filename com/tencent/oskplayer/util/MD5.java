package com.tencent.oskplayer.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MD5 {
    private static char[] hextable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String byteArrayToHex(byte[] bArr) {
        String str = "";
        for (byte b16 : bArr) {
            int i3 = (b16 + 256) & 255;
            str = str + hextable[(i3 >> 4) & 15] + hextable[i3 & 15];
        }
        return str;
    }

    private static String digest(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes(), 0, str.length());
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            PlayerUtils.log(5, KeyPropertiesCompact.DIGEST_MD5, PlayerUtils.getPrintableStackTrace(e16));
            return str;
        }
    }

    public static String md5(String str) {
        return digest(str, KeyPropertiesCompact.DIGEST_MD5);
    }
}
