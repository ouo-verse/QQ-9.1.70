package h45;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes29.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f404318a = "";

    public static String a(Context context, int i3) {
        if (i3 >= 2) {
            return "NULL";
        }
        int i16 = i3 + 1;
        if (TextUtils.isEmpty(f404318a)) {
            b(k45.a.b(context).a("UUID", ""));
            if (TextUtils.isEmpty(f404318a)) {
                b(UUID.randomUUID().toString());
                if (TextUtils.isEmpty(f404318a)) {
                    return "NULL";
                }
                k45.a.b(context).d("UUID", f404318a);
            }
        }
        if (!TextUtils.isEmpty(f404318a) && (f404318a.length() > 40 || !j2.a.g(f404318a))) {
            f404318a = "";
            k45.a.b(context).c("UUID");
            f404318a = a(context, i16);
        }
        return f404318a;
    }

    private static synchronized void b(String str) {
        synchronized (h.class) {
            f404318a = str;
        }
    }
}
