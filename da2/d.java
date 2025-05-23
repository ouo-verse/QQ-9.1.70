package da2;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lda2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "a", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "b", "()Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "d", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "latLng", "I", "()I", "c", "(I)V", "dis", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;I)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LatLng latLng;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int dis;

    public d() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getDis() {
        return this.dis;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LatLng getLatLng() {
        return this.latLng;
    }

    public final void c(int i3) {
        this.dis = i3;
    }

    public final void d(@NotNull LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "<set-?>");
        this.latLng = latLng;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.latLng, dVar.latLng) && this.dis == dVar.dis) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.latLng.hashCode() * 31) + this.dis;
    }

    @NotNull
    public String toString() {
        LatLng latLng = this.latLng;
        return "{lat:" + latLng.latitude + " lnt:" + latLng.longitude + " dis:" + this.dis + "}";
    }

    public d(@NotNull LatLng latLng, int i3) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        this.latLng = latLng;
        this.dis = i3;
    }

    public /* synthetic */ d(LatLng latLng, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new LatLng() : latLng, (i16 & 2) != 0 ? 0 : i3);
    }
}
