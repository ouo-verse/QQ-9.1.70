package com.tencent.hippy.qq.update.sign;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HMACSHA1 {
    private static final String HMAC_SHA1 = "HmacSHA1";

    public static byte[] getSignature(String str, String str2) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(str2.getBytes(), mac.getAlgorithm()));
        return mac.doFinal(str.getBytes());
    }
}
