package com.qzone.reborn.albumx.qzonex.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxEditMediaEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "linkId", "", "lloc", "success", "", "desc", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getLinkId", "getLloc", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class QZAlbumxEditMediaEvent extends SimpleBaseEvent {
    private final String desc;
    private final String linkId;
    private final String lloc;
    private final boolean success;

    public QZAlbumxEditMediaEvent(String linkId, String lloc, boolean z16, String desc) {
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.linkId = linkId;
        this.lloc = lloc;
        this.success = z16;
        this.desc = desc;
    }

    /* renamed from: component1, reason: from getter */
    public final String getLinkId() {
        return this.linkId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final QZAlbumxEditMediaEvent copy(String linkId, String lloc, boolean success, String desc) {
        Intrinsics.checkNotNullParameter(linkId, "linkId");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new QZAlbumxEditMediaEvent(linkId, lloc, success, desc);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLinkId() {
        return this.linkId;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.linkId.hashCode() * 31) + this.lloc.hashCode()) * 31;
        boolean z16 = this.success;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.desc.hashCode();
    }

    public String toString() {
        return "QZAlbumxEditMediaEvent(linkId=" + this.linkId + ", lloc=" + this.lloc + ", success=" + this.success + ", desc=" + this.desc + ")";
    }

    public static /* synthetic */ QZAlbumxEditMediaEvent copy$default(QZAlbumxEditMediaEvent qZAlbumxEditMediaEvent, String str, String str2, boolean z16, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qZAlbumxEditMediaEvent.linkId;
        }
        if ((i3 & 2) != 0) {
            str2 = qZAlbumxEditMediaEvent.lloc;
        }
        if ((i3 & 4) != 0) {
            z16 = qZAlbumxEditMediaEvent.success;
        }
        if ((i3 & 8) != 0) {
            str3 = qZAlbumxEditMediaEvent.desc;
        }
        return qZAlbumxEditMediaEvent.copy(str, str2, z16, str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZAlbumxEditMediaEvent)) {
            return false;
        }
        QZAlbumxEditMediaEvent qZAlbumxEditMediaEvent = (QZAlbumxEditMediaEvent) other;
        return Intrinsics.areEqual(this.linkId, qZAlbumxEditMediaEvent.linkId) && Intrinsics.areEqual(this.lloc, qZAlbumxEditMediaEvent.lloc) && this.success == qZAlbumxEditMediaEvent.success && Intrinsics.areEqual(this.desc, qZAlbumxEditMediaEvent.desc);
    }
}
