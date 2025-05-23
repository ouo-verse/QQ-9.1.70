package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;

/* loaded from: classes13.dex */
public class GuildMediaProgressStateEvent extends SimpleBaseEvent {
    private GuildMediaProgressState mMediaProgressState;

    public GuildMediaProgressStateEvent(GuildMediaProgressState guildMediaProgressState) {
        this.mMediaProgressState = guildMediaProgressState;
        if (guildMediaProgressState == null) {
            this.mMediaProgressState = new GuildMediaProgressState();
        }
    }

    public GuildMediaProgressState getMediaProgressState() {
        return this.mMediaProgressState;
    }

    public String toString() {
        return "GuildMediaProgressStateEvent{mMediaProgressState=" + this.mMediaProgressState + '}';
    }
}
