package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
class i {
    public static SecretKey a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bArr.length != 16 || bArr2.length != 16 || bArr3.length != 16) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        Log.d("AGC_SecretKey", "start generated key");
        SecretKey generateSecret = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(Hex.encodeHexString(a(bArr, bArr2, bArr3)).toCharArray(), bArr4, i3, 128));
        Log.d("AGC_SecretKey", "end generated key");
        return new SecretKeySpec(generateSecret.getEncoded(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    private static byte[] a(byte[] bArr, int i3) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i16 = 0; i16 < bArr.length; i16++) {
            if (i3 < 0) {
                bArr[i16] = (byte) (bArr[i16] << (-i3));
            } else {
                bArr[i16] = (byte) (bArr[i16] >> i3);
            }
        }
        return bArr;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(a(a(a(bArr, -4), bArr2), 6), bArr3);
    }
}
