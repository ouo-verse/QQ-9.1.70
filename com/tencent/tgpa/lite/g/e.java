package com.tencent.tgpa.lite.g;

import android.util.Base64;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    public static byte[] a(byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    public static byte[] b(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
        cipher.init(1, new SecretKeySpec(str.getBytes("utf-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(str2.getBytes("utf-8")));
        return cipher.doFinal(bArr);
    }
}
