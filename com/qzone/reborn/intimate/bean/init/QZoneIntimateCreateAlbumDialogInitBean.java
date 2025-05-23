package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateCreateAlbumDialogInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "pageId", "", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "spaceId", "getSpaceId", "setSpaceId", "spaceType", "", "getSpaceType", "()I", "setSpaceType", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateCreateAlbumDialogInitBean extends QZoneIntimateInitBean {
    private int spaceType;
    private String spaceId = "";
    private String pageId = "close_friend_space_id";

    public final String getPageId() {
        return this.pageId;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final void setPageId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageId = str;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }
}
