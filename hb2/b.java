package hb2;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lhb2/b;", "Lda2/b;", "", "b", "Lxp4/a;", "c", "Lxp4/a;", "d", "()Lxp4/a;", "setData", "(Lxp4/a;)V", "data", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Lxp4/a;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends da2.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private xp4.a data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull xp4.a data, @NotNull LatLng pos) {
        super(pos);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.data = data;
    }

    @Override // da2.b
    @NotNull
    public String b() {
        String str = this.data.f448296a;
        Intrinsics.checkNotNullExpressionValue(str, "data.fid");
        return str;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final xp4.a getData() {
        return this.data;
    }
}
