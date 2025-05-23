package com.vivo.push.util;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static String f387868a = "RSA";

    public static String a(Key key) {
        return Base64.encodeToString(key.getEncoded(), 2);
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(f387868a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NullPointerException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        }
    }

    public static boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
