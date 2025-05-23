package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class RSAEncryptKS {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37814a = "RSAEncryptKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37815b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37816c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37817d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37818e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37819f = 3072;

    private static boolean a() {
        return true;
    }

    private static PublicKey b(String str, boolean z16) {
        if (!b(str)) {
            a(str, z16);
        }
        Certificate c16 = c(str);
        if (c16 != null) {
            return c16.getPublicKey();
        }
        return null;
    }

    private static Certificate c(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e16) {
            b.b(f37814a, "IOException: " + e16.getMessage());
            return null;
        } catch (KeyStoreException e17) {
            b.b(f37814a, "KeyStoreException: " + e17.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
            return null;
        } catch (CertificateException e19) {
            b.b(f37814a, "CertificateException: " + e19.getMessage());
            return null;
        } catch (Exception e26) {
            b.b(f37814a, "Exception: " + e26.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            b.b(f37814a, "UnsupportedEncodingException: " + e16.getMessage());
            return "";
        } catch (Exception e17) {
            b.b(f37814a, "Exception: " + e17.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            b.b(f37814a, "UnsupportedEncodingException: " + e16.getMessage());
            return "";
        } catch (Exception e17) {
            b.b(f37814a, "Exception: " + e17.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e16) {
            b.b(f37814a, "UnsupportedEncodingException: " + e16.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e16) {
            b.b(f37814a, "UnsupportedEncodingException: " + e16.getMessage());
            return "";
        }
    }

    private static byte[] a(String str, byte[] bArr, boolean z16) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37814a, "sdk version is too low");
                return bArr2;
            }
            PublicKey b16 = b(str, z16);
            if (b16 == null) {
                b.b(f37814a, "Public key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f37816c);
                cipher.init(1, b16, new OAEPParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", new MGF1ParameterSpec(KeyPropertiesCompact.DIGEST_SHA1), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f37814a, "InvalidAlgorithmParameterException: " + e16.getMessage());
                return bArr2;
            } catch (InvalidKeyException e17) {
                b.b(f37814a, "InvalidKeyException: " + e17.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e18) {
                b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
                return bArr2;
            } catch (BadPaddingException e19) {
                b.b(f37814a, "BadPaddingException: " + e19.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e26) {
                b.b(f37814a, "IllegalBlockSizeException: " + e26.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e27) {
                b.b(f37814a, "NoSuchPaddingException: " + e27.getMessage());
                return bArr2;
            } catch (Exception e28) {
                b.b(f37814a, "Exception: " + e28.getMessage());
                return bArr2;
            }
        }
        b.b(f37814a, "alias or content is null");
        return bArr2;
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f37814a, "sdk version is too low");
                return bArr2;
            }
            PrivateKey a16 = a(str);
            if (a16 == null) {
                b.b(f37814a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f37816c);
                cipher.init(2, a16, new OAEPParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", new MGF1ParameterSpec(KeyPropertiesCompact.DIGEST_SHA1), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f37814a, "InvalidAlgorithmParameterException: " + e16.getMessage());
                return bArr2;
            } catch (InvalidKeyException e17) {
                b.b(f37814a, "InvalidKeyException: " + e17.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e18) {
                b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
                return bArr2;
            } catch (BadPaddingException e19) {
                b.b(f37814a, "BadPaddingException: " + e19.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e26) {
                b.b(f37814a, "IllegalBlockSizeException: " + e26.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e27) {
                b.b(f37814a, "NoSuchPaddingException: " + e27.getMessage());
                return bArr2;
            } catch (Exception e28) {
                b.b(f37814a, "Exception: " + e28.getMessage());
                return bArr2;
            }
        }
        b.b(f37814a, "alias or encrypted content is null");
        return bArr2;
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    private static boolean b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e16) {
            b.b(f37814a, "IOException: " + e16.getMessage());
            return false;
        } catch (KeyStoreException e17) {
            b.b(f37814a, "KeyStoreException: " + e17.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
            return false;
        } catch (UnrecoverableKeyException e19) {
            b.b(f37814a, "UnrecoverableKeyException: " + e19.getMessage());
            return false;
        } catch (CertificateException e26) {
            b.b(f37814a, "CertificateException: " + e26.getMessage());
            return false;
        } catch (Exception e27) {
            b.b(f37814a, "Exception: " + e27.getMessage());
            return false;
        }
    }

    private static synchronized KeyPair a(String str, boolean z16) {
        synchronized (RSAEncryptKS.class) {
            KeyPair keyPair = null;
            if (b(str)) {
                b.b(f37814a, "Key pair exits");
                return null;
            }
            b.c(f37814a, "generate key pair.");
            try {
                try {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                        if (!z16) {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA512).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_RSA_OAEP).setKeySize(2048).build());
                        } else {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests(KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA512).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_RSA_OAEP).setKeySize(3072).build());
                        }
                        keyPair = keyPairGenerator.generateKeyPair();
                    } catch (InvalidAlgorithmParameterException e16) {
                        b.b(f37814a, "InvalidAlgorithmParameterException: " + e16.getMessage());
                    } catch (NoSuchProviderException e17) {
                        b.b(f37814a, "NoSuchProviderException: " + e17.getMessage());
                    }
                } catch (NoSuchAlgorithmException e18) {
                    b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
                }
            } catch (Exception e19) {
                b.b(f37814a, "Exception: " + e19.getMessage());
            }
            return keyPair;
        }
    }

    private static PrivateKey a(String str) {
        if (!b(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e16) {
            b.b(f37814a, "IOException: " + e16.getMessage());
            return null;
        } catch (KeyStoreException e17) {
            b.b(f37814a, "KeyStoreException: " + e17.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37814a, "NoSuchAlgorithmException: " + e18.getMessage());
            return null;
        } catch (UnrecoverableKeyException e19) {
            b.b(f37814a, "UnrecoverableKeyException: " + e19.getMessage());
            return null;
        } catch (CertificateException e26) {
            b.b(f37814a, "CertificateException: " + e26.getMessage());
            return null;
        } catch (Exception e27) {
            b.b(f37814a, "Exception: " + e27.getMessage());
            return null;
        }
    }
}
