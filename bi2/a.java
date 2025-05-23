package bi2;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f28442a = new ConcurrentHashMap();

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str + ":";
        Iterator<Map.Entry<String, Long>> it = f28442a.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (!TextUtils.isEmpty(key) && key.contains(str2)) {
                it.remove();
            }
        }
    }

    public static long b(String str, String str2, String str3, String str4) {
        return c(str, str2) - c(str3, str4);
    }

    public static long c(String str, String str2) {
        Long l3 = f28442a.get(str + ":" + str2);
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    public static void d(String str, String str2) {
        f28442a.put(str + ":" + str2, Long.valueOf(SystemClock.uptimeMillis()));
    }
}
