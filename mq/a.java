package mq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import w53.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f417163b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, C10800a> f417164a = new HashMap();

    /* compiled from: P */
    /* renamed from: mq.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10800a {

        /* renamed from: a, reason: collision with root package name */
        private Long f417165a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<Long> f417166b = new ArrayList<>();

        public C10800a(Long l3) {
            this.f417165a = l3;
        }
    }

    a() {
    }

    private long b(String str, int i3) {
        long e16 = e(str, i3);
        long f16 = f(str);
        if (this.f417164a.containsKey(str)) {
            this.f417164a.remove(str);
        }
        if (f16 <= 0 || e16 <= f16) {
            return 0L;
        }
        return e16 - f16;
    }

    private ArrayList<Long> c(String str, int... iArr) {
        ArrayList<Long> arrayList = new ArrayList<>();
        long f16 = f(str);
        for (int i3 : iArr) {
            long e16 = e(str, i3);
            long j3 = 0;
            if (f16 > 0 && e16 > f16) {
                j3 = e16 - f16;
            }
            arrayList.add(Long.valueOf(j3));
        }
        if (this.f417164a.containsKey(str)) {
            this.f417164a.remove(str);
        }
        return arrayList;
    }

    public static a d() {
        if (f417163b == null) {
            synchronized (a.class) {
                if (f417163b == null) {
                    f417163b = new a();
                }
            }
        }
        return f417163b;
    }

    private long f(String str) {
        if (this.f417164a.containsKey(str)) {
            return this.f417164a.get(str).f417165a.longValue();
        }
        return 0L;
    }

    public void a(String str) {
        Map<String, C10800a> map = this.f417164a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f417164a.remove(str);
    }

    public ArrayList<Long> i(String str, int... iArr) {
        return c(str, iArr);
    }

    public void j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f417164a.put(str, new C10800a(Long.valueOf(currentTimeMillis)));
        ms.a.f("LSPrefRecorder", str + " value :" + currentTimeMillis);
    }

    public void k(String str) {
        if (this.f417164a.containsKey(str)) {
            this.f417164a.get(str).f417166b.add(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void l(String str, long j3) {
        if (this.f417164a.containsKey(str)) {
            this.f417164a.get(str).f417166b.add(Long.valueOf(j3));
        }
    }

    public long g(String str) {
        return h(str, 0);
    }

    private long e(String str, int i3) {
        try {
            if (this.f417164a.containsKey(str) && this.f417164a.get(str).f417166b.size() > i3) {
                ArrayList arrayList = this.f417164a.get(str).f417166b;
                if (arrayList.isEmpty()) {
                    return 0L;
                }
                if (i3 == -1) {
                    return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
                }
                return ((Long) arrayList.get(i3)).longValue();
            }
        } catch (Exception e16) {
            b.e("LSPrefRecorder", e16);
        }
        return 0L;
    }

    public long h(String str, int i3) {
        if (i3 != -1) {
            k(str);
        }
        return b(str, i3);
    }
}
