package com.tencent.timi.game.liveroom.impl.room.pendant.webview;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/RightBottomPendantPushEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "needShow", "", "(Z)V", "getNeedShow", "()Z", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class RightBottomPendantPushEvent extends SimpleBaseEvent {
    private final boolean needShow;

    public RightBottomPendantPushEvent(boolean z16) {
        this.needShow = z16;
    }

    public final boolean getNeedShow() {
        return this.needShow;
    }
}
