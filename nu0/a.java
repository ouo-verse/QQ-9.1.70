package nu0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ((!str.startsWith("https://") && !str.startsWith("http://")) || !str.contains(".flv")) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("rtmp");
    }
}
