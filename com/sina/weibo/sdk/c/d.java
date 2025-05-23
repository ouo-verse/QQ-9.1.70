package com.sina.weibo.sdk.c;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: ap, reason: collision with root package name */
    private static final char[] f61250ap = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                char[] cArr2 = f61250ap;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr[i17] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        try {
            return a(str.getBytes());
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
