package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;

/* loaded from: classes13.dex */
public class GuildTaskProgressStateEvent extends SimpleBaseEvent {
    private GuildTaskProgressState mTaskProgressState;

    public GuildTaskProgressStateEvent(GuildTaskProgressState guildTaskProgressState) {
        this.mTaskProgressState = guildTaskProgressState;
    }

    public GuildTaskProgressState getTaskProgressState() {
        return this.mTaskProgressState;
    }

    public boolean isBeyondGuild() {
        if (this.mTaskProgressState.mScope != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "GuildTaskProgressStateEvent{mTaskProgressState=" + this.mTaskProgressState + '}';
    }
}
