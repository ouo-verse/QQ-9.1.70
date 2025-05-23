package h45;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a {
    public static <T> T a(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2));
    }
}
