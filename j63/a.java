package j63;

import i63.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lj63/a;", "Li63/b$b;", "", "Lj63/d;", "a", "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements b.InterfaceC10509b {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<Float> f409520b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<Float> f409521c;

    static {
        List<Float> listOf;
        List<Float> listOf2;
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(1.5f);
        Float valueOf3 = Float.valueOf(2.5f);
        Float valueOf4 = Float.valueOf(5.0f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{valueOf, valueOf2, valueOf3, valueOf4, Float.valueOf(7.5f)});
        f409520b = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.5f), valueOf, valueOf2, Float.valueOf(2.0f), valueOf3, valueOf4});
        f409521c = listOf2;
    }

    @Override // i63.b.InterfaceC10509b
    @NotNull
    public List<d> a() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        ArrayList arrayList = new ArrayList();
        List<Float> list = f409520b;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(new b(((Number) it.next()).floatValue()));
        }
        arrayList.addAll(arrayList2);
        List<Float> list2 = f409521c;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(new c(((Number) it5.next()).floatValue()));
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    @Override // i63.b.InterfaceC10509b
    public int b() {
        return 6;
    }
}
