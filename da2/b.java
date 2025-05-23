package da2;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lda2/b;", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "c", "", "a", "", "b", "toString", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LatLng pos;

    public b(@NotNull LatLng pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.pos = pos;
    }

    public boolean a() {
        return true;
    }

    @NotNull
    public abstract String b();

    @NotNull
    /* renamed from: c, reason: from getter */
    public LatLng getPos() {
        return this.pos;
    }

    @NotNull
    public String toString() {
        LatLng latLng = this.pos;
        return "pos: " + latLng.latitude + "-" + latLng.longitude;
    }
}
