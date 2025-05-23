package com.tencent.timi.game.liveroom.impl.room.playtogether.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/event/DefaultRoleChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isDismiss", "", "defaultRole", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "(ZLtrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;)V", "getDefaultRole", "()Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleInfo;", "()Z", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class DefaultRoleChangedEvent extends SimpleBaseEvent {

    @Nullable
    private final YesGameInfoOuterClass$YesGameRoleInfo defaultRole;
    private final boolean isDismiss;

    public DefaultRoleChangedEvent(boolean z16, @Nullable YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo) {
        this.isDismiss = z16;
        this.defaultRole = yesGameInfoOuterClass$YesGameRoleInfo;
    }

    @Nullable
    public final YesGameInfoOuterClass$YesGameRoleInfo getDefaultRole() {
        return this.defaultRole;
    }

    /* renamed from: isDismiss, reason: from getter */
    public final boolean getIsDismiss() {
        return this.isDismiss;
    }
}
