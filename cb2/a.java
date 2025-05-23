package cb2;

import bb2.SortCluster;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcb2/a;", "Lcb2/b;", "", "e", "Lbb2/f;", "sortedClusterData", "Lda2/b;", "l", "", "f", "g", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull TencentMap tencentMap) {
        super(tencentMap);
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
    }

    @Override // cb2.b
    @NotNull
    public String e() {
        return "NBP.Cluster_Area";
    }

    @Override // cb2.b
    public int f() {
        return 20000;
    }

    @Override // cb2.b
    public int g() {
        return 10000;
    }

    @Override // cb2.b
    @NotNull
    public da2.b l(@NotNull SortCluster sortedClusterData) {
        Intrinsics.checkNotNullParameter(sortedClusterData, "sortedClusterData");
        return sortedClusterData.getCenterInfo();
    }
}
