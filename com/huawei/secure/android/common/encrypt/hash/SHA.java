package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SHA {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37796a = "SHA";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37797b = "SHA-256";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37798c = "";

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f37799d = {"SHA-256", KeyPropertiesCompact.DIGEST_SHA384, KeyPropertiesCompact.DIGEST_SHA512};

    SHA() {
    }

    private static boolean a(String str) {
        for (String str2 : f37799d) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, "SHA-256");
    }

    public static String shaEncrypt(String str, String str2) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!a(str2)) {
                b.b(f37796a, "algorithm is not safe or legal");
                return "";
            }
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                b.b(f37796a, "Error in generate SHA UnsupportedEncodingException");
            }
            return HexUtil.byteArray2HexStr(shaEncryptByte(bArr, str2));
        }
        b.b(f37796a, "content or algorithm is null.");
        return "";
    }

    public static byte[] shaEncryptByte(byte[] bArr, String str) {
        if (bArr != null && !TextUtils.isEmpty(str)) {
            if (!a(str)) {
                b.b(f37796a, "algorithm is not safe or legal");
                return new byte[0];
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                b.b(f37796a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
        b.b(f37796a, "content or algorithm is null.");
        return new byte[0];
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return str2.equals(shaEncrypt(str, str3));
        }
        return false;
    }

    public static boolean validateSHA256(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str2.equals(sha256Encrypt(str));
        }
        return false;
    }
}
