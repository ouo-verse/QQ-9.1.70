package com.qq.wx.voice.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Hex {
    public static String encode(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb5 = new StringBuilder(bArr.length << 1);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(cArr[(bArr[i3] & 240) >> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static byte[] generateMD5(byte[] bArr) {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(bArr);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] generateSHA1(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
