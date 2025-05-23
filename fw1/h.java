package fw1;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<Integer, a> f400891a;

    public h() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = new ConcurrentHashMap<>();
        this.f400891a = concurrentHashMap;
        concurrentHashMap.put(1, new g());
        this.f400891a.put(2, new k());
        this.f400891a.put(3, new i());
        this.f400891a.put(4, new f());
        this.f400891a.put(5, new d());
        this.f400891a.put(6, new c());
        this.f400891a.put(7, new e());
        this.f400891a.put(8, new j());
    }

    public a a(int i3) {
        return this.f400891a.get(Integer.valueOf(i3));
    }
}
