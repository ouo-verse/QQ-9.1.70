package com.tencent.tfd.sdk.wxa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cepheus {
    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(Bennet.a("4D4435")));
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArr2 = null;
        }
        return Bennet.a(bArr2);
    }
}
