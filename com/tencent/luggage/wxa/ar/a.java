package com.tencent.luggage.wxa.ar;

import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static String a(String str) {
        return a(str, "6a9d40ace2f56f1e0ad3c44224068588");
    }

    public static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(b(str2), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            byte[] decode = Base64.decode(str, 0);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode), StandardCharsets.UTF_8);
        } catch (Exception e16) {
            x0.a("AESUtil", "decrypt error:", e16);
            return null;
        }
    }
}
