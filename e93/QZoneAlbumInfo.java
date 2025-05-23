package e93;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Le93/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Le93/k;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setAlbumList", "(Ljava/util/List;)V", "albumList", "b", "I", "()I", "albumMediaTotalNum", "<init>", "(Ljava/util/List;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e93.j, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class QZoneAlbumInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<QZoneAlbumStruct> albumList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int albumMediaTotalNum;

    public QZoneAlbumInfo(@NotNull List<QZoneAlbumStruct> albumList, int i3) {
        Intrinsics.checkNotNullParameter(albumList, "albumList");
        this.albumList = albumList;
        this.albumMediaTotalNum = i3;
    }

    @NotNull
    public final List<QZoneAlbumStruct> a() {
        return this.albumList;
    }

    /* renamed from: b, reason: from getter */
    public final int getAlbumMediaTotalNum() {
        return this.albumMediaTotalNum;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneAlbumInfo)) {
            return false;
        }
        QZoneAlbumInfo qZoneAlbumInfo = (QZoneAlbumInfo) other;
        if (Intrinsics.areEqual(this.albumList, qZoneAlbumInfo.albumList) && this.albumMediaTotalNum == qZoneAlbumInfo.albumMediaTotalNum) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.albumList.hashCode() * 31) + this.albumMediaTotalNum;
    }

    @NotNull
    public String toString() {
        return "QZoneAlbumInfo(albumList=" + this.albumList + ", albumMediaTotalNum=" + this.albumMediaTotalNum + ")";
    }
}
