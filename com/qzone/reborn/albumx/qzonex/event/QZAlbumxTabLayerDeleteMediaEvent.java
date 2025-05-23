package com.qzone.reborn.albumx.qzonex.event;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTabLayerDeleteMediaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "videoNumber", "", PhotoCategorySummaryInfo.PHOTO_NUMBER, "(II)V", "getPhotoNumber", "()I", "getVideoNumber", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxTabLayerDeleteMediaEvent extends SimpleBaseEvent {
    private final int photoNumber;
    private final int videoNumber;

    public QZAlbumxTabLayerDeleteMediaEvent(int i3, int i16) {
        this.videoNumber = i3;
        this.photoNumber = i16;
    }

    public final int getPhotoNumber() {
        return this.photoNumber;
    }

    public final int getVideoNumber() {
        return this.videoNumber;
    }
}
