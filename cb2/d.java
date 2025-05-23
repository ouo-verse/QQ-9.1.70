package cb2;

import bb2.SortCluster;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\t\u001a\u00020\b2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcb2/d;", "Lcb2/b;", "", "e", "Ljava/util/LinkedHashMap;", "Lbb2/f;", "Lkotlin/collections/LinkedHashMap;", "clusters", "", "c", "sortedClusterData", "Lda2/b;", "l", "", "f", "g", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends b {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Comparator<Map.Entry<String, SortCluster>> f30562h = new Comparator() { // from class: cb2.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int p16;
            p16 = d.p((Map.Entry) obj, (Map.Entry) obj2);
            return p16;
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull TencentMap tencentMap) {
        super(tencentMap);
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(Map.Entry entry, Map.Entry entry2) {
        da2.b centerInfo = ((SortCluster) entry.getValue()).getCenterInfo();
        Intrinsics.checkNotNull(centerInfo, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem");
        int i3 = ((hb2.b) centerInfo).getData().f448304i;
        da2.b centerInfo2 = ((SortCluster) entry2.getValue()).getCenterInfo();
        Intrinsics.checkNotNull(centerInfo2, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem");
        return Intrinsics.compare(i3, ((hb2.b) centerInfo2).getData().f448304i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cb2.b
    public void c(@NotNull LinkedHashMap<String, SortCluster> clusters) {
        Intrinsics.checkNotNullParameter(clusters, "clusters");
        ArrayList<Map.Entry> arrayList = new ArrayList(clusters.entrySet());
        Collections.sort(arrayList, f30562h);
        clusters.clear();
        for (Map.Entry entry : arrayList) {
            clusters.put(entry.getKey(), entry.getValue());
        }
    }

    @Override // cb2.b
    @NotNull
    public String e() {
        return "NBP.Cluster_Status";
    }

    @Override // cb2.b
    public int f() {
        return 10000;
    }

    @Override // cb2.b
    public int g() {
        return 10000;
    }

    @Override // cb2.b
    @NotNull
    public da2.b l(@NotNull SortCluster sortedClusterData) {
        Intrinsics.checkNotNullParameter(sortedClusterData, "sortedClusterData");
        if (sortedClusterData.j()) {
            return sortedClusterData.getCenterInfo();
        }
        ArrayList<da2.b> g16 = sortedClusterData.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem> }");
        return new hb2.c(g16, null, 2, null);
    }
}
