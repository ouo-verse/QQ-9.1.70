package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumFeedTabRefreshEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "component1", "fromSource", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getFromSource", "()I", "<init>", "(I)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class GroupAlbumFeedTabRefreshEvent extends SimpleBaseEvent {
    public static final int FROM_AIO = 1;
    public static final int FROM_DYNAMIC_TAB = 2;
    private final int fromSource;

    public GroupAlbumFeedTabRefreshEvent(int i3) {
        this.fromSource = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getFromSource() {
        return this.fromSource;
    }

    public final GroupAlbumFeedTabRefreshEvent copy(int fromSource) {
        return new GroupAlbumFeedTabRefreshEvent(fromSource);
    }

    public final int getFromSource() {
        return this.fromSource;
    }

    public int hashCode() {
        return this.fromSource;
    }

    public String toString() {
        return "GroupAlbumFeedTabRefreshEvent(fromSource=" + this.fromSource + ")";
    }

    public static /* synthetic */ GroupAlbumFeedTabRefreshEvent copy$default(GroupAlbumFeedTabRefreshEvent groupAlbumFeedTabRefreshEvent, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = groupAlbumFeedTabRefreshEvent.fromSource;
        }
        return groupAlbumFeedTabRefreshEvent.copy(i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GroupAlbumFeedTabRefreshEvent) && this.fromSource == ((GroupAlbumFeedTabRefreshEvent) other).fromSource;
    }
}
