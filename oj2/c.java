package oj2;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final c f423026b = new c();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Long> f423027a = new HashMap<>();

    c() {
    }

    public static c b() {
        return f423026b;
    }

    public long a(String str) {
        if (this.f423027a.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f423027a.get(str).longValue();
            if (currentTimeMillis < 0) {
                mj2.a.d("QQVideoEditMapReport", "endKey... cost < 0 id:" + str);
                return -1L;
            }
            return currentTimeMillis;
        }
        mj2.a.d("QQVideoEditMapReport", "endKey... clickTimesMap not contain id:" + str);
        return -1L;
    }

    public void c(String str, String str2, String str3) {
        if (a(str) <= 0) {
            mj2.a.d("QQVideoEditMapReport", "reportEnd... cost < 0 id:" + str);
        }
    }

    public void d(String str) {
        this.f423027a.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
