package e45;

import c45.b;
import c45.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e implements c45.g {

    /* renamed from: a, reason: collision with root package name */
    public final h f395704a;

    public e(h hVar) {
        this.f395704a = hVar;
    }

    @Override // c45.g
    public final <T extends c45.d> void a(T t16) {
        t16.writeMessage(this);
    }

    public final void b(int i3, c45.b bVar, Object obj) {
        if (!f.a(bVar, obj) || obj == null) {
            return;
        }
        c(i3, bVar, obj);
    }

    public final void c(int i3, c45.b bVar, Object obj) {
        int collectionSizeOrDefault;
        Set set;
        if (bVar instanceof b.e) {
            h hVar = this.f395704a;
            b.e eVar = (b.e) bVar;
            if (eVar instanceof b.e.c) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
                hVar.g(i3, ((Double) obj).doubleValue());
                return;
            }
            if (eVar instanceof b.e.d) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                hVar.d(i3, ((Float) obj).floatValue());
                return;
            }
            if (eVar instanceof b.e.f) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                hVar.c(i3, ((Long) obj).longValue());
                return;
            }
            if (eVar instanceof b.e.i) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                hVar.i(i3, ((Long) obj).longValue());
                return;
            }
            if (eVar instanceof b.e.C0168e) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                hVar.e(i3, ((Integer) obj).intValue());
                return;
            }
            if (eVar instanceof b.e.a) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                hVar.b(i3, ((Boolean) obj).booleanValue());
                return;
            }
            if (eVar instanceof b.e.g) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                hVar.a(i3, (String) obj);
                return;
            } else if (eVar instanceof b.e.C0167b) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                hVar.k(i3, (c45.a) obj);
                return;
            } else {
                if (eVar instanceof b.e.h) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    hVar.f(i3, ((Integer) obj).intValue());
                    return;
                }
                return;
            }
        }
        if (bVar instanceof b.c) {
            ((b.c) bVar).getClass();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.Message");
            c45.d dVar = (c45.d) obj;
            this.f395704a.l(i3, dVar.getProtoSize());
            dVar.writeMessage(this);
            return;
        }
        if (bVar instanceof b.d) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageNew");
            l lVar = (l) obj;
            this.f395704a.l(i3, lVar.getProtoSize());
            lVar.writeMessage(this);
            return;
        }
        if (bVar instanceof b.a) {
            h hVar2 = this.f395704a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            hVar2.h(i3, ((Integer) obj).intValue());
            return;
        }
        if (bVar instanceof b.f) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List<?> list = (List) obj;
            b.f fVar = (b.f) bVar;
            c45.b bVar2 = fVar.f30309a;
            if (fVar.f30310b) {
                this.f395704a.j(i3, list, bVar2);
                return;
            }
            for (Object obj2 : list) {
                if (obj2 != null) {
                    c(i3, bVar2, obj2);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            return;
        }
        if (bVar instanceof b.C0166b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            Map map = (Map) obj;
            b.C0166b c0166b = (b.C0166b) bVar;
            pbandk.a aVar = map instanceof pbandk.a ? (pbandk.a) map : null;
            if (aVar == null) {
                Set<Map.Entry> entrySet = map.entrySet();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (Map.Entry entry : entrySet) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    a.c.C11000a<K, V> c11000a = c0166b.f30295a;
                    Intrinsics.checkNotNull(c11000a, "null cannot be cast to non-null type pbandk.MessageMap.Entry.Companion<kotlin.Any?, kotlin.Any?>");
                    MapsKt__MapsKt.emptyMap();
                    arrayList.add(new a.c(key, value, c11000a));
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList);
                aVar = new pbandk.a(set);
            }
            Iterator it = aVar.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                Intrinsics.checkNotNull(entry2, "null cannot be cast to non-null type pbandk.MessageMap.Entry<*, *>");
                a.c cVar = (a.c) entry2;
                this.f395704a.l(i3, cVar.getProtoSize());
                cVar.writeMessage(this);
            }
        }
    }
}
