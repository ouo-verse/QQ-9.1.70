package com.qzone.reborn.intimate.event;

import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneIntimateUploadAlbumEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "spaceId", "", "albumId", "batchId", "", "succeedCount", "", "(Ljava/lang/String;Ljava/lang/String;JI)V", "getAlbumId", "()Ljava/lang/String;", "getBatchId", "()J", "getSpaceId", "getSucceedCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZoneIntimateUploadAlbumEvent extends SimpleBaseEvent {
    private final String albumId;
    private final long batchId;
    private final String spaceId;
    private final int succeedCount;

    public QZoneIntimateUploadAlbumEvent(String spaceId, String albumId, long j3, int i3) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.spaceId = spaceId;
        this.albumId = albumId;
        this.batchId = j3;
        this.succeedCount = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBatchId() {
        return this.batchId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSucceedCount() {
        return this.succeedCount;
    }

    public final QZoneIntimateUploadAlbumEvent copy(String spaceId, String albumId, long batchId, int succeedCount) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        return new QZoneIntimateUploadAlbumEvent(spaceId, albumId, batchId, succeedCount);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSucceedCount() {
        return this.succeedCount;
    }

    public int hashCode() {
        return (((((this.spaceId.hashCode() * 31) + this.albumId.hashCode()) * 31) + n.a(this.batchId)) * 31) + this.succeedCount;
    }

    public String toString() {
        return "QZoneIntimateUploadAlbumEvent(spaceId=" + this.spaceId + ", albumId=" + this.albumId + ", batchId=" + this.batchId + ", succeedCount=" + this.succeedCount + ")";
    }

    public static /* synthetic */ QZoneIntimateUploadAlbumEvent copy$default(QZoneIntimateUploadAlbumEvent qZoneIntimateUploadAlbumEvent, String str, String str2, long j3, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qZoneIntimateUploadAlbumEvent.spaceId;
        }
        if ((i16 & 2) != 0) {
            str2 = qZoneIntimateUploadAlbumEvent.albumId;
        }
        String str3 = str2;
        if ((i16 & 4) != 0) {
            j3 = qZoneIntimateUploadAlbumEvent.batchId;
        }
        long j16 = j3;
        if ((i16 & 8) != 0) {
            i3 = qZoneIntimateUploadAlbumEvent.succeedCount;
        }
        return qZoneIntimateUploadAlbumEvent.copy(str, str3, j16, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneIntimateUploadAlbumEvent)) {
            return false;
        }
        QZoneIntimateUploadAlbumEvent qZoneIntimateUploadAlbumEvent = (QZoneIntimateUploadAlbumEvent) other;
        return Intrinsics.areEqual(this.spaceId, qZoneIntimateUploadAlbumEvent.spaceId) && Intrinsics.areEqual(this.albumId, qZoneIntimateUploadAlbumEvent.albumId) && this.batchId == qZoneIntimateUploadAlbumEvent.batchId && this.succeedCount == qZoneIntimateUploadAlbumEvent.succeedCount;
    }
}
