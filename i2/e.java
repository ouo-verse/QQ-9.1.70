package i2;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f407089a = {KeyPropertiesCompact.DIGEST_SHA256, KeyPropertiesCompact.DIGEST_SHA384, KeyPropertiesCompact.DIGEST_SHA512};

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!b(str2)) {
                q.q.q.e.w.e.e("SHA256", "algorithm is not safe or legal", true);
                return "";
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes("UTF-8"));
                return j2.a.c(messageDigest.digest());
            } catch (UnsupportedEncodingException unused) {
                q.q.q.e.w.e.e("SHA256", "Error in generate SHA UnsupportedEncodingException", true);
                return "";
            } catch (NoSuchAlgorithmException unused2) {
                q.q.q.e.w.e.e("SHA256", "Error in generate SHA NoSuchAlgorithmException", true);
                return "";
            }
        }
        q.q.q.e.w.e.e("SHA256", "content or algorithm is null.", true);
        return "";
    }

    private static boolean b(String str) {
        for (String str2 : f407089a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String c(String str) {
        return d(str);
    }

    public static String d(String str) {
        return a(str, KeyPropertiesCompact.DIGEST_SHA256);
    }
}
