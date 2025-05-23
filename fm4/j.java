package fm4;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public boolean f399882a;

    /* renamed from: b, reason: collision with root package name */
    public int f399883b;

    /* renamed from: c, reason: collision with root package name */
    public int f399884c;

    /* renamed from: d, reason: collision with root package name */
    public int f399885d;

    /* renamed from: e, reason: collision with root package name */
    public long f399886e;

    /* renamed from: f, reason: collision with root package name */
    public int f399887f;

    /* renamed from: g, reason: collision with root package name */
    public List<Integer> f399888g = new ArrayList();

    public j(boolean z16, int i3, int i16, int i17, long j3, int i18, List<Integer> list) {
        this.f399882a = z16;
        this.f399883b = i3;
        this.f399884c = i16;
        this.f399885d = i17;
        this.f399886e = j3;
        this.f399887f = i18;
        if (list != null && list.size() > 0) {
            this.f399888g.addAll(list);
        }
    }

    public static j b(int i3) {
        return new j(true, i3, 0, 0, 0L, 0, null);
    }

    public static j c(com.tencent.timi.game.room.impl.util.d dVar) {
        return new j(false, dVar.f379328e, dVar.f379325b, dVar.f379326c, dVar.f379324a, 0, null);
    }

    public static j d(com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar) {
        return new j(false, dVar.f379328e, dVar.f379325b, dVar.f379326c, dVar.f379324a, cVar.f379322a, cVar.f379323b);
    }

    public int a() {
        if (this.f399884c != 3) {
            return 1;
        }
        return 2;
    }
}
