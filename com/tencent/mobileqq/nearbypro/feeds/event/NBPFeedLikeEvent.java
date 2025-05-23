package com.tencent.mobileqq.nearbypro.feeds.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op4.d;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/event/NBPFeedLikeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "Lop4/d;", "likeInfo", "Lop4/d;", "getLikeInfo", "()Lop4/d;", "<init>", "(Ljava/lang/String;Lop4/d;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPFeedLikeEvent extends SimpleBaseEvent {

    @NotNull
    private final String feedId;

    @NotNull
    private final d likeInfo;

    public NBPFeedLikeEvent(@NotNull String feedId, @NotNull d likeInfo) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
        this.feedId = feedId;
        this.likeInfo = likeInfo;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final d getLikeInfo() {
        return this.likeInfo;
    }
}
