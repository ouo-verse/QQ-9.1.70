package com.tencent.qqlive.tvkplayer.tools.httpdns;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKHttpDnsCryptoUtils {
    private static final String AES_SECRETE_KEY = "Dsmp6K9bFiJHjr4l";
    private static final String CHARSET_UTF8 = "UTF-8";
    private static final String DES_SECRETE_KEY = "cePcXNnF";
    public static final String ENCRYPTION_TYPE_AES = "AES/CBC/PKCS7Padding";
    public static final String ENCRYPTION_TYPE_DES = "DES";
    private static final byte[] IV_DEFAULT = {48, 49, 48, 50, 48, 51, 48, 52, 48, 53, 48, 54, 48, 55, 48, 56};
    private static final String TAG = "TVKHttpDnsCryptoUtils";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface EncryptionType {
    }

    private static String bytes2HexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b16)));
        }
        return stringBuffer.toString();
    }

    public static String decrypt(String str, String str2) {
        if (ENCRYPTION_TYPE_DES.equals(str2)) {
            return decrypt(str, DES_SECRETE_KEY, str2);
        }
        return ENCRYPTION_TYPE_AES.equals(str2) ? decrypt(str, AES_SECRETE_KEY, str2) : "";
    }

    private static byte[] deleteIVFromAesCipherText(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    public static String encrypt(String str, String str2) {
        if (ENCRYPTION_TYPE_DES.equals(str2)) {
            return encrypt(str, DES_SECRETE_KEY, str2);
        }
        return ENCRYPTION_TYPE_AES.equals(str2) ? encrypt(str, AES_SECRETE_KEY, str2) : "";
    }

    private static byte[] getIVFromAesCipherText(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return null;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    private static IvParameterSpec getRandomAesIv() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[Cipher.getInstance(ENCRYPTION_TYPE_AES).getBlockSize()];
            secureRandom.nextBytes(bArr);
            return new IvParameterSpec(bArr);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return new IvParameterSpec(IV_DEFAULT);
        }
    }

    private static Key getSecretKey(String str, String str2) {
        try {
            return new SecretKeySpec(str.getBytes("UTF-8"), str2);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return null;
        }
    }

    private static byte[] hexString2Bytes(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = Integer.valueOf(str.substring(i16, i16 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static boolean isValidAesKey(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 16) {
            return true;
        }
        return false;
    }

    private static boolean isValidDesKey(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 8) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(String str, String str2) {
        if (ENCRYPTION_TYPE_DES.equals(str2) && isValidDesKey(str)) {
            return true;
        }
        if (ENCRYPTION_TYPE_AES.equals(str2) && isValidAesKey(str)) {
            return true;
        }
        return false;
    }

    private static String decrypt(String str, String str2, String str3) {
        byte[] doFinal;
        if (!isValidKey(str2, str3)) {
            TVKLogUtil.i(TAG, "invalid decrypt key=" + str2 + ", encryptionType=" + str3);
            return "";
        }
        try {
            byte[] hexString2Bytes = hexString2Bytes(str);
            Cipher cipher = Cipher.getInstance(str3);
            if (ENCRYPTION_TYPE_AES.equals(str3)) {
                cipher.init(2, getSecretKey(str2, str3), new IvParameterSpec(getIVFromAesCipherText(hexString2Bytes)));
                doFinal = cipher.doFinal(deleteIVFromAesCipherText(hexString2Bytes));
            } else {
                cipher.init(2, getSecretKey(str2, str3));
                doFinal = cipher.doFinal(hexString2Bytes);
            }
            return new String(doFinal);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return "";
        }
    }

    private static String encrypt(String str, String str2, String str3) {
        byte[] doFinal;
        if (!isValidKey(str2, str3)) {
            TVKLogUtil.i(TAG, "invalid encrypt key=" + str2 + ", encryptionType=" + str3);
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance(str3);
            if (ENCRYPTION_TYPE_AES.equals(str3)) {
                IvParameterSpec randomAesIv = getRandomAesIv();
                cipher.init(1, getSecretKey(str2, str3), randomAesIv);
                doFinal = TVKUtils.mergeBytes(randomAesIv.getIV(), cipher.doFinal(str.getBytes("UTF-8")));
            } else {
                cipher.init(1, getSecretKey(str2, str3));
                doFinal = cipher.doFinal(str.getBytes("UTF-8"));
            }
            return bytes2HexString(doFinal);
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            return "";
        }
    }
}
