package com.tencent.rdelivery.util;

import android.util.Base64;
import android.util.Log;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(2, new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(new byte[16]));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e16) {
            Log.e("RDelivery_CryptoUtil", "aesDecrypt exception", e16);
            e16.printStackTrace();
            return bArr3;
        }
    }

    public static byte[] b(byte[] bArr, Key key) {
        byte[] bArr2 = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(1, key, new IvParameterSpec(new byte[16]));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e16) {
            Log.e("RDelivery_CryptoUtil", "aesEncrypt exception", e16);
            e16.printStackTrace();
            return bArr2;
        }
    }

    public static Key c() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
    }

    public static PublicKey d(String str) {
        if (str == null) {
            Log.w("RDelivery_CryptoUtil", "parsePublicKey Could not parse null public key");
            return null;
        }
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (NoSuchAlgorithmException e16) {
                Log.e("RDelivery_CryptoUtil", "parsePublicKey NoSuchAlgorithmException", e16);
                e16.printStackTrace();
                return null;
            } catch (InvalidKeySpecException e17) {
                Log.e("RDelivery_CryptoUtil", "parsePublicKey InvalidKeySpecException", e17);
                e17.printStackTrace();
                return null;
            }
        } catch (IllegalArgumentException e18) {
            Log.w("RDelivery_CryptoUtil", "parsePublicKey IllegalArgumentException", e18);
            return null;
        }
    }

    public static byte[] e(byte[] bArr, Key key) {
        byte[] bArr2 = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, key);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e16) {
            Log.e("RDelivery_CryptoUtil", "rsaEncrypt exception", e16);
            e16.printStackTrace();
            return bArr2;
        }
    }
}
