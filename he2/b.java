package he2;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected static MessageDigest f404806a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f404807b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static char[] f404808c;

    /* renamed from: d, reason: collision with root package name */
    private static int f404809d;

    static {
        char[] charArray = "361910168".toCharArray();
        f404808c = charArray;
        f404809d = charArray.length;
        try {
            f404806a = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
        } catch (NoSuchAlgorithmException e16) {
            QLog.e("PandoraExEvent.SecurityUtil", 1, "init message digest error, ", e16);
        }
    }

    public static String a(String str) {
        return i(str);
    }

    public static String b(String str) {
        return i(str);
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i3 = 0;
        if (str.length() < 4) {
            StringBuilder sb5 = new StringBuilder();
            while (i3 < str.length()) {
                if (i3 == str.length() - 1) {
                    sb5.append(str.charAt(i3));
                } else {
                    sb5.append("*");
                }
                i3++;
            }
            return sb5.toString();
        }
        if (str.length() % 4 == 0) {
            StringBuilder sb6 = new StringBuilder();
            while (i3 < str.length()) {
                if (i3 > (str.length() / 4) - 1 && i3 < (str.length() * 3) / 4) {
                    sb6.append("*");
                } else {
                    sb6.append(str.charAt(i3));
                }
                i3++;
            }
            return sb6.toString();
        }
        StringBuilder sb7 = new StringBuilder();
        while (i3 < str.length()) {
            if (i3 > str.length() / 4 && i3 <= (str.length() * 3) / 4) {
                sb7.append("*");
            } else {
                sb7.append(str.charAt(i3));
            }
            i3++;
        }
        return sb7.toString();
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i3 = 0;
        if (str.length() <= 4) {
            StringBuilder sb5 = new StringBuilder();
            while (i3 < str.length()) {
                sb5.append("*");
                i3++;
            }
            return sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        while (i3 < str.length()) {
            if (i3 >= str.length() - 4) {
                sb6.append(str.charAt(i3));
            } else {
                sb6.append("*");
            }
            i3++;
        }
        return sb6.toString();
    }

    public static String e(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            return h(str.concat(str2).concat(str3));
        }
        return "";
    }

    public static String f(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str3 != null && str4 != null) {
            return h(str.concat(str2).concat(str3).concat(str4));
        }
        return "";
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (!str.equals("C2-1-9") && !str.equals("C2-1-4") && !str.equals("C2-1-7") && !str.equals("C2-1-6") && !str.equals("C2-1-12")) {
            return c(str2);
        }
        return d(str2);
    }

    public static String h(String str) {
        if (f404806a != null && !TextUtils.isEmpty(str)) {
            synchronized (f404807b) {
                f404806a.update(str.getBytes());
            }
            return Base64.encodeToString(f404806a.digest(), 9);
        }
        return "";
    }

    private static String i(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char[] cArr = new char[length];
        int i3 = 0;
        if (f404809d >= charArray.length) {
            while (i3 < charArray.length) {
                cArr[i3] = (char) (charArray[i3] ^ f404808c[i3]);
                i3++;
            }
        } else {
            while (i3 < charArray.length) {
                cArr[i3] = (char) (charArray[i3] ^ f404808c[i3 % f404809d]);
                i3++;
            }
        }
        if (length == 0) {
            return "";
        }
        return new String(cArr);
    }
}
