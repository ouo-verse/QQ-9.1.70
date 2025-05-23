package fb2;

import android.view.View;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B\u001f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lfb2/b;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$InfoWindowAdapter;", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "markerBean", "Landroid/view/View;", "a", "Ljava/lang/Class;", "Lda2/b;", "clz", "Lfb2/a;", "", "b", "marker", "getInfoWindow", "getInfoContents", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "d", "Ljava/lang/ref/WeakReference;", "hostWeakReference", "Lfb2/d;", "e", "Lfb2/d;", "configTypes", "<init>", "(Ljava/lang/ref/WeakReference;Lfb2/d;)V", "f", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b implements TencentMap.InfoWindowAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<com.tencent.mobileqq.nearbypro.part.a> hostWeakReference;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d configTypes;

    public b(@NotNull WeakReference<com.tencent.mobileqq.nearbypro.part.a> hostWeakReference, @NotNull d configTypes) {
        Intrinsics.checkNotNullParameter(hostWeakReference, "hostWeakReference");
        Intrinsics.checkNotNullParameter(configTypes, "configTypes");
        this.hostWeakReference = hostWeakReference;
        this.configTypes = configTypes;
    }

    private final View a(Marker markerBean) {
        MarkerOptions markerOptions;
        bb2.e eVar;
        View view = null;
        if (markerBean != null) {
            markerOptions = markerBean.getOptions();
        } else {
            markerOptions = null;
        }
        if (markerOptions instanceof bb2.e) {
            eVar = (bb2.e) markerOptions;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            j.c().d("NBP.MainMapWindowAdapter", "markerOpt==null, create empty markView");
            return new View(BaseApplication.getContext());
        }
        bb2.d<da2.b> b16 = eVar.b();
        if (b16 != null) {
            view = b16.d();
        }
        if (view != null) {
            return view;
        }
        com.tencent.mobileqq.nearbypro.part.a aVar = this.hostWeakReference.get();
        if (aVar == null) {
            j.c().d("NBP.MainMapWindowAdapter", "host==null, create empty markView");
            return new View(BaseApplication.getContext());
        }
        da2.b b17 = db2.a.f393512a.b(eVar.getSortCluster());
        bb2.d<? extends da2.b> a16 = b(b17.getClass()).a(aVar, b17, markerBean);
        a16.f(aVar);
        eVar.a(a16);
        return a16.d();
    }

    private final a<Object, Marker> b(Class<? extends da2.b> clz) {
        a<Object, Marker> b16 = this.configTypes.a(clz).b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.nearbypro.map.marker.multitype.AbstractMarkerDelegate<kotlin.Any, com.tencent.tencentmap.mapsdk.maps.model.Marker>");
        return b16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    @NotNull
    public View getInfoContents(@Nullable Marker marker) {
        return a(marker);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    @NotNull
    public View getInfoWindow(@Nullable Marker marker) {
        return a(marker);
    }

    public /* synthetic */ b(WeakReference weakReference, d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, (i3 & 2) != 0 ? new db2.b() : dVar);
    }
}
