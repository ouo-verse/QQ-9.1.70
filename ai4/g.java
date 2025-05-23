package ai4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yh4.ReceiverInfoModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000\u00a8\u0006\u0007"}, d2 = {"", "Lyh4/b;", "rawReceiverList", "", "c", "a", "b", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((ReceiverInfoModel) t16).getPriority()), Integer.valueOf(((ReceiverInfoModel) t17).getPriority()));
            return compareValues;
        }
    }

    @NotNull
    public static final List<ReceiverInfoModel> a(@NotNull List<ReceiverInfoModel> rawReceiverList) {
        List<ReceiverInfoModel> mutableList;
        Intrinsics.checkNotNullParameter(rawReceiverList, "rawReceiverList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : rawReceiverList) {
            if (hashSet.add(Long.valueOf(((ReceiverInfoModel) obj).getUid().uid.get()))) {
                arrayList.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    @NotNull
    public static final List<ReceiverInfoModel> b(@NotNull List<ReceiverInfoModel> rawReceiverList) {
        List<ReceiverInfoModel> mutableList;
        Intrinsics.checkNotNullParameter(rawReceiverList, "rawReceiverList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : rawReceiverList) {
            if (hashSet.add(Long.valueOf(((ReceiverInfoModel) obj).getUid().yes_uid.get()))) {
                arrayList.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return mutableList;
    }

    @NotNull
    public static final List<ReceiverInfoModel> c(@NotNull List<ReceiverInfoModel> rawReceiverList) {
        List sortedWith;
        List<ReceiverInfoModel> mutableList;
        Intrinsics.checkNotNullParameter(rawReceiverList, "rawReceiverList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(rawReceiverList, new a());
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) sortedWith);
        return mutableList;
    }
}
