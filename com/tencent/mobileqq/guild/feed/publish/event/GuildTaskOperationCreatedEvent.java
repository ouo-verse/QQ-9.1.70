package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildTaskOperationCreatedEvent extends SimpleBaseEvent {
    private GuildSingleMainTask task;

    public GuildTaskOperationCreatedEvent(GuildSingleMainTask guildSingleMainTask) {
        this.task = guildSingleMainTask;
    }

    public GuildSingleMainTask getTask() {
        return this.task;
    }

    public void setTask(GuildSingleMainTask guildSingleMainTask) {
        this.task = guildSingleMainTask;
    }
}
