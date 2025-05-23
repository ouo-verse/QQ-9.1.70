package ev2;

import android.content.SharedPreferences;
import hv2.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    public static String[] a(SharedPreferences sharedPreferences) {
        k b16 = b();
        if (b16 != null) {
            return b16.a(sharedPreferences);
        }
        return null;
    }

    private static k b() {
        return (k) dv2.b.d().a(k.class);
    }

    public static SharedPreferences c(String str) {
        k b16 = b();
        if (b16 != null) {
            return b16.b(str);
        }
        return qv2.b.a().getSharedPreferences(str, 0);
    }
}
