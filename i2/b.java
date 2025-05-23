package i2;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static String a(Context context, String str) {
        int i3;
        String str2;
        try {
            i3 = Integer.parseInt(h45.c.a(context));
        } catch (Exception unused) {
            q.q.q.e.w.e.c("HnIdEncrypter", "get version of encrypted is null, use GRADE_VERSION_KEYSTORE directory", true);
            i3 = 3;
        }
        if (i3 >= 3) {
            str2 = c.a(context.getPackageName() + ".hnidsdk", str);
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }

    public static String b(Context context, String str) {
        return c.c(context.getPackageName() + ".hnidsdk", str);
    }

    public static String c(Context context, String str) {
        return a(context, str);
    }
}
