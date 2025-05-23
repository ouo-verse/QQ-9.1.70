package bb2;

import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R \u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lbb2/e;", "Lcom/tencent/tencentmap/mapsdk/maps/model/MarkerOptions;", "Lbb2/d;", "Lda2/b;", "b", "", "obj", "", "equals", "infoView", "", "a", "Lbb2/f;", "sortCluster", "d", "c", "Lbb2/f;", "Lbb2/d;", "markerView", "<init>", "(Lbb2/f;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e extends MarkerOptions {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SortCluster sortCluster;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d<? extends da2.b> markerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull SortCluster sortCluster) {
        super(sortCluster.h());
        Intrinsics.checkNotNullParameter(sortCluster, "sortCluster");
        this.sortCluster = sortCluster;
    }

    public final void a(@Nullable d<? extends da2.b> infoView) {
        this.markerView = infoView;
    }

    @Nullable
    public d<da2.b> b() {
        return this.markerView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final SortCluster getSortCluster() {
        return this.sortCluster;
    }

    public final void d(@NotNull SortCluster sortCluster) {
        Intrinsics.checkNotNullParameter(sortCluster, "sortCluster");
        this.sortCluster = sortCluster;
        position(sortCluster.h());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof e) {
            return Intrinsics.areEqual(this.sortCluster, ((e) obj).sortCluster);
        }
        return super.equals(obj);
    }
}
