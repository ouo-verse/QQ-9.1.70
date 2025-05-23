package eu3;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f397156a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f397157b = new HashMap();

    public static void a(boolean z16) {
        f397156a = z16;
    }

    public static void b(String str, String str2) {
        if (!f397156a) {
            return;
        }
        String str3 = str + str2;
        Map<String, Long> map = f397157b;
        if (map.containsKey(str3)) {
            long longValue = map.remove(str3).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = (longValue / 1000) % 60;
            long j16 = (longValue / 60000) % 60;
            long j17 = (currentTimeMillis / 1000) % 60;
            long j18 = (currentTimeMillis / 60000) % 60;
            Log.d(str, "track method: " + str2 + ", startTime: " + j16 + ":" + j3 + "." + (longValue % 1000) + ", endTime: " + j18 + ":" + j17 + "." + (currentTimeMillis % 1000) + ", costTime: " + (currentTimeMillis - longValue) + " ms");
            return;
        }
        map.put(str3, Long.valueOf(System.currentTimeMillis()));
    }
}
