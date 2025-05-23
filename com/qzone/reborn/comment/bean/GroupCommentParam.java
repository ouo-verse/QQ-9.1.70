package com.qzone.reborn.comment.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/comment/bean/GroupCommentParam;", "Ljava/io/Serializable;", "groupId", "", "groupName", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupCommentParam implements Serializable {
    private String groupId;
    private String groupName;

    public GroupCommentParam() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setGroupName(String str) {
        this.groupName = str;
    }

    public GroupCommentParam(String str, String str2) {
        this.groupId = str;
        this.groupName = str2;
    }

    public /* synthetic */ GroupCommentParam(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
