package com.tencent.biz.richframework.network.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Encrypt {
    private static final int MAX_ENCRYPT_BLOCK = 117;
    protected static final String MODE = "RSA";
    private static final int PADDING_MAX_ENCRYPT_BLOCK = 128;
    protected static final String PADDING_MODE = "RSA/ECB/PKCS1Padding";
    private static final int RADIX = 16;
    private static final String SEED = "51901";

    public static byte[] compress(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (IOException e16) {
            e16.printStackTrace();
            return bArr2;
        }
    }

    public static final String decrypt(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(new BigInteger(str, 16).xor(new BigInteger(SEED)).toByteArray());
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String encrypt(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return new BigInteger(SEED).xor(new BigInteger(str.getBytes())).toString(16);
    }

    public static String md5(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest != null) {
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            return StringUtils.byte2HexString(messageDigest.digest());
        }
        return "";
    }
}
