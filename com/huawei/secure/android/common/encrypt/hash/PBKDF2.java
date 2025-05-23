package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes2.dex */
public abstract class PBKDF2 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37787a = "PBKDF2";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37788b = "PBKDF2WithHmacSHA1";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37789c = "PBKDF2WithHmacSHA256";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37790d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f37791e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37792f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final int f37793g = 32;

    /* renamed from: h, reason: collision with root package name */
    private static final int f37794h = 10000;

    /* renamed from: i, reason: collision with root package name */
    private static final int f37795i = 1000;

    private static byte[] a(char[] cArr, byte[] bArr, int i3, int i16, boolean z16) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i3, i16);
            if (z16) {
                secretKeyFactory = SecretKeyFactory.getInstance(f37789c);
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance(f37788b);
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e16) {
            b.b(f37787a, "pbkdf exception : " + e16.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i3, int i16) {
        return a(cArr, bArr, i3, i16, false);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT < 26) {
            b.b(f37787a, "system version not high than 26");
            return bArr2;
        }
        return a(cArr, bArr, i3, i16, true);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i3) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i3, 32);
    }

    public static String pbkdf2EncryptNew(String str, int i3) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i3, 32);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i3, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(String str, String str2, int i3) {
        byte[] pbkdf2SHA256;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            pbkdf2SHA256 = pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i3, 256);
        } else {
            pbkdf2SHA256 = pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i3, 256);
        }
        return a(pbkdf2SHA256, HexUtil.hexStr2ByteArray(substring2));
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            b.b(f37787a, "pwd is null.");
            return "";
        }
        if (i3 < 1000) {
            b.b(f37787a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 8) {
            b.b(f37787a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i16 < 32) {
            b.b(f37787a, "cipherLen length is not enough");
            return "";
        }
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2(str.toCharArray(), bArr, i3, i16 * 8));
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i3, int i16) {
        byte[] pbkdf2SHA256;
        if (TextUtils.isEmpty(str)) {
            b.b(f37787a, "pwd is null.");
            return "";
        }
        if (i3 < 1000) {
            b.b(f37787a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 16) {
            b.b(f37787a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i16 < 32) {
            b.b(f37787a, "cipherLen length is not enough");
            return "";
        }
        if (Build.VERSION.SDK_INT < 26) {
            b.c(f37787a, "sha 1");
            pbkdf2SHA256 = pbkdf2(str.toCharArray(), bArr, i3, i16 * 8);
        } else {
            b.c(f37787a, "sha 256");
            pbkdf2SHA256 = pbkdf2SHA256(str.toCharArray(), bArr, i3, i16 * 8);
        }
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2SHA256);
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i3 = 0; i3 < bArr.length && i3 < bArr2.length; i3++) {
            length |= bArr[i3] ^ bArr2[i3];
        }
        return length == 0;
    }
}
