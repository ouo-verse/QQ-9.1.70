package com.huawei.secure.android.common.util;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EncryptUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38001a = "EncryptUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38002b = "RSA";

    /* JADX WARN: Removed duplicated region for block: B:16:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] generateSecureRandom(int i3) {
        SecureRandom secureRandom;
        byte[] bArr = new byte[i3];
        try {
        } catch (NoSuchAlgorithmException unused) {
            LogsUtil.e(f38001a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            secureRandom = SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused2) {
                    LogsUtil.e(f38001a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                    return new byte[0];
                } catch (Exception e16) {
                    LogsUtil.e(f38001a, "getSecureRandomBytes getInstance: exception : " + e16.getMessage());
                    return new byte[0];
                }
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    @Deprecated
    public static String generateSecureRandomStr(int i3) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i3));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e16) {
                LogsUtil.e(f38001a, "load Key Exception:" + e16.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(f38001a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(f38001a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e16) {
                LogsUtil.e(f38001a, "load Key Exception:" + e16.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(f38001a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(f38001a, "base64 decode Exception", true);
            return null;
        }
    }
}
