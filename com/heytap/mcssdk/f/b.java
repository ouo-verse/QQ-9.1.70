package com.heytap.mcssdk.f;

import android.util.Base64;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b {
    public static String a(String str, String str2) {
        Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES);
        cipher.init(2, a(str2));
        return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    private static Key a(String str) {
        return SecretKeyFactory.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_DES).generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }
}
