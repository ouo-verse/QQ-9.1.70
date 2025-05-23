package db;

import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Ldb/b;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "", "b", "Z", "isSelect", "()Z", "setSelect", "(Z)V", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AlbumInfo albumInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isSelect;

    public b(AlbumInfo albumInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.albumInfo = albumInfo;
        this.isSelect = z16;
    }

    /* renamed from: a, reason: from getter */
    public final AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public /* synthetic */ b(AlbumInfo albumInfo, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(albumInfo, (i3 & 2) != 0 ? false : z16);
    }
}
