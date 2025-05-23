package com.qzone.reborn.groupalbum.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "groupId", "", "(Ljava/lang/String;)V", "from", "", "getFrom", "()I", "setFrom", "(I)V", "startTimeMs", "", "getStartTimeMs", "()J", "setStartTimeMs", "(J)V", "tabId", "getTabId", "setTabId", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumMainPageInitBean extends GroupAlbumInitBean {
    private int from;
    private long startTimeMs;
    private int tabId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumMainPageInitBean(String groupId) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
    }

    public final int getFrom() {
        return this.from;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final void setFrom(int i3) {
        this.from = i3;
    }

    public final void setStartTimeMs(long j3) {
        this.startTimeMs = j3;
    }

    public final void setTabId(int i3) {
        this.tabId = i3;
    }
}
