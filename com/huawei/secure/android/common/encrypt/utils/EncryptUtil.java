package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EncryptUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37843a = "EncryptUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37844b = "RSA";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f37845c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f37846d = true;

    /* JADX WARN: Removed duplicated region for block: B:19:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SecureRandom a() {
        SecureRandom secureRandom;
        b.a(f37843a, "generateSecureRandomNew ");
        try {
        } catch (NoSuchAlgorithmException unused) {
            b.b(f37843a, "getSecureRandomBytes: NoSuchAlgorithmException");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            secureRandom = SecureRandom.getInstanceStrong();
            if (secureRandom == null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused2) {
                    b.b(f37843a, "NoSuchAlgorithmException");
                    return secureRandom;
                } catch (Throwable th5) {
                    if (f37846d) {
                        b.b(f37843a, "exception : " + th5.getMessage() + " , you should implementation bcprov-jdk15on library");
                        f37846d = false;
                    }
                    return secureRandom;
                }
            }
            AESEngine aESEngine = new AESEngine();
            byte[] bArr = new byte[32];
            secureRandom.nextBytes(bArr);
            return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(MsgConstant.KRMFILETHUMBSIZE384).buildCTR(aESEngine, 256, bArr, false);
        }
        secureRandom = null;
        if (secureRandom == null) {
        }
        AESEngine aESEngine2 = new AESEngine();
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        return new SP800SecureRandomBuilder(secureRandom, true).setEntropyBitsRequired(MsgConstant.KRMFILETHUMBSIZE384).buildCTR(aESEngine2, 256, bArr2, false);
    }

    public static SecureRandom genSecureRandom() {
        SecureRandom secureRandom;
        if (!f37845c) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    secureRandom = SecureRandom.getInstanceStrong();
                } else {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                }
                return secureRandom;
            } catch (NoSuchAlgorithmException unused) {
                b.b(f37843a, "genSecureRandom: NoSuchAlgorithmException");
                return null;
            }
        }
        return a();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] generateSecureRandom(int i3) {
        SecureRandom secureRandom;
        if (!f37845c) {
            byte[] bArr = new byte[i3];
            try {
            } catch (NoSuchAlgorithmException unused) {
                b.b(f37843a, "getSecureRandomBytes: NoSuchAlgorithmException");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                secureRandom = SecureRandom.getInstanceStrong();
                if (secureRandom == null) {
                    try {
                        secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    } catch (NoSuchAlgorithmException unused2) {
                        b.b(f37843a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                        return new byte[0];
                    } catch (Exception e16) {
                        b.b(f37843a, "getSecureRandomBytes getInstance: exception : " + e16.getMessage());
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
        return a(i3);
    }

    public static String generateSecureRandomStr(int i3) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i3));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e16) {
                b.b(f37843a, "load Key Exception:" + e16.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f37843a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e17) {
            b.b(f37843a, "base64 decode Exception" + e17.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e16) {
                b.b(f37843a, "load Key Exception:" + e16.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(f37843a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e17) {
            b.b(f37843a, "base64 decode Exception" + e17.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return f37845c;
    }

    public static void setBouncycastleFlag(boolean z16) {
        b.c(f37843a, "setBouncycastleFlag: " + z16);
        f37845c = z16;
    }

    private static byte[] a(int i3) {
        SecureRandom a16 = a();
        if (a16 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i3];
        a16.nextBytes(bArr);
        return bArr;
    }
}
