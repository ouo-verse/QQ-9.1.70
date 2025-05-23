package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumMainFragmentRightEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "hasUpLoadRight", "", "from", "", "(ZI)V", "getFrom", "()I", "getHasUpLoadRight", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class GroupAlbumMainFragmentRightEvent extends SimpleBaseEvent {
    private final int from;
    private final boolean hasUpLoadRight;

    public GroupAlbumMainFragmentRightEvent(boolean z16, int i3) {
        this.hasUpLoadRight = z16;
        this.from = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasUpLoadRight() {
        return this.hasUpLoadRight;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    public final GroupAlbumMainFragmentRightEvent copy(boolean hasUpLoadRight, int from) {
        return new GroupAlbumMainFragmentRightEvent(hasUpLoadRight, from);
    }

    public final int getFrom() {
        return this.from;
    }

    public final boolean getHasUpLoadRight() {
        return this.hasUpLoadRight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.hasUpLoadRight;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.from;
    }

    public String toString() {
        return "GroupAlbumMainFragmentRightEvent(hasUpLoadRight=" + this.hasUpLoadRight + ", from=" + this.from + ")";
    }

    public static /* synthetic */ GroupAlbumMainFragmentRightEvent copy$default(GroupAlbumMainFragmentRightEvent groupAlbumMainFragmentRightEvent, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = groupAlbumMainFragmentRightEvent.hasUpLoadRight;
        }
        if ((i16 & 2) != 0) {
            i3 = groupAlbumMainFragmentRightEvent.from;
        }
        return groupAlbumMainFragmentRightEvent.copy(z16, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumMainFragmentRightEvent)) {
            return false;
        }
        GroupAlbumMainFragmentRightEvent groupAlbumMainFragmentRightEvent = (GroupAlbumMainFragmentRightEvent) other;
        return this.hasUpLoadRight == groupAlbumMainFragmentRightEvent.hasUpLoadRight && this.from == groupAlbumMainFragmentRightEvent.from;
    }
}
