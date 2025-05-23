package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tvideo.Video;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/event/QFSTVideoFeedsItemSelectedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "stFeed", "Lfeedcloud/FeedCloudMeta$StFeed;", "tVideoFeed", "Ltvideo/Video;", "position", "", "(Lfeedcloud/FeedCloudMeta$StFeed;Ltvideo/Video;I)V", "getPosition", "()I", "getStFeed", "()Lfeedcloud/FeedCloudMeta$StFeed;", "getTVideoFeed", "()Ltvideo/Video;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class QFSTVideoFeedsItemSelectedEvent extends SimpleBaseEvent {
    private final int position;

    @NotNull
    private final FeedCloudMeta$StFeed stFeed;

    @NotNull
    private final Video tVideoFeed;

    public QFSTVideoFeedsItemSelectedEvent(@NotNull FeedCloudMeta$StFeed stFeed, @NotNull Video tVideoFeed, int i3) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(tVideoFeed, "tVideoFeed");
        this.stFeed = stFeed;
        this.tVideoFeed = tVideoFeed;
        this.position = i3;
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final FeedCloudMeta$StFeed getStFeed() {
        return this.stFeed;
    }

    @NotNull
    public final Video getTVideoFeed() {
        return this.tVideoFeed;
    }
}
