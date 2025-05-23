package cb2;

import bb2.SortCluster;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcb2/e;", "Lcb2/b;", "", "e", "Lbb2/f;", "sortedClusterData", "Lda2/b;", "l", "", "f", "g", "Lbb2/e;", "options", "", h.F, "key", "", "isSinger", "i", "Ljava/lang/String;", "selfTid", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends b {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selfTid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull TencentMap tencentMap) {
        super(tencentMap);
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        this.selfTid = String.valueOf(ab2.a.f25767a.m());
    }

    @Override // cb2.b
    @NotNull
    public String e() {
        return "NBP.Cluster_User";
    }

    @Override // cb2.b
    public int f() {
        return 0;
    }

    @Override // cb2.b
    public int g() {
        return 10000;
    }

    @Override // cb2.b
    public void h(@NotNull bb2.e options) {
        Intrinsics.checkNotNullParameter(options, "options");
        super.h(options);
        if (options.getSortCluster().j() && Intrinsics.areEqual(options.getSortCluster().getClusterKey(), this.selfTid)) {
            options.zIndex(88888.0f);
        }
    }

    @Override // cb2.b
    public boolean i(@NotNull String key, boolean isSinger) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (isSinger && Intrinsics.areEqual(key, this.selfTid)) {
            return false;
        }
        return true;
    }

    @Override // cb2.b
    @NotNull
    public da2.b l(@NotNull SortCluster sortedClusterData) {
        Intrinsics.checkNotNullParameter(sortedClusterData, "sortedClusterData");
        if (sortedClusterData.j()) {
            return sortedClusterData.getCenterInfo();
        }
        ArrayList<da2.b> g16 = sortedClusterData.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.personal.UserInfoClusterItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.personal.UserInfoClusterItem> }");
        return new gb2.a(g16, null, 2, null);
    }
}
