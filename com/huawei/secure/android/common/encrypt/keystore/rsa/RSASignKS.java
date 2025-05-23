package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class RSASignKS {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37820a = "RSASignKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37821b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37822c = "SHA256withRSA/PSS";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37823d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37824e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37825f = 3072;

    private static byte[] a(String str, byte[] bArr, boolean z16) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!isBuildVersionHigherThan22()) {
                b.b(f37820a, "sdk version is too low");
                return bArr2;
            }
            KeyStore.Entry b16 = b(str, z16);
            if (!(b16 instanceof KeyStore.PrivateKeyEntry)) {
                b.b(f37820a, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature signature = Signature.getInstance(f37822c);
                signature.initSign(((KeyStore.PrivateKeyEntry) b16).getPrivateKey());
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidKeyException e16) {
                b.b(f37820a, "InvalidKeyException: " + e16.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e17) {
                b.b(f37820a, "NoSuchAlgorithmException: " + e17.getMessage());
                return bArr2;
            } catch (SignatureException e18) {
                b.b(f37820a, "SignatureException: " + e18.getMessage());
                return bArr2;
            } catch (Exception e19) {
                b.b(f37820a, "Exception: " + e19.getMessage());
                return bArr2;
            }
        }
        b.b(f37820a, "alias or content is null");
        return bArr2;
    }

    private static KeyStore.Entry b(String str, boolean z16) {
        if (!a(str)) {
            a(str, z16);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e16) {
            b.b(f37820a, "IOException: " + e16.getMessage());
            return null;
        } catch (KeyStoreException e17) {
            b.b(f37820a, "KeyStoreException: " + e17.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37820a, "NoSuchAlgorithmException: " + e18.getMessage());
            return null;
        } catch (UnrecoverableEntryException e19) {
            b.b(f37820a, "UnrecoverableEntryException: " + e19.getMessage());
            return null;
        } catch (CertificateException e26) {
            b.b(f37820a, "CertificateException: " + e26.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return true;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e16) {
            Log.e(f37820a, "sign UnsupportedEncodingException : " + e16.getMessage());
            return "";
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e16) {
            Log.e(f37820a, "sign UnsupportedEncodingException : " + e16.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e16) {
            Log.e(f37820a, "verifySign UnsupportedEncodingException: " + e16.getMessage());
            return false;
        } catch (Exception e17) {
            b.b(f37820a, "base64 decode Exception" + e17.getMessage());
            return false;
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e16) {
            Log.e(f37820a, "verifySign UnsupportedEncodingException: " + e16.getMessage());
            return false;
        } catch (Exception e17) {
            b.b(f37820a, "base64 decode Exception" + e17.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z16) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!isBuildVersionHigherThan22()) {
                b.b(f37820a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry b16 = b(str, z16);
            if (!(b16 instanceof KeyStore.PrivateKeyEntry)) {
                b.b(f37820a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(f37822c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) b16).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e16) {
                b.b(f37820a, "InvalidKeyException: " + e16.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e17) {
                b.b(f37820a, "NoSuchAlgorithmException: " + e17.getMessage());
                return false;
            } catch (SignatureException e18) {
                b.b(f37820a, "SignatureException: " + e18.getMessage());
                return false;
            } catch (Exception e19) {
                b.b(f37820a, "Exception: " + e19.getMessage());
                return false;
            }
        }
        b.b(f37820a, "alias or content or sign value is null");
        return false;
    }

    private static synchronized KeyPair a(String str, boolean z16) {
        synchronized (RSASignKS.class) {
            KeyPair keyPair = null;
            if (a(str)) {
                b.b(f37820a, "Key pair exits");
                return null;
            }
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    if (!z16) {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA512).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).setKeySize(2048).build());
                    } else {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA512).setSignaturePaddings(KeyPropertiesCompact.SIGNATURE_PADDING_RSA_PSS).setKeySize(3072).build());
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (InvalidAlgorithmParameterException e16) {
                    b.b(f37820a, "InvalidAlgorithmParameterException: " + e16.getMessage());
                } catch (NoSuchAlgorithmException e17) {
                    b.b(f37820a, "NoSuchAlgorithmException: " + e17.getMessage());
                }
            } catch (NoSuchProviderException e18) {
                b.b(f37820a, "NoSuchProviderException: " + e18.getMessage());
            }
            return keyPair;
        }
    }

    private static boolean a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e16) {
            b.b(f37820a, "IOException: " + e16.getMessage());
            return false;
        } catch (KeyStoreException e17) {
            b.b(f37820a, "KeyStoreException: " + e17.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e18) {
            b.b(f37820a, "NoSuchAlgorithmException: " + e18.getMessage());
            return false;
        } catch (UnrecoverableKeyException e19) {
            b.b(f37820a, "UnrecoverableKeyException: " + e19.getMessage());
            return false;
        } catch (CertificateException e26) {
            b.b(f37820a, "CertificateException: " + e26.getMessage());
            return false;
        }
    }
}
