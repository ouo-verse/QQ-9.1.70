package com.tencent.mobileqq.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes20.dex */
public class y {
    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 != null && bArr != null && bArr2 != null) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e16) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e16);
            } catch (InvalidKeyException e17) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e17);
            } catch (NoSuchAlgorithmException e18) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e18);
            } catch (BadPaddingException e19) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e19);
            } catch (IllegalBlockSizeException e26) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e26);
            } catch (NoSuchPaddingException e27) {
                com.tencent.open.agent.util.t.d("EncryptUtils", "encryptAES", e27);
            }
        }
        return null;
    }
}
