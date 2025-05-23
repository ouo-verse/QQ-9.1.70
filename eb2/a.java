package eb2;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Leb2/a;", "Lda2/b;", "", "b", "", "a", "toString", "Lqp4/a;", "c", "Lqp4/a;", "d", "()Lqp4/a;", "setAreaInfo", "(Lqp4/a;)V", "areaInfo", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "getPos", "()Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", c.G, "<init>", "(Lqp4/a;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a extends da2.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private qp4.a areaInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LatLng pos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull qp4.a areaInfo, @NotNull LatLng pos) {
        super(pos);
        Intrinsics.checkNotNullParameter(areaInfo, "areaInfo");
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.areaInfo = areaInfo;
        this.pos = pos;
    }

    @Override // da2.b
    public boolean a() {
        return false;
    }

    @Override // da2.b
    @NotNull
    public String b() {
        LatLng latLng = this.pos;
        return latLng.latitude + "-" + latLng.longitude;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final qp4.a getAreaInfo() {
        return this.areaInfo;
    }

    @Override // da2.b
    @NotNull
    public String toString() {
        return "areaId:" + this.areaInfo.f429197a;
    }
}
