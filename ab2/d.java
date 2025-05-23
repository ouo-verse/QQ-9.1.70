package ab2;

import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bR\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lab2/d;", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/MarkerOptions;", "opt", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "a", "Lcom/tencent/tencentmap/mapsdk/maps/Projection;", "c", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "b", "Lmqq/util/WeakReference;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "mapProxy", "map", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<TencentMap> mapProxy;

    public d(@NotNull TencentMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.mapProxy = new WeakReference<>(map);
    }

    @Nullable
    public final Marker a(@Nullable MarkerOptions opt) {
        TencentMap tencentMap = this.mapProxy.get();
        if (tencentMap != null && !tencentMap.isDestroyed()) {
            return tencentMap.addMarker(opt);
        }
        return null;
    }

    @Nullable
    public final CameraPosition b() {
        TencentMap tencentMap = this.mapProxy.get();
        if (tencentMap != null && !tencentMap.isDestroyed()) {
            return tencentMap.getCameraPosition();
        }
        return null;
    }

    @Nullable
    public final Projection c() {
        TencentMap tencentMap = this.mapProxy.get();
        if (tencentMap != null && !tencentMap.isDestroyed()) {
            return tencentMap.getProjection();
        }
        return null;
    }
}
