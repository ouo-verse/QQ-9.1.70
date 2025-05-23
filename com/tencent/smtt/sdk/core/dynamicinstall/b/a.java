package com.tencent.smtt.sdk.core.dynamicinstall.b;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f369315a = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'E', 'S'};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f369316b = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'E', 'S', '/', 'E', 'C', 'B', '/', 'P', 'K', 'C', 'S', '5', 'P', 'a', 'd', 'd', 'i', 'n', 'g'};

    public static String a(String str, String str2) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        byte[] bytes = str2.getBytes();
        byte[] a16 = b.a(str);
        e.b(a16);
        return new String(a(bytes, a16), "utf-8");
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, String.valueOf(f369315a));
        Cipher cipher = Cipher.getInstance(String.valueOf(f369316b));
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }
}
