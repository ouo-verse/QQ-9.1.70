package com.tencent.guildmedia.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guildmedia/data/GuildMediaAIOLottieEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "msgItem", "", "updateResult", "", "(Ljava/lang/Object;Z)V", "getMsgItem", "()Ljava/lang/Object;", "getUpdateResult", "()Z", "aio-guild-media-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildMediaAIOLottieEvent extends SimpleBaseEvent {

    @NotNull
    private final Object msgItem;
    private final boolean updateResult;

    public GuildMediaAIOLottieEvent(@NotNull Object msgItem, boolean z16) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.msgItem = msgItem;
        this.updateResult = z16;
    }

    @NotNull
    public final Object getMsgItem() {
        return this.msgItem;
    }

    public final boolean getUpdateResult() {
        return this.updateResult;
    }
}
