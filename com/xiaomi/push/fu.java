package com.xiaomi.push;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fu {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f388930a = {100, 23, 84, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, RegisterType.REFERENCE, 32};

    private static Cipher a(byte[] bArr, int i3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f388930a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, ivParameterSpec);
        return cipher;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }
}
