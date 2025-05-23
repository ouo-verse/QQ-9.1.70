package com.tencent.qphone.base.util.log.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RSA {
    private static final String KEY_RSA = "RSA";

    private static byte[] decryptBase64(String str) {
        try {
            return Base64.decode(str);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String encryptBase64(byte[] bArr) {
        return Base64.encode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encryptByPublic(String str, String str2) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decryptBase64(str2));
            byte[] bytes = str.getBytes("UTF-8");
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(1, generatePublic);
            return encryptBase64(cipher.doFinal(bytes));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
