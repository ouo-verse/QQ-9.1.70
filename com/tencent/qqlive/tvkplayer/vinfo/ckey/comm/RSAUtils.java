package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class RSAUtils {
    private static String RSA = "RSA";

    public static byte[] decryptData(byte[] bArr, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(2, privateKey);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] decryptData_pub(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            cipher.init(2, publicKey);
            return cipher.doFinal(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] encryptData(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptData_pri(byte[] bArr, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            cipher.init(1, privateKey);
            return cipher.doFinal(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static KeyPair generateRSAKeyPair() {
        return generateRSAKeyPair(1024);
    }

    public static String getNewVid(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update((str + "magicCC").getBytes());
            String lowerCase = new BigInteger(1, messageDigest.digest()).toString(16).toLowerCase();
            while (lowerCase.length() < 32) {
                lowerCase = "0" + lowerCase;
            }
            return lowerCase.substring(0, 12);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static PrivateKey getPrivateKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static PublicKey getPublicKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static PrivateKey loadPrivateKey(String str) throws Exception {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64Utils.decode(str)));
        } catch (NullPointerException unused) {
            throw new Exception("\u79c1\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("\u79c1\u94a5\u975e\u6cd5");
        }
    }

    public static PublicKey loadPublicKey(String str) throws Exception {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(Base64Utils.decode(str)));
        } catch (NullPointerException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        }
    }

    public static void printPrivateKeyInfo(PrivateKey privateKey) {
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        System.out.println("----------RSAPrivateKey ----------");
        System.out.println("Modulus.length=" + rSAPrivateKey.getModulus().bitLength());
        System.out.println("Modulus=" + rSAPrivateKey.getModulus().toString());
        System.out.println("PrivateExponent.length=" + rSAPrivateKey.getPrivateExponent().bitLength());
        System.out.println("PrivatecExponent=" + rSAPrivateKey.getPrivateExponent().toString());
    }

    public static void printPublicKeyInfo(PublicKey publicKey) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        System.out.println("----------RSAPublicKey----------");
        System.out.println("Modulus.length=" + rSAPublicKey.getModulus().bitLength());
        System.out.println("Modulus=" + rSAPublicKey.getModulus().toString());
        System.out.println("PublicExponent.length=" + rSAPublicKey.getPublicExponent().bitLength());
        System.out.println("PublicExponent=" + rSAPublicKey.getPublicExponent().toString());
    }

    private static String readKey(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (readLine.charAt(0) != '-') {
                    sb5.append(readLine);
                    sb5.append('\r');
                }
            } else {
                return sb5.toString();
            }
        }
    }

    public static KeyPair generateRSAKeyPair(int i3) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(i3);
            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static PrivateKey getPrivateKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static PublicKey getPublicKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static PrivateKey loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            return loadPrivateKey(readKey(inputStream));
        } catch (IOException unused) {
            throw new Exception("\u79c1\u94a5\u6570\u636e\u8bfb\u53d6\u9519\u8bef");
        } catch (NullPointerException unused2) {
            throw new Exception("\u79c1\u94a5\u8f93\u5165\u6d41\u4e3a\u7a7a");
        }
    }

    public static PublicKey loadPublicKey(InputStream inputStream) throws Exception {
        try {
            return loadPublicKey(readKey(inputStream));
        } catch (IOException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u6d41\u8bfb\u53d6\u9519\u8bef");
        } catch (NullPointerException unused2) {
            throw new Exception("\u516c\u94a5\u8f93\u5165\u6d41\u4e3a\u7a7a");
        }
    }
}
