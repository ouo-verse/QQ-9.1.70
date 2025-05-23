package com.tencent.timi.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/timi/game/app/event/AudienceInputEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "inputContent", "", "(JLjava/lang/String;)V", "getInputContent", "()Ljava/lang/String;", "getRoomId", "()J", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class AudienceInputEvent extends SimpleBaseEvent {

    @NotNull
    private final String inputContent;
    private final long roomId;

    public AudienceInputEvent(long j3, @NotNull String inputContent) {
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        this.roomId = j3;
        this.inputContent = inputContent;
    }

    @NotNull
    public final String getInputContent() {
        return this.inputContent;
    }

    public final long getRoomId() {
        return this.roomId;
    }
}
