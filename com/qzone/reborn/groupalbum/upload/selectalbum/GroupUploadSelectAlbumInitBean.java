package com.qzone.reborn.groupalbum.upload.selectalbum;

import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/GroupUploadSelectAlbumInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "groupId", "", "albumId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupUploadSelectAlbumInitBean extends GroupAlbumInitBean {
    private final String albumId;

    public /* synthetic */ GroupUploadSelectAlbumInitBean(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupUploadSelectAlbumInitBean(String groupId, String str) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.albumId = str;
    }
}
