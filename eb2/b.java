package eb2;

import bb2.d;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.land.AreaParam;
import com.tencent.mobileqq.nearbypro.land.LandMode;
import com.tencent.mobileqq.nearbypro.land.e;
import com.tencent.mobileqq.nearbypro.utils.i;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\u000e"}, d2 = {"Leb2/b;", "Lfb2/a;", "Leb2/a;", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "bean", "marker", "Lbb2/d;", "Lda2/b;", "b", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends fb2.a<a, Marker> {
    @Override // fb2.a
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d<? extends da2.b> a(@NotNull com.tencent.mobileqq.nearbypro.part.a host, @NotNull a bean, @NotNull Marker marker) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(marker, "marker");
        LandMode e16 = i.e(host);
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaMarkerDelegate", "onCreateMarkerView mode=" + e16);
        }
        return new e().c(host.c9()).b(new AreaParam(bean.getAreaInfo(), e16)).a(host);
    }
}
