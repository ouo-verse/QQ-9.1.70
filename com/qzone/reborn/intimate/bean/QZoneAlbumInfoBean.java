package com.qzone.reborn.intimate.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$AlbumSpaceInfo;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Ljava/io/Serializable;", "albumInfo", "Lqzone/QZIntimateSpaceAlbum$AlbumSpaceInfo;", "commonExt", "Lqzone/QZoneBaseCommon$StCommonExt;", "ownerUin", "", "(Lqzone/QZIntimateSpaceAlbum$AlbumSpaceInfo;Lqzone/QZoneBaseCommon$StCommonExt;J)V", "getAlbumInfo", "()Lqzone/QZIntimateSpaceAlbum$AlbumSpaceInfo;", "getCommonExt", "()Lqzone/QZoneBaseCommon$StCommonExt;", "getOwnerUin", "()J", "setOwnerUin", "(J)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumInfoBean implements Serializable {
    private final QZIntimateSpaceAlbum$AlbumSpaceInfo albumInfo;
    private final QZoneBaseCommon$StCommonExt commonExt;
    private long ownerUin;

    public QZoneAlbumInfoBean(QZIntimateSpaceAlbum$AlbumSpaceInfo albumInfo, QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt, long j3) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.albumInfo = albumInfo;
        this.commonExt = qZoneBaseCommon$StCommonExt;
        this.ownerUin = j3;
    }

    public final QZIntimateSpaceAlbum$AlbumSpaceInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final QZoneBaseCommon$StCommonExt getCommonExt() {
        return this.commonExt;
    }

    public final long getOwnerUin() {
        return this.ownerUin;
    }

    public final void setOwnerUin(long j3) {
        this.ownerUin = j3;
    }
}
