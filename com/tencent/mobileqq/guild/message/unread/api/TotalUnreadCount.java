package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "a", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "b", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "tab", "mine", "<init>", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.message.unread.api.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class TotalUnreadCount {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final UnreadInfo.a tab;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final UnreadInfo.a mine;

    public TotalUnreadCount(@NotNull UnreadInfo.a tab, @NotNull UnreadInfo.a mine) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(mine, "mine");
        this.tab = tab;
        this.mine = mine;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final UnreadInfo.a getMine() {
        return this.mine;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final UnreadInfo.a getTab() {
        return this.tab;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TotalUnreadCount)) {
            return false;
        }
        TotalUnreadCount totalUnreadCount = (TotalUnreadCount) other;
        if (Intrinsics.areEqual(this.tab, totalUnreadCount.tab) && Intrinsics.areEqual(this.mine, totalUnreadCount.mine)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.tab.hashCode() * 31) + this.mine.hashCode();
    }

    @NotNull
    public String toString() {
        return "TotalUnreadCount(tab=" + this.tab + ", mine=" + this.mine + ')';
    }
}
