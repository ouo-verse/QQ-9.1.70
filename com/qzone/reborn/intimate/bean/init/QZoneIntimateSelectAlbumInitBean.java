package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateSelectAlbumInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "spaceId", "", "source", "Lcom/qzone/reborn/intimate/bean/init/Source;", "albumId", "(Ljava/lang/String;Lcom/qzone/reborn/intimate/bean/init/Source;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "getSource", "()Lcom/qzone/reborn/intimate/bean/init/Source;", "getSpaceId", "isFromUploadAlbum", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateSelectAlbumInitBean extends QZoneIntimateInitBean {
    private final String albumId;
    private final Source source;
    private final String spaceId;

    public /* synthetic */ QZoneIntimateSelectAlbumInitBean(String str, Source source, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? Source.UPLOAD_ALBUM : source, (i3 & 4) != 0 ? null : str2);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final boolean isFromUploadAlbum() {
        return this.source == Source.UPLOAD_ALBUM;
    }

    public QZoneIntimateSelectAlbumInitBean(String spaceId, Source source, String str) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.spaceId = spaceId;
        this.source = source;
        this.albumId = str;
    }
}
