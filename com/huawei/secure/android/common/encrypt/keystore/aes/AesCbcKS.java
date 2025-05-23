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
import javax.crypto.spec.IvParameterSpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AesCbcKS {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37800a = "CBCKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37801b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37802c = "AES/CBC/PKCS7Padding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37803d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37804e = 16;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37805f = 256;

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, SecretKey> f37806g = new HashMap();

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f37806g.get(str) == null) {
            a(str);
        }
        return f37806g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                b.b(f37800a, "encrypt: UnsupportedEncodingException");
                return "";
            }
        }
        b.b(f37800a, "alias or encrypt content is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            b.b(f37800a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.b(f37800a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    private static synchronized SecretKey a(String str) {
        SecretKey secretKey;
        synchronized (AesCbcKS.class) {
            b.c(f37800a, "load key");
            secretKey = null;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                                        keyStore.load(null);
                                        Key key = keyStore.getKey(str, null);
                                        if (key != null && (key instanceof SecretKey)) {
                                            secretKey = (SecretKey) key;
                                        } else {
                                            b.c(f37800a, "generate key");
                                            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES, "AndroidKeyStore");
                                            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(KeyPropertiesCompact.BLOCK_MODE_CBC).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_PKCS7).setKeySize(256).build());
                                            secretKey = keyGenerator.generateKey();
                                        }
                                    } catch (NoSuchAlgorithmException e16) {
                                        b.b(f37800a, "NoSuchAlgorithmException: " + e16.getMessage());
                                    } catch (NoSuchProviderException e17) {
                                        b.b(f37800a, "NoSuchProviderException: " + e17.getMessage());
                                    }
                                } catch (InvalidAlgorithmParameterException e18) {
                                    b.b(f37800a, "InvalidAlgorithmParameterException: " + e18.getMessage());
                                }
                            } catch (UnrecoverableKeyException e19) {
                                b.b(f37800a, "UnrecoverableKeyException: " + e19.getMessage());
                            }
                        } catch (KeyStoreException e26) {
                            b.b(f37800a, "KeyStoreException: " + e26.getMessage());
                        }
                    } catch (CertificateException e27) {
                        b.b(f37800a, "CertificateException: " + e27.getMessage());
                    }
                } catch (IOException e28) {
                    b.b(f37800a, "IOException: " + e28.getMessage());
                }
            } catch (Exception e29) {
                b.b(f37800a, "Exception: " + e29.getMessage());
            }
            f37806g.put(str, secretKey);
        }
        return secretKey;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37800a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                SecretKey b16 = b(str);
                if (b16 == null) {
                    b.b(f37800a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, b16);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv5 = cipher.getIV();
                if (iv5 != null && iv5.length == 16) {
                    byte[] copyOf = Arrays.copyOf(iv5, iv5.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv5.length, doFinal.length);
                    return copyOf;
                }
                b.b(f37800a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e16) {
                b.b(f37800a, "InvalidKeyException: " + e16.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e17) {
                b.b(f37800a, "NoSuchAlgorithmException: " + e17.getMessage());
                return bArr2;
            } catch (BadPaddingException e18) {
                b.b(f37800a, "BadPaddingException: " + e18.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e19) {
                b.b(f37800a, "IllegalBlockSizeException: " + e19.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e26) {
                b.b(f37800a, "NoSuchPaddingException: " + e26.getMessage());
                return bArr2;
            } catch (Exception e27) {
                b.b(f37800a, "Exception: " + e27.getMessage());
                return bArr2;
            }
        }
        b.b(f37800a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37800a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 16) {
                b.b(f37800a, "Decrypt source data is invalid.");
                return bArr2;
            }
            SecretKey b16 = b(str);
            if (b16 == null) {
                b.b(f37800a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(2, b16, new IvParameterSpec(copyOf));
                return cipher.doFinal(bArr, 16, bArr.length - 16);
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f37800a, "InvalidAlgorithmParameterException: " + e16.getMessage());
                return bArr2;
            } catch (InvalidKeyException e17) {
                b.b(f37800a, "InvalidKeyException: " + e17.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e18) {
                b.b(f37800a, "NoSuchAlgorithmException: " + e18.getMessage());
                return bArr2;
            } catch (BadPaddingException e19) {
                b.b(f37800a, "BadPaddingException: " + e19.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e26) {
                b.b(f37800a, "IllegalBlockSizeException: " + e26.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e27) {
                b.b(f37800a, "NoSuchPaddingException: " + e27.getMessage());
                return bArr2;
            } catch (Exception e28) {
                b.b(f37800a, "Exception: " + e28.getMessage());
                return bArr2;
            }
        }
        b.b(f37800a, "alias or encrypt content is null");
        return bArr2;
    }
}
