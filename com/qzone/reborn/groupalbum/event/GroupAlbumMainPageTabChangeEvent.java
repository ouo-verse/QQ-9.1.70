package com.qzone.reborn.groupalbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/groupalbum/event/GroupAlbumMainPageTabChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "tabId", "", "(I)V", "getTabId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class GroupAlbumMainPageTabChangeEvent extends SimpleBaseEvent {
    private final int tabId;

    public GroupAlbumMainPageTabChangeEvent(int i3) {
        this.tabId = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getTabId() {
        return this.tabId;
    }

    public final GroupAlbumMainPageTabChangeEvent copy(int tabId) {
        return new GroupAlbumMainPageTabChangeEvent(tabId);
    }

    public final int getTabId() {
        return this.tabId;
    }

    public int hashCode() {
        return this.tabId;
    }

    public String toString() {
        return "GroupAlbumMainPageTabChangeEvent(tabId=" + this.tabId + ")";
    }

    public static /* synthetic */ GroupAlbumMainPageTabChangeEvent copy$default(GroupAlbumMainPageTabChangeEvent groupAlbumMainPageTabChangeEvent, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = groupAlbumMainPageTabChangeEvent.tabId;
        }
        return groupAlbumMainPageTabChangeEvent.copy(i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GroupAlbumMainPageTabChangeEvent) && this.tabId == ((GroupAlbumMainPageTabChangeEvent) other).tabId;
    }
}
