package ez3;

import cooperation.qzone.LbsDataV2;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements a {

    /* renamed from: c, reason: collision with root package name */
    private static String f397465c;

    /* renamed from: a, reason: collision with root package name */
    private a f397467a;

    /* renamed from: b, reason: collision with root package name */
    private static Object f397464b = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, b> f397466d = new ConcurrentHashMap<>();

    b(String str) {
        f397465c = str;
        this.f397467a = c.b(str);
    }

    public static b b(String str) {
        b bVar = f397466d.get(str);
        if (bVar == null) {
            synchronized (f397464b) {
                bVar = f397466d.get(str);
                if (bVar == null) {
                    bVar = new b(str);
                    f397466d.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    @Override // ez3.a
    public LbsDataV2.GpsInfo a() {
        return this.f397467a.a();
    }
}
