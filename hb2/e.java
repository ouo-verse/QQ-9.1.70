package hb2;

import com.tencent.mobileqq.nearbypro.map.marker.status.StatusClusterView;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\u000e"}, d2 = {"Lhb2/e;", "Lfb2/a;", "Lhb2/b;", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "bean", "marker", "Lbb2/d;", "Lda2/b;", "b", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends fb2.a<b, Marker> {
    @Override // fb2.a
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bb2.d<? extends da2.b> a(@NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull b bean, @NotNull Marker marker) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(marker, "marker");
        StatusClusterView statusClusterView = new StatusClusterView(host.getContext(), host);
        statusClusterView.g(bean);
        return statusClusterView;
    }
}
