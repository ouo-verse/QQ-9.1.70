package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudRead$GetDecorationRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSLayerPageDecorationPopupEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "decoration", "Lfeedcloud/FeedCloudRead$GetDecorationRsp;", "(Lfeedcloud/FeedCloudRead$GetDecorationRsp;)V", "getDecoration", "()Lfeedcloud/FeedCloudRead$GetDecorationRsp;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSLayerPageDecorationPopupEvent extends SimpleBaseEvent {

    @NotNull
    private final FeedCloudRead$GetDecorationRsp decoration;

    public QFSLayerPageDecorationPopupEvent(@NotNull FeedCloudRead$GetDecorationRsp decoration) {
        Intrinsics.checkNotNullParameter(decoration, "decoration");
        this.decoration = decoration;
    }

    @NotNull
    public final FeedCloudRead$GetDecorationRsp getDecoration() {
        return this.decoration;
    }
}
