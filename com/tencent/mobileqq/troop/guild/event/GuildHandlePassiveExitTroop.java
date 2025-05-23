package com.tencent.mobileqq.troop.guild.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/guild/event/GuildHandlePassiveExitTroop;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "troopUin", "", "(Ljava/lang/String;)V", "getTroopUin", "()Ljava/lang/String;", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class GuildHandlePassiveExitTroop extends SimpleBaseEvent {
    private final String troopUin;

    public GuildHandlePassiveExitTroop(String str) {
        this.troopUin = str;
    }

    public final String getTroopUin() {
        return this.troopUin;
    }
}
