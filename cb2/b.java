package cb2;

import bb2.SortCluster;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104JP\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\u0005H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0007H&J,\u0010\u0014\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!J.\u0010$\u001a\u00020\t2&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0005R0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010%R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010-R\u0014\u00100\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/\u00a8\u00065"}, d2 = {"Lcb2/b;", "", "Ljava/util/LinkedHashMap;", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "Lkotlin/collections/LinkedHashMap;", "oriMarkers", "Lbb2/f;", "clusters", "", "b", "marker", "cluster", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "d", "e", "sortedClusterData", "Lda2/b;", "l", "c", "Lbb2/e;", "options", h.F, "", "f", "g", "key", "", "isSinger", "i", "sortedCluster", DomainData.DOMAIN_NAME, "Lcb2/b$a;", "renderListener", "k", "j", "Ljava/util/LinkedHashMap;", "singleMarker", "clusterMarker", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", NodeProps.Z_INDEX, "Lcb2/b$a;", "Lab2/d;", "Lab2/d;", "mapProxy", "Ljava/lang/String;", "logTag", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, Marker> singleMarker;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, Marker> clusterMarker;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger zIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a renderListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ab2.d mapProxy;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcb2/b$a;", "", "Lcb2/b;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void a(@NotNull b render);
    }

    public b(@NotNull TencentMap tencentMap) {
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        this.singleMarker = new LinkedHashMap<>();
        this.clusterMarker = new LinkedHashMap<>();
        this.zIndex = new AtomicInteger(f());
        this.mapProxy = new ab2.d(tencentMap);
        this.logTag = e();
    }

    private final Marker a(SortCluster cluster) {
        ab2.d dVar = this.mapProxy;
        bb2.e eVar = new bb2.e(cluster);
        h(eVar);
        Marker a16 = dVar.a(eVar);
        if (a16 != null) {
            a16.setPosition(cluster.h());
            a16.showInfoWindow();
            j.c().e(this.logTag, "addMarker zIndex:" + a16.getZIndex());
            return a16;
        }
        return null;
    }

    private final void b(LinkedHashMap<String, Marker> oriMarkers, LinkedHashMap<String, SortCluster> clusters) {
        Object first;
        Object first2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, SortCluster> entry : clusters.entrySet()) {
            String key = entry.getKey();
            SortCluster value = entry.getValue();
            if (oriMarkers.containsKey(key)) {
                Marker remove = oriMarkers.remove(key);
                Intrinsics.checkNotNull(remove);
                m(remove, value);
                linkedHashMap.put(key, remove);
            } else {
                linkedHashMap2.put(key, value);
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            String str = (String) entry2.getKey();
            SortCluster sortCluster = (SortCluster) entry2.getValue();
            Set<String> keySet = oriMarkers.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "oriMarkers.keys");
            if (!keySet.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first(keySet);
                Intrinsics.checkNotNullExpressionValue(first, "keys.first()");
                if (i((String) first, sortCluster.j())) {
                    first2 = CollectionsKt___CollectionsKt.first(keySet);
                    Marker remove2 = oriMarkers.remove(first2);
                    Intrinsics.checkNotNull(remove2);
                    m(remove2, sortCluster);
                    linkedHashMap.put(str, remove2);
                }
            }
            Marker a16 = a(sortCluster);
            if (a16 != null) {
                linkedHashMap.put(str, a16);
            }
        }
        for (Map.Entry<String, Marker> entry3 : oriMarkers.entrySet()) {
            if (entry3.getValue().isVisible()) {
                entry3.getValue().setVisible(false);
                j.c().e(this.logTag, "hideInfoWindow");
            }
        }
        oriMarkers.putAll(linkedHashMap);
    }

    private final String d() {
        int size = this.singleMarker.size();
        Collection<Marker> values = this.singleMarker.values();
        Intrinsics.checkNotNullExpressionValue(values, "singleMarker.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((Marker) obj).isVisible()) {
                arrayList.add(obj);
            }
        }
        int size2 = arrayList.size();
        int size3 = this.clusterMarker.size();
        Collection<Marker> values2 = this.clusterMarker.values();
        Intrinsics.checkNotNullExpressionValue(values2, "clusterMarker.values");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : values2) {
            if (((Marker) obj2).isVisible()) {
                arrayList2.add(obj2);
            }
        }
        return "singleMarker all_size:" + size + " visible_size:" + size2 + " clusterMarker all_size:" + size3 + " visible_size:" + arrayList2.size();
    }

    private final void m(Marker marker, SortCluster cluster) {
        MarkerOptions options = marker.getOptions();
        Intrinsics.checkNotNull(options, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.cluster.NBPMarkerOptions");
        bb2.e eVar = (bb2.e) options;
        eVar.d(cluster);
        bb2.d<da2.b> b16 = eVar.b();
        if (b16 != null) {
            b16.g(l(cluster));
        }
        if (!Intrinsics.areEqual(cluster.h(), marker.getPosition())) {
            marker.setPosition(cluster.h());
        }
        if (!marker.isVisible()) {
            marker.setVisible(true);
            j.c().e(this.logTag, "showInfoWindow");
        }
        if (!n(cluster)) {
            marker.refreshInfoWindow();
        }
    }

    public void c(@NotNull LinkedHashMap<String, SortCluster> clusters) {
        Intrinsics.checkNotNullParameter(clusters, "clusters");
    }

    @NotNull
    public abstract String e();

    public abstract int f();

    public abstract int g();

    public void h(@NotNull bb2.e options) {
        Intrinsics.checkNotNullParameter(options, "options");
        ab2.a.f25767a.r(options);
        if (!n(options.getSortCluster())) {
            options.alpha(1.0f);
            options.viewInfoWindow(false);
        }
        int i3 = this.zIndex.get();
        if (i3 >= f() + g()) {
            i3 = (f() + g()) - 1;
            j.c().d(this.logTag, "initMarkOptions zIndex OverSize");
        } else {
            this.zIndex.incrementAndGet();
        }
        options.zIndex(i3);
    }

    public boolean i(@NotNull String key, boolean isSinger) {
        Intrinsics.checkNotNullParameter(key, "key");
        return true;
    }

    public final void j(@Nullable LinkedHashMap<String, SortCluster> clusters) {
        LinkedHashMap<String, SortCluster> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, SortCluster> linkedHashMap2 = new LinkedHashMap<>();
        if (clusters != null) {
            c(clusters);
            for (Map.Entry<String, SortCluster> entry : clusters.entrySet()) {
                String key = entry.getKey();
                SortCluster value = entry.getValue();
                if (!value.j()) {
                    linkedHashMap2.put(key, value);
                } else {
                    linkedHashMap.put(key, value);
                }
            }
        }
        j.c().e(this.logTag, "before adjustMark:" + d());
        long currentTimeMillis = System.currentTimeMillis();
        b(this.singleMarker, linkedHashMap);
        j.c().e(this.logTag, "adjustSingle size:" + this.singleMarker.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        b(this.clusterMarker, linkedHashMap2);
        j.c().e(this.logTag, "adjustMulti size:" + linkedHashMap2.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis2));
        j.c().e(this.logTag, "after adjustMark:" + d());
        a aVar = this.renderListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final void k(@Nullable a renderListener) {
        this.renderListener = renderListener;
    }

    @NotNull
    public abstract da2.b l(@NotNull SortCluster sortedClusterData);

    public boolean n(@NotNull SortCluster sortedCluster) {
        Intrinsics.checkNotNullParameter(sortedCluster, "sortedCluster");
        return true;
    }
}
