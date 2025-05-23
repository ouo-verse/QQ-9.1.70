package bb2;

import cb2.b;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\tJ&\u0010\f\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lbb2/b;", "Lcb2/b$a;", "Lbb2/a;", "gather", "", "b", "Ljava/lang/Class;", "Lda2/b;", "clazz", "", "items", "e", "d", "", "showMarker", "f", "forceCluster", "c", "Lcb2/b;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "a", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "clusterGathers", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TencentMap tencentMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<ClusterGather> clusterGathers;

    public b(@NotNull TencentMap tencentMap) {
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        this.tencentMap = tencentMap;
        this.clusterGathers = new CopyOnWriteArrayList<>();
    }

    @Override // cb2.b.a
    public void a(@NotNull cb2.b render) {
        Intrinsics.checkNotNullParameter(render, "render");
        j.c().e("NBP.Cluster", "onRenderFinish render:" + render.getClass());
    }

    public final void b(@NotNull ClusterGather gather) {
        Intrinsics.checkNotNullParameter(gather, "gather");
        this.clusterGathers.add(gather);
        gather.getRender().k(this);
    }

    public final void c(boolean forceCluster) {
        Iterator<T> it = this.clusterGathers.iterator();
        while (it.hasNext()) {
            ((ClusterGather) it.next()).b(this.tencentMap.getCameraPosition().zoom, forceCluster);
        }
    }

    public final void d(@NotNull Class<? extends da2.b> clazz, @NotNull List<? extends da2.b> items) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(items, "items");
        for (ClusterGather clusterGather : this.clusterGathers) {
            if (clusterGather.getAlgorithm().C(clazz)) {
                clusterGather.getAlgorithm().r();
                clusterGather.getAlgorithm().j(items);
                return;
            }
        }
    }

    public final void e(@NotNull Class<? extends da2.b> clazz, @NotNull List<? extends da2.b> items) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(items, "items");
        for (ClusterGather clusterGather : this.clusterGathers) {
            if (clusterGather.getAlgorithm().C(clazz)) {
                clusterGather.getAlgorithm().t();
                clusterGather.getAlgorithm().l(items);
                return;
            }
        }
    }

    public final void f(boolean showMarker) {
        Iterator<T> it = this.clusterGathers.iterator();
        while (it.hasNext()) {
            ((ClusterGather) it.next()).getAlgorithm().G(showMarker);
        }
    }
}
