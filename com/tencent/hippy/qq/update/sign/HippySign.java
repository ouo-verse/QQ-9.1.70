package com.tencent.hippy.qq.update.sign;

import java.util.Random;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippySign {
    public static boolean empty(String str) {
        if (str != null && !str.trim().equals("") && !str.trim().equals("null")) {
            return false;
        }
        return true;
    }

    public static String getSign(String str, String str2) {
        if (empty(str2)) {
            return null;
        }
        String str3 = "a=" + str + "&t=" + (System.currentTimeMillis() / 1000) + "&r=" + Math.abs(new Random().nextInt());
        byte[] hashHmac = hashHmac(str3, str2);
        if (hashHmac == null) {
            return null;
        }
        byte[] bArr = new byte[hashHmac.length + str3.getBytes().length];
        System.arraycopy(hashHmac, 0, bArr, 0, hashHmac.length);
        System.arraycopy(str3.getBytes(), 0, bArr, hashHmac.length, str3.getBytes().length);
        return Base64Util.encode(bArr);
    }

    private static byte[] hashHmac(String str, String str2) {
        try {
            return HMACSHA1.getSignature(str, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
