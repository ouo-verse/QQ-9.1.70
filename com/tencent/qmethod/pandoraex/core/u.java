package com.tencent.qmethod.pandoraex.core;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    protected static MessageDigest f344163a;

    /* renamed from: b, reason: collision with root package name */
    private static char[] f344164b;

    /* renamed from: c, reason: collision with root package name */
    private static int f344165c;

    static {
        char[] charArray = "361910168".toCharArray();
        f344164b = charArray;
        f344165c = charArray.length;
        try {
            f344163a = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
        } catch (NoSuchAlgorithmException e16) {
            o.d("PandoraExEvent.SecurityUtil", "init message digest error, ", e16);
        }
    }

    public static String a(String str) {
        return c(str);
    }

    public static String b(String str) {
        return c(str);
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char[] cArr = new char[length];
        int i3 = 0;
        if (f344165c >= charArray.length) {
            while (i3 < charArray.length) {
                cArr[i3] = (char) (charArray[i3] ^ f344164b[i3]);
                i3++;
            }
        } else {
            while (i3 < charArray.length) {
                cArr[i3] = (char) (charArray[i3] ^ f344164b[i3 % f344165c]);
                i3++;
            }
        }
        if (length == 0) {
            return "";
        }
        return new String(cArr);
    }
}
