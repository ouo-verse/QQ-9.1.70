package c.t.m.g;

import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class d1 {
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable unused) {
            bArr = null;
        }
        return a(bArr, str2);
    }

    public static String a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return n0.a(messageDigest.digest(), "");
        } catch (Throwable th5) {
            if (c1.a()) {
                c1.a("MessageDigestUtil", "getMessageDigest[" + str + "] error.", th5);
            }
            return "";
        }
    }
}
