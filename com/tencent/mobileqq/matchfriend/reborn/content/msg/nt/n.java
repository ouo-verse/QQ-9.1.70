package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/n;", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contactList", "", "isGuildUpdate", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class n implements com.tencent.qqnt.chats.main.vm.datasource.preprocess.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f244703d;

        public a(List list) {
            this.f244703d = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f244703d.indexOf(Long.valueOf(((RecentContactInfo) t16).contactId))), Integer.valueOf(this.f244703d.indexOf(Long.valueOf(((RecentContactInfo) t17).contactId))));
            return compareValues;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.preprocess.d
    public List<Long> a(List<Long> sortedContactList, List<RecentContactInfo> contactList, boolean isGuildUpdate) {
        List sortedWith;
        List plus;
        Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : contactList) {
            RecentContactInfo recentContactInfo = (RecentContactInfo) obj;
            if (recentContactInfo.topFlag == 1 && sortedContactList.contains(Long.valueOf(recentContactInfo.contactId))) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a(sortedContactList));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((RecentContactInfo) it.next()).contactId));
        }
        if (arrayList2.isEmpty()) {
            return sortedContactList;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : sortedContactList) {
            if (!arrayList2.contains(Long.valueOf(((Number) obj2).longValue()))) {
                arrayList3.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
        return new ArrayList(plus);
    }
}
