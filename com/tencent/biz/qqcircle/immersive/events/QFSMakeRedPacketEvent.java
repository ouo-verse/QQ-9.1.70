package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/events/QFSMakeRedPacketEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "redPacketInfo", "Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "(Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;)V", "getRedPacketInfo", "()Lfeedcloud/FeedCloudDatacard$RedPocketCoverInfo;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketEvent extends SimpleBaseEvent {

    @Nullable
    private final FeedCloudDatacard$RedPocketCoverInfo redPacketInfo;

    public QFSMakeRedPacketEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final FeedCloudDatacard$RedPocketCoverInfo getRedPacketInfo() {
        return this.redPacketInfo;
    }

    public /* synthetic */ QFSMakeRedPacketEvent(FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : feedCloudDatacard$RedPocketCoverInfo);
    }

    public QFSMakeRedPacketEvent(@Nullable FeedCloudDatacard$RedPocketCoverInfo feedCloudDatacard$RedPocketCoverInfo) {
        this.redPacketInfo = feedCloudDatacard$RedPocketCoverInfo;
    }
}
