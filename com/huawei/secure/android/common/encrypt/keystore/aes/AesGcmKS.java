package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AesGcmKS {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37807a = "GCMKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37808b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37809c = "AES/GCM/NoPadding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37810d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37811e = 12;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37812f = 256;

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f37813g = new HashMap();

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f37813g.get(str) == null) {
            a(str);
        }
        return f37813g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                b.b(f37807a, "decrypt: UnsupportedEncodingException : " + e16.getMessage());
                return "";
            }
        }
        b.b(f37807a, "alias or encrypt content is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e16) {
                b.b(f37807a, "encrypt: UnsupportedEncodingException : " + e16.getMessage());
                return "";
            }
        }
        b.b(f37807a, "alias or encrypt content is null");
        return "";
    }

    private static SecretKey a(String str) {
        b.c(f37807a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                b.c(f37807a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES, "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(KeyPropertiesCompact.BLOCK_MODE_GCM).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_NONE).setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (IOException e16) {
            b.b(f37807a, "IOException : " + e16.getMessage());
        } catch (InvalidAlgorithmParameterException e17) {
            b.b(f37807a, "InvalidAlgorithmParameterException : " + e17.getMessage());
        } catch (KeyStoreException e18) {
            b.b(f37807a, "KeyStoreException : " + e18.getMessage());
        } catch (NoSuchAlgorithmException e19) {
            b.b(f37807a, "NoSuchAlgorithmException : " + e19.getMessage());
        } catch (NoSuchProviderException e26) {
            b.b(f37807a, "NoSuchProviderException : " + e26.getMessage());
        } catch (UnrecoverableKeyException e27) {
            b.b(f37807a, "UnrecoverableKeyException : " + e27.getMessage());
        } catch (CertificateException e28) {
            b.b(f37807a, "CertificateException : " + e28.getMessage());
        } catch (Exception e29) {
            b.b(f37807a, "Exception: " + e29.getMessage());
        }
        f37813g.put(str, secretKey);
        return secretKey;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37807a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 12) {
                b.b(f37807a, "Decrypt source data is invalid.");
                return bArr2;
            }
            return decrypt(b(str), bArr);
        }
        b.b(f37807a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37807a, "sdk version is too low");
                return bArr2;
            }
            return encrypt(b(str), bArr);
        }
        b.b(f37807a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(f37807a, "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            b.b(f37807a, "secret key is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f37807a, "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f37809c);
            cipher.init(1, secretKey);
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] iv5 = cipher.getIV();
            if (iv5 != null && iv5.length == 12) {
                byte[] copyOf = Arrays.copyOf(iv5, iv5.length + doFinal.length);
                System.arraycopy(doFinal, 0, copyOf, iv5.length, doFinal.length);
                return copyOf;
            }
            b.b(f37807a, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e16) {
            b.b(f37807a, "InvalidKeyException : " + e16.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e17) {
            b.b(f37807a, "NoSuchAlgorithmException : " + e17.getMessage());
            return bArr2;
        } catch (BadPaddingException e18) {
            b.b(f37807a, "BadPaddingException : " + e18.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e19) {
            b.b(f37807a, "IllegalBlockSizeException : " + e19.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e26) {
            b.b(f37807a, "NoSuchPaddingException : " + e26.getMessage());
            return bArr2;
        } catch (Exception e27) {
            b.b(f37807a, "Exception: " + e27.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(f37807a, "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            b.b(f37807a, "content is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f37807a, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            b.b(f37807a, "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] copyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance(f37809c);
            cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e16) {
            b.b(f37807a, "InvalidAlgorithmParameterException : " + e16.getMessage());
            return bArr2;
        } catch (InvalidKeyException e17) {
            b.b(f37807a, "InvalidKeyException : " + e17.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37807a, "NoSuchAlgorithmException : " + e18.getMessage());
            return bArr2;
        } catch (BadPaddingException e19) {
            b.b(f37807a, "BadPaddingException : " + e19.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e26) {
            b.b(f37807a, "IllegalBlockSizeException : " + e26.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e27) {
            b.b(f37807a, "NoSuchPaddingException : " + e27.getMessage());
            return bArr2;
        } catch (Exception e28) {
            b.b(f37807a, "Exception: " + e28.getMessage());
            return bArr2;
        }
    }
}
