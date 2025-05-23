package hb2;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R2\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lhb2/c;", "Lda2/b;", "", "b", "Ljava/util/ArrayList;", "Lhb2/b;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "setStatusInfoLi", "(Ljava/util/ArrayList;)V", "statusInfoLi", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", com.tencent.luggage.wxa.c8.c.G, "<init>", "(Ljava/util/ArrayList;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends da2.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<b> statusInfoLi;

    public /* synthetic */ c(ArrayList arrayList, LatLng latLng, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i3 & 2) != 0 ? new LatLng() : latLng);
    }

    @Override // da2.b
    @NotNull
    public String b() {
        return "";
    }

    @NotNull
    public final ArrayList<b> d() {
        return this.statusInfoLi;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ArrayList<b> statusInfoLi, @NotNull LatLng pos) {
        super(pos);
        Intrinsics.checkNotNullParameter(statusInfoLi, "statusInfoLi");
        Intrinsics.checkNotNullParameter(pos, "pos");
        this.statusInfoLi = statusInfoLi;
    }
}
