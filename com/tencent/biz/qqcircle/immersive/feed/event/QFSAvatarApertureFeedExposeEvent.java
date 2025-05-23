package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/event/QFSAvatarApertureFeedExposeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", "feed", "Lfeedcloud/FeedCloudMeta$StFeed;", "(Ljava/lang/String;Lfeedcloud/FeedCloudMeta$StFeed;)V", "getFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "getUin", "()Ljava/lang/String;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSAvatarApertureFeedExposeEvent extends SimpleBaseEvent {

    @Nullable
    private final FeedCloudMeta$StFeed feed;

    @NotNull
    private final String uin;

    public QFSAvatarApertureFeedExposeEvent(@NotNull String uin, @Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.feed = feedCloudMeta$StFeed;
    }

    @Nullable
    public final FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }
}
