package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class RSAEncrypt {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37826a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37827b = "RSAEncrypt";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37828c = "UTF-8";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37829d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37830e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final String f37831f = "RSA";

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        b.b(f37827b, "content or private key is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, EncryptUtil.getPublicKey(str2));
        }
        b.b(f37827b, "content or public key is null");
        return "";
    }

    public static Map<String, Key> generateRSAKeyPair(int i3) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i3 < 2048) {
            b.b(f37827b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(i3, genSecureRandom);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        if (rSAPrivateKey == null || rSAPrivateKey.getModulus().bitLength() < 2048) {
            return false;
        }
        return true;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        if (rSAPublicKey == null || rSAPublicKey.getModulus().bitLength() < 2048) {
            return false;
        }
        return true;
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (!TextUtils.isEmpty(str) && privateKey != null && isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                b.b(f37827b, "RSA decrypt exception : " + e16.getMessage());
                return "";
            } catch (Exception e17) {
                b.b(f37827b, "exception : " + e17.getMessage());
                return "";
            }
        }
        b.b(f37827b, "content or privateKey is null , or length is too short");
        return "";
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (!TextUtils.isEmpty(str) && publicKey != null && isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
            } catch (UnsupportedEncodingException unused) {
                b.b(f37827b, "encrypt: UnsupportedEncodingException");
                return "";
            } catch (Exception e16) {
                b.b(f37827b, "exception : " + e16.getMessage());
                return "";
            }
        }
        b.b(f37827b, "content or PublicKey is null , or length is too short");
        return "";
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null && isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                Cipher cipher = Cipher.getInstance(f37826a);
                cipher.init(2, privateKey);
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e16) {
                b.b(f37827b, "RSA decrypt exception : " + e16.getMessage());
                return bArr2;
            }
        }
        b.b(f37827b, "content or privateKey is null , or length is too short");
        return bArr2;
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && publicKey != null && isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                Cipher cipher = Cipher.getInstance(f37826a);
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e16) {
                b.b(f37827b, "RSA encrypt exception : " + e16.getMessage());
                return bArr2;
            }
        }
        b.b(f37827b, "content or PublicKey is null , or length is too short");
        return bArr2;
    }
}
