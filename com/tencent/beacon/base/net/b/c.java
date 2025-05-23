package com.tencent.beacon.base.net.b;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c {
    public static byte[] a(int i3, String str, byte[] bArr) throws Exception {
        if (i3 == 3) {
            return a(str, bArr);
        }
        return null;
    }

    public static byte[] b(int i3, String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (i3 == 3) {
            return b(str, bArr);
        }
        return null;
    }

    private static byte[] a(String str, byte[] bArr) throws Exception {
        if (str == null || bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(str);
        for (int length = sb5.length(); length < 16; length++) {
            sb5.append("0");
        }
        String substring = sb5.toString().substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(Charset.forName("UTF-8")), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(substring.getBytes(Charset.forName("UTF-8"))));
        return cipher.doFinal(bArr);
    }

    private static byte[] b(String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (str == null || bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(str);
        for (int length = sb5.length(); length < 16; length++) {
            sb5.append("0");
        }
        String substring = sb5.toString().substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(Charset.forName("UTF-8")), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(substring.getBytes(Charset.forName("UTF-8"))));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(Context context, String str) {
        KeyFactory keyFactory;
        if (str == null) {
            return null;
        }
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
            if (context.getApplicationInfo().targetSdkVersion >= 28) {
                keyFactory = KeyFactory.getInstance("RSA");
            } else {
                keyFactory = KeyFactory.getInstance("RSA", "BC");
            }
            RSAPublicKey rSAPublicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(str.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
