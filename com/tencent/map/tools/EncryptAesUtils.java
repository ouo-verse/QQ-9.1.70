package com.tencent.map.tools;

import android.util.Base64;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EncryptAesUtils {
    private static final String CipherMode = "AES/CBC/PKCS5Padding";
    private static final String EMPTY_STRING = "";
    private static final byte[] EMPYT_BYTE_ARR = new byte[0];

    private static byte[] EnDeCrypt(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec, int i3) {
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0) {
            try {
                Cipher cipher = getCipher(str, algorithmParameterSpec, i3);
                if (cipher == null) {
                    return EMPYT_BYTE_ARR;
                }
                return cipher.doFinal(bArr);
            } catch (Throwable unused) {
                return EMPYT_BYTE_ARR;
            }
        }
        return EMPYT_BYTE_ARR;
    }

    private static String EnDeCryptBase64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec, int i3) {
        byte[] bArr;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (str != null && str.length() != 0) {
            try {
                if (i3 == 1) {
                    bArr = str.getBytes();
                } else if (i3 == 2) {
                    bArr = Base64.decode(str.getBytes(), 2);
                } else {
                    bArr = null;
                }
                if (bArr != null && bArr.length != 0) {
                    byte[] EnDeCrypt = EnDeCrypt(bArr, str2, algorithmParameterSpec, i3);
                    if (i3 == 1) {
                        return Base64.encodeToString(EnDeCrypt, 2);
                    }
                    if (i3 != 2) {
                        return null;
                    }
                    return new String(EnDeCrypt);
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static byte[] decryptAes256(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        return EnDeCrypt(bArr, str, algorithmParameterSpec, 2);
    }

    public static String decryptAes256Base64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec) {
        return EnDeCryptBase64(str, str2, algorithmParameterSpec, 2);
    }

    public static byte[] encryptAes256(byte[] bArr, String str, AlgorithmParameterSpec algorithmParameterSpec) {
        return EnDeCrypt(bArr, str, algorithmParameterSpec, 1);
    }

    public static String encryptAes256Base64(String str, String str2, AlgorithmParameterSpec algorithmParameterSpec) {
        return EnDeCryptBase64(str, str2, algorithmParameterSpec, 1);
    }

    private static Cipher getCipher(String str, AlgorithmParameterSpec algorithmParameterSpec, int i3) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance(CipherMode);
        cipher.init(i3, secretKeySpec, algorithmParameterSpec);
        return cipher;
    }
}
