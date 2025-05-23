package com.huawei.secure.android.common.encrypt.rsa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class RSASign {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37832a = "SHA256WithRSA";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37833b = "SHA256WithRSA/PSS";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37834c = "RSASign";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37835d = "UTF-8";

    /* renamed from: e, reason: collision with root package name */
    private static final String f37836e = "";

    private static String a(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
            if (z16) {
                return newSign(str, privateKey);
            }
            return sign(str, privateKey);
        }
        b.b(f37834c, "sign content or key is null");
        return "";
    }

    public static boolean isBuildVersionHigherThan23() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    public static String newSign(String str, String str2) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f37834c, "sdk version is too low");
            return "";
        }
        return a(str, str2, true);
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f37834c, "sdk version is too low");
            return false;
        }
        return a(str, str2, str3, true);
    }

    @Deprecated
    public static String sign(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return a(str, str2, str3, false);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return a(str, privateKey, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return a(str, str2, publicKey, false);
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z16) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null && RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                if (z16) {
                    signature = Signature.getInstance(f37833b);
                    signature.setParameter(new PSSParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f37832a);
                }
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f37834c, "sign InvalidAlgorithmParameterException: " + e16.getMessage());
                return bArr2;
            } catch (InvalidKeyException e17) {
                b.b(f37834c, "sign InvalidKeyException: " + e17.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e18) {
                b.b(f37834c, "sign NoSuchAlgorithmException: " + e18.getMessage());
                return bArr2;
            } catch (SignatureException e19) {
                b.b(f37834c, "sign SignatureException: " + e19.getMessage());
                return bArr2;
            } catch (Exception e26) {
                b.b(f37834c, "sign Exception: " + e26.getMessage());
                return bArr2;
            }
        }
        b.b(f37834c, "content or privateKey is null , or length is too short");
        return bArr2;
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z16) {
        Signature signature;
        if (bArr != null && publicKey != null && bArr2 != null && RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                if (z16) {
                    signature = Signature.getInstance(f37833b);
                    signature.setParameter(new PSSParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f37832a);
                }
                signature.initVerify(publicKey);
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (GeneralSecurityException e16) {
                b.b(f37834c, "check sign exception: " + e16.getMessage());
                return false;
            } catch (Exception e17) {
                b.b(f37834c, "exception : " + e17.getMessage());
                return false;
            }
        }
        b.b(f37834c, "content or publicKey is null , or length is too short");
        return false;
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f37834c, "sdk version is too low");
            return "";
        }
        return a(str, privateKey, true);
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (!isBuildVersionHigherThan23()) {
            b.b(f37834c, "sdk version is too low");
            return false;
        }
        return a(str, str2, publicKey, true);
    }

    private static String a(String str, PrivateKey privateKey, boolean z16) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z16), 0);
        } catch (UnsupportedEncodingException e16) {
            b.b(f37834c, "sign UnsupportedEncodingException: " + e16.getMessage());
            return "";
        }
    }

    private static boolean a(String str, String str2, String str3, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
            if (z16) {
                return newVerifySign(str, str2, publicKey);
            }
            return verifySign(str, str2, publicKey);
        }
        b.b(f37834c, "content or public key or sign value is null");
        return false;
    }

    private static boolean a(String str, String str2, PublicKey publicKey, boolean z16) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z16);
        } catch (UnsupportedEncodingException e16) {
            b.b(f37834c, "verifySign UnsupportedEncodingException: " + e16.getMessage());
            return false;
        } catch (Exception e17) {
            b.b(f37834c, "base64 decode Exception : " + e17.getMessage());
            return false;
        }
    }

    public static boolean verifySign(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z16) {
        Signature signature;
        if (byteBuffer != null && publicKey != null && bArr != null && RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                if (z16) {
                    signature = Signature.getInstance(f37833b);
                    signature.setParameter(new PSSParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f37832a);
                }
                signature.initVerify(publicKey);
                signature.update(byteBuffer);
                return signature.verify(bArr);
            } catch (GeneralSecurityException e16) {
                b.b(f37834c, "check sign exception: " + e16.getMessage());
                return false;
            } catch (Exception e17) {
                b.b(f37834c, "exception : " + e17.getMessage());
                return false;
            }
        }
        b.b(f37834c, "content or publicKey is null , or length is too short");
        return false;
    }

    public static byte[] sign(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z16) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer != null && privateKey != null && RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                if (z16) {
                    signature = Signature.getInstance(f37833b);
                    signature.setParameter(new PSSParameterSpec(KeyPropertiesCompact.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f37832a);
                }
                signature.initSign(privateKey);
                signature.update(byteBuffer);
                bArr = signature.sign();
                b.c(f37834c, "result is : " + Arrays.toString(bArr));
                return bArr;
            } catch (InvalidAlgorithmParameterException e16) {
                b.b(f37834c, "sign InvalidAlgorithmParameterException: " + e16.getMessage());
                return bArr;
            } catch (InvalidKeyException e17) {
                b.b(f37834c, "sign InvalidKeyException: " + e17.getMessage());
                return bArr;
            } catch (NoSuchAlgorithmException e18) {
                b.b(f37834c, "sign NoSuchAlgorithmException: " + e18.getMessage());
                return bArr;
            } catch (SignatureException e19) {
                b.b(f37834c, "sign SignatureException: " + e19.getMessage());
                return bArr;
            } catch (Exception e26) {
                b.b(f37834c, "sign Exception: " + e26.getMessage());
                return bArr;
            }
        }
        b.b(f37834c, "content or privateKey is null , or length is too short");
        return bArr;
    }
}
