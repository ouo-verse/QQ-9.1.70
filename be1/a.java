package be1;

import com.tencent.mobileqq.gamecenter.qa.util.j;
import com.tencent.qqnt.chats.biz.eventprocessor.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lbe1/a;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/a$a;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "a", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements a.InterfaceC9564a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: be1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C0121a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((g) t17).s().msgTime), Long.valueOf(((g) t16).s().msgTime));
            return compareValues;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.a.InterfaceC9564a
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        List sortedWith;
        Object obj;
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            g gVar = null;
            if (b16 != null) {
                obj = b16.get("click_recent_data");
            } else {
                obj = null;
            }
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((g) next).n() == 1) {
                z16 = true;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new C0121a());
        HashSet hashSet = new HashSet();
        ArrayList<g> arrayList3 = new ArrayList();
        for (Object obj2 : sortedWith) {
            if (hashSet.add(Long.valueOf(((g) obj2).l()))) {
                arrayList3.add(obj2);
            }
        }
        for (g gVar2 : arrayList3) {
            j.Companion companion = j.INSTANCE;
            if (companion.d(String.valueOf(gVar2.l()))) {
                companion.i(gVar2, false);
            }
        }
    }
}
