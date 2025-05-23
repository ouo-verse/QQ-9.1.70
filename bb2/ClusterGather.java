package bb2;

import com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J0\u0010\r\u001a\u00020\u00062&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016J\t\u0010\u000e\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lbb2/a;", "Lbb2/c;", "", "zoomLevel", "", "forceCluster", "", "b", "Ljava/util/LinkedHashMap;", "", "Lbb2/f;", "Lkotlin/collections/LinkedHashMap;", "clusters", "a", "toString", "", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;", "Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;", "c", "()Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;", "algorithm", "Lcb2/b;", "Lcb2/b;", "d", "()Lcb2/b;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "<init>", "(Lcom/tencent/mobileqq/nearbypro/map/cluster/algorithm/BaseClusterAlgorithm;Lcb2/b;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bb2.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class ClusterGather implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BaseClusterAlgorithm algorithm;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final cb2.b render;

    public ClusterGather(@NotNull BaseClusterAlgorithm algorithm, @NotNull cb2.b render) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(render, "render");
        this.algorithm = algorithm;
        this.render = render;
    }

    @Override // bb2.c
    public void a(@Nullable LinkedHashMap<String, SortCluster> clusters) {
        this.render.j(clusters);
    }

    public final void b(float zoomLevel, boolean forceCluster) {
        this.algorithm.v(zoomLevel, forceCluster, this);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final BaseClusterAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final cb2.b getRender() {
        return this.render;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClusterGather)) {
            return false;
        }
        ClusterGather clusterGather = (ClusterGather) other;
        if (Intrinsics.areEqual(this.algorithm, clusterGather.algorithm) && Intrinsics.areEqual(this.render, clusterGather.render)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.algorithm.hashCode() * 31) + this.render.hashCode();
    }

    @NotNull
    public String toString() {
        return "ClusterGather(algorithm=" + this.algorithm + ", render=" + this.render + ")";
    }
}
