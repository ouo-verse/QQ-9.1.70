package com.tencent.mobileqq.nearbypro.map.cluster.algorithm;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/h;", "Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;", "Ljava/lang/Class;", "Lda2/b;", "clazz", "", BdhLogUtil.LogTag.Tag_Conn, "", "B", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h extends BaseClusterAlgorithm {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull TencentMap tencentMap) {
        super(tencentMap);
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
    }

    @Override // com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm
    @NotNull
    public String B() {
        return "NBP.Cluster_Status";
    }

    @Override // com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm
    public boolean C(@NotNull Class<? extends da2.b> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return Intrinsics.areEqual(clazz, hb2.b.class);
    }
}
