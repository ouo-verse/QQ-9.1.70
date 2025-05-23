package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateDeleteAlbumFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "albumId", "", "deleteNum", "", "(Ljava/lang/String;I)V", "getAlbumId", "()Ljava/lang/String;", "getDeleteNum", "()I", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateDeleteAlbumFeedEvent extends SimpleBaseEvent {
    private final String albumId;
    private final int deleteNum;

    public QZoneIntimateDeleteAlbumFeedEvent(String albumId, int i3) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.albumId = albumId;
        this.deleteNum = i3;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final int getDeleteNum() {
        return this.deleteNum;
    }
}
