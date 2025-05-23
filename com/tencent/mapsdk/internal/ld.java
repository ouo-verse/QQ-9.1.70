package com.tencent.mapsdk.internal;

import android.util.Base64;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ld {

    /* renamed from: a, reason: collision with root package name */
    private static final String f149177a = "AESCrypt";

    /* renamed from: b, reason: collision with root package name */
    private static final String f149178b = "AES/CBC/PKCS7Padding";

    /* renamed from: c, reason: collision with root package name */
    private static final String f149179c = "UTF-8";

    /* renamed from: d, reason: collision with root package name */
    private static final String f149180d = "SHA-256";

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f149181e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    ld() {
    }

    public static String a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    private static String b(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            byte[] decode = Base64.decode(str2, 2);
            byte[] bArr = f149181e;
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
            return new String(cipher.doFinal(decode), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new GeneralSecurityException(e16);
        }
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), KeyPropertiesCompact.KEY_ALGORITHM_AES);
            byte[] bArr = f149181e;
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
            return Base64.encodeToString(cipher.doFinal(bytes), 2);
        } catch (UnsupportedEncodingException e16) {
            throw new GeneralSecurityException(e16);
        }
    }

    private static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    private static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    private static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            cArr2[i17] = cArr[i16 >>> 4];
            cArr2[i17 + 1] = cArr[i16 & 15];
        }
        return new String(cArr2);
    }
}
