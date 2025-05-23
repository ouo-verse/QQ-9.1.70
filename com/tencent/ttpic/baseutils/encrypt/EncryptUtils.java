package com.tencent.ttpic.baseutils.encrypt;

import com.tencent.util.Coffee;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: P */
/* loaded from: classes27.dex */
class EncryptUtils {
    private static final String encoding = "utf-8";

    /* renamed from: iv, reason: collision with root package name */
    private static final String f381695iv = "68881999";

    EncryptUtils() {
    }

    public static byte[] decode(byte[] bArr) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(Coffee.getSignkey().getBytes()));
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        cipher.init(2, generateSecret, new IvParameterSpec(f381695iv.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] encode(byte[] bArr) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(Coffee.getSignkey().getBytes()));
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        cipher.init(1, generateSecret, new IvParameterSpec(f381695iv.getBytes()));
        return cipher.doFinal(bArr);
    }
}
