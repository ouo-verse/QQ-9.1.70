package com.tencent.icgame.game.liveroom.impl.room.message.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/message/event/SysMsgEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "roomId", "", "sysNotice", "", "txtColor", "", "(JLjava/lang/String;I)V", "getRoomId", "()J", "getSysNotice", "()Ljava/lang/String;", "getTxtColor", "()I", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class SysMsgEvent extends SimpleBaseEvent {
    private final long roomId;

    @NotNull
    private final String sysNotice;
    private final int txtColor;

    public SysMsgEvent(long j3, @NotNull String sysNotice, int i3) {
        Intrinsics.checkNotNullParameter(sysNotice, "sysNotice");
        this.roomId = j3;
        this.sysNotice = sysNotice;
        this.txtColor = i3;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getSysNotice() {
        return this.sysNotice;
    }

    public final int getTxtColor() {
        return this.txtColor;
    }

    public /* synthetic */ SysMsgEvent(long j3, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, (i16 & 4) != 0 ? 0 : i3);
    }
}
