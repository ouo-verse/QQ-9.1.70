package c45;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j implements l {
    public static final int $stable = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((h) t16).f30319a), Integer.valueOf(((h) t17).f30319a));
            return compareValues;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((h) t16).f30319a), Integer.valueOf(((h) t17).f30319a));
            return compareValues;
        }
    }

    public j decodeWith(f fVar) {
        throw new Error("Not yet implemented");
    }

    public Map<Integer, h> getIndexes() {
        Map<Integer, h> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // c45.e
    public int getProtoSize() {
        List<h> sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(getIndexes().values(), new a());
        int i3 = 0;
        for (h hVar : sortedWith) {
            i3 += e45.i.f395705a.a(hVar.f30319a, hVar.f30321c, hVar.f30320b);
        }
        return i3;
    }

    @Override // c45.l
    public void writeMessage(g gVar) {
        List<h> sortedWith;
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(getIndexes().values(), new b());
        for (h hVar : sortedWith) {
            eVar.b(hVar.f30319a, hVar.f30321c, hVar.f30320b);
        }
    }

    public void setValue(int i3, Object obj) {
    }
}
