package com.vivo.push.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class j {
    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = (char) (bArr[i3] ^ RegisterType.UNINIT_REF);
        }
        return new String(cArr);
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes("utf-8")));
        return cipher.doFinal(bArr);
    }
}
