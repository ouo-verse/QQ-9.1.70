package com.tencent.mobileqq.guild.setting.group;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/GroupType;", "", "groupName", "", "isDefaultCollapse", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getGroupName", "()Ljava/lang/String;", "()Z", "CreatedGroup", "ManagedGroup", "JoinedGroup", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public enum GroupType {
    CreatedGroup("\u6211\u521b\u5efa\u7684", false),
    ManagedGroup("\u6211\u7ba1\u7406\u7684", true),
    JoinedGroup("\u6211\u52a0\u5165\u7684", true);


    @NotNull
    private final String groupName;
    private final boolean isDefaultCollapse;

    GroupType(String str, boolean z16) {
        this.groupName = str;
        this.isDefaultCollapse = z16;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    /* renamed from: isDefaultCollapse, reason: from getter */
    public final boolean getIsDefaultCollapse() {
        return this.isDefaultCollapse;
    }
}
