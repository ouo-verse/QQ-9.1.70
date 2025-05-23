package com.qzone.reborn.albumx.qzonex.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTopAndRefreshEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "albumId", "", "from", "", "(Ljava/lang/String;I)V", "getAlbumId", "()Ljava/lang/String;", "getFrom", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZAlbumxTopAndRefreshEvent extends SimpleBaseEvent {
    private final String albumId;
    private final int from;

    public QZAlbumxTopAndRefreshEvent() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    public final QZAlbumxTopAndRefreshEvent copy(String albumId, int from) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        return new QZAlbumxTopAndRefreshEvent(albumId, from);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final int getFrom() {
        return this.from;
    }

    public int hashCode() {
        return (this.albumId.hashCode() * 31) + this.from;
    }

    public String toString() {
        return "QZAlbumxTopAndRefreshEvent(albumId=" + this.albumId + ", from=" + this.from + ")";
    }

    public /* synthetic */ QZAlbumxTopAndRefreshEvent(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? -1 : i3);
    }

    public QZAlbumxTopAndRefreshEvent(String albumId, int i3) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.albumId = albumId;
        this.from = i3;
    }

    public static /* synthetic */ QZAlbumxTopAndRefreshEvent copy$default(QZAlbumxTopAndRefreshEvent qZAlbumxTopAndRefreshEvent, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qZAlbumxTopAndRefreshEvent.albumId;
        }
        if ((i16 & 2) != 0) {
            i3 = qZAlbumxTopAndRefreshEvent.from;
        }
        return qZAlbumxTopAndRefreshEvent.copy(str, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZAlbumxTopAndRefreshEvent)) {
            return false;
        }
        QZAlbumxTopAndRefreshEvent qZAlbumxTopAndRefreshEvent = (QZAlbumxTopAndRefreshEvent) other;
        return Intrinsics.areEqual(this.albumId, qZAlbumxTopAndRefreshEvent.albumId) && this.from == qZAlbumxTopAndRefreshEvent.from;
    }
}
