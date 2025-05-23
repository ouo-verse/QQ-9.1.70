package com.xiaomi.push;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ag {
    public static String a(int i3) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < i3; i16++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(j(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        }
        return "";
    }

    public static String c(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int length = str.length();
        if (i3 <= 0 || length < i3) {
            i3 = length / 3;
            if (i3 <= 1) {
                i3 = 1;
            }
            if (i3 > 3) {
                i3 = 3;
            }
        }
        int i16 = 0;
        while (i16 < length) {
            int i17 = i16 + 1;
            if (i17 % i3 == 0) {
                sb5.append("*");
            } else {
                sb5.append(str.charAt(i16));
            }
            i16 = i17;
        }
        return sb5.toString();
    }

    public static String d(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return e(collection.iterator(), str);
    }

    public static String e(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String f(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    public static String g(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return h(objArr, str, 0, objArr.length);
    }

    public static String h(Object[] objArr, String str, int i3, int i16) {
        int length;
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return "";
        }
        Object obj = objArr[i3];
        if (obj == null) {
            length = 16;
        } else {
            length = obj.toString().length();
        }
        StringBuffer stringBuffer = new StringBuffer(i17 * (length + str.length()));
        for (int i18 = i3; i18 < i16; i18++) {
            if (i18 > i3) {
                stringBuffer.append(str);
            }
            Object obj2 = objArr[i18];
            if (obj2 != null) {
                stringBuffer.append(obj2);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean i(String str) {
        if (str != null) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt < 0 || charAt > '\u007f') {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String k(String str) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                messageDigest.update(j(str));
                return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (NoSuchAlgorithmException unused) {
                return str;
            }
        }
        return null;
    }

    public static String l(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        return null;
    }
}
