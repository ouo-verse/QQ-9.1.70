package com.qzone.reborn.intimate.event;

import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateEditAlbumEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "spaceId", "", "deleteAlbum", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "addAlbum", "(Ljava/lang/String;Lqzone/QZoneBaseAlbumMeta$AlbumInfo;Lqzone/QZoneBaseAlbumMeta$AlbumInfo;Lqzone/QZoneBaseAlbumMeta$AlbumInfo;)V", "getAddAlbum", "()Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "getDeleteAlbum", "getEditAlbum", "getSpaceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZoneIntimateEditAlbumEvent extends SimpleBaseEvent {
    private final QZoneBaseAlbumMeta$AlbumInfo addAlbum;
    private final QZoneBaseAlbumMeta$AlbumInfo deleteAlbum;
    private final QZoneBaseAlbumMeta$AlbumInfo editAlbum;
    private final String spaceId;

    public /* synthetic */ QZoneIntimateEditAlbumEvent(String str, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo2, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : qZoneBaseAlbumMeta$AlbumInfo, (i3 & 4) != 0 ? null : qZoneBaseAlbumMeta$AlbumInfo2, (i3 & 8) != 0 ? null : qZoneBaseAlbumMeta$AlbumInfo3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: component2, reason: from getter */
    public final QZoneBaseAlbumMeta$AlbumInfo getDeleteAlbum() {
        return this.deleteAlbum;
    }

    /* renamed from: component3, reason: from getter */
    public final QZoneBaseAlbumMeta$AlbumInfo getEditAlbum() {
        return this.editAlbum;
    }

    /* renamed from: component4, reason: from getter */
    public final QZoneBaseAlbumMeta$AlbumInfo getAddAlbum() {
        return this.addAlbum;
    }

    public final QZoneIntimateEditAlbumEvent copy(String spaceId, QZoneBaseAlbumMeta$AlbumInfo deleteAlbum, QZoneBaseAlbumMeta$AlbumInfo editAlbum, QZoneBaseAlbumMeta$AlbumInfo addAlbum) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return new QZoneIntimateEditAlbumEvent(spaceId, deleteAlbum, editAlbum, addAlbum);
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getAddAlbum() {
        return this.addAlbum;
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getDeleteAlbum() {
        return this.deleteAlbum;
    }

    public final QZoneBaseAlbumMeta$AlbumInfo getEditAlbum() {
        return this.editAlbum;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public int hashCode() {
        int hashCode = this.spaceId.hashCode() * 31;
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = this.deleteAlbum;
        int hashCode2 = (hashCode + (qZoneBaseAlbumMeta$AlbumInfo == null ? 0 : qZoneBaseAlbumMeta$AlbumInfo.hashCode())) * 31;
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo2 = this.editAlbum;
        int hashCode3 = (hashCode2 + (qZoneBaseAlbumMeta$AlbumInfo2 == null ? 0 : qZoneBaseAlbumMeta$AlbumInfo2.hashCode())) * 31;
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo3 = this.addAlbum;
        return hashCode3 + (qZoneBaseAlbumMeta$AlbumInfo3 != null ? qZoneBaseAlbumMeta$AlbumInfo3.hashCode() : 0);
    }

    public String toString() {
        return "QZoneIntimateEditAlbumEvent(spaceId=" + this.spaceId + ", deleteAlbum=" + this.deleteAlbum + ", editAlbum=" + this.editAlbum + ", addAlbum=" + this.addAlbum + ")";
    }

    public QZoneIntimateEditAlbumEvent(String spaceId, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo2, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo3) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.spaceId = spaceId;
        this.deleteAlbum = qZoneBaseAlbumMeta$AlbumInfo;
        this.editAlbum = qZoneBaseAlbumMeta$AlbumInfo2;
        this.addAlbum = qZoneBaseAlbumMeta$AlbumInfo3;
    }

    public static /* synthetic */ QZoneIntimateEditAlbumEvent copy$default(QZoneIntimateEditAlbumEvent qZoneIntimateEditAlbumEvent, String str, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo2, QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qZoneIntimateEditAlbumEvent.spaceId;
        }
        if ((i3 & 2) != 0) {
            qZoneBaseAlbumMeta$AlbumInfo = qZoneIntimateEditAlbumEvent.deleteAlbum;
        }
        if ((i3 & 4) != 0) {
            qZoneBaseAlbumMeta$AlbumInfo2 = qZoneIntimateEditAlbumEvent.editAlbum;
        }
        if ((i3 & 8) != 0) {
            qZoneBaseAlbumMeta$AlbumInfo3 = qZoneIntimateEditAlbumEvent.addAlbum;
        }
        return qZoneIntimateEditAlbumEvent.copy(str, qZoneBaseAlbumMeta$AlbumInfo, qZoneBaseAlbumMeta$AlbumInfo2, qZoneBaseAlbumMeta$AlbumInfo3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneIntimateEditAlbumEvent)) {
            return false;
        }
        QZoneIntimateEditAlbumEvent qZoneIntimateEditAlbumEvent = (QZoneIntimateEditAlbumEvent) other;
        return Intrinsics.areEqual(this.spaceId, qZoneIntimateEditAlbumEvent.spaceId) && Intrinsics.areEqual(this.deleteAlbum, qZoneIntimateEditAlbumEvent.deleteAlbum) && Intrinsics.areEqual(this.editAlbum, qZoneIntimateEditAlbumEvent.editAlbum) && Intrinsics.areEqual(this.addAlbum, qZoneIntimateEditAlbumEvent.addAlbum);
    }
}
