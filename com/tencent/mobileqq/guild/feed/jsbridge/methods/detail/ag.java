package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ag extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "updateFeedTop";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        if (l() == null) {
            return false;
        }
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
        guildFeedDetailTopUpdateEvent.setFeedId(g("feedId"));
        guildFeedDetailTopUpdateEvent.setIsFeedSetTop(c("isTop", false));
        guildFeedDetailTopUpdateEvent.setGuildId(g("guild_id"));
        guildFeedDetailTopUpdateEvent.setChannelId(g("channel_id"));
        SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailTopUpdateEvent, true);
        return true;
    }
}
