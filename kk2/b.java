package kk2;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f412602a = new HashMap<>();

    public static boolean a(String str, long j3) {
        long j16;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (f412602a.containsKey(str)) {
            j16 = f412602a.get(str).longValue();
        } else {
            j16 = 0;
        }
        long j17 = currentTimeMillis - j16;
        if (j17 >= 0 && j17 <= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        f412602a.put(str, Long.valueOf(currentTimeMillis));
        return z16;
    }
}
