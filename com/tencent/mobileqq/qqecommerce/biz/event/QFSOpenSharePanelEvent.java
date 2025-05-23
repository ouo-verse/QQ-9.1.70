package com.tencent.mobileqq.qqecommerce.biz.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/event/QFSOpenSharePanelEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "pbFeed", "Lcom/tencent/mobileqq/pb/MessageMicro;", "(Lcom/tencent/mobileqq/pb/MessageMicro;)V", "getPbFeed", "()Lcom/tencent/mobileqq/pb/MessageMicro;", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSOpenSharePanelEvent extends SimpleBaseEvent {

    @NotNull
    private final MessageMicro<?> pbFeed;

    public QFSOpenSharePanelEvent(@NotNull MessageMicro<?> pbFeed) {
        Intrinsics.checkNotNullParameter(pbFeed, "pbFeed");
        this.pbFeed = pbFeed;
    }

    @NotNull
    public final MessageMicro<?> getPbFeed() {
        return this.pbFeed;
    }
}
