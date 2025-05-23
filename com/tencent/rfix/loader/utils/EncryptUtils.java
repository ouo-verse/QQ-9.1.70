package com.tencent.rfix.loader.utils;

import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes25.dex */
public class EncryptUtils {
    private static final String TAG = "RFix.EncryptUtils";

    public static String hmacSHA256Encrypt(String str, String str2) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            byte[] bytes2 = str2.getBytes(StandardCharsets.UTF_8);
            Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256);
            mac.init(new SecretKeySpec(bytes2, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256));
            byte[] doFinal = mac.doFinal(bytes);
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : doFinal) {
                sb5.append(Integer.toHexString((b16 & 255) | 256).substring(1, 3));
            }
            return sb5.toString().toLowerCase();
        } catch (Exception e16) {
            RFixLog.e(TAG, "encrypt exception!", e16);
            return null;
        }
    }
}
