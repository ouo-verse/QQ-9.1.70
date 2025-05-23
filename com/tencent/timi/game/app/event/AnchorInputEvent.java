package com.tencent.timi.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/app/event/AnchorInputEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "inputContent", "", "fromPlayTogether", "", "(JLjava/lang/String;Z)V", "getFromPlayTogether", "()Z", "getInputContent", "()Ljava/lang/String;", "getRoomId", "()J", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class AnchorInputEvent extends SimpleBaseEvent {
    private final boolean fromPlayTogether;

    @NotNull
    private final String inputContent;
    private final long roomId;

    public /* synthetic */ AnchorInputEvent(long j3, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, (i3 & 4) != 0 ? false : z16);
    }

    public final boolean getFromPlayTogether() {
        return this.fromPlayTogether;
    }

    @NotNull
    public final String getInputContent() {
        return this.inputContent;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public AnchorInputEvent(long j3, @NotNull String inputContent, boolean z16) {
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        this.roomId = j3;
        this.inputContent = inputContent;
        this.fromPlayTogether = z16;
    }
}
