package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HMACSHA256 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37783a = "HMACSHA256";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37784b = "HmacSHA256";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37785c = "";

    /* renamed from: d, reason: collision with root package name */
    private static final int f37786d = 32;

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            if (bArr2.length < 32) {
                b.b(f37783a, "hmac key length is not right");
                return new byte[0];
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "HmacSHA256");
                Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
                mac.init(secretKeySpec);
                return mac.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e16) {
                b.b(f37783a, "hmacsha256 encrypt exception" + e16.getMessage());
                return new byte[0];
            }
        }
        b.b(f37783a, "content or key is null.");
        return new byte[0];
    }

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            b.b(f37783a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e16) {
            b.b(f37783a, "hmacsha256 encrypt exception" + e16.getMessage());
            bArr2 = new byte[0];
        }
        return HexUtil.byteArray2HexStr(hmacEncrypt(bArr2, bArr));
    }
}
