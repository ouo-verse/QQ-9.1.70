package com.qzone.reborn.groupalbum.bean.init;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "Ljava/io/Serializable;", "groupId", "", "(Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "serialVersionUID", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public abstract class GroupAlbumInitBean implements Serializable {
    private final String groupId;
    private final long serialVersionUID;

    public GroupAlbumInitBean(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        this.serialVersionUID = 1521697345242559987L;
    }

    public String getGroupId() {
        return this.groupId;
    }
}
