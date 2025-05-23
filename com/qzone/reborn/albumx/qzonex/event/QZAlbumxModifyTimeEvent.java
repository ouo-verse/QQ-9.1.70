package com.qzone.reborn.albumx.qzonex.event;

import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxModifyTimeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mediaList", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "(Ljava/util/ArrayList;)V", "getMediaList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZAlbumxModifyTimeEvent extends SimpleBaseEvent {
    private final ArrayList<CommonStMedia> mediaList;

    public QZAlbumxModifyTimeEvent(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this.mediaList = mediaList;
    }

    public final ArrayList<CommonStMedia> component1() {
        return this.mediaList;
    }

    public final QZAlbumxModifyTimeEvent copy(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        return new QZAlbumxModifyTimeEvent(mediaList);
    }

    public final ArrayList<CommonStMedia> getMediaList() {
        return this.mediaList;
    }

    public int hashCode() {
        return this.mediaList.hashCode();
    }

    public String toString() {
        return "QZAlbumxModifyTimeEvent(mediaList=" + this.mediaList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QZAlbumxModifyTimeEvent copy$default(QZAlbumxModifyTimeEvent qZAlbumxModifyTimeEvent, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = qZAlbumxModifyTimeEvent.mediaList;
        }
        return qZAlbumxModifyTimeEvent.copy(arrayList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QZAlbumxModifyTimeEvent) && Intrinsics.areEqual(this.mediaList, ((QZAlbumxModifyTimeEvent) other).mediaList);
    }
}
