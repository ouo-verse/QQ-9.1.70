package db2;

import bb2.SortCluster;
import bb2.g;
import hb2.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Ldb2/a;", "", "Lbb2/f;", "sortedClusterData", "", "a", "Lda2/b;", "b", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f393512a = new a();

    a() {
    }

    private final boolean a(SortCluster sortedClusterData) {
        if (!g.a(sortedClusterData) && !g.e(sortedClusterData) && !g.d(sortedClusterData)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final da2.b b(@NotNull SortCluster sortedClusterData) {
        da2.b cVar;
        Intrinsics.checkNotNullParameter(sortedClusterData, "sortedClusterData");
        if (a(sortedClusterData)) {
            return sortedClusterData.getCenterInfo();
        }
        if (g.b(sortedClusterData)) {
            ArrayList<da2.b> g16 = sortedClusterData.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.personal.UserInfoClusterItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.personal.UserInfoClusterItem> }");
            cVar = new gb2.a(g16, null, 2, null);
        } else if (g.c(sortedClusterData)) {
            ArrayList<da2.b> g17 = sortedClusterData.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterItem> }");
            cVar = new c(g17, null, 2, null);
        } else {
            throw new RuntimeException("SortCluster error");
        }
        return cVar;
    }
}
