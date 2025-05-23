package bb2;

import android.text.TextUtils;
import com.tencent.mobileqq.nearbypro.map.cluster.algorithm.BaseClusterAlgorithm;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BU\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020 j\b\u0012\u0004\u0012\u00020\u0002`!\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00108\u001a\u00020\b\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\bJ.\u0010\u0015\u001a\u00020\u00062&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u0013J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0018\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u000eH\u00d6\u0001R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR2\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020 j\b\u0012\u0004\u0012\u00020\u0002`!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00106\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00107\u00a8\u0006;"}, d2 = {"Lbb2/f;", "", "Lda2/b;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", h.F, "infoData", "", "a", "", "key", "", "b", "", "f", "", "i", "j", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lastClusterMap", "k", "obj", "equals", "toString", "hashCode", "Lda2/b;", "d", "()Lda2/b;", "setCenterInfo", "(Lda2/b;)V", "centerInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "list", "Z", "e", "()Z", "l", "(Z)V", "forceNoCluster", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "getFromLatLng", "()Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "setFromLatLng", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "fromLatLng", "getTargetLatLng", "setTargetLatLng", "targetLatLng", "Ljava/lang/String;", "clusterKey", "<init>", "(Lda2/b;Ljava/util/ArrayList;ZLcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: bb2.f, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class SortCluster {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private da2.b centerInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<da2.b> list;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean forceNoCluster;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private LatLng fromLatLng;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private LatLng targetLatLng;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String clusterKey;

    public SortCluster(@NotNull da2.b centerInfo, @NotNull ArrayList<da2.b> list, boolean z16, @Nullable LatLng latLng, @Nullable LatLng latLng2, @NotNull String clusterKey) {
        Intrinsics.checkNotNullParameter(centerInfo, "centerInfo");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(clusterKey, "clusterKey");
        this.centerInfo = centerInfo;
        this.list = list;
        this.forceNoCluster = z16;
        this.fromLatLng = latLng;
        this.targetLatLng = latLng2;
        this.clusterKey = clusterKey;
    }

    public final void a(@NotNull da2.b infoData) {
        Intrinsics.checkNotNullParameter(infoData, "infoData");
        if (b(infoData.b())) {
            return;
        }
        this.list.add(infoData);
    }

    public final boolean b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<da2.b> it = this.list.iterator();
        while (it.hasNext()) {
            da2.b next = it.next();
            if (!TextUtils.isEmpty(key) && Intrinsics.areEqual(key, next.b())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getClusterKey() {
        return this.clusterKey;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final da2.b getCenterInfo() {
        return this.centerInfo;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getForceNoCluster() {
        return this.forceNoCluster;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SortCluster) {
            SortCluster sortCluster = (SortCluster) obj;
            if (Intrinsics.areEqual(this.clusterKey, sortCluster.clusterKey) && i() == sortCluster.i() && Intrinsics.areEqual(f(), sortCluster.f())) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    @NotNull
    public Collection<da2.b> f() {
        return this.list;
    }

    @NotNull
    public final ArrayList<da2.b> g() {
        return this.list;
    }

    @NotNull
    public LatLng h() {
        return this.centerInfo.getCom.tencent.luggage.wxa.c8.c.G java.lang.String();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.centerInfo.hashCode() * 31) + this.list.hashCode()) * 31;
        boolean z16 = this.forceNoCluster;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        LatLng latLng = this.fromLatLng;
        int i17 = 0;
        if (latLng == null) {
            hashCode = 0;
        } else {
            hashCode = latLng.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        LatLng latLng2 = this.targetLatLng;
        if (latLng2 != null) {
            i17 = latLng2.hashCode();
        }
        return ((i18 + i17) * 31) + this.clusterKey.hashCode();
    }

    public int i() {
        return this.list.size();
    }

    public final boolean j() {
        if (i() <= 1) {
            return true;
        }
        return false;
    }

    public final void k(@Nullable HashMap<String, SortCluster> lastClusterMap) {
        Collections.sort(this.list, BaseClusterAlgorithm.f253404k.a());
        Iterator<da2.b> it = this.list.iterator();
        SortCluster sortCluster = null;
        da2.b bVar = null;
        while (it.hasNext()) {
            da2.b next = it.next();
            if (lastClusterMap != null && lastClusterMap.containsKey(next.b())) {
                SortCluster sortCluster2 = lastClusterMap.get(next.b());
                Intrinsics.checkNotNull(sortCluster2);
                SortCluster sortCluster3 = sortCluster2;
                if (!sortCluster3.forceNoCluster) {
                    if (sortCluster == null || sortCluster3.i() > sortCluster.i()) {
                        sortCluster = sortCluster3;
                    }
                }
            }
            if (bVar == null) {
                bVar = next;
            }
        }
        if (sortCluster != null) {
            bVar = sortCluster.centerInfo;
        }
        if (bVar != null) {
            this.centerInfo = bVar;
            this.clusterKey = bVar.b();
        }
    }

    public final void l(boolean z16) {
        this.forceNoCluster = z16;
    }

    @NotNull
    public String toString() {
        return "SortCluster(centerInfo=" + this.centerInfo + ", list=" + this.list + ", forceNoCluster=" + this.forceNoCluster + ", fromLatLng=" + this.fromLatLng + ", targetLatLng=" + this.targetLatLng + ", clusterKey=" + this.clusterKey + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SortCluster(da2.b bVar, ArrayList arrayList, boolean z16, LatLng latLng, LatLng latLng2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, arrayList, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? null : latLng, (i3 & 16) != 0 ? null : latLng2, (i3 & 32) != 0 ? bVar.b() : str);
        if ((i3 & 2) != 0) {
            arrayList = new ArrayList();
            arrayList.add(bVar);
        }
    }
}
