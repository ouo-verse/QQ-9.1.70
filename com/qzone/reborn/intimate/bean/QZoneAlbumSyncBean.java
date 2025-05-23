package com.qzone.reborn.intimate.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "Ljava/io/Serializable;", "albumInfo", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "(Lqzone/QZoneBaseAlbumMeta$AlbumInfo;)V", "getAlbumInfo", "()Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "isDisable", "", "()Z", "setDisable", "(Z)V", "isSelected", "setSelected", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumSyncBean implements Serializable {
    private final QZoneBaseAlbumMeta$AlbumInfo albumInfo;
    private boolean isDisable;
    private boolean isSelected;

    public QZoneAlbumSyncBean(QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.albumInfo = albumInfo;
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    /* renamed from: isDisable, reason: from getter */
    public final boolean getIsDisable() {
        return this.isDisable;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setDisable(boolean z16) {
        this.isDisable = z16;
    }

    public final void setSelected(boolean z16) {
        this.isSelected = z16;
    }
}
