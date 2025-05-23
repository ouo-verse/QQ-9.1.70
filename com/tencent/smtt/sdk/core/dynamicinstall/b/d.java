package com.tencent.smtt.sdk.core.dynamicinstall.b;

import com.tencent.mobileqq.text.EmotcationConstants;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f369319a = {'R', 'S', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f369320b = {'S', 'H', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, '2', '5', '6', 'w', 'i', 't', 'h', 'R', 'S', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET};

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance(String.valueOf(f369319a)).generatePublic(new X509EncodedKeySpec(bArr3));
        Signature signature = Signature.getInstance(String.valueOf(f369320b));
        signature.initVerify(generatePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
