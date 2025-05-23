package com.tencent.oskplayer.util;

import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SecretUtils {
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String DES = "des";
    private static final String HEX = "0123456789ABCDEF";
    private static final String SHA1PRNG = "SHA1PRNG";
    public static final String TAG = "SecretUtils";
    private static final byte[] DESIV = {RegisterType.REFERENCE, 52, 86, 120, -112, -85, -51, -17};
    private static String sRandomStr = null;

    private static void appendHex(StringBuffer stringBuffer, byte b16) {
        stringBuffer.append(HEX.charAt((b16 >> 4) & 15));
        stringBuffer.append(HEX.charAt(b16 & RegisterType.DOUBLE_HI));
    }

    public static String decode(String str, String str2, String str3) throws Exception {
        if (str != null && !str.isEmpty() && str.equals(DES)) {
            return decodeDes(str2, str3);
        }
        return null;
    }

    private static String decodeDes(String str, String str2) throws Exception {
        if (str != null && str.length() >= 8) {
            byte[] decode = Base16.decode(str2);
            if (decode != null && decode.length != 0) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str3 = TAG;
                    PlayerUtils.log(3, str3, "start decode milles time = " + currentTimeMillis);
                    SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes()));
                    Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
                    cipher.init(2, generateSecret, new IvParameterSpec(DESIV));
                    String str4 = new String(cipher.doFinal(decode));
                    PlayerUtils.log(3, str3, "end decode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
                    return str4;
                } catch (Exception e16) {
                    PlayerUtils.log(6, TAG, "decode des error" + PlayerUtils.getPrintableStackTrace(e16));
                    throw e16;
                }
            }
            return null;
        }
        throw new Exception("secret key is not available");
    }

    public static String encode(String str, String str2, String str3) throws Exception {
        if (str != null && !str.isEmpty() && str.equals(DES)) {
            return encodeDes(str2, str3);
        }
        return null;
    }

    private static String encodeDes(String str, String str2) throws Exception {
        if (str != null && str.length() >= 8) {
            if (str2 != null && !str2.isEmpty()) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String str3 = TAG;
                    PlayerUtils.log(3, str3, "start encode milles time = " + currentTimeMillis);
                    SecretKey generateSecret = SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(str.getBytes()));
                    Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
                    cipher.init(1, generateSecret, new IvParameterSpec(DESIV));
                    String encode = Base16.encode(cipher.doFinal(str2.getBytes()));
                    PlayerUtils.log(3, str3, "end encode milles time = " + (System.currentTimeMillis() - currentTimeMillis));
                    return encode;
                } catch (Exception e16) {
                    PlayerUtils.log(6, TAG, "encode des error" + PlayerUtils.getPrintableStackTrace(e16));
                    throw e16;
                }
            }
            return null;
        }
        throw new Exception("secret key is not available");
    }

    public static String generateKey() {
        try {
            byte[] bArr = new byte[20];
            SecureRandom.getInstance(SHA1PRNG).nextBytes(bArr);
            return toHex(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static synchronized String getRandomNum() {
        String str;
        synchronized (SecretUtils.class) {
            if (sRandomStr == null) {
                sRandomStr = generateKey();
            }
            str = sRandomStr;
        }
        return str;
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b16 : bArr) {
            appendHex(stringBuffer, b16);
        }
        return stringBuffer.toString();
    }
}
