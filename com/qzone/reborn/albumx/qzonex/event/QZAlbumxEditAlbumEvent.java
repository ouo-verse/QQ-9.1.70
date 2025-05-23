package com.qzone.reborn.albumx.qzonex.event;

import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxEditAlbumEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "qzoneId", "", "deleteAlbum", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "addAlbum", "(Ljava/lang/String;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "getAddAlbum", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getDeleteAlbum", "getEditAlbum", "getQzoneId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZAlbumxEditAlbumEvent extends SimpleBaseEvent {
    private final CommonAlbumInfo addAlbum;
    private final CommonAlbumInfo deleteAlbum;
    private final CommonAlbumInfo editAlbum;
    private final String qzoneId;

    public /* synthetic */ QZAlbumxEditAlbumEvent(String str, CommonAlbumInfo commonAlbumInfo, CommonAlbumInfo commonAlbumInfo2, CommonAlbumInfo commonAlbumInfo3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : commonAlbumInfo, (i3 & 4) != 0 ? null : commonAlbumInfo2, (i3 & 8) != 0 ? null : commonAlbumInfo3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQzoneId() {
        return this.qzoneId;
    }

    /* renamed from: component2, reason: from getter */
    public final CommonAlbumInfo getDeleteAlbum() {
        return this.deleteAlbum;
    }

    /* renamed from: component3, reason: from getter */
    public final CommonAlbumInfo getEditAlbum() {
        return this.editAlbum;
    }

    /* renamed from: component4, reason: from getter */
    public final CommonAlbumInfo getAddAlbum() {
        return this.addAlbum;
    }

    public final QZAlbumxEditAlbumEvent copy(String qzoneId, CommonAlbumInfo deleteAlbum, CommonAlbumInfo editAlbum, CommonAlbumInfo addAlbum) {
        Intrinsics.checkNotNullParameter(qzoneId, "qzoneId");
        return new QZAlbumxEditAlbumEvent(qzoneId, deleteAlbum, editAlbum, addAlbum);
    }

    public final CommonAlbumInfo getAddAlbum() {
        return this.addAlbum;
    }

    public final CommonAlbumInfo getDeleteAlbum() {
        return this.deleteAlbum;
    }

    public final CommonAlbumInfo getEditAlbum() {
        return this.editAlbum;
    }

    public final String getQzoneId() {
        return this.qzoneId;
    }

    public int hashCode() {
        int hashCode = this.qzoneId.hashCode() * 31;
        CommonAlbumInfo commonAlbumInfo = this.deleteAlbum;
        int hashCode2 = (hashCode + (commonAlbumInfo == null ? 0 : commonAlbumInfo.hashCode())) * 31;
        CommonAlbumInfo commonAlbumInfo2 = this.editAlbum;
        int hashCode3 = (hashCode2 + (commonAlbumInfo2 == null ? 0 : commonAlbumInfo2.hashCode())) * 31;
        CommonAlbumInfo commonAlbumInfo3 = this.addAlbum;
        return hashCode3 + (commonAlbumInfo3 != null ? commonAlbumInfo3.hashCode() : 0);
    }

    public String toString() {
        return "QZAlbumxEditAlbumEvent(qzoneId=" + this.qzoneId + ", deleteAlbum=" + this.deleteAlbum + ", editAlbum=" + this.editAlbum + ", addAlbum=" + this.addAlbum + ")";
    }

    public QZAlbumxEditAlbumEvent(String qzoneId, CommonAlbumInfo commonAlbumInfo, CommonAlbumInfo commonAlbumInfo2, CommonAlbumInfo commonAlbumInfo3) {
        Intrinsics.checkNotNullParameter(qzoneId, "qzoneId");
        this.qzoneId = qzoneId;
        this.deleteAlbum = commonAlbumInfo;
        this.editAlbum = commonAlbumInfo2;
        this.addAlbum = commonAlbumInfo3;
    }

    public static /* synthetic */ QZAlbumxEditAlbumEvent copy$default(QZAlbumxEditAlbumEvent qZAlbumxEditAlbumEvent, String str, CommonAlbumInfo commonAlbumInfo, CommonAlbumInfo commonAlbumInfo2, CommonAlbumInfo commonAlbumInfo3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qZAlbumxEditAlbumEvent.qzoneId;
        }
        if ((i3 & 2) != 0) {
            commonAlbumInfo = qZAlbumxEditAlbumEvent.deleteAlbum;
        }
        if ((i3 & 4) != 0) {
            commonAlbumInfo2 = qZAlbumxEditAlbumEvent.editAlbum;
        }
        if ((i3 & 8) != 0) {
            commonAlbumInfo3 = qZAlbumxEditAlbumEvent.addAlbum;
        }
        return qZAlbumxEditAlbumEvent.copy(str, commonAlbumInfo, commonAlbumInfo2, commonAlbumInfo3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZAlbumxEditAlbumEvent)) {
            return false;
        }
        QZAlbumxEditAlbumEvent qZAlbumxEditAlbumEvent = (QZAlbumxEditAlbumEvent) other;
        return Intrinsics.areEqual(this.qzoneId, qZAlbumxEditAlbumEvent.qzoneId) && Intrinsics.areEqual(this.deleteAlbum, qZAlbumxEditAlbumEvent.deleteAlbum) && Intrinsics.areEqual(this.editAlbum, qZAlbumxEditAlbumEvent.editAlbum) && Intrinsics.areEqual(this.addAlbum, qZAlbumxEditAlbumEvent.addAlbum);
    }
}
