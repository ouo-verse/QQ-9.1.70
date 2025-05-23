package com.tencent.mobileqq.guild.feed.feedsquare.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData;", "", "", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData$Operate;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData$Operate;", "getOperateData", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData$Operate;", "operateData", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData$Operate;)V", "Operate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedOperateData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Operate operateData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData$Operate;", "", "(Ljava/lang/String;I)V", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "ADD", "REMOVE", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum Operate {
        INIT,
        ADD,
        REMOVE
    }

    public GuildFeedOperateData(@NotNull Operate operateData) {
        Intrinsics.checkNotNullParameter(operateData, "operateData");
        this.operateData = operateData;
    }

    public int a() {
        return 20;
    }
}
