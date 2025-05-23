package com.tencent.turingcam;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LmseU {
    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArr2 = null;
        }
        return Ckq8l.a(bArr2);
    }
}
