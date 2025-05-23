package jj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Ljj/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "a", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "()Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "albumInfo", "b", "Z", "isSelect", "()Z", "setSelect", "(Z)V", "<init>", "(Lqzone/QZoneBaseAlbumMeta$AlbumInfo;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jj.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class IntimateSelectAlbumBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final QZoneBaseAlbumMeta$AlbumInfo albumInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelect;

    public IntimateSelectAlbumBean(QZoneBaseAlbumMeta$AlbumInfo albumInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.albumInfo = albumInfo;
        this.isSelect = z16;
    }

    /* renamed from: a, reason: from getter */
    public final QZoneBaseAlbumMeta$AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.albumInfo.hashCode() * 31;
        boolean z16 = this.isSelect;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "IntimateSelectAlbumBean(albumInfo=" + this.albumInfo + ", isSelect=" + this.isSelect + ")";
    }

    public /* synthetic */ IntimateSelectAlbumBean(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(qZoneBaseAlbumMeta$AlbumInfo, (i3 & 2) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateSelectAlbumBean)) {
            return false;
        }
        IntimateSelectAlbumBean intimateSelectAlbumBean = (IntimateSelectAlbumBean) other;
        return Intrinsics.areEqual(this.albumInfo, intimateSelectAlbumBean.albumInfo) && this.isSelect == intimateSelectAlbumBean.isSelect;
    }
}
