package com.qzone.reborn.groupalbum.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumCreateAlbumInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "groupId", "", "(Ljava/lang/String;)V", "pageId", "getPageId", "()Ljava/lang/String;", "setPageId", "spaceType", "", "getSpaceType", "()I", "setSpaceType", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumCreateAlbumInitBean extends GroupAlbumInitBean {
    private String pageId;
    private int spaceType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumCreateAlbumInitBean(String groupId) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.pageId = "close_friend_space_id";
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final void setPageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageId = str;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }
}
